package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import JDBC.OrderDao;
import JDBC.UserDao;
import JDBC.GoodDao;
import JavaBean.Goods;
import JavaBean.Orders;
import JavaBean.Users;

/**
 * Servlet implementation class addOrder
 */
//@WebServlet("/addOrder")
public class AddOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 定义三个空表来装获取的参数
		String good[]=null;
		String number[]=null;
		String buy[]=null;
		//获取多个同名参数的方法
		Enumeration<String> names=request.getParameterNames();
		while(names.hasMoreElements()) {
			String parameterName=(String)names.nextElement();
			if("goodName".equals(parameterName)) {
				good=request.getParameterValues(parameterName);
//				if(good!=null) {
//					for(int i=0;i<good.length;i++) {
//						response.getWriter().println("商品名："+good[i]);
//					}
//				}
			}else if("number".equals(parameterName)) {
				number=request.getParameterValues(parameterName);
				///////
			}else if("is_by".equals(parameterName)){
				buy=request.getParameterValues(parameterName);
			}
		}
		if(buy==null||buy.length==0) {
			response.getWriter().println("<h3 align=center>请选择商品呀亲！<a href='cart.jsp'><h2>点此返回</h2></a></h3>");
		}else {
			//购物车有东西
			//准备要用的工具类
			Users user=(Users)request.getSession().getAttribute("user");
			OrderDao od=new OrderDao();
			GoodDao gd=new GoodDao();
			//留一个good的String做新购物车
			ArrayList<String> beenBuy=new ArrayList<String>();
			//定义新Order的属性
			String userid=user.getAdmin();
			String goods="";
			String pay="0";
			int money=0;
			for(int i=0;i<buy.length;i++) {
//				response.getWriter().println("Integer.parseInt(buy[i])："+Integer.parseInt(buy[i]));
//				response.getWriter().println("good[Integer.parseInt(buy[i])]为："+good[Integer.parseInt(buy[i])]+"<br>");
//				response.getWriter().println("商品字符串为："+goods);
				//获取单价
				Goods g = null;
				try {
					g = gd.getGoodByName(good[Integer.parseInt(buy[i])]);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				int price=Integer.parseInt(g.getPrice());
				money+=price*Integer.parseInt(number[Integer.parseInt(buy[i])]);
				goods+=good[Integer.parseInt(buy[i])]+"~"+number[Integer.parseInt(buy[i])]+"#";
				beenBuy.add(good[Integer.parseInt(buy[i])]);
			}
			//select暂存添加购物车的东西good是原购物车,beenBuy是购买了的
			String newCert="";
			for(int i=0;i<good.length;i++) {
				String go=good[i];
				Boolean T=true;
				for(int x=0;x<beenBuy.size();x++) {
					if(beenBuy.get(x).equals(go)) {
						T=false;
					}
				}
				if(T==true) {
					newCert+=good[i]+"#";
				}
			}
			user.setCart(newCert);
			UserDao ud=new UserDao();
			try {
				ud.updateUser(user);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//封装新Order
			Orders order=new Orders();
			order.setGoods(goods);
			order.setMoney(money+"");
			order.setPay(pay);
			order.setUserId(userid);
			//判断是否下单成功
			int success=0;
			try {
				if(od.addOrder(order)) {
					success=1;
				};
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(success==0) {
				//下单失败
				response.getWriter().println("下单失败，程序员太笨了，又出bug了！<a href='cart.jsp'><h2>点此返回</h2></a>");
			}else {
				//下单成功
				//减掉购物车东西
				String[] oldCert=user.getCart().split("#");
				
				//
				ArrayList<Orders> newOrder=null;
				try {
					newOrder=od.getOrdersByUserId(userid);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(newOrder==null) {
					response.getWriter().println("呀！咱们店生意太好了，网络炸了了了！<a href='cart.jsp'><h2>点此返回</h2></a>");
				}else {
					response.getWriter().println("<h1 align=center style='color:red'><span style='color:black'>订单号为：</span>"+newOrder.get(newOrder.size()-1).getOrderId()+"</h1><a href='index.jsp'><h2 align=center>点此继续购物</h2></a>");
					
				}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
