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
import by.epam.hostel.dao.factory.DaoFactory;
import by.epam.hostel.dao.factory.DaoFactory.DAOType;
import by.epam.hostel.entity.Category;
import by.epam.hostel.entity.Order;
import by.epam.hostel.entity.Room;

/**
 * The inner class for implementation singleton. Direct implementation of the
 * interface MySqlUserDao.
 * 
 * @author Alex Nastin
 */
public final class MySqlUserDao implements IMySqlUserDao {

	private static ConnectionPool connectionPool = ConnectionPool.getInstance();

	private final String GET_ROOMS_NOT_DELETED = "SELECT * FROM rooms WHERE isDeleted=0";
	private final String GET_USER_ORDERS = "SELECT idOrder, idRoom, price, category, capacity, arrival, departure FROM orders, rooms, users WHERE idUser = users_idUser and rooms.idRoom = Rooms_idRoom and idUser=";

	private final String GET_BOOKEDROOM = "SELECT rooms_idRoom FROM bookeddate WHERE  notbooking>? and booking<?  group by rooms_idRoom";

	private final String GET_SPECIFIC_ROOMS_CATEGORY_AND_PRICE = "SELECT * FROM rooms WHERE category=? and price<=? and capacity=?";
	private final String GET_SPECIFIC_ROOMS_CATEGORY = "SELECT * FROM rooms WHERE category=? and capacity=?";
	private final String GET_SPECIFIC_ROOMS_PRICE = "SELECT * FROM rooms WHERE price<=? and capacity=?";
	private final String GET_SPECIFIC_ROOMS_CAPACITY = "SELECT * FROM rooms WHERE capacity=?";

	private final String INSERT_ORDER = "INSERT INTO orders (arrival, departure, users_idUser, rooms_idRoom, paid) VALUES (?,?,?,?,0)";
	private final String INSERT_BOOKEDDATE = "INSERT INTO bookeddate (rooms_idRoom, booking, notbooking) VALUES (?,?,?)";

	private MySqlUserDao() {
	}

	/**
	 * The inner class for implementation singleton. It holds MySqlUserDao
	 * instance.
	 */
	private static class Holder {
		private final static MySqlUserDao INSTANCE = new MySqlUserDao();
	}

	/**
	 * The method gives MySqlUserDao singleton instance.
	 */
	public static MySqlUserDao getInstance() {
		return Holder.INSTANCE;
	}

	@Override
	public List<Room> getRoomsNotDeleted() throws DaoException {
		List<Room> rooms = new ArrayList<Room>();
		Connection connection = null;
		Statement statement = null;
		try {
			connection = connectionPool.takeConnection();
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(GET_ROOMS_NOT_DELETED);
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
	public List<Room> getRoomsCategoryAndCapacity(String category, int capacity)
			throws DaoException {

		List<Room> rooms = new ArrayList<Room>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = connectionPool.takeConnection();
			preparedStatement = connection
					.prepareStatement(GET_SPECIFIC_ROOMS_CATEGORY);
			preparedStatement.setString(1, category);
			preparedStatement.setInt(2, capacity);
			ResultSet resultSet = preparedStatement.executeQuery();
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
			connectionPool.closeConnection(connection, preparedStatement);
		}
		return rooms;
	}

	@Override
	public List<Room> getRoomsPriceAndCapacity(double price, int capacity)
			throws DaoException {
		List<Room> rooms = new ArrayList<Room>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = connectionPool.takeConnection();
			preparedStatement = connection
					.prepareStatement(GET_SPECIFIC_ROOMS_PRICE);
			preparedStatement.setDouble(1, price);
			preparedStatement.setInt(2, capacity);
			ResultSet resultSet = preparedStatement.executeQuery();
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
			connectionPool.closeConnection(connection, preparedStatement);
		}
		return rooms;
	}

	@Override
	public List<Room> getRoomsPriceAndCategoryAndCapacity(String category,
			double price, int capacity) throws DaoException {
		List<Room> rooms = new ArrayList<Room>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = connectionPool.takeConnection();
			preparedStatement = connection
					.prepareStatement(GET_SPECIFIC_ROOMS_CATEGORY_AND_PRICE);
			preparedStatement.setString(1, category);
			preparedStatement.setDouble(2, price);
			preparedStatement.setInt(3, capacity);
			ResultSet resultSet = preparedStatement.executeQuery();
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
			connectionPool.closeConnection(connection, preparedStatement);
		}
		return rooms;
	}

	@Override
	public List<Room> getRoomsCapacity(int capacity) throws DaoException {
		List<Room> rooms = new ArrayList<Room>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = connectionPool.takeConnection();
			preparedStatement = connection
					.prepareStatement(GET_SPECIFIC_ROOMS_CAPACITY);
			preparedStatement.setInt(1, capacity);
			ResultSet resultSet = preparedStatement.executeQuery();
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
			connectionPool.closeConnection(connection, preparedStatement);
		}
		return rooms;
	}

	@Override
	public List<Order> getUserOrders(int idUser) throws DaoException {
		List<Order> orders = new ArrayList<Order>();
		Order order = null;
		Room room = null;
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = connectionPool.takeConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(GET_USER_ORDERS + idUser);
			while (resultSet.next()) {
				order = new Order();
				room = new Room();
				order.setIdOrder(resultSet.getInt(1));
				room.setIdRoom(resultSet.getInt(2));
				room.setPrice(resultSet.getDouble(3));
				switch (resultSet.getString(4)) {
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
				room.setCapacity(resultSet.getInt(5));
				order.setArrival(resultSet.getDate(6));
				order.setDeparture((resultSet.getDate(7)));
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
	public int insertOrder(String arrival, String departure, int idUser,
			int idRoom) throws DaoException {

		int result = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = connectionPool.takeConnection();
			preparedStatement = connection.prepareStatement(INSERT_ORDER);
			preparedStatement.setString(1, arrival);
			preparedStatement.setString(2, departure);
			preparedStatement.setInt(3, idUser);
			preparedStatement.setInt(4, idRoom);
			result = preparedStatement.executeUpdate();
			preparedStatement.close();
			preparedStatement = connection.prepareStatement(INSERT_BOOKEDDATE);
			preparedStatement.setInt(1, idRoom);
			preparedStatement.setString(2, arrival);
			preparedStatement.setString(3, departure);
			result = preparedStatement.executeUpdate();
		} catch (ConnectionPoolException | SQLException e) {
			throw new DaoException(e);
		} finally {
			connectionPool.closeConnection(connection, preparedStatement);
		}
		return result;
	}

	@Override
	public List<Room> getFreeRooms(String arrival, String departure)
			throws DaoException {

		IMySqlAdminDao dao = DaoFactory.getDAO(DAOType.MY_SQL_DAO)
				.getMySqlAdminDao();

		List<Room> busyRooms = new ArrayList<Room>();
		List<Room> allRooms = new ArrayList<Room>();

		allRooms.addAll(getRoomsNotDeleted());
		Room room = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = connectionPool.takeConnection();
			preparedStatement = connection.prepareStatement(GET_BOOKEDROOM);
			preparedStatement.setString(1, arrival);
			preparedStatement.setString(2, departure);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				room = dao.getRoom(resultSet.getInt(1));
				busyRooms.add(room);
			}
		} catch (ConnectionPoolException | SQLException e) {
			throw new DaoException(e);
		} finally {
			connectionPool.closeConnection(connection, preparedStatement);
		}
		allRooms.removeAll(busyRooms);
		return allRooms;
	}
}
