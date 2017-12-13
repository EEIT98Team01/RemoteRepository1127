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
			<section class="wrapper" id="account_overview">
				<div class="breadcrumb-row">
					<h3>會員管理</h3>
					<ol class="breadcrumb">
					  	<li><a href="#">會員管理</a></li>
					</ol>
				</div>
				<div class="row">
					<div class="clear-both"></div>
				</div>
				<!--這邊開始寫內容-->
				<div class="row">
					<div class="col-md-12">
						<div class="panel panel-addpadding">
							<form class="form-inline" action="http://localhost:8080/CowBaby/CustomerManagementController.controller" method="POST">
								<div class="form-group">
									<label for="exampleInputName2">會員帳號:</label>
									<input type='text' name='account' id='account' class="form-control" value="${account}"/>
								</div>
								<div class="form-group">
									<label for="exampleInputName2">會員身份:</label>
									<select class="form-control" name="userType">
										<option <c:if test="${userType==''}">selected="true"</c:if>>全部</option>
										<option <c:if test="${userType=='1'}">selected="true"</c:if>>一般會員</option>
										<option <c:if test="${userType=='2'}">selected="true"</c:if>>平台賣家</option>
										<option <c:if test="${userType=='3'}">selected="true"</c:if>>黑名單</option>	
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
							<table class="table table-striped table-bordered" id='customerList'> 
								<thead>
								  <tr>
								    <th>序號</th>
									<th><a href="<c:url value="CustomerManagementController.controller?page=1&orderBy=email&account=${account}&userType=${userType}" />">帳號</a></th>
									<th><a href="<c:url value="CustomerManagementController.controller?page=1&orderBy=customerName&account=${account}&userType=${userType}" />">姓名</a></th>
									<th>手機</th>
									<th>性別</th>
									<th>身份</th>
									<th>所屬會員群集</th>
									<th>累積消費金額</th>
									<th>檢視</th>
									<th>編輯</th>								
								  </tr>
								</thead>
								<tbody>
									<c:forEach var="customer" varStatus="st" items="${customerList}">
										<tr>
											<td>${st.count}</td>
											<td>${customer.email}</td>
											<td>${customer.customerName}</td>
											<td>${customer.mobilePhone}</td>
											<td>${customer.gender}</td>
											<td>${customer.userID}</td>
											<td>${customer.consumerSegmentation}</td>
											<td>${customer.totalAmoutOfConsumption}</td>
											<td>
												<a href=# class='btn btn-success'> <i class='fa fa-eye'></i> </a>
											</td>
											<td>
												<a href=# class='btn btn-primary'> <i class='fa fa-pencil'></i> </a>
											</td>
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
							<span>第${page}頁</span>
							<span>第${(page-1)*10+1} - ${page*10}筆</span>
							<span>共${customerQuantity}筆</span>
						</c:if>
					</div>
					
					<ul class="pagination">
						<c:if test="${!empty customerQuantity}">
							<li>
								<c:if test="${page != 1}">
					      			<a href="<c:url value="CustomerManagementController.controller?page=${page-1}&orderBy=${orderBy}&account=${account}&userType=${userType}" />" aria-label="Previous">
					        			<span aria-hidden="true">&laquo;</span>
					      			</a>
					      		</c:if>
					      		<c:if test="${page == 1}">
					      			<a href="<c:url value="CustomerManagementController.controller?page=1&orderBy=${orderBy}&account=${account}&userType=${userType}" />" aria-label="Previous">
					        			<span aria-hidden="true">&laquo;</span>
					      			</a>
					      		</c:if>
					      	</li>					      	

							<c:forEach var="pageNumber" begin="1" end="${pageQuantity}">
								<li><a href="<c:url value="CustomerManagementController.controller?page=${pageNumber}&orderBy=${orderBy}&account=${account}&userType=${userType}" />">${pageNumber}</a></li>
							</c:forEach>

					    	<li>
					    		<c:if test="${(page) != pageQuantity}">
					    			<a href="<c:url value="CustomerManagementController.controller?page=${page+1}&orderBy=${orderBy}&account=${account}&userType=${userType}" />" aria-label="Next">
					        			<span aria-hidden="true">&raquo;</span>
					    			</a>
					    		</c:if>
					    		<c:if test="${(page) == pageQuantity}">
					    			<a href="<c:url value="CustomerManagementController.controller?page=${pageQuantity}&orderBy=${orderBy}&account=${account}&userType=${userType}" />" aria-label="Next">
					        			<span aria-hidden="true">&raquo;</span>
					    			</a>
					    		</c:if>
					    	</li>
					    </c:if>
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

<script>
$(function(){
	// side_menu 帳戶總覽填充背景色
	$(".memberManagment a").addClass('active');
// 	var html="";
// 	var count = 1;
// 	$.getJSON('http://localhost:8080/CowBaby/service/getCustomerData',{},function(datas){
	     
		
// 		$.each(datas,function(idx,customer){
// 	    	 var html="";
	    	 
// 		    	html="<tr>"+
// 							"<td>"+(idx+1)+"</td>" +
// 							"<td>"+customer.email+"</td>" +
// 							"<td>"+customer.customerName+"</td>" +
// 							"<td>"+customer.mobilePhone+"</td>" +
// 							"<td>"+customer.gender+"</td>" +
// 							"<td>"+customer.userID+"</td>" +
// 							"<td>"+customer.consumerSegmentation+"</td>" +
// 							"<td>"+customer.totalAmoutOfConsumption+"</td>" +
// 							"<td> <a href=# class='btn btn-success'> <i class='fa fa-eye'></i> </a> </td>" +
// 							"<td> <a href=# class='btn btn-primary'> <i class='fa fa-pencil'></i> </a> </td>" +
// 						 "</tr>";				
// 		    	$('tbody').append(html);
// 	     });
//    });

})
</script>