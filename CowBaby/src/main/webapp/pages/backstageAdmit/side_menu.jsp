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
				  	
			<li class="memberManagment">
				<a href="member_managment.jsp">
			    	<i class="fa fa-dashboard"></i>
			        <span>會員管理</span>
			    </a>
			</li>
		     
		    <li class="sub-menu auditComplaints">
		         <a href="audit_complaints.jsp" >
		             <i class="fa fa-cog" aria-hidden="true"></i>
		             <span>審核管理</span>
		              <i class="fa fa-chevron-down" aria-hidden="true"></i> 
		         </a>
		         <ul class="sub">
		             <li><a href="audit_complaints.jsp">客服申訴</a></li>
		             <li><a href="audit_advertisement.jsp">廣告審核</a></li>
		             <li><a href="audit_shop.jsp">賣家審核</a></li>
		         </ul>
		    </li>
		     
		    <li class="sub-menu adManagement">
		         <a href="ad_management_banner.jsp" >
		             <i class="fa fa-file-text" aria-hidden="true"></i>
		             <span>廣告管理</span>
		              <i class="fa fa-chevron-down" aria-hidden="true"></i> 
		         </a>
		         <ul class="sub">
		             <li><a href="ad_management_banner.jsp">Slideshow</a></li>
		             <li><a href="ad_management_seller_ad.jsp">賣家廣告欄位</a></li>
		         </ul>
		     </li>
		
		     <li class="sub-menu productManagement">
		         <a href="product_management_list.jsp" >
		             <i class="fa fa-gift" aria-hidden="true"></i>
		             <span>商品管理</span>
		             <i class="fa fa-chevron-down" aria-hidden="true"></i>
		         </a>
		         <ul class="sub">
		             <li><a href="product_management_list.jsp">商品列表頁</a></li>
		             <li><a href="product_management_sort.jsp">商品分類設定</a></li>
		             <li><a href="product_management_sale_report.jsp">銷售報表</a></li> 
		         </ul>
		     </li>
		     
		     <li class="sub-menu msg">
		         <a href="send_msg.jsp">
		             <i class="fa fa-envelope-o"></i>
		             <span>訊息管理</span>
		         </a> 
		     </li>
		
		     <li class="sub-menu blog">
		          <a href="blog_list.jsp">
		          	 <i class="fa fa-th"></i>
		             <span>媽咪上稿</span>
		             <i class="fa fa-chevron-down" aria-hidden="true"></i>
		         </a>
		         <ul class="sub">
		             <li><a href="blog_list.jsp">文章列表</a></li>
		             <li><a href="blog_add.jsp">新增文章</a></li>
		             <li><a href="blog_delete.jsp">修改文章</a></li> 
		         </ul>
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


