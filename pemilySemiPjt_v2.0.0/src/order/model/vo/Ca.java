package order.model.vo;

public class Ca {
	private int rnum;
	private int caNo;
	private int caAn;
	private String caTitle;
	private String caWriter;
	private String caContent;
	private String caDate;
	public Ca() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ca(int rnum, int caNo, int caAn, String caTitle, String caWriter, String caContent, String caDate) {
		super();
		this.rnum = rnum;
		this.caNo = caNo;
		this.caAn = caAn;
		this.caTitle = caTitle;
		this.caWriter = caWriter;
		this.caContent = caContent;
		this.caDate = caDate;
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
}
