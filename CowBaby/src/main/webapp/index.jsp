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
<link rel="stylesheet" href="<c:url value="/css/frontDesk/index.css"/>">

<!--body-->
<body>
	<!--引入 topbar 跟  header-->
	<jsp:include page="/pages/common/topbar_and_header.jsp"/>

	<!--banner-->
	<section class="banner">
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
		    <!-- Indicators -->
		    <ol class="carousel-indicators">
		      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
		      <li data-target="#myCarousel" data-slide-to="1"></li>
		      <li data-target="#myCarousel" data-slide-to="2"></li>
		    </ol>

		    <!-- Wrapper for slides -->
		    <div class="carousel-inner">
		      <div class="item active">
		        <img src="<c:url value="/images/a3.jpg"/>" alt="Los Angeles" style="width:100%;">
		      </div>
		      <div class="item">
		        <img src="<c:url value="/images/a8.jpg"/>" alt="Chicago" style="width:100%;">
		      </div>
		    
		      <div class="item">
		        <img src="<c:url value="/images/a9.jpg"/>" alt="New york" style="width:100%;">
		      </div>
		    </div>

		    <!-- Left and right controls -->
		    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
		      	<span class="glyphicon glyphicon-chevron-left"></span>
		     	<span class="sr-only">Previous</span>
		    </a>
		    <a class="right carousel-control" href="#myCarousel" data-slide="next">
		      	<span class="glyphicon glyphicon-chevron-right"></span>
		      	<span class="sr-only">Next</span>
		    </a>
	  		</div>
		</div>
	</section>
	<!--banne end-->

	<!--search gift-->
	<section class="searchGift">
		<a class="searchBtn" href="#">123132</a>
	</section>

	<!--doc line-->
	<section class="docline"></section>

	<!--賣家廣告-->
	<section class="adSection">
		<ul>
			<li><a href="#"><img src="<c:url value="/images/ad1.jpg"/>"></a></li>
			<li><a href="#"><img src="<c:url value="/images/ad2.jpg"/>"></a></li>
			<li><a href="#"><img src="<c:url value="/images/ad3.jpg"/>"></a></li>
		</ul>
	</section>
	
	<!--doc line-->
	<section class="docline"></section>

	<!--最新商品-->
	<section class="newArrived">
		<section class="mainTitle">
			<img class="flagL" src="<c:url value="/images/flag_L.png"/>">
			<img class="flagR" src="<c:url value="/images/flag_R.png"/>">
			<div class="topic">
				<img src="<c:url value="/images/new_arrived.png"/>">
				<p>走過路過快來看看喔!跳樓大牌賣!!</p>
			</div>
		</section>
			
		<!--slidershow-->
		<section class="slidershow">
			<div class="slidershow-Wrapper1">
				<c:forEach var="newproduct" items="${newProductList}">
					<a href='<c:url value='/ProductItemOfShop?storeID=&productID=${newproduct.productID}'/>'>
						<div class="item">
							<img src="${newproduct.productImage}">
							<p class="title">${newproduct.title}</p>
							<div class="originalPrice">NT <span class="specialPriceNum">${newproduct.unitPrice}</span> 元</div>
						</div>
					</a>
				</c:forEach>
			</div>
		</section>
	</section>

	<!--doc line-->
	<section class="docline"></section>

	<!--熱門商品-->
	<section class="hotProuduct">
		<section class="mainTitle">
			<div class="topic">
				<img src="<c:url value="/images/hot_prouduct.png"/>">
				<p>走過路過快來看看喔!跳樓大牌賣!!</p>
			</div>
		</section>

		<!--slidershow-->
		<section class="slidershow">
			<div class="slidershow-Wrapper2">
				<c:forEach var="hotproduct" varStatus="st" items="${hotProductList}">
					<a href='<c:url value='/ProductItemOfShop?storeID=&productID=${hotproduct.productID}'/>'>
						<div class="item">
							<div class="topIcon">${st.count}</div>
							<img src="${hotproduct.productImage}">
							<p class="title">${hotproduct.title}</p>
							<div class="originalPrice">NT <span class="specialPriceNum">${hotproduct.unitPrice}</span> 元</div>
						</div>
					</a>
				</c:forEach>
				
			</div>
		</section>
	</section>

	<!--精選商家-->
	<section class="content-fluid hotSohpWrapper">
		<section class="waveTop"></section>
		<section class="waveBottom"></section>
		<section class="hotSohp">
			<img  class="illustration1" src="<c:url value="/images/img1.png"/>">
			<img  class="illustration2" src="<c:url value="/images/img2.png"/>">
			<img  class="cutImgL" src="<c:url value="/images/cutImgL.png"/>  ">
			<img  class="cutImgR" src="<c:url value="/images/cutImgR.png"/> ">
			<section class="mainTitle">
				<div class="topic">
					<img src="<c:url value="/images/pop_store.png"/>">
					<p>走過路過快來看看喔!跳樓大牌賣!!</p>
				</div>
			</section>

			<!--slidershow-->
			<section class="slidershow">
				<div class="slidershow-Wrapper3">
					<c:forEach var="hotStore" varStatus="st" items="${hotStoreList}">
						<a href='<c:url value='/PersonShopController?storeID=${hotStore[0]}&email=${hotStore[6]}'/>'>
							<div class="item">
								<div class="choice"></div>
									<img src="data:image/jpeg;base64,${hotStore[1]}"/>
									<div class="shopName">${hotStore[2]}</div>
									<div class="description">
										${hotStore[3]}
									</div>
								<div class="stars">
									<ul>
										<li><i class="fa fa-star" aria-hidden="true"></i></li>
										<li><i class="fa fa-star" aria-hidden="true"></i></li>
										<li><i class="fa fa-star" aria-hidden="true"></i></li>
										<li><i class="fa fa-star" aria-hidden="true"></i></li>
										<c:if test="${hotStore[4] == 4}">
											<li><i class="fa fa-star-o" aria-hidden="true"></i></li>
										</c:if>
										<c:if test="${hotStore[4] == 5}">
											<li><i class="fa fa-star" aria-hidden="true"></i></li>
										</c:if>
										
									</ul>
								</div>
								<div class="likes">
									<i class="fa fa-gratipay" aria-hidden="true"></i>
									<span>${hotStore[5]}</span>
								</div>
							</div>
						</a>
					</c:forEach>
				</div>
			</section>
		</section>
	</section>

	<!--媽咪推薦-->
	<section class="otherContent">
		<!--媽咪文章-->
		<div class="momBlog">
			<img class="momlogo" src="<c:url value="/images/mon_pic.png"/>">
			<div class="momTitle"><img src="<c:url value="/images/monBlog_title.png"/>"><span><a target="_blank" href="<c:url value='AllBlogController'/>">看更多..</a></span></div>

			<c:forEach var="newBlog" varStatus="st" items="${newBlogList}">
				<div class="momArtical">
					<a  target="_blank" href='<c:url value='/BlogItemOfArticle?articleID=${newBlog[0]}'/>'>
						<div class="articalL">
							<img width="160" height="125" src="data:image/jpeg;base64,${newBlog[1]}">
						</div>

						<div class="articalR">
							<p>${newBlog[3]}</p>
							<p>${newBlog[2]}...MORE</p>
							<p class="lookdetail">看詳細內容</p>
						</div>
					</a>
				</div>
			</c:forEach>
				
		</div>

		<!--友情連結-->
		<div class="otherLink">
			<div class="link facebookLink"><img src="<c:url value="/images/linkad01.jpg"/>"></div>
			<div class="link"><img src="<c:url value="/images/link_ad.png"/>"></div>
			<div class="link"><img src="<c:url value="/images/ad04.jpg"/>"></div>
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

<script type="text/javascript">
$(function(){
		// 一進來先獲取購物車內的內容
		
		$('.slidershow-Wrapper1').bxSlider({
		    slideWidth: 255,
		    moveSlides: 1,
		    minSlides: 4,
		    maxSlides: 4,
		    slideMargin: 40,
		    pager: false
  		}); 


  		 $('.slidershow-Wrapper2').bxSlider({
		    slideWidth: 255,
		    moveSlides: 1,
		    minSlides: 4,
		    maxSlides: 4,
		    slideMargin: 40,
		    pager: false
  		});

  		$('.slidershow-Wrapper3').bxSlider({
		    slideWidth: 255,
		    moveSlides: 1,
		    minSlides: 4,
		    maxSlides: 4,
		    slideMargin: 40,
		    pager: false
  		}); 
  		
  		$(".description").each(function(){
  	    	var mytext = $(this).text();
  			var newText = mytext.substr(0,40);
  			$(this).text(newText+"..."); 	
  		});
  		
})
</script>
