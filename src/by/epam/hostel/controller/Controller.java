package by.epam.hostel.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.epam.hostel.logic.ICommand;
import by.epam.hostel.logic.CommandException;
import by.epam.hostel.logic.CommandHelper;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger(Controller.class);
	int counter = 0;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		proccesRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		proccesRequest(request, response);

	}
	 /**
     * This method gets a instance of <code>Command</code> from <code>CommandHelper</code>
     * by request and executes this command. Then it goes to next jsp.
     * 
     * @param request a httpServletRequest
     * @param response a httpServletResponse
     * @throws ServletException a ServletException
     * @throws IOException a IOException
     */
	private void proccesRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		counter++;
		String page = null;
		
		String commandName = request.getParameter(RequestParameterName.COMMAND_NAME);

		CommandHelper helper = CommandHelper.getInstance();
		ICommand iCommand = helper.getCommand(commandName);
		try {
			page = iCommand.execute(request);
		} catch (CommandException e) {
			LOG.error(e);
			page = JspPageName.ERROR_PAGE;
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);

	}
}
