package by.epam.hostel.entity;
/**
 * This is the class of the business object acting as a storage database table
 * Rooms.
 * 
 * @author Alex Nastin
 */
public class Room extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7850899406976248706L;

	private int idRoom;
	private double price;
	private int capacity;
	private Category category;
	private boolean isDeleted;

	public Room() {
	}

	public Room(int idRoom, double price, int capacity, Category category,
			boolean isDeleted) {
		super();
		this.idRoom = idRoom;
		this.price = price;
		this.capacity = capacity;
		this.category = category;
		this.isDeleted = isDeleted;
	}

	public Room(int idRoom, double price, int capacity, Category category) {
		super();
		this.idRoom = idRoom;
		this.price = price;
		this.capacity = capacity;
		this.category = category;
	}

	public int getIdRoom() {
		return idRoom;
	}

	public void setIdRoom(int idRoom) {
		this.idRoom = idRoom;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + capacity;
		result = prime * result
				+ ((category == null) ? 0 : category.hashCode());
		result = prime * result + idRoom;
		result = prime * result + (isDeleted ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Room other = (Room) obj;
		if (capacity != other.capacity) {
			return false;
		}
		if (category != other.category) {
			return false;
		}
		if (idRoom != other.idRoom) {
			return false;
		}
		if (isDeleted != other.isDeleted) {
			return false;
		}
		if (Double.doubleToLongBits(price) != Double
				.doubleToLongBits(other.price)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Room [idRoom=" + idRoom + ", price=" + price + ", capacity="
				+ capacity + ", category=" + category + ", isDeleted="
				+ isDeleted + "]";
	}

}
