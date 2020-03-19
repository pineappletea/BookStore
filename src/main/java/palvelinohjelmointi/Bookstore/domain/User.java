package palvelinohjelmointi.Bookstore.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class User {
	// username (unique), password, email, role
	
	@Id
	@Column(name = "username", nullable = false, unique = true)
    private String username;
	
	@Column(name = "email", nullable = true)
    private String email;
	
	@Column(name = "password", nullable = false)
    private String password;
	
	@Column(name = "role", nullable = false)
    private String role;

	public User(String username, String email, String password, String role) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", email=" + email + ", password=" + password + ", role=" + role + "]";
	}

	

}
