package JavaBean;

public class Orders {
	private String orderid;
	private String userid;
	private String goods;//描述句子good1^15,
	private String money;
	private String pay;

	//订单号
	public void setOrderId(String orderid) {
		this.orderid=orderid;
	}
	public String getOrderId() {
		return this.orderid;
	}
	//用户ID
	public void setUserId(String userid) {
		this.userid=userid;
	}
	public String getUserId() {
		return this.userid;
	}
	//商品及数量描述
	public void setGoods(String goods) {
		this.goods=goods;
	}
	public String getGoods() {
		return this.goods;
	}
	//价钱
	public void setMoney(String money) {
		this.money=money;
	}
	public String getMoney() {
		return this.money;
	}
	//是否已支付
	public void setPay(String pay) {
		this.pay=pay;
	}
	public String getPay() {
		return this.pay;
	}
}
