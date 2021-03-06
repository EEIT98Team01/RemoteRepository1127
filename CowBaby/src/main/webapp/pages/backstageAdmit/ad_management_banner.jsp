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
			<section class="wrapper" id="audit_advertisement">
				<div class="breadcrumb-row">
					<h3>slidershow</h3>
					<ol class="breadcrumb">
					  	<li>廣告管理</li>
					  	<li>slidershow</li>
					</ol>
				</div>
				<div class="row">
					<div class="clear-both"></div>
				</div>
				<!--這邊開始寫內容-->	
			
				<div class="row">	
					<div class="col-md-12">
						<div class="panel">	
							<table class="table table-striped table-bordered"> 
								<thead style="font-size: 15px;text-align:center;background:#5da9ba;color: #fff;">
								  <tr>
								    <th>欄位序號</th>
									<th>廣告圖示</th>
									<th>圖片連結</th>
									<th>操作</th>
								  </tr>
								</thead>
								<tbody>
								  	<tr>
								  		<td>1</td>
										<td>
											<img src="${pageContext.request.contextPath}/images/01.jpg">
											<input type="file">   
										</td>
										<td>
											<input type="text" class="form-control">   
		                                </td>			
										<td><a href="#" class='btn btn-primary'> 更新</a></td>
								  	</tr>	
								</tbody>
							</table>
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
	$(".adManagement").css({'background':'#3a4152'});
	$(".adManagement").find('.sub').css({'display':'block'});
	$(".adManagement").find('.sub a').eq(0).css({'color':'yellow'});	

})
</script>




