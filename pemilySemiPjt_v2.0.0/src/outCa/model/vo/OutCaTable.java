package outCa.model.vo;

public class OutCaTable {
	private int outcaNo;
	private String outcaMember;
	private int outcaPrice;
	private int outcaStore;
	private String outcaEmp;
	public OutCaTable() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OutCaTable(int outcaNo, String outcaMember, int outcaPrice, int outcaStore, String outcaEmp) {
		super();
		this.outcaNo = outcaNo;
		this.outcaMember = outcaMember;
		this.outcaPrice = outcaPrice;
		this.outcaStore = outcaStore;
		this.outcaEmp = outcaEmp;
	}
	public int getOutcaNo() {
		return outcaNo;
	}
	public void setOutcaNo(int outcaNo) {
		this.outcaNo = outcaNo;
	}
	public String getOutcaMember() {
		return outcaMember;
	}
	public void setOutcaMember(String outcaMember) {
		this.outcaMember = outcaMember;
	}
	public int getOutcaPrice() {
		return outcaPrice;
	}
	public void setOutcaPrice(int outcaPrice) {
		this.outcaPrice = outcaPrice;
	}
	public int getOutcaStore() {
		return outcaStore;
	}
	public void setOutcaStore(int outcaStore) {
		this.outcaStore = outcaStore;
	}
	public String getOutcaEmp() {
		return outcaEmp;
	}
	public void setOutcaEmp(String outcaEmp) {
		this.outcaEmp = outcaEmp;
	}
	
	
}
