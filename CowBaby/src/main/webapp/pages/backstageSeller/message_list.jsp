<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>cow baby 賣家後台</title>
<link rel="icon" href="logo.ico">
</head>

<!--css-->
<link rel="stylesheet" href="<c:url value="/css/backstageSellerMainStyle.css"/>">

<!--body-->
<body>
	<section id="container" >
		<!--引入 header-->
		<jsp:include page="/pages/backstageSeller/header_backstage.jsp"/>
		
		<!--引入 側邊蘭選單-->
		<jsp:include page="/pages/backstageSeller/side_menu.jsp"/>
		
		<!--main-content-->
		<!--主要內容-->
     	<section id="main-content">
			<section class="wrapper" id="message">
				<div class="breadcrumb-row">
					<h3>訊息管理</h3>
					<ol class="breadcrumb">
					  	<li><a href="#">訊息管理</a></li>
					</ol>
				</div>
				<div class="row">
					<div class="clear-both"></div>
				</div>
				<!--這邊開始寫內容-->
				<div class="row">
					<div class="col-md-12">
						<div class="panel panel-addpadding">
							<form class="form-inline messageFrom">
								<div class="form-group">
									<label for="exampleInputName2">會員帳號:</label>
									<input type='text' name='account' id='account' class="form-control" value="${account}"/>
								</div>
							
								<div class="form-group">
									<label for="exampleInputName2">信件狀態</label>
									<select class="form-control" name="readStatus">
										<option value="">全部</option>
										<option value="0">未讀</option>
										<option value="1">已讀</option>
									</select>
								</div>

								<div class="form-group">
									<label for="exampleInputName2">寄件者</label>
									<select class="form-control" name="userType">
										<option value="全部">全部</option>
										<option value="系統訊息">系統訊息</option>
										<option value="一般會員">一般會員</option>
										<option value="平台賣家">平台賣家</option>
									</select>
								</div>

								<button type="submit" class="btn btn-primary inquire">查詢</button>
							</form>
						</div>
					</div>
				</div>	
			
				<div class="row"> 
					<div class="col-md-12">    
		                <table class="table table-bordered" style="background-color: #fff;" id="messageList">                  
                        	<thead>
							  	<tr>
									<th>刪除</th>
									<th>標記</th>
									<th>寄件人</th>
									<th>敘述</th>
									<th>時間</th>
									<th>狀態</th>
								</tr>
							</thead>
							<tbody>
								<td colspan="10">目前無任何資料</td>
							</tbody>
	                    </table>   
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
				<!--context end-->
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
	$("#nav-accordion").find('li a').eq(6).addClass('active');

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
	formData = $(".messageFrom").serializeArray();
		
	// 發 ajax 查詢表單資料
	inqueryData(formData , pagenow);
  	 
   // 查詢
   $(".inquire").click(function(){
		//擋掉超連結的預設值
		event.preventDefault(); 
       
		//分頁的插件，一定要加
		$('#myPagination').twbsPagination('destroy');
       
		// 抓取表單欄位
		formData = $(".messageFrom").serializeArray();
		
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
	        url: "/CowBaby/message/getMessageList",    
	        data: {
	        	receiverAccount:"${user.email}",
	        	msgSenderID:formData[0].value,
	        	readStatus:formData[1].value,
	        	userType:formData[2].value,
	        	msgMarker:"",
		       	pageSize:visiblecount,
	       		pageNumber:pageNum,
	       		sortCondition:"MsgMarker desc, MsgTime desc"
	        }, 
	         
	        dataType:"json",   
	        
	        // ajax載入前
	        beforeSend: function(){
	        	//顯示laoding 參考網址=>https://gasparesganga.com/labs/jquery-loading-overlay/#quick-demo
	        	$("#messageList").LoadingOverlay("show");
			}, 
			
			// 成功要做的事
	        success : function(response){   
	        	//測試列出接收到的資料
	        	console.log("response",response);
	        		        	
	           // response 回來的字串轉 json物件
	           var obj = JSON.parse(response.list);
	           
	           // 組出 列表塞回 table  
	           // 讀取物件中的資料$.each(object,function(name,value){});
	           $.each(obj, function (index, message) {
	           	    var html="";
	 		    	html="<tr>"+
							"<td>" + "<input type='checkbox' class='mail-checkbox'>" + "</td>" +
							"<td>" + message.msgMarker + "</td>" +
							"<td>" + message.msgSenderID + "</td>" +
							"<td>" +
								"<a href='<c:url value='/pages/backstageSeller/messageView?messageId=" +
								message.msgID + "'/>' class='linklist'>" + message.msgContent + "</a>" +
							"</td>" +
							
							"<td>" + message.msgTime.substr(0,19) + "</td>" +
							"<td>" + message.readStatus + "</td>" +
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
	        		$("#messageList").LoadingOverlay("hide");
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