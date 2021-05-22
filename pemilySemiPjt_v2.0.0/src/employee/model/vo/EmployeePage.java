package employee.model.vo;

import java.util.ArrayList;

public class EmployeePage {
	private ArrayList<Employee> list;
	private String navigation;
	public EmployeePage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeePage(ArrayList<Employee> list, String navigation) {
		super();
		this.list = list;
		this.navigation = navigation;
	}
	public ArrayList<Employee> getList() {
		return list;
	}
	public void setList(ArrayList<Employee> list) {
		this.list = list;
	}
	public String getNavigation() {
		return navigation;
	}
	public void setNavigation(String navigation) {
		this.navigation = navigation;
	}
	
}
