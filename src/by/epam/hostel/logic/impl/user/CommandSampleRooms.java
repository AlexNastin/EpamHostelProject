package by.epam.hostel.logic.impl.user;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.epam.hostel.controller.JspPageName;
import by.epam.hostel.controller.RequestParameterName;
import by.epam.hostel.dao.DaoException;
import by.epam.hostel.dao.factory.AbstractDAOFactory;
import by.epam.hostel.dao.factory.DaoFactory;
import by.epam.hostel.dao.factory.DaoFactory.DAOType;
import by.epam.hostel.dao.impl.IMySqlUserDao;
import by.epam.hostel.entity.Room;
import by.epam.hostel.logic.ICommand;
import by.epam.hostel.logic.CommandException;

/**
 * This class implements a pattern command. This class in which the sample rooms
 * on an individual user's request.
 * 
 * @author Alex Nastin
 */
public class CommandSampleRooms implements ICommand {

	private final String FAMILY = "FAMILY";
	private final String LUX = "LUX";
	private final String SUPER_LUX = "SUPER_LUX";
	private final String ECONOM = "ECONOM";

	/**
	 * This method implements sample needed rooms for user parameters.
	 * 
	 * @param request
	 *            a httpServletRequest
	 * @throws CommandException
	 * @return String which contains page's path for displaying
	 */
	@Override
	public String execute(HttpServletRequest request) throws CommandException {
		List<Room> rooms = new ArrayList<Room>();
		try {

			AbstractDAOFactory abstractDAOFactory = DaoFactory
					.getDAO(DAOType.MY_SQL_DAO);
			IMySqlUserDao dao = abstractDAOFactory.getMySqlUserDao();

			String priceStr = request
					.getParameter(RequestParameterName.PRICE_ROOM);
			String categoryStr = request
					.getParameter(RequestParameterName.CATEGORY_ROOM);
			String capacityStr = request
					.getParameter(RequestParameterName.CAPACITY_ROOM);
			Integer capacity = Integer.valueOf(capacityStr);

			if (("".equalsIgnoreCase(priceStr) != true)) {
				Double price = Double.valueOf(priceStr);
				switch (categoryStr) {
				case FAMILY:
					rooms = dao.getRoomsPriceAndCategoryAndCapacity(
							categoryStr, price, capacity);
					break;
				case LUX:
					rooms = dao.getRoomsPriceAndCategoryAndCapacity(
							categoryStr, price, capacity);
					break;
				case SUPER_LUX:
					rooms = dao.getRoomsPriceAndCategoryAndCapacity(
							categoryStr, price, capacity);
					break;
				case ECONOM:
					rooms = dao.getRoomsPriceAndCategoryAndCapacity(
							categoryStr, price, capacity);
					break;
				default:
					rooms = dao.getRoomsPriceAndCapacity(price, capacity);
					break;
				}
			} else {
				switch (categoryStr) {
				case FAMILY:
					rooms = dao.getRoomsCategoryAndCapacity(categoryStr,
							capacity);
					break;
				case LUX:
					rooms = dao.getRoomsCategoryAndCapacity(categoryStr,
							capacity);
					break;
				case SUPER_LUX:
					rooms = dao.getRoomsCategoryAndCapacity(categoryStr,
							capacity);
					break;
				case ECONOM:
					rooms = dao.getRoomsCategoryAndCapacity(categoryStr,
							capacity);
					break;
				default:
					rooms = dao.getRoomsCapacity(capacity);
					break;
				}
			}
		} catch (DaoException e) {
			throw new CommandException(e);
		}

		request.getSession(true).setAttribute(RequestParameterName.FREEROOMS,
				rooms);
		return JspPageName.USERPICKORDER_PAGE;
	}
}
