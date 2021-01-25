package servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import JDBC.UserDao;
import JavaBean.Users;

/**
 * Servlet Filter implementation class pageEncode
 */
//@WebFilter("/pageEncode")
public class pageEncode implements Filter {

    /**
     * Default constructor. 
     */
    public pageEncode() {
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
		//编码
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)resp;
		//直接放行js文件和css文件
		StringBuffer server=request.getRequestURL(); //获取请求资源路径
		if(server.toString().contains(".css")||server.toString().contains(".js")||server.toString().contains(".png")) {
			chain.doFilter(request, response);
		}else{
			//自动登录
			Cookie[] cookie=request.getCookies();
			if(cookie!=null) {
				for(int i=0;i<cookie.length;i++) {
					if(cookie[i].getName().equals("autologin")) {
						String[] autologin=cookie[i].getValue().split("-");
						if(autologin.length>1) {
							String admin=autologin[0];
							String password=autologin[1];
							UserDao dao=new UserDao();
							try {
								Users user=dao.findUserByAdmin(admin);
								if(user!=null&&password.equals(user.getPassword())) {
									request.getSession().setAttribute("user", user);
								}
							}catch(Exception e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
			//全站编码
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			response.setCharacterEncoding("utf-8");
//			CharacterRequest characterRequest=new CharacterRequest(request);
			chain.doFilter(request, response);
	}
	
}


	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
}

