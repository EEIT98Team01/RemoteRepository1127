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
			<!--這邊開始寫內容-->
				<div class="container details-inbox">
					<div class="row">
						<div class="col-md-12">
							<i class="fa fa-user-circle-o" aria-hidden="true"></i>
  
  							<!-- 收系統訊息 -->
                       		<c:if test="${messageData.msgSenderID == 'Din@gmail.com'}">
								<strong>FROM:</strong>
                          		<strong>${senderName}</strong>
                          		<span>[${messageData.msgSenderID}]</span>
			           		</c:if>
			           		
			           		<!-- 看自己發的訊息 -->
			            	<c:if test="${messageData.msgSenderID == user.email}">
                          		<strong>SEND:</strong>
                          		<strong>${receiverName}</strong>
                          		<span>[${messageData.msgReceiverID}]</span>
			            	</c:if>
                          	
                          	<span>-</span>
                          	<span><i class="fa fa-clock-o" aria-hidden="true"></i>${messageTime}</span> 	
                  		</div>
					</div>
					<div class="row text">
						<div class="col-md-12">
							<label for="comment">訊息內容:</label>
							<p>
								${messageData.msgContent}
							</p>
                  		</div>
					</div>
					<div class="row">
						<hr/>
					</div>
					<div class="row">
						<!-- 系統訊息,只能返回 -->
			            <c:if test="${messageData.msgSenderID == 'Din@gmail.com'}">
							<input type="button" id="beforePage" class="btn btn-primary pull-left" value="返回" />
			            </c:if>
			            
			            <!-- 自己發的訊息,只能看到對方回覆的內容,無法修改 -->
			            <c:if test="${messageData.msgSenderID == user.email}">
							<form class="form-inline msgFrom">
								<div class="form-group col-md-12">
						  			<label for="comment">對方回覆：</label>
						  			<p>
										${messageData.msgResponse}
									</p>
						  			<br/>
									<input type="button" id="beforePage" class="btn btn-primary pull-left" value="返回" />
								</div>
			            	</form>
			            </c:if>
					</div>
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
	$("#beforePage").on('click', function () {
		window.location.assign('<c:url value="/pages/member/member_account_msg.jsp" />');
	})
})
</script>
