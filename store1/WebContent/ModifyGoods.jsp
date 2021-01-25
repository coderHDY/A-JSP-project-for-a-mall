<%@page  language="java" contentType="text/html;charset=UTF-8"
pageEncoding="UTF-8" import="JDBC.GoodDao,JavaBean.Goods"%>

    <head>
        <link rel="stylesheet" href="style/min/ModifyGoods.css" media="screen and (min-device-width:320px) and (max-device-width:949px)" />
        <link rel="stylesheet" href="style/max/ModifyGoods.css" media="screen and (min-device-width:950px)" />
    </head>

    <body>
        <%@include file="header.jsp"%>
        <%String goodid=request.getParameter("goodid");
        GoodDao dao=new GoodDao();
        Goods good=null;
        if(goodid!=null){
        	good=dao.getGoodById(goodid);
        }else{
        	request.getRequestDispatcher("manager.jsp").forward(request, response);
        }%>
            <div id="container">
                <h1>修改商品信息</h1>
                <form action="MGoods" method="POST" id="good_modify">
                    <div>
                    	<div>商品编号：<input type="text" name="goodid" value="<%=good.getGoodsId() %>" placeholder="(无法更改)" id="admin" autocomplete="off" required readonly></div>
                        <div>商&nbsp;&nbsp;品&nbsp;&nbsp;名：<input type="text" name="name" placeholder="新的商品名" id="admin" autocomplete="off" required></div>
                        <div>商品种类：<select name="type">
											<option value="口红">口红</option>
											<option value="粉底">粉底</option>
											<option value="防晒">防晒</option>
											<option value="香水">香水</option>
											<option value="唇釉">唇釉</option>
											<option value="零食">零食</option>
										<select></div>
                        <div>小图路径：<input type="text" name="small" placeholder="(images/)路径"  autocomplete="off" required></div>
                        <div>大图路径：<input type="text" name="big" placeholder="(images/)路径"  autocomplete="off" required></div>
                         <div>商品介绍：<input type="text" name="description" placeholder="商品介绍" minlength="5" autocomplete="off" required></div>
                        <div>商品库存：<input type="number" name="num" placeholder="库存"  autocomplete="off" required></div>
                        <div>是否推荐：<input type="number" name="hot" placeholder="是否要让这个商品上首页呢？（0或1）"  autocomplete="off" required></div>
                        <div>商品价格：<input type="number" name="price" placeholder="卖贵点！"  autocomplete="off" required></div>
                    </div>
                    <input type="submit" id="modify" value="修改">
                </form>
                <%@include file="footer.jsp"%>
            </div>
    </body>