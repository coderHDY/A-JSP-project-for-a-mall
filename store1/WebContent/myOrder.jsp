<%@page  language="java" contentType="text/html;charset=UTF-8"
pageEncoding="UTF-8" import="JDBC.OrderDao,java.util.*"%>

  <head>
      <link rel="stylesheet" href="style/min/myOrder.css" media="screen and (min-device-width:320px) and (max-device-width:949px)" />
      <link rel="stylesheet" href="style/max/myOrder.css" media="screen and (min-device-width:950px)" />
      <%OrderDao dao=new OrderDao();
      %>
      	
  </head>

  <body>
      <%@include file="header.jsp"%>
      <%ArrayList<Orders> orders=null; 
      if(user==null){
      		request.getRequestDispatcher("login.jsp").forward(request,response);
    	} else{
    		String userid=user.getAdmin();
    		orders=dao.getOrdersByUserId(userid);
    	}%>
    	
          <div id="container">
              
              <table id="orders">
              	<caption>那些年上帝剁过的手...</caption>
              	<thead>
              	</thead>
              	<tbody>
              		<%for(int i=0;i<orders.size();i++){ 
              			String pay="";
              			if("1".equals(orders.get(i).getPay())){
              				pay="已支付";
              			}else{
              				pay="未支付";
              			}
              		%>
              		<tr>
              			<form action="myOrderMessage.jsp" method="POST">
              			<td><input type="text" name="orderid" value="<%=orders.get(i).getOrderId()%>" readonly></th>
              			<td><%=pay %></th>
              			<td><input type="submit" value="详细信息" class="goMessage"></th>
              			</form>
              		</tr>
              		
              		<%} %>
              	</tbody>
              </table>
              
              
              
              
              
              
              
              
              <%@include file="footer.jsp"%>
          </div>

  </body>