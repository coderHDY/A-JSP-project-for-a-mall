package JavaBean;

public class Goods {
	private String goodsId;
	private String type;
	private String name;
	private String big;
	private String small;
	private String description;
	private String number;
	private String price;
	private String hot;

	//ID
	public void setGoodsId(String goodsid) {
		this.goodsId=goodsid;
	}
	public String getGoodsId() {
		return this.goodsId;
	}
	//����
		public void setType(String type) {
			this.type=type;
		}
		public String getType() {
			return this.type;
		}
	//����
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return this.name;
	}
	//СͼƬ·��
	public void setSmall(String small) {
		this.small=small;
	}
	public String getSmall() {
		return this.small;
	}
	//��ͼƬ·��
		public void setBig(String big) {
			this.big=big;
		}
		public String getBig() {
			return this.big;
		}
	//����
	public void setDescription(String description) {
		this.description=description;
	}
	public String getDescription() {
		return this.description;
	}
	//���
	public void setNumber(String number) {
		this.number=number;
	}
	public String getNumber() {
		return this.number;
	}
	//�۸�
	public void setPrice(String price) {
		this.price=price;
	}
	public String getPrice() {
		return this.price;
	}
	//�ȶ�
	public void setHot(String hot) {
		this.hot=hot;
	}
	public String getHot() {
		return this.hot;
	}
}
