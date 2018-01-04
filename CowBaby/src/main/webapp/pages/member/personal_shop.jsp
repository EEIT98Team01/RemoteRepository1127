<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
		<img src="${shopData.storeBanner}">
	</section>

	<section class="page_container personal_shop_page_container loadingBox">
		<div class="side_bar">
			<div class="personal_infor">
				<div class="seller_title">賣家資訊</div>
				<div class="seller_img">
					<img src="data:image/jpg;base64,${shopLogoImg}">
				</div>
				<div class="infor_titile">
					<span class="glyphicon glyphicon-home" aria-hidden="true"></span>
					<span>${shopData.storeName}</span>
				</div>
				<div class="infor_titile">
					<span class="glyphicon glyphicon-phone-alt" aria-hidden="true"></span>
					<span>${shopData.storePhone}</span>
				</div>

				<div class="infor_valuation">
					<span>消費者滿意度：<span class="score">${shopData.storeRating*2}</span></span>
					<div class="stars">
							
							<c:if test="${shopData.storeRating==0}">
								<ul>
									<li><i class="fa fa-star" aria-hidden="true"></i></li>
									<li><i class="fa fa-star-o" aria-hidden="true"></i></li>
									<li><i class="fa fa-star-o" aria-hidden="true"></i></li>
									<li><i class="fa fa-star-o" aria-hidden="true"></i></li>
									<li><i class="fa fa-star-o" aria-hidden="true"></i></li>
								</ul>
							</c:if>
							<c:if test="${shopData.storeRating==1}">
								<ul>
									<li><i class="fa fa-star" aria-hidden="true"></i></li>
									<li><i class="fa fa-star-o" aria-hidden="true"></i></li>
									<li><i class="fa fa-star-o" aria-hidden="true"></i></li>
									<li><i class="fa fa-star-o" aria-hidden="true"></i></li>
									<li><i class="fa fa-star-o" aria-hidden="true"></i></li>
								</ul>
							</c:if>
							<c:if test="${shopData.storeRating==2}">
								<ul>
									<li><i class="fa fa-star" aria-hidden="true"></i></li>
									<li><i class="fa fa-star" aria-hidden="true"></i></li>
									<li><i class="fa fa-star-o" aria-hidden="true"></i></li>
									<li><i class="fa fa-star-o" aria-hidden="true"></i></li>
									<li><i class="fa fa-star-o" aria-hidden="true"></i></li>
								</ul>
							</c:if>
							<c:if test="${shopData.storeRating==3}">
								<ul>
									<li><i class="fa fa-star" aria-hidden="true"></i></li>
									<li><i class="fa fa-star" aria-hidden="true"></i></li>
									<li><i class="fa fa-star" aria-hidden="true"></i></li>
									<li><i class="fa fa-star-o" aria-hidden="true"></i></li>
									<li><i class="fa fa-star-o" aria-hidden="true"></i></li>
								</ul>
							</c:if>
							<c:if test="${shopData.storeRating==4}">
								<ul>
									<li><i class="fa fa-star" aria-hidden="true"></i></li>
									<li><i class="fa fa-star" aria-hidden="true"></i></li>
									<li><i class="fa fa-star" aria-hidden="true"></i></li>
									<li><i class="fa fa-star" aria-hidden="true"></i></li>
									<li><i class="fa fa-star-o" aria-hidden="true"></i></li>
								</ul>
							</c:if>
							<c:if test="${shopData.storeRating==5}">
								<ul>
									<li><i class="fa fa-star" aria-hidden="true"></i></li>
									<li><i class="fa fa-star" aria-hidden="true"></i></li>
									<li><i class="fa fa-star" aria-hidden="true"></i></li>
									<li><i class="fa fa-star" aria-hidden="true"></i></li>
									<li><i class="fa fa-star" aria-hidden="true"></i></li>
								</ul>
							</c:if>		
					</div>
				</div>
				
			</div>
			<!--其他功能-->
			<div class="other_function">
				<p>每日流覽人數: <span>${shopData.totalPageView}</span></p>
				<p>人氣: <span><fmt:formatNumber value=" ${shopData.totalPageView*100/1.5}" pattern="#" type="number"/></span></p>
				<a href="#" class="audit_popupbox_btn"><i style="margin-right: 5px;" class="fa fa-commenting-o" aria-hidden="true"></i>發訊給賣家</a>
				<a style="margin-left: 15px;background:#818080;" href="#"><i style="margin-right: 5px;" class="fa fa-user-circle-o" aria-hidden="true"></i>檢舉</a>
			</div>
		</div>

		<!-- 個人商店頁面-->
		<div class="main_container_col_2 personal_shop">
			<div class="shop_introduction">
				<div class="personal_shop_name">${shopData.storeName}</div>
				<div class="personal_shop_description">${shopData.storeDescription}</div>
			</div>
			<div class="container_pagination">
				<div class="container_pagination_title col-md-2">全部商品</div>
				<div class="pull-right">
					<ul class="pagination" id="myPagination"></ul>	
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
<script src="<c:url value="/pluging/Bootsrap/jquery.twbsPagination.js"/>"></script>
<script src="https://cdn.jsdelivr.net/npm/gasparesganga-jquery-loading-overlay@1.5.4/src/loadingoverlay.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/gasparesganga-jquery-loading-overlay@1.5.4/extras/loadingoverlay_progress/loadingoverlay_progress.min.js"></script>


