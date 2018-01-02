<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>cow baby 賣家後台</title>
<link rel="icon" href="logo.ico">
</head>


<!--css-->
<link rel="stylesheet"
	href="<c:url value="/css/backstageSellerMainStyle.css"/>">


<!--body-->
<body>
	<section id="container"> <!--引入 header--> <jsp:include
		page="/pages/backstageSeller/header_backstage.jsp" /> <!--引入 側邊蘭選單-->
	<jsp:include page="/pages/backstageSeller/side_menu.jsp" /> <!--main-content-->
	<!--主要內容--> <section id="main-content"> <section
		class="wrapper" id="order_list">
	<div class="breadcrumb-row">
		<h3>訂單查詢</h3>
		<ol class="breadcrumb">
			<li><a href="#">訂單查詢</a></li>
		</ol>
	</div>
	<div class="row">
		<div class="clear-both"></div>
	</div><!--  -->
	<!--這邊開始寫內容-->
	<div class="row">
		<div class="col-md-12">
			<div class="panel panel-addpadding">
				<!-- 問熊大-->
				<form class="form-inline orderFrom">										
					<div class="form-group">
						<label for="exampleInputName2">訂單編號:</label> 
						<input type='text' name='orderID' id='orderID' class="form-control"/>
					</div>

					<div class="form-group">
						<label for="exampleInputName2">訂單狀態:</label> 
						<select class="form-control" name="status">
							<option value=''>全部</option>
							<option value='1'>未處理</option>
							<option value='2'>撿貨中</option>
							<option value='3'>送貨中</option>
							<option value='4'>已完成</option>
						</select>
					</div>
					<div class="form-group">
						<label>下訂期間:</label>

						<div class='input-group date'>
							<input type='text' class="form-control" id=startTime name='startTime' />
							<span class="input-group-addon"> <span
								class="glyphicon glyphicon-calendar"></span>
							</span>
						</div>
						<span>到</span>

						<div class='input-group date'>
							<input type='text' class="form-control" id='endTime' name='endTime' />
							<span class="input-group-addon"> <span
								class="glyphicon glyphicon-calendar"></span>
							</span>
						</div>

					</div>
					<button type="submit" class="btn btn-primary inquire">查詢</button>
				</form>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-md-12">
			<div class="panel">
				<table class="table table-striped table-bordered" id="orderList">
					<!-- <table class="table table-hover table-bordered orderlist"> -->
					<thead>
						<tr>
							<th>序號</th>
							<th>訂單編號</th>
							<th>訂購時間</th>
							<th>數量</th>
							<th>訂購人</th>
							<th>總金額</th>
							<th>訂單狀態</th>
							<th>訂單明細</th>
							<th>訂單處理</th>
						</tr>
					</thead>
					<tbody>
						<td colspan="10">目前無任何資料</td>
					</tbody>
				</table>
			</div>
		</div>
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
				<!-- 內容結束 -->
			</section>
			<!-- wrapper end -->
      	</section>
      	<!-- main-content end -->
	</section>
	<!-- container end -->
	
	<div class="modal fade">
		  <div class="modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header">
			       	 	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
			        	<h4 class="modal-title">Modal title</h4>
			      </div>
			      <div class="modal-body">
			        	<p>One fine body…</p>
			      </div>
			      <div class="modal-footer">
			        	<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			        	<button type="button" class="btn btn-primary">Save changes</button>
			      </div>
			    </div><!-- /.modal-content -->
		  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
</body>
</html>

<!-- javasript pluging link CDN-->
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-switch/3.3.4/js/bootstrap-switch.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap3-dialog/1.34.7/js/bootstrap-dialog.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.4/js/bootstrap-select.min.js"></script>
<!--  <script src="<c:url value="/pluging/Bootsrap/bootstrap-datetimepicker.min.js"/>"></script>-->
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="<c:url value="/pluging/Bootsrap/jquery.twbsPagination.js"/>"></script>
<script src="https://cdn.jsdelivr.net/npm/gasparesganga-jquery-loading-overlay@1.5.4/src/loadingoverlay.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/gasparesganga-jquery-loading-overlay@1.5.4/extras/loadingoverlay_progress/loadingoverlay_progress.min.js"></script>

