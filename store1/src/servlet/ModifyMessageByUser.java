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
 * Servlet implementation class ModifyMessageByUser
 */
//@WebServlet("/ModifyMessageByUser")
public class ModifyMessageByUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyMessageByUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//用户修改信息
		Users user=(Users)request.getSession().getAttribute("user");
		String name=request.getParameter("name");
		String image=request.getParameter("image");
		String phone=request.getParameter("phone");
		String address=request.getParameter("address");
		user.setName(name);
		user.setAddress(address);
		user.setPhone(phone);
		user.setImage(image);
		UserDao dao=new UserDao();
		try {
			if(dao.updateUser(user)) {
				response.getWriter().print("<h2 align=center>修改成功，<a href='me.jsp'>点此返回</a></h2>");
			}else {
				response.getWriter().print("修改失败，<a href='me.jsp'>点此返回</a>");
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
