package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import JDBC.UserDao;
import JavaBean.Users;

/**
 * Servlet implementation class AddCart
 */
//@WebServlet("/AddCart")
public class AddCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 接收加入购物车请求，参数是good_name
		String goodName=request.getParameter("good_name");
		Users user=(Users) request.getSession().getAttribute("user");
		if(user==null) {
			response.getWriter().print("<h2 align=center>请先<a href='login.jsp'>登录</a></h2>");
		}else if(goodName==null) {
			response.getWriter().print("<h2 align=center>商品不存在<a href='index.jsp'>点此返回</a></h2>");
		}else {
			UserDao dao=new UserDao();
			String cart=user.getCart();
			if(cart==null||"".equals(cart.replace(" ", ""))) {
				user.setCart(goodName+"#");
			}else if(cart.indexOf(goodName)!=-1){
				response.getWriter().print("<h2 align=center>您已添加此商品<a href='index.jsp'>点此返回</a></h2>");
			}else {
				user.setCart(cart+goodName+"#");
			}
			try {
				dao.updateUser(user);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("cart.jsp");
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
