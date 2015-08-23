package by.epam.hostel.exeption;

/**
 * This exception appears from ProjectException.
 * 
 * @author Alex Nastin
 */
public class ProjectException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1395030963234802420L;

	public ProjectException(String message) {
		super(message);

	}

	public ProjectException(String message, Throwable e) {
		super(message, e);
	}

	public ProjectException(Throwable e) {
		super(e);
	}

}
