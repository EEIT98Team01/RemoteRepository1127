<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>cow baby 管理著後台</title>
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
			<section class="wrapper" id="message">
				<div class="breadcrumb-row">
					<h3>發送訊息</h3>
					<ol class="breadcrumb">
					  	<li><a href="#">發送訊息</a></li>					  
					</ol>
				</div>
				<div class="row">
					<div class="clear-both"></div>
				</div>
				<!--這邊開始寫內容-->
				<div class="row">
					<div class="col-md-12">
						<div class="panel panel-addpadding">
							<form class="form-inline msgFrom">
								<div class="form-group">
									<label>指定會員帳號：</label>
									<input type='text' name='account' id='account' class="form-control"/>
								</div>

								<div class="form-group">
									<label>收件人範圍：</label>
									<select class="form-control" name='range'　id='range'>
										<option value="0">全部</option>
										<option value="1">一般會員</option>
										<option value="2">平台賣家</option>
									</select>
								</div>
								
								<div class="col-md-12">    	
									<label>訊息內容：</label>
									<br/>
		                			<textarea  name='msgContent' id='msgContent'></textarea>
	                			</div>

								<button type="button" id="submit" class="btn btn-primary">發信</button>
							</form>
						</div>
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
	$(".msg a").addClass('active');
	
	console.log("data",new FormData($('#aaaaForm')[0]));
	$("#submit").on('click', function () {
		formData = $(".msgFrom").serializeArray();
		console.log(formData);
		
		$.ajax({
			type: 'POST',
			url: "<c:url value='/message/sendMessages' />",
			data: {
				account:    formData[0].value,
				range:      formData[1].value,
				msgContent: formData[2].value,
			},
			dataType:"json",
			success: function(result){  //處理回傳成功事件，當請求成功後此事件會被呼叫
				//通知儲存成功  ，call BootstrapDialog      		       
				BootstrapDialog.show({
					type: BootstrapDialog.TYPE_INFO,
					title: "訊息",
					message: '訊息發送成功!!',
					buttons: [{
						label: 'Close',
						action: function(dialogItself){
							dialogItself.close();
						}
					}]
				});
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




