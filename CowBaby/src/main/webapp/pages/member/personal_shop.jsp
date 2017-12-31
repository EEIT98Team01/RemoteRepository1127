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
<link rel="stylesheet" href="<c:url value="/css/frontDesk/personal_shop.css"/>">


<!--body-->
<body>
	<!--引入 topbar 跟  header-->
	<jsp:include page="/pages/common/topbar_and_header.jsp"/>
	
	<!-- 這邊 開始寫內容-->
	<!--每頁 page_container-->
	<!--每頁Banner-->
	<section class="page_banner">
		<img src="<c:url value="/images/all_prouducts_banner.png"/>">
	</section>

	<section class="page_container personal_shop_page_container">
		<div class="side_bar">
			<div class="personal_infor">
				<div class="seller_title">賣家資訊</div>
				<div class="seller_img">
					<img src="<c:url value="/images/toto.png"/>">
				</div>
				<div class="infor_titile">
					<span class="glyphicon glyphicon-home" aria-hidden="true"></span>
					<span>兔兔的店</span>
				</div>
				<div class="infor_titile">
					<span class="glyphicon glyphicon-phone-alt" aria-hidden="true"></span>
					<span>0932-132-456</span>
				</div>

				<div class="infor_valuation">
					<span>消費者滿意度：<span class="score">9.6</span></span>
					<div class="stars">
						<ul>
							<li><i class="fa fa-star" aria-hidden="true"></i></li>
							<li><i class="fa fa-star" aria-hidden="true"></i></li>
							<li><i class="fa fa-star" aria-hidden="true"></i></li>
							<li><i class="fa fa-star-o" aria-hidden="true"></i></li>
							<li><i class="fa fa-star-o" aria-hidden="true"></i></li>
						</ul>			
					</div>
				</div>
				
			</div>
			<!--其他功能-->
			<div class="other_function">
				<p>每日流覽人數: <span> 123456</span></p>
				<p>人氣: <span> 123456</span></p>
				<a href="#"><i style="margin-right: 5px;" class="fa fa-commenting-o" aria-hidden="true"></i>留言給賣家</a>
				<a style="margin-left: 15px;background:#818080;" href="#"><i style="margin-right: 5px;" class="fa fa-user-circle-o" aria-hidden="true"></i>檢舉</a>
			</div>
		</div>


		<!-- 個人商店頁面-->
		<div class="main_container_col_2 personal_shop">
			<div class="shop_introduction">
				<div class="personal_shop_name">兔兔的店</div>
				<div class="personal_shop_description">行政院長賴清德盼企業提高薪資，台積電董事長張忠謀昨日直言，薪資應該是自由人力市場事情，政府勸企業提高薪水，有違自由市場規矩，「他（指政府）不必、也用不著勸我們，我們本來就是每年都在提高薪水。」</div>
			</div>
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
			<!--店家產品LIST-->
			<section class="proudectList">
				<div class="item">
					<img src="<c:url value="/images/newArrived1.jpg"/>">
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
					<img src="<c:url value="/images/newArrived1.jpg"/>">
					<p class="title">英國Blade ＆ Rose 聖誕款內搭褲</p>
					<div class="originalPrice">原價 NT 190</div>
					<div class="specialPrice">特價 NT <span class="specialPriceNum">190</span></div>
				</div>

				<div class="item">
					<img src="img/newArrived4.jpg">
					<p class="title">英國Blade ＆ Rose 聖誕款內搭褲</p>
					<div class="originalPrice">原價 NT 190</div>
					<div class="specialPrice">特價 NT <span class="specialPriceNum">190</span></div>
				</div>

				<div class="item">
					<img src="<c:url value="/images/newArrived1.jpg"/>">
					<p class="title">英國Blade ＆ Rose 聖誕款內搭褲</p>
					<div class="originalPrice">原價 NT 190</div>
					<div class="specialPrice">特價 NT <span class="specialPriceNum">190</span></div>
				</div>

				<div class="item">
					<img src="<c:url value="/images/newArrived1.jpg"/>">
					<p class="title">英國Blade ＆ Rose 聖誕款內搭褲</p>
					<div class="originalPrice">原價 NT 190</div>
					<div class="specialPrice">特價 NT <span class="specialPriceNum">190</span></div>
				</div>

				<div class="item">
					<img src="<c:url value="/images/newArrived1.jpg"/>">
					<p class="title">英國Blade ＆ Rose 聖誕款內搭褲</p>
					<div class="originalPrice">原價 NT 190</div>
					<div class="specialPrice">特價 NT <span class="specialPriceNum">190</span></div>
				</div>

				<div class="item">
					<img src="<c:url value="/images/newArrived1.jpg"/>">
					<p class="title">英國Blade ＆ Rose 聖誕款內搭褲</p>
					<div class="originalPrice">原價 NT 190</div>
					<div class="specialPrice">特價 NT <span class="specialPriceNum">190</span></div>
				</div>

				<div class="item">
					<img src="<c:url value="/images/newArrived1.jpg"/>">
					<p class="title">英國Blade ＆ Rose 聖誕搭褲聖誕搭褲</p>
					<div class="originalPrice">原價 NT 190</div>
					<div class="specialPrice">特價 NT <span class="specialPriceNum">190</span></div>
				</div>

				<div class="item">
					<img src="<c:url value="/images/newArrived1.jpg"/>">
					<p class="title">英國Blade ＆ Rose 聖誕款內搭褲</p>
					<div class="originalPrice">原價 NT 190</div>
					<div class="specialPrice">特價 NT <span class="specialPriceNum">190</span></div>
				</div>

				<div class="item">
					<img src="<c:url value="/images/newArrived1.jpg"/>">
					<p class="title">英國Blade ＆ Rose 聖誕款內搭褲</p>
					<div class="originalPrice">原價 NT 190</div>
					<div class="specialPrice">特價 NT <span class="specialPriceNum">190</span></div>
				</div>

				<div class="item">
					<img src="<c:url value="/images/newArrived1.jpg"/>">
					<p class="title">英國Blade ＆ Rose 聖誕款內搭褲</p>
					<div class="originalPrice">原價 NT 190</div>
					<div class="specialPrice">特價 NT <span class="specialPriceNum">190</span></div>
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
