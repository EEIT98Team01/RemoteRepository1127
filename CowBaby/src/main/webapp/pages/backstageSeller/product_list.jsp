<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>cow baby 賣家後台</title>
<link rel="icon" href="logo.ico">
</head>

<!--css-->
<link rel="stylesheet" href="<c:url value="/css/backstageSellerMainStyle.css"/>">


<!--body-->
<body>
	<section id="container" >
		<!--引入 header-->
		<jsp:include page="/pages/backstageSeller/header_backstage.jsp"/>
		
		<!--引入 側邊蘭選單-->
		<jsp:include page="/pages/backstageSeller/side_menu.jsp"/>
		
		<!--main-content-->
		<!--主要內容-->
     	<section id="main-content">
			<section class="wrapper" id="product_management">
				<div class="breadcrumb-row">
					<h3>全部商品列表</h3>
					<ol class="breadcrumb">
					 	<li><a href="#">商品管理</a></li>
					  	<li><a href="#">全部商品列表</a></li>
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
									<label for="exampleInputName2">商品編號:</label>
									<input type='text' class="form-control"/>
								</div>
								<div class="form-group">
									<label for="exampleInputName2">商品分類:</label>
									<select class="form-control">
										<option>全部</option>
										<option>玩具</option>
										<option>圖書</option>
										<option>日用品</option>
										<option>衣服</option>		
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
							<!-- <table class="table table-hover table-bordered orderlist"> -->
								<thead>
								  <tr>
								    <th>序號</th>
									<th>商品編號</th>
									<th>商品名稱</th>
									<th>圖片</th>
									<th>分類</th>
									<th>庫存</th>
									<th>原價</th>
									<th>特價</th>
									<th>上架操作</th>
									<th>編輯</th>
									<th>刪除</th>								
								  </tr>
								</thead>
								<tbody>
								  	<tr>
								  		<td>1</td>
										<td>a123456</td>
										<td>教你作出好吃膠柄人之愛莉絲夢遊仙境</td>
										<td><img src="${pageContext.request.contextPath}/images/01.jpg"></td>
										<td>書籍</td>
										<td>100</td>
										<td>$500</td>
										<td>$50</td>
										<td>
											<input type="checkbox" name="my-checkbox" checked  data-size="mini">
										</td>
										<td>
											<button class="btn btn-primary">
												<i class="fa fa-pencil"></i>
											</button>
										</td>
										<td>
											<button class="btn btn-danger">
												<i class="fa fa-trash-o "></i>
											</button>
										</td>
									  	</tr>
									  	  	<tr>
									  		<td>1</td>
											<td>a123456</td>
											<td>教你作出好吃膠柄人之愛莉絲夢遊仙境</td>
											<td><img src="${pageContext.request.contextPath}/images/01.jpg"></td>
											<td>書籍</td>
											<td>100</td>
											<td>$500</td>
											<td>$50</td>
											<td>
												<input type="checkbox" name="my-checkbox" checked  data-size="mini">
											</td>
											<td>
												<button class="btn btn-primary">
													<i class="fa fa-pencil"></i>
												</button>
											</td>
											<td>
												<button class="btn btn-danger">
													<i class="fa fa-trash-o "></i>
												</button>
											</td>
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
				<!--內容結束  -->
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
	$("[name='my-checkbox']").bootstrapSwitch();
	// side_menu 帳戶總覽填充背景色
	$("#nav-accordion").find('li a').eq(3).addClass('active');
	$("#nav-accordion li a").siblings(".sub").css({'display':'block'});
	$("#nav-accordion li ul").find('a').eq(0).css({'color':'yellow'});
	$("#nav-accordion li").eq(3).css({'background':'#3a4152'});
	
})
</script>




