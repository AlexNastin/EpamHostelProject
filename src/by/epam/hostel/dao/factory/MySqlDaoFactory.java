package by.epam.hostel.dao.factory;

import by.epam.hostel.dao.impl.IMySqlAdminDao;
import by.epam.hostel.dao.impl.IMySqlUserDao;
import by.epam.hostel.dao.impl.MySqlAdminDao;
import by.epam.hostel.dao.impl.MySqlUserDao;
/**
 * 
 * This class holds methods that return the necessary implementation dao.
 * 
 * @author Alex Nastin
 */
public class MySqlDaoFactory extends AbstractDAOFactory {

	@Override
	public IMySqlAdminDao getMySqlAdminDao() {
		return MySqlAdminDao.getInstance();
	}

	@Override
	public IMySqlUserDao getMySqlUserDao() {
		return MySqlUserDao.getInstance();
	}

}
