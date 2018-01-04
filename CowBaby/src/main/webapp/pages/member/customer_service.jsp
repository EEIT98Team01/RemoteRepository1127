<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>cow babye購物商城</title>
<link rel="icon" href="logo.ico">
</head>

<!--css-->
<link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-switch/3.3.4/css/bootstrap3/bootstrap-switch.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap3-dialog/1.34.7/css/bootstrap-dialog.min.css">

<link rel="stylesheet"
	href="<c:url value="/pluging/Bxsliders/jquery.bxslider.min.css"/>">
<link rel="stylesheet" href="<c:url value="/css/frontDesk/basic.css"/>">
<link rel="stylesheet"
	href="<c:url value="/css/frontDesk/customer_service.css"/>">


<!--body-->
<body>
	<!--引入 topbar 跟  header-->
	<jsp:include page="/pages/common/topbar_and_header.jsp" />

	<!-- 這邊 開始寫內容-->
	<div class="main_page_title">
		<h3>客戶服務申請</h3>
		<h5>
			有任何問題可聯絡客服，我們將盡快為您處理
			<h5>
	</div>
	<!--每頁主要內容-->
	<!--從這邊開始寫-->
	<section class="page_container customer_service"> <!-- 主要內容-->
	<div class="main_container_col_1">
		<form action="${pageContext.servletContext.contextPath}/CustomerServiceAuditList.controller"
			  method="POST">
			<div>

				<table>
					<tr>
						<td><label>申訴人</label></td>
						
						<td><input type="text" name="email"></td>
						<td style="text-align:left;color: red;">${errors.email}</td>
					</tr>
					<tr>
						<td><label>問題種類</label></td>
						<td><select id="problemTypes" name="problemTypes">
								<option value="1">黑名單檢舉</option>
								<option value="2">帳號問題</option>
								<option value="3">BUG問題</option>
								<option value="4">其他</option>
						</select></td>

					</tr>
<!-- 					<tr> -->
<!-- 						<td><label>檔案上傳</label></td> -->
<!-- 						<td><input name="myFile" type="file" name=""></td> -->

<!-- 					</tr> -->
					<tr>
						<td><label>問題描述</label></td>
						
						<td><textarea id="comment" rows="50" cols="50"
								name="problemDescription"></textarea></td>
						<td style="text-align:left;color: red;">${errors.problemDescription}</td>					
					</tr>
					<tr>
				</table>
				<button type="submit" class="btn btn-primary pull-right serviceBtn">提交問題</button>
			</div>
		</form>
	</div>
	</section>


	<!--引入 footer-->
	<jsp:include page="/pages/common/footer.jsp" />
</body>
</html>


<!-- Bootstrap core JavaScript-->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script type="text/javascript"
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-switch/3.3.4/js/bootstrap-switch.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap3-dialog/1.34.7/js/bootstrap-dialog.min.js"></script>
<script src="<c:url value="/pluging/Bxsliders/jquery.bxslider.min.js"/>"></script>

<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/bxslider/4.2.12/jquery.bxslider.js"></script> -->
<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bxslider/4.2.12/jquery.bxslider.css">  -->




<script type="text/javascript">
	$(function() {
		$(".nav li").eq(4).find('a').css({"background": "#6abbc5","color": "#ffff"})
	})
</script>
