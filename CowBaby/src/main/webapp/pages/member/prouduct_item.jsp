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
				<li class="sort-title">超人氣選購款</li>
				<li><a href="#">民族風針織斗篷-桃紅</a></li>
				<li><a href="#">紅條紋圍兜兜</a></li>
				<li><a href="#">【甜蜜小孩系列】小販手推車</a></li>
				<li><a href="#">丹麥熊熊安撫音樂鈴(粉紅)</a></li>
			</ul>
		</div>

		<!-- 主要內容-->
		<div class="main_container_col_2">
		
			<!--產品明細-->
			<section class="proudect_detail" style="overflow: auto;">

				<div class="showPic">
					<img src="${productData.productImage}">
				</div>

				<div class="product_infor">
					<div class="product_title">${productData.title}</div>
					<div class="product_desc">${productData.summary}</div>
					<div class="product_price">NT.${productData.unitPrice}</div>

					<div class="product_size">
						<p><i class="fa fa-gift" aria-hidden="true"></i>產品規格</p>
						<ul>
						<c:forEach var="item" varStatus="st" items="${productSize}">
							<li><a href="#" class="productSpec"><span>${item.productSpec}</span>(${item.specStock})</a></li>
						</c:forEach>	
						</ul>
					</div>
					
					<div class="product_number">
						<span style="float: left;padding: 10px;font-size: 14px;">要購買數量</span>
						<a href="#" class="add_num" style="color: #fff;border: 1px solid #939191;">+</a>
						<input type="text" value="0" id="quantity">
						<a href="#" class="reduce_num" style="color: #fff;border: 1px solid #939191;">-</a>
						
					</div>

					<div class="checkout">
						<a class="add_cart"  href="#">加入購物車</a>
						<a class="gopay" href="#">去結帳</a>				
					</div>
				</div>
			</section>
			
			
			<section class="proudect_ckeditor">
				${productData.productDescription}
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


<script type="text/javascript">

$(function(){
	
		// 要傳給後端的資料
		var quantity = 0; //數量
		var productID = ${productData.productID}; // 產品ID
		var productSpec = ""; // 產品規格

		
		// 增加商品
		$(".add_num").click(function(){
			event.preventDefault();
			var num_add = parseInt($("#quantity").val())+1;
		  	if($("#quantity").val()==""){
		    	num_add = 1;
		  	}
		  	$("#quantity").val(num_add);
		  	
		  	quantity = $("#quantity").val();
		  	
		});
			
		// 減少商品
		$(".reduce_num").click(function(){
			event.preventDefault();
			var num_dec = parseInt($("#quantity").val())-1;
			if(num_dec<0){
				$("#quantity").val(0);
				quantity = $("#quantity").val();
			}else{
				$("#quantity").val(num_dec);
				quantity = $("#quantity").val();
			}
		});
				
		// input輸入商品數量
		$("#quantity").keyup(function(){
		    if(isNaN($(this).val())||parseInt($(this).val())<1){
		      $(this).val("1");
		      quantity = $("#quantity").val(); 
		    }
		})
		
		// 選擇產品類型
		$(".productSpec").click(function(){
			event.preventDefault();
			$(".productSpec").removeClass('select');
			$(this).addClass('select');
			
			// 使用著選取的size
			productSpec = $(this).find('span').text();
		})
		

		// 加入購物車
		$(".add_cart").on('click', function () {
			
			$.ajax({
				url:"http://localhost:8080/CowBaby/shopping/addShoppingCart",
				type: 'post',
				data:{
				    productID:productID,
					spec:productSpec,
					productNum:quantity

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
})
</script>
