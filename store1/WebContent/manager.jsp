<%@page  language="java" contentType="text/html;charset=UTF-8"
pageEncoding="UTF-8" import="JavaBean.*,JDBC.*,java.util.*"%>

    <head>
        <link rel="stylesheet" href="style/min/manager.css" media="screen and (min-device-width:320px) and (max-device-width:949px)" />
        <link rel="stylesheet" href="style/max/manager.css" media="screen and (min-device-width:950px)" /> 
        <%OrderDao od=new OrderDao();
        GoodDao gd=new GoodDao();
        UserDao dao=new UserDao();
        ArrayList<Orders> orders=null;
        ArrayList<Goods> goods=null;
        ArrayList<Users> users=null;
        //order列表
        if(request.getParameter("query_order_byId")!=null&&!"".equals(request.getParameter("query_order_byId").replace(" "," "))){
        	orders=new ArrayList<Orders>();
        	orders.add(od.getOrderById(request.getParameter("query_order_byId")));
        }else if(request.getParameter("query_order_by_UserID")!=null&&!"".equals(request.getParameter("query_order_by_UserID").replace(" "," "))){
        	String userid=new String(request.getParameter("query_order_by_UserID").getBytes("ISO-8859-1"),"utf-8");  //解决中文参数！ 
        	orders=od.getOrdersByUserId(userid);
        }else{
        	orders=od.getAllOrders();
        }
      //goods列表
        if(request.getParameter("query_good_by_goodId")!=null&&!"".equals(request.getParameter("query_good_by_goodId").replace(" "," "))){
        	goods=new ArrayList<Goods>();
        	goods.add(gd.getGoodById(request.getParameter("query_good_by_goodId")));
        }else if(request.getParameter("query_good_by_goodName")!=null&&!"".equals(request.getParameter("query_good_by_goodName").replace(" "," "))){
        	String goodName=new String(request.getParameter("query_good_by_goodName").getBytes("ISO-8859-1"),"utf-8");  //解决中文参数！ 
        	goods=gd.getGoodsByName(goodName);
        }else{
        	goods=gd.getAllGoods();
        }
      //users列表
        if(request.getParameter("query_user_byAdmin")!=null&&!"".equals(request.getParameter("query_user_byAdmin").replace(" "," "))){
        	users=new ArrayList<Users>();
        	String admin=new String(request.getParameter("query_user_byAdmin").getBytes("ISO-8859-1"),"utf-8"); 
        	users.add(dao.findUserByAdmin(admin));
        }else if(request.getParameter("query_user_byName")!=null&&!"".equals(request.getParameter("query_user_byName").replace(" "," "))){
        	String userName=new String(request.getParameter("query_user_byName").getBytes("ISO-8859-1"),"utf-8");  //解决中文参数！ 
        	users=dao.findUsersByName(userName);
        }else{
        	users=dao.findAllUser();
        }
        %>
    </head>

    <body>
        <%@include file="header.jsp"%>
            <div id="container">
                <h2>宝贝们的管理员</h2>
                <ul id="title">
                    <li><a href="#orders_form">管理订单</a></li>
                    <li><a href="#goods_form">管理宝贝</a></li>
                    <li><a href="#users_form">管理上帝</a></li>
                </ul>
                <div id="lists">
                    <!--订单页面-->
                    <section id="orders_form">
                        <div class="tools">
                            <a class="add_order" href="#">
                                <img src="images/笑脸.png" alt="" class="add_order">
                            </a>
                            <form action="manager.jsp" method="POST">
                                <input type="text" name="query_order_byId" placeholder="搜索订单编号">
                                <input type="submit" value="搜索">
                            </form>
                            <form action="manager.jsp" method="POST">
                                <input type="text" name="query_order_by_UserID" placeholder="搜索用户编号">
                                <input type="submit" value="搜索">
                            </form>
                        </div>
                        <table class="list_table">
                            <thead>
                                <tr>
                                    <th>订单编号</th>
                                    <th>用户名</th>
                                    <th>商品</th>
                                    <th>价格</th>
                                    <th>是否付款</th>
                                    <th>已付</th>
                                </tr>
                            </thead>
                            <tbody>
                            <%for(int i=0;i<orders.size();i++){ 
                            String pay=null;
                            if("1".equals(orders.get(i).getPay())){
                            	pay="已支付";
                            }else{pay="未支付";}%>
                                <tr>
                           		<form action="Pays" method="POST">
                                    <td><input type="text" readonly value="<%=orders.get(i).getOrderId() %>" name="orderid"></td>
                                    <td><%=orders.get(i).getUserId() %></td>
                                    <td><%=orders.get(i).getGoods() %></td>
                                    <td><%=orders.get(i).getMoney() %></td>
                                    <td><input type="text" readonly value="<%=pay %>" name="pay"></td>
                                    <td><input type="submit" value="改" class="update"></td>
                            	</form>
                                </tr>
                                <%} %>
                            </tbody>
                        </table>
                    </section>
                    <!--商品页面-->
                    <section id="goods_form">
                        <div class="tools">
                            <a class="add_order" href="AddGood.jsp">
                                <img src="images/笑脸.png" alt="" class="add_order">
                            </a>
                            <form action="manager.jsp" method="POST">
                                <input type="text" name="query_good_by_goodId" placeholder="商品编号搜索">
                                <input type="submit" value="搜索">
                            </form>
                            <form action="manager.jsp" method="POST">
                                <input type="text" name="query_good_by_goodName" placeholder="商品名称搜索">
                                <input type="submit" value="搜索">
                            </form>
                        </div>
                        <table class="list_table">
                            <thead>
                                <tr>
                                    <th>商品编号</th>
                                    <th>商品类别</th>
                                    <th>商品名</th>
                                    <th>单价</th>
                                    <th>商品库存</th>
                                    <th>修改信息</th>
                                    <th>删除商品</th>
                                </tr>
                            </thead>
                            <tbody>
                            <%for(int i=0;i<goods.size();i++){ %>
                            <form action="ModifyGoods.jsp" method="POST">
                                <tr>
                                    <td><input type="text" readonly name="goodid" value="<%=goods.get(i).getGoodsId()%>"></td>
                                    <td><%=goods.get(i).getType() %></td>
                                    <td><%=goods.get(i).getName() %></td>
                                    <td><%=goods.get(i).getPrice() %></td>
                                    <td><%=goods.get(i).getNumber()%></td>
                                    <td><input type="submit" class="good_m" value="改"></form></td>
                                    <td><form method="POST" action="DGood"><input type="text" name="del_id" value="<%=goods.get(i).getGoodsId()%>" style="display:none"><input type="submit" value="删" class="del_good"></form></td>
                                </tr>
                            
                                <%} %>
                            </tbody>
                        </table>
                    </section>
                    <!--用户页面-->
                    <section id="users_form">
                        <div class="tools">
                            <a class="add_order" href="registered.jsp">
                                <img src="images/笑脸.png" alt="" class="add_order">
                            </a>
                            <form action="manager.jsp" method="POST">
                                <input type="text" name="query_user_byAdmin" placeholder="用户编号搜索">
                                <input type="submit" value="搜索">
                            </form>
                            <form action="manager.jsp" method="POST">
                                <input type="text" name="query_user_byName" placeholder="用户名搜索">
                                <input type="submit" value="搜索">
                            </form>
                        </div>
                        <table class="list_table">
                            <thead>
                                <tr>
                                    <th>用户账号</th>
                                    <th>用户名</th>
                                    <th>电话</th>
                                    <th>地址</th>
                                    <th>用户密码</th>
                                </tr>
                            </thead>
                            <tbody>
                            <%for(int i=0;i<users.size();i++){ %>
                                <tr>
                                    <td><%=users.get(i).getAdmin() %></td>
                                    <td><%=users.get(i).getName() %></td>
                                    <td><%=users.get(i).getPhone() %></td>
                                    <td><%=users.get(i).getAddress() %></td>
                                    <td><%=users.get(i).getPassword() %></td>
                                </tr>
                                <%} %>
                            </tbody>
                        </table>
                    </section>
                </div>
                
                <%@include file="footer.jsp"%>
            </div>
    </body>