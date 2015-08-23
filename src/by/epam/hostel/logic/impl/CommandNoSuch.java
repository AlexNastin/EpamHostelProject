package by.epam.hostel.logic.impl;

import javax.servlet.http.HttpServletRequest;

import by.epam.hostel.controller.JspPageName;
import by.epam.hostel.logic.ICommand;
import by.epam.hostel.logic.CommandException;

/**
 * This class implements a pattern command. This class handles invalid commands.
 * 
 * @author Alex Nastin
 * 
 */
public class CommandNoSuch implements ICommand {
	/**
	 * This method handles requests with invalid commands.
	 * 
	 * @param request
	 *            a httpServletRequest
	 * @throws CommandException
	 * @return String which contains page's path for displaying
	 */
	@Override
	public String execute(HttpServletRequest request) throws CommandException {
		return JspPageName.ERROR_PAGE;
	}
}
