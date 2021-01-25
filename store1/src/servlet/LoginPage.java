package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import JDBC.UserDao;
import JavaBean.Users;
/**
 * Servlet implementation class LoginPage
 */
//@WebServlet("/LoginPage")
public class LoginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取输入数据
		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		String admin=request.getParameter("admin");
		String password=request.getParameter("password");
		//判断登录
		if(admin.equals("15754027696")&&password.equals("Kongyanan990501")) {
			Users user=new Users();
			user.setAdmin("管理员");
			user.setName("南瓜");
			user.setPassword("Kongyanan990501");
			user.setAddress("大连交通大学二期四号楼");
			user.setPhone("15754027696");
			session.setAttribute("user", user);
			response.sendRedirect("manager.jsp");
		}else {
			//访问数据库 DAO
			UserDao dao=new UserDao();
			try {
				if(dao.findUserByAdmin(admin)==null) {
					out.println("<h1>用户不存在！</h1>");	    //需要改用户不存在页面
				}else if(!password.equals((String)dao.findUserByAdmin(admin).getPassword())) {
					out.println("<h1>密码错误！</h1>");	    //需要改用跳转登录界面页面
				}else if(password.equals((String)dao.findUserByAdmin(admin).getPassword())) {
					Users user=dao.findUserByAdmin(admin);
					session.setAttribute("user", user);
					//30分钟内自动登录
					Cookie cookie=new Cookie("autologin",admin+"-"+password);
					cookie.setMaxAge(60*30);
					cookie.setPath(request.getContextPath());
					response.addCookie(cookie);
					response.sendRedirect("index.jsp");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
