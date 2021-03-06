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
<link rel="stylesheet" href="<c:url value="/css/frontDesk/member_account_update_infor.css"/>">


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
			    <li class="active">會員資訊</li>
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
			<div class="review_member_infor">
			<form action="${pageContext.servletContext.contextPath}/CustomerUpdate.controller"
			      method="POST">
				<div class="wrapper">
					<div class="title">會員基本資訊</div>
					<div class="wrapper_box1">
						<table>
							<tr>
								<td>帳號E-mail</td>
								<td>${user.email}</td>
								<input type="text" style="display:none" name="customerID" value="${user.customerID}" />
								<td>會員註冊日</td>
								<td>${user.createTime}</td>
							</tr>
							<tr>
								<td>累積消費金額</td>
								<td>${user.totalAmoutOfConsumption}</td>
								<td>消費紅利</td>
								<td>${user.bonus}</td>
							</tr>
							<tr>
								<td>修改密碼</td>
								<td><input type="text" class="form-control" name="password" id="password" value="${user.password}"><p style="color: #e21124;">${errors.password}</p></td>
								
								<td>確認密碼</td>
								<td><input type="text" class="form-control" name="checkPassword" id="checkPassword" value="${user.password}"><p style="color: #e21124;">${errors.checkPassword}</p></td>
								
							</tr>
						</table>
					</div>
					<div class="title" style="margin-top: 40px;">個人基本資料 Personal information </div>
					<div class="wrapper_box1 num2">
						<table>
							<tr>
								<td>您的大名 * :</td>
								<td>${user.customerName}</td>
								<td>您的性別 * :</td>
								<td>${user.gender}</td>
							</tr>
							<tr>
								<td>您的生日 * :</td>
								<td>${user.birthday}</td>
								<td>婚姻狀況 * :</td>
								<c:if test="${user.marriage==false}">
									<td colspan="3">未婚</td>
								</c:if>
								<c:if test="${user.marriage==true}">
									<td colspan="3">已婚</td>
								</c:if>
							</tr>
							<tr>
								<td>您的電話 *:</td>
								<td><input type="text" class="form-control" name="landline" id="landline" value="${user.landline}"></td>
								<td>行動電話*</td>
								<td><input type="text" class="form-control" name="mobilePhone" id="mobilePhone" value="${user.mobilePhone}"></td>
							</tr>
							<tr>
								<td>聯絡地址 * :</td>
								<td><input type="text" class="form-control" name="address" id="address" value="${user.address}"></td>
								<td>月收入狀況 :</td>
								<td><input type="text" class="form-control" name="income" id="income" value="${user.income}"></td>
							</tr>
							<tr>
								<td>是否定閱電子報 :</td>
								<td colspan="3">
									<label class="radio-inline"><input type="radio" name="subscription" id="subscription"> 是 </label>
									<label class="radio-inline"><input type="radio" name="subscription" id="subscription"> 否 </label>
								</td>
							</tr>
						</table>	
					</div>	
				</div>
				<div><button  type="submit" class="btn btn-primary pull-right">確認提交</button></div>
				</form>
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

<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/bxslider/4.2.12/jquery.bxslider.js"></script> -->
<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bxslider/4.2.12/jquery.bxslider.css">  -->
 



<script type="text/javascript">

	$(function(){


	})
</script>
