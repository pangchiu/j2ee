package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.User;

public class DBUtil {
	String username = "root";
	String password = "";
	String connectionURL = "jdbc:mysql://" + "localhost" + ":3306/" + "j2ee?useSSL=true" ;


	public DBUtil() {

	}

	public Connection getConnetion() throws SQLException, ClassNotFoundException {

		Class.forName("com.mysql.jdbc.Driver");

		return DriverManager.getConnection(connectionURL,username,password);
	}

	public boolean creatUser(User user) {
		String sql = "INSERT INTO user (username,password)  VALUES (?,?)";
		try {
			Connection conn = getConnetion();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());

			return preparedStatement.execute();

		} catch (Exception e) {
			return false;
		}

	}

	public boolean deleteUser(int id) {
		String sql = "DELETE FROM user WHERE id = ?";
		try {
			Connection conn = getConnetion();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);

			return preparedStatement.execute();

		} catch (Exception e) {
			return false;
		}
	}
	
	
	public boolean editUser(User user) {
		String sql = "UPDATE user SET username=? ,password=? WHERE id=?";
		try {
			Connection conn = getConnetion();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setInt(3,user.getId());

			return preparedStatement.execute();

		} catch (Exception e) {
			return false;
		}
	}

	public List<User> getAllUser() {

		String sql = "SELECT * FROM user ";
		List<User> users = new ArrayList<User>();
		try {
			Connection conn = getConnetion();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				users.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}

		} catch (Exception e) {
		 System.out.println(e.getMessage());
		}
		return users;
	}

	public List<User> findByName(String key) {

		String top = "SELECT * FROM user where username = N'%";
		String sql = top + key + "'";
		List<User> users = new ArrayList<User>();
		try {
			Connection conn = getConnetion();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				users.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}

		} catch (Exception e) {

		}
		return users;

	}
}
