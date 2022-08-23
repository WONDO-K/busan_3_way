package vo;

public class QnaVo {
	
	// Field
	private int    qna_idx;
	private String qna_member_id;
	private String qna_title;
	private String qna_cont;
	private int    qna_readcount;
	private String qna_regdate;
	
	// Constructor
	public QnaVo() {
		
	}
	public QnaVo(int qna_idx, String qna_member_id, String qna_title, String qna_cont, int qna_readcount,
			String qna_regdate) {
		super();
		this.qna_idx = qna_idx;
		this.qna_member_id = qna_member_id;
		this.qna_title = qna_title;
		this.qna_cont = qna_cont;
		this.qna_readcount = qna_readcount;
		this.qna_regdate = qna_regdate;
	}
	
	public QnaVo(String member_id, String qna_title, String qna_cont) {
		this.qna_member_id = qna_member_id;
		this.qna_title = qna_title;
		this.qna_cont = qna_cont;
	}
	// Getter / Setter
	public int getQna_idx() {
		return qna_idx;
	}
	public void setQna_idx(int qna_idx) {
		this.qna_idx = qna_idx;
	}
	public String getQna_member_id() {
		return qna_member_id;
	}
	public void setQna_member_id(String qna_member_id) {
		this.qna_member_id = qna_member_id;
	}
	public String getQna_title() {
		return qna_title;
	}
	public void setQna_title(String qna_title) {
		this.qna_title = qna_title;
	}
	public String getQna_cont() {
		return qna_cont;
	}
	public void setQna_cont(String qna_cont) {
		this.qna_cont = qna_cont;
	}
	public int getQna_readcount() {
		return qna_readcount;
	}
	public void setQna_readcount(int qna_readcount) {
		this.qna_readcount = qna_readcount;
	}
	public String getQna_regdate() {
		return qna_regdate;
	}
	public void setQna_regdate(String qna_regdate) {
		this.qna_regdate = qna_regdate;
	}
	
	// toString
	@Override
	public String toString() {
		return "QnaVo [qna_idx=" + qna_idx + ", qna_member_id=" + qna_member_id + ", qna_title=" + qna_title
				+ ", qna_cont=" + qna_cont + ", qna_readcount=" + qna_readcount + ", qna_regdate=" + qna_regdate + "]";
	}
	
	
	
}
