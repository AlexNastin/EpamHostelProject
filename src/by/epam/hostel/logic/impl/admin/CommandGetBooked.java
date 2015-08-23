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
 * This class implements a pattern command. This class returns the date of the
 * reservation of the room.
 * 
 * @author Alex Nastin
 */
public class CommandGetBooked implements ICommand {

	private final String NOT_FIND = "admin.notfind";

	/**
	 * This method returns the date of the reservation of the room.
	 * 
	 * @param request
	 *            a httpServletRequest
	 * @throws CommandException
	 * @return String which contains page's path for displaying
	 */
	@Override
	public String execute(HttpServletRequest request) throws CommandException {

		String idRoomStr = request.getParameter(RequestParameterName.ID_ROOM);
		String pageName = null;
		try {
			if ("".equalsIgnoreCase(idRoomStr) != true) {
				Integer idRoom = Integer.valueOf(idRoomStr);

				AbstractDAOFactory abstractDAOFactory = DaoFactory
						.getDAO(DAOType.MY_SQL_DAO);
				IMySqlAdminDao dao = abstractDAOFactory.getMySqlAdminDao();

				request.setAttribute(RequestParameterName.GET_BOOKEDDATES,
						dao.getBookedDatesRoom(idRoom));
				pageName = JspPageName.BOOKEDDATE_PAGE;

			} else {
				request.setAttribute(RequestParameterName.ERROR, NOT_FIND);
				pageName = JspPageName.BOOKEDDATE_PAGE;
			}
		} catch (DaoException e) {
			throw new CommandException(e);
		}

		return pageName;
	}

}
