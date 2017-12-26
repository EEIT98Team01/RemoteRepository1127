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
		page="/pages/backstageAdmit/header_backstage.jsp" /> <!--引入 側邊蘭選單--> <jsp:include
		page="/pages/backstageAdmit/side_menu.jsp" /> <!--main-content--> <!--主要內容-->
	<section id="main-content"> <section class="wrapper"
		id="audit_advertisement">
	<div class="breadcrumb-row">
		<h3>商品列表頁</h3>
		<ol class="breadcrumb">
			<li>商品管理</li>
			<li>商品列表頁</li>
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
					action="${pageContext.servletContext.contextPath}/ProductController"
					method="POST">
					<div class="form-group">
						<label for="exampleInputName2">會員帳號:</label> <input type='text'
							name='classficationID' class="form-control" value="" />
					</div>
					<div class="form-group">
						<label for="exampleInputName2">會員身份:</label> 
						<select class="form-control" name="productStatus">
							<option>
								<c:if test="${productStatus==''}">selected="true"</c:if>全部 
							</option>
							<option>
								<c:if test="${productStatus=='1'}">selected="true"</c:if>一般會員
							</option>
							<option>
								<c:if test="${productStatus=='2'}">selected="true"</c:if>平台賣家
							</option>
							<option>
								<c:if test="${productStatus=='3'}">selected="true"</c:if>黑名單
							</option>
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
				<table class="table table-striped table-bordered table_thead"
					id="customerList">
					<thead>
						<tr>
							<th>序號</th>
							<th>商品名稱</th>
							<th>摘要</th>
							<th>單價</th>
							<th>商品內容描述</th>
							<th>狀態</th>
							<th>分類</th>
							<th>適用年齡</th>
							<th>性別</th>
							<th>上架時間</th>
							<th>商品圖示</th>
							<th>編輯</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="classfication" varStatus="st" items="${classficationIDList}">
						<tr>
							<td>${st.count}</td>
							<td>${classfication.title}</td>
							<td>${classfication.summary}</td>
							<td>${classfication.unitPrice}</td>
							<td>${classfication.productDescription}</td>
							<td>${classfication.productStatus}</td>
							<td>${classfication.classficationID}</td>
							<td>${classfication.suitableAges}</td>
							<td>${classfication.genderPreference}</td>
							<td>${classfication.displayTime}</td>
							<td>${classfication.productImage}</td>
							<!-- <td><span class="label label-success">啟用</span></td>
							 -->
							<td><a href="#" class='btn btn-primary'> 
							<i class='fa fa-pencil'></i>
							</a></td>
						</tr>
						</c:forEach>
					</tbody>

				</table>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-3 record-number">
			<span>第 <span class="pageNum">1</span>頁
			</span>| <span>第 <span class="firstNum">0</span> - <span
				class="endNum">10</span>筆
			</span>| <span>共 <span class="totalNum">150</span>筆
			</span>
		</div>
		<!--分頁 -->
		<ul class="pagination" id="myPagination"></ul>
	</div>
	<!-- 內容結束 --> </section> <!-- wrapper end --> </section> <!-- main-content end --> </section>
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
	$(function() {
		// side_menu 帳戶總覽填充背景色	
		$(".productManagement").css({
			'background' : '#3a4152'
		});
		$(".productManagement").find('.sub').css({
			'display' : 'block'
		});
		$(".productManagement").find('.sub a').eq(0).css({
			'color' : 'yellow'
		});

	})
</script>




