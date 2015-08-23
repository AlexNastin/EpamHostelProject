package by.epam.hostel.logic.impl;

import javax.servlet.http.HttpServletRequest;

import by.epam.hostel.controller.JspPageName;
import by.epam.hostel.controller.RequestParameterName;
import by.epam.hostel.dao.DaoException;
import by.epam.hostel.dao.factory.DaoFactory;
import by.epam.hostel.dao.factory.DaoFactory.DAOType;
import by.epam.hostel.dao.impl.IMySqlAdminDao;
import by.epam.hostel.entity.Login;
import by.epam.hostel.entity.User;
import by.epam.hostel.logic.ICommand;
import by.epam.hostel.logic.CommandException;
import by.epam.hostel.logic.helper.Helper;

/**
 * This class implements a pattern command. This class authorizes users.
 * 
 * @author Alex Nastin
 * 
 */
public class CommandLogin implements ICommand {

	private Login login = null;
	private int userPasswordInt = 0;
	private String page = null;

	/**
	 * This method handles user's request to get access to subscriber or admin
	 * page. If there is an invalid user path will be set to error page. Also
	 * checks whether the user is blacklisted.
	 * 
	 * @param request a httpServletRequest
	 * @throws CommandException
	 * @return String which contains page's path for displaying
	 */
	@Override
	public String execute(HttpServletRequest request) throws CommandException {

		String userLogin = request
				.getParameter(RequestParameterName.LOGIN_USER);
		String userPasswordStr = request
				.getParameter(RequestParameterName.PASSWORD_USER);

		try {
			IMySqlAdminDao dao = DaoFactory.getDAO(DAOType.MY_SQL_DAO)
					.getMySqlAdminDao();
			login = dao.getLogin(userLogin);
			
			if (login != null) {
				userPasswordInt = userPasswordStr.hashCode();
				if (Helper.checkPassword(login, userPasswordInt)) {
					page = checkUser(login, userPasswordInt);
					request.getSession().setAttribute(RequestParameterName.ID_USER, login.getIdUser());
					User user  = dao.getUser(login.getIdUser());
					request.getSession(true).setAttribute( RequestParameterName.LOGIN_USER, user.getName());
				} else {
					page = JspPageName.ERROR_LOGIN_PAGE;
				}
			} else {
				page = JspPageName.ERROR_LOGIN_PAGE;
			}

		} catch (DaoException e) {
			throw new CommandException(e);
		}

		return page;
	}

	private String checkUser(Login login, int userPasswordInt) {
		if (Helper.checkBlacklist(login)) {
			if (Helper.checkStatus(login)) {
				page = JspPageName.ADMIN_PAGE;
			} else {
				page = JspPageName.USER_PAGE;
			}
		} else {
			page = JspPageName.BLACKLIST_PAGE;
		}
		return page;
	}
}
