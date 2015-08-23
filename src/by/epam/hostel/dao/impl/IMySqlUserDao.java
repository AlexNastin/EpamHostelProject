package by.epam.hostel.dao.impl;

import java.util.List;

import by.epam.hostel.dao.DaoException;
import by.epam.hostel.entity.Order;
import by.epam.hostel.entity.Room;

/**
 * This interface holds methods needed to work with database.
 * 
 * @author Alex Nastin
 */
public interface IMySqlUserDao {
	/**
	 * This method get all not remote room from database.
	 * 
	 * @return List<Room>
	 * @throws DAOException
	 * 
	 */
	public List<Room> getRoomsNotDeleted() throws DaoException;

	/**
	 * This method get all user orders from database.
	 * 
	 * @param int idUser
	 * @return List<Order>
	 * @throws DAOException
	 * 
	 */
	public List<Order> getUserOrders(int idUser) throws DaoException;

	/**
	 * This method insert Order to database.
	 * 
	 * @param String
	 *            arrival
	 * @param String
	 *            departure
	 * @param int idUser
	 * @param int idRoom
	 * @return int the number of rows affected.
	 * @throws DAOException
	 */
	public int insertOrder(String arrival, String departure, int idUser,
			int idRoom) throws DaoException;

	/**
	 * This method get all rooms relevant parameters from database.
	 * 
	 * @param String category
	 * @param int capacity
	 * @return List<Room>
	 * @throws DAOException
	 */
	public List<Room> getRoomsCategoryAndCapacity(String category, int capacity)
			throws DaoException;

	/**
	 * This method get all rooms relevant parameters from database.
	 * 
	 * @param double price
	 * @param int capacity
	 * @return List<Room>
	 * @throws DAOException
	 */
	public List<Room> getRoomsPriceAndCapacity(double price, int capacity)
			throws DaoException;

	/**
	 * This method get all rooms relevant parameters from database.
	 * 
	 * @param int capacity
	 * @return List<Room>
	 * @throws DAOException
	 */
	public List<Room> getRoomsCapacity(int capacity) throws DaoException;

	/**
	 * This method get all rooms relevant parameters from database.
	 * 
	 * @param String category
	 * @param double price
	 * @param int capacity
	 * @return List<Room>
	 * @throws DAOException
	 */
	public List<Room> getRoomsPriceAndCategoryAndCapacity(String category,
			double price, int capacity) throws DaoException;

	/**
	 * This method get all free rooms from database.
	 * 
	 * @param String arrival
	 * @param String departure
	 * @return List<Room>
	 * @throws DAOException
	 */
	public List<Room> getFreeRooms(String arrival, String departure)
			throws DaoException;
}
