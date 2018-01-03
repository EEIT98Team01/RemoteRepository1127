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
	<section class="page_container all_products_page_container loadingBox">
		<div class="side_bar">
			<ul>
				<li class="sort-title">商品分類</li>
				<c:forEach var="item" items="${classficationList}">
					<li><label><input type="checkbox" name ="classfication" value="${item[0].classficationID}" > <span>${item[0].classficatoinName} </span><span>(${item[1]})</span></label> </li>
				</c:forEach>
			</ul>

			<ul>
				<li class="sort-title">年齡分類</li>
				<li><label><input type="checkbox" name ="suitableAges" value="1"> <span>0-3 歲</span> <span></span></label> </li>
				<li><label><input type="checkbox" name ="suitableAges" value="2"> <span>3-6 歲</span> <span></span></label> </li>
				<li><label><input type="checkbox" name ="suitableAges" value="3"> <span>6-12 歲</span> <span></span></label> </li>
				<li><label><input type="checkbox" name ="suitableAges" value="4"> <span>12 歲以上</span> <span></span></label> </li>	
			</ul>

			<ul>
				<li class="sort-title">性別分類</li>
				<li><label><input type="checkbox" name ="genderPreference" value="A"> <span>通用</span> <span>(4890)</span></label> </li>
				<li><label><input type="checkbox" name ="genderPreference" value="M"> <span>男</span> <span>(4890)</span></label> </li>
				<li><label><input type="checkbox" name ="genderPreference" value="F"> <span>女</span> <span>(4890)</span></label> </li>	
			</ul>
		</div>

		<!-- 主要內容-->
		<div class="main_container_col_2">
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
			<!--產品LIST-->
	
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

<script type="text/javascript">

	$(function(){
			   
		//初始參數設定
		var classfication ="";
		var suitableAges ="";
		var genderPreference ="";
		// 預設當前頁
	   	var pagenow = 1; 
	   	// 預設總頁數
	   	var totalPage = 1; 
	   	// 預設每頁顯示筆數
	   	var visiblecount = 10; 
	   	
	 	// 設置 loaading圖案
		$.LoadingOverlaySetup({ size : "12%"});
		
		queryData("","","",10,1);
		
		//判斷商品類勾選條件
		$('input[name="classfication"]').click(function(){
			
			  /* console.log("QQQ",$(this).prop('checked')); */
			  
	          $('#myPagination').twbsPagination('destroy');

			  if($(this).prop('checked')){
					$('input[name="classfication"]:checkbox').prop('checked',false);
					$(this).prop('checked',true);
					classfication = $(this).val();
					console.log("classfication",classfication);
			  }else{
				  classfication="";
			  }
			  queryData(classfication,suitableAges,genderPreference,10,1);
		});
		
		//判斷年齡分類勾選條件
		$('input[name="suitableAges"]').click(function(){
			
		      $('#myPagination').twbsPagination('destroy');

			  if($(this).prop('checked')){
					$('input[name="suitableAges"]:checkbox').prop('checked',false);
					$(this).prop('checked',true);
					suitableAges = $(this).val();
					console.log("suitableAges",suitableAges);
			  }else{
				  suitableAges ="";  
			  }
			  queryData(classfication,suitableAges,genderPreference,10,1);
		});
		
		//判斷性別有無勾選條件
		$('input[name="genderPreference"]').click(function(){
			
			  $('#myPagination').twbsPagination('destroy');

			  if($(this).prop('checked')){
					$('input[name="genderPreference"]:checkbox').prop('checked',false);
					$(this).prop('checked',true);
					genderPreference = $(this).val();
					console.log("genderPreference",genderPreference);
			  }else{
				  genderPreference ="";  
			  }
			  queryData(classfication,suitableAges,genderPreference,10,1);
		});
		
		console.log("******************************");
		

		// 查詢過濾勾選的商品
		function queryData(classfication,suitableAges,genderPreference,pageSize,pageNumber){
			
			console.log("***********最後帶的資料*******************");
			console.log("classfication=>",classfication);
			console.log("suitableAges=>",suitableAges);
			console.log("genderPreference=>",genderPreference);
			// 將畫面清空
			$('.proudectList').empty();
			
	    	$.ajax({
		        type:"GET",                   
		        url: "/CowBaby/prouducts/inquire",    
		        data: {
		        	 keyWord:"${keyWord}",
		        	 productClassfication:classfication,
		        	 suitableAges:suitableAges,
		        	 genderPreference:genderPreference,
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
// 			 							"<p class='prouduct_name'>" + myitem.summary +"</p>"+
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
			                	  queryData(classfication,suitableAges,genderPreference,10,page);
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
		        error:function(xhr, ajaxOptions, thrownError){
		            /* alert(xhr.status+"\n"+thrownError); */
		        	 $(".loadingBox").LoadingOverlay("hide");
		        }

	    	});
		}
		
	
		
		
	})
</script>
