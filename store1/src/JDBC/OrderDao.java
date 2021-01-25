package JDBC;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mysql.cj.x.protobuf.MysqlxCrud.Order;

import JavaBean.Goods;
import JavaBean.Orders;

public class OrderDao {
	//获取所有订单
	public ArrayList<Orders> getAllOrders() throws SQLException{
		QueryRunner runner=new QueryRunner(DaoPool.getDataSource());
		String sql="select * from orders";
		ArrayList<Orders> orders=(ArrayList<Orders>) runner.query(sql, new BeanListHandler(Orders.class));
		return orders;
	}
	//根据订单id获取订单
	public Orders getOrderById(String orderid) throws SQLException {
		//申请一个连接
		QueryRunner runner=new QueryRunner(DaoPool.getDataSource());
		//定义数据库访问语句
		String sql="select * from orders where orderid=?";
		Orders order=(Orders)runner.query(sql, new BeanHandler(Orders.class),orderid);
		return order;
	}
	//根据用户名获取订单集（该用户所有订单）
	public ArrayList<Orders> getOrdersByUserId(String userid) throws SQLException{
		QueryRunner runner=new QueryRunner(DaoPool.getDataSource());
		String sql="select * from orders where userid =?";
		ArrayList<Orders> orders=(ArrayList<Orders>) runner.query(sql, new BeanListHandler(Orders.class),userid);
		return orders;
	}
	//修改订单状态
	public Boolean updateOrder(Orders order) throws SQLException {
		QueryRunner runner=new QueryRunner(DaoPool.getDataSource());
		String sql="update orders set userid=?,goods=?,money=?,pay=? where orderid=?";
		int i=runner.update(sql,new Object[] {order.getUserId(),order.getGoods(),order.getMoney(),order.getPay(),order.getOrderId()});
		if(i==0) {
			return false;
		}else {
			return true;
		}
	}
	//添加订单
	public Boolean addOrder(Orders order) throws SQLException {
		QueryRunner runner=new QueryRunner(DaoPool.getDataSource());
		String sql="insert into orders(userid,goods,money,pay) values(?,?,?,?)";
		int i=runner.update(sql, new Object[] {order.getUserId(),order.getGoods(),order.getMoney(),order.getPay()});
		if(i==0) {
			return false;
		}else {
			return true;
		}
	}
	//删除订单(收id)
	public Boolean deleteOrderByOrderId(String orderid) throws SQLException {
		QueryRunner runner=new QueryRunner(DaoPool.getDataSource());
		String sql="delete from Orders where orderid=?";
		int i=runner.update(sql,new Object[] {orderid});
		if(i==0) {
			return false;
		}else {
			return true;
		}
	}
//	public static void main(String[] args) throws SQLException {
//		OrderDao dao=new OrderDao();
		//修改状态测试
//		Orders order=dao.getOrderById("1002");
//		System.out.println("现在订单"+order.getOrderId()+"的交易情况是"+order.getPay());	
//		order.setPay("1");
//		dao.updateOrder(order);
//		Orders order2=dao.getOrderById("1002");
//		System.out.println("现在订单"+order2.getOrderId()+"的交易情况是"+order2.getPay());	
		//删除测试
//		System.out.println(dao.deleteOrderByOrderId("1002"));
		//获取订单测试
//		ArrayList<Orders> orders=dao.getOrdersByUserId("陈云江");
//		for(int i=0;i<orders.size();i++) {
//			System.out.print(orders.get(i).getGoods());	
//		}
//		System.out.print(dao.getOrderById("1002").getMoney());
		//添加订单测试
//		Orders order=new Orders();
//		order.setUserId("王映澜");
//		order.setGoods("11^2#20^3#17^13");
//		order.setMoney("335.5");
//		order.setPay("0");
//		System.out.println(dao.addOrder(order));
//		
//	}
}

