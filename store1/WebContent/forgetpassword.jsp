<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>

    <head>
        <link rel="stylesheet" href="style/min/fpassword.css" media="screen and (min-device-width:320px) and (max-device-width:949px)" />
        <link rel="stylesheet" href="style/max/fpassword.css" media="screen and (min-device-width:950px)" />
    </head>

    <body>
        <%@include file="header.jsp"%>
            <div id="container">
                <h1>上帝记性不太好...</h1>
                <form action="fMyPassword" method="POST" id="modify">
                    <div>
                    	<div>上帝名：<input type="text" name="admin" placeholder="请输入账号" id="admin" autocomplete="off" required></div>
                        <div>电&nbsp;&nbsp;&nbsp;&nbsp;话：<input type="text" name="phone" placeholder="电话你总记得吧？？" id="phone" autocomplete="off" required></div>
                        <div>新密码：<input type="password" name="password" placeholder="新密码" maxlength="11" autocomplete="off" required></div>
                        <div>密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="password2" placeholder="确认新密码" maxlength="11" autocomplete="off" required></div>
                    </div>
                    <input type="submit" id="modify-password" value="修改">
                </form>
                <%@include file="footer.jsp"%>
            </div>
    </body>