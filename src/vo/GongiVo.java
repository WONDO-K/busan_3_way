package vo;

public class GongiVo {
	
	// Field
	private int    notice_idx;
	private String notice_member_id;
	private String notice_title;
	private String notice_cont;
	private int    notice_readcount;
	private String notice_regdate;
	
	// Constructor
	public GongiVo() {
		
	}
	public GongiVo(int notice_idx, String notice_member_id, String notice_title, String notice_cont,
			int notice_readcount, String notice_regdate) {
		super();
		this.notice_idx = notice_idx;
		this.notice_member_id = notice_member_id;
		this.notice_title = notice_title;
		this.notice_cont = notice_cont;
		this.notice_readcount = notice_readcount;
		this.notice_regdate = notice_regdate;
	}
	
	// Getter / Setter
	public int getNotice_idx() {
		return notice_idx;
	}
	public void setNotice_idx(int notice_idx) {
		this.notice_idx = notice_idx;
	}
	public String getNotice_member_id() {
		return notice_member_id;
	}
	public void setNotice_member_id(String notice_member_id) {
		this.notice_member_id = notice_member_id;
	}
	public String getNotice_title() {
		return notice_title;
	}
	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}
	public String getNotice_cont() {
		return notice_cont;
	}
	public void setNotice_cont(String notice_cont) {
		this.notice_cont = notice_cont;
	}
	public int getNotice_readcount() {
		return notice_readcount;
	}
	public void setNotice_readcount(int notice_readcount) {
		this.notice_readcount = notice_readcount;
	}
	public String getNotice_regdate() {
		return notice_regdate;
	}
	public void setNotice_regdate(String notice_regdate) {
		this.notice_regdate = notice_regdate;
	}
	
	// toString
	@Override
	public String toString() {
		return "GongiVo [notice_idx=" + notice_idx + ", notice_member_id=" + notice_member_id + ", notice_title="
				+ notice_title + ", notice_cont=" + notice_cont + ", notice_readcount=" + notice_readcount
				+ ", notice_regdate=" + notice_regdate + "]";
	}
	
	
}
