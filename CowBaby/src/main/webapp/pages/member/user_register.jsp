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

<link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css"/> 
<link rel="stylesheet" href="<c:url value="/pluging/Bxsliders/jquery.bxslider.min.css"/>"> 
<link rel="stylesheet" href="<c:url value="/css/frontDesk/basic.css"/>">
<link rel="stylesheet" href="<c:url value="/css/frontDesk/user_register.css"/>">


<!--body-->
<body>
	<!--引入 topbar 跟  header-->
	<jsp:include page="/pages/common/topbar_and_header.jsp"/>
	
	<!-- 這邊 開始寫內容-->
	<!--每頁 page_container-->
	
	<div class="main_page_title">
		<h3>會員註冊</h3>
		<h5>填寫基本資料即可開始購物<h5>
	</div>
	
	<section class="page_container member_register_container">
		<!-- 主要內容-->
		<div class="main_container_col_1">
			<form action="<c:url value="/CustomerRegisterController"/>" method="POST" enctype="multipart/form-data">
				<div>
					<div class="title">設定帳號密碼 Account & Password Setting</div>
					<table>
						<tr>
							<td><label>帳號E-mail*</label></td>
							<td><input type="text" name="email"><p class="error_text">${errors.password_error}</p></td>
							<td>(此信箱將作為您的登入帳號、收取確認信之用途，一旦建立， 將無法修改，敬請注意。)</td>
						</tr>
						<tr>
							<td><label>您的密碼*</label></td>
							<td><input type="password" name="password"></td>
							<td>請填入6個字元以上的英文字母、數字</td>
						</tr>
						<tr>
							<td><label>密碼確認*</label></td>
							<td><input type="password" name="checkPassword"></td>
							<td>請再輸入一次密碼</td>
						</tr>
					</table>

					<div class="docline"></div>

					<div class="title">設定個人基本資料 Personal information Setting</div>

					<table style="width: 45%; float:left">
						<tr>
							<td><label>您的大名*</label></td>
							<td><input type="text" name="customerName"></td>
						</tr>
						
						<tr>
							<td><label>您的手機*</label></td>
							<td><input type="text" name="mobilePhone"></td>
						</tr>
						
						<tr>
							<td><label>市內電話*</label></td>
							<td><input type="text" name="landline"></td>
						</tr>
						
						<tr>
							<td><label>月收入狀況</label></td>
							<td><input type="text" name="income"></td>	
						</tr>
						
						<tr>
							<td><label>您的性別*</label></td>
							<td style="text-align: left;">
								<label style="margin-right:10px"><input type="radio" name="gender" value="M">男</label>
								<label style="margin-right:10px"><input type="radio" name="gender"  value="F">女</label>
							</td>
						</tr>	
					</table>

					<table style="width: 45%;">
						<tr>
							<td><label>聯絡地址*</label></td>
							<td><input type="text" name="address"></td>
						</tr>
						
						<tr>
							<td><label>您的生日*</label></td>
							<td><input type="text" name="birthday" id='datetimepicker'></td>
						</tr>
						
						<tr>
							<td><label>上傳頭像*</label></td>
							<td><input type="file" name="loginPhoto" class="logoUpl"></td>
						</tr>
						
						<tr>
							<td><label>婚姻狀況*</label></td>
							<td style="text-align: left;">
								<label style="margin-right:10px"><input type="radio" name="marriage">已婚</label>
								<label><input type="radio" name="marriage">未婚</label>
							</td>
						</tr>
						
					</table>
					<div class="docline"></div>
					<table>
						<tr>
							<td><label>訂閱電子報</label></td>
							<td style="text-align: left;">
								<label style="margin-right:10px"><input type="radio" name="subscription">是</label>
								<label style="margin-right:10px"><input type="radio" name="subscription">否</label>
							</td>
							<td><button id="submit" type="submit" class="btn btn-primary pull-right">確定送出</button></td>
						</tr>
						<tr>
							<!-- <td><label>驗證碼*</label></td>
							<td>
								<input type="text">
							</td> -->
								
						</tr>
					</table>
				</div>
			</form>
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
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<!-- YA -->

<script type="text/javascript">

	$(function(){
		
		$( "#datetimepicker").datepicker({
			 dateFormat: 'yy/mm/dd'
		});
	})
</script>
