package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import JDBC.GoodDao;
import JavaBean.Goods;

/**
 * Servlet Filter implementation class HomePageFind
 */
//@WebFilter("/HomePageFind")
public class HomePageFind implements Filter {

    /**
     * Default constructor. 
     */
    public HomePageFind() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)resp;
		String serch=request.getParameter("serch");
		GoodDao dao=new GoodDao();
		if(serch!=null&&!"".equals(serch.replace(" ", ""))) {
			try {
				ArrayList<Goods> goods=dao.getGoodsByName(serch);
				request.setAttribute("showgoods", goods);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			try {
				ArrayList<Goods> goods=dao.getGoodsByHot();
				request.setAttribute("showgoods", goods);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
