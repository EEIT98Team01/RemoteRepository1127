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
			<section class="wrapper" id="audit_shop">
				<div class="breadcrumb-row">
					<h3>賣家審核</h3>
					<ol class="breadcrumb">
					  	<li>審核管理</li>
					  	<li>賣家審核</li>
					</ol>
				</div>
				<div class="row">
					<div class="clear-both"></div>
				</div>
								<!--這邊開始寫內容-->
				<div class="row">
					<div class="col-md-12">
						<div class="panel panel-addpadding">
							<form class="form-inline audit_shop_form">
								<div class="form-group">
									<label for="exampleInputName2">申請人帳號:</label>
									<input type='text' class="form-control" name="email"/>
								</div>

								<div class="form-group">
									<label for="exampleInputName2">審核狀態:</label>
									<select class="form-control" name="applicationState">
										<option value="">全部</option>
										<option value="1">未審核</option>
										<option value="2">審核中</option>
										<option value="3">審核通過</option>
										<option value="4">審核未通過</option>		
									</select>
								</div>
								<button type="submit" class="btn btn-primary inquire">查詢</button>
							</form>
						</div>
					</div>	
				</div>
				
				<div class="row">	
					<div class="col-md-12">
						<div class="panel">	
							<table class="table table-striped table-bordered table_thead" id="audit_shop_List"> 
								<thead>
								  <tr>
								    <th>序號</th>
									<th>申請人帳號</th>
									<th>申請時間</th>
									<th>審核狀態</th>
									<th>審核處理</th>
									<th>備註</th>
								  </tr>
								</thead>
								<tbody>
								 <td colspan="10">目前無任何資料</td>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<!-- 顯示筆數 -->
				<div class="row">
					<div class="col-md-3 record-number">
						<span>第 <span class="pageNum">0</span>頁</span>|
						<span>第 <span class="firstNum">0</span> - <span class="endNum">0</span>筆</span>|
						<span>共 <span class="totalNum">0</span>筆</span>
					</div>
					<!--分頁 -->
					<ul class="pagination"></ul>
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
<script src="<c:url value="/pluging/Bootsrap/jquery.twbsPagination.js"/>"></script>
<script src="https://cdn.jsdelivr.net/npm/gasparesganga-jquery-loading-overlay@1.5.4/src/loadingoverlay.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/gasparesganga-jquery-loading-overlay@1.5.4/extras/loadingoverlay_progress/loadingoverlay_progress.min.js"></script>
<script src="<c:url value="/js/frontDesk/audit_shop.js"/>"></script>





