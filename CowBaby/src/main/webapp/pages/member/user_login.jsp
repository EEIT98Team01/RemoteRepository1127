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
<link rel="stylesheet" href="<c:url value="/css/frontDesk/user_login.css"/>">

<!--body-->
<body>
	<!--引入 topbar 跟  header-->
	<jsp:include page="/pages/common/topbar_and_header.jsp"/>

	<!--登入畫面-->
	<div class="loginBox">
		<div class="box_top">
			<div class="login_part">
				<h3>會員登入</h3>
				<form class="form-inline" action="<c:url value="/CustomerUserLoginController" />" method="POST" >
					<div class="form-group" style="margin-right: 15px">
						<label for="email">Email帳號</label>
						<input type="email" class="form-control" name="useremail" id="email">
						<p style="color: #e21124;">${errors.useremail}</p>
					</div>
					<div class="form-group">
						<label for="pwd">密碼</label>
						<input type="password" class="form-control" name="password" id="pwd">
						<p style="color: #e21124;">${errors.password}</p>
				    </div>
				    <button type="submit" class="btn btn-primary btn-md">我要登入</button>
				    <button type="button" class="btn btn-warning btn-md">忘記密碼</button>
				</form>
			</div>
			<div class="register_part">
				<a href="<c:url value="/pages/member/user_register.jsp"/>"><img src="<c:url value="/images/mem-join.png"/>"></a>
			</div>	
		</div>
		<div class="box_button">
			<h3>防詐騙提醒</h3>
			<table>
				<tr>
					<td>不操作ATM</td>
					<td>ATM最主要的功能是提款與轉帳，並沒有解除分期付款的選項。</td>
				</tr>
				<tr>
					<td>不透露信用卡資料</td>
					<td>請勿告知來電者信用卡號與卡片到期日。</td>
				</tr>
				<tr>
					<td>求證相關單位</td>
					<td>懷疑來電者是詐騙集團，請撥警政署反詐騙諮詢專線165，或洽客服人員07-721-0219，維護自身網路資料安全，建議您不定期進行掃毒，更新自己在各網站帳號的密碼，若使用公共電腦記得使用完畢要登出。</td>
				</tr>
			</table>
		</div>
	</div>	
	
	
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

	
</script>
