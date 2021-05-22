package inca.model.vo;

public class Inca {
	private int incaNo;
	private int incaAn;
	private String incaName;
	private String incaGender;
	private int incaMonth;
	private int incaCondition;
	private int incaPrice;
	private String incaDate;
	private int incaStore;
	private String incaPic;
	private String incaPath;
	private int Sort;
	public Inca() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Inca(int incaNo, int incaAn, String incaName, String incaGender, int incaMonth, int incaCondition,
			int incaPrice, String incaDate, int incaStore, String incaPic, String incaPath, int sort) {
		super();
		this.incaNo = incaNo;
		this.incaAn = incaAn;
		this.incaName = incaName;
		this.incaGender = incaGender;
		this.incaMonth = incaMonth;
		this.incaCondition = incaCondition;
		this.incaPrice = incaPrice;
		this.incaDate = incaDate;
		this.incaStore = incaStore;
		this.incaPic = incaPic;
		this.incaPath = incaPath;
		Sort = sort;
	}
	public int getIncaNo() {
		return incaNo;
	}
	public void setIncaNo(int incaNo) {
		this.incaNo = incaNo;
	}
	public int getIncaAn() {
		return incaAn;
	}
	public void setIncaAn(int incaAn) {
		this.incaAn = incaAn;
	}
	public String getIncaName() {
		return incaName;
	}
	public void setIncaName(String incaName) {
		this.incaName = incaName;
	}
	public String getIncaGender() {
		return incaGender;
	}
	public void setIncaGender(String incaGender) {
		this.incaGender = incaGender;
	}
	public int getIncaMonth() {
		return incaMonth;
	}
	public void setIncaMonth(int incaMonth) {
		this.incaMonth = incaMonth;
	}
	public int getIncaCondition() {
		return incaCondition;
	}
	public void setIncaCondition(int incaCondition) {
		this.incaCondition = incaCondition;
	}
	public int getIncaPrice() {
		return incaPrice;
	}
	public void setIncaPrice(int incaPrice) {
		this.incaPrice = incaPrice;
	}
	public String getIncaDate() {
		return incaDate;
	}
	public void setIncaDate(String incaDate) {
		this.incaDate = incaDate;
	}
	public int getIncaStore() {
		return incaStore;
	}
	public void setIncaStore(int incaStore) {
		this.incaStore = incaStore;
	}
	public String getIncaPic() {
		return incaPic;
	}
	public void setIncaPic(String incaPic) {
		this.incaPic = incaPic;
	}
	public String getIncaPath() {
		return incaPath;
	}
	public void setIncaPath(String incaPath) {
		this.incaPath = incaPath;
	}
	public int getSort() {
		return Sort;
	}
	public void setSort(int sort) {
		Sort = sort;
	}
}
