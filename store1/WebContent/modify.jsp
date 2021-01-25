<%@page  language="java" contentType="text/html;charset=UTF-8"
pageEncoding="UTF-8"%>

    <head>
        <link rel="stylesheet" href="style/min/modify.css" media="screen and (min-device-width:320px) and (max-device-width:949px)" />
        <link rel="stylesheet" href="style/max/modify.css" media="screen and (min-device-width:950px)" />
    </head>

    <body>
        <%@include file="header.jsp"%>
        <%String admin=null;
        if(user!=null&&user.getAdmin()!=null){
        admin=user.getAdmin();
        }%>
            <div id="container">
                <h1>上帝想改信息...</h1>
                <form action="mMyMessage" method="POST" id="modify">
                    <div>
                        <div>上帝名：<input type="text" name="admin" placeholder="(无法更改)<%=admin %>" id="admin" autocomplete="off" required readonly></div>
                        <div>昵&nbsp;&nbsp;&nbsp;&nbsp;称：<input type="text" name="name" placeholder="昵称" maxlength="11" autocomplete="off" required></div>
                        <div style="display:none;">头&nbsp;&nbsp;&nbsp;&nbsp;像：<input type="file" name="image" autocomplete="off" accept="image/gif,image/png,image/jpg,image/jpeg" value=" "></div>
                        <div>电&nbsp;&nbsp;&nbsp;&nbsp;话：<input type="text" name="phone" placeholder="请输入收货电话" maxlength="11" autocomplete="off" required> </div>
                        <div>地&nbsp;&nbsp;&nbsp;&nbsp;址：<input type="text" name="address" placeholder="请输入收货地址" autocomplete="off" required></div>
                    </div>

                    <input type="submit" id="modify-submit" value="修改">
                </form>
                <%@include file="footer.jsp"%>
            </div>
    </body>