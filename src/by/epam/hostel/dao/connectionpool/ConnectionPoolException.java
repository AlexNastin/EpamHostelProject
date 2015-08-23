package by.epam.hostel.dao.connectionpool;

import by.epam.hostel.exeption.ProjectException;

/**
 * This exception appears in ConnectionPool class
 * 
 * @author Alex Nastin
 */
public class ConnectionPoolException extends ProjectException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8555125592745246274L;

	public ConnectionPoolException(String message) {
		super(message);

	}

	public ConnectionPoolException(String message, Throwable e) {
		super(message, e);
	}

	public ConnectionPoolException(Throwable e) {
		super(e);
	}

}
