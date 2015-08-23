package by.epam.hostel.logic.impl.user;

import javax.servlet.http.HttpServletRequest;

import by.epam.hostel.controller.JspPageName;
import by.epam.hostel.controller.RequestParameterName;
import by.epam.hostel.dao.DaoException;
import by.epam.hostel.dao.factory.AbstractDAOFactory;
import by.epam.hostel.dao.factory.DaoFactory;
import by.epam.hostel.dao.factory.DaoFactory.DAOType;
import by.epam.hostel.dao.impl.IMySqlAdminDao;
import by.epam.hostel.dao.impl.IMySqlUserDao;
import by.epam.hostel.entity.Room;
import by.epam.hostel.logic.ICommand;
import by.epam.hostel.logic.CommandException;

/**
 * This class implements a pattern command. This class reservation room for the
 * user.
 * 
 * @author Alex Nastin
 */
public class CommandBooked implements ICommand {

	private final String INFO = "user.info";

	/**
	 * This method writes the order number into the database, and considers the
	 * total amount of the order and sends the user to the main page and a
	 * message for him.
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
		int idUser = (int) request.getSession(true).getAttribute(
				RequestParameterName.ID_USER);
		String arrival = (String) request.getSession().getAttribute(
				RequestParameterName.ARRIVAL_USER);
		String departure = (String) request.getSession().getAttribute(
				RequestParameterName.DEPARTURE_USER);
		int amountDays = (int) request.getSession().getAttribute(
				RequestParameterName.AMOUNT_DAYS);
		double totalPrice = 0;

		try {

			AbstractDAOFactory abstractDAOFactory = DaoFactory
					.getDAO(DAOType.MY_SQL_DAO);
			IMySqlUserDao daoUser = abstractDAOFactory.getMySqlUserDao();
			IMySqlAdminDao daoAdmin = abstractDAOFactory.getMySqlAdminDao();
			daoUser.insertOrder(arrival, departure, idUser, idRoom);

			Room room = daoAdmin.getRoom(idRoom);
			totalPrice = room.getPrice() * (amountDays - 1);

		} catch (DaoException e) {
			throw new CommandException(e);
		}
		request.setAttribute(RequestParameterName.USER_INFO, INFO);
		request.setAttribute(RequestParameterName.TOTAL_PRICE, totalPrice);
		return JspPageName.USER_PAGE;
	}
}
