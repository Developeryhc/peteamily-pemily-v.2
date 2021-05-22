package outProduct.model.vo;

import java.util.ArrayList;

public class OutProPage {
	private ArrayList<OutPro> list;
	private String navigation;
	public OutProPage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OutProPage(ArrayList<OutPro> list, String navigation) {
		super();
		this.list = list;
		this.navigation = navigation;
	}
	public ArrayList<OutPro> getList() {
		return list;
	}
	public void setList(ArrayList<OutPro> list) {
		this.list = list;
	}
	public String getNavigation() {
		return navigation;
	}
	public void setNavigation(String navigation) {
		this.navigation = navigation;
	}
	
}
