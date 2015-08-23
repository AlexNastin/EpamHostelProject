package by.epam.hostel.logic.impl.user;

import javax.servlet.http.HttpServletRequest;

import by.epam.hostel.controller.JspPageName;
import by.epam.hostel.controller.RequestParameterName;
import by.epam.hostel.logic.ICommand;
import by.epam.hostel.logic.CommandException;

/**
 * This class implements a pattern command. This class receive data for
 * displaying filldate page.
 * 
 * @author Alex Nastin
 */
public class CommandGoFillDate implements ICommand {
	/**
	 * This method handles request to get data for displaying fill date page.
	 * 
	 * @param request
	 *            a httpServletRequest
	 * @throws CommandException
	 * @return String which contains page's path for displaying
	 */
	@Override
	public String execute(HttpServletRequest request) throws CommandException {
		String locale = (String) request.getSession(true).getAttribute(
				RequestParameterName.LOCALE);
		request.setAttribute(RequestParameterName.LOCALE, locale);
		return JspPageName.USERFILLDATE_PAGE;
	}
}
