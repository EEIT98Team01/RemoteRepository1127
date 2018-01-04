<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>cow babye購物商城</title>
	<link rel="icon" href="logo.ico">
</head>

<!--css-->
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css"> 
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-switch/3.3.4/css/bootstrap3/bootstrap-switch.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap3-dialog/1.34.7/css/bootstrap-dialog.min.css">

<link rel="stylesheet" href="<c:url value="/pluging/Bxsliders/jquery.bxslider.min.css"/>"> 
<link rel="stylesheet" href="<c:url value="/css/frontDesk/basic.css"/>">
<link rel="stylesheet" href="<c:url value="/css/frontDesk/member_account_order.css"/>">


<!--body-->
<body>
	<!--引入 topbar 跟  header-->
	<jsp:include page="/pages/common/topbar_and_header.jsp"/>
	
	<!-- 這邊 開始寫內容-->
	<!--每頁 page_container-->
	<section class="page_container member_information_container">
		<div class="side_bar">
			<div class="title">會員專區</div>
			<div class="member_infor_menu">
				<ul>
					<li> <a href="<c:url value="/pages/member/member_account_infor.jsp"/>"><i class="fa fa-user" aria-hidden="true"></i>會員資料</a></li>
					<li> <a href="<c:url value="/pages/member/member_account_update_infor.jsp"/>"><i class="fa fa-pencil" aria-hidden="true"></i>修改會員資料</a></li>
					<li> <a href="<c:url value="/pages/member/member_account_order.jsp"/>"><i class="fa fa-shopping-basket" aria-hidden="true"></i>我的消費明細</a></li>
					<li> <a href="<c:url value="/pages/member/member_account_msg.jsp"/>"><i class="fa fa-envelope" aria-hidden="true"></i>訊息</a></li>
				</ul>	
			</div>	
		</div>

		<!-- 個人商店頁面-->
		<div class="main_container_col_2 member_information">
			<ul class="breadcrumb">
			    <li><a href="#">首頁</a></li>
			    <li>會員專區</li>
			    <li class="active">我的訂單明細</li>
			</ul>
			<div class="welcome_text">
				<p>HI! 
					<span style="color: #f1648f;font-size: 15px;">${user.customerName}</span>~歡迎來到CowBaby~
					<span class="user_stauts">
						<c:if test="${user.userID==1}">
						   <c:out value="一般會員"/>
						</c:if>
						<c:if test="${user.userID==2}">
						   <c:out value="平台賣家"/>
						</c:if>	
						<c:if test="${user.userID==3}">
						   <c:out value="黑名單"/>
						</c:if>				
					</span> 
					<c:if test="${user.userID==1}">
					<a class="open_shop" href="<c:url value="/pages/member/member_apply_shop.jsp"/>">我要開店</a>
					</c:if>
				</p>
			</div>
			
			<!--這邊開始寫內容-->
			<div class="order_detail">
				<table>
				    <thead>
				      	<tr>
							<th>商品名稱</th>
							<th>數量</th>
							<th>規格</th>
							<th>價錢</th>
				      	</tr>
				    </thead>
				    <tbody>
					    <c:forEach var="orderDetail" varStatus="st" items="${orderDetail_list}">
							<tr>
								<td><a href='<c:url value='/ProductItemOfShop?storeID=&productID=${orderDetail[5]}'/>' target="_blank">${orderDetail[0]}</a></td>
								<td>${orderDetail[2]}</td>
								<td>${orderDetail[3]}</td>
								<td>${orderDetail[4]}</td>	
							</tr>
						</c:forEach>						  	

					    <tr>
					        <td colspan="3" style="text-align: right;">本次使用紅利</td>
					        <td><span class="bonus">${orderData.usebonus}</span>點</td>
					    </tr>

					    <tr>
					        <td colspan="3" style="text-align: right;">總價</td>
					        <td><span class="price">${orderData.totalAmount}</span>元</td>
					    </tr>
				    </tbody>
				</table>
				
				<table>
					<thead>
						<tr>
							<td colspan="2">訂單資訊</td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>購買店家</td>
							<td><a href="<c:url value='/PersonShopController?storeID=${store.storeID}&email=${store.email}'/>" target="_blank">${store.storeName}</a></td>
						<tr>
						<tr>
							<td>訂單編號</td>
							<td>${orderData.orderID}</td>
						<tr>
						<tr>
							<td>下訂日期</td>
							<td>${1900+orderData.orderDate.year}-${1+orderData.orderDate.month}-${orderData.orderDate.date}</td>
						<tr>
						<tr>
							<td>收件人姓名</td>
							<td>${orderData.receiverName}</td>
						<tr>
						<tr>
							<td>收件人信箱</td>
							<td>${orderData.receiverEmail}</td>
						<tr>
						<tr>
							<td>收件人電話</td>
							<td>${orderData.receiverPhone}</td>
						<tr>
						<tr>
							<td>取貨超商</td>
							<td>${orderData.pickUpStore}</td>
						<tr>
					</tbody>
				</table>
				
			</div>
		</div>	
			
	</section>
	
	<!--引入 footer-->
	<jsp:include page="/pages/common/footer.jsp"/>
</body>
</html>


<!-- Bootstrap core JavaScript-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-switch/3.3.4/js/bootstrap-switch.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap3-dialog/1.34.7/js/bootstrap-dialog.min.js"></script>
<script src="<c:url value="/pluging/Bxsliders/jquery.bxslider.min.js"/>"></script>
<script src="<c:url value="/pluging/Bootsrap/jquery.twbsPagination.js"/>"></script>
<script src="https://cdn.jsdelivr.net/npm/gasparesganga-jquery-loading-overlay@1.5.4/src/loadingoverlay.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/gasparesganga-jquery-loading-overlay@1.5.4/extras/loadingoverlay_progress/loadingoverlay_progress.min.js"></script>

<script type="text/javascript">

	$(function(){

	})
</script>
