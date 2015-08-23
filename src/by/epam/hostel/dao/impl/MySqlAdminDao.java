package by.epam.hostel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.epam.hostel.dao.DaoException;
import by.epam.hostel.dao.connectionpool.ConnectionPool;
import by.epam.hostel.dao.connectionpool.ConnectionPoolException;
import by.epam.hostel.entity.BookedDate;
import by.epam.hostel.entity.Category;
import by.epam.hostel.entity.Login;
import by.epam.hostel.entity.Order;
import by.epam.hostel.entity.Room;
import by.epam.hostel.entity.User;

/**
 * The inner class for implementation singleton. Direct implementation of the
 * interface IMySqlAdminDao.
 * 
 * @author Alex Nastin
 */
public final class MySqlAdminDao implements IMySqlAdminDao {

	private static ConnectionPool connectionPool = ConnectionPool.getInstance();

	private final String GET_USER = "SELECT name, surname, numpass, login, password, status, blacklist FROM login, users WHERE idUser = users_idUser and idUser = ";
	private final String GET_ROOM = "SELECT * FROM rooms WHERE idRoom=";
	private final String GET_LOGIN_USER = "SELECT * FROM login WHERE login=\"";

	private final String GET_USERS = "SELECT idUser, name, surname, numpass, login, password, status, blacklist FROM users, login WHERE idUser = users_idUser";
	private final String GET_ALL_ROOMS = "SELECT * FROM rooms";
	private final String GET_ORDERS = "SELECT idOrder, name, surname, numpass, idRoom, price, category, capacity, arrival, departure, paid FROM orders, rooms, users WHERE idUser = users_idUser and idRoom = Rooms_idRoom";
	private final String GET_BOOKEDDATES = "SELECT * FROM bookeddate";
	private final String GET_BOOKEDDATESROOM = "SELECT * FROM bookeddate WHERE rooms_idRoom=";

	private final String GET_LAST_ID = "SELECT LAST_INSERT_ID();";

	private final String INSERT_USER_LOGIN = "INSERT INTO login (users_idUser, blacklist,login,password,status) VALUES (?,0,?,?,0)";
	private final String INSERT_USER = "INSERT INTO users (name,surname,numpass) VALUES (?,?,?)";
	private final String INSERT_ROOM = " INSERT INTO rooms (idRoom,price,category,capacity,isDeleted) VALUES (?,?,?,?,0)";

	private final String UPDATE_STATUS = "UPDATE login SET status=? WHERE users_idUser = ?";
	private final String UPDATE_BLACKLIST = "UPDATE login SET blacklist=? WHERE users_idUser = ?";
	private final String UPDATE_PAID = "UPDATE orders SET paid=? WHERE idOrder = ?";

	private final String UPDATE_ROOM = " UPDATE rooms SET price=?, category =?, capacity = ?, isDeleted=? WHERE idRoom=?";

	private MySqlAdminDao() {
	}

	/**
	 * The inner class for implementation singleton. It holds MySqlAdminDao
	 * instance.
	 */
	private static class Holder {
		private final static MySqlAdminDao INSTANCE = new MySqlAdminDao();
	}

	/**
	 * The method gives MySqlAdminDao singleton instance.
	 */
	public static MySqlAdminDao getInstance() {
		return Holder.INSTANCE;
	}

	@Override
	public User getUser(int idUser) throws DaoException {
		User user = null;
		Connection connection = null;
		Statement statement = null;
		try {
			connection = connectionPool.takeConnection();
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(GET_USER + idUser);

			if (resultSet.next()) {
				Login login = new Login(idUser, resultSet.getString(4),
						resultSet.getInt(5), resultSet.getBoolean(6),
						resultSet.getBoolean(7));
				user = new User(resultSet.getString(1), resultSet.getString(2),
						resultSet.getString(3), login);
				user.setIdUser(idUser);
			}

		} catch (SQLException | ConnectionPoolException e) {
			throw new DaoException(e);
		} finally {
			connectionPool.closeConnection(connection, statement);
		}
		return user;
	}

