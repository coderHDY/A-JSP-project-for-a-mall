<%@page  language="java" contentType="text/html;charset=UTF-8"
pageEncoding="UTF-8" import="JDBC.*,JavaBean.*,java.util.*"%>

<head>
    <link rel="stylesheet" href="style/min/type.css" media="screen and (min-device-width:320px) and (max-device-width:949px)" />
    <link rel="stylesheet" href="style/max/type.css" media="screen and (min-device-width:950px)" />
    <%GoodDao dao=new GoodDao();
    %>
</head>

<body>
    <%@include file="header.jsp"%>
     <div id="fix">
                <div id="search-box">
                    <img src="images/logo.png">
                    <form action="index.jsp" id="find">
                        <input type="text" name="serch" id="" placeholder="搜索商品"><input type="submit" value="搜索">
                    </form>
                </div>
            </div>
       <div id="container">
           <div id="types">
               <ul>
                   <li><a href="#口红">口红</a></li>
                   <li><a href="#粉底">粉底</a></li>
                   <li><a href="#防晒">防晒</a></li>
                   <li><a href="#香水">香水</a></li>
                   <li><a href="#唇釉">唇釉</a></li>
                   <li><a href="#零食">零食</a></li>
               </ul>
           </div>

           <div id="goods">
               <section id="口红">
                   <%ArrayList<Goods> kouhong=dao.getGoodsByType("口红"); %>
                    <%for(int i=0;i<kouhong.size();i++){
                	Goods good=kouhong.get(i);%>
                    <a href="goodShow.jsp?goodsid=<%=good.getGoodsId() %>">
                        <div class="good">
                            <img src="<%=good.getSmall() %>" alt="">
                            <p><%=good.getName() %></p>
                        </div>
                    </a>
                    <%} %>
               </section>
               <section id="粉底">
                   	<%ArrayList<Goods> fendi=dao.getGoodsByType("粉底"); %>
                    <%for(int i=0;i<fendi.size();i++){
                	Goods good=fendi.get(i);%>
                    <a href="goodShow.jsp?goodsid=<%=good.getGoodsId() %>">
                        <div class="good">
                            <img src="<%=good.getSmall() %>" alt="">
                            <p><%=good.getName() %></p>
                        </div>
                    </a>
                    <%} %>
               </section>
               <section id="防晒">
                   	<%ArrayList<Goods> fangshai=dao.getGoodsByType("防晒"); %>
                    <%for(int i=0;i<fangshai.size();i++){
                	Goods good=fangshai.get(i);%>
                    <a href="goodShow.jsp?goodsid=<%=good.getGoodsId() %>">
                        <div class="good">
                            <img src="<%=good.getSmall() %>" alt="">
                            <p><%=good.getName() %></p>
                        </div>
                    </a>
                    <%} %>
               </section>
               <section id="香水">
                   	<%ArrayList<Goods> xiangshui=dao.getGoodsByType("香水"); %>
                    <%for(int i=0;i<xiangshui.size();i++){
                	Goods good=xiangshui.get(i);%>
                    <a href="goodShow.jsp?goodsid=<%=good.getGoodsId() %>">
                        <div class="good">
                            <img src="<%=good.getSmall() %>" alt="">
                            <p><%=good.getName() %></p>
                        </div>
                    </a>
                    <%} %>
               </section>
               <section id="唇釉">
                   	<%ArrayList<Goods> chunyou=dao.getGoodsByType("唇釉"); %>
                    <%for(int i=0;i<chunyou.size();i++){
                	Goods good=chunyou.get(i);%>
                    <a href="goodShow.jsp?goodsid=<%=good.getGoodsId() %>">
                        <div class="good">
                            <img src="<%=good.getSmall() %>" alt="">
                            <p><%=good.getName() %></p>
                        </div>
                    </a>
                    <%} %>
               </section>
               <section id="零食">
                   	<%ArrayList<Goods> lingshi=dao.getGoodsByType("零食"); %>
                    <%for(int i=0;i<lingshi.size();i++){
                	Goods good=lingshi.get(i);%>
                    <a href="goodShow.jsp?goodsid=<%=good.getGoodsId() %>">
                        <div class="good">
                            <img src="<%=good.getSmall() %>" alt="">
                            <p><%=good.getName() %></p>
                        </div>
                    </a>
                    <%} %>
               </section>
           </div>
           <%@include file="footer.jsp"%>
        </div>
</body>