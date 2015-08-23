package by.epam.hostel.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import by.epam.hostel.controller.RequestParameterName;

/**
 * HotelSessionListener implementation class HttpSessionListener
 * 
 * The class puts the necessary parameters in the session when it is first
 * created.
 * 
 * @author Alex Nastin
 */
@WebListener
public class HotelSessionListener implements HttpSessionListener {
	/**
	 * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
	 */
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		HttpSession session = event.getSession();
		session.setAttribute(RequestParameterName.LOCALE, "en");
	}

	/**
	 * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
	 */
	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
	}
}