	@Override
	public List<User> getUsers() throws DaoException {
		List<User> users = new ArrayList<User>();
		Connection connection = null;
		Statement statement = null;
		try {
			connection = connectionPool.takeConnection();
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(GET_USERS);
			while (resultSet.next()) {
				Login login = new Login(resultSet.getInt(1),
						resultSet.getString(5), resultSet.getInt(6),
						resultSet.getBoolean(7), resultSet.getBoolean(8));
				User user = new User(resultSet.getString(2),
						resultSet.getString(3), resultSet.getString(4), login);
				user.setIdUser(login.getIdUser());
				users.add(user);
			}
		} catch (SQLException | ConnectionPoolException e) {
			throw new DaoException(e);
		} finally {
			connectionPool.closeConnection(connection, statement);
		}
		return users;
	}

	@SuppressWarnings("resource")
	@Override
	public void insertUser(String name, String surname, String numpass,
			String login, String password) throws DaoException {
		Connection connection = null;
		Statement statement = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = connectionPool.takeConnection();
			preparedStatement = connection.prepareStatement(INSERT_USER);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, surname);
			preparedStatement.setString(3, numpass);
			preparedStatement.executeUpdate();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(GET_LAST_ID);
			preparedStatement = connection.prepareStatement(INSERT_USER_LOGIN);
			if (resultSet.next()) {
				preparedStatement.setInt(1, resultSet.getInt(1));
			}
			preparedStatement.setString(2, login);
			preparedStatement.setInt(3, password.hashCode());
			preparedStatement.executeUpdate();
		} catch (ConnectionPoolException | SQLException e) {
			throw new DaoException(e);
		} finally {
			connectionPool.closeConnection(connection, statement,
					preparedStatement);
		}
	}

	@Override
	public Login getLogin(String login) throws DaoException {
		Login loginUser = null;
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = connectionPool.takeConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(GET_LOGIN_USER + login + "\"");
			if (resultSet.next()) {
				loginUser = new Login();
				loginUser.setIdUser(resultSet.getInt(1));
				loginUser.setBlacklist(resultSet.getBoolean(2));
				loginUser.setLogin(resultSet.getString(3));
				loginUser.setPassword(resultSet.getInt(4));
				loginUser.setStatus(resultSet.getBoolean(5));
			}
		} catch (ConnectionPoolException | SQLException e) {
			throw new DaoException(e);
		} finally {
			connectionPool.closeConnection(connection, statement);
		}
		return loginUser;
	}

	@Override
	public int setStatus(int idUser, int status) throws DaoException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		try {
			connection = connectionPool.takeConnection();
			preparedStatement = connection.prepareStatement(UPDATE_STATUS);
			preparedStatement.setInt(1, status);
			preparedStatement.setInt(2, idUser);
			result = preparedStatement.executeUpdate();
		} catch (ConnectionPoolException | SQLException e) {
			throw new DaoException(e);
		} finally {
			connectionPool.closeConnection(connection, preparedStatement);
		}
		return result;
	}

	@Override
	public int setBlacklistUser(int idUser, int blacklist) throws DaoException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		try {
			connection = connectionPool.takeConnection();
			preparedStatement = connection.prepareStatement(UPDATE_BLACKLIST);
			preparedStatement.setInt(1, blacklist);
			preparedStatement.setInt(2, idUser);
			result = preparedStatement.executeUpdate();
		} catch (ConnectionPoolException | SQLException e) {
			throw new DaoException(e);
		} finally {
			connectionPool.closeConnection(connection, preparedStatement);
		}
		return result;
	}

	@Override
	public Room getRoom(int idRoom) throws DaoException {
		Connection connection = null;
		Statement statement = null;
		Room room = null;
		try {
			connection = connectionPool.takeConnection();
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(GET_ROOM + idRoom);
			if (resultSet.next()) {
				room = new Room();
				room.setIdRoom(idRoom);
				room.setPrice(resultSet.getDouble(2));
				switch (resultSet.getString(3)) {
				case "ECONOM":
					room.setCategory(Category.ECONOM);
					break;
				case "FAMILY":
					room.setCategory(Category.FAMILY);
					break;
				case "LUX":
					room.setCategory(Category.LUX);
					break;
				case "SUPER_LUX":
					room.setCategory(Category.SUPER_LUX);
					break;
				default:
					throw new DaoException("There is no such category.");
				}
				room.setCapacity(resultSet.getInt(4));
				room.setDeleted(resultSet.getBoolean(5));
			}
		} catch (ConnectionPoolException | SQLException e) {
			throw new DaoException(e);
		} finally {
			connectionPool.closeConnection(connection, statement);
		}
		return room;
	}

	@Override
	public List<Room> getRooms() throws DaoException {
		List<Room> rooms = new ArrayList<Room>();
		Connection connection = null;
		Statement statement = null;
		try {
			connection = connectionPool.takeConnection();
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(GET_ALL_ROOMS);
			while (resultSet.next()) {
				Room room = new Room();
				room.setIdRoom(resultSet.getInt(1));
				room.setPrice(resultSet.getDouble(2));
				switch (resultSet.getString(3)) {
				case "ECONOM":
					room.setCategory(Category.ECONOM);
					break;
				case "FAMILY":
					room.setCategory(Category.FAMILY);
					break;
				case "LUX":
					room.setCategory(Category.LUX);
					break;
				case "SUPER_LUX":
					room.setCategory(Category.SUPER_LUX);
					break;
				default:
					throw new DaoException("There is no such category.");
				}
				room.setCapacity(resultSet.getInt(4));
				room.setDeleted(resultSet.getBoolean(5));
				rooms.add(room);
			}
		} catch (ConnectionPoolException | SQLException e) {
			throw new DaoException(e);
		} finally {
			connectionPool.closeConnection(connection, statement);
		}
		return rooms;
	}

	@Override
	public int setPaid(int idOrder, int paid) throws DaoException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		try {
			connection = connectionPool.takeConnection();
			preparedStatement = connection.prepareStatement(UPDATE_PAID);
			preparedStatement.setInt(1, paid);
			preparedStatement.setInt(2, idOrder);
			result = preparedStatement.executeUpdate();
		} catch (ConnectionPoolException | SQLException e) {
			throw new DaoException(e);
		} finally {
			connectionPool.closeConnection(connection, preparedStatement);
		}
		return result;
	}

	@Override
	public int insertRoom(int idRoom, double price, String category,
			int capacity) throws DaoException {
		int result = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = connectionPool.takeConnection();
			preparedStatement = connection.prepareStatement(INSERT_ROOM);
			preparedStatement.setInt(1, idRoom);
			preparedStatement.setDouble(2, price);
			preparedStatement.setString(3, category);
			preparedStatement.setInt(4, capacity);
			result = preparedStatement.executeUpdate();
		} catch (ConnectionPoolException | SQLException e) {
			throw new DaoException(e);
		} finally {
			connectionPool.closeConnection(connection, preparedStatement);
		}
		return result;
	}

	@Override
	public int updateRoom(int idRoom, double price, Category category,
			int capacity, int isDeleted) throws DaoException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		try {
			connection = connectionPool.takeConnection();
			preparedStatement = connection.prepareStatement(UPDATE_ROOM);
			preparedStatement.setDouble(1, price);
			switch (category) {
			case LUX:
				preparedStatement.setString(2, "LUX");
				break;
			case ECONOM:
				preparedStatement.setString(2, "ECONOM");
				break;
			case SUPER_LUX:
				preparedStatement.setString(2, "SUPER_LUX");
				break;
			case FAMILY:
				preparedStatement.setString(2, "FAMILY");
				break;
			default:
				break;
			}
			preparedStatement.setInt(3, capacity);
			preparedStatement.setInt(4, isDeleted);
			preparedStatement.setInt(5, idRoom);
			result = preparedStatement.executeUpdate();
		} catch (ConnectionPoolException | SQLException e) {
			throw new DaoException(e);
		} finally {
			connectionPool.closeConnection(connection, preparedStatement);
		}

		return result;
	}

	@Override
	public List<Order> getOrders() throws DaoException {
		List<Order> orders = new ArrayList<Order>();
		Order order = null;
		User user = null;
		Room room = null;
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = connectionPool.takeConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(GET_ORDERS);
			while (resultSet.next()) {
				order = new Order();
				user = new User();
				room = new Room();
				order.setIdOrder(resultSet.getInt(1));
				user.setName(resultSet.getString(2));
				user.setSurname(resultSet.getString(3));
				user.setNumpass(resultSet.getString(4));
				room.setIdRoom(resultSet.getInt(5));
				room.setPrice(resultSet.getDouble(6));
				switch (resultSet.getString(7)) {
				case "ECONOM":
					room.setCategory(Category.ECONOM);
					break;
				case "FAMILY":
					room.setCategory(Category.FAMILY);
					break;
				case "LUX":
					room.setCategory(Category.LUX);
					break;
				case "SUPER_LUX":
					room.setCategory(Category.SUPER_LUX);
					break;
				default:
					throw new DaoException("There is no such category.");
				}
				room.setCapacity(resultSet.getInt(8));
				order.setArrival(resultSet.getDate(9));
				order.setDeparture((resultSet.getDate(10)));
				order.setPaid(resultSet.getBoolean(11));
				order.setUser(user);
				order.setRoom(room);
				orders.add(order);
			}

		} catch (ConnectionPoolException | SQLException e) {
			throw new DaoException(e);
		} finally {
			connectionPool.closeConnection(connection, statement);
		}
		return orders;
	}

	@Override
	public List<BookedDate> getBookedDates() throws DaoException {
		List<BookedDate> bookeddates = new ArrayList<BookedDate>();
		Connection connection = null;
		Statement statement = null;
		BookedDate bookedDate = null;
		ResultSet resultSet = null;
		try {
			connection = connectionPool.takeConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(GET_BOOKEDDATES);
			while (resultSet.next()) {
				bookedDate = new BookedDate();
				bookedDate.setIdBooked(resultSet.getInt(1));
				bookedDate.setIdRoom(resultSet.getInt(2));
				bookedDate.setBooking(resultSet.getDate(3));
				bookedDate.setNotBooking(resultSet.getDate(4));
				bookeddates.add(bookedDate);
			}
		} catch (ConnectionPoolException | SQLException e) {
			throw new DaoException(e);
		} finally {
			connectionPool.closeConnection(connection, statement);
		}
		return bookeddates;
	}

	@Override
	public List<BookedDate> getBookedDatesRoom(int idRoom) throws DaoException {
		List<BookedDate> bookeddates = new ArrayList<BookedDate>();
		Connection connection = null;
		Statement statement = null;
		BookedDate bookedDate = null;
		ResultSet resultSet = null;
		try {
			connection = connectionPool.takeConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(GET_BOOKEDDATESROOM + idRoom);
			while (resultSet.next()) {
				bookedDate = new BookedDate();
				bookedDate.setIdRoom(resultSet.getInt(1));
				bookedDate.setBooking(resultSet.getDate(2));
				bookedDate.setNotBooking(resultSet.getDate(3));
				bookeddates.add(bookedDate);
			}
		} catch (ConnectionPoolException | SQLException e) {
			throw new DaoException(e);
		} finally {
			connectionPool.closeConnection(connection, statement);
		}
		return bookeddates;
	}

}
