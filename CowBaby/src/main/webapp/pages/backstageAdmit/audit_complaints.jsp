<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CowBaby管理者後台</title>
<link rel="icon" href="logo.ico">
</head>

<!--css-->
<link rel="stylesheet" href="<c:url value="/css/backstageAdmitMainStyle.css"/>">

<!--body-->
<body>
	<section id="container" >
		<!--引入 header-->
		<jsp:include page="/pages/backstageAdmit/header_backstage.jsp"/>
		
		<!--引入 側邊蘭選單-->
		<jsp:include page="/pages/backstageAdmit/side_menu.jsp"/>
		
		<!--main-content-->
		<!--主要內容-->
     	<section id="main-content">
			<section class="wrapper" id="audit_complaints">
				<div class="breadcrumb-row">
					<h3>客服申訴</h3>
					<ol class="breadcrumb">
						<li>審核管理</li>
					  	<li>客服申訴</li>
					</ol>
				</div>
				<div class="row">
					<div class="clear-both"></div>
				</div>
				<!--這邊開始寫內容-->
				<div class="row">
					<div class="col-md-12">
						<div class="panel panel-addpadding">
							<form class="form-inline">
								<div class="form-group">
									<label for="exampleInputName2">申訴人帳號:</label>
									<input type='text' class="form-control"/>
								</div>

								<div class="form-group">
									<label for="exampleInputName2">審核狀態:</label>
									<select class="form-control">
										<option>全部</option>
										<option>未處理</option>
										<option>處理中</option>
										<option>已處理</option>	
									</select>
								</div>
								<div class="form-group">
									<label for="exampleInputName2">案件類型:</label>
									<select class="form-control">
										<option>全部</option>
										<option>檢舉黑名單</option>
										<option>帳號問題</option>
										<option>BUG回報</option>
										<option>其他</option>
									</select>
								</div>
								<button class="btn btn-primary inquire">查詢</button>
							</form>
						</div>
					</div>	
				</div>
				
				<div class="row">	
					<div class="col-md-12">
						<div class="panel">	
							<table class="table table-striped table-bordered table_thead" id="audit_complaints_List"> 
							<!-- <table class="table table-hover table-bordered orderlist"> -->
								<thead>
								  <tr>
								    <th>序號</th>
									<th>申訴人帳號</th>
									<th>申訴日期</th>
									<th>案件類型</th>								
									<th>審核狀態</th>
									<th>申訴內容</th>
									<th>申訴處理</th>
								  </tr>
								</thead>
								<tbody>
								  	<tr>
								  		<td>1</td>
										<td>華安</td>
										<td>2017-10-10 10:05:05</td>
										<td>檢舉黑名單</td>
										<td><span class="label label-danger">未處理</span></td>
										<td><a href="#" class='btn btn-info audit_detail_btn'> <i class="fa fa-commenting" aria-hidden="true"></i> </a></td>
										<td><a href="#" class='btn btn-primary audit_popupbox_btn'> <i class='fa fa-pencil'></i> </a></td>									
										
								  	</tr>
								  	<tr>
								  		<td>2</td>
										<td>武狀元</td>
										<td>2017-10-10 10:05:05</td>
										<td>帳號問題</td>
										<td><span class="label label-info">處理中</span></td>
										<td><a href="#" class='btn btn-info audit_detail_btn'> <i class="fa fa-commenting" aria-hidden="true"></i> </a></td>
										<td><a href="#" class='btn btn-primary audit_popupbox_btn'> <i class='fa fa-pencil'></i> </a></td>
										
								  	</tr>	
								  	<tr>
								  		<td>3</td>
										<td>對穿腸</td>
										<td>2017-10-10 10:05:05</td>
										<td>其他</td>	
										<td><span class="label label-default">已處理</span></td>
										<td><a href="#" class='btn btn-info audit_detail_btn'> <i class="fa fa-commenting" aria-hidden="true"></i> </a></td>
										<td><a href="#" class='btn btn-success'> <i class='fa fa-eye'></i> </a></td>
								  	</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<!-- 顯示筆數 -->
				<div class="row">
					<div class="col-md-3 record-number">
						<span>第 <span class="pageNum">0</span>頁</span>|
						<span>第 <span class="firstNum">0</span> - <span class="endNum">0</span>筆</span>|
						<span>共 <span class="totalNum">0</span>筆</span>
					</div>
					<!--分頁 -->
					<ul class="pagination"  id="audit_complaints_Pagination"></ul>
				</div>
				<!-- 內容結束 -->
			</section>
			<!-- wrapper end -->
      	</section>
      	<!-- main-content end -->
	</section>
	<!-- container end -->
	
	<!-- 顯示申訴內容彈跳框 -->
	<div class="modal hide">
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
<script src="<c:url value="/pluging/Bootsrap/bootstrap-datetimepicker.min.js"/>"></script>
<script src="<c:url value="/pluging/Bootsrap/jquery.twbsPagination.js"/>"></script>
<script src="https://cdn.jsdelivr.net/npm/gasparesganga-jquery-loading-overlay@1.5.4/src/loadingoverlay.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/gasparesganga-jquery-loading-overlay@1.5.4/extras/loadingoverlay_progress/loadingoverlay_progress.min.js"></script>

