<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>cow baby 管理著後台</title>
<link rel="icon" href="logo.ico">
</head>

<!--css-->
<link rel="stylesheet"
	href="<c:url value="/css/backstageAdmitMainStyle.css"/>">

<!--body-->
<body>
	<section id="container"> <!--引入 header--> <jsp:include
		page="/pages/backstageAdmit/header_backstage.jsp" /> <!--引入 側邊蘭選單-->
	<jsp:include page="/pages/backstageAdmit/side_menu.jsp" /> <!--main-content-->
	<!--主要內容--> <section id="main-content"> <section
		class="wrapper" id="product_management_sort">
	<div class="breadcrumb-row">
		<h3>商品分類設定</h3>
		<ol class="breadcrumb">
			<li><a href="#">商品管理</a></li>
			<li><a href="#">商品分類設定</a></li>
		</ol>
	</div>
	<div class="row">
		<div class="clear-both"></div>
	</div>
	<!--這邊開始寫內容-->
	<div class="row">
		<div class="col-md-12">
			<div class="panel panel-addpadding">
				<form class="form-inline" 
				action="${pageContext.servletContext.contextPath}/ClassficationController" 
				method="POST" >
					<div class="form-group">
						<label for="exampleInputName2">分類名稱:</label> 
						<input type='text' name="classficatoinName" class="form-control" 
						value="" /> <!-- 回填分類名稱 -->
					</div>
					<button type="submit" class="btn btn-primary">查詢</button>
					<button type="button" class="btn btn-primary">新增分類</button>
				</form>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<div class="panel">
				<table class="table table-striped table-bordered table_thead">
					<!-- <table class="table table-hover table-bordered orderlist"> -->
					<thead>
						<tr>
							<th>序號</th>
							<th>分類名稱</th>
							<th>分類描述</th>
							<th>使用狀態</th>
							<th>編輯</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="Classfication" varStatus="st" items="${ClassficationList}">
						<tr>
							<td>${st.count}</td>
							<td>${Classfication.classficatoinName}</td>
							<td>${Classfication.classificationDescription}</td>
							<td>${Classfication.startStopStatus}</td>
							<!-- <td><span class="label label-success">啟用</span></td>
							 -->
							<td><a href="#" class='btn btn-primary'> 
							<i class='fa fa-pencil'></i>
							</a></td>
						</tr>
<!-- 						<tr> -->
<!-- 							<td>2</td> -->
<!-- 							<td>圖書</td> -->
<!-- 							<td>給小朋友看的書唷</td> -->
<!-- 							<td><span class="label label-danger">停用</span></td> -->
<!-- 							<td><a href="#" class='btn btn-primary'> <i -->
<!-- 									class='fa fa-pencil'></i> -->
<!-- 							</a></td> -->
<!-- 						</tr> -->
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-3 record-number">
			<span>第2頁</span> <span>第10 - 20 筆</span> <span>共150筆</span>
		</div>
		<ul class="pagination">
			<li><a href="#" aria-label="Previous"> <span
					aria-hidden="true">&laquo;</span>
			</a></li>
			<li><a href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li><a href="#">4</a></li>
			<li><a href="#">5</a></li>
			<li><a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
			</a></li>
		</ul>
	</div>
	<!--內容結束  --> </section> <!-- wrapper end --> </section> <!-- main-content end --> </section>
	<!-- container end -->
</body>
</html>

<!-- javasript pluging link CDN-->
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-switch/3.3.4/js/bootstrap-switch.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap3-dialog/1.34.7/js/bootstrap-dialog.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.4/js/bootstrap-select.min.js"></script>
<script
	src="<c:url value="/pluging/Bootsrap/bootstrap-datetimepicker.min.js"/>"></script>


<script>
$(function(){
	
	// side_menu 帳戶總覽填充背景色	
	$(".productManagement").css({'background':'#3a4152'});
	$(".productManagement").find('.sub').css({'display':'block'});
	$(".productManagement").find('.sub a').eq(1).css({'color':'yellow'});	
	
	//增加商品彈跳框
	$(".add_sort").click(function(){
		event.preventDefault();
	console.log("AAA");
		BootstrapDialog.show({
			 message: $('<div></div>').load('../common/add_prouduct_popup.jsp'),
            title:"新增商品分類",
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
	
<<<<<<< HEAD
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
	   //擋掉超連結的預設值
       event.preventDefault(); 
       
       //分頁的插件，一定要加
       $('#myPagination').twbsPagination('destroy');
       
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
	        url: "http://localhost:8080/CowBaby/getClassficationData",    
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
	           
	           //讀取物件中的資料
	           $.each(obj, function (index, customer) {
	        	   console.log("customer",customer);
	           	    var html="";
	 		    	html="<tr>"+
							"<td>"+(index+1+ (response.pageSize*(response.pageNumber-1)))+"</td>" +
							"<td>"+customer.classficatoinName+"</td>" +
							"<td>"+customer.classificationDescription+"</td>" +
							"<td>"+customer.startStopStatus+"</td>" +
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
=======
	/*********************************************/
	
	
   // 查詢
   $(".inquire").click(function(){
       event.preventDefault(); 
       
       console.log("aaa")
       
     /*   $('#myPagination').twbsPagination('destroy');
       
		// 抓取表單欄位
		formData = $(".memberFrom").serializeArray();*/
	    // 發 ajax 查詢表單資料
		inqueryData(formData , pagenow); 
		
   });
	
	// 查詢資料
	function inqueryData(data,pageNum){
	    	
	    	console.log("data",data);
	    	console.log("pageNum",pageNum);	
	      	// 將畫面清空
	      	$('tbody').empty();
	    
	    	$.ajax({
		        type:"GET",                   
		        url: "http://localhost:8080/CowBaby/service/getCustomerData",    
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
	
	
>>>>>>> branch 'master' of https://github.com/EEIT98Team01/RemoteRepository1127.git
})
</script>




