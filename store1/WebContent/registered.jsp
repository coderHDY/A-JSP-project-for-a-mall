<%@page  language="java" contentType="text/html;charset=UTF-8"
pageEncoding="UTF-8"%>

    <head>
        <link rel="stylesheet" href="style/min/registered.css" media="screen and (min-device-width:320px) and (max-device-width:949px)" />
        <link rel="stylesheet" href="style/max/registered.css" media="screen and (min-device-width:950px)" />
    </head>

    <body>
    <%@include file="header.jsp"%>
    <div id="container">
        <h1>欢迎注册！</h1>
        <form action="CreateUser" method="POST" id="registered">
            <div>
                <div>用户名：<input type="text" name="admin" placeholder="请输入账户名(建议用手机号)" id="admin" autocomplete="off" maxlength="11" required></div>
                <div>密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="password" placeholder="请输入密码(8~16位)" id="password" minlength="8" maxlength="16" autocomplete="new-password" required></div>
                <div>密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="password" placeholder="请确认密码" id="password" minlength="8" maxlength="16" autocomplete="new-password" required></div>
                <div>昵&nbsp;&nbsp;&nbsp;&nbsp;称：<input type="text" name="name" placeholder="昵称" autocomplete="off" maxlength="8" required></div>
                <div style="display:none;">头&nbsp;&nbsp;&nbsp;&nbsp;像：<input type="file" name="portrait" autocomplete="off" accept="image/gif,image/png,image/jpg,image/jpeg" value=" "></div>
                <div>电&nbsp;&nbsp;&nbsp;&nbsp;话：<input type="text" name="phone" placeholder="请输入收货电话" maxlength="11" autocomplete="off" required> </div>
                <div>地&nbsp;&nbsp;&nbsp;&nbsp;址：<input type="text" name="address" placeholder="请输入收货地址" autocomplete="off" required></div>
            </div>
            <input type="submit" id="registered-submit" value="注册">
        </form>
        <%@include file="footer.jsp"%>
    </div>
    </body>