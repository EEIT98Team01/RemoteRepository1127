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

		<!-- 個人訊息--->
		<div class="main_container_col_2 member_information">
			<ul class="breadcrumb">
			    <li><a href="#">首頁</a></li>
			    <li>會員專區</li>
			    <li class="active">我的訂單明細</li>
			</ul>
			<div class="welcome_text">
				<p>HI! 
					<span>雄大</span>~歡迎來到CowBaby~<span class="user_stauts">ㄧ般會員</span> 
					<a class="open_shop">我要開店</a>
				</p>
			</div>
			 個人訊息個人訊息個人訊息個人訊息
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

<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/bxslider/4.2.12/jquery.bxslider.js"></script> -->
<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bxslider/4.2.12/jquery.bxslider.css">  -->
 
<script type="text/javascript">

	$(function(){


	})
</script>
