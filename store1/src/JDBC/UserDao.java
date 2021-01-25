package JDBC;

import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import JavaBean.Users;

public class UserDao {
	//查询所有用户
	public ArrayList<Users> findAllUser() throws SQLException {
		//QueryRunner 简化执行了SQL代码
		QueryRunner runner=new QueryRunner(DaoPool.getDataSource());
		//预定义sql语句
		String sql="select * from users";
		//执行查询
		ArrayList<Users> users=(ArrayList<Users>)runner.query(sql, new BeanListHandler(Users.class)); //注意使用的是单对象BeanHandler还是多对象BeanListHandler
		return users;
	}
	
	//查询单个用户
	public Users findUserByAdmin(String admin) throws SQLException {
		QueryRunner runner=new QueryRunner(DaoPool.getDataSource());
		String sql="select * from users where admin=?";
		Users user=(Users)runner.query(sql, new BeanHandler(Users.class),new Object[] {admin});//单个对象用BeanHandler,且需要加数组参数
		return user;
	}
	//通过名字查询用户们！！
	public ArrayList<Users> findUsersByName(String name) throws SQLException{
		QueryRunner runner=new QueryRunner(DaoPool.getDataSource());
		String sql="select * from users where name=?";
		ArrayList<Users> users=(ArrayList<Users>) runner.query(sql, new BeanListHandler(Users.class),new Object[] {name});
		return users;
	}
	//添加用户数据
	public Boolean addUser(Users user) throws SQLException {
		QueryRunner runner=new QueryRunner(DaoPool.getDataSource());
		//用户
		String sql="insert into users(admin,name,password,address,phone,image,cart) values(?,?,?,?,?,?,?)";
		int i=runner.update(sql,new Object[] {user.getAdmin(),user.getName(),user.getPassword(),user.getAddress(),user.getPhone(),user.getImage(),user.getCart()});
		if(i>0) {
			return true;
		}else {
			return false;
		}
	}
	//修改用户数据!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
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
	//删除用户
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
////		String i="阿玛尼111~13";
////		String[] l=i.split("~");
////		System.out.print(l.length);
////		for(int i=0;i<users.size();i++) {
////			System.out.print(users.get(i).getAddress());
////		}
//												//创建用户测试语句
//		UserDao dao=new UserDao();
//		Users user=dao.findUserByAdmin("回欣宇");
////		System.out.println(user.getAddress());
//		
//		user.setName("大大回");
//		user.setPassword("miehaihai123");
//		user.setAddress("大连市软件园");
//		user.setPhone("13063080813");
//		user.setImage("images/00.jpg");
//		System.out.print(dao.updateUser(user));
//		//删除用户测试语句
//		System.out.print("hello111");
//	}
}
