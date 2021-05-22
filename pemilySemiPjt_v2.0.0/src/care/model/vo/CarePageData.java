package care.model.vo;

import java.util.ArrayList;

public class CarePageData {
	private ArrayList<Care> list;
	private String pageNavi;
	public CarePageData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CarePageData(ArrayList<Care> list, String pageNavi) {
		super();
		this.list = list;
		this.pageNavi = pageNavi;
	}
	public ArrayList<Care> getList() {
		return list;
	}
	public void setList(ArrayList<Care> list) {
		this.list = list;
	}
	public String getPageNavi() {
		return pageNavi;
	}
	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}
	
	
}
