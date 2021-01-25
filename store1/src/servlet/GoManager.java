package servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import JavaBean.Users;

/**
 * Servlet Filter implementation class GoManager
 */
//@WebFilter("/GoManager")
public class GoManager implements Filter {

    /**
     * Default constructor. 
     */
    public GoManager() {
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
		// TODO Auto-generated method stub
		//±‡¬Î
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)resp;
		Users user=(Users)request.getSession().getAttribute("user");
	    if(user==null||user.getAdmin()==null||user.getAdmin()!=("π‹¿Ì‘±")||user.getPassword()!="Kongyanan990501"){
	    	response.setStatus(404);
	    	}else {
	    		chain.doFilter(request, response);
	    	}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
