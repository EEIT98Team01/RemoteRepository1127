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
							<form class="form-inline" action="${pageContext.servletContext.contextPath}/pages/backstageSeller/ProductList" method="post">
								<div class="form-group">
									<label>商品名稱:</label>
									<input type='text' class="form-control" name="productName"/>
								</div>
								<div class="form-group">
									<label>商品分類:</label>
									<select class="form-control" name="productClassfication">
										<option value="">全部</option>
										<option value="1">玩具</option>
										<option value="2">圖書</option>
										<option value="3">衣服</option>
										<option value="4">鞋子</option>
										<option value="5">日用品</option>
									</select>
								</div>
								<div class="form-group">
									<label>商品狀態:</label>
									<select class="form-control" name="productStatus">
										<option value="">全部</option>
										<option value="">上架</option>
										<option value="">下架</option>
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
									<c:forEach var="product" varStatus="st" items="${productList}">
								  		<tr>
								  			<td>${st.count + (pageSize*(pageNumber-1))}</td>
											<td>${product.productID}</td>
											<td>${product.title}</td>
											<td><img src="${pageContext.request.contextPath}/images/01.jpg"></td>
											<td>${product.classficationID}</td>
											<td>100</td>
											<td>${product.unitPrice}</td>
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
									</c:forEach>
									
									<c:if test="${totalPage == 0 || empty totalPage}" >
										<tr><td colspan="10">目前無任何資料</td></tr>
									</c:if>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-3 record-number">
						<c:if test="${totalPage == 0 || empty totalPage}" >
							<span>第 <span class="pageNum">0</span>頁</span>|
							<span>第 <span class="firstNum">0</span> - <span class="endNum">0</span>筆</span>|
							<span>共 <span class="totalNum">0</span>筆</span>
						</c:if>
						
						<c:if test="${totalPage != 0 && !empty totalPage}" >
							<span>第 <span class="pageNum">${pageNumber}</span>頁</span>|
							<span>第 <span class="firstNum">${((pageNumber-1)*pageSize)+1}</span> - <span class="endNum">${pageNumber*pageSize}</span>筆</span>|
							<span>共 <span class="totalNum">${tatal}</span>筆</span>
						</c:if>

					</div>
					<!--分頁 -->
					<ul class="pagination"  id="myPagination"></ul>
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
<script src="<c:url value='/pluging/Bootsrap/bootstrap-datetimepicker.min.js'/>"></script>
<script src="<c:url value="/pluging/Bootsrap/jquery.twbsPagination.js"/>"></script>

<script>
$(function(){
	$("[name='my-checkbox']").bootstrapSwitch();
	// side_menu 帳戶總覽填充背景色
	$("#nav-accordion").find('li a').eq(3).addClass('active');
	$("#nav-accordion li a").siblings(".sub").css({'display':'block'});
	$("#nav-accordion li ul").find('a').eq(0).css({'color':'yellow'});
	$("#nav-accordion li").eq(3).css({'background':'#3a4152'});
	
  	// 預設當前頁
  	var pagenow = 1;
  	// 預設總頁數
  	var totalPage = 1;
  	// 預設每頁顯示筆數
  	var visiblecount = 10;
  	// 分頁的插件，一定要加
    $('#myPagination').twbsPagination('destroy');

 	// 自動產生分頁
 	var totalPages = ${totalPage};
    var pageSize  = ${pageSize};
    
	if(!totalPages==0) {
		// 如果查詢有資料
		$('#myPagination').twbsPagination({
			startPage: ${pageNumber},
			totalPages: totalPages,
			visiblePages: pageSize,
			initiateStartPageClick: false,
            
			onPageClick: function (evt, page) { 
				var url = "";
				url = url + 
				      "${pageContext.servletContext.contextPath}/pages/backstageSeller/ProductList?" +
				      "productName=${productName}&" +
				      "productClassfication=${productClassfication}&" +
				      "productStatus=${productStatus}&" +
				      "pageNumber=" + page + "&" +
				      "pageSize=${pageSize}"				
				window.location.replace(url);
			}
		});
	}
})
</script>




