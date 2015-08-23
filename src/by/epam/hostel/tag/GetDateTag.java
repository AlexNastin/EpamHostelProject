package by.epam.hostel.tag;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * This tag displays the current date according to the locale.
 * 
 * @author Alex Nastin
 * 
 */
@SuppressWarnings("serial")
public class GetDateTag extends TagSupport {

	private String locale;

	public void setLocale(String locale) {
		this.locale = locale;
	}

	private Locale loc;

	/**
	 * This method prints the current date.
	 * 
	 * @return SKIP_BODY
	 * @throws JspException
	 *             a JspException
	 */
	@Override
	public int doStartTag() throws JspException {
		if ("ru".equalsIgnoreCase(locale)) {
			loc = new Locale("ru", "RU");
		} else {
			loc = new Locale("en", "EN");
		}
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		DateFormat dateFormat = DateFormat
				.getDateInstance(DateFormat.FULL, loc);
		String time = "<hr/><b> " + dateFormat.format(gc.getTime())
				+ " </b><hr/>";
		try {
			JspWriter out = pageContext.getOut();
			out.write(time);
		} catch (IOException e) {
			throw new JspException(e.getMessage());
		}
		return SKIP_BODY;
	}

	/**
	 * @return EVAL_PAGE
	 * @throws JspException
	 *             a JspException
	 */
	@Override
	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}
}