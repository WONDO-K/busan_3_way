package vo;

public class MemberVo {

	// Field
	private String member_id;
	private String member_pwd;
	private String member_name;
	private String member_nick_name;
	private String member_birth;
	private String member_email;
	private String member_addr;
	private String member_tel;
	private String member_joindate;
	private int member_member_level;
	
	// Constructor
	public MemberVo() {
		
	}
	public MemberVo(String member_id, String member_pwd, String member_name, String member_nick_name,
			String member_birth, String member_email, String member_addr, String member_tel, String member_joindate,
			int member_member_level) {
		super();
		this.member_id = member_id;
		this.member_pwd = member_pwd;
		this.member_name = member_name;
		this.member_nick_name = member_nick_name;
		this.member_birth = member_birth;
		this.member_email = member_email;
		this.member_addr = member_addr;
		this.member_tel = member_tel;
		this.member_joindate = member_joindate;
		this.member_member_level = member_member_level;
	}
	
	// Getter / Setter
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getMember_pwd() {
		return member_pwd;
	}
	public void setMember_pwd(String member_pwd) {
		this.member_pwd = member_pwd;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getMember_nick_name() {
		return member_nick_name;
	}
	public void setMember_nick_name(String member_nick_name) {
		this.member_nick_name = member_nick_name;
	}
	public String getMember_birth() {
		return member_birth;
	}
	public void setMember_birth(String member_birth) {
		this.member_birth = member_birth;
	}
	public String getMember_email() {
		return member_email;
	}
	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}
	public String getMember_addr() {
		return member_addr;
	}
	public void setMember_addr(String member_addr) {
		this.member_addr = member_addr;
	}
	public String getMember_tel() {
		return member_tel;
	}
	public void setMember_tel(String member_tel) {
		this.member_tel = member_tel;
	}
	public String getMember_joindate() {
		return member_joindate;
	}
	public void setMember_joindate(String member_joindate) {
		this.member_joindate = member_joindate;
	}
	public int getMember_member_level() {
		return member_member_level;
	}
	public void setMember_member_level(int member_member_level) {
		this.member_member_level = member_member_level;
	}
	
	// toString
	@Override
	public String toString() {
		return "MemberVo [member_id=" + member_id + ", member_pwd=" + member_pwd + ", member_name=" + member_name
				+ ", member_nick_name=" + member_nick_name + ", member_birth=" + member_birth + ", member_email="
				+ member_email + ", member_addr=" + member_addr + ", member_tel=" + member_tel + ", member_joindate="
				+ member_joindate + ", member_member_level=" + member_member_level + "]";
	}
	
	
	
	
}
