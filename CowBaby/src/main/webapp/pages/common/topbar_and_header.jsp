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
					<span class="shopcart-total-number">0</span>
				</a>
				<div class="currentShoppingCartList">
					<ul>購物車空空的</ul>
					<p class="calculate">總價錢:<span>0</span></p>
				</div>
			</li>
		
			<li><a href="<c:url value="/ShoppingCartCheckController"/>">結帳去</a></li>	
			<c:if test="${empty user}">
				<li style="margin-top: 15px;"><a href="<c:url value="/pages/member/user_login.jsp"/>">登入</a></li>
				<li style="margin: 15px 0 0 0;color: #3a939e;">/</li>
				<li style="margin-top: 15px;"><a href="<c:url value="/pages/member/user_register.jsp"/>">註冊</a></li>
			</c:if>
			<c:if test="${not empty user}">
				<li><img src="data:image/jpg;base64,${logingPhotoImg}"/>${user.customerName}
					<div class="showMemberPannal">
						<div><a href="#">我的賣場</a></div>
						<div><a href="<c:url value="/pages/backstageSeller/account_overview.jsp"/>">我的管理著後台</a></div>
						<div><a href="<c:url value="/pages/member/member_account_infor.jsp"/>">我的資訊</a></div>
						<div><a href="<c:url value="/LoingOutController"/>">安全登出</a></div>
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
				<li><a href="<c:url value="/AllProductController"/>"><i class="fa fa-gift fa-2x" aria-hidden="true"></i>全部商品</a></li>
				<li><a href="<c:url value="/pages/member/all_products.jsp"/>"><i class="fa fa-diamond fa-2x" aria-hidden="true"></i>最新商品</a></li>
				<li><a href="<c:url value="/pages/member/all_shops.jsp"/>"><i class="fa fa-heartbeat fa-2x" aria-hidden="true"></i>精選商家</a></li>
				<li><a href="<c:url value="/AllBlogController"/>"/><i class="fa fa-star-half-o fa-2x" aria-hidden="true"></i>媽咪推薦</a></li>
				<li><a href="<c:url value="/pages/member/customer_service.jsp"/>"/><i class="fa fa-thumbs-up fa-2x" aria-hidden="true"></i>客戶服務</a></li>
			</ul>
		</section>
	</section>
</header>
<!--header end-->

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">

$(function(){
	
	 $(".currentShoppingCartList").show();
	
/* 
	$(".shopcart").hover(function(event) {
	    $(".currentShoppingCartList").show();
	});
	
	$(".currentShoppingCartList").hover(function(event) {
	    $(".currentShoppingCartList").show();
	});
	
	
	$(".currentShoppingCartList").mouseleave( 'mouseleave', function() {
	    $(".currentShoppingCartList").hide();
	}); 
 */
 	
 
 	// 發AJAX 先拿購物車清單
	$.ajax({
		url: "http://localhost:8080/CowBaby/shopping/getShoppingCart",
		type: "get",
		data:{
		  
		},
		dataType:"json",   
		success: function(result){ 

		    var productInfor = result.productInfo;
		    var totalAmount = result.totalAmount;
		    var totalItems = result.totalItems;
		    var item="";
		    var totalBuyNumber=0;
		    
		    // 把每ㄧ筆店家所購買的物品列出來 (key = 商店名子,productInfor = 在該商店購買的物品 )
		    for(var key in productInfor){
		       for(var i =0 ; i<productInfor[key].length ; i++){
		    	    // 全部購買總商品數量
		    	    totalBuyNumber = totalBuyNumber + productInfor[key][i].quantity;
		       		item  = item +"<li>"+
		        			"<img src='<c:url value='/images/ad1.jpg'/>'>"+
							"<div class='cartList'>"+
								"<p>"+ key +"</p>"+
								"<p>"+ productInfor[key][i].productName + "<span>-"+ productInfor[key][i].productSpec+"</span></p>"+
								"<p>"+ productInfor[key][i].unitPrice +"元 X"+ productInfor[key][i].quantity +"</p>"+
							"</div>"+
							"</li>" 
		       } 

		    }
		    
		    // 把資訊帶入購物車
		    if(totalItems==0){
		    	 $(".shopcart-total-number").text(0);
		    	 $(".calculate span").text(totalAmount);
		    	 $(".currentShoppingCartList ul").html("購物車空空的");
		    	
		    }else{
		    	$(".shopcart-total-number").text(totalBuyNumber);
		    	$(".currentShoppingCartList ul").html(item);
			    $(".calculate span").text(totalAmount);
		    }
		  

		},
		error: function(result){  
		     //your code here
		}
	})

})
		
		
		
		
</script>
