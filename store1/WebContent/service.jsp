<%@page  language="java" contentType="text/html;charset=UTF-8"
pageEncoding="UTF-8" import="java.util.*"%>

  <head>
      <link rel="stylesheet" href="style/min/service.css" media="screen and (min-device-width:320px) and (max-device-width:949px)" />
      <link rel="stylesheet" href="style/max/service.css" media="screen and (min-device-width:950px)" />
  </head>

  <body>
      <%@include file="header.jsp"%>
          <div id="container">
              <div id="chat-record">
              	<%ArrayList<String> messages=null;
              		messages=(ArrayList<String>)session.getAttribute("messages");
              		if(messages==null||messages.size()==0){}else{
              			for(int i=0;i<messages.size();i++){%>
			              	<div class="me_chat"><%=messages.get(i) %></div>
			              	<div class="service_chat">你好,请按照下面的操作流程进行购物：</div>
			              	<div class="service_chat">添加商品，下单，记下订单号，添加客服，<br>发送订单号并付款</div>
			              	<div class="service_chat"><img src="images/me.jpg" style="height:15rem;width:auto;"></div>
			              	<div class="service_chat">您的订单将在一天内发货！</div>
              				
              			<%} }
              		String newMessage=request.getParameter("message"); 
              		if(newMessage==null||"".equals(newMessage.replace(" ", ""))){}else{
              			String newM=new String(request.getParameter("message").getBytes("iso8859-1"),"UTF-8");%>
              			<div class="me_chat"><%=newM %></div>
		              	<div class="service_chat">你好,请按照下面的操作流程进行购物：</div>
		              	<div class="service_chat">添加商品，下单，记下订单号，添加客服，<br>发送订单号并付款</div>
		              	<div class="service_chat"><img src="images/me.jpg" style="height:15rem;width:auto;"></div>
		              	<div class="service_chat">您的订单将在一天内发货！</div>
		              	<%messages=new ArrayList<String>();
		              	messages.add(newM);
              			session.setAttribute("messages",messages);
              			} %>
              		
              		
              		
              
              

              </div>
              <form action="service.jsp" method="post">
                  <input type="text" name="message"><input type="submit" value="发送">
              </form>
              <%@include file="footer.jsp"%>
          </div>

  </body>