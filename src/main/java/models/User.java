package models;

public class User {
	int id;
	String password;
	String username;
	
	
	public User(int id, String password, String username) {
		this.id = id;
		this.password = password;
		this.username = username;
	}
	
	public User(String password, String username) {

		this.password = password;
		this.username = username;
	}
	
	
	
	
	public User() {
		
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}
