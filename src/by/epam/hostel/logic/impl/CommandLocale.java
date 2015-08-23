package by.epam.hostel.logic.impl;

import javax.servlet.http.HttpServletRequest;

import by.epam.hostel.controller.JspPageName;
import by.epam.hostel.controller.RequestParameterName;
import by.epam.hostel.logic.ICommand;
import by.epam.hostel.logic.CommandException;

/**
 * This class implements a pattern command. This class change the language in
 * the web-application.
 * 
 * @author Alex Nastin
 */
public class CommandLocale implements ICommand {
	
	/**
	 * This method change the language and goes to the start page.
	 * 
	 * @param request a httpServletRequest
	 * @throws CommandException
	 * @return String which contains page's path for displaying
	 */
	@Override
	public String execute(HttpServletRequest request) throws CommandException {

		String localeName = (String) request.getSession(true).getAttribute(
				RequestParameterName.LOCALE);

		if ("en".equalsIgnoreCase(localeName)) {
			localeName = "ru";
		} else {
			localeName = "en";
		}

		request.getSession(true).setAttribute(RequestParameterName.LOCALE,
				localeName);

		return JspPageName.INDEX_PAGE;
	}
}
