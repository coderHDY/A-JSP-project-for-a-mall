package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import JDBC.UserDao;
import JavaBean.Users;

/**
 * Servlet implementation class ForgetPassword
 */
//@WebServlet("/ForgetPassword")
public class ForgetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgetPassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ͨ���˺ź͵绰���޸�����
		String admin=request.getParameter("admin");
		String phone=request.getParameter("phone");
		String password=request.getParameter("password");
		UserDao dao=new UserDao();
		try {
			Users user=dao.findUserByAdmin(admin);
			if(user!=null&&user.getPhone()!=null) {
				if(phone.equals(user.getPhone())) {
					user.setPassword(password);
					dao.updateUser(user);
					response.getWriter().print("�޸�<h1>�ɹ�</h1>����������Ŷ��<a href='login.jsp'>����ȥ��¼</a>");
				}else {
					response.getWriter().print("�޸�<h1>ʧ��</h1>��̫���ˣ�<a href='index.jsp'>����ȥ���</a>");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
