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
 * This class implements a pattern command. This class changes the status of the
 * user.
 * 
 * @author Alex Nastin
 */
public class CommandMakeAdmin implements ICommand {
	/**
	 * This method changes the status of the user with the administrator or
	 * user.
	 * 
	 * @param request
	 *            a httpServletRequest
	 * @throws CommandException
	 * @return String which contains page's path for displaying
	 */
	@Override
	public String execute(HttpServletRequest request) throws CommandException {
		try {
			Integer idUser = Integer.valueOf(request
					.getParameter(RequestParameterName.ID_USER));
			Boolean statusBool = Boolean.valueOf(request
					.getParameter(RequestParameterName.STATUS_USER));
			int statusInt = Helper.getInt(statusBool);
			AbstractDAOFactory abstractDAOFactory = DaoFactory
					.getDAO(DAOType.MY_SQL_DAO);
			IMySqlAdminDao dao = abstractDAOFactory.getMySqlAdminDao();

			dao.setStatus(idUser, Helper.changeInt(statusInt));
			request.setAttribute(RequestParameterName.USER, dao.getUser(idUser));
		} catch (DaoException e) {
			throw new CommandException(e);
		}
		return JspPageName.USERFIND_PAGE;
	}
}
