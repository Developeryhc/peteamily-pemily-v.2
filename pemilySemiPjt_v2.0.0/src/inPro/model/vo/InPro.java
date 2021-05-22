package inPro.model.vo;

public class InPro {
	private int inProNo;
	private int inProSn;
	private String inProName;
	private int inProPrice;
	private int inProAmount;
	private String inProPic;
	private String inProPath;
	private int sort;
	
	public InPro() {
		super();
		// TODO Auto-generated constructor stub
	}
	public InPro(int inProNo, int inProSn, String inProName, int inProPrice, int inProAmount, String inProPic,
			String inProPath,int sort) {
		super();
		this.inProNo = inProNo;
		this.inProSn = inProSn;
		this.inProName = inProName;
		this.inProPrice = inProPrice;
		this.inProAmount = inProAmount;
		this.inProPic = inProPic;
		this.inProPath = inProPath;
		this.sort = sort;
	}
	public int getInProNo() {
		return inProNo;
	}
	public void setInProNo(int inProNo) {
		this.inProNo = inProNo;
	}
	public int getInProSn() {
		return inProSn;
	}
	public void setInProSn(int inProSn) {
		this.inProSn = inProSn;
	}
	public String getInProName() {
		return inProName;
	}
	public void setInProName(String inProName) {
		this.inProName = inProName;
	}
	public int getInProPrice() {
		return inProPrice;
	}
	public void setInProPrice(int inProPrice) {
		this.inProPrice = inProPrice;
	}
	public int getInProAmount() {
		return inProAmount;
	}
	public void setInProAmount(int inProAmount) {
		this.inProAmount = inProAmount;
	}
	public String getInProPic() {
		return inProPic;
	}
	public void setInProPic(String inProPic) {
		this.inProPic = inProPic;
	}
	public String getInProPath() {
		return inProPath;
	}
	public void setInProPath(String inProPath) {
		this.inProPath = inProPath;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	
}
