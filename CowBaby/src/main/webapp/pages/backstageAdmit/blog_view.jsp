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
  
  		<!--主要內容-->
     	<section id="main-content">
			<section class="wrapper" id="account_overview">
				<div class="breadcrumb-row">
					<h3>部落格檢視</h3>
					<ol class="breadcrumb">
						<li><a href="<c:url value='/pages/backstageAdmit/blog_list.jsp'/>">回文章列表</a></li>
					</ol>				
				</div>
				<div class="row">
					<div class="clear-both"></div>
				</div>
				<!--這邊開始寫內容-->
				
				<div class="container">
					<div class="row">
						<section class="panel">
							<header class="panel-heading product-add-heading" style="background:#93bad1;color: #fff; ">檢視部落格文章</header>
	                        <div class="panel-body">
								<div class="row">
									<div class="form-group col-md-12">
										<label class="col-md-2 control-label">文章ID</label>
										<label class="col-md-2 control-label" style="text-align:left; width:auto;">${blogData.articleID}</label>
									</div>
									
									<!-- 到底要怎麼插小圖阿，靠北耶 -->
									<div class="form-group col-md-12" style="padding-top: 30px">
										<label class="col-md-2 control-label">部落格小圖</label>
										<label class="col-md-2 control-label" style="text-align:left; width:auto;">${blogData.articlePhoto}</label>
									</div>
									
									<div class="form-group col-md-12">
										<label class="col-md-2 control-label">部落客大名</label>
										<label class="col-md-2 control-label" style="text-align:left; width:auto;">${blogData.bloggerName}</label>
									</div>
									
									<div class="form-group col-md-12">
										<label class="col-md-2 control-label">文章標題</label>
										<label class="col-md-2 control-label" style="text-align:left; width:auto;">${blogData.articleHeader}</label>
									</div>									
									
									<div class="dash-line col-md-12"/></div>
									
									<div class="form-group col-md-12" style="padding-top: 30px">
										<label class="col-md-2 control-label">文章內容</label>
										<label class="col-md-2 control-label" style="text-align:left; width:auto;">${blogData.articleContent}</label>
									</div>
									
									

								<input type="button" id="beforePage" class="btn btn-primary pull-left" value="返回查詢頁面" />
							  </div>
	                      	</section>
	                      	
						</div>
					</div>	
				</div>	
 
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
		
	 // 返回查詢頁面
	 $("#beforePage").on('click', function () {
		window.location.assign('<c:url value="/pages/backstageAdmit/blog_list.jsp" />');
	 })
	
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
	 
 	
	// side_menu 帳戶總覽填充背景色	
	$(".blog").css({'background':'#3a4152'});
	$(".blog").find('.sub').css({'display':'block'});
	$(".blog").find('.sub a').eq(0).css({'color':'yellow'});	
})
</script>