<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/bxslider/4.2.12/jquery.bxslider.js"></script> -->
<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bxslider/4.2.12/jquery.bxslider.css">  -->
 



<script type="text/javascript">

	$(function(){
		
		
		
		// 預設當前頁
	   	var pagenow = 1; 
	   	// 預設總頁數
	   	var totalPage = 1; 
	   	// 預設每頁顯示筆數
	   	var visiblecount = 10; 

	 	// 設置 loaading圖案
		$.LoadingOverlaySetup({ size : "12%"});
	   	
		queryData(10, 1);
		
		// 查詢過濾勾選的商品
		function queryData(pageSize,pageNumber){
			// 將畫面清空
			$('.proudectList').empty();
			
	    	$.ajax({
		        type:"GET",
		        url: "/CowBaby/prouducts/storeProdcut",
		        data: {
		        	 storeID:"${storeID}",
			       	 pageSize:pageSize,
		       		 pageNumber:pageNumber
		        }, 
		         
		        dataType:"json",   
		        
		       // ajax載入前
		        beforeSend: function(){
		        	$(".loadingBox").LoadingOverlay("show");
				},
				
				// 成功要做的事
		        success : function(response){   
			        console.log("response",response);
			        
			        $(".loadingBox").LoadingOverlay("hide");
			        var obj = JSON.parse(response.list);
			        
			        $.each(obj, function (index, myitem) {
			        	   console.log("customer",myitem);
			           	    var html="";
			 		    	html="<div class='item'>"+                                                                                        
		 							"<a href='<c:url value='ProductItemOfShop'/>?storeID=&productID=" + myitem.productID + "'>"+
			 							"<img src='" + myitem.productImage + "'>"+
			 							"<p class='stroe_name'>"+ myitem.title +"</p>"+
			 							"<div class='specialPrice'>售價 NT <span class='specialPriceNum'>" + myitem.unitPrice + "</span></div>"
		 							"</a>"+
								  "</div>";				
		 		    		$('.proudectList').append(html);
			         })
			         
	         		 // 自動產生分頁
		         	 var totalPages = response.tatalPage;
		             var pageSize  = response.pageSize;
	 
	 				 if(!totalPages==0){
	 				 // 如果查詢有資料
					    $('#myPagination').twbsPagination({
			                  totalPages: totalPages,
			                  visiblePages: visiblecount,
			                  initiateStartPageClick: false,
			                 /*  hideOnlyOnePage: true, */
			                  onPageClick: function (evt, page) { 
			                	  queryData(10,page);
				       	　　　　}
		                 });
	 				  
						 // 把頁數 ，筆數，開始筆數-結束筆數 塞回去
			             $(".pageNum").html(response.pageNumber);
			             $(".firstNum").html( ((response.pageNumber-1)*response.pageSize) +1);
			             $(".endNum").html(response.pageNumber*response.pageSize);
			             $(".totalNum").html(response.tatal);
					  
	 				 }else{
	 			 	 // 如果查詢無資料	
	 					 $(".pageNum").html(0);
	 		             $(".firstNum").html(0);
	 		             $(".endNum").html(0);
	 		             $(".totalNum").html(0);
	 		             $('tbody').html('<tr><td colspan="10">目前無任何資料</td></tr>');	
	 				 }
	        	
		        },

		         
				// 發ajax錯誤
		        error:function(xhr, ajaxOptions, thrownError) {
		            /* alert(xhr.status+"\n"+thrownError); */
		        	 $(".loadingBox").LoadingOverlay("hide");
		        }

	    	});
		}
		
		// 申訴審核彈出框
		$(".audit_popupbox_btn").click(function(){
			event.preventDefault(); 

	 		var emailId = $(this).parents('tr').find('td').eq(1).text();
	 		var id = $(this).parents('tr').find('td').eq(6).text();
	 		
	 		BootstrapDialog.show({
	 			 message: $('<div></div>').load('${pageContext.request.contextPath}/pages/common/send_message.jsp'),
	             title:"發訊息給賣家",
	             buttons: [{
	 		                label: '確定',
	 		                // no title as it is optional
	 		                cssClass: 'btn-primary',
	 		                action: function(dialogItself){
	 		                	// 抓取裡面表單資料
	 		                	formData = $(".seller_audit_popupForm").serializeArray();
	 		                	sendMessage("${user.email}", "${shopData.email}", formData[0].value);
	 		                	dialogItself.close();
	 		                }
	 		            },{
	 		                label: '取消',
	 		                action: function(dialogItself){
	 		                    dialogItself.close();
	 		               }
	 		            }]
	 	     });
		});
		
		//改變審核狀態
	 	function sendMessage(sender, receiver, content){
	 		$.ajax({
		        type:"POST",                   
		        url: "/CowBaby/message/sendMessage",
		        data: {
		        	msgSenderAccount:sender,
		        	msgReceiverAccount:receiver,
		        	msgContent:content
		        }, 
		         
		        dataType:"json",          
				// 成功要做的事
		        success : function(response){
		        	//通知儲存成功  ，call BootstrapDialog      		       
					BootstrapDialog.show({
						type: BootstrapDialog.TYPE_INFO,
						title: "訊息",
						message: '傳送成功!!',
						buttons: [{
							label: 'Close',
							action: function(dialogItself){
								dialogItself.close();
							}
						}]
					});  
		        }
	 		})         
	 	} 

	})
</script>
