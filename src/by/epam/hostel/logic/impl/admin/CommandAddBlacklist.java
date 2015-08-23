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
 * This class implements a pattern command. This class adds the user to the
 * black list.
 * 
 * @author Alex Nastin
 */
public class CommandAddBlacklist implements ICommand {
	/**
	 * This method adds the user to the blacklist.
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
			Integer idUser = Integer.valueOf(request
					.getParameter(RequestParameterName.ID_USER));
			Boolean blacklistBool = Boolean.valueOf(request
					.getParameter(RequestParameterName.BLACKLIST_USER));
			int blacklistInt = Helper.getInt(blacklistBool);
			dao.setBlacklistUser(idUser, Helper.changeInt(blacklistInt));
			request.setAttribute(RequestParameterName.USER, dao.getUser(idUser));
		} catch (DaoException e) {
			throw new CommandException(e);
		}
		return JspPageName.USERFIND_PAGE;
	}
}
