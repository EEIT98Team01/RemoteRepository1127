<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>cow baby 賣家後台</title>
<link rel="icon" href="logo.ico">
</head>


<!--css-->
<link rel="stylesheet"
	href="<c:url value="/css/backstageSellerMainStyle.css"/>">


<!--body-->
<body>
	<section id="container"> <!--引入 header--> <jsp:include
		page="/pages/backstageSeller/header_backstage.jsp" /> <!--引入 側邊蘭選單-->
	<jsp:include page="/pages/backstageSeller/side_menu.jsp" /> <!--main-content-->
	<!--主要內容--> <section id="main-content"> <section
		class="wrapper" id="order_list">
	<div class="breadcrumb-row">
		<h3>訂單查詢</h3>
		<ol class="breadcrumb">
			<li><a href="#">訂單查詢</a></li>
		</ol>
	</div>
	<div class="row">
		<div class="clear-both"></div>
	</div><!--  -->
	<!--這邊開始寫內容-->
	<div class="row">
		<div class="col-md-12">
			<div class="panel panel-addpadding">
				<!-- 問熊大-->
				<form class="form-inline"																	
				action="${pageContext.servletContext.contextPath}/Order01ManagementList.controller" 
					method="POST">										<!--↑識別字串 要跟controller對應 -->
					<div class="form-group">
						<label for="exampleInputName2">訂單編號:</label> 
						<input type='text' name='orderID' class="form-control" value="${orderID.orderID}" />
					</div>

					<div class="form-group">
						<label for="exampleInputName2">訂單狀態:</label> 
						<select class="form-control" name="orderStatus">
							<option>
								<c:if test="${orderStatus==''}">selected="true"</c:if>全部 
							</option>
							<option>
								<c:if test="${orderStatus=='1'}">selected="true"</c:if>未處理
							</option>
							<option>
								<c:if test="${orderStatus=='2'}">selected="true"</c:if>撿貨中
							</option>
							<option>
								<c:if test="${orderStatus=='3'}">selected="true"</c:if>送貨中
							</option>
							<option>
								<c:if test="${orderStatus=='4'}">selected="true"</c:if>已完成
							</option>
						</select>
					</div>
					<div class="form-group">
						<label>下訂期間:</label>

						<div class='input-group date'>
							<input type='text' class="form-control" id='datetimepicker1' name='startTime' />
							<span class="input-group-addon"> <span
								class="glyphicon glyphicon-calendar"></span>
							</span>
						</div>
						<span>到</span>

						<div class='input-group date'>
							<input type='text' class="form-control" id='datetimepicker2' name='endTime' />
							<span class="input-group-addon"> <span
								class="glyphicon glyphicon-calendar"></span>
							</span>
						</div>

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
							<th>訂單編號</th>
							<th>訂購時間</th>
							<th>數量</th>
							<th>訂購人</th>
							<th>總金額</th>
							<th>處理狀態</th>
							<th>訂單處理</th>
						</tr>
					</thead>
					<tbody>
									<!--forEach為加強型for迴圈    var自己取名 ，代表物件 item為識別字串    -->
						<c:forEach var="order01" varStatus="st" items="${order01List}">  <!--←識別字串 要跟controller的 ("order01List", order01ManagementService.find());對應       -->
																							<!--↓下面的order01為var值  -->
							<tr>
								<td>${st.count}</td>
								<td><a
									href="<c:url value="OrderDetailList.controller?orderID=${order01.orderID}"/>"
									class="linklist">${order01.orderID}</a></td>  <!--←${order01} 為上面var值設定  .orderID 為欄位值 -->
								<td>${order01.orderDate}</td>  
								<td>${order01.totalItems}</td>
								<td>${order01.customerID}</td>
								<td>${order01.totalAmount}</td>
								<td><span class="label label-danger">未處理</span></td>
								<td><button type="button" class="btn btn-success">變更狀態</button></td>
							</tr>
						</c:forEach>


					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-3 record-number">
			<c:if test="${!empty page}">
				<span>第{page}頁</span>
				<span>第${(page-1)*10+1} - ${page*10}筆</span>
				<span>共${orderQuantity}筆</span>
			</c:if>
		</div>
		<ul class="pagination">
			<li><c:if test="${!empty orderQuantity}">
					<a
						href="<c:url value="Order01ManagementList.controller?page=${page-1}&orderBy=${orderBy}&orderID=${orderID}&orderStatus=${orderStatus}" />"
						aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
					</a>
				</c:if>
				<c:if test="${page==1}">
	      			<a href="<c:url value="Order01ManagementList.controller?page=1&orderBy=${orderBy}&orderID=${orderID}&orderStatus=${orderStatus}" />" aria-label="Previous">
						<span aria-hidden="true">&laquo;</span>
					</a>
				</c:if>
			</li>
	
			<c:forEach var="pageNumber" begin="1" end="${pageQuantity}">
				<li><a href="<c:url value="Order01ManagementList.controller?page=${pageNumber}&orderBy=${orderBy}&order01=${order01}&orderStatus=${orderStatus}" />">${pageNumber}</a></li>
			</c:forEach>
			
	    	<li>
	    		<c:if test="${(page) != pageQuantity}">
	    			<a href="<c:url value="Order01ManagementList.controller?page=${page+1}&orderBy=${orderBy}&orderID=${orderID}&orderStatus=${orderStatus}" />" aria-label="Next">
	        			<span aria-hidden="true">&raquo;</span>
	    			</a>
	    		</c:if>
	    		<c:if test="${(page) == pageQuantity}">
	    			<a href="<c:url value="Order01ManagementList.controller?page=${pageQuantity}&orderBy=${orderBy}&orderID=${orderID}&orderStatus=${orderStatus}" />" aria-label="Next">
	        			<span aria-hidden="true">&raquo;</span>
	    			</a>
	    		</c:if>
	    	</li>
		</ul>
	</div>

	</section> </section> </section>
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
<!--  <script src="<c:url value="/pluging/Bootsrap/bootstrap-datetimepicker.min.js"/>"></script>-->
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script>
	$(function() {
		// side_menu 商店設置填充背景色
		$("#nav-accordion").find('li a').eq(2).addClass('active');
		$("#datetimepicker1").datepicker();
		$("#datetimepicker2").datepicker();
	})
</script>


