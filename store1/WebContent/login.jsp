<%@page  language="java" contentType="text/html;charset=UTF-8"
pageEncoding="UTF-8"%>


    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="style/min/login.css" media="screen and (min-device-width:320px) and (max-device-width:949px)" />
        <link rel="stylesheet" href="style/max/login.css" media="screen and (min-device-width:950px)" />

        <title>南瓜的小铺子</title>
    </head>

    <body>
    <%@include file="header.jsp"%>
    <div id="container">
        <h1>请先登录！</h1>
        <form action="login" method="POST" id="login">
            <input type="text" name="admin" placeholder="请输入账户名" id="admin" autocomplete="off" required>
            <input type="password" name="password" placeholder="请输入密码" id="password" autocomplete="off" required>
            <input type="submit" id="login-submit" value="登录"><a href="registered.jsp" id="registered">注册</a>
            <span><a href="forgetpassword.jsp" id="forget">忘记密码</a></span>
        </form>
        <%@include file="footer.jsp"%>
    </div>
    </body>