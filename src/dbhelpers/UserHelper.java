package dbhelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.User;

public class UserHelper {
		
	private Connection conn;
	private ResultSet rs;
	
	public UserHelper() {
		String url = "jdbc:mysql://node42197-thecollegefever.cloud.cms500.com/" + Util.dbname;
//		String url = "jdbc:mysql://localhost:3306/" + Util.dbname;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.conn = DriverManager.getConnection(url, Util.user, Util.passwd);
		} catch (ClassNotFoundException e) {
			System.out.println("Unable to setup Driver (DEBUG)");
		} catch (SQLException e) {
			System.out.println("Sql exeption occured (DEBUG)");
		}
	}
	
	public boolean insert(User user) {
		
		String query = "insert into " + Util.usertbl + 
				"(" + 
				Util.user_username + "," +
				Util.user_name + "," +
				Util.user_password  +
				") "+ 
				"values(";
		query += "\"" + user.getUsername() + "\"" + ",";
		query += "\"" + user.getName() + "\"" + ",";
		query += "\"" + user.getPassword() + "\"" + ");";		
		
		System.out.println(query);
		try {
			PreparedStatement ps = this.conn.prepareStatement(query);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Sql exeption occured in insert of user (DEBUG)");
			return false;
		}
		return true;
	}
	
	public ArrayList<User> select(){
		ArrayList<User> ret = new ArrayList<>();
		
		String query = "select * from " + Util.usertbl + ";";
		
		try {
			this.rs = this.conn.prepareStatement(query).executeQuery();
			while(rs.next()) {
				ret.add(new User(rs.getString(Util.user_username),rs.getString(Util.user_name),
						rs.getString(Util.user_password)));				
			}
		} catch (SQLException e) {
			System.out.println("Sql exeption occured in select of user (DEBUG)");
			return null;
		}
		
		return ret;
	}
	
	public String getId(User user) {
		String id = "";
		String query = "select * from " + Util.usertbl + " where " + 
		Util.user_name + " = " + Util.addquotes(user.getName()) + " and " +
		Util.user_password + " = " + Util.addquotes(user.getPassword());	
		System.out.println(query);
		
		try {
			this.rs = this.conn.prepareStatement(query).executeQuery();
			while(rs.next()) {
				id = rs.getString("Username");
			}
		} catch (SQLException e) {
			System.out.println("Sql exeption occured in select of user (DEBUG)");
			return id;
		}
		
		return id;
	}
	
	public User getById(String id) {
		String query = "select * from " + Util.usertbl + " where " + 
		"Username" + " = " + Util.addquotes(id) + " ;";
		System.out.println(query);
		try {
			this.rs = this.conn.prepareStatement(query).executeQuery();
			while(rs.next()) {
				return new User(rs.getString(Util.user_username),rs.getString(Util.user_name),
						rs.getString(Util.user_password));				
			}
		} catch (SQLException e) {
			System.out.println("Sql exeption occured in select of user (DEBUG)");
			return null;
		}
		return null;
	}
	
}
