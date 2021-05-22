package order.model.vo;

public class Product {
	
	private int pdNo;
	private String pdName;
	private int pdPrice;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int pdNo, String pdName, int pdPrice) {
		super();
		this.pdNo = pdNo;
		this.pdName = pdName;
		this.pdPrice = pdPrice;
	}
	public int getPdNo() {
		return pdNo;
	}
	public void setPdNo(int pdNo) {
		this.pdNo = pdNo;
	}
	public String getPdName() {
		return pdName;
	}
	public void setPdName(String pdName) {
		this.pdName = pdName;
	}
	public int getPdPrice() {
		return pdPrice;
	}
	public void setPdPrice(int pdPrice) {
		this.pdPrice = pdPrice;
	}
	
	

}
