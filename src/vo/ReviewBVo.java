package vo;

public class ReviewBVo {

	// Field
	private int r_idx;
	private String mem_id;
	private String r_cont;
	private int score;
	private String attraction_id;

	// Constructor
	public ReviewBVo() {
		
	}
	public ReviewBVo(int r_idx, String mem_id, String r_cont, int score, String attraction_id) {
		super();
		this.r_idx = r_idx;
		this.mem_id = mem_id;
		this.r_cont = r_cont;
		this.score = score;
		this.attraction_id = attraction_id;
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
	public String getAttraction_id() {
		return attraction_id;
	}
	public void setAttraction_id(String attraction_id) {
		this.attraction_id = attraction_id;
	}
	
	// toString
	@Override
	public String toString() {
		return "Review [r_idx=" + r_idx + ", mem_id=" + mem_id + ", r_cont=" + r_cont + ", score=" + score
				+ ", store_id=" + attraction_id + "]";
	}
	
	
	
	
	
}
