<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 前台 topbar header -->

<!--topbar-->
<div class="container-fliud top-bar">
	<section class="container">
		<ul class="top-bar-menu pull-right">
			<li><a class="facebook" href="#">FB</a></li>
			<li>
				<a class="shopcart" href="#">
					<i class="fa fa-cart-plus fa-2x" aria-hidden="true"></i>
					<span class="shopcart-total-number">5</span>
				</a>
			</li>
			<li><a class="login" href="#">登入/註冊</a></li>
			<li><img src="<c:url value="/images/line.jpg"/>">HI!雄大</li>
		</ul>
	</section>
</div>

<!--header-->
<header>
	<section class="container">
		<row>
			<div class="col-md-2 logo">
				<img src="<c:url value="/images/logo.jpg"/>">
			</div>
			<div class="col-md-2 slogan" >
				<span>開心玩樂開心學習~</span>
				<span>給孩子最好的就在牛寶貝!!</span>
			</div>

			<form class="col-md-5 pull-right searchProduct" role="search">
			    <div class="input-group add-on">
			      	<input class="form-control" style="border: 2px solid #9ee2ea;" placeholder="Search" name="srch-term" id="srch-term" type="text">
			      	<div class="input-group-btn">
			        	<button class="btn btn-default searchStyle" type="submit"><i class="glyphicon glyphicon-search"></i></button>
			      	</div>
			    </div>
		  	</form>
		</row>			
	</section>

	<section class="container-fliud">
		<section class="container main-nav">
			<ul class="nav navbar-nav">
				<li><a href="#"><i class="fa fa-gift fa-2x" aria-hidden="true"></i>全部商品</a></li>
				<li><a href="#"><i class="fa fa-diamond fa-2x" aria-hidden="true"></i>最新商品</a></li>
				<li><a href="#"><i class="fa fa-heartbeat fa-2x" aria-hidden="true"></i>精選商家</a></li>
				<li><a href="#"><i class="fa fa-star-half-o fa-2x" aria-hidden="true"></i>媽咪推薦</a></li>
				<li><a href="#"><i class="fa fa-thumbs-up fa-2x" aria-hidden="true"></i>客戶服務</a></li>
			</ul>
		</section>
	</section>
</header>
<!--header end-->
