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
			<div class="container_pagination">
				
					<div class="container_pagination_title col-md-2">全部商品</div>
					<div class="pull-right">
						<ul class="pagination">
							<li>
							    <a  style="border-radius:50%" href="#" aria-label="Previous">
							        <span aria-hidden="true">«</span>
							    </a>
						    </li>
						    <li><a href="#">1</a></li>
						    <li><a href="#">2</a></li>
						    <li><a href="#">3</a></li>
						    <li><a href="#">4</a></li>
						    <li><a href="#">5</a></li>
						    <li>
						    <a style="border-radius:50%" href="#" aria-label="Next">
						        <span aria-hidden="true">»</span>
						    </a>
						</ul>
					</div>
					<div class="col-md-2 col-md-offset-3 pull-right">
						<form class="form-inline">
							<div class="form-group">
								<label for="exampleInputName2">顯示</label>
								<select class="form-control">
									<option>10</option>
									<option>20</option>
									<option>30</option>
									<option>40</option>		
								</select>
							</div>
						</form>	
					</div>
				
			</div>
			<!--產品LIST-->
<<<<<<< HEAD
			<section class="proudectList">
				<div class="item">
					<img src=" <c:url value="/images/newArrived1.jpg"/>">
					<p class="title">英國Blade ＆ Rose 聖誕款聖誕款聖款內內搭褲</p>
					<div class="originalPrice">原價 NT 190</div>
					<div class="specialPrice">特價 NT <span class="specialPriceNum">190</span></div>
				</div>

				<div class="item">
					<img src="<c:url value="/images/newArrived2.jpg"/>">
					<p class="title">英國Blade ＆ Rose 聖誕款內搭褲</p>
					<div class="originalPrice">原價 NT 190</div>
					<div class="specialPrice">特價 NT <span class="specialPriceNum">190</span></div>
				</div>

				<div class="item">
					<img src=" <c:url value="/images/newArrived3.jpg"/>">
					<p class="title">英國Blade ＆ Rose 聖誕款內搭褲</p>
					<div class="originalPrice">原價 NT 190</div>
					<div class="specialPrice">特價 NT <span class="specialPriceNum">190</span></div>
				</div>

				<div class="item">
					<img src=" <c:url value="/images/newArrived4.jpg"/>">
					<p class="title">英國Blade ＆ Rose 聖誕款內搭褲</p>
					<div class="originalPrice">原價 NT 190</div>
					<div class="specialPrice">特價 NT <span class="specialPriceNum">190</span></div>
				</div>
=======
 							
			<section class="proudectList">
				<c:forEach var="array" varStatus="st" items="${productList}">
					<div class="item"> 
						<a href="<c:url value="ProductItemOfShop"/>?storeID=${array[0]}&productID=${array[6]}" >
							<img src=" <c:url value="/images/newArrived1.jpg"/>">
							<p class="stroe_name">${array[2]}</p>
							<p class="prouduct_name">${array[3]}</p>
							<div class="specialPrice">特價 NT <span class="specialPriceNum">${array[5]}</span></div>
						</a>
					</div>
				</c:forEach>
>>>>>>> branch 'master' of https://github.com/EEIT98Team01/RemoteRepository1127.git

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
<script src="<c:url value="/js/frontDesk/callshopingCartAPI.js"/>"></script>

<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/bxslider/4.2.12/jquery.bxslider.js"></script> -->
<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bxslider/4.2.12/jquery.bxslider.css">  -->
 



<script type="text/javascript">

	$(function(){
		// 一進來先獲取購物車內的內容
		/* new ShoppingCatAPI("","",""); */
	})
</script>
