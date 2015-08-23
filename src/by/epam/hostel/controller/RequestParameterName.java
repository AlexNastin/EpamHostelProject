package by.epam.hostel.controller;

/**
 * This class keeps information about the names of the parameters Request.
 * 
 * @author Alex Nastin
 */
public final class RequestParameterName {

	private RequestParameterName() {
	}

	public static final String COMMAND_NAME = "command";

	public static final String LOGIN = "login";
	public static final String LOGOUT = "logout";

	public static final String GO_REGISTER = "goRegister";

	public static final String ID_ORDER = "idOrder";
	public static final String PAID = "paid";

	public static final String ID_ROOM = "idRoom";
	public static final String PRICE_ROOM = "price";
	public static final String CATEGORY_ROOM = "category";
	public static final String CAPACITY_ROOM = "capacity";
	public static final String DELETED_ROOM = "isDeleted";

	public static final String ID_USER = "idUser";
	public static final String USER_INFO = "info";
	public static final String NAME_USER = "userName";
	public static final String SURNAME_USER = "userSurname";
	public static final String NUMPASS_USER = "userNumpass";
	public static final String LOGIN_USER = "userLogin";
	public static final String PASSWORD_USER = "userPassword";
	public static final String ARRIVAL_USER = "arrival";
	public static final String DEPARTURE_USER = "departure";
	public static final String ADAY = "aday";
	public static final String AMONTH = "amonth";
	public static final String AYEAR = "ayear";
	public static final String DDAY = "dday";
	public static final String DMONTH = "dmonth";
	public static final String DYEAR = "dyear";
	public static final String AMOUNT_DAYS = "amountDays";
	public static final String TOTAL_PRICE = "totalPrice";
	public static final String FREEROOMS = "freerooms";

	public static final String PASSWORDMATCH_USER = "userPasswordMatch";
	public static final String PASSWORDMATCH_NOT = "errorPasswordNotMatch";

	public static final String REGEXLOGIN = "regexLogin";
	public static final String FIELD_NOT = "fieldNot";
	public static final String LOCALE = "locale";

	public static final String GET_USERS = "users";
	public static final String GET_ROOMS = "rooms";
	public static final String GET_ORDERS = "orders";
	public static final String GET_BOOKED = "getbooked";
	public static final String GET_USER_ORDERS = "userorders";
	public static final String GET_BOOKEDDATES = "bookeddates";

	public static final String ERROR = "error";
	public static final String STATUS_USER = "status";
	public static final String BLACKLIST_USER = "blacklist";
	public static final String USER = "user";
	public static final String ROOM = "room";
}
