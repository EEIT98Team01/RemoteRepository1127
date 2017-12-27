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
		
		<!--引入 側邊欄選單-->
		<jsp:include page="/pages/backstageAdmit/side_menu.jsp"/>
		
		<!--main-content-->
		<!--主要內容-->
     	<section id="main-content">
			<section class="wrapper" id="blog_list">
				<div class="breadcrumb-row">
					<h3>修改文章</h3>
					<ol class="breadcrumb">
					  	<li><a href="#">媽咪推薦</a></li>
					  	<li><a href="#">修改文章</a></li>
					</ol>
				</div>
				<div class="row">
					<div class="clear-both"></div>
				</div>
		<!--main-content-->
		<!--主要內容-->
		<!--這邊開始寫內容-->
				<div class="container">
					<div class="row">
						<section class="panel">
							<header class="panel-heading product-add-heading" style="background:#93bad1;color: #fff; ">編輯部落格資料</header>
	                        <div class="panel-body">
								<form class="form-horizontal" id="shopSetForm" action="http://localhost:8080/CowBaby/CustomerManagementUpdate.controller" method="POST">
									<div class="row">

			                            <!-- 基本資料 -->
			                            <div class="dash-line col-md-12"/></div>
			                            <div class="form-group col-md-12" style="padding-top: 30px">
		                                    <label class="col-md-2 control-label">部落客大名</label>
		                                    <div class="col-md-6 add-prouduct-list-description">
		                                        <input type="text" name="income" class="form-control" value="${customerData.income}">
		                                    </div>
		                                </div>
			                            <div class="form-group col-md-12">
		                                    <label class="col-md-2 control-label">文章標題</label>
		                                    <div class="col-md-6 add-prouduct-list-description">
		                                        <input type="text" name="birthday" class="form-control" value="${customerData.birthday}">
		                                    </div>
		                                </div>
										
										<!-- 平台相關資訊 -->
		                                <div class="dash-line col-md-12"/></div>
			                            <div class="form-group col-md-12" style="padding-top: 30px">
		                                    <label class="col-md-2 control-label">文章內容</label>
		                                    <div class="col-md-6 add-prouduct-list-description">
		                                        <input type="text" name="bonus" class="form-control" value="${customerData.bonus}">
		                                    </div>
		                                </div>
                                     </div>
                                     <input type="button" id="beforePage" class="btn btn-primary pull-left" value="返回查詢頁面" />
		                             <input type="button" id="update" class="btn btn-primary pull-right" value="儲存部落格資料" />
	                              </form>
	                          </div>
	                      	</section>
						</div>
					</div>	
				</div>	
				<!-- 內容結束 -->
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
	$(".blog").find('.sub a').eq(2).css({'color':'yellow'});	
})
</script>




