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
	//��ȡ���ж���
	public ArrayList<Orders> getAllOrders() throws SQLException{
		QueryRunner runner=new QueryRunner(DaoPool.getDataSource());
		String sql="select * from orders";
		ArrayList<Orders> orders=(ArrayList<Orders>) runner.query(sql, new BeanListHandler(Orders.class));
		return orders;
	}
	//���ݶ���id��ȡ����
	public Orders getOrderById(String orderid) throws SQLException {
		//����һ������
		QueryRunner runner=new QueryRunner(DaoPool.getDataSource());
		//�������ݿ�������
		String sql="select * from orders where orderid=?";
		Orders order=(Orders)runner.query(sql, new BeanHandler(Orders.class),orderid);
		return order;
	}
	//�����û�����ȡ�����������û����ж�����
	public ArrayList<Orders> getOrdersByUserId(String userid) throws SQLException{
		QueryRunner runner=new QueryRunner(DaoPool.getDataSource());
		String sql="select * from orders where userid =?";
		ArrayList<Orders> orders=(ArrayList<Orders>) runner.query(sql, new BeanListHandler(Orders.class),userid);
		return orders;
	}
	//�޸Ķ���״̬
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
	//��Ӷ���
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
	//ɾ������(��id)
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
		//�޸�״̬����
//		Orders order=dao.getOrderById("1002");
//		System.out.println("���ڶ���"+order.getOrderId()+"�Ľ��������"+order.getPay());	
//		order.setPay("1");
//		dao.updateOrder(order);
//		Orders order2=dao.getOrderById("1002");
//		System.out.println("���ڶ���"+order2.getOrderId()+"�Ľ��������"+order2.getPay());	
		//ɾ������
//		System.out.println(dao.deleteOrderByOrderId("1002"));
		//��ȡ��������
//		ArrayList<Orders> orders=dao.getOrdersByUserId("���ƽ�");
//		for(int i=0;i<orders.size();i++) {
//			System.out.print(orders.get(i).getGoods());	
//		}
//		System.out.print(dao.getOrderById("1002").getMoney());
		//��Ӷ�������
//		Orders order=new Orders();
//		order.setUserId("��ӳ��");
//		order.setGoods("11^2#20^3#17^13");
//		order.setMoney("335.5");
//		order.setPay("0");
//		System.out.println(dao.addOrder(order));
//		
//	}
}

