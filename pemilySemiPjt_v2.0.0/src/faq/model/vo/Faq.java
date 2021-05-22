package faq.model.vo;

public class Faq {
	
	private int faqNo;
	private String faqTitle;
	private String faqWriter;
	private String faqContent;
	private String faqDate;
	public Faq() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Faq(int faqNo, String faqTitle, String faqWriter, String faqContent, String faqDate) {
		super();
		this.faqNo = faqNo;
		this.faqTitle = faqTitle;
		this.faqWriter = faqWriter;
		this.faqContent = faqContent;
		this.faqDate = faqDate;
	}
	public int getFaqNo() {
		return faqNo;
	}
	public void setFaqNo(int faqNo) {
		this.faqNo = faqNo;
	}
	public String getFaqTitle() {
		return faqTitle;
	}
	public void setFaqTitle(String faqTitle) {
		this.faqTitle = faqTitle;
	}
	public String getFaqWriter() {
		return faqWriter;
	}
	public void setFaqWriter(String faqWriter) {
		this.faqWriter = faqWriter;
	}
	public String getFaqContent() {
		return faqContent;
	}
	public void setFaqContent(String faqContent) {
		this.faqContent = faqContent;
	}
	public String getFaqDate() {
		return faqDate;
	}
	public void setFaqDate(String faqDate) {
		this.faqDate = faqDate;
	}

	
	
	
}
