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
					<h3>文章列表</h3>
					<ol class="breadcrumb">
					  	<li><a href="#">媽咪推薦</a></li>
					  	<li><a href="#">文章列表</a></li>
					</ol>
				</div>
				<div class="row">
					<div class="clear-both"></div>
				</div>
				<!--這邊開始寫內容-->
				<div class="row">
					<div class="col-md-12">
						<div class="panel panel-addpadding">
							<form class="form-inline memberFrom" >
								<div class="form-group">
									<label for="exampleInputName2">會員帳號:</label>
									<input type='text' name='account' id='account' class="form-control" value="${account}"/>
								</div>
								<div class="form-group">
									<label for="exampleInputName2">會員身份:</label>
									<select class="form-control" name="userType">
										<option value="">全部</option>
										<option value="1">一般會員</option>
										<option value="2">平台賣家</option>
										<option value="3">黑名單</option>	
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
							<table class="table table-striped table-bordered table_thead" id="customerList"> 
								<thead>
								  <tr>
								    <th>序號</th>
								    <th>文章ID</th>
								    <th>文章作著</th>
									<th>文章主題</th>
									<th>預覽</th>	
									<th>編輯</th>								
								  </tr>
								</thead>
								<tbody>
								   <tr>
								   	 <td>1</td>
								   	 <td>a123</td>
								   	 <td>牛牛媽</td>
								   	 <td>如何教倒乖孩子</td>
								   	 <td> <a href="#"><i class="fa fa-eye btn btn-success" aria-hidden="true"></i></a></td>
								   	 <td> <a href="#"><i class="fa fa-pencil btn btn-primary"></i></a></td>
								   </tr>
								   <td colspan="10">目前無任何資料</td>
								</tbody>
								
							</table>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-3 record-number">
						<span>第 <span class="pageNum">0</span>頁</span>|
						<span>第 <span class="firstNum">0</span> - <span class="endNum">0</span>筆</span>|
						<span>共 <span class="totalNum">0</span>筆</span>
					</div>
					<!--分頁 -->
					<ul class="pagination"  id="myPagination"></ul>
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
	$(".blog").find('.sub a').eq(0).css({'color':'yellow'});	
})
</script>




