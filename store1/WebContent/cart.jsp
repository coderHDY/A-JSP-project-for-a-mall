<%@page  language="java" contentType="text/html;charset=UTF-8"
pageEncoding="UTF-8" import="java.util.*,JDBC.*"%>
    <head>
        <link rel="stylesheet" href="style/min/cart.css" media="screen and (min-device-width:320px) and (max-device-width:949px)" />
        <link rel="stylesheet" href="style/max/cart.css" media="screen and (min-device-width:950px)" />
    </head>

    <body>
    <%@include file="header.jsp"%>

    <div id="container">
        <form action="Buy">
            <table>
                <caption>
                    <h2>主人的宝贝们</h2>
                </caption>
                <thead>
                    <tr>
                        <th>宝贝名</th>
                        <th>宝贝的样子</th>
                        <th>宝贝的数量</th>
                        <th>宝贝的单价</th>
                        <th>买买买</th>
                    </tr>
                </thead>
                <tbody id="goods_list">
       		 	<%if(user!=null&&user.getCart()!=null&&!"".equals(user.getCart().replace(" ", ""))){ %>

       		 	<%GoodDao dao=new GoodDao();
		        	String[] cart=user.getCart().split("#");
                	for(int i=0;i<cart.length;i++){
                	Goods good=dao.getGoodByName(cart[i]);
                	%>
			        
                  <tr>
                      <td><input type="text" name="goodName" value="<%=good.getName() %>" readonly></td>
                      <td><img src="<%=good.getSmall() %>" alt=""></td>
                      <td><input type="number" name="number" value="1" size="5rem" max="999" min="0"></td>
                      <td class="one_price"><%=good.getPrice() %></td>
                      <td><input type="checkbox" name="is_by" value="<%=i%>"><span>买！</span></td>
                  </tr>
                    <%}} %>
                      
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td>合计：<span id="sum_box">0.00</span></td>
                        <td><input type="submit" name="buy" value="买" id="buy"></td>
                    </tr>
                </tbody>
            </table>
        </form>


        <%@include file="footer.jsp"%>
    </div>