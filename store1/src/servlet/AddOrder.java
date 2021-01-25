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
		// ���������ձ���װ��ȡ�Ĳ���
		String good[]=null;
		String number[]=null;
		String buy[]=null;
		//��ȡ���ͬ�������ķ���
		Enumeration<String> names=request.getParameterNames();
		while(names.hasMoreElements()) {
			String parameterName=(String)names.nextElement();
			if("goodName".equals(parameterName)) {
				good=request.getParameterValues(parameterName);
//				if(good!=null) {
//					for(int i=0;i<good.length;i++) {
//						response.getWriter().println("��Ʒ����"+good[i]);
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
			response.getWriter().println("<h3 align=center>��ѡ����Ʒѽ�ף�<a href='cart.jsp'><h2>��˷���</h2></a></h3>");
		}else {
			//���ﳵ�ж���
			//׼��Ҫ�õĹ�����
			Users user=(Users)request.getSession().getAttribute("user");
			OrderDao od=new OrderDao();
			GoodDao gd=new GoodDao();
			//��һ��good��String���¹��ﳵ
			ArrayList<String> beenBuy=new ArrayList<String>();
			//������Order������
			String userid=user.getAdmin();
			String goods="";
			String pay="0";
			int money=0;
			for(int i=0;i<buy.length;i++) {
//				response.getWriter().println("Integer.parseInt(buy[i])��"+Integer.parseInt(buy[i]));
//				response.getWriter().println("good[Integer.parseInt(buy[i])]Ϊ��"+good[Integer.parseInt(buy[i])]+"<br>");
//				response.getWriter().println("��Ʒ�ַ���Ϊ��"+goods);
				//��ȡ����
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
			//select�ݴ���ӹ��ﳵ�Ķ���good��ԭ���ﳵ,beenBuy�ǹ����˵�
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
			//��װ��Order
			Orders order=new Orders();
			order.setGoods(goods);
			order.setMoney(money+"");
			order.setPay(pay);
			order.setUserId(userid);
			//�ж��Ƿ��µ��ɹ�
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
				//�µ�ʧ��
				response.getWriter().println("�µ�ʧ�ܣ�����Ա̫���ˣ��ֳ�bug�ˣ�<a href='cart.jsp'><h2>��˷���</h2></a>");
			}else {
				//�µ��ɹ�
				//�������ﳵ����
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
					response.getWriter().println("ѽ�����ǵ�����̫���ˣ�����ը�����ˣ�<a href='cart.jsp'><h2>��˷���</h2></a>");
				}else {
					response.getWriter().println("<h1 align=center style='color:red'><span style='color:black'>������Ϊ��</span>"+newOrder.get(newOrder.size()-1).getOrderId()+"</h1><a href='index.jsp'><h2 align=center>��˼�������</h2></a>");
					
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