<script>
	$(function() {
		
		
		// side_menu 商店設置填充背景色
		$("#nav-accordion").find('li a').eq(2).addClass('active');
		$("#startTime").datepicker();
		$("#endTime").datepicker();
		 // 設置 loaading圖案
		 $.LoadingOverlaySetup({ 
			/* image : "/CowBaby/src/main/webapp/images/loading_icon.gif", */
			/*  maxSize         : "80px",
			    minSize         : "20px",
			    resizeInterval  : 0, */
			    size            : "10%"
			   
		 });
		 
	 	 // 抓取表單欄位
		 var formData ="";
	   	 // 預設當前頁
	   	 var pagenow = 1; 
	   	 // 預設總頁數
	   	 var totalPage = 1; 
	   	 // 預設每頁顯示筆數
	   	 var visiblecount = 10; 

		// 抓取表單欄位
		formData = $(".orderFrom").serializeArray();
		console.log("aaaa");
		
		// 發 ajax 查詢表單資料
		inqueryData(formData , pagenow);

		
	    // 查詢
	    $(".inquire").click(function(){
	    	// 擋掉超連結的預設值
	        event.preventDefault(); 
	        
	        // 分頁的插件，一定要加
	        $('#myPagination').twbsPagination('destroy');
	        
			// 抓取表單欄位
			formData = $(".orderFrom").serializeArray();
			
		    // 發 ajax 查詢表單資料
			inqueryData(formData , pagenow);
	    });
	    
	    // 查詢表單資料
	    function inqueryData(data,pageNum){
	      	// 將畫面清空
	      	$('tbody').empty();
	    
	    	$.ajax({
		        type:"GET",                   
		        url: "http://localhost:8080/CowBaby/order/getOrderData",    
		        data: {
			       	 orderID:formData[0].value,
			       	 pageSize:visiblecount,
			       	 status:formData[1].value,
			       	 startTime:formData[2].value,         
			       	 endTime:formData[3].value,
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
		        	   console.log("order",order);
		           	    var html="";
		 		    	html="<tr>"+
	 							"<td>"+(index+1+ (response.pageSize*(response.pageNumber-1)))+"</td>" +
	 							"<td>"+order.orderID+"</td>" +
	 							"<td>"+order.orderDate+"</td>" +
	 							"<td>"+order.totalItems+"</td>" +
	 							"<td>"+order.email+"</td>" +
	 							"<td>"+order.totalAmount+"</td>";
	 							
	 							if(order.status == 1) {
	 								html = html + "<td>未處理</td>";
	 							} else if(order.status == 2) {
	 								html = html + "<td>檢貨中</td>";
	 							} else if(order.status == 3) {
	 								html = html + "<td>送貨中</td>";
	 							} else if(order.status == 4) {
	 								html = html + "<td>已完成</td>";
	 							}
	 							
	 					html=html+		
	 							"<td> <a href='<c:url value='orderView.controller'/>?id=" + order.orderID   + 
	 							"' class='btn btn-success'> <i class='fa fa-eye'></i> </a> </td>" +
	 							"<td> <a href='#' class='btn btn-primary audit_popupbox_btn'>" +
	 							"<span style='display: none;'>" + order.orderID + "</span>" +
	 							"<i class='fa fa-pencil'></i> </a> </td>" +
							 "</tr>";
	 		    		$('tbody').append(html);
		           }) 
		           
// 		           				<td>
// 		           					<a href="#" class='btn btn-primary audit_popupbox_btn' >
// 									<span style="display: none;">${CustomerReview.reportID}</span>
// 									<i class='fa fa-pencil'></i> 
// 									</a>
// 								</td>
		          	    
	         		// 自動產生分頁
		         	var totalPages = response.tatalPage;
		            var pageSize  = response.pageSize;
	 
	 				if(!totalPages==0){
	 				// 如果查詢有資料
					   $('#myPagination').twbsPagination({
			                  totalPages: totalPages,
			                  visiblePages: pageSize,
			                  
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
		            alert(xhr.status+"\n"+thrownError);
		        }
				
				
				

	    	});
	    }
	    
	    //~~~~~~~~~
		 // 申訴內容細節和回覆彈出框
		 $('body').on("click", '.audit_popupbox_btn', function () {
				console.log("AA")
				var aaa = $(this).find('span').text();
				                                    
				BootstrapDialog.show({               
					message : $('<div></div>').load('/CowBaby/pages/common/order_complaints_popup.jsp?aaa='+aaa),
					title : "訂單狀態編輯",
					buttons : [ {
						label : '確定',
						// no title as it is optional
						cssClass : 'btn-primary',
						data : {
							js : 'btn-confirm',
							'user-id' : '3'
						},
						action : function() {
							console.log("AAA");
		                	$("#qqq").submit();
						}
					}, {
						label : '取消',
						action : function(dialogItself) {
							dialogItself.close();
						}
					} ]
				});
		})

		
		
	})
	
</script>


