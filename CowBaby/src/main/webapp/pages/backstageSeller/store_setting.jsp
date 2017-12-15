<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>cow baby 賣家後台</title>
<link rel="icon" href="logo.ico">
</head>

<!--css-->
<link rel="stylesheet"
	href="<c:url value="/css/backstageSellerMainStyle.css"/>">
<!--body-->
<body>
	<section id="container"> <!--引入 header--> <jsp:include
		page="/pages/backstageSeller/header_backstage.jsp" /> <!--引入 側邊蘭選單-->
	<jsp:include page="/pages/backstageSeller/side_menu.jsp" /> <!--main-content-->
	<!--主要內容--> <section id="main-content"> <section
		class="wrapper" id="shop_setting">
	<div class="breadcrumb-row">
		<h3>商店設置</h3>
		<ol class="breadcrumb">
			<li><a href="#">商店設置</a></li>
		</ol>
	</div>

	<div class="row">
		<div class="clear-both"></div>
	</div>
	<!--這邊開始寫內容-->
	<div class="container">
		<div class="row">
			<section class="panel"> 
				<header class="panel-heading product-add-heading" style="background:#93bad1;color: #fff; ">商店基本資料</header>
				<div class="panel-body">
					<form class="form-horizontal" id="shopSetForm" enctype="multipart/form-data">
						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-2 control-label">商店名稱</label>
								<div class="col-md-6">
									<input type="text" class="form-control" name="storeName">
								</div>
								<span class="col-md-4 text-limit-description">(限制30字內)<span>
							</div>
	
							<div class="form-group col-md-12">
								<label class="col-md-2 control-label">連絡電話</label>
								<div class="col-md-6">
									<input type="text" class="form-control" name="storePhone">
								</div>
								<span class="col-md-4 text-limit-description">(限制10字內)<span>
							</div>
	
							<div class="form-group col-md-12">
								<label class="col-md-2 control-label">商店狀態</label>
								<div class="col-md-6">
									<select class="form-control" name="storeStatus">
										<option value="true">開啟</option>
										<option value="false">關閉</option>
									</select>
								</div>
							</div>
	
							<div class="form-group col-md-12">
								<label class="col-md-2 control-label">店家描述</label>
								<div class="col-md-6 add-prouduct-list-description">
									<input type="text" class="form-control" name="storeDescription">
								</div>
								<span class="col-md-4 text-limit-description">(最多只可30字)<span>
							</div>
	
							<div class="dash-line col-md-12" /></div>
	
							<div class="form-group col-md-12" style="padding-top: 30px;">
								<label class="col-md-2 control-label">商店logo</label>
								<div class="col-md-2 add-prouduct-list-description">
									<img style="width: 150px; height: 110px" src="<c:url value="/images/emptyImg.jpg"/>" class="img-thumbnail">
								</div>
								<div class="col-md-3" style="padding-top: 35px;">
									<input type="file" name="storeLogo" id="aa"
										style="margin-bottom: 10px;"> <span class="pictip">(長寬為1024*768，大小不得超過1M)</span>
								</div>
							</div>
	
							<div class="form-group col-md-12" style="padding-top: 30px;">
								<label class="col-md-2 control-label">商店橫幅</label>
								<div class="col-md-2 add-prouduct-list-description">
									<img style="width: 150px; height: 110px"
										src="<c:url value="/images/emptyImg.jpg"/>"
										class="img-thumbnail">
								</div>
	
								<div class="col-md-3" style="padding-top: 35px;">
									<input type="file" name="storeBanner" id="aa" style="margin-bottom: 10px;"> <span class="pictip">(長寬為1024*768，大小不得超過1M)</span>
								</div>
							</div>
						</div>
					</form>
				<div class="dash-line col-md-12" /></div>
				<button id="qq" class="btn btn-primary pull-right" style="margin-top: 15px;">設定儲存</button>
			</div>
			</section>
		</div>
	</div>
	<!--這邊開始寫內容結束-->
	</div>
	<!--wrapper end--> 
	</section>
	 <!--main-content end-->
	</section>
 <!--containe end--> 
 </section>
 
 
	 <!-- 警告視窗--->
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
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
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
	 // side_menu 商店設置填充背景色
	 $("#nav-accordion").find('li a').eq(1).addClass('active');
	
	 
	 // 儲存發AJAX
	 $("#qq").on('click', function () {
		
		 $.ajax({
		     url: "http://localhost:8080/CowBaby/service/qoo",
		     type: 'POST',
		     cache: false,
		     data: new FormData($('#shopSetForm')[0]),
		     processData: false,
		     contentType: false,
		 	 success: function(result){ 
		 		 BootstrapDialog.alert('I want banana!');
		 	 },
			 error: function(result){  
			     //your code here

			 },
			 complete: function(result) {

			 },
			 statusCode: {               
			     404: function() {
			        alert("page not found");
			     }
			 }
		});
	 }) 

})
</script>



