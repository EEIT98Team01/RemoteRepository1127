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
			<section class="wrapper" id="audit_shop">
				<div class="breadcrumb-row">
					<h3>賣家審核</h3>
					<ol class="breadcrumb">
					  	<li>審核管理</li>
					  	<li>賣家審核</li>
					</ol>
				</div>
				<div class="row">
					<div class="clear-both"></div>
				</div>
								<!--這邊開始寫內容-->
				<div class="row">
					<div class="col-md-12">
						<div class="panel panel-addpadding">
							<form class="form-inline audit_shop_form">
								<div class="form-group">
									<label for="exampleInputName2">申請人帳號:</label>
									<input type='text' class="form-control" name="email"/>
								</div>

								<div class="form-group">
									<label for="exampleInputName2">審核狀態:</label>
									<select class="form-control" name="applicationState">
										<option value="">全部</option>
										<option value="1">未審核</option>
										<option value="2">審核中</option>
										<option value="3">審核通過</option>
										<option value="4">審核未通過</option>		
									</select>
								</div>
								<button type="submit" class="btn btn-primary inquire">查詢</button>
							</form>
						</div>
					</div>	
				</div>
				
				<div class="row">	
					<div class="col-md-12">
						<div class="panel">	
							<table class="table table-striped table-bordered table_thead" id="audit_shop_List"> 
								<thead>
								  <tr>
								    <th>序號</th>
									<th>申請人帳號</th>
									<th>申請時間</th>
									<th>審核狀態</th>
									<th>審核處理</th>
									<th>備註</th>
								  </tr>
								</thead>
								<tbody>
								 <td colspan="10">目前無任何資料</td>
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
					<ul class="pagination"></ul>
				</div>
				<!-- 內容結束 -->
			</section>
			<!-- wrapper end -->
      	</section>
      	<!-- main-content end -->
	</section>
	<!-- container end -->
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
	$(".auditComplaints").find('.sub a').eq(2).css({'color':'yellow'});
	
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
	$(".inquire").click(function(){
		event.preventDefault(); 
		console.log("AA")
		 $('.pagination').twbsPagination('destroy');
		
		// 抓取表單欄位
		formData = $(".audit_shop_form").serializeArray();
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
	        url: "http://localhost:8080/CowBaby/SellerAudit/getSellerAuditData",    
	        data: {
	        	 pageSize:visiblecount,
	        	 pageNumber:pageNum, 
	        	 email:formData[0].value,
	        	 processStatus:formData[1].value,	
	        }, 
	         
	        dataType:"json",   
	        
	        // ajax載入前
	       beforeSend: function(){
	        	//顯示laoding 參考網址=>https://gasparesganga.com/labs/jquery-loading-overlay/#quick-demo
	        	$("#audit_shop_List").LoadingOverlay("show");
			}, 
			
			// 成功要做的事
	        success : function(response){ 
	        	
	           console.log("response",response);
	        	
	           // response 回來的字串轉 json物件
	           var obj = JSON.parse(response.list);
	           console.log("obj",obj);
	           
	           setTimeout(function(){
	        		$("#audit_shop_List").LoadingOverlay("hide");
	        	},300)	
	           
	           // 組出 列表塞回 table
	           
	           $.each(obj, function (index, item) {
	        	   console.log("item",item);
	        	   
	        	    // 狀態轉換
	        	    var state="";
	        	    if(item.applicationState==1){
	        	    	state = "<span class='label label-danger'>未審核</span>"
					}else if(item.applicationState==2){
						state = "<span class='label label-info'>審核中</span>"
					}else if(item.applicationState==3){
						state = "<span class='label label-primary'>審核不通過</span>"
					}else if(item.applicationState==4){
						state = "<span class='label label-warning'>審核成功</span>"
					}
	        	    
	        	    // 組HTML塞回TABLE
	           	    var html="";
	           	    
	 		    	html="<tr>"+
 							"<td>"+(index+1+ (response.pageSize*(response.pageNumber-1)))+"</td>" +
 							"<td>"+item.email+"</td>" +
 							"<td>"+item.applicationDate+"</td>"+
 							"<td>"+ state +"</td>"+
 							"<td><a href='#' class='btn btn-primary audit_popupbox_btn'><i class='fa fa-pencil'></i></a></td>"+	
 							"<td>"+ item.applicationDescription +"</td>"+
 							"<td style='display:none;'>"+item.applicationID+"</td>"+
						 "</tr>";
	 
 		    		$('tbody').append(html);
	           })
	            
	          	    
         		// 自動產生分頁
	            var totalPages = response.tatalPage;
	            var pageSize  = response.pageSize;
 
 				if(!totalPages==0){
 				// 如果查詢有資料
				   $('.pagination').twbsPagination({
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

			// 發ajax錯誤
	        error:function(xhr, ajaxOptions, thrownError){
	            alert(xhr.status+"\n"+thrownError);
	        }

    	});

	}
 	
 	// 申訴審核彈出框
 	$('body').on('click','.audit_popupbox_btn',function () {
 		
 		var emailId = $(this).parents('tr').find('td').eq(1).text();
 		var id = $(this).parents('tr').find('td').eq(6).text();

 		console.log(emailId)
 		console.log(id)
 		
 		
 		
 		BootstrapDialog.show({
 			 message: $('<div></div>').load('../common/audit_sellers.jsp'),
             title:"申請審核",
             buttons: [{
 		                label: '確定',
 		                // no title as it is optional
 		                cssClass: 'btn-primary',
 		                action: function(dialogItself){
 		                	// 抓取裡面表單資料
 		                	formData = $(".seller_audit_popupForm").serializeArray();
 		                	changeAuditStatus(formData,emailId,id);
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
 	function changeAuditStatus(formData,emailId,id){
 		console.log("**formData**",formData);
 		

 		$.ajax({
	        type:"GET",                   
	        url: "http://localhost:8080/CowBaby/SellerAudit/updateSellerAuditStatus",    
	        data: {
	        	 applicationID:id, 
	        	 email:emailId,
	        	 processStatus:formData[0].value,	
	        	 applicationDescription:formData[1].value,
	        	 
	        }, 
	         
	        dataType:"json",   
	        
			// 成功要做的事
	        success : function(response){ 
	        	var myformData = $(".audit_shop_form").serializeArray();
	         	inqueryData(myformData,1) ;
	        }
 		})
	            
 	} 
 	
 	
 	
 	// 申訴內容細節和回覆彈出框
 	/* $(".audit_detail_btn").click(function(){
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
 	}) */
	
})
</script>




