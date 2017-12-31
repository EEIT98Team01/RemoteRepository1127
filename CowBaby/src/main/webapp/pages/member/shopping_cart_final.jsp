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
			<li><a class="step_link active" href="">Step3</a><small>確認結帳完成</small></li>
		</ul>
	</div>
	

	<!--每頁主要內容-->
	<section class="page_container shopping_cart_check">
		<!-- 主要內容-->
		
			<div class="main_container_col_1 step1">
			
				<!--------送給後端資料全部隱藏---------->
				<%-- <form action="<c:url value="/goCheckout"/>" method="post" >
					<input name="productList" value="${shoppingCartInfo.productInfo}">
				</form> --%>
			
			
			
				<h2>訂購資料</h2>
				<p>${map.getBonus}<p>
				<!--------訂購物品明細---------->
				<c:forEach var="objectArray" items="${shoppingCartInfo}">
					<div class="myshopOrder">
						<div class="shop_name">
							<span><i class="fa fa-user-secret" aria-hidden="true"></i><span class="myshoptext">${objectArray[0]}</span>
							
							<span><input name="storename" value="${objectArray[0]}"></span>
						</div>
						<table>
							<tr>
								<th>商品名稱</th>
								<th>圖片</th>
								<th>單價</th>
								<th>產品規格</th>
								<th>數量</th>
								<th>小計</th>
								<!-- <th>變更明細</th> -->
							</tr>
							<c:forEach var="var" items="${objectArray[3]}">
							<tr>
								<td>${var.productName}</td>
							    <td><img src="${var.productImage}"></td>
								<td>${var.unitPrice}</td>
								<td>${var.productSpec}</td>
								<td>${var.quantity}</td>
								<td>${var.quantity*var.unitPrice}</td> 
								<%-- <td><a class="btn btn-primary" href="<c:url value="/deleteProuductController"/>?productID=${var.productID}&spec=${var.productSpec}">刪除</a></td> --%>
							</tr> 
							</c:forEach>
							<tr>
							<td colspan="7" style="text-align: right;">
									<div class="bonusbox">
										<span>目前紅利金為<span class="totalbonus">500</span>點，我要折抵</span>
										<span>${objectArray[4]}</span>
										<span>元</span>
									</div>
								</td>
							</tr>
							<tr>
								<td colspan="7" style="text-align: right;">共
										<span class="totalItem">${objectArray[1]}</span>
									項商品，總金額NT$ 
									<span class="totalPrice">${objectArray[2]}</span>元
								</td>
							</tr>	
						</table>
					</div>
				</c:forEach>
				
				<!--------收件人資訊---------->
				<h2>收件人資訊</h2>
				<table>
					<tr>
						<td>收件人</td>
						<td>${infor.getRecipients}</td>
					</tr>
					<tr>
						<td>連絡電話</td>
						<td>${infor.getRecipientsMobile}</td>
					</tr>
					<tr>
						<td>地址</td>
						<td>${infor.getRecipientsAdd}</td>
					</tr>
					<tr>
						<td>EMAIL</td>
						<td>${infor.recipientsEmail}</td>
					</tr>
				</table>
				
				<!--------取貨資訊---------->
				<h2>商店取貨資訊</h2>
				<table>
					<tr>
						<td>門市</td>
						<td>${infor.convenienceStoreName}</td>
					</tr>
					<tr>
						<td>電話</td>
						<td>${infor.convenienceStoreTel}</td>
					</tr>
					<tr>
						<td>地址</td>
						<td>${infor.convenienceStoreAdd}</td>
					</tr>
				</table>
	
				<div class="total_order">
					<div class="total_order_my_prouduct">
						<div>購買總金額 (<span class="all_prousuct">${shoppingCart.totalItems}</span> 個商品):
							<span class="all_prousuct_price">$<span>${shoppingCart.totalAmount}</span></span>
						</div>
						<div class="this_order_bonus">此次紅利點數 : <span>123456</span>點</div>		
					</div>
					<div class="go_checkout">
						<!-- <a href="#" class="go_checkout_btn">確認結帳</a>  -->
					 <button style="padding:15px 75px;background: #f27373;font-size: 16px; border: none;" type="submit go_checkout_btn" class="btn btn-primary pull-right">確認結帳</button>
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
  
   	
</script>
