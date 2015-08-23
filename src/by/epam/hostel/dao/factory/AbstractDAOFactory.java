package by.epam.hostel.dao.factory;

import by.epam.hostel.dao.impl.IMySqlAdminDao;
import by.epam.hostel.dao.impl.IMySqlUserDao;
/**
 * 
 * This abstract class holds abstract methods for further implementation dao.
 * 
 * @author Alex Nastin
 */
public abstract class AbstractDAOFactory {

	public AbstractDAOFactory() {
	}

	public abstract IMySqlAdminDao getMySqlAdminDao();

	public abstract IMySqlUserDao getMySqlUserDao();

}
