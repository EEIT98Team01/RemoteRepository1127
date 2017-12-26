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
<link rel="stylesheet" href="<c:url value="/css/frontDesk/shopping_cart_check.css"/>">


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
	<section class="page_container shopping_cart_check">
		<!-- 主要內容-->
		<div class="main_container_col_1">
			<div class="myshopOrder">
				<div class="shop_name">
					<span><i class="fa fa-user-secret" aria-hidden="true"></i>這是兔兔商店</span>
					<span>|</span>
					<span>店家ID : 1</span>
				</div>
				<table>
					<tr>
						<th>商品名稱</th>
						<th>圖片</th>
						<th>單價</th>
						<th>數量</th>
						<th>小計</th>
						<th>庫存</th>
						<th>變更明細</th>
					</tr>
					<tr>
						<td>做對選擇，讓生活變輕盈：別讓他人的要求支配你，找回自己的空間與自由</td>
						<td><img src="img/newArrived2.jpg"></td>
						<td>288</td>
						<td>1</td>
						<td>288</td>
						<td>有</td>
						<td><button type="button" class="btn btn-primary">刪除</button></td>
					</tr>

					<tr>
						<td colspan="7" style="text-align: right;">
							<div class="bonusbox">
								<span>目前紅利金為<span class="totalbonus">500</span>點，我要折抵</span>
								<span><input type="text" name="" value="0"></span>
								<span>元</span>
							</div>
						</td>
						
					</tr>
					<tr>
						<td colspan="7" style="text-align: right;">共
							<span class="totalItem">3 </span>項商品，總金額NT$ 
							<span class="totalPrice"> 702 </span>元
						</td>
					</tr>	
				</table>
			</div>


			<div class="myshopOrder">
				<div class="shop_name">
					<span><i class="fa fa-user-secret" aria-hidden="true"></i>這是珠珠商店</span>
					<span>|</span>
					<span>店家ID : 2</span>
				</div>
				<table>
					<tr>
						<th>商品名稱</th>
						<th>圖片</th>
						<th>單價</th>
						<th>數量</th>
						<th>小計</th>
						<th>庫存</th>
						<th>變更明細</th>
					</tr>
					<tr>
						<td>做對選擇，讓生活變輕盈：別讓他人的要求支配你，找回自己的空間與自由</td>
						<td><img src="img/newArrived2.jpg"></td>
						<td>288</td>
						<td>1</td>
						<td>288</td>
						<td>有</td>
						<td><button type="button" class="btn btn-primary">刪除</button></td>
					</tr>
					<tr>
						<td>做對選擇，讓生活變輕盈：別讓他人的要求支配你，找回自己的空間與自由</td>
						<td><img src="img/newArrived2.jpg"></td>
						<td>288</td>
						<td>1</td>
						<td>288</td>
						<td>有</td>
						<td><button type="button" class="btn btn-primary">刪除</button></td>
					</tr>
					<tr>
						<td colspan="7" style="text-align: right;">
							<div class="bonusbox">
								<span>目前紅利金為<span class="totalbonus">500</span>點，我要折抵</span>
								<span><input type="text" name="" value="0"></span>
								<span>元</span>
							</div>
						</td>
						
					</tr>
					<tr>
						<td colspan="7" style="text-align: right;">共
							<span class="totalItem">3 </span>項商品，總金額NT$ 
							<span class="totalPrice"> 702 </span>元
						</td>
					</tr>	
				</table>
			</div>

			<div class="total_order">
				<div class="total_order_my_prouduct">
					<div>購買總金額 (<span class="all_prousuct">5</span> 個商品):
						<span class="all_prousuct_price">$5,567</span>
					</div>
					<div class="this_order_bonus">此次紅利點數 : <span>123456</span>點</div>		
				</div>
				<div class="go_checkout">
					<a href="#" class="go_checkout_btn">去結帳</a>
				</div>
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
<script type="text/javascript">

	$(function(){


	})
</script>
