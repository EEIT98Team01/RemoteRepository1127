<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>cow baby 管理著後台</title>
<link rel="icon" href="logo.ico">
</head>

<!--css-->
<link rel="stylesheet"
	href="<c:url value="/css/backstageAdmitMainStyle.css"/>">

<!--body-->
<body>
	<section id="container"> <!--引入 header--> <jsp:include
		page="/pages/backstageAdmit/header_backstage.jsp" /> <!--引入 側邊蘭選單-->
	<jsp:include page="/pages/backstageAdmit/side_menu.jsp" /> <!--main-content-->
	<!--主要內容--> <section id="main-content"> <section
		class="wrapper" id="product_management_sort">
	<div class="breadcrumb-row">
		<h3>商品分類設定</h3>
		<ol class="breadcrumb">
			<li><a href="#">商品管理</a></li>
			<li><a href="#">商品分類設定</a></li>
		</ol>
	</div>
	<div class="row">
		<div class="clear-both"></div>
	</div>
	<!--這邊開始寫內容-->
	<div class="row">
		<div class="col-md-12">
			<div class="panel panel-addpadding">
				<form class="form-inline" 
				action="${pageContext.servletContext.contextPath}/ClassficationController" 
				method="POST" >
					<div class="form-group">
						<label for="exampleInputName2">分類名稱:</label> 
						<input type='text' name="classficatoinName" class="form-control" 
						value="" /> <!-- 回填分類名稱 -->
					</div>
					<button type="submit" class="btn btn-primary ">查詢</button>
					<button type="button" class="btn btn-primary add_sort">新增分類</button>
				</form>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<div class="panel">
				<table class="table table-striped table-bordered table_thead">
					<!-- <table class="table table-hover table-bordered orderlist"> -->
					<thead>
						<tr>
							<th>序號</th>
							<th>分類名稱</th>
							<th>分類描述</th>
							<th>使用狀態</th>
							<th>編輯</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="Classfication" varStatus="st" items="${ClassficationList}">
						<tr>
							<td>${st.count}</td>
							<td>${Classfication.classficatoinName}</td>
							<td>${Classfication.classificationDescription}</td>
							<c:choose>
								<c:when test="${Classfication.startStopStatus == true}">
									<td>啟用</td>
								</c:when>
								<c:otherwise>
									<td>不啟用</td>
								</c:otherwise>
							</c:choose>
							
							<!-- <td><span class="label label-success">啟用</span></td>
							 -->
							<td><a href="#" class='btn btn-primary'> 
							<i class='fa fa-pencil'></i>
							</a></td>
						</tr>
<!-- 						<tr> -->
<!-- 							<td>2</td> -->
<!-- 							<td>圖書</td> -->
<!-- 							<td>給小朋友看的書唷</td> -->
<!-- 							<td><span class="label label-danger">停用</span></td> -->
<!-- 							<td><a href="#" class='btn btn-primary'> <i -->
<!-- 									class='fa fa-pencil'></i> -->
<!-- 							</a></td> -->
<!-- 						</tr> -->
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-3 record-number">
			<span>第1頁</span> <span>第0 - 10 筆</span> <span>共150筆</span>
		</div>
		<ul class="pagination">
			<li><a href="#" aria-label="Previous"> <span
					aria-hidden="true">&laquo;</span>
			</a></li>
			<li><a href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li><a href="#">4</a></li>
			<li><a href="#">5</a></li>
			<li><a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
			</a></li>
		</ul>
	</div>
	<!--內容結束  --> </section> <!-- wrapper end --> </section> <!-- main-content end --> </section>
	<!-- container end -->
</body>
</html>

<!-- javasript pluging link CDN-->
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
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
	
	// side_menu 帳戶總覽填充背景色	
	$(".productManagement").css({'background':'#3a4152'});
	$(".productManagement").find('.sub').css({'display':'block'});
	$(".productManagement").find('.sub a').eq(1).css({'color':'yellow'});	
	
	//增加商品彈跳框
	$(".add_sort").click(function(){
		event.preventDefault();
		console.log("AAA");
		BootstrapDialog.show({
			 message: $('<div></div>').load('<c:url value="/pages/common/add_prouduct_popup.jsp"/>'),
            title:"新增商品分類",
            buttons: [{
		                label: '確定',
		                // no title as it is optional
		                cssClass: 'btn-primary',
		                data: {
		                    js: 'btn-confirm',
		                    'user-id': '3'
		                },
		                action: function(){
		                	console.log("AAA");
		                	$("#qqq").submit();
		                	
		                   
		                }
		            },{
		                label: '取消',
		                action: function(dialogItself){
		                    dialogItself.close();
		               }
		            }]
	     });
	})
	
})
</script>




