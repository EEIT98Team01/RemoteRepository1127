<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>cow baby 管理者後台</title>
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
			<section class="wrapper" id="blog_list">
				<div class="breadcrumb-row">
					<h3>文章列表</h3>
					<ol class="breadcrumb">
					  	<li><a href="#">媽咪推薦</a></li>
					  	<li><a href="#">文章列表</a></li>
					</ol>
				</div>
				<div class="row">
					<div class="clear-both"></div>
				</div>
				<!--這邊開始寫內容-->
				<div class="row">
					<div class="col-md-12">
						<div class="panel panel-addpadding">
							<form class="form-inline blogFrom" >
								<div class="form-group">
									<label for="exampleInputName2">文章作者:</label>
									<input type='text' name='author' id='author' class="form-control" value="${author}"/>
								</div>
								<div class="form-group">
									<label for="exampleInputName3">文章主題:</label>
									<input type='text' name='article' id='article' class="form-control" value="${article}"/>
								</div>

								<button type="submit" class="btn btn-primary inquire">查詢</button> 
							</form>
						</div>
					</div>	
				</div>
				<div class="row">	
					<div class="col-md-12">
						<div class="panel">	
							<table class="table table-striped table-bordered table_thead" id="blogList"> 
								<thead>
								  <tr>
								    <th>序號</th>
								    <th>文章ID</th>
								    <th>文章作者</th>
									<th>文章主題</th>
									<th>預覽</th>	
									<th>編輯</th>								
								  </tr>
								</thead>
								<tbody>
				<!-- 			   <tr>
								   	 <td>1</td>
								   	 <td>a123</td>
								   	 <td>牛牛媽</td>
								   	 <td>如何教倒乖孩子</td>
								   	 <td> <a href="#"><i class="fa fa-eye btn btn-success" aria-hidden="true"></i></a></td>
								   	 <td> <a href="#"><i class="fa fa-pencil btn btn-primary"></i></a></td>
								   </tr>
				 -->				   
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
	 /* $(".pp").click(function(){
	BootstrapDialog.alert('Hi Apple!');
 	}) */
	
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
	formData = $(".blogFrom").serializeArray();
		
	// 發 ajax 查詢表單資料
	inqueryData(formData , pagenow);

   // 查詢
   $(".inquire").click(function(){
   	console.log("AA");
   	//擋掉超連結的預設值
       event.preventDefault(); 
       
     //分頁的插件，一定要加
       $('#myPagination').twbsPagination('destroy');
       
		// 抓取表單欄位
		formData = $(".blogFrom").serializeArray();
		
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
	        url: "http://localhost:8080/CowBaby/Blog/getBlogData",    
	        data: {
		       	 author:formData[0].value,
		       	 pageSize:visiblecount,
		       	 article:formData[1].value,
	       		 pageNumber:pageNum	 
	        }, 
	         
	        dataType:"json",   
	        
	        // ajax載入前
	        beforeSend: function(){
	        	//顯示laoding 參考網址=>https://gasparesganga.com/labs/jquery-loading-overlay/#quick-demo
	        	$("#blogList").LoadingOverlay("show");
			}, 
			
			// 成功要做的事
	        success : function(response){   
	        	//測試列出接收到的資料
	        	console.log("response",response);
	        		        	
	           // response 回來的字串轉 json物件
	           var obj = JSON.parse(response.list);
	           
	           // 組出 列表塞回 table  
	           //讀取物件中的資料$.each(object,function(name,value){});
	           $.each(obj, function (index, blog) {
	        	   console.log("blog",blog);
	           	    var html="";
	 		    	html="<tr>"+
							"<td>"+(index+1+ (response.pageSize*(response.pageNumber-1)))+"</td>" +
							"<td>"+blog.articleID+"</td>" +
							"<td>"+blog.bloggerName+"</td>" +
							"<td>"+blog.articleHeader+"</td>" +
 							"<td> <a href='' class='btn btn-success'> <i class='fa fa-eye'></i> </a> </td>" +
 							"<td> <a href='<c:url value='blogDelete.controller'/>?id=" + blog.articleID + 
 							"' class='btn btn-primary'> <i class='fa fa-pencil'></i> </a> </td>" +
// 						 								↑blogDelete.controller 識別字串，與Controller對應
 							
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
	        		$("#blogList").LoadingOverlay("hide");
	        	},300)	
			},
			     
			// 發ajax錯誤
	        error:function(xhr, ajaxOptions, thrownError){
	            alert(xhr.status+"\n"+thrownError);
	        }

   	});
   } 	
 	
 	
	// side_menu 帳戶總覽填充背景色	
	$(".blog").css({'background':'#3a4152'});
	$(".blog").find('.sub').css({'display':'block'});
	$(".blog").find('.sub a').eq(0).css({'color':'yellow'});	
})
</script>




