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
			<section class="wrapper" id="blog_list">
				<div class="breadcrumb-row">
					<h3>新增文章</h3>
					<ol class="breadcrumb">
					  	<li><a href="#">媽咪推薦</a></li>
					  	<li><a href="#">新增文章</a></li>
					</ol>
				</div>
				<div class="row">
					<div class="clear-both"></div>
				</div>
				<!--這邊開始寫內容-->
				<div class="container">
					<section class="panel">
						<header class="panel-heading product-add-heading" style="background:#93bad1;color: #fff; ">文章資訊</header>
                        <div class="panel-body">
							<form class="form-horizontal" method="get">
								<div class="row">
									<div class="form-group col-md-12">
	                                    <label class="col-md-2 control-label">文章主題</label>
	                                    <div class="col-md-6">
	                                        <input type="text" class="form-control">
	                                    </div>
	                                    <span class="col-md-4 text-limit-description">(限制15字內)<span>
		                            </div>   

	                                <div class="form-group col-md-12">
	                                    <label class="col-md-2 control-label">文章作著</label>
	                                    <div class="col-md-6">
	                                        <input type="text" class="form-control">
	                                    </div>  
	                                </div>
	                                
	                                <div class="form-group col-md-12">
	                                    <label class="col-md-2 control-label">文章大頭貼</label>
	                                    <div class="col-md-2">
	                                        <img style="width: 150px; height: 130px" src="<c:url value="/images/emptyImg.jpg"/>" class="previewStoreLogo">
	                                    </div>                       
										<div class="col-md-3" style="padding-top: 35px;">
											<input type="file" name="storeLogo" class="logoUpl" style="margin-bottom: 10px;">
											<span class="pictip" style="color:#ff6c60;font-size: 12px;">(長寬為1024*768，大小不得超過1M)</span>
										</div>
	                                </div>  
	                                
	                                <div class="dash-line col-md-12"/></div>
							
	                                <div class="form-group">
                                            <label class="col-sm-2 control-label col-sm-2">CKEditor</label>
                                                <div class="col-sm-10"><div id="editor"></div>
                                       </div>
                                    </div>        
                              </form>
                          </div>
                      	</section>
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
	$(".blog").css({'background':'#3a4152'});
	$(".blog").find('.sub').css({'display':'block'});
	$(".blog").find('.sub a').eq(1).css({'color':'yellow'});	
})
</script>




