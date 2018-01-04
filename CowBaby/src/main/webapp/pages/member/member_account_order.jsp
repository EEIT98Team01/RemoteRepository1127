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
<link rel="stylesheet" href="<c:url value="/css/frontDesk/member_account_order.css"/>">


<!--body-->
<body>
	<!--引入 topbar 跟  header-->
	<jsp:include page="/pages/common/topbar_and_header.jsp"/>
	
	<!-- 這邊 開始寫內容-->
	<!--每頁 page_container-->
	<section class="page_container member_information_container">
		<div class="side_bar">
			<div class="title">會員專區</div>
			<div class="member_infor_menu">
				<ul>
					<li> <a href="<c:url value="/pages/member/member_account_infor.jsp"/>"><i class="fa fa-user" aria-hidden="true"></i>會員資料</a></li>
					<li> <a href="<c:url value="/pages/member/member_account_update_infor.jsp"/>"><i class="fa fa-pencil" aria-hidden="true"></i>修改會員資料</a></li>
					<li> <a href="<c:url value="/pages/member/member_account_order.jsp"/>"><i class="fa fa-shopping-basket" aria-hidden="true"></i>我的消費明細</a></li>
					<li> <a href="<c:url value="/pages/member/member_account_msg.jsp"/>"><i class="fa fa-envelope" aria-hidden="true"></i>訊息</a></li>
				</ul>	
			</div>	
		</div>

		<!-- 個人商店頁面-->
		<div class="main_container_col_2 member_information">
			<ul class="breadcrumb">
			    <li><a href="#">首頁</a></li>
			    <li>會員專區</li>
			    <li class="active">我的訂單明細</li>
			</ul>
			<div class="welcome_text">
				<p>HI! 
					<span style="color: #f1648f;font-size: 15px;">${user.customerName}</span>~歡迎來到CowBaby~
					<span class="user_stauts">
						<c:if test="${user.userID==1}">
						   <c:out value="一般會員"/>
						</c:if>
						<c:if test="${user.userID==2}">
						   <c:out value="平台賣家"/>
						</c:if>	
						<c:if test="${user.userID==3}">
						   <c:out value="黑名單"/>
						</c:if>				
					</span> 
					<c:if test="${user.userID==1}">
					<a class="open_shop" href="<c:url value="/pages/member/member_apply_shop.jsp"/>">我要開店</a>
					</c:if>
				</p>
			</div>
			<div class="order_detail">
				<table id="orderList">
				    <thead>
				      	<tr>
				      		<th>項次</th>
					        <th>訂單編號</th>
					        <th>訂購日期</th>
					        <th>付款方式</th>
					        <th>總金額</th>
					        <th>商品數量</th>
					        <th>處理狀態</th>
					        <th>檢視細項</th>
				      	</tr>
				    </thead>
				    <tbody>

				    </tbody>
				</table>
			</div>
			<div class="row">
				<div class="col-md-3 record-number">
					<span>第 <span class="pageNum">0</span>頁</span>|
					<span>第 <span class="firstNum">0</span> - <span class="endNum">0</span>筆</span>|
					<span>共 <span class="totalNum">0</span>筆</span>
				</div>
					<!--分頁 -->
				<ul class="pagination"  id="myPagination"></ul>
			</div>
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
		 // 設置 loaading圖案
		 $.LoadingOverlaySetup({ 
			    size            : "10%"
		 });
		
	   	 // 預設當前頁
	   	 var pagenow = 1; 
	   	 // 預設總頁數
	   	 var totalPage = 1; 
	   	 // 預設每頁顯示筆數
	   	 var visiblecount = 10; 
	   	 
	   	 inqueryData(1);
	   	 
	   	 function inqueryData(pageNum){
			$.ajax({
		        type:"GET",                   
		        url: "/CowBaby/order/getCustomerOrder",    
		        data: {
			       	 customerAccount:"${user.email}",
			       	 pageSize:visiblecount,
		       		 pageNumber:pageNum
		        }, 
		         
		        dataType:"json",   
		        
		        // ajax載入前
		        beforeSend: function(){
		        	//顯示laoding 參考網址=>https://gasparesganga.com/labs/jquery-loading-overlay/#quick-demo
		        	$("#orderList").LoadingOverlay("show");
				}, 
				
				// 成功要做的事
		        success : function(response){   
	
		           // response 回來的字串轉 json物件
		           var obj = JSON.parse(response.list);
		           
		           // 組出 列表塞回 table  
		           //讀取物件中的資料$.each(object,function(name,value){});
		           $.each(obj, function (index, order) {
		           	    var html="";
		           	    
// 				        <td>S123456</td>
// 				        <td>2017-10-10 20:08:08</td>
// 				        <td>超商取貨</td>
// 				        <td>1000</td>
// 				        <td>7項</td>
// 				        <td>訂單未完成</td>
// 				        <td> <a href='#' class='btn btn-success'> <i class='fa fa-eye'></i> </a> </td>
		           	    
		 		    	html="<tr>"+
	 							"<td>"+(index+1+ (response.pageSize*(response.pageNumber-1)))+"</td>" +
	 							"<td>"+order.orderID+"</td>" +
	 							"<td>"+order.orderDate.substr(0,19)+"</td>";
	 							
	 							if(order.paymentMethod == 1) {
	 								html = html + "<td>超商取貨</td>";
	 							} else if(order.paymentMethod == 2) {
	 								html = html + "<td>毆付寶</td>";
	 							}
	 					
	 					html=html+		
	 							"<td>"+order.totalAmount+"</td>" +
	 							"<td>"+order.totalItems+"項</td>";
	 							
	 							if(order.status == 1) {
	 								html = html + "<td>未處理</td>";
	 							} else if(order.status == 2) {
	 								html = html + "<td>撿貨中</td>";
	 							} else if(order.status == 3) {
	 								html = html + "<td>送貨中</td>";
	 							} else if(order.status == 4) {
	 								html = html + "<td>已完成</td>";
	 							}
	 							
	 					html=html+
	 							"<td> <a href='<c:url value='/pages/member/orderDetail'/>?orderID=" + order.orderID + 
	 							"' class='btn btn-success'> <i class='fa fa-eye'></i> </a> </td>" +
							 "</tr>";
							 
						html=html+"<td style='display:none'></td>";
	 		    		$('tbody').append(html);
		           }) 
		           
		          	    
	         		// 自動產生分頁
		         	var totalPages = response.tatalPage;
		            var pageSize  = response.pageSize;
	 
	 				if(!totalPages==0){
	 				// 如果查詢有資料
					   $('#myPagination').twbsPagination({
			                  totalPages: totalPages,
			                  visiblePages: pageSize,
			                  initiateStartPageClick: false,
			                  onPageClick: function (evt, page) { 
								inqueryData(formData,page);
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
	
		        // ajax完成~隱藏loading
		        complete: function(){
		        	setTimeout(function(){
		        		$("#orderList").LoadingOverlay("hide");
		        	},300)
				},
				     
				// 發ajax錯誤
		        error:function(xhr, ajaxOptions, thrownError){
		            //alert(xhr.status+"\n"+thrownError);
		        }
	    	});
	   	 }

	})
</script>
