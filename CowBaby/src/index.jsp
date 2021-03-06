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
<link rel="stylesheet" href="<c:url value="/css/frontDesk/basic.css"/>">
<link rel="stylesheet" href="<c:url value="/css/frontDesk/index.css"/>">

<%-- <link rel="stylesheet" href="<c:url value="/pluging/Bxsliders/jquery.bxslider.min.css"/>"> --%>

<!--body-->
<body>
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
			<img  class="illustration1" src="img/img1.png">
			<img  class="illustration2" src="img/img2.png">
			<img  class="cutImgL" src="img/cutImgL.png">
			<img  class="cutImgR" src="img/cutImgR.png">
			<section class="mainTitle">
				<div class="topic">
					<img src="img/pop_store.png">
					<p>走過路過快來看看喔!跳樓大牌賣!!</p>
				</div>
			</section>

			<!--slidershow-->
			<section class="slidershow">
				<div class="slidershow-Wrapper3">
					<div class="item">
						<div class="choice"></div>
						<img src="img/newArrived1.jpg">
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
						<img src="img/newArrived1.jpg">
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
						<img src="img/newArrived1.jpg">
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
						<img src="img/newArrived1.jpg">
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
						<img src="img/newArrived1.jpg">
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
			<img class="momlogo" src="img/mon_pic.png">
			<div class="momTitle"><img src="img/monBlog_title.png"><span><a href="#">看更多..</a></span></div>

			<div class="momArtical">
				<div class="articalL">
					<img src="img/artical_img1.png">
					<p>部落客 牛牛媽咪</p>
				</div>

				<div class="articalR">
					<p>保暖啾啾褲超好穿大推!!</p>
					<p>秋冬新款全面鋪貨中 每一款都是精心挑選出來了 這裏有最新款全面鋪貨中 每一款全面鋪貨中 貨中 每一款全面都是精心挑選全面鋪貨中 好的質...MORE</p>
				</div>
			</div>

				<div class="momArtical">
				<div class="articalL">
					<img src="img/artical_img1.png">
					<p>部落客 牛牛媽咪</p>
				</div>

				<div class="articalR">
					<p>保暖啾啾褲超好穿大推!!</p>
					<p>秋冬新款全面鋪貨中 每一款都是精心挑選出來了 這裏有最新款全面鋪貨中 每一款全面鋪貨中 貨中 每一款全面都是精心挑選全面鋪貨中 好的質...MORE</p>
				</div>
			</div>

			<div class="momArtical">
				<div class="articalL">
					<img src="img/artical_img1.png">
					<p>部落客 牛牛媽咪</p>
				</div>

				<div class="articalR">
					<p>保暖啾啾褲超好穿大推!!</p>
					<p>秋冬新款全面鋪貨中 每一款都是精心挑選出來了 這裏有最新款全面鋪貨中 每一款全面鋪貨中 貨中 每一款全面都是精心挑選全面鋪貨中 好的質...MORE</p>
				</div>
			</div>
			<div class="momArtical">
				<div class="articalL">
					<img src="img/artical_img1.png">
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
			<div class="link"><img src="img/link_ad.png"></div>
			<div class="link">asdasdads</div>
		</div>
	</section>

	<!--登入框彈跳框-->
	<div class="overlay"></div>
	<div class="popupBox">
		<div class="loginBox">
			<a href="#" class="cancel_btn"></a>
			<div class="box_top">
				<div class="login_part">
					<h3>會員登入</h3>
					<form class="form-inline">
						<div class="form-group" style="margin-right: 15px">
							<label for="email">Email帳號</label>
							<input type="email" class="form-control" id="email">
						</div>
						<div class="form-group">
							<label for="pwd">密碼</label>
							<input type="password" class="form-control" id="pwd">
					    </div>
					    <button type="button" class="btn btn-primary btn-md">我要登入</button>
					    <button type="button" class="btn btn-warning btn-md">忘記密碼</button>
					</form>
				</div>
				<div class="register_part">
					<a href="#""><img src="img/mem-join.png"></a>
				</div>	
			</div>
			<div class="box_button">
				<h3>防詐騙提醒</h3>
				<table>
					<tr>
						<td>不操作ATM</td>
						<td>ATM最主要的功能是提款與轉帳，並沒有解除分期付款的選項。</td>
					</tr>
					<tr>
						<td>不透露信用卡資料</td>
						<td>請勿告知來電者信用卡號與卡片到期日。</td>
					</tr>
					<tr>
						<td>求證相關單位</td>
						<td>懷疑來電者是詐騙集團，請撥警政署反詐騙諮詢專線165，或洽客服人員07-721-0219，維護自身網路資料安全，建議您不定期進行掃毒，更新自己在各網站帳號的密碼，若使用公共電腦記得使用完畢要登出。</td>
					</tr>
				</table>
			</div>
		</div>	
	</div>

	<!--footer-->
	<section class="container-fliud footerWrapper">

		<div class="footerBk"></div>
		<div class="container footerContainer">

			<div class="containerBox container-1">
				<ul>
					<li><a href="#">關於我們</a></li>
					<li><a href="#">媽咪推薦</a></li>
					<li><a href="#">服務說明</a></li>
					<li><a href="#">客服專區</a></li>
				</ul>
			</div>
			<div class="containerBox container-1">
				<ul>
					<li><a href="#">關於我們</a></li>
					<li><a href="#">媽咪推薦</a></li>
					<li><a href="#">服務說明</a></li>
					<li><a href="#">客服專區</a></li>
				</ul>
			</div>

			<div class="containerBox container-1">
				<img src="img/content_img.png">
			</div>	
		</div>
		<div class="footerCopyright">COPYREGHT @ 2017  COWBABY MAKE</div>
	</section>
</body>
</html>


<!-- Bootstrap core JavaScript-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-switch/3.3.4/js/bootstrap-switch.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap3-dialog/1.34.7/js/bootstrap-dialog.min.js"></script>


<script src="https://cdnjs.cloudflare.com/ajax/libs/bxslider/4.2.12/jquery.bxslider.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bxslider/4.2.12/jquery.bxslider.css">
<%-- 
<script src="<c:url value="/pluging/Bxsliders/jquery.bxslider.min.js"/>"></script> --%>


<script type="text/javascript">

	$(function(){

		$(".login").click(function(){
			$(".overlay").show();
			$(".popupBox").show();
		})

		$(".cancel_btn").click(function(){
			$(".overlay").hide();
			$(".popupBox").hide();
		})


		$('.slidershow-Wrapper1').bxSlider(); 


  		/* $('.slidershow-Wrapper2').bxSlider({
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
  		}); */

		

	})

