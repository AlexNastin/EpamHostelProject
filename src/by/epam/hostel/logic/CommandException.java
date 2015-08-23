package by.epam.hostel.logic;

import by.epam.hostel.exeption.ProjectException;

/**
 * This exception appears from CommandException.
 * 
 * @author Alex Nastin
 */
public class CommandException extends ProjectException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8967941434873708746L;

	public CommandException(String message, Throwable e) {
		super(message, e);
	}

	public CommandException(String message) {
		super(message);
	}

	public CommandException(Throwable e) {
		super(e);
	}

}
