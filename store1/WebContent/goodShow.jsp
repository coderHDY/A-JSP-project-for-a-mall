<%@page  language="java" contentType="text/html;charset=UTF-8"
pageEncoding="UTF-8" import="JDBC.*"%>

    <head>
        <link rel="stylesheet" href="style/min/goodshow.css" media="screen and (min-device-width:320px) and (max-device-width:949px)" />
        <link rel="stylesheet" href="style/max/goodshow.css" media="screen and (min-device-width:950px)" />
    </head>

    <body>
        <%@include file="header.jsp"%>
        <div id="container">
             <form action="PutInMyCart" id="good" method="POST">
             	<%GoodDao dao=new GoodDao();
             	Goods good=null;
             	if(request.getParameter("goodsid")!=null){
             		good=dao.getGoodById(request.getParameter("goodsid"));%>
             	
             		 
             	<input readonly name="good_name" value="<%=good.getName() %>" id="good_name"/>
             	<div id="images">
             		<img alt="" src="<%=good.getBig() %>">
             	</div>
             	<p><%=good.getDescription() %></p>
             <%}else{%>
            	 <h2>对不起，宝贝不存在</h2>
             <%} %>
             <input type="submit" id="add_cart" value="加"/>
             </form>
        <%@include file="footer.jsp"%>
        </div>
    </body>