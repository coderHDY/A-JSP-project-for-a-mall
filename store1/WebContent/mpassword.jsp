<%@page  language="java" contentType="text/html;charset=UTF-8"
pageEncoding="UTF-8"%>

    <head>
        <link rel="stylesheet" href="style/min/mpassword.css" media="screen and (min-device-width:320px) and (max-device-width:949px)" />
        <link rel="stylesheet" href="style/max/mpassword.css" media="screen and (min-device-width:950px)" />
    </head>

    <body>
        <%@include file="header.jsp"%>
        <%String admin=null;
        if(user!=null&&user.getAdmin()!=null){
        admin=user.getAdmin();
        }%>
            <div id="container">
                <h1>上帝想改密码...</h1>
                <form action="mMyPassword" method="POST" id="modify">
                    <div>
                        <div>上帝名：<input type="text" name="admin" placeholder="(无法更改)<%=admin %>" id="admin" autocomplete="off" required readonly></div>
                        <div>密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="password" placeholder="新密码" maxlength="11" autocomplete="off" required></div>
                        <div>密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="password2" placeholder="确认新密码" maxlength="11" autocomplete="off" required></div>
                    </div>
                    <input type="submit" id="modify-password" value="修改">
                </form>
                <%@include file="footer.jsp"%>
            </div>
    </body>