package s02_member;

public class Membership {
	private String userid;
	private String passwd;
	private String name;
	private String email;
	
	//생성자
	public Membership() {
		super();
	}
	public Membership(String userid, String passwd, String name, String email) {
		super();
		this.userid = userid;
		this.passwd = passwd;
		this.name = name;
		this.email = email;
	}
	
	//게터만든이유 : 나중에 호출하려고
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	@Override
	public String toString() {
		return "Membership [userid=" + userid + ", passwd=" + passwd + ", name=" + name + ", email=" + email + "]";
	}
	
	
}