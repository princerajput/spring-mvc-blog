package dbhelpers;

public final class Util {
	// Database used
	public static final String dbname = "main";
	
	// User table
	public static final String usertbl = "user";
	public static final String user_username = "Username";
	public static final String user_name = "Name";
	public static final String user_password = "Password";
	
	// Blog Table
	public static final String blogtbl = "blog";
	public static final String blog_id = "BlogID";
	public static final String blog_bname = "Blog_Name";
	public static final String blog_authname = "Author_Name";
	public static final String blog_category = "Category";
	public static final String blog_content = "Content";
	public static final String blog_tags = "Tags";
	public static final String blog_desc = "Description";
	
	//user details
	public static final String user = "root";
	public static final String passwd = "CTNlvr15555";

	public static String addquotes(String a) {
		return "\"" + a + "\"";
	}

}
