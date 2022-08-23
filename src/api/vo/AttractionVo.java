package api.vo;

public class AttractionVo {
	private String attraction_id;
	private String attraction_name;
	private String attraction_gugun;
	private String attraction_place;
	private String attraction_title;
	private String attraction_subtitle;
	private String attraction_addr1;
	private String attraction_tel;
	private String attraction_site;
	private String attraction_trfc_info;
	private String attraction_usageday;
	private String attraction_hldy_info;
	private String attraction_time;
	private String attraction_usage_amount;
	private String attraction_convenient;
	private String attraction_img;
	private String attraction_thumb;
	private String attraction_cont;
	private String attraction_cont1;
	private String attraction_cont2;
	private String attraction_cont3;
	private String attraction_cont4;
	private String attraction_good;
	private String attraction_bad;
	
	public AttractionVo() {
		
	}
	
	public AttractionVo( String attraction_cont1, String attraction_cont2,String attraction_cont3, String attraction_cont4) {
		this.attraction_cont1 = attraction_cont1;
		this.attraction_cont2 = attraction_cont2;
		this.attraction_cont3 = attraction_cont3;
		this.attraction_cont4 = attraction_cont4;
	}
	public AttractionVo(String attraction_id, String attraction_name, String attraction_gugun, String attraction_place,
			String attraction_title, String attraction_subtitle, String attraction_addr1, String attraction_tel,
			String attraction_site, String attraction_trfc_info, String attraction_usageday,
			String attraction_hldy_info, String attraction_time, String attraction_usage_amount,
			String attraction_convenient, String attraction_img, String attraction_thumb, String attraction_cont1, String attraction_cont2,String attraction_cont3, String attraction_cont4,
			String attraction_good,String attraction_bad) {
		
		this.attraction_id = attraction_id;
		this.attraction_name = attraction_name;
		this.attraction_gugun = attraction_gugun;
		this.attraction_place = attraction_place;
		this.attraction_title = attraction_title;
		this.attraction_subtitle = attraction_subtitle;
		this.attraction_addr1 = attraction_addr1;
		this.attraction_tel = attraction_tel;
		this.attraction_site = attraction_site;
		this.attraction_trfc_info = attraction_trfc_info;
		this.attraction_usageday = attraction_usageday;
		this.attraction_hldy_info = attraction_hldy_info;
		this.attraction_time = attraction_time;
		this.attraction_usage_amount = attraction_usage_amount;
		this.attraction_convenient = attraction_convenient;
		this.attraction_img = attraction_img;
		this.attraction_thumb = attraction_thumb;
		this.attraction_cont1 = attraction_cont1;
		this.attraction_cont2 = attraction_cont2;
		this.attraction_cont3 = attraction_cont3;
		this.attraction_cont4 = attraction_cont4;
		this.attraction_good = attraction_good;
		this.attraction_bad = attraction_bad;
	}
	public AttractionVo(String attraction_id, String attraction_name, String attraction_gugun, String attraction_place,
			String attraction_title, String attraction_subtitle, String attraction_addr1, String attraction_tel,
			String attraction_site, String attraction_trfc_info, String attraction_usageday,
			String attraction_hldy_info, String attraction_time, String attraction_usage_amount,
			String attraction_convenient, String attraction_img, String attraction_thumb, String attraction_cont /*String attraction_cont2*/) {
		
		this.attraction_id = attraction_id;
		this.attraction_name = attraction_name;
		this.attraction_gugun = attraction_gugun;
		this.attraction_place = attraction_place;
		this.attraction_title = attraction_title;
		this.attraction_subtitle = attraction_subtitle;
		this.attraction_addr1 = attraction_addr1;
		this.attraction_tel = attraction_tel;
		this.attraction_site = attraction_site;
		this.attraction_trfc_info = attraction_trfc_info;
		this.attraction_usageday = attraction_usageday;
		this.attraction_hldy_info = attraction_hldy_info;
		this.attraction_time = attraction_time;
		this.attraction_usage_amount = attraction_usage_amount;
		this.attraction_convenient = attraction_convenient;
		this.attraction_img = attraction_img;
		this.attraction_thumb = attraction_thumb;
		this.attraction_cont = attraction_cont;
	}
	public String getAttraction_id() {
		return attraction_id;
	}
	public void setAttraction_id(String attraction_id) {
		this.attraction_id = attraction_id;
	}
	public String getAttraction_name() {
		return attraction_name;
	}
	public void setAttraction_name(String attraction_name) {
		this.attraction_name = attraction_name;
	}
	public String getAttraction_gugun() {
		return attraction_gugun;
	}
	public void setAttraction_gugun(String attraction_gugun) {
		this.attraction_gugun = attraction_gugun;
	}
	public String getAttraction_place() {
		return attraction_place;
	}
	public void setAttraction_place(String attraction_place) {
		this.attraction_place = attraction_place;
	}
	public String getAttraction_title() {
		return attraction_title;
	}
	public void setAttraction_title(String attraction_title) {
		this.attraction_title = attraction_title;
	}
	public String getAttraction_subtitle() {
		return attraction_subtitle;
	}
	public void setAttraction_subtitle(String attraction_subtitle) {
		this.attraction_subtitle = attraction_subtitle;
	}
	public String getAttraction_addr1() {
		return attraction_addr1;
	}
	public void setAttraction_addr1(String attraction_addr1) {
		this.attraction_addr1 = attraction_addr1;
	}
	public String getAttraction_tel() {
		return attraction_tel;
	}
	public void setAttraction_tel(String attraction_tel) {
		this.attraction_tel = attraction_tel;
	}
	public String getAttraction_site() {
		return attraction_site;
	}
	public void setAttraction_site(String attraction_site) {
		this.attraction_site = attraction_site;
	}
	public String getAttraction_trfc_info() {
		return attraction_trfc_info;
	}
	public void setAttraction_trfc_info(String attraction_trfc_info) {
		this.attraction_trfc_info = attraction_trfc_info;
	}
	public String getAttraction_usageday() {
		return attraction_usageday;
	}
	public void setAttraction_usageday(String attraction_usageday) {
		this.attraction_usageday = attraction_usageday;
	}
	public String getAttraction_hldy_info() {
		return attraction_hldy_info;
	}
	public void setAttraction_hldy_info(String attraction_hldy_info) {
		this.attraction_hldy_info = attraction_hldy_info;
	}
	public String getAttraction_time() {
		return attraction_time;
	}
	public void setAttraction_time(String attraction_time) {
		this.attraction_time = attraction_time;
	}
	public String getAttraction_usage_amount() {
		return attraction_usage_amount;
	}
	public void setAttraction_usage_amount(String attraction_usage_amount) {
		this.attraction_usage_amount = attraction_usage_amount;
	}
	public String getAttraction_convenient() {
		return attraction_convenient;
	}
	public void setAttraction_convenient(String attraction_convenient) {
		this.attraction_convenient = attraction_convenient;
	}
	public String getAttraction_img() {
		return attraction_img;
	}
	public void setAttraction_img(String attraction_img) {
		this.attraction_img = attraction_img;
	}
	public String getAttraction_thumb() {
		return attraction_thumb;
	}
	public void setAttraction_thumb(String attraction_thumb) {
		this.attraction_thumb = attraction_thumb;
	}
	public String getAttraction_cont() {
		return attraction_cont;
	}
	public void setAttraction_cont(String attraction_cont) {
		this.attraction_cont = attraction_cont;
	}
	public String getAttraction_cont1() {
		return attraction_cont1;
	}
	public void setAttraction_cont1(String attraction_cont1) {
		this.attraction_cont1 = attraction_cont1;
	}
	public String getAttraction_cont2() {
		return attraction_cont2;
	}
	public void setAttraction_cont2(String attraction_cont2) {
		this.attraction_cont2 = attraction_cont2;
	}
	public String getAttraction_cont3() {
		return attraction_cont3;
	}
	public void setAttraction_cont3(String attraction_cont3) {
		this.attraction_cont3 = attraction_cont3;
	}
	public String getAttraction_cont4() {
		return attraction_cont4;
	}
	public void setAttraction_cont4(String attraction_cont4) {
		this.attraction_cont4 = attraction_cont4;
	}
	public String getAttraction_good() {
		return attraction_good;
	}
	public void setAttraction_good(String attraction_good) {
		this.attraction_good = attraction_good;
	}
	public String getAttraction_bad() {
		return attraction_good;
	}
	public void setAttraction_bad(String attraction_bad) {
		this.attraction_bad = attraction_bad;
	}

