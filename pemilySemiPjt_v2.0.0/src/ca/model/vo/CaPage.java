package ca.model.vo;

import java.util.ArrayList;

public class CaPage {
	private ArrayList<Ca> list;
	private String navigation;
	public CaPage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CaPage(ArrayList<Ca> list, String navigation) {
		super();
		this.list = list;
		this.navigation = navigation;
	}
	public ArrayList<Ca> getList() {
		return list;
	}
	public void setList(ArrayList<Ca> list) {
		this.list = list;
	}
	public String getNavigation() {
		return navigation;
	}
	public void setNavigation(String navigation) {
		this.navigation = navigation;
	}
}
