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
 * This class implements a pattern command. This class performs the addition of
 * a new room in the database.
 * 
 * @author Alex Nastin
 */
public class CommandInsertRoom implements ICommand {
	/**
	 * This method receives data from the query and stores them in a database.
	 * 
	 * @param request
	 *            a httpServletRequest
	 * @throws CommandException
	 * @return String which contains page's path for displaying
	 */
	@Override
	public String execute(HttpServletRequest request) throws CommandException {
		Integer idRoom = Integer.valueOf(request
				.getParameter(RequestParameterName.ID_ROOM));
		Double price = Double.valueOf(request
				.getParameter(RequestParameterName.PRICE_ROOM));
		String category = request
				.getParameter(RequestParameterName.CATEGORY_ROOM);
		Integer capacity = Integer.valueOf(request
				.getParameter(RequestParameterName.CAPACITY_ROOM));
		try {
			AbstractDAOFactory abstractDAOFactory = DaoFactory
					.getDAO(DAOType.MY_SQL_DAO);
			IMySqlAdminDao dao = abstractDAOFactory.getMySqlAdminDao();
			dao.insertRoom(idRoom, price, category, capacity);
			request.setAttribute(RequestParameterName.GET_ROOMS, dao.getRooms());
		} catch (DaoException e) {
			throw new CommandException(e);
		}

		return JspPageName.ADMINROOMS_PAGE;
	}

}
