package JDBC;

import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import JavaBean.Users;

public class UserDao {
	//��ѯ�����û�
	public ArrayList<Users> findAllUser() throws SQLException {
		//QueryRunner ��ִ����SQL����
		QueryRunner runner=new QueryRunner(DaoPool.getDataSource());
		//Ԥ����sql���
		String sql="select * from users";
		//ִ�в�ѯ
		ArrayList<Users> users=(ArrayList<Users>)runner.query(sql, new BeanListHandler(Users.class)); //ע��ʹ�õ��ǵ�����BeanHandler���Ƕ����BeanListHandler
		return users;
	}
	
	//��ѯ�����û�
	public Users findUserByAdmin(String admin) throws SQLException {
		QueryRunner runner=new QueryRunner(DaoPool.getDataSource());
		String sql="select * from users where admin=?";
		Users user=(Users)runner.query(sql, new BeanHandler(Users.class),new Object[] {admin});//����������BeanHandler,����Ҫ���������
		return user;
	}
	//ͨ�����ֲ�ѯ�û��ǣ���
	public ArrayList<Users> findUsersByName(String name) throws SQLException{
		QueryRunner runner=new QueryRunner(DaoPool.getDataSource());
		String sql="select * from users where name=?";
		ArrayList<Users> users=(ArrayList<Users>) runner.query(sql, new BeanListHandler(Users.class),new Object[] {name});
		return users;
	}
	//����û�����
	public Boolean addUser(Users user) throws SQLException {
		QueryRunner runner=new QueryRunner(DaoPool.getDataSource());
		//�û�
		String sql="insert into users(admin,name,password,address,phone,image,cart) values(?,?,?,?,?,?,?)";
		int i=runner.update(sql,new Object[] {user.getAdmin(),user.getName(),user.getPassword(),user.getAddress(),user.getPhone(),user.getImage(),user.getCart()});
		if(i>0) {
			return true;
		}else {
			return false;
		}
	}
	//�޸��û�����!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	public Boolean updateUser(Users user) throws SQLException {
		QueryRunner runner=new QueryRunner(DaoPool.getDataSource());
		String sql="update users set name=?,password=?,address=?,phone=?,image=?,cart=? where admin=?";
		int i=runner.update(sql,new Object[] {user.getName(),user.getPassword(),user.getAddress(),user.getPhone(),user.getImage(),user.getCart(),user.getAdmin()});
		if(i>0) {
			return true;
		}else {
			return false;
		}
	}
	//ɾ���û�
	public Boolean deleteUserByAdmin(String admin) throws SQLException {
		QueryRunner runner=new QueryRunner(DaoPool.getDataSource());
		String sql="delete from users where admin=?";
		int i=runner.update(sql,new Object[] {admin});
		if(i>0) {
			return true;
		}else {
			return false;
		}
	}
//	public static void main(String[] args) throws SQLException {
////		String i="������111~13";
////		String[] l=i.split("~");
////		System.out.print(l.length);
////		for(int i=0;i<users.size();i++) {
////			System.out.print(users.get(i).getAddress());
////		}
//												//�����û��������
//		UserDao dao=new UserDao();
//		Users user=dao.findUserByAdmin("������");
////		System.out.println(user.getAddress());
//		
//		user.setName("����");
//		user.setPassword("miehaihai123");
//		user.setAddress("���������԰");
//		user.setPhone("13063080813");
//		user.setImage("images/00.jpg");
//		System.out.print(dao.updateUser(user));
//		//ɾ���û��������
//		System.out.print("hello111");
//	}
}
