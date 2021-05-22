package member.model.vo;

import java.util.ArrayList;

public class MemberPage {
	private ArrayList<Member> list;
	private String navigation;
	public MemberPage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MemberPage(ArrayList<Member> list, String navigation) {
		super();
		this.list = list;
		this.navigation = navigation;
	}
	public ArrayList<Member> getList() {
		return list;
	}
	public void setList(ArrayList<Member> list) {
		this.list = list;
	}
	public String getNavigation() {
		return navigation;
	}
	public void setNavigation(String navigation) {
		this.navigation = navigation;
	}
	
}
