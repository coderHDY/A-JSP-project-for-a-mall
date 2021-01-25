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
 * Servlet implementation class ModifyPasswordByUser
 */
//@WebServlet("/ModifyPasswordByUser")
public class ModifyPasswordByUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyPasswordByUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Users user=(Users)request.getSession().getAttribute("user");
		String password=request.getParameter("password");
		if(user!=null) {
			UserDao dao=new UserDao();
			user.setPassword(password);
			try {
				if(dao.updateUser(user)) {
					response.getWriter().print("–ﬁ∏ƒ√‹¬Î≥…π¶£¨«Î<a href='Logout'>÷ÿ–¬µ«¬º</a> ‘ ‘–¬√‹¬Î£°");
				}else {
					response.getWriter().print("–ﬁ∏ƒ√‹¬Î ß∞‹£¨<a href='me.jsp'>∑µªÿ</a>");
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
