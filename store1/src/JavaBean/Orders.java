package JavaBean;

public class Orders {
	private String orderid;
	private String userid;
	private String goods;//��������good1^15,
	private String money;
	private String pay;

	//������
	public void setOrderId(String orderid) {
		this.orderid=orderid;
	}
	public String getOrderId() {
		return this.orderid;
	}
	//�û�ID
	public void setUserId(String userid) {
		this.userid=userid;
	}
	public String getUserId() {
		return this.userid;
	}
	//��Ʒ����������
	public void setGoods(String goods) {
		this.goods=goods;
	}
	public String getGoods() {
		return this.goods;
	}
	//��Ǯ
	public void setMoney(String money) {
		this.money=money;
	}
	public String getMoney() {
		return this.money;
	}
	//�Ƿ���֧��
	public void setPay(String pay) {
		this.pay=pay;
	}
	public String getPay() {
		return this.pay;
	}
}
