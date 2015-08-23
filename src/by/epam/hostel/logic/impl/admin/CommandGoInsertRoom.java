package by.epam.hostel.logic.impl.admin;

import javax.servlet.http.HttpServletRequest;

import by.epam.hostel.controller.JspPageName;
import by.epam.hostel.logic.ICommand;
import by.epam.hostel.logic.CommandException;

/**
 * This class implements a pattern command. This class receive data for
 * displaying insert room page.
 * 
 * @author Alex Nastin
 */
public class CommandGoInsertRoom implements ICommand {
	/**
	 * This method handles request to get data for displaying insert room page.
	 * 
	 * @param request
	 *            a httpServletRequest
	 * @throws CommandException
	 * @return String which contains page's path for displaying
	 */
	@Override
	public String execute(HttpServletRequest request) throws CommandException {
		return JspPageName.INSERTROOM_PAGE;
	}

}
