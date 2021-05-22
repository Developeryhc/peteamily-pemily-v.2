package notice.model.vo;

public class NoticeWriteInfo {
	private int noticeNo;
	private String noticeWriter;
	private String noticeTitle;
	private String noticeContent;
	private String noticeDate;
	private int noticeCom;
	private String empPath;
	private String empName;
	private String empPhone;
	public NoticeWriteInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NoticeWriteInfo(int noticeNo, String noticeWriter, String noticeTitle, String noticeContent,
			String noticeDate, int noticeCom, String empPath, String empName, String empPhone) {
		super();
		this.noticeNo = noticeNo;
		this.noticeWriter = noticeWriter;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.noticeDate = noticeDate;
		this.noticeCom = noticeCom;
		this.empPath = empPath;
		this.empName = empName;
		this.empPhone = empPhone;
	}
	public int getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}
	public String getNoticeWriter() {
		return noticeWriter;
	}
	public void setNoticeWriter(String noticeWriter) {
		this.noticeWriter = noticeWriter;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	public String getNoticeDate() {
		return noticeDate;
	}
	public void setNoticeDate(String noticeDate) {
		this.noticeDate = noticeDate;
	}
	public int getNoticeCom() {
		return noticeCom;
	}
	public void setNoticeCom(int noticeCom) {
		this.noticeCom = noticeCom;
	}
	public String getEmpPath() {
		return empPath;
	}
	public void setEmpPath(String empPath) {
		this.empPath = empPath;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpPhone() {
		return empPhone;
	}
	public void setEmpPhone(String empPhone) {
		this.empPhone = empPhone;
	}
	
}
