<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>cow baby 管理著後台</title>
<link rel="icon" href="logo.ico">
</head>

<!--css-->
<link rel="stylesheet" href="<c:url value="/css/backstageAdmitMainStyle.css"/>">

<!--body-->
<body>
	<section id="container" >
		<!--引入 header-->
		<jsp:include page="/pages/backstageAdmit/header_backstage.jsp"/>
		
		<!--引入 側邊蘭選單-->
		<jsp:include page="/pages/backstageAdmit/side_menu.jsp"/>
		
		<!--main-content-->
		<!--主要內容-->
     	<section id="main-content">
			<section class="wrapper" id="account_overview">
				<div class="breadcrumb-row">
					<h3>會員編輯</h3>
					<ol class="breadcrumb">
					  	<li><a href="#">會員管理</a></li>
					</ol>
				</div>
				<div class="row">
					<div class="clear-both"></div>
				</div>
				<!--這邊開始寫內容-->
					<span>${customerData.customerID}</span>
				<!-- 內容結束 -->
			</section>
			<!-- wrapper end -->
      	</section>
      	<!-- main-content end -->
	</section>
	<!-- container end -->
</body>
</html>

<!-- javasript pluging link CDN-->
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-switch/3.3.4/js/bootstrap-switch.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap3-dialog/1.34.7/js/bootstrap-dialog.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.4/js/bootstrap-select.min.js"></script>

<script>
$(function(){
	// side_menu 帳戶總覽填充背景色
	$(".memberManagment a").addClass('active');
// 	var html="";
// 	var count = 1;
// 	$.getJSON('http://localhost:8080/CowBaby/service/getCustomerData',{},function(datas){
	     
		
// 		$.each(datas,function(idx,customer){
// 	    	 var html="";
	    	 
// 		    	html="<tr>"+
// 							"<td>"+(idx+1)+"</td>" +
// 							"<td>"+customer.email+"</td>" +
// 							"<td>"+customer.customerName+"</td>" +
// 							"<td>"+customer.mobilePhone+"</td>" +
// 							"<td>"+customer.gender+"</td>" +
// 							"<td>"+customer.userID+"</td>" +
// 							"<td>"+customer.consumerSegmentation+"</td>" +
// 							"<td>"+customer.totalAmoutOfConsumption+"</td>" +
// 							"<td> <a href=# class='btn btn-success'> <i class='fa fa-eye'></i> </a> </td>" +
// 							"<td> <a href=# class='btn btn-primary'> <i class='fa fa-pencil'></i> </a> </td>" +
// 						 "</tr>";				
// 		    	$('tbody').append(html);
// 	     });
//    });

})
</script>