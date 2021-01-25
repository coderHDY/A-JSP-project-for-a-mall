<%@page  language="java" contentType="text/html;charset=UTF-8"
pageEncoding="UTF-8" import="JavaBean.*" %>

    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="style/min/header.css" media="screen and (min-device-width:320px) and (max-device-width:949px)" />
        <link rel="stylesheet" href="style/max/header.css" media="screen and (min-device-width:950px)" />
        <script src="script/jquery.min.js"></script>
        <script src="script/max/home.js"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0,user-scalable=0">
        <title>南瓜的小铺子</title>
    </head>

    <body>
        <header id="top">
            <nav>
                <ul>
                    <li><a href="index.jsp">首页</a></li>
                    <li><a href="type.jsp">分类</a></li>
                    <li><a href="service.jsp">联系客服</a></li>
                    <li><a href="cart.jsp">购物车</a></li>
                    <li><a href="me.jsp">我的信息</a></li>
                    <%	Users user=(Users)session.getAttribute("user");
    if(user==null){%>
                        <div id="is-login">你好，请先<a href="login.jsp">登录</a>！</div>
                        <% }else{
    	String admin=user.getAdmin();
    	if(admin!=null&&admin.equals("管理员")){ %>
                            <div id="is-login">欢迎您，
                                <a href="manager.jsp">
                                    <%=user.getName() %>
                                </a>！<a href="Logout">注销</a></div>

                            <% }else if(admin!=null&&admin.length()>0){%>
                                <div id="is-login">欢迎您，
                                    <a href="me.jsp">
                                        <%=user.getName() %>
                                    </a>！<a href="Logout">注销</a></div>
                                <%	}else{%>
                                    <div id="is-login">你好，请先<a href="login.jsp">登录</a>！</div>
                                    <%}} %>

                </ul>
            </nav>
        </header>

        <div id="min-top">
            <nav>
                <ul>
                    <li>
                        <a href="index.jsp"><img src="images/min/home.png" alt=""></a>
                    </li>
                    <li>
                        <a href="type.jsp"><img src="images/min/type.png" alt=""></a>
                    </li>
                    <li>
                        <a href="service.jsp"><img src="images/min/service.png" alt=""></a>
                    </li>
                    <li>
                        <a href="cart.jsp"><img src="images/min/cart.png" alt=""></a>
                        </a>
                    </li>
                    <li>
                        <a href="me.jsp"><img src="images/min/me.png" alt=""></a>
                        </a>
                    </li>
                </ul>
            </nav>

        </div>
    </body>

    </html>