package care.model.vo;

public class Care {
	private int rnum;
	private int careNo;
	private int careAn;
	private String careTitle;
	private String careWriter;
	private String careContent;
	private String carePic;
	private String careDate;
	private String carePath;
	private int careSatisfa;
	public Care() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Care(int rnum, int careNo, int careAn, String careTitle, String careWriter, String careContent,
			String carePic, String careDate, String carePath, int careSatisfa) {
		super();
		this.rnum = rnum;
		this.careNo = careNo;
		this.careAn = careAn;
		this.careTitle = careTitle;
		this.careWriter = careWriter;
		this.careContent = careContent;
		this.carePic = carePic;
		this.careDate = careDate;
		this.carePath = carePath;
		this.careSatisfa = careSatisfa;
	}
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public int getCareNo() {
		return careNo;
	}
	public void setCareNo(int careNo) {
		this.careNo = careNo;
	}
	public int getCareAn() {
		return careAn;
	}
	public void setCareAn(int careAn) {
		this.careAn = careAn;
	}
	public String getCareTitle() {
		return careTitle;
	}
	public void setCareTitle(String careTitle) {
		this.careTitle = careTitle;
	}
	public String getCareWriter() {
		return careWriter;
	}
	public void setCareWriter(String careWriter) {
		this.careWriter = careWriter;
	}
	public String getCareContentBr() {
		return careContent.replaceAll("\r\n", "<br>");
	}
	public String getCareContent() {
		return careContent;
	}
	public void setCareContent(String careContent) {
		this.careContent = careContent;
	}
	public String getCarePic() {
		return carePic;
	}
	public void setCarePic(String carePic) {
		this.carePic = carePic;
	}
	public String getCareDate() {
		return careDate;
	}
	public void setCareDate(String careDate) {
		this.careDate = careDate;
	}
	public String getCarePath() {
		return carePath;
	}
	public void setCarePath(String carePath) {
		this.carePath = carePath;
	}
	public int getCareSatisfa() {
		return careSatisfa;
	}
	public void setCareSatisfa(int careSatisfa) {
		this.careSatisfa = careSatisfa;
	}
	 
	
}