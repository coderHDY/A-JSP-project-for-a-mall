package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import JDBC.GoodDao;

/**
 * Servlet implementation class DelGood
 */
//@WebServlet("/DelGood")
public class DelGood extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelGood() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String goodsid=request.getParameter("del_id");
		GoodDao dao=new GoodDao();
		try {
			if(dao.deleteGood(goodsid)) {
				response.getWriter().print("<h2 align=center>删除成功！<a href='manager.jsp'>点此返回</a></h2>");
				
			}else {
				response.getWriter().print("<h2 align=center>删除失败！<a href='manager.jsp'>点此返回</a></h2>");
			}
		} catch (SQLException e) {
			response.getWriter().print("<h2 align=center>删除失败！<a href='manager.jsp'>点此返回</a></h2>");
			e.printStackTrace();
		}
//		response.sendRedirect("manager.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
