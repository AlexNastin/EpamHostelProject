package by.epam.hostel.logic.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import by.epam.hostel.controller.JspPageName;
import by.epam.hostel.controller.RequestParameterName;
import by.epam.hostel.dao.DaoException;
import by.epam.hostel.dao.factory.DaoFactory;
import by.epam.hostel.dao.factory.DaoFactory.DAOType;
import by.epam.hostel.dao.impl.IMySqlAdminDao;
import by.epam.hostel.logic.ICommand;
import by.epam.hostel.logic.CommandException;

/**
 * This class implements a pattern command. This class registers users.
 * 
 * @author Alex Nastin
 * 
 */
public class CommandRegister implements ICommand {

	private final String ERROR_PASSWORDMATCH = "error.passwordnotmatch";
	private final String ERROR_FIELD = "error.fieldnot";
	private final String ERROR_LOGIN = "error.login";
	private final String REGEX_LOGIN = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$";

	/**
	 * This method handles user's request register to site. It checks that data
	 * is valid and writes the user database.
	 * 
	 * @param request
	 *            a httpServletRequest
	 * @throws CommandException
	 * @return String which contains page's path for displaying
	 */
	@Override
	public String execute(HttpServletRequest request) throws CommandException {

		String userName = request.getParameter(RequestParameterName.NAME_USER);
		String userSurname = request
				.getParameter(RequestParameterName.SURNAME_USER);
		String userNumpass = request
				.getParameter(RequestParameterName.NUMPASS_USER);
		String userLogin = request
				.getParameter(RequestParameterName.LOGIN_USER);
		String userPassword = request
				.getParameter(RequestParameterName.PASSWORD_USER);
		String userPasswordMatch = request
				.getParameter(RequestParameterName.PASSWORDMATCH_USER);

		if ((userName != "") && (userNumpass != "") && (userSurname != "")
				&& (userLogin != "") && (userPassword != "")) {
			if (userPassword.equals(userPasswordMatch)) {
				Pattern pattern = Pattern.compile(REGEX_LOGIN);
				Matcher matcher = pattern.matcher(userLogin);
				
				
				if (matcher.find()) {
					try {
						IMySqlAdminDao dao = DaoFactory.getDAO(
								DAOType.MY_SQL_DAO).getMySqlAdminDao();
						dao.insertUser(userName, userSurname, userNumpass,
								userLogin, userPassword);
					} catch (DaoException e) {
						throw new CommandException(e);
					}
					return JspPageName.INDEX_PAGE;
				} else {
					request.setAttribute(RequestParameterName.REGEXLOGIN,
							ERROR_LOGIN);
					return JspPageName.ERROR_PAGE;
				}
			} else {
				request.setAttribute(RequestParameterName.PASSWORDMATCH_NOT,
						ERROR_PASSWORDMATCH);
				return JspPageName.ERROR_PAGE;
			}
		} else {
			request.setAttribute(RequestParameterName.FIELD_NOT, ERROR_FIELD);
			return JspPageName.ERROR_PAGE;
		}

	}
}
