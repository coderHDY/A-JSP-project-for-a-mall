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
				response.getWriter().println("�Բ���ע��ʧ�ܣ��û����Ѵ��ڣ�<a href='registered.jsp'><h2>�������ע��</h2></a>");    //��Ҫ���û��Ѵ�����תҳ��
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
//							if(me.getAdmin().equals("����Ա")) {
//								response.sendRedirect("manager.jsp");
//							}else {
//								response.getWriter().println("��ϲ��ע��ɹ���<a href='login.jsp'><h2>���ȥ��¼</h2></a>");
//							}
//							
//						}else {
							
							response.getWriter().println("<h3 align=center>��ϲ��ע��ɹ���<a href='login.jsp'><h2>���ȥ��¼</h2></a></h3>");     //��Ҫ��ע��ɹ�����תҳ��
//						}
					}else {
						response.getWriter().print("<h2>δ֪����...</h2>");     //��Ҫ����תҳ��
					}
				}	
			}catch (SQLException e) {
				response.getWriter().print("<h2>δ֪����...</h2>"); 
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
