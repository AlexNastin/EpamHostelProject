package by.epam.hostel.dao.connectionpool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * 
 * This class implements a pattern singleton. This class derives from the
 * configuration file settings for the database.
 * 
 * @author Alex Nastin
 */
public class MySqlPropertyManager {
	/**
	 * It is a logger which print some messages to log file.
	 */
	private static final Logger LOG = Logger
			.getLogger(MySqlPropertyManager.class);

	private final String PATH = "db.properties";
	private final String PREFIX = this.getClass().getResource("/").getPath();

	private Properties properties = new Properties();
	private BufferedReader reader = null;
	private File file = new File(PREFIX + PATH);

	/**
	 * The inner class for implementation singleton. It holds
	 * MySqlPropertyManager instance.
	 */
	private static class Holder {
		private static final MySqlPropertyManager INSTANCE = new MySqlPropertyManager();
	}

	/**
	 * The method gives MySqlPropertyManager singleton instance.
	 */
	public static MySqlPropertyManager getInstance() {
		return Holder.INSTANCE;
	}

	/**
	 * The constructor creates BufferedReader and reads configuration file
	 * database.
	 */
	private MySqlPropertyManager() {
		try {
			reader = new BufferedReader(new FileReader(file));
			properties.load(reader);
		} catch (FileNotFoundException e) {
			LOG.error("File db.properties not found.", e);
		} catch (IOException e) {
			LOG.error(e);
		}
	}

	/**
	 * The method gives extract key parameters.
	 * 
	 * @param String key
	 * @return String
	 */
	public String getValue(String key) {
		return properties.getProperty(key);
	}

}
