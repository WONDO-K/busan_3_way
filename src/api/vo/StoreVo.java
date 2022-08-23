package api.vo;

public class StoreVo {
	private String store_id;
	private String store_name;
	private String store_gugun;
	private String store_ex;
	private String store_addr;
	private String store_addr2;
	private String store_tel;
	private String store_site;
	private String store_time;
	private String store_menu;
	private String store_img;
	private String store_thumb;
	private String store_cont;
	private String store_good;
	private String store_bad;
	
	public StoreVo() {
		
	}

	public StoreVo(String store_id, String store_name, String store_gugun, String store_ex, String store_addr,
			String store_addr2, String store_tel, String store_site, String store_time, String store_menu,
			String store_img, String store_thumb, String store_cont) {
		this.store_id = store_id;
		this.store_name = store_name;
		this.store_gugun = store_gugun;
		this.store_ex = store_ex;
		this.store_addr = store_addr;
		this.store_addr2 = store_addr2;
		this.store_tel = store_tel;
		this.store_site = store_site;
		this.store_time = store_time;
		this.store_menu = store_menu;
		this.store_img = store_img;
		this.store_thumb = store_thumb;
		this.store_cont = store_cont;
	}
	
	public StoreVo(String store_id, String store_name, String store_gugun, String store_ex, String store_addr,
			String store_addr2, String store_tel, String store_site, String store_time, String store_menu,
			String store_img, String store_thumb, String store_cont, String store_good, String store_bad) {
		super();
		this.store_id = store_id;
		this.store_name = store_name;
		this.store_gugun = store_gugun;
		this.store_ex = store_ex;
		this.store_addr = store_addr;
		this.store_addr2 = store_addr2;
		this.store_tel = store_tel;
		this.store_site = store_site;
		this.store_time = store_time;
		this.store_menu = store_menu;
		this.store_img = store_img;
		this.store_thumb = store_thumb;
		this.store_cont = store_cont;
		this.store_good = store_good;
		this.store_bad = store_bad;
	}

	public String getStore_id() {
		return store_id;
	}

	public void setStore_id(String store_id) {
		this.store_id = store_id;
	}

	public String getStore_name() {
		return store_name;
	}

	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}

	public String getStore_gugun() {
		return store_gugun;
	}

	public void setStore_gugun(String store_gugun) {
		this.store_gugun = store_gugun;
	}

	public String getStore_ex() {
		return store_ex;
	}

	public void setStore_ex(String store_ex) {
		this.store_ex = store_ex;
	}

	public String getStore_addr() {
		return store_addr;
	}

	public void setStore_addr(String store_addr) {
		this.store_addr = store_addr;
	}

	public String getStore_addr2() {
		return store_addr2;
	}

	public void setStore_addr2(String store_addr2) {
		this.store_addr2 = store_addr2;
	}

	public String getStore_tel() {
		return store_tel;
	}

	public void setStore_tel(String store_tel) {
		this.store_tel = store_tel;
	}

	public String getStore_site() {
		return store_site;
	}

	public void setStore_site(String store_site) {
		this.store_site = store_site;
	}

	public String getStore_time() {
		return store_time;
	}

	public void setStore_time(String store_time) {
		this.store_time = store_time;
	}

	public String getStore_menu() {
		return store_menu;
	}

	public void setStore_menu(String store_menu) {
		this.store_menu = store_menu;
	}

	public String getStore_img() {
		return store_img;
	}

	public void setStore_img(String store_img) {
		this.store_img = store_img;
	}

	public String getStore_thumb() {
		return store_thumb;
	}

	public void setStore_thumb(String store_thumb) {
		this.store_thumb = store_thumb;
	}

	public String getStore_cont() {
		return store_cont;
	}

	public void setStore_cont(String store_cont) {
		this.store_cont = store_cont;
	}

	public String getStore_good() {
		return store_good;
	}

	public void setStore_good(String store_good) {
		this.store_good = store_good;
	}

	public String getStore_bad() {
		return store_bad;
	}

	public void setStore_bad(String store_bad) {
		this.store_bad = store_bad;
	}

	@Override
	public String toString() {
		return "StoreVo [store_id=" + store_id + ", store_name=" + store_name + ", store_gugun=" + store_gugun
				+ ", store_ex=" + store_ex + ", store_addr=" + store_addr + ", store_addr2=" + store_addr2
				+ ", store_tel=" + store_tel + ", store_site=" + store_site + ", store_time=" + store_time
				+ ", store_menu=" + store_menu + ", store_img=" + store_img + ", store_thumb=" + store_thumb
				+ ", store_cont=" + store_cont + ", store_good=" + store_good + ", store_bad=" + store_bad + "]";
	}

}
