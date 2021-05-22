package outProduct.model.vo;

public class OutPro {
	private int outProNo;
	private int outProPn;
	private String outProMi;
	private int outProAmount;
	private int outProPrice;
	private String outProDate;
	private int sort;
	public OutPro() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OutPro(int outProNo, int outProPn, String outProMi, int outProAmount, int outProPrice, String outProDate,
			int sort) {
		super();
		this.outProNo = outProNo;
		this.outProPn = outProPn;
		this.outProMi = outProMi;
		this.outProAmount = outProAmount;
		this.outProPrice = outProPrice;
		this.outProDate = outProDate;
		this.sort = sort;
	}
	public int getOutProNo() {
		return outProNo;
	}
	public void setOutProNo(int outProNo) {
		this.outProNo = outProNo;
	}
	public int getOutProPn() {
		return outProPn;
	}
	public void setOutProPn(int outProPn) {
		this.outProPn = outProPn;
	}
	public String getOutProMi() {
		return outProMi;
	}
	public void setOutProMi(String outProMi) {
		this.outProMi = outProMi;
	}
	public int getOutProAmount() {
		return outProAmount;
	}
	public void setOutProAmount(int outProAmount) {
		this.outProAmount = outProAmount;
	}
	public int getOutProPrice() {
		return outProPrice;
	}
	public void setOutProPrice(int outProPrice) {
		this.outProPrice = outProPrice;
	}
	public String getOutProDate() {
		return outProDate;
	}
	public void setOutProDate(String outProDate) {
		this.outProDate = outProDate;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	
}
