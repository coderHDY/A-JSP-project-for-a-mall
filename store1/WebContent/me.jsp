<%@page  language="java" contentType="text/html;charset=UTF-8"
pageEncoding="UTF-8" import="JavaBean.Users"%>

    <head>
        <link rel="stylesheet" href="style/min/me.css" media="screen and (min-device-width:320px) and (max-device-width:949px)" />
        <link rel="stylesheet" href="style/max/me.css" media="screen and (min-device-width:950px)" />
    </head>

    <body>
    <%@include file="header.jsp"%>
    <%String name=null,admin=null,phone=null,image=null,address=null,password=null;  
    if(user!=null){
    	name=user.getName();
    	admin=user.getAdmin();
    	phone=user.getPhone();
    	image=user.getImage();
    	address=user.getAddress();
    	password=user.getPassword();
    }%>
    <% %>
    
    
    <div id="container">
        <h1 align="center">上帝的信息</h1>
        <div id="my-infomation">
            <div align="center" id="protrait"></div>
            <div>昵称：<span><%=name %></span></div>
            <div>电话：<span><%=phone %></span></div>
            <div>账号：<span><%=admin%></span></div>
            <div>地址：<span><%=address%></span></div>
            <%if("管理员".equals(admin)&&"Kongyanan990501".equals(password)){ %>
            <a href="manager.jsp" id="modify">
                <div>
                    <h3>管理界面</h3>
                </div>
            </a>
            <%} %>
            <a href="myOrder.jsp" id="modify">
                <div>
                    <h3>我的订单</h3>
                </div>
            </a>
            <a href="modify.jsp" id="modify">
                <div>
                    <h3>修改信息</h3>
                </div>
            </a>
            <a href="mpassword.jsp" id="modify_password">
                <div>
                    <h3>修改密码</h3>
                </div>
            </a>
            <a href="Logout" id="logout">
                <div>
                    <h3>朕下线了</h3>
                </div>
            </a>
        </div>
        <%@include file="footer.jsp"%>
    </div>