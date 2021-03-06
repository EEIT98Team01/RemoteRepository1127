<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- 前台 topbar header -->
<!--topbar-->
<div class="container-fliud top-bar">
	<section class="container">
		<ul class="top-bar-menu pull-right">
			<c:if test="${user.userID==2}">
				<li class="myshopStoreLi"><a class="myshopStore" href="<c:url value="PersonShopController"/>?storeID=${myStoreID}&email=${user.email}">
						<span><img src="<c:url value="/images/myshop.png"/>"></span>
						<span>myshop</span>
					</a>
				</li>
			</c:if>
			
			<li class="shopcartli">
				<a class="shopcart" href="#">
					<i class="fa fa-cart-plus fa-2x" aria-hidden="true"></i>
					<span class="shopcart-total-number">0</span>
				</a>
				<a class="gotopay" href="<c:url value="/ShoppingCartCheckController"/>">結帳去</a>
				<div class="currentShoppingCartList">
					<ul> 購物車空空的 </ul>
					<p class="calculate">總價錢:<span>0</span></p>
				</div>
			</li>
	
			<c:if test="${empty user}">
				<li class="login" style="margin-top: 15px;"><a href="<c:url value="/pages/member/user_login.jsp"/>">登入</a></li>
				<li class="line" style="margin: 15px 0 0 0;color: #3a939e;padding: 0;">/</li>
				<li class="register" style="margin-top: 15px;"><a href="<c:url value="/pages/member/user_register.jsp"/>">註冊</a></li>
			</c:if>
			<c:if test="${not empty user}">
				<li class="loginUser">
					<img src="data:image/jpg;base64,${logingPhotoImg}"/>${user.customerName}
					<div class="showMemberPannal">
						<div class="arrow"></div>
						<c:if test="${user.userID==2}">
							<div><a href="<c:url value="PersonShopController"/>?storeID=${myStoreID}&email=${user.email}">我的賣場</a></div>
							<div><a href="<c:url value="/pages/backstageSeller/SellerBackstagePageController.controller"/>">賣場管理後台</a></div>
						</c:if>
						<div><a href="<c:url value="/pages/member/member_account_infor.jsp"/>">我的資訊</a></div>
						<div><a href="<c:url value="/LoingOutController"/>">安全登出</a></div>
					</div>
				</li>
			</c:if> 
	</section>
</div>

<!--header-->
<header>
	<section class="container">
		<row>
			<div class="col-md-3 logo">
				<a href="<c:url value="/"/>"><img src="<c:url value="/images/logo01.jpg"/>"></a>
			</div>
			

			<form class="col-md-5 pull-right searchProduct" role="search" action="<c:url value='AllProductController'/>" method="post">
			    <div class="input-group add-on">
			      	<input class="form-control" style="border: 2px solid #9ee2ea;" placeholder="Search" name="keyWord" id="title" value="${keyWord}" type="text">
			      	<div class="input-group-btn">
			        	<button class="btn btn-default searchStyle" style="border: 4px solid #8bd1d9;" type="submit"><i class="glyphicon glyphicon-search"></i></button>
			      	</div>
			    </div>
		  	</form>
		</row>			
	</section>

	<section class="container-fliud">
		<section class="container main-nav" style="padding:0;">
			<ul class="nav navbar-nav">
				<li><a href="<c:url value="/AllProductController"/>"><i class="fa fa-gift fa-2x" aria-hidden="true"></i>全部商品</a></li>
				<li><a href="<c:url value="/NewArrivalController"/>"><i class="fa fa-diamond fa-2x" aria-hidden="true"></i>最新商品</a></li>
				<li><a href="<c:url value="/AllShopController"/>"><i class="fa fa-heartbeat fa-2x" aria-hidden="true"></i>精選商家</a></li>
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
	
	$(".currentShoppingCartList").hide();

	$(".shopcart").hover(function(event) {
	    $(".currentShoppingCartList").show();
	});
	
	$(".currentShoppingCartList").hover(function(event) {
	    $(".currentShoppingCartList").show();
	});

	$(".currentShoppingCartList").mouseleave( 'mouseleave', function() {
	    $(".currentShoppingCartList").hide();
	});
	
	
	$(".showMemberPannal").hide();

	var isShowMemberPannal=false;
	$(".loginUser").click(function(){
		isShowMemberPannal = !isShowMemberPannal;
		if(isShowMemberPannal){
			$(".showMemberPannal").show();
		}else{
			$(".showMemberPannal").hide();
		}
		
	})
	

 
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
		        			"<img src='" + productInfor[key][i].productImage + "'>"+
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
