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

		<!-- 個人訊息--->
		<div class="main_container_col_2 member_information">
			<ul class="breadcrumb">
			    <li><a href="#">首頁</a></li>
			    <li>會員專區</li>
			    <li class="active">我的訂單明細</li>
			</ul>
			<div class="welcome_text">
				<p>HI! 
					<span>雄大</span>~歡迎來到CowBaby~<span class="user_stauts">ㄧ般會員</span> 
					<a class="open_shop">我要開店</a>
				</p>
			</div>
			
							<!--這邊開始寫內容-->
				<div class="row">
					<div class="col-md-12">
						<div class="panel panel-addpadding">
							<form class="form-inline messageFrom">
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
									<select class="form-control" name="userType" id="userType">
										<option value="自己">自己</option>
										<option value="系統訊息">系統訊息</option>
									</select>
								</div>

								<button type="button" class="btn btn-primary inquire">查詢</button>
							</form>
						</div>
					</div>
				</div>	
			
				<div class="row"> 
					<div class="col-md-12">    
		                <table class="table table-bordered" style="background-color: #fff;" id="messageList">                  
                        	<thead>

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

<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/bxslider/4.2.12/jquery.bxslider.js"></script> -->
<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bxslider/4.2.12/jquery.bxslider.css">  -->

<script src="<c:url value="/pluging/Bootsrap/jquery.twbsPagination.js"/>"></script>
<script src="https://cdn.jsdelivr.net/npm/gasparesganga-jquery-loading-overlay@1.5.4/src/loadingoverlay.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/gasparesganga-jquery-loading-overlay@1.5.4/extras/loadingoverlay_progress/loadingoverlay_progress.min.js"></script>
 
<script type="text/javascript">
$(function(){
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
		inqueryData(formData , pagenow)
   });
   
   // 查詢表單資料
   function inqueryData(data,pageNum){
     	// 將畫面清空
     	$('thead').empty();
     	$('tbody').empty();
     	
     	if($('#userType').val() == '自己') {
     		html = "";
     		html = "<tr>" +
					"<th>收件人</th>" +
					"<th>時間</th>" +
					"<th>敘述</th>" +
					"<th>回覆</th>" +
					"<th>刪除</th>" +
			   	"</tr>"
			$('thead').append(html);
			   	
     		$.ajax({
		    	type:"GET",                   
		        url: "/CowBaby/message/getMessageList",    
		        data: {
		        	receiverAccount:"${user.email}",
		        	msgSenderID:"",
		        	readStatus:formData[0].value,
		        	userType:formData[1].value,
		        	msgMarker:"",
			       	pageSize:visiblecount,
		       		pageNumber:pageNum,
		       		sortCondition:"MsgTime desc"
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
								"<td>" + message.msgReceiverID + "</td>" +
								"<td>" + message.msgTime.substr(0,19) + "</td>" +
								"<td>" +
									"<a href='<c:url value='/pages/member/messageView?messageId=" +
									message.msgID + "'/>' class='linklist'>" + message.msgContent + "</a>" +
								"</td>" +
							
								"<td>" + message.msgResponse + "</td>" +
								"<td> <a href='<c:url value='/pages/member/messageDelete?messageId=" +
								message.msgID + "'/>' class='btn btn-primary'> <i class='fa fa-trash-o'></i> </a> </td>" +
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
     	} else {
     		html = "";
     		html = "<tr>" +
					"<th>標記</th>" +
					"<th>寄件人</th>" +
					"<th>敘述</th>" +
					"<th>時間</th>" +
					"<th>狀態</th>" +
					"<th>刪除</th>" +
			   	"</tr>"
			$('thead').append(html);
			   	
		    $.ajax({
		    	type:"GET",                   
		        url: "/CowBaby/message/getMessageList",    
		        data: {
		        	receiverAccount:"${user.email}",
		        	msgSenderID:"",
		        	readStatus:formData[0].value,
		        	userType:formData[1].value,
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
								"<td>" + message.msgMarker + "</td>" +
								"<td>" + message.msgSenderID + "</td>" +
								"<td>" +
									"<a href='<c:url value='/pages/member/messageView?messageId=" +
									message.msgID + "'/>' class='linklist'>" + message.msgContent + "</a>" +
								"</td>" +
								"<td>" + message.msgTime.substr(0,19) + "</td>" +
								"<td>" + message.readStatus + "</td>" +
								"<td> <a href='<c:url value='/pages/member/messageDelete?messageId=" +
								message.msgID + "'/>' class='btn btn-primary'> <i class='fa fa-trash-o'></i> </a> </td>" +
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
   }
})
</script>
