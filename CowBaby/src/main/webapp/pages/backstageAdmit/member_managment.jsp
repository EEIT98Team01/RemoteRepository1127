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
			<section class="wrapper" id="member_managment">
				<div class="breadcrumb-row">
					<h3>會員管理</h3>
					<ol class="breadcrumb">
					  	<li><a href="#">會員查詢</a></li>
					</ol>
				</div>
				<div class="row">
					<div class="clear-both"></div>
				</div>
				<!--這邊開始寫內容-->
				<div class="row">
					<div class="col-md-12">
						<div class="panel panel-addpadding">
							<form class="form-inline memberFrom" >
								<div class="form-group">
									<label for="exampleInputName2">會員帳號:</label>
									<input type='text' name='account' id='account' class="form-control" />
								</div>
								<div class="form-group">
									<label for="exampleInputName2">會員身份:</label>
									<select class="form-control" name="userType">
										<option value="">全部</option>
										<option value="1">一般會員</option>
										<option value="2">平台賣家</option>
										<option value="3">黑名單</option>	
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
							<table class="table table-striped table-bordered table_thead" id="customerList"> 
								<thead>
								  <tr>
								    <th>
</th>
								    <th>帳號</th>
									<th>姓名</th>
								<%-- 	<th><a href="<c:url value="CustomerManagementList.controller?page=1&orderBy=email&account=${account}&userType=${userType}" />">帳號</a></th>
									<th><a href="<c:url value="CustomerManagementList.controller?page=1&orderBy=customerName&account=${account}&userType=${userType}" />">姓名</a></th> --%>
									<th>手機</th>
									<th>性別</th>
									<th>身份</th>
									<th>所屬會員群集</th>
									<th>累積消費金額</th>
									<th>檢視</th>
									<th>編輯</th>								
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
<script src="<c:url value="/pluging/Bootsrap/jquery.twbsPagination.js"/>"></script>
<script src="https://cdn.jsdelivr.net/npm/gasparesganga-jquery-loading-overlay@1.5.4/src/loadingoverlay.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/gasparesganga-jquery-loading-overlay@1.5.4/extras/loadingoverlay_progress/loadingoverlay_progress.min.js"></script>

<script>
$(function(){
	 // side_menu 帳戶總覽填充背景色
	 $(".memberManagment a").addClass('active');
	
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
	formData = $(".memberFrom").serializeArray();
		
	// 發 ajax 查詢表單資料
	inqueryData(formData , pagenow);

    // 查詢
    $(".inquire").click(function(){
    	// 擋掉超連結的預設值
        event.preventDefault(); 
        
        // 分頁的插件，一定要加
        $('#myPagination').twbsPagination('destroy');
        
		// 抓取表單欄位
		formData = $(".memberFrom").serializeArray();
		
	    // 發 ajax 查詢表單資料
		inqueryData(formData , pagenow);
    });
    
    // 查詢表單資料
    function inqueryData(data,pageNum){
    	
    	
    
      	// 將畫面清空
      	$('tbody').empty();
    
    	$.ajax({
	        type:"GET",                   
	        url: "/CowBaby/service/getCustomerData",    
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
	        	$("#customerList").LoadingOverlay("show");
			}, 
			
			// 成功要做的事
	        success : function(response){   

	           // response 回來的字串轉 json物件
	           var obj = JSON.parse(response.list);
	           
	           // 組出 列表塞回 table  
	           //讀取物件中的資料$.each(object,function(name,value){});
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
	        		$("#customerList").LoadingOverlay("hide");
	        	},300)	
			},
			     
			// 發ajax錯誤
	        error:function(xhr, ajaxOptions, thrownError){
	            alert(xhr.status+"\n"+thrownError);
	        }

    	});
    }
})
</script>