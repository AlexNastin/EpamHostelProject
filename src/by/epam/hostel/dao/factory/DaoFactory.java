package by.epam.hostel.dao.factory;

import by.epam.hostel.dao.DaoException;

/**
 * 
 * This class holds methods that return the necessary implementation dao.
 * 
 * @author Alex Nastin
 */
public class DaoFactory {

	public enum DAOType {
		MY_SQL_DAO;
	}

	private DaoFactory() {
	}

	/**
	 * 
	 * The methods returns implementation dao.
	 * 
	 * @param DAOType type
	 * @return AbstractDAOFactory
	 * @throws DaoException
	 */
	public static AbstractDAOFactory getDAO(DAOType type) throws DaoException {
		AbstractDAOFactory daoFactory = null;
		switch (type) {
		case MY_SQL_DAO:
			daoFactory = new MySqlDaoFactory();
		default:
			daoFactory = new MySqlDaoFactory();
			break;
		}
		return daoFactory;
	}

}
