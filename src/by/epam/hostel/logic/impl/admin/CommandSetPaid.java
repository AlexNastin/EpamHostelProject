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
import by.epam.hostel.logic.helper.Helper;

/**
 * This class implements a pattern command. This class change the status of
 * payment.
 * 
 * @author Alex Nastin
 */
public class CommandSetPaid implements ICommand {
	/**
	 * This method change the status of payment.
	 * 
	 * @param request
	 *            a httpServletRequest
	 * @throws CommandException
	 * @return String which contains page's path for displaying
	 */
	@Override
	public String execute(HttpServletRequest request) throws CommandException {
		try {
			Integer idOrder = Integer.valueOf(request
					.getParameter(RequestParameterName.ID_ORDER));
			Boolean paid = Boolean.valueOf(request
					.getParameter(RequestParameterName.PAID));
			int blacklistInt = Helper.getInt(paid);

			AbstractDAOFactory abstractDAOFactory = DaoFactory
					.getDAO(DAOType.MY_SQL_DAO);
			IMySqlAdminDao dao = abstractDAOFactory.getMySqlAdminDao();

			dao.setPaid(idOrder, Helper.changeInt(blacklistInt));
			request.setAttribute(RequestParameterName.GET_ORDERS,
					dao.getOrders());
		} catch (DaoException e) {
			throw new CommandException(e);
		}
		return JspPageName.ADMINORDERS_PAGE;
	}

}
