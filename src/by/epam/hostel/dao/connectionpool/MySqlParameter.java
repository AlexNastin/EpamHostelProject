package by.epam.hostel.dao.connectionpool;

/**
 * This class contains information about the name of the parameters for the
 * database.
 * 
 * @author Alex Nastin
 */

public final class MySqlParameter {

	private MySqlParameter() {
	}

	public static final String DB_DRIVER = "db.driver";
	public static final String DB_URL = "db.url";
	public static final String DB_USER = "db.user";
	public static final String DB_PASSWORD = "db.password";
	public static final String DB_POLL_SIZE = "db.poolsize";

}
