package Model;

public class Blog {
	
	private int blogID;
	private String bname;
	private String authname;
	private String desc;
	private String content;
	private String category;
	private String tags;
	
	public Blog() {
		
	}
	
	public Blog(int ID,String bname, String authname,String Content, String desc, String category, String tags) {
		this.blogID=ID;
		this.bname=bname;
		this.authname=authname;
		this.content=Content;
		this.category=category;
		this.desc=desc;
		this.tags=tags;
	}

	public int getBlogID() {
		return blogID;
	}

	public void setBlogID(int blogID) {
		this.blogID = blogID;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getAuthname() {
		return authname;
	}

	public void setAuthname(String authname) {
		this.authname = authname;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}
	
}
