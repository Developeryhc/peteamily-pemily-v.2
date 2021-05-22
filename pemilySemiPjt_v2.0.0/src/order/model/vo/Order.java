package order.model.vo;

public class Order {
	//주문번호 : outpro_no
	private int orderNo;
	//주문 상품 이름 : inpro_name
	private String orderName;
	//주문된 상품 금액 : inpro_price
	private int orderPrice;
	//주문된 수량 : outProAmount
	private int orderAmount;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(int orderNo, String orderName, int orderPrice, int orderAmount) {
		super();
		this.orderNo = orderNo;
		this.orderName = orderName;
		this.orderPrice = orderPrice;
		this.orderAmount = orderAmount;
	}
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public int getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}
	public int getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}

}
