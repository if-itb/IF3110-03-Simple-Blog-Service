package entities;

public class UserDetails {
	private String name, email, username, password, user_id;
	private int role;

	public UserDetails() {
	}

	public UserDetails(String name, String email, String user_id) {
		this.name = name;
		this.email = email;
		this.user_id = user_id;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public int getRole() {
		return role;
	}

	public String getStrRole() {
		String str;
		switch (role) {
		case 10: {
			str = "Regular";
			break;
		}
		case 20: {
			str = "Editor";
			break;
		}
		case 30: {
			str = "Admin";
			break;
		}
		default: {
			str = "Unknown";
		}
		}

		return str;
	}

	public String getUserId() {
		return user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setEmail(String str) {
		email = str;
	}

	public void setName(String str) {
		name = str;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public void setUserId(String n) {
		user_id = n;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
