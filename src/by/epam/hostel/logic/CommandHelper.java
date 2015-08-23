package by.epam.hostel.logic;

import java.util.HashMap;
import java.util.Map;

import by.epam.hostel.logic.impl.CommandGoRegister;
import by.epam.hostel.logic.impl.CommandLocale;
import by.epam.hostel.logic.impl.CommandLogin;
import by.epam.hostel.logic.impl.CommandLogout;
import by.epam.hostel.logic.impl.CommandNoSuch;
import by.epam.hostel.logic.impl.CommandRegister;
import by.epam.hostel.logic.impl.admin.CommandAddBlacklist;
import by.epam.hostel.logic.impl.admin.CommandAdminUseOrders;
import by.epam.hostel.logic.impl.admin.CommandAdminUseRooms;
import by.epam.hostel.logic.impl.admin.CommandAdminUseUsers;
import by.epam.hostel.logic.impl.admin.CommandGetBooked;
import by.epam.hostel.logic.impl.admin.CommandGetRoom;
import by.epam.hostel.logic.impl.admin.CommandGetUser;
import by.epam.hostel.logic.impl.admin.CommandGoInsertRoom;
import by.epam.hostel.logic.impl.admin.CommandInsertRoom;
import by.epam.hostel.logic.impl.admin.CommandMakeAdmin;
import by.epam.hostel.logic.impl.admin.CommandSetPaid;
import by.epam.hostel.logic.impl.admin.CommandShowBooked;
import by.epam.hostel.logic.impl.admin.CommandUpdateRoom;
import by.epam.hostel.logic.impl.user.CommandBooked;
import by.epam.hostel.logic.impl.user.CommandCheckDate;
import by.epam.hostel.logic.impl.user.CommandGoFillDate;
import by.epam.hostel.logic.impl.user.CommandSampleRooms;
import by.epam.hostel.logic.impl.user.CommandUserOrders;

/**
 * The class implements a pattern singleton. This class gets a command from
 * request, checks this name and returns an instance of interface
 * <code>ICommand</code>
 * 
 * @author Alex Nastin
 */
public final class CommandHelper {

	/**
	 * HashMap holds available commands. Key - name of command. Value - instance
	 * of interface Command.
	 */
	private Map<CommandName, ICommand> iCommands = new HashMap<CommandName, ICommand>();

	/**
	 * The method gives ConnectionPool singleton instance.
	 */
	public static CommandHelper getInstance() {
		return Holder.INSTANCE;
	}

	/**
	 * The inner class for implementation singleton. It holds ConnectionPool
	 * instance.
	 */
	private static class Holder {
		private static final CommandHelper INSTANCE = new CommandHelper();
	}

	/**
	 * private constructor fill HashMap with command's instances.
	 */
	public CommandHelper() {
		iCommands.put(CommandName.LOGIN, new CommandLogin());
		iCommands.put(CommandName.GOREGISTER, new CommandGoRegister());
		iCommands.put(CommandName.REGISTER, new CommandRegister());
		iCommands.put(CommandName.LOGOUT, new CommandLogout());
		iCommands.put(CommandName.ADMIN_USE_USER, new CommandAdminUseUsers());
		iCommands.put(CommandName.NO_SUCH_COMMAND, new CommandNoSuch());
		iCommands.put(CommandName.GETUSER, new CommandGetUser());
		iCommands.put(CommandName.MAKEADMIN, new CommandMakeAdmin());
		iCommands.put(CommandName.ADDBLACKLIST, new CommandAddBlacklist());
		iCommands.put(CommandName.ADMIN_USE_ROOMS, new CommandAdminUseRooms());
		iCommands.put(CommandName.GETROOM, new CommandGetRoom());
		iCommands.put(CommandName.UPDATEROOM, new CommandUpdateRoom());
		iCommands.put(CommandName.GOINSERTROOM, new CommandGoInsertRoom());
		iCommands.put(CommandName.INSERTROOM, new CommandInsertRoom());
		iCommands.put(CommandName.ADMIN_USE_ORDERS, new CommandAdminUseOrders());
		iCommands.put(CommandName.SHOWBOOKED, new CommandShowBooked());
		iCommands.put(CommandName.USERORDERS, new CommandUserOrders());
		iCommands.put(CommandName.GETBOOKED, new CommandGetBooked());
		iCommands.put(CommandName.CHECKDATE, new CommandCheckDate());
		iCommands.put(CommandName.GOFILLDATE, new CommandGoFillDate());
		iCommands.put(CommandName.SAMPLEROOMS, new CommandSampleRooms());
		iCommands.put(CommandName.BOOKED, new CommandBooked());
		iCommands.put(CommandName.SETPAID, new CommandSetPaid());
		iCommands.put(CommandName.LOCALE, new CommandLocale());

	}

	/**
	 * This method get command's instance from request.
	 * 
	 * @param String commandName
	 * @return Command instance
	 */
	public ICommand getCommand(String commandName) {
		ICommand iCommand = null;
		CommandName name = null;
		try {
			name = CommandName.valueOf(commandName.toUpperCase());
		} catch (IllegalArgumentException e) {
			iCommand = iCommands.get(CommandName.NO_SUCH_COMMAND);
		}
		if (name != null) {
			iCommand = iCommands.get(name);
		} else {
			iCommand = iCommands.get(CommandName.NO_SUCH_COMMAND);
		}
		return iCommand;
	}
}
