package by.epam.hostel.logic.impl.user;

import java.util.GregorianCalendar;

import javax.servlet.http.HttpServletRequest;

import by.epam.hostel.controller.JspPageName;
import by.epam.hostel.controller.RequestParameterName;
import by.epam.hostel.dao.DaoException;
import by.epam.hostel.dao.factory.AbstractDAOFactory;
import by.epam.hostel.dao.factory.DaoFactory;
import by.epam.hostel.dao.factory.DaoFactory.DAOType;
import by.epam.hostel.dao.impl.IMySqlUserDao;
import by.epam.hostel.logic.ICommand;
import by.epam.hostel.logic.CommandException;
import by.epam.hostel.logic.helper.Helper;

/**
 * This class implements a pattern command. This class determines the
 * availability for user.
 * 
 * @author Alex Nastin
 */
public class CommandCheckDate implements ICommand {

	private final String DASH = "-";

	/**
	 * This method selects the availability for the user in a given period of
	 * time.
	 * 
	 * @param request
	 *            a httpServletRequest
	 * @throws CommandException
	 * @return String which contains page's path for displaying
	 */
	@Override
	public String execute(HttpServletRequest request) throws CommandException {
		IMySqlUserDao dao = null;

		String aday = request.getParameter(RequestParameterName.ADAY);
		String amonth = request.getParameter(RequestParameterName.AMONTH);
		String ayear = request.getParameter(RequestParameterName.AYEAR);

		String dday = request.getParameter(RequestParameterName.DDAY);
		String dmonth = request.getParameter(RequestParameterName.DMONTH);
		String dyear = request.getParameter(RequestParameterName.DYEAR);

		StringBuilder arrival = new StringBuilder();
		StringBuilder departure = new StringBuilder();

		arrival.append(ayear);
		arrival.append(DASH);
		arrival.append(amonth);
		arrival.append(DASH);
		arrival.append(aday);

		departure.append(dyear);
		departure.append(DASH);
		departure.append(dmonth);
		departure.append(DASH);
		departure.append(dday);

		GregorianCalendar dataArrival = new GregorianCalendar(
				Integer.valueOf(ayear), Integer.valueOf(amonth) - 1,
				Integer.valueOf(aday));
		GregorianCalendar dataDeparture = new GregorianCalendar(
				Integer.valueOf(dyear), Integer.valueOf(dmonth) - 1,
				Integer.valueOf(dday));
		int amountDays = Helper.getAmountDays(dataArrival, dataDeparture);

		request.getSession(true).setAttribute(
				RequestParameterName.ARRIVAL_USER, arrival.toString());
		request.getSession().setAttribute(RequestParameterName.DEPARTURE_USER,
				departure.toString());
		request.getSession().setAttribute(RequestParameterName.AMOUNT_DAYS,
				amountDays);
		try {
			AbstractDAOFactory abstractDAOFactory = DaoFactory
					.getDAO(DAOType.MY_SQL_DAO);
			dao = abstractDAOFactory.getMySqlUserDao();
			request.getSession().setAttribute(RequestParameterName.FREEROOMS,
					dao.getFreeRooms(arrival.toString(), departure.toString()));

		} catch (DaoException e) {
			throw new CommandException(e);
		}
		return JspPageName.USERPICKORDER_PAGE;
	}
}
