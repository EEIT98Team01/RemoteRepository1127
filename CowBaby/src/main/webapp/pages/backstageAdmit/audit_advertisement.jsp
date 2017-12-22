<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CowBaby管理者後台</title>
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
					<h3>廣告審核</h3>
					<ol class="breadcrumb">
					  	<li><a href="#">會員管理</a></li>
					  	<li><a href="#">廣告審核</a></li>
					</ol>
				</div>
				<div class="row">
					<div class="clear-both"></div>
				</div>
				<!--這邊開始寫內容-->
				<div class="row">
					<div class="col-md-12">
						<div class="panel panel-addpadding">
							<form class="form-inline">
								<div class="form-group">
									<label for="exampleInputName2">申請人帳號:</label>
									<input type='text' class="form-control"/>
								</div>

								<div class="form-group">
									<label for="exampleInputName2">審核狀態:</label>
									<select class="form-control">
										<option>全部</option>
										<option>未審核</option>
										<option>審核中</option>
										<option>審核通過</option>
										<option>審核未通過</option>		
									</select>
								</div>
								<button type="submit" class="btn btn-primary">查詢</button>
							</form>
						</div>
					</div>	
				</div>
				
				<div class="row">	
					<div class="col-md-12">
						<div class="panel">	
							<table class="table table-striped table-bordered"> 
								<thead>
								  <tr>
								    <th>序號</th>
									<th>申請人帳號</th>
									<th>申請時間</th>
									<th>審核狀態</th>
									<th>廣告圖示</th>
									<th>審核處理</th>
								  </tr>
								</thead>
								<tbody>
								  	<tr>
								  		<td>1</td>
										<td><a href="<c:url value="/pages/backstageSeller/order_detail.jsp"/>" class="linklist">a001</a></td>
										<td>2017-10-10 10:05:05</td>
										<td><span class="label label-danger">未審核</span></td>
										<td><img src="${pageContext.request.contextPath}/images/01.jpg"></td>
										<td><a href="#" class='btn btn-primary'> <i class='fa fa-pencil'></i> </a></td>
								  	</tr>
								  	<tr>
								  		<td>2</td>
										<td><a href="<c:url value="/pages/backstageSeller/order_detail.jsp"/>" class="linklist">a001</a></td>
										<td>2017-10-10 10:05:05</td>
										<td><span class="label label-info">審核中</span></td>
										<td><img src="${pageContext.request.contextPath}/images/01.jpg"></td>
										<td><a href="#" class='btn btn-primary'> <i class='fa fa-pencil'></i> </a></td>
								  	</tr>
								  	<tr>
								  		<td>3</td>
										<td><a href="<c:url value="/pages/backstageSeller/order_detail.jsp"/>" class="linklist">a001</a></td>
										<td>2017-10-10 10:05:05</td>
										<td><span class="label label-primary">審核完成</span></td>
										<td><img src="${pageContext.request.contextPath}/images/01.jpg"></td>
										<td><a href="#" class='btn btn-success'> <i class='fa fa-eye'></i> </a></td>
								  	</tr>
								  	<tr>
								  		<td>4</td>
										<td><a href="<c:url value="/pages/backstageSeller/order_detail.jsp"/>" class="linklist">a001</a></td>
										<td>2017-10-10 10:05:05</td>
										<td><span class="label label-warning">審核未通過</span></td>
										<td><img src="${pageContext.request.contextPath}/images/01.jpg"></td>
										<td><a href="#" class='btn btn-success'> <i class='fa fa-eye'></i> </a></td>
								  	</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-3 record-number">
						<span>第2頁</span>
						<span>第10 - 20 筆</span>
						<span>共150筆</span>
					</div>
					<ul class="pagination">
						<li>
					      <a href="#" aria-label="Previous">
					        <span aria-hidden="true">&laquo;</span>
					      </a>
					    </li>
					    <li><a href="#">1</a></li>
					    <li><a href="#">2</a></li>
					    <li><a href="#">3</a></li>
					    <li><a href="#">4</a></li>
					    <li><a href="#">5</a></li>
					    <li>
					    <a href="#" aria-label="Next">
					        <span aria-hidden="true">&raquo;</span>
					    </a>
					    </li>
					</ul>
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
	$(".auditComplaints").css({'background':'#3a4152'});
	$(".auditComplaints").find('.sub').css({'display':'block'});
	$(".auditComplaints").find('.sub a').eq(1).css({'color':'yellow'});	

})
</script>




