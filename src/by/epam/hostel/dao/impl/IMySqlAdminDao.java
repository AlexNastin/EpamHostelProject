package by.epam.hostel.dao.impl;

import java.util.List;


import by.epam.hostel.dao.DaoException;
import by.epam.hostel.entity.BookedDate;
import by.epam.hostel.entity.Category;
import by.epam.hostel.entity.Login;
import by.epam.hostel.entity.Order;
import by.epam.hostel.entity.Room;
import by.epam.hostel.entity.User;


/**
 * This interface holds methods needed to work with database.
 * 
 * @author Alex Nastin
 */
public interface IMySqlAdminDao {

	/**
	 * This method get User from database.
	 * 
	 * @param int idUser
	 * @return User
	 * @throws DAOException
	 * 
	 */
	public User getUser(int idUser) throws DaoException;

	/**
	 * This method get all Users from database.
	 * 
	 * @return List<User>
	 * @throws DAOException
	 * 
	 */
	public List<User> getUsers() throws DaoException;

	/**
	 * This method insert User to database.
	 * 
	 * @param String name
	 * @param String surname
	 * @param String numpass
	 * @param String login
	 * @param String password
	 * @return int insert index.
	 * @throws DAOException
	 * 
	 */
	public void insertUser(String name, String surname, String numpass,
			String login, String password) throws DaoException;
	
	/**
	 * This method changes the state of the blacklist user.
	 * 
	 * @param int idUser
	 * @param int blacklist
	 * @return int the number of rows affected.
	 * @throws DAOException
	 */
	public int setBlacklistUser(int idUser, int blacklist) throws DaoException;
	
	/**
	 * This method changes the state of the status user.
	 * 
	 * @param int idUser
	 * @param int status
	 * @return int the number of rows affected.
	 * @throws DAOException
	 */
	public int setStatus(int idUser, int status) throws DaoException;

	/**
	 * This method changes the state of the paid user.
	 * 
	 * @param int idOrder
	 * @param int paid
	 * @return int the number of rows affected.
	 * @throws DAOException
	 */
	public int setPaid(int idOrder, int paid) throws DaoException;
	
	/**
	 * This method get Login from database.
	 * 
	 * @param String login
	 * @return Login
	 * @throws DAOException
	 * 
	 */
	public Login getLogin(String login) throws DaoException;

	/**
	 * This method get Room from database.
	 * 
	 * @param int idRoom
	 * @return Room
	 * @throws DAOException
	 * 
	 */
	public Room getRoom(int idRoom) throws DaoException;

	/**
	 * This method get all Rooms from database.
	 * 
	 * @return List<Room>
	 * @throws DAOException
	 * 
	 */
	public List<Room> getRooms() throws DaoException;
	
	/**
	 * This method get all BookedDates from database.
	 * 
	 * @return List<BookedDate>
	 * @throws DAOException
	 * 
	 */
	public List<BookedDate> getBookedDates() throws DaoException;
	
	/**
	 * This method get all BookedDates from database.
	 * 
	 * @param int idRoom
	 * @return List<BookedDate>
	 * @throws DAOException 
	 */
	public List<BookedDate> getBookedDatesRoom(int idRoom) throws DaoException;

	/**
	 * This method get all Orders from database.
	 * 
	 * @return List<Order>
	 * @throws DAOException
	 * 
	 */
	public List<Order> getOrders() throws DaoException;

	/**
	 * This method update Room to database.
	 * 
	 * @param int idRoom
	 * @param double price
	 * @param Category category
	 * @param int capacity
	 * @param int isDeleted
	 * @return int the number of rows affected.
	 * @throws DAOException
	 * 
	 */
	public int updateRoom(int idRoom, double price, Category category,
			int capacity, int isDeleted) throws DaoException;

	/**
	 * This method insert Room to database.
	 * 
	 * @param int idRoom
	 * @param double price
	 * @param Category category
	 * @param int capacity
	 * @return int the number of rows affected.
	 * @throws DAOException
	 */
	public int insertRoom(int idRoom, double price, String category,
			int capacity) throws DaoException;

}
