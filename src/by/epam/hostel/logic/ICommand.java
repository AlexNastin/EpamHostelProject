package by.epam.hostel.logic;

import javax.servlet.http.HttpServletRequest;

/**
 * This interface implements a pattern command. It causes methods a
 * business-logic and sends results on jsp.
 * 
 * @author Alex Nastin
 * 
 */
public interface ICommand {

	/**
	 * This abstract method causes methods a business-logic and sends results on
	 * jsp.
	 * 
	 * @param request
	 *            a httpServletRequest
	 * @param response
	 *            a httpServletResponse
	 * @throws ServletException
	 *             a ServletException
	 * @throws IOException
	 *             a IOException
	 * @return String which contains page's path for displaying
	 */
	public String execute(HttpServletRequest request) throws CommandException;

}
