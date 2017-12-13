<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- 後台 側邊選單 -->
<!--sidebar-->
<aside>
	<div id="sidebar">
		<ul class="sidebar-menu" id="nav-accordion">
			<div  class="welcome-row">
			 	<img src="${pageContext.request.contextPath}/images/line.jpg" class="img-circle" width="60">
			 	<h5 class="centered">WELCOME!</h5>
			</div>
				  	
			<li>
				<a href="account_overview.jsp">
			    	<i class="fa fa-dashboard"></i>
			        <span>帳戶總覽</span>
			    </a>
			</li>
		     
		    <li>
		         <a href="store_setting.jsp" >
		             <i class="fa fa-cog" aria-hidden="true"></i>
		             <span>商店設置</span> 
		         </a>
		    </li>
		     
		    <li>
		         <a href="order_list.jsp" >
		             <i class="fa fa-file-text" aria-hidden="true"></i>
		             <span>訂單查詢</span> 
		         </a>
		     </li>
		
		     <li class="sub-menu">
		         <a href="product_list.jsp" >
		             <i class="fa fa-gift" aria-hidden="true"></i>
		             <span>商品管理</span>
		             <i class="fa fa-chevron-down" aria-hidden="true"></i>
		         </a>
		         <ul class="sub">
		             <li><a href="product_list.jsp">全部商品列表</a></li>
		             <li><a href="product_add.jsp">新增商品</a></li>
		         </ul>
		     </li>
		     
		     <li class="sub-menu">
		         <a href="message_list.jsp">
		             <i class="fa fa-envelope-o"></i>
		             <span>訊息管理</span> 
		         </a> 
		     </li>
		
		     <li class="sub-menu">
		          <a href="advertisement_buy.jsp">
		          	 <i class="fa fa-th"></i>
		             <span>購買廣告</span>
		         </a>
		     </li>
		 </ul>
	</div>
</aside>
<!-- javasript pluging link CDN-->
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-switch/3.3.4/js/bootstrap-switch.min.js"></script>

<!--  
<script src="${pageContext.request.contextPath}/js/backstageSeller/side_menu.js"></script>-->


