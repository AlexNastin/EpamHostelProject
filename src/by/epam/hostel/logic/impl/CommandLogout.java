package by.epam.hostel.logic.impl;

import javax.servlet.http.HttpServletRequest;

import by.epam.hostel.controller.JspPageName;
import by.epam.hostel.logic.ICommand;
import by.epam.hostel.logic.CommandException;

/**
 * This class implements a pattern command. This class executes logout of user
 * and clears session.
 * 
 * @author Alex Nastin
 * 
 */
public class CommandLogout implements ICommand {
	/**
	 * This method handles user's request logout from site. The session will be
	 * invalidated.
	 * 
	 * @param request
	 *            a httpServletRequest
	* @throws CommandException
	 * @return String which contains page's path for displaying
	 */
	@Override
	public String execute(HttpServletRequest request) throws CommandException {
		request.getSession(true).invalidate();
		return JspPageName.INDEX_PAGE;
	}
}
