<%@page  language="java" contentType="text/html;charset=UTF-8"
pageEncoding="UTF-8" import="java.util.*"%>

    <head>
        <link rel="stylesheet" href="style/min/index.css" media="screen and (min-device-width:320px) and (max-device-width:949px)" />
        <link rel="stylesheet" href="style/max/index.css" media="screen and (min-device-width:950px)" />
    </head>

    <body>
        <%@include file="header.jsp"%>
        <script type="text/javascript" src="script/jquery.min.js"></script>
            <script type="text/javascript" src="style/jquery.SuperSlide.2.1.3.js"></script>
        <%ArrayList<Goods> goods=(ArrayList<Goods>)request.getAttribute("showgoods"); %>

            <div id="fix">
                <div id="search-box">
                    <img src="images/logo.png">
                    <form action="index.jsp" id="find">
                        <input type="text" name="serch" id="" placeholder="搜索商品"><input type="submit" value="搜索">
                    </form>
                </div>
            </div>
                  <%if(request.getParameter("serch")==null||"".equals(((String)request.getParameter("serch")).replaceAll(" ",""))){ %>
	                <div id="top-two">
	                    <div id="top-three">
                        <!--下面是轮播图-->


                            <div id="slideBox" class="slideBox">
                                <div class="hd">
                                    <ul>
                                        <li>·</li>
                                        <li>·</li>
                                        <li>·</li>
                                    </ul>
                                </div>
                                <div class="bd">
                                    <ul>
                                        <li>
                                            <a href="#" target="_blank"><img src="images/max/goods/kouhong/amani316/01.jpg" /></a>
                                        </li>
                                        <li>
                                            <a href="#" target="_blank"><img src="images/max/goods/kouhong/amani316/02.jpg" /></a>
                                        </li>
                                        <li>
                                            <a href="#" target="_blank"><img src="images/max/goods/kouhong/amani316/03.jpg" /></a>
                                        </li>
                                    </ul>
                                </div>

                                <!-- 下面是前/后按钮代码，如果不需要删除即可 -->
                                <a class="prev" href="javascript:void(0)" style='text-decoration:none;color:white'>&lt;</a>
                                <a class="next" href="javascript:void(0)" style='text-decoration:none;color:white'>&gt;</a>
                            </div>







	                    </div>
	                </div>
				<%} else{}%>


            <div id="container">


                <div id="body-head">
                    <img src="images/max/h1.jpg" alt="">
                </div>
                <div id="body-one">
                <%for(int i=0;i<goods.size();i++){
                	Goods good=goods.get(i);
                %>
                    <a href="goodShow.jsp?goodsid=<%=good.getGoodsId() %>">
                        <div class="good">
                            <img src="<%=good.getSmall() %>" alt="">
                            <p><%=good.getName() %></p>
                        </div>
                    </a>
                    <%} %>
                	
                </div>
                <%@include file="footer.jsp"%>
            </div>

            <script type="text/javascript">
                            jQuery(".slideBox").slide({
                                mainCell: ".bd ul",
                                delayTime:1000,
                                autoPlay: true
                            });
            </script>
    </body>