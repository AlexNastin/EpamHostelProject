package by.epam.hostel.entity;

/**
 * This is the class of the business object acting as a storage database table
 * Login.
 * 
 * @author Alex Nastin
 */
public class Login extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 869263177225053864L;

	private int idUser;
	private String login;
	private int password;
	private boolean status;
	private boolean blacklist;

	public Login(int idUser, String login, int password, boolean status,
			boolean blacklist) {
		super();
		this.idUser = idUser;
		this.login = login;
		this.password = password;
		this.status = status;
		this.blacklist = blacklist;
	}

	public Login() {
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean isBlacklist() {
		return blacklist;
	}

	public void setBlacklist(boolean blacklist) {
		this.blacklist = blacklist;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (blacklist ? 1231 : 1237);
		result = prime * result + idUser;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + password;
		result = prime * result + (status ? 1231 : 1237);
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
		Login other = (Login) obj;
		if (blacklist != other.blacklist) {
			return false;
		}
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
		if (password != other.password) {
			return false;
		}
		if (status != other.status) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Login [idUser=" + idUser + ", login=" + login + ", password="
				+ password + ", status=" + status + ", blacklist=" + blacklist
				+ "]";
	}

}
