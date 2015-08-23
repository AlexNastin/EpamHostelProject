package by.epam.hostel.logic.impl.admin;

import javax.servlet.http.HttpServletRequest;

import by.epam.hostel.controller.JspPageName;
import by.epam.hostel.controller.RequestParameterName;
import by.epam.hostel.dao.DaoException;
import by.epam.hostel.dao.factory.AbstractDAOFactory;
import by.epam.hostel.dao.factory.DaoFactory;
import by.epam.hostel.dao.factory.DaoFactory.DAOType;
import by.epam.hostel.dao.impl.IMySqlAdminDao;
import by.epam.hostel.entity.User;
import by.epam.hostel.logic.ICommand;
import by.epam.hostel.logic.CommandException;

/**
 * This class implements a pattern command. This class finds the necessary user
 * in the database.
 * 
 * @author Alex Nastin
 */
public class CommandGetUser implements ICommand {

	private final String NOT_FIND = "admin.notfind";

	/**
	 * This method back user of the base number.
	 * 
	 * @param request a httpServletRequest
	 * @throws CommandException
	 * @return String which contains page's path for displaying
	 */
	@Override
	public String execute(HttpServletRequest request) throws CommandException {

		String idUserStr = request.getParameter(RequestParameterName.ID_USER);
		String pageName = null;
		try {
			if ("".equals(idUserStr) != true) {
				Integer idUser = Integer.valueOf(idUserStr);
				AbstractDAOFactory abstractDAOFactory = DaoFactory
						.getDAO(DAOType.MY_SQL_DAO);
				IMySqlAdminDao dao = abstractDAOFactory.getMySqlAdminDao();
				User user = dao.getUser(idUser);

				if (user != null) {
					request.setAttribute(RequestParameterName.USER, user);
					pageName = JspPageName.USERFIND_PAGE;
				} else {
					request.setAttribute(RequestParameterName.ERROR, NOT_FIND);
					pageName = JspPageName.ADMINUSERS_PAGE;
				}
			} else {
				request.setAttribute(RequestParameterName.ERROR, NOT_FIND);
				pageName = JspPageName.ADMINUSERS_PAGE;
			}
		} catch (DaoException e) {
			throw new CommandException(e);
		}

		return pageName;
	}
}
