package Model;

import java.sql.Blob;

import javax.validation.constraints.Size;

public class User {
	
	private String username;
	@Size(min=1, message="Name cannot be empty")
	private String name;
	private String password;
	
	public User() {
		
	}
	
	public User(String username, String name, String password) {
		this.username=username;
		this.name=name;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
