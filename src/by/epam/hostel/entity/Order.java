package by.epam.hostel.entity;

import java.util.Date;

/**
 * This is the class of the business object acting as a storage database table
 * Orders.
 * 
 * @author Alex Nastin
 */
public class Order extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4982171589940820673L;

	private int idOrder;
	private int usersIdUser;
	private int roomsIdRoom;
	private Date arrival;
	private Date departure;
	private User user;
	private Room room;
	private boolean paid;

	public Order() {
	}

	public Order(int idOrder, int usersIdUser, int roomsIdRoom, Date arrival,
			Date departure, boolean paid) {
		super();
		this.idOrder = idOrder;
		this.usersIdUser = usersIdUser;
		this.roomsIdRoom = roomsIdRoom;
		this.arrival = arrival;
		this.departure = departure;
		this.paid = paid;
	}

	public Order(int idOrder, Date arrival, Date departure, User user,
			Room room, boolean paid) {
		super();
		this.idOrder = idOrder;
		this.arrival = arrival;
		this.departure = departure;
		this.user = user;
		this.room = room;
		this.paid = paid;
	}

	public int getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	public int getUsersIdUser() {
		return usersIdUser;
	}

	public void setUsersIdUser(int usersIdUser) {
		this.usersIdUser = usersIdUser;
	}

	public int getRoomsIdRoom() {
		return roomsIdRoom;
	}

	public void setRoomsIdRoom(int roomsIdRoom) {
		this.roomsIdRoom = roomsIdRoom;
	}

	public Date getArrival() {
		return arrival;
	}

	public void setArrival(Date arrival) {
		this.arrival = arrival;
	}

	public Date getDeparture() {
		return departure;
	}

	public void setDeparture(Date departure) {
		this.departure = departure;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arrival == null) ? 0 : arrival.hashCode());
		result = prime * result
				+ ((departure == null) ? 0 : departure.hashCode());
		result = prime * result + idOrder;
		result = prime * result + (paid ? 1231 : 1237);
		result = prime * result + ((room == null) ? 0 : room.hashCode());
		result = prime * result + roomsIdRoom;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + usersIdUser;
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
		Order other = (Order) obj;
		if (arrival == null) {
			if (other.arrival != null) {
				return false;
			}
		} else if (!arrival.equals(other.arrival)) {
			return false;
		}
		if (departure == null) {
			if (other.departure != null) {
				return false;
			}
		} else if (!departure.equals(other.departure)) {
			return false;
		}
		if (idOrder != other.idOrder) {
			return false;
		}
		if (paid != other.paid) {
			return false;
		}
		if (room == null) {
			if (other.room != null) {
				return false;
			}
		} else if (!room.equals(other.room)) {
			return false;
		}
		if (roomsIdRoom != other.roomsIdRoom) {
			return false;
		}
		if (user == null) {
			if (other.user != null) {
				return false;
			}
		} else if (!user.equals(other.user)) {
			return false;
		}
		if (usersIdUser != other.usersIdUser) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Order [idOrder=" + idOrder + ", usersIdUser=" + usersIdUser
				+ ", roomsIdRoom=" + roomsIdRoom + ", arrival=" + arrival
				+ ", departure=" + departure + ", user=" + user + ", room="
				+ room + ", paid=" + paid + "]";
	}

}
