package inca.model.vo;

import java.util.ArrayList;

public class IncaPage {
	private ArrayList<Inca> list;
	private String navigation;
	public IncaPage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public IncaPage(ArrayList<Inca> list, String navigation) {
		super();
		this.list = list;
		this.navigation = navigation;
	}
	public ArrayList<Inca> getList() {
		return list;
	}
	public void setList(ArrayList<Inca> list) {
		this.list = list;
	}
	public String getNavigation() {
		return navigation;
	}
	public void setNavigation(String navigation) {
		this.navigation = navigation;
	}
}