	@Override
	public String toString() {
		return "AttractionVo [attraction_id=" + attraction_id + ", attraction_name=" + attraction_name
				+ ", attraction_gugun=" + attraction_gugun + ", attraction_place=" + attraction_place
				+ ", attraction_title=" + attraction_title + ", attraction_subtitle=" + attraction_subtitle
				+ ", attraction_addr1=" + attraction_addr1 + ", attraction_tel=" + attraction_tel + ", attraction_site="
				+ attraction_site + ", attraction_trfc_info=" + attraction_trfc_info + ", attraction_usageday="
				+ attraction_usageday + ", attraction_hldy_info=" + attraction_hldy_info + ", attraction_time="
				+ attraction_time + ", attraction_usage_amount=" + attraction_usage_amount + ", attraction_convenient="
				+ attraction_convenient + ", attraction_img=" + attraction_img + ", attraction_thumb="
				+ attraction_thumb + ", attraction_cont=" + attraction_cont + ", attraction_cont1=" + attraction_cont1
				+ ", attraction_cont2=" + attraction_cont2 + ", attraction_cont3=" + attraction_cont3
				+ ", attraction_cont4=" + attraction_cont4 + ", attraction_good=" + attraction_good
				+ ", attraction_bad=" + attraction_bad + "]";
	}

}
