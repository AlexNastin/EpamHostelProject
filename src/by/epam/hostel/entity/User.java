package by.epam.hostel.entity;

/**
 * This is the class of the business object acting as a storage database table
 * Users.
 * 
 * @author Alex Nastin
 */
public class User extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7887153851936630442L;

	private int idUser;
	private String name;
	private String surname;
	private String numpass;
	private Login login;

	public User() {
	}

	public User(int idUser, String name, String surname, String numpass) {
		super();
		this.idUser = idUser;
		this.name = name;
		this.surname = surname;
		this.numpass = numpass;
	}

	public User(String name, String surname, String numpass, Login login) {
		super();
		this.name = name;
		this.surname = surname;
		this.numpass = numpass;
		this.login = login;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getNumpass() {
		return numpass;
	}

	public void setNumpass(String numpass) {
		this.numpass = numpass;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idUser;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((numpass == null) ? 0 : numpass.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
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
		User other = (User) obj;
		if (idUser != other.idUser) {
			return false;
		}
		if (login == null) {
			if (other.login != null) {
				return false;
			}
		} else if (!login.equals(other.login)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (numpass == null) {
			if (other.numpass != null) {
				return false;
			}
		} else if (!numpass.equals(other.numpass)) {
			return false;
		}
		if (surname == null) {
			if (other.surname != null) {
				return false;
			}
		} else if (!surname.equals(other.surname)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", name=" + name + ", surname="
				+ surname + ", numpass=" + numpass + ", login=" + login + "]";
	}

}
