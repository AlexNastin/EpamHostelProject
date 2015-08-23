package by.epam.hostel.junit;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.Statement;

import org.junit.Test;

import by.epam.hostel.dao.connectionpool.ConnectionPool;
import by.epam.hostel.dao.connectionpool.ConnectionPoolException;

public class TestConnectionPool {

	/**
	 * The method tests the creation and initialization of the connection pool.
	 * */
	@Test(timeout = 1000)
	public void testCreateConnectionPool() {
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		try {
			connectionPool.initPoolData();
		} catch (ConnectionPoolException e) {
			fail("Error initializing the connection pool.");
		} finally {
			connectionPool.dispose();
		}
	}

	/**
	 * The method tests whether there is a connection in the connection pool.
	 * */
	@Test(timeout = 1000)
	public void testTakeConnection() {
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		Connection connection = null;
		Statement statement = null;
		try {
			connectionPool.initPoolData();
			connection = connectionPool.takeConnection();
			try {
				statement = connection.createStatement();
				statement.close();
			} catch (Exception e) {
				fail("Problems with connection");
			}
		} catch (ConnectionPoolException e) {
			fail("Error initializing the connection pool.");
		} finally {
			connectionPool.dispose();
		}
	}
}
