package notice.model.vo;

public class Notice {
	
	private int rnum;  //화면상에 보여주는 번호(데이터에서 게시글이 하나 사라져도 화면상에는 순서대로 보여지게끔!)
	private int noticeNo;
	private String noticeWriter;
	private String noticeTitle;
	private String noticeContent;
	private String noticeDate;
	private int noticeCom;
	public Notice() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Notice(int rnum, int noticeNo, String noticeWriter, String noticeTitle, String noticeContent,
			String noticeDate, int noticeCom) {
		super();
		this.rnum = rnum;
		this.noticeNo = noticeNo;
		this.noticeWriter = noticeWriter;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.noticeDate = noticeDate;
		this.noticeCom = noticeCom;
	}
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
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
	public String getNoticeContentBr() {
		return noticeContent.replaceAll("\r\n", "<br>");
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

	
}
