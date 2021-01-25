<%@page  language="java" contentType="text/html;charset=UTF-8"
pageEncoding="UTF-8" import="JDBC.OrderDao,JDBC.GoodDao,java.util.*,JavaBean.Orders,JavaBean.Goods"%>

  <head>
      <link rel="stylesheet" href="style/min/myOrderMessage.css" media="screen and (min-device-width:320px) and (max-device-width:949px)" />
      <link rel="stylesheet" href="style/max/myOrderMessage.css" media="screen and (min-device-width:950px)" />
      <%OrderDao dao=new OrderDao();
      	GoodDao gd=new GoodDao();
      %>
      	
  </head>

  <body>
      <%@include file="header.jsp"%>
      <%Orders order=null; 
      String[] goodStr=null;
    	//商品序列
      if(user==null){
      		request.getRequestDispatcher("login.jsp").forward(request,response);
    	} else{
    		String orderid=request.getParameter("orderid");
    		//order订单对象已形成
    		order=dao.getOrderById(orderid);
    	}%>
    	
         <div id="container">
             <h1>订单详情</h1>
             <div id="message">
	    	<%if(order!=null&&order.getGoods()!=null&&order.getGoods().replace(" ", "").length()>0){
	    	goodStr=order.getGoods().split("#");
	    	//总价
	    	double sum=0;
	    	%>
             <table>
             <h2><span>订单号：</span><%=order.getOrderId() %><h2>
             <thead>
             	<tr>
             		<th>商品名</th>
             		<th>商品价格</th>
             		<th>购买数量</th>
             	</tr>
           	</thead>
           	<tbody>
           	<%for(int i=0;i<goodStr.length;i++){
           		//goodnews单个商品信息条
           		String[] GN=goodStr[i].split("~");///////////////////////////bug!!! 好像"^"不能做分隔符？？？
           		
           		String goodName=GN[0];
           		String num=GN[1];
           		Goods good=gd.getGoodByName(goodName);
           		Float price=Float.parseFloat(good.getPrice());
           		sum+=price*Integer.parseInt(num);
           		%>
           		<tr>
           			<td></td>
           			<td></td>
           			<td></td>
           		</tr>
           		<tr>
           			<td><%=goodName %></td>
           			<td><%=price %></td>
           			<td><%=num %></td>
           		</tr>
           		<%} %>
           	</tbody>
             </table>
             <div id="all-price">
             	<span>总价：</span><h2><%=sum %></h2>
             </div>
             
             <%} %>
             </div>
             
             

             <%@include file="footer.jsp"%>
         </div>

  </body>