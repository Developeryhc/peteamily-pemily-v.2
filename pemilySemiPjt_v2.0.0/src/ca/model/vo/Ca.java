package ca.model.vo;

public class Ca {
	private int rnum;
	private int caNo;
	private int caAn;
	private String caTitle;
	private String caWriter;
	private String caContent;
	private String caDate;
	private String caName;
	private int caKindNo;
	private String caEmp;
	private int caPrice;
	private int caStore;
	public Ca() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ca(int rnum, int caNo, int caAn, String caTitle, String caWriter, String caContent, String caDate,
			String caName, int caKindNo, String caEmp, int caPrice, int caStore) {
		super();
		this.rnum = rnum;
		this.caNo = caNo;
		this.caAn = caAn;
		this.caTitle = caTitle;
		this.caWriter = caWriter;
		this.caContent = caContent;
		this.caDate = caDate;
		this.caName = caName;
		this.caKindNo = caKindNo;
		this.caEmp = caEmp;
		this.caPrice = caPrice;
		this.caStore = caStore;
	}
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public int getCaNo() {
		return caNo;
	}
	public void setCaNo(int caNo) {
		this.caNo = caNo;
	}
	public int getCaAn() {
		return caAn;
	}
	public void setCaAn(int caAn) {
		this.caAn = caAn;
	}
	public String getCaTitle() {
		return caTitle;
	}
	public void setCaTitle(String caTitle) {
		this.caTitle = caTitle;
	}
	public String getCaWriter() {
		return caWriter;
	}
	public void setCaWriter(String caWriter) {
		this.caWriter = caWriter;
	}
	public String getCaContent() {
		return caContent;
	}
	public void setCaContent(String caContent) {
		this.caContent = caContent;
	}
	public String getCaDate() {
		return caDate;
	}
	public void setCaDate(String caDate) {
		this.caDate = caDate;
	}
	public String getCaName() {
		return caName;
	}
	public void setCaName(String caName) {
		this.caName = caName;
	}
	public int getCaKindNo() {
		return caKindNo;
	}
	public void setCaKindNo(int caKindNo) {
		this.caKindNo = caKindNo;
	}
	public String getCaEmp() {
		return caEmp;
	}
	public void setCaEmp(String caEmp) {
		this.caEmp = caEmp;
	}
	public int getCaPrice() {
		return caPrice;
	}
	public void setCaPrice(int caPrice) {
		this.caPrice = caPrice;
	}
	public int getCaStore() {
		return caStore;
	}
	public void setCaStore(int caStore) {
		this.caStore = caStore;
	}
}
