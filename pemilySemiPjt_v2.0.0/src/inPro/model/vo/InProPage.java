package inPro.model.vo;

import java.util.ArrayList;

public class InProPage {
	private ArrayList<InPro> list;
	private String navigation;
	public InProPage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public InProPage(ArrayList<InPro> list, String navigation) {
		super();
		this.list = list;
		this.navigation = navigation;
	}
	public ArrayList<InPro> getList() {
		return list;
	}
	public void setList(ArrayList<InPro> list) {
		this.list = list;
	}
	public String getNavigation() {
		return navigation;
	}
	public void setNavigation(String navigation) {
		this.navigation = navigation;
	}
	
}
