package vo;

public class ReviewMVo {

	// Field
	private int r_idx;
	private String mem_id;
	private String r_cont;
	private int score;
	private int store_id;

	// Constructor
	public ReviewMVo() {
		
	}
	public ReviewMVo(int r_idx, String mem_id, String r_cont, int score, int store_id) {
		super();
		this.r_idx = r_idx;
		this.mem_id = mem_id;
		this.r_cont = r_cont;
		this.score = score;
		this.store_id = store_id;
	}
	
	// Getter / Setter
	public int getR_idx() {
		return r_idx;
	}
	public void setR_idx(int r_idx) {
		this.r_idx = r_idx;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getR_cont() {
		return r_cont;
	}
	public void setR_cont(String r_cont) {
		this.r_cont = r_cont;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getStore_id() {
		return store_id;
	}
	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}
	
	// toString
	@Override
	public String toString() {
		return "Review [r_idx=" + r_idx + ", mem_id=" + mem_id + ", r_cont=" + r_cont + ", score=" + score
				+ ", store_id=" + store_id + "]";
	}
	
	
	
	
	
}
