package by.epam.hostel.logic.impl.admin;

import javax.servlet.http.HttpServletRequest;

import by.epam.hostel.controller.JspPageName;
import by.epam.hostel.controller.RequestParameterName;
import by.epam.hostel.dao.DaoException;
import by.epam.hostel.dao.factory.AbstractDAOFactory;
import by.epam.hostel.dao.factory.DaoFactory;
import by.epam.hostel.dao.factory.DaoFactory.DAOType;
import by.epam.hostel.dao.impl.IMySqlAdminDao;
import by.epam.hostel.entity.Category;
import by.epam.hostel.logic.ICommand;
import by.epam.hostel.logic.CommandException;
import by.epam.hostel.logic.helper.Helper;

/**
 * This class implements a pattern command. This class lets you change the room.
 * 
 * @author Alex Nastin
 */
public class CommandUpdateRoom implements ICommand {
	/**
	 * This method receives parameters from the request of the room and changes
	 * the existing parameters of the room.
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
		Category category = Helper.changeStringCategory(request
				.getParameter(RequestParameterName.CATEGORY_ROOM));
		Integer capacity = Integer.valueOf(request
				.getParameter(RequestParameterName.CAPACITY_ROOM));
		Boolean deletedBool = Boolean.valueOf(request
				.getParameter(RequestParameterName.DELETED_ROOM));
		int deleted = Helper.getInt(deletedBool);
		try {
			AbstractDAOFactory abstractDAOFactory = DaoFactory
					.getDAO(DAOType.MY_SQL_DAO);
			IMySqlAdminDao dao = abstractDAOFactory.getMySqlAdminDao();

			dao.updateRoom(idRoom, price, category, capacity, deleted);
			request.setAttribute(RequestParameterName.GET_ROOMS, dao.getRooms());
		} catch (DaoException e) {
			throw new CommandException(e);
		}
		return JspPageName.ADMINROOMS_PAGE;
	}

}
