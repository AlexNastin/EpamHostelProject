package by.epam.hostel.entity;

import java.util.Date;

/**
 * This is the class of the business object acting as a storage database table
 * BookedDates.
 * 
 * @author Alex Nastin
 */
public class BookedDate extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int idBooked;
	private int idRoom;
	private Date booking;
	private Date notBooking;

	public BookedDate() {
		super();
	}

	public BookedDate(int idBooked, int idRoom, Date booking, Date notBooking) {
		super();
		this.idBooked = idBooked;
		this.idRoom = idRoom;
		this.booking = booking;
		this.notBooking = notBooking;
	}

	public int getIdBooked() {
		return idBooked;
	}

	public void setIdBooked(int idBooked) {
		this.idBooked = idBooked;
	}

	public int getIdRoom() {
		return idRoom;
	}

	public void setIdRoom(int idRoom) {
		this.idRoom = idRoom;
	}

	public Date getBooking() {
		return booking;
	}

	public void setBooking(Date booking) {
		this.booking = booking;
	}

	public Date getNotBooking() {
		return notBooking;
	}

	public void setNotBooking(Date notBooking) {
		this.notBooking = notBooking;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((booking == null) ? 0 : booking.hashCode());
		result = prime * result + idBooked;
		result = prime * result + idRoom;
		result = prime * result
				+ ((notBooking == null) ? 0 : notBooking.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		BookedDate other = (BookedDate) obj;
		if (booking == null) {
			if (other.booking != null) {
				return false;
			}
		} else if (!booking.equals(other.booking)) {
			return false;
		}
		if (idBooked != other.idBooked) {
			return false;
		}
		if (idRoom != other.idRoom) {
			return false;
		}
		if (notBooking == null) {
			if (other.notBooking != null) {
				return false;
			}
		} else if (!notBooking.equals(other.notBooking)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "BookedDate [idBooked=" + idBooked + ", idRoom=" + idRoom
				+ ", booking=" + booking + ", notBooking=" + notBooking + "]";
	}

}
