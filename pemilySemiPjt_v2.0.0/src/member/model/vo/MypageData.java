package member.model.vo;

import java.util.ArrayList;

import order.model.vo.Order;

public class MypageData {
	private Member m;
	private ArrayList<Order> list;
	public MypageData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MypageData(Member m, ArrayList<Order> list) {
		super();
		this.m = m;
		this.list = list;
	}
	public Member getM() {
		return m;
	}
	public void setM(Member m) {
		this.m = m;
	}
	public ArrayList<Order> getList() {
		return list;
	}
	public void setList(ArrayList<Order> list) {
		this.list = list;
	}
	
}
