package by.epam.hostel.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import by.epam.hostel.dao.connectionpool.ConnectionPool;
import by.epam.hostel.dao.connectionpool.ConnectionPoolException;

/**
 * HotelContextListener implementation class ServletContextListener
 * 
 * The class receives an object of type connection pool and initializes it.
 * 
 * @author Alex Nastin
 */
@WebListener
public class HotelContextListener implements ServletContextListener {

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		try {
			connectionPool.initPoolData();
		} catch (ConnectionPoolException e) {
			throw new RuntimeException();
		}
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		connectionPool.dispose();
	}

}
