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
<link rel="stylesheet" href="<c:url value="/css/frontDesk/all_products.css"/>">


<!--body-->
<body>
	<!--引入 topbar 跟  header-->
	<jsp:include page="/pages/common/topbar_and_header.jsp"/>
	
	<!-- 這邊 開始寫內容-->
	<!--每頁Banner-->
	<section class="page_banner">
		<img src="<c:url value="/images/all_prouducts_banner.png"/>">
	</section>
	
	<!--每頁 page_container-->
	<section class="page_container all_products_page_container">
		<div class="side_bar">
			<ul>
				<li class="sort-title">商品分類</li>
				<li><a href="#">全部同裝商品</a></li>
				<li><a href="#">精選商品A</a></li>
				<li><a href="#">人氣商品C</a></li>
				<li><a href="#">特價商品</a></li>
				<li><a href="#">出清商品</a></li>
			</ul>

			<ul>
				<li class="sort-title">年齡分類</li>
				<li><label><input type="checkbox" value=""> <span>0-6 歲</span> <span>(4890)</span></label> </li>
				<li><label><input type="checkbox" value=""> <span>0-3 Months</span> <span>(4890)</span></label> </li>
				<li><label><input type="checkbox" value=""> <span>0-3 Months</span> <span>(4890)</span></label> </li>	
			</ul>

			<ul>
				<li class="sort-title">性別分類</li>
				<li><label><input type="checkbox" value=""> <span>0-3 Months</span> <span>(4890)</span></label> </li>
				<li><label><input type="checkbox" value=""> <span>0-3 Months</span> <span>(4890)</span></label> </li>
				<li><label><input type="checkbox" value=""> <span>0-3 Months</span> <span>(4890)</span></label> </li>	
			</ul>
		</div>

		<!-- 主要內容-->
		<div class="main_container_col_2">
		
			<!--產品明細-->
			<section class="proudect_detail">

				<div class="showPic">
					<img src="<c:url value="/images/prouduct_item1.jpg"/>">
				</div>

				<div class="product_infor">
					<div class="product_title">英國Blade ＆ Rose 仙人掌內搭褲</div>
					<div class="product_desc">小寶貝秋冬個性搶眼內搭褲,彈性極佳、保暖度夠居家褲、睡褲或外出當內搭褲皆適宜</div>
					<div class="product_price">NT.1000</div>

					<div class="product_size">
						<p><i class="fa fa-gift" aria-hidden="true"></i>產品規格</p>
						<ul>
							<li><a href="#">紅色T</a></li>
							<li><a href="#">黑色T</a></li>
							<li><a href="#">白色T</a></li>
							<li><a href="#">藍色T</a></li>
							<li><a href="#">橘色T</a></li>
							<li><a href="#">深藍藍色T</a></li>
						</ul>
					</div>
					
					<div class="product_number">
						<a href="#" class="add_num">+</a>
						<input type="text" value="1">
						<a href="#" class="reduce_num">-</a>
					</div>

					<div class="checkout">
						<a class="add_cart" href="#">加入購物車</a>
						<a class="add_cart" href="#">去結帳</a>				
					</div>
				</div>
				
			</section>
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