<script>
$(function(){
	// side_menu 帳戶總覽填充背景色
		$(".auditComplaints").css({'background':'#3a4152'});
		$(".auditComplaints").find('.sub').css({'display':'block'});
		$(".auditComplaints").find('.sub a').eq(0).css({'color':'yellow'});
	
	// 設置 loaading icon大小
		$.LoadingOverlaySetup({ size : "10%"});
	
	// 抓取表單欄位
	 	var formData ="";
	// 預設當前頁
  	 	var pagenow = 1; 
	// 預設總頁數
		var totalPage = 1; 
	// 預設每頁顯示筆數
		var visiblecount = 10; 

	// 查詢
		$("#inquire").click(function(){
			event.preventDefault(); 
			$('#audit_complaints_Pagination').twbsPagination('destroy'); 
			
			// 抓取表單欄位
			formData = $(".memberFrom").serializeArray();
			
		    // 發 ajax 查詢表單資料
			inqueryData(formData , pagenow);
		});
	 
	 // 查詢表單資料
		 function inqueryData(data,pageNum){
		 	
		 	console.log("data",data);
		 	console.log("pageNum",pageNum);	
		   	// 將畫面清空
		   	$('tbody').empty();
		 
		 	$.ajax({
		       type:"GET",                   
		       url: "http://localhost:8080/json/text1",    
		       data: {
		       	 customerAccount:formData[0].value,
		       	 pageSize:visiblecount,
		       	 customerStatue:formData[1].value,
		      		 pageNumber:pageNum	 
		       }, 
		        
		       dataType:"json",   
		       
		       	// ajax載入前
		       	beforeSend: function(){
			       	//顯示laoding 參考網址=>https://gasparesganga.com/labs/jquery-loading-overlay/#quick-demo
			       	$("#audit_complaints_List").LoadingOverlay("show");
				}, 
			
			// 成功要做的事
		       success : function(response){   
		    	   
		    	   console.log("response",response)
		          // response 回來的字串轉 json物件
		          /*   var obj = JSON.parse(response.list); */
		          
		          // 組出 列表塞回 table
		          $.each(obj, function (index, customer) {
		       	  		console.log("customer",customer);
		          	    var html="";
				    	html="<tr>"+
							"<td>"+(index+1+ (response.pageSize*(response.pageNumber-1)))+"</td>" +
							"<td>"+customer.email+"</td>" +
							"<td>"+customer.customerName+"</td>" +
							"<td>"+customer.mobilePhone+"</td>" +
							"<td>"+customer.gender+"</td>" +
							"<td>"+customer.userID+"</td>" +
							"<td>"+customer.consumerSegmentation+"</td>" +
							"<td>"+customer.totalAmoutOfConsumption+"</td>" +
							"<td> <a href='<c:url value='CustomerManagementView.controller'/>?id=" + customer.customerID + 
							"' class='btn btn-success'> <i class='fa fa-eye'></i> </a> </td>" +
							"<td> <a href='<c:url value='CustomerManagementEdit.controller'/>?id=" + customer.customerID + 
							"' class='btn btn-primary'> <i class='fa fa-pencil'></i> </a> </td>" +
						 "</tr>";				
		    			$('tbody').append(html);
		          }) 
		            
		      		// 自動產生分頁
		        	var totalPages = response.tatalPage;
		            var pageSize  = response.pageSize;
		
		            // 如果查詢有資料
					if(!totalPages==0){
					   $('#audit_complaints_Pagination').twbsPagination({
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
				
					// loading hide
					setTimeout(function(){
			       		$("#audit_complaints_List").LoadingOverlay("hide");
			       	},300)	
		       },
		
			   // 發ajax錯誤
		       error:function(xhr, ajaxOptions, thrownError){
		           alert(xhr.status+"\n"+thrownError);
		       }
		
		 	});
		}
	 
	 // 申訴審核彈出框
	 	$(".audit_popupbox_btn").click(function(){	
	 		BootstrapDialog.show({
	 			 message: $('<div></div>').load('../common/audit_complaints_popup.jsp'),
	             title:"申請審核",
	             buttons: [{
	 		                label: '確定',
	 		                // no title as it is optional
	 		                cssClass: 'btn-primary',
	 		                data: {
	 		                    js: 'btn-confirm',
	 		                    'user-id': '3'
	 		                },
	 		                action: function(){
	 		                    alert('Hi Orange!');
	 		                }
	 		            },{
	 		                label: '取消',
	 		                action: function(dialogItself){
	 		                    dialogItself.close();
	 		               }
	 		            }]
	 	     });
	 	})
	 	
	 	// 申訴內容細節和回覆彈出框
	 	$(".audit_detail_btn").click(function(){
	 		console.log("AA")
	 		BootstrapDialog.show({
	 			 message: $('<div></div>').load('../common/audit_context.jsp'),
	             title:"申訴內容",
	             buttons: [{
	 		                label: '確定',
	 		                // no title as it is optional
	 		                cssClass: 'btn-primary',
	 		                data: {
	 		                    js: 'btn-confirm',
	 		                    'user-id': '3'
	 		                },
	 		                action: function(){
	 		                    alert('Hi Orange!');
	 		                }
	 		            },{
	 		                label: '取消',
	 		                action: function(dialogItself){
	 		                    dialogItself.close();
	 		               }
	 		            }]
	 	     });
	 	})

		
	        

})
</script>




