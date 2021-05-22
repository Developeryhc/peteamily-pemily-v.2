package outCa.model.vo;

import java.util.ArrayList;

public class OutCaPage {
	private ArrayList<OutCa> list;
	private String navigation;
	public OutCaPage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OutCaPage(ArrayList<OutCa> list, String navigation) {
		super();
		this.list = list;
		this.navigation = navigation;
	}
	public ArrayList<OutCa> getList() {
		return list;
	}
	public void setList(ArrayList<OutCa> list) {
		this.list = list;
	}
	public String getNavigation() {
		return navigation;
	}
	public void setNavigation(String navigation) {
		this.navigation = navigation;
	}
	
}
