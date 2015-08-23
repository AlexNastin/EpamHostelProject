package by.epam.hostel.logic.impl.user;

import javax.servlet.http.HttpServletRequest;

import by.epam.hostel.controller.JspPageName;
import by.epam.hostel.controller.RequestParameterName;
import by.epam.hostel.dao.DaoException;
import by.epam.hostel.dao.factory.AbstractDAOFactory;
import by.epam.hostel.dao.factory.DaoFactory;
import by.epam.hostel.dao.factory.DaoFactory.DAOType;
import by.epam.hostel.dao.impl.IMySqlUserDao;
import by.epam.hostel.logic.ICommand;
import by.epam.hostel.logic.CommandException;

/**
 * This class implements a pattern command. This class user demonstrates orders.
 * 
 * @author Alex Nastin
 */
public class CommandUserOrders implements ICommand {

	/**
	 * This method extracts from the database specific user orders and sends
	 * them to the jsp.
	 * 
	 * @param request
	 *            a httpServletRequest
	 * @throws CommandException
	 * @return String which contains page's path for displaying
	 */
	@Override
	public String execute(HttpServletRequest request) throws CommandException {
		int idUser = (int) request.getSession(true).getAttribute(
				RequestParameterName.ID_USER);
		try {
			AbstractDAOFactory abstractDAOFactory = DaoFactory
					.getDAO(DAOType.MY_SQL_DAO);
			IMySqlUserDao dao = abstractDAOFactory.getMySqlUserDao();
			request.setAttribute(RequestParameterName.GET_USER_ORDERS,
					dao.getUserOrders(idUser));
		} catch (DaoException e) {
			throw new CommandException(e);
		}
		return JspPageName.USERORDERS_PAGE;
	}

}
