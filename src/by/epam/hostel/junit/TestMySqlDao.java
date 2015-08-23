package by.epam.hostel.junit;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import by.epam.hostel.dao.DaoException;
import by.epam.hostel.dao.connectionpool.ConnectionPool;

import by.epam.hostel.dao.factory.DaoFactory;
import by.epam.hostel.dao.factory.DaoFactory.DAOType;
import by.epam.hostel.dao.impl.IMySqlAdminDao;
import by.epam.hostel.entity.Login;

public class TestMySqlDao {

	private static ConnectionPool connectionPool = null;
	private Connection connection = null;

	/**
	 * The method creation and initialization of the connection pool for further
	 * work test.
	 * */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		connectionPool = ConnectionPool.getInstance();
		connectionPool.initPoolData();
	}

	/**
	 * Method destroys the connection pool.
	 * */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		connectionPool.dispose();
	}

	/**
	 * The method takes the connection.
	 * */
	@Before
	public void setUp() throws Exception {
		connection = connectionPool.takeConnection();
	}

	/**
	 * Method puts the connection back to the connection pool.
	 * */
	@After
	public void tearDown() throws Exception {
		connection.close();
	}

	/**
	 * The method checks the correctness of retrieval from the database, the
	 * password check for a match.
	 * */
	@Test
	public void testPasswordMatch() {
		long password = "123456".hashCode();
		try {
			IMySqlAdminDao dao = DaoFactory.getDAO(DAOType.MY_SQL_DAO)
					.getMySqlAdminDao();
			Login user = dao.getLogin("aa@aa.aa");
			long passwordUser = user.getPassword();
			assertEquals("Error because passwords do not match.", password,
					passwordUser);
		} catch (DaoException e) {
			fail("Problem whith create DAO");
		}
	}
}
