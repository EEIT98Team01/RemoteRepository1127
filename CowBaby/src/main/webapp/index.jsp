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
		        <img src="<c:url value="/images/a3.jpg"/>" alt="Chicago" style="width:100%;">
		      </div>
		    
		      <div class="item">
		        <img src="<c:url value="/images/a3.jpg"/>" alt="New york" style="width:100%;">
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
				<div class="item">
					<img src="<c:url value="/images/newArrived1.jpg"/>">
					<p class="title">英國Blade ＆ Rose 聖誕款內搭褲</p>
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
					<img src="<c:url value="/images/newArrived3.jpg"/>">
					<p class="title">英國Blade ＆ Rose 聖誕款內搭褲</p>
					<div class="originalPrice">原價 NT 190</div>
					<div class="specialPrice">特價 NT <span class="specialPriceNum">190</span></div>
				</div>

				<div class="item">
					<img src="<c:url value="/images/newArrived4.jpg"/>">
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
					<img src="<c:url value="/images/newArrived2.jpg"/>">
					<p class="title">英國Blade ＆ Rose 聖誕款內搭褲</p>
					<div class="originalPrice">原價 NT 190</div>
					<div class="specialPrice">特價 NT <span class="specialPriceNum">190</span></div>
				</div>

				<div class="item">
					<img src="<c:url value="/images/newArrived3.jpg"/>">
					<p class="title">英國Blade ＆ Rose 聖誕款內搭褲</p>
					<div class="originalPrice">原價 NT 190</div>
					<div class="specialPrice">特價 NT <span class="specialPriceNum">190</span></div>
				</div>

				<div class="item">
					<img src="<c:url value="/images/newArrived4.jpg"/>">
					<p class="title">英國Blade ＆ Rose 聖誕款內搭褲</p>
					<div class="originalPrice">原價 NT 190</div>
					<div class="specialPrice">特價 NT <span class="specialPriceNum">190</span></div>
				</div>					
			</div>
		</section>
	</section>

	<!--doc line-->
	<section class="docline"></section>

	<!--熱門商品-->
	<section class="hotProuduct">
		<section class="mainTitle">
			<div class="topic">
				<img src="<c:url value="/images/new_arrived.png"/>">
				<p>走過路過快來看看喔!跳樓大牌賣!!</p>
			</div>
		</section>

		<!--slidershow-->
		<section class="slidershow">
			<div class="slidershow-Wrapper2">
				
				<div class="item">
					<div class="topIcon">1</div>
					<img src="<c:url value="/images/newArrived1.jpg"/>">
					<p class="title">英國Blade ＆ Rose 聖誕款內搭褲</p>
					<div class="originalPrice">原價 NT 190</div>
					<div class="specialPrice">特價 NT <span class="specialPriceNum">190</span></div>
				</div>
				

				<div class="item">
					<div class="topIcon">2</div>
					<img src="<c:url value="/images/newArrived2.jpg"/>">
					<p class="title">英國Blade ＆ Rose 聖誕款內搭褲</p>
					<div class="originalPrice">原價 NT 190</div>
					<div class="specialPrice">特價 NT <span class="specialPriceNum">190</span></div>
				</div>

				<div class="item">
					<div class="topIcon">3</div>
					<img src="<c:url value="/images/newArrived3.jpg"/>">
					<p class="title">英國Blade ＆ Rose 聖誕款內搭褲</p>
					<div class="originalPrice">原價 NT 190</div>
					<div class="specialPrice">特價 NT <span class="specialPriceNum">190</span></div>
				</div>

				<div class="item">
					<div class="topIcon">4</div>
					<img src="<c:url value="/images/newArrived4.jpg"/>">
					<p class="title">英國Blade ＆ Rose 聖誕款內搭褲</p>
					<div class="originalPrice">原價 NT 190</div>
					<div class="specialPrice">特價 NT <span class="specialPriceNum">190</span></div>
				</div>

				<div class="item">
					<div class="topIcon">5</div>
					<img src="<c:url value="/images/newArrived1.jpg"/>">
					<p class="title">英國Blade ＆ Rose 聖誕款內搭褲</p>
					<div class="originalPrice">原價 NT 190</div>
					<div class="specialPrice">特價 NT <span class="specialPriceNum">190</span></div>
				</div>

				<div class="item">
					<div class="topIcon">6</div>
					<img src="<c:url value="/images/newArrived1.jpg"/>">
					<p class="title">英國Blade ＆ Rose 聖誕款內搭褲</p>
					<div class="originalPrice">原價 NT 190</div>
					<div class="specialPrice">特價 NT <span class="specialPriceNum">190</span></div>
				</div>

				<div class="item">
					<div class="topIcon">7</div>
					<img src="<c:url value="/images/newArrived1.jpg"/>">
					<p class="title">英國Blade ＆ Rose 聖誕款內搭褲</p>
					<div class="originalPrice">原價 NT 190</div>
					<div class="specialPrice">特價 NT <span class="specialPriceNum">190</span></div>
				</div>

				<div class="item">
					<div class="topIcon">8</div>
					<img src="<c:url value="/images/newArrived1.jpg"/>">
					<p class="title">英國Blade ＆ Rose 聖誕款內搭褲</p>
					<div class="originalPrice">原價 NT 190</div>
					<div class="specialPrice">特價 NT <span class="specialPriceNum">190</span></div>
				</div>

				<div class="item">
					<div class="topIcon">9</div>
					<img src="<c:url value="/images/newArrived1.jpg"/>">
					<p class="title">英國Blade ＆ Rose 聖誕款內搭褲</p>
					<div class="originalPrice">原價 NT 190</div>
					<div class="specialPrice">特價 NT <span class="specialPriceNum">190</span></div>
				</div>

				<div class="item">
					<div class="topIcon">10</div>
					<img src="<c:url value="/images/newArrived1.jpg"/>">
					<p class="title">英國Blade ＆ Rose 聖誕款內搭褲</p>
					<div class="originalPrice">原價 NT 190</div>
					<div class="specialPrice">特價 NT <span class="specialPriceNum">190</span></div>
				</div>
	
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
					<div class="item">
						<div class="choice"></div>
						<img src="<c:url value="/images/newArrived1.jpg"/>">
						<div class="shopName">兔兔的家</div>
						<div class="description">
							秋冬新款全面鋪貨中 每一款都是精心挑選出來了 這裏有最好的質量歡迎來諮詢 ！！
						</div>
						<div class="stars">
							<ul>
								<li><i class="fa fa-star" aria-hidden="true"></i></li>
								<li><i class="fa fa-star" aria-hidden="true"></i></li>
								<li><i class="fa fa-star" aria-hidden="true"></i></li>
								<li><i class="fa fa-star-o" aria-hidden="true"></i></li>
								<li><i class="fa fa-star-o" aria-hidden="true"></i></li>
							</ul>
							
						</div>
						<div class="likes">
							<i class="fa fa-gratipay" aria-hidden="true"></i>
							<span>1234</span>
						</div>
					</div>

					<div class="item">
						<div class="choice"></div>
						<img src="<c:url value="/images/newArrived1.jpg"/>">
						<div class="shopName">兔兔的家</div>
						<div class="description">
							秋冬新款全面鋪貨中 每一款都是精心挑選出來了 這裏有最好的質量歡迎來諮詢 ！！
						</div>
						<div class="stars">
							<ul>
								<li><i class="fa fa-star" aria-hidden="true"></i></li>
								<li><i class="fa fa-star" aria-hidden="true"></i></li>
								<li><i class="fa fa-star" aria-hidden="true"></i></li>
								<li><i class="fa fa-star-o" aria-hidden="true"></i></li>
								<li><i class="fa fa-star-o" aria-hidden="true"></i></li>
							</ul>
							
						</div>
						<div class="likes">
							<i class="fa fa-gratipay" aria-hidden="true"></i>
							<span>1234</span>
						</div>
					</div>

					<div class="item">
						<div class="choice"></div>
						<img src="<c:url value="/images/newArrived1.jpg"/>">
						<div class="shopName">雄大的農場</div>
						<div class="description">
							秋冬新款全面鋪貨中 每一款都是精心挑選出來了 這裏有最好的質量歡迎來諮詢 ！！
						</div>
						<div class="stars">
							<ul>
								<li><i class="fa fa-star" aria-hidden="true"></i></li>
								<li><i class="fa fa-star" aria-hidden="true"></i></li>
								<li><i class="fa fa-star" aria-hidden="true"></i></li>
								<li><i class="fa fa-star-o" aria-hidden="true"></i></li>
								<li><i class="fa fa-star-o" aria-hidden="true"></i></li>
							</ul>
							
						</div>
						<div class="likes">
							<i class="fa fa-gratipay" aria-hidden="true"></i>
							<span>1234</span>
						</div>
					</div>


					<div class="item">
						<div class="choice"></div>
						<img src="<c:url value="/images/newArrived1.jpg"/>">
						<div class="shopName">珠珠的小天地</div>
						<div class="description">
							秋冬新款全面鋪貨中 每一款都是精心挑選出來了 這裏有最好的質量歡迎來諮詢 ！！
						</div>
						<div class="stars">
							<ul>
								<li><i class="fa fa-star" aria-hidden="true"></i></li>
								<li><i class="fa fa-star" aria-hidden="true"></i></li>
								<li><i class="fa fa-star" aria-hidden="true"></i></li>
								<li><i class="fa fa-star-o" aria-hidden="true"></i></li>
								<li><i class="fa fa-star-o" aria-hidden="true"></i></li>
							</ul>
							
						</div>
						<div class="likes">
							<i class="fa fa-gratipay" aria-hidden="true"></i>
							<span>1234</span>
						</div>
					</div>

					<div class="item">
						<div class="choice"></div>
						<img src="<c:url value="/images/newArrived1.jpg"/>">
						<div class="shopName">汪汪的小舖鋪</div>
						<div class="description">
							秋冬新款全面鋪貨中 每一款都是精心挑選出來了 這裏有最好的質量歡迎來諮詢 ！！
						</div>
						<div class="stars">
							<ul>
								<li><i class="fa fa-star" aria-hidden="true"></i></li>
								<li><i class="fa fa-star" aria-hidden="true"></i></li>
								<li><i class="fa fa-star" aria-hidden="true"></i></li>
								<li><i class="fa fa-star-o" aria-hidden="true"></i></li>
								<li><i class="fa fa-star-o" aria-hidden="true"></i></li>
							</ul>
							
						</div>
						<div class="likes">
							<i class="fa fa-gratipay" aria-hidden="true"></i>
							<span>1234</span>
						</div>
					</div>
				</div>
			</section>
		</section>
	</section>

	<!--媽咪推薦-->
	<section class="otherContent">
		<!--媽咪文章-->
		<div class="momBlog">
			<img class="momlogo" src="<c:url value="/images/mon_pic.png"/>">
			<div class="momTitle"><img src="<c:url value="/images/monBlog_title.png"/>"><span><a href="#">看更多..</a></span></div>

			<div class="momArtical">
				<div class="articalL">
					<img src="<c:url value="/images/artical_img1.png"/>">
					<p>部落客 牛牛媽咪</p>
				</div>

				<div class="articalR">
					<p>保暖啾啾褲超好穿大推!!</p>
					<p>秋冬新款全面鋪貨中 每一款都是精心挑選出來了 這裏有最新款全面鋪貨中 每一款全面鋪貨中 貨中 每一款全面都是精心挑選全面鋪貨中 好的質...MORE</p>
				</div>
			</div>

				<div class="momArtical">
				<div class="articalL">
					<img src="<c:url value="/images/artical_img1.png"/>">
					<p>部落客 牛牛媽咪</p>
				</div>

				<div class="articalR">
					<p>保暖啾啾褲超好穿大推!!</p>
					<p>秋冬新款全面鋪貨中 每一款都是精心挑選出來了 這裏有最新款全面鋪貨中 每一款全面鋪貨中 貨中 每一款全面都是精心挑選全面鋪貨中 好的質...MORE</p>
				</div>
			</div>

			<div class="momArtical">
				<div class="articalL">
					<img src="<c:url value="/images/artical_img1.png"/>">
					<p>部落客 牛牛媽咪</p>
				</div>

				<div class="articalR">
					<p>保暖啾啾褲超好穿大推!!</p>
					<p>秋冬新款全面鋪貨中 每一款都是精心挑選出來了 這裏有最新款全面鋪貨中 每一款全面鋪貨中 貨中 每一款全面都是精心挑選全面鋪貨中 好的質...MORE</p>
				</div>
			</div>
			<div class="momArtical">
				<div class="articalL">
					<img src="<c:url value="/images/artical_img1.png"/>">
					<p>部落客 牛牛媽咪</p>
				</div>

				<div class="articalR">
					<p>保暖啾啾褲超好穿大推!!</p>
					<p>秋冬新款全面鋪貨中 每一款都是精心挑選出來了 這裏有最新款全面鋪貨中 每一款全面鋪貨中 貨中 每一款全面都是精心挑選全面鋪貨中 好的質...MORE</p>
				</div>
			</div>	
		</div>

		<!--友情連結-->
		<div class="otherLink">
			<div class="link facebookLink">asdas</div>
			<div class="link"><img src="<c:url value="/images/link_ad.png"/>"></div>
			<div class="link">asdasdads</div>
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
	})
</script>
