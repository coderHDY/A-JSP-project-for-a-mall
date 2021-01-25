package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import JDBC.GoodDao;
import JavaBean.Goods;

/**
 * Servlet implementation class AGood
 */
//@WebServlet("/AGood")
public class AGood extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AGood() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				Goods good=new Goods();
				String name=request.getParameter("name");
				String small=request.getParameter("small");
				String big=request.getParameter("big");
				String number=request.getParameter("num");
				String price=request.getParameter("price");
				String type=request.getParameter("type");
				String description=request.getParameter("description");
				String hot=request.getParameter("hot");
				good.setName(name);
				good.setType(type);
				good.setSmall(small);
				good.setBig(big);
				good.setNumber(number);
				good.setPrice(price);
				good.setDescription(description);
				good.setHot(hot);
				GoodDao dao=new GoodDao();
				try {
					if(dao.addGood(good)) {
						response.getWriter().println("<h1 align=center>添加成功！<a href='manager.jsp'>点此返回</a></h1>");
					}else {
						response.getWriter().println("<h3 align=center>添加失败！程序猿太蠢了！又出BUG了！<a href='manager.jsp'>点此返回管理员界面！</a></h3>");
						
					}
					
				} catch (Exception e) {
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
