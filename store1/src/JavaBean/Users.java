package JavaBean;



public class Users {
	private String admin;
	private String name;
	private String password;
	private String phone;
	private String address;
	private String image;
	private String cart;
	//�˻�
	public void setAdmin(String admin) {
		this.admin=admin;
	}
	public String getAdmin() {
		return this.admin;
	}
	//�ǳ�
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return this.name;
	}
	//����
	public void setPassword(String password) {
		this.password=password;
	}
	public String getPassword() {
		return this.password;
	}
	//�绰
	public void setPhone(String phone) {
		this.phone=phone;
	}
	public String getPhone() {
		return this.phone;
	}
	//��ַ
	public void setAddress(String address) {
		this.address=address;
	}
	public String getAddress() {
		return this.address;
	}
	//ͼƬ
	public void setImage(String image) {
		this.image=image;
	}
	public String getImage() {
		return this.image;
	}
	//���ﳵ������һ���ַ�����������11#����(��������)
	public void setCart(String cart) {
		this.cart=cart;
	}
	public String getCart() {
		return this.cart;
	}
}
