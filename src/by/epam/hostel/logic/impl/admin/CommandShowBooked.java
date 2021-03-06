package by.epam.hostel.logic.impl.admin;

import javax.servlet.http.HttpServletRequest;

import by.epam.hostel.controller.JspPageName;
import by.epam.hostel.controller.RequestParameterName;
import by.epam.hostel.dao.DaoException;
import by.epam.hostel.dao.factory.AbstractDAOFactory;
import by.epam.hostel.dao.factory.DaoFactory;
import by.epam.hostel.dao.factory.DaoFactory.DAOType;
import by.epam.hostel.dao.impl.IMySqlAdminDao;
import by.epam.hostel.logic.ICommand;
import by.epam.hostel.logic.CommandException;

/**
 * This class implements a pattern command. This class demonstrates all book
 * room.
 * 
 * @author Alex Nastin
 */
public class CommandShowBooked implements ICommand {
	/**
	 * This method demonstrates all book room.
	 * 
	 * @param request
	 *            a httpServletRequest
	 * @throws CommandException
	 * @return String which contains page's path for displaying
	 */
	@Override
	public String execute(HttpServletRequest request) throws CommandException {
		try {
			AbstractDAOFactory abstractDAOFactory = DaoFactory
					.getDAO(DAOType.MY_SQL_DAO);
			IMySqlAdminDao dao = abstractDAOFactory.getMySqlAdminDao();

			request.setAttribute(RequestParameterName.GET_BOOKEDDATES,
					dao.getBookedDates());
		} catch (DaoException e) {
			throw new CommandException(e);
		}
		return JspPageName.BOOKEDDATE_PAGE;
	}
}
