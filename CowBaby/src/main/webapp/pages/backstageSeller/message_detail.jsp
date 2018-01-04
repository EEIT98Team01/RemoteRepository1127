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
			<section class="wrapper" id="message-details">
		
				<!--這邊開始寫內容-->
				<div class="container details-inbox">
					<div class="row">
						<div class="col-md-12">
							<i class="fa fa-user-circle-o" aria-hidden="true"></i>
                  		  	<strong>FROM:</strong>
                          	<strong>${customerName}</strong>
                          	<span>[${messageData.msgSenderID}]</span>
                          	<span>-</span>
                          	<span><i class="fa fa-clock-o" aria-hidden="true"></i>${messageTime}</span> 	
                  		</div>
					</div>
					<div class="row text">
						<div class="col-md-12">
							<p>
								訊息內容：
							</p>
							<p>
								${messageData.msgContent}
							</p>
                  		</div>
					</div>
					<div class="row">
						<c:if test="${messageData.msgSenderID != 'admini@gmail.com'}">
							<form class="form-inline msgFrom">
								<div class="form-group col-md-12">
						  			<p>
						  				回應內容：
									</p>
						  			<c:if test="${!empty messageData.msgResponse}" >
						  				<textarea cols="80" rows="10" class="form-control" rows="5" id="msgResponse" name="msgResponse" readonly="readonly">${messageData.msgResponse}</textarea>
									</c:if>	
									<c:if test="${empty messageData.msgResponse}" >
						  				<textarea cols="80" rows="10" class="form-control" rows="5" id="msgResponse" name="msgResponse"></textarea>
									</c:if>
								</div>
								<input type="button" id="beforePage" class="btn btn-primary pull-left" value="返回" />
			            		<c:if test="${!empty messageData.msgResponse}" >
						  			<input type="button" id="update" class="btn btn-primary pull-right" disabled="disabled" value="已回覆" />
								</c:if>
								<c:if test="${empty messageData.msgResponse}" >
						  			<input type="button" id="update" class="btn btn-primary pull-right" value="回覆" />
								</c:if>
			            	</form>
			            </c:if>
			            <c:if test="${messageData.msgSenderID == 'admini@gmail.com'}">
							<input type="button" id="beforePage" class="btn btn-primary pull-left" value="返回" />
			            </c:if>
					</div>
				</div>	
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


<script>
$(function(){
	
	// side_menu 帳戶總覽填充背景色
	$("#nav-accordion").find('li a').eq(6).addClass('active');

	$("#beforePage").on('click', function () {
		window.location.assign('<c:url value="/pages/backstageSeller/message_list.jsp" />');
	})
	
	$("#update").on('click', function () {
		formData = $(".msgFrom").serializeArray();
		console.log(formData);
		
		$.ajax({
			type: 'POST',
			url: "<c:url value='/message/replyMessage' />",
			data: {
				messageId:    "${messageData.msgID}",
				msgResponse:  formData[0].value,
			},
			dataType:"json",
			success: function(result){  //處理回傳成功事件，當請求成功後此事件會被呼叫
				//通知儲存成功  ，call BootstrapDialog      		       
				BootstrapDialog.show({
					type: BootstrapDialog.TYPE_INFO,
					title: "訊息",
					message: '訊息回覆成功!!',
					buttons: [{
						label: 'Close',
						action: function(dialogItself){
							dialogItself.close();
						}
					}]
				});
			
				$("#update").attr("disabled", "disabled");
				$("#msgResponse").attr("readonly", "readonly");
			},
			error: function(result){   //處理回傳錯誤事件，當請求失敗後此事件會被呼叫
				//your code here

			},
			complete: function(result) {

			},
			statusCode: {                     //狀態碼處理
				404: function() {
					alert("page not found");
				}
			}
		});
	})
	
})
</script>




