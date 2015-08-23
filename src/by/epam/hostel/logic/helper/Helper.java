package by.epam.hostel.logic.helper;

import java.util.Date;
import java.util.GregorianCalendar;

import by.epam.hostel.entity.Category;
import by.epam.hostel.entity.Login;

/**
 * 
 * This class is intended for smaller tasks to logic layer
 * 
 * @author Alex Nastin
 */
public final class Helper {

	private Helper() {
	}

	/**
	 * The static method check password user.
	 * 
	 * @param Login
	 *            login
	 * @param int password
	 * @return boolean
	 */
	public static boolean checkPassword(Login login, int password) {
		boolean check = false;
		if (login.getPassword() == password) {
			check = true;
		}
		return check;
	}

	/**
	 * The static method check blacklist user.
	 * 
	 * @param Login
	 *            login
	 * @return boolean
	 */
	public static boolean checkBlacklist(Login login) {
		boolean check = false;
		if (login.isBlacklist() == false) {
			check = true;
		}
		return check;
	}

	/**
	 * The static method check status user.
	 * 
	 * @param Loginlogin
	 * @return boolean
	 */
	public static boolean checkStatus(Login login) {
		boolean check = false;
		if (login.isStatus()) {
			check = true;
		}
		return check;
	}

	/**
	 * The static method convert type boolean to type int.
	 * 
	 * @param boolean bool
	 * @return int
	 */
	public static int getInt(boolean bool) {
		return bool ? 1 : 0;
	}

	/**
	 * The static method automatically change the 1 to 0 or 0 to 1.
	 * 
	 * @param int integer
	 * @return int
	 */
	public static int changeInt(int integer) {
		int changeInteger = 0;
		if (integer == 0) {
			changeInteger = 1;
		}
		return changeInteger;
	}

	/**
	 * The static method transforms a string to the type required enum type.
	 * 
	 * @param String
	 *            stringCategory
	 * @return Category
	 */
	public static Category changeStringCategory(String stringCategory) {
		Category category = null;
		switch (stringCategory) {
		case "LUX":
			category = Category.LUX;
			break;
		case "SUPER_LUX":
			category = Category.SUPER_LUX;
			break;
		case "FAMILY":
			category = Category.FAMILY;
			break;
		case "ECONOM":
			category = Category.ECONOM;
			break;
		default:
			category = Category.ECONOM;
			break;
		}
		return category;
	}

	public static int getAmountDays(GregorianCalendar date1,
			GregorianCalendar date2) {
		int amountDays = 0;
		long difference = date2.getTimeInMillis() - date1.getTimeInMillis();
		Date date = new Date(Math.abs(difference));
		amountDays = date.getDate();
		return amountDays;
	}
}
