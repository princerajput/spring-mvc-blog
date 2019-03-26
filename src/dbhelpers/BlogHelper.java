package dbhelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Blog;

public class BlogHelper {
		
	private Connection conn;
	private ResultSet rs;
	
	public BlogHelper() {
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
	
	public boolean insert(Blog blog,String curuser) {
		
		String query = "insert into " + Util.blogtbl + 
				"(" + 
				Util.blog_bname + "," +
				Util.blog_authname + "," +
				Util.blog_desc + "," +
				Util.blog_category + "," +
				Util.blog_tags + "," +
				Util.blog_content +
				") "+ 
				"values(";
		query += "\"" + blog.getBname() + "\"" + ",";
		query += "\"" + curuser + "\"" + ",";
		query += "\"" + blog.getDesc() + "\"" + ",";
		query += "\"" + blog.getCategory() + "\"" + ",";
		query += "\"" + blog.getTags() + "\"" + ",";
		query += "\"" + blog.getContent() + "\"" + ");";		
		
		System.out.println(query);
		try {
			PreparedStatement ps = this.conn.prepareStatement(query);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Sql exeption occured in insert of Blog (DEBUG)");
			return false;
		}
		return true;
	}
	
	public ArrayList<Blog> select(){
		ArrayList<Blog> ret = new ArrayList<>();
		
		String query = "select * from " + Util.blogtbl + ";";
		
		try {
			this.rs = this.conn.prepareStatement(query).executeQuery();
			while(rs.next()) {
				ret.add(new Blog(rs.getInt(Util.blog_id),rs.getString(Util.blog_bname),
						rs.getString(Util.blog_authname),
						rs.getString(Util.blog_content),
						rs.getString(Util.blog_desc),
						rs.getString(Util.blog_category),
						rs.getString(Util.blog_tags)
						));
				
			}
		} catch (SQLException e) {
			System.out.println("Sql exeption occured in select of Blog (DEBUG)");
			return null;
		}
		
		return ret;
	}
	
	public ArrayList<Blog> select1(){
		ArrayList<Blog> ret = new ArrayList<>();
		
		String query = "select * from " + Util.blogtbl + " where " + Util.blog_category + " = 'Educational';";
		
		try {
			this.rs = this.conn.prepareStatement(query).executeQuery();
			while(rs.next()) {
				ret.add(new Blog(rs.getInt(Util.blog_id),rs.getString(Util.blog_bname),
						rs.getString(Util.blog_authname),
						rs.getString(Util.blog_content),
						rs.getString(Util.blog_desc),
						rs.getString(Util.blog_category),
						rs.getString(Util.blog_tags)
						));
				
			}
		} catch (SQLException e) {
			System.out.println("Sql exeption occured in select of Blog (DEBUG)");
			return null;
		}
		
		return ret;
	}
	
	public ArrayList<Blog> select2(){
		ArrayList<Blog> ret = new ArrayList<>();
		
		String query = "select * from " + Util.blogtbl + " where " + Util.blog_category + " = 'Entertainment';";
		
		try {
			this.rs = this.conn.prepareStatement(query).executeQuery();
			while(rs.next()) {
				ret.add(new Blog(rs.getInt(Util.blog_id),rs.getString(Util.blog_bname),
						rs.getString(Util.blog_authname),
						rs.getString(Util.blog_content),
						rs.getString(Util.blog_desc),
						rs.getString(Util.blog_category),
						rs.getString(Util.blog_tags)
						));
				
			}
		} catch (SQLException e) {
			System.out.println("Sql exeption occured in select of Blog (DEBUG)");
			return null;
		}
		
		return ret;
	}
	
	public int getId(Blog blog) {
		int id = -1;
		String query = "select * from " + Util.blogtbl + " where " + 
		Util.blog_bname + " = " + Util.addquotes(blog.getBname()) + " and " +
		Util.blog_authname + " = " + Util.addquotes(blog.getAuthname()) + " and " +
		Util.blog_desc + " = " + Util.addquotes(blog.getDesc()) + " and " +
		Util.blog_category + " = " + Util.addquotes(blog.getCategory()) + " and " +
		Util.blog_tags + " = " + Util.addquotes(blog.getTags()) + " and " +
		Util.blog_content + " = " + Util.addquotes(blog.getContent());
	
		System.out.println(query);
		
		try {
			this.rs = this.conn.prepareStatement(query).executeQuery();
			while(rs.next()) {
				id = rs.getInt("BlogID");
			}
		} catch (SQLException e) {
			System.out.println("Sql exeption occured in select of Blog (DEBUG)");
			return id;
		}
		
		return id;
	}
	
	public Blog getById(int id) {
		String query = "select * from " + Util.blogtbl + " where " + 
		"BlogID" + " = " + id + " ;";
		System.out.println(query);
		try {
			this.rs = this.conn.prepareStatement(query).executeQuery();
			while(rs.next()) {
				return new Blog(rs.getInt(Util.blog_id),rs.getString(Util.blog_bname),
						rs.getString(Util.blog_authname),
						rs.getString(Util.blog_content),
						rs.getString(Util.blog_desc),
						rs.getString(Util.blog_category),
						rs.getString(Util.blog_tags)
						);			
			}
		} catch (SQLException e) {
			System.out.println("Sql exeption occured in select of Blog (DEBUG)");
			return null;
		}
		return null;
	}
	
	
}
