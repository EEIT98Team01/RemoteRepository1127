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
<link rel="stylesheet" href="<c:url value="/css/frontDesk/shopping_payment.css"/>">


<!--body-->
<body>
	<!--引入 topbar 跟  header-->
	<jsp:include page="/pages/common/topbar_and_header.jsp"/>
	
	<!-- 這邊 開始寫內容-->
	<!--每頁 page_container-->
		<div class="main_page_title">
		<h3>我的購物車 My ShoppingCart</h3>
		<h5>親愛的XXX你好，以下是你的購物車清單<h5>
	</div>

	<div class="shopping_step">
		<div class="line1 lineActive"></div>
		<div class="line2"></div>
		<ul>
			<li><a class="step_link active" href="">Step1</a><small>確認購物明細</small></li>
			<li><a class="step_link active" href="">Step2</a><small>選擇附款方式</small></li>
			<li><a class="step_link" href="">Step3</a><small>確認結帳完成</small></li>
		</ul>
	</div>
	
	<!--每頁主要內容-->
	<section class="page_container shopping_payment">

		<!-- 主要內容-->
		<div class="main_container_col_1">

			<div class="panel panel-info">
		      	<div class="panel-heading title">請選擇付款方式</div>
		      	<div class="panel-body pannal_box">
			      	<ul>
						<li><label><input type="radio" name="payment">超商取貨</label></li>
						<li><label><input type="radio" name="payment">歐付寶付款</label></li>	
						<li><label><input type="radio" name="payment">轉帳="=</label></li>			
					</ul>
				</div>
   			</div>

   			<div class="panel panel-info">
		      	<div class="panel-heading title">請選擇7-11</div>
		      	<div class="panel-body pannal_box">
			      	
				</div>
   			</div>


   			<div class="panel panel-info">
		      	<div class="panel-heading title">訂購人資訊</div>
		      	<div class="panel-body pannal_box">
			      	<table>
			      		<tr>
			      			<td>姓名</td>
							<td><input type="text" name="" value=""></td>
			      		</tr>
						<tr>
			      			<td>手機</td>
							<td><input type="text" name="" value=""></td>
			      		</tr>

			      		<tr>
			      			<td>地址</td>
							<td><input type="text" name="" value=""></td>
			      		</tr>
			      		
			      		<tr>
			      			
							<td>email</td>
							<td><input type="text" name="" value=""></td>
			      		</tr>

			      	</table>
				</div>
   			</div>


   			<div class="panel panel-info">
		      	<div class="panel-heading title">收件人資訊</div>
		      	<div class="panel-body pannal_box">
			      	<table>
			      		<tr>
			      			<td>姓名</td>
							<td><input type="text" name="" value=""></td>
			      		</tr>
						<tr>
			      			<td>手機</td>
							<td><input type="text" name="" value=""></td>
			      		</tr>

			      		<tr>
			      			<td>地址</td>
							<td><input type="text" name="" value=""></td>
			      		</tr>
			      	</table>
				</div>
   			</div>

			
			<div class="docline"></div>

			<a href="#" class="go_checkout_btn">下ㄧ步</a>
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
<script type="text/javascript">

	$(function(){


	})
</script>
