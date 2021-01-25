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
 * Servlet implementation class Register
 */
//@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserDao dao=new UserDao();
		String admin=request.getParameter("admin");
		try {
			if(dao.findUserByAdmin(admin)!=null) {
				response.getWriter().println("对不起，注册失败！用户名已存在！<a href='registered.jsp'><h2>点此重新注册</h2></a>");    //需要改用户已存在跳转页面
			}else {
					Users user=new Users();
					user.setAdmin(request.getParameter("admin"));
					user.setName(request.getParameter("name"));
					user.setPassword(request.getParameter("password"));
					user.setAddress(request.getParameter("address"));
					user.setPhone(request.getParameter("phone"));
					user.setImage(request.getParameter("image"));
					user.setCart("");
					if(dao.addUser(user)) {
//						if(request.getSession()!=null&&request.getSession().getAttribute("user")!=null) {
//							Users me=(Users)request.getSession().getAttribute("user");
//							if(me.getAdmin().equals("管理员")) {
//								response.sendRedirect("manager.jsp");
//							}else {
//								response.getWriter().println("恭喜，注册成功！<a href='login.jsp'><h2>点此去登录</h2></a>");
//							}
//							
//						}else {
							
							response.getWriter().println("<h3 align=center>恭喜，注册成功！<a href='login.jsp'><h2>点此去登录</h2></a></h3>");     //需要改注册成功的跳转页面
//						}
					}else {
						response.getWriter().print("<h2>未知错误...</h2>");     //需要改跳转页面
					}
				}	
			}catch (SQLException e) {
				response.getWriter().print("<h2>未知错误...</h2>"); 
				e.printStackTrace();
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
