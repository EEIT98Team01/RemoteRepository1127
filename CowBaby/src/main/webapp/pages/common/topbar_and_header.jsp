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
			<c:if test="${empty user}">
				<li style="margin-top: 15px;"><a href="<c:url value="/pages/member/user_login.jsp"/>">登入</a></li>
				<li style="margin: 15px 0 0 0;">/</li>
				<li style="margin-top: 15px;"><a href="<c:url value="/pages/member/user_register.jsp"/>">註冊</a></li>
			</c:if>
			<c:if test="${not empty user}">
				<li><img src="data:image/jpg;base64,${logingPhotoImg}"/>${user.customerName}
					<div class="showMemberPannal">
						<div><a href="#">我的賣場</a></div>
						<div><a href="<c:url value="/pages/member/member_account_infor.jsp"/>">我的資訊</a></div>
						<div><a href="#">安全登出</a></div>				
					</div>
				</li>
				
			</c:if>
		</ul>
	</section>
</div>

<!--header-->
<header>
	<section class="container">
		<row>
			<div class="col-md-2 logo">
				<a href="<c:url value="/index.jsp"/>"><img src="<c:url value="/images/logo.jpg"/>"></a>
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
				<li><a href="<c:url value="/pages/member/user_register.jsp"/>"><i class="fa fa-gift fa-2x" aria-hidden="true"></i>全部商品</a></li>
				<li><a href="<c:url value="/pages/member/all_products.jsp"/>"><i class="fa fa-diamond fa-2x" aria-hidden="true"></i>最新商品</a></li>
				<li><a href="<c:url value="/pages/member/all_shops.jsp"/>"><i class="fa fa-heartbeat fa-2x" aria-hidden="true"></i>精選商家</a></li>
				<li><a href="<c:url value="/pages/member/all_blog.jsp"/>"/><i class="fa fa-star-half-o fa-2x" aria-hidden="true"></i>媽咪推薦</a></li>
				<li><a href="<c:url value="/pages/member/customer_service.jsp"/>"/><i class="fa fa-thumbs-up fa-2x" aria-hidden="true"></i>客戶服務</a></li>
			</ul>
		</section>
	</section>
</header>
<!--header end-->
