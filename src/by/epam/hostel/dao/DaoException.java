package by.epam.hostel.dao;

import by.epam.hostel.exeption.ProjectException;

/**
 * This exception appears from DAO.
 * 
 * @author Alex Nastin
 */
public class DaoException extends ProjectException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4215196266448842328L;

	public DaoException(String message) {
		super(message);

	}

	public DaoException(String message, Throwable e) {
		super(message, e);
	}

	public DaoException(Throwable e) {
		super(e);
	}

}
