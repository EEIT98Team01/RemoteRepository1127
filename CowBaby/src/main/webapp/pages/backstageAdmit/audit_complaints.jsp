<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CowBaby管理者後台</title>
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
		class="wrapper" id="audit_complaints">
	<div class="breadcrumb-row">
		<h3>客服申訴</h3>
		<ol class="breadcrumb">
			<li>審核管理</li>
			<li>客服申訴</li>
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
					action="${pageContext.servletContext.contextPath}/CustomerReview.controller"
					method="POST">
					<div class="form-group">
						<label for="exampleInputName2">申訴人帳號:</label>
						<input type='text' class="form-control" name="email" value=""/>
					</div>

					<div class="form-group">
						<label for="exampleInputName2">審核狀態:</label> <select
							class="form-control" id="processStatus" name="processStatus">
							<option value="1">全部</option>
							<option value="2">未處理</option>
							<option value="3">處理中</option>
							<option value="4">已處理</option>
						</select>
					</div>
					<div class="form-group">
						<label for="exampleInputName2">案件類型:</label> <select
							class="form-control" id="problemTypes" name="problemTypes">
							<option value="1">全部</option>
							<option value="2">檢舉黑名單</option>
							<option value="3">帳號問題</option>
							<option value="4">BUG回報</option>
							<option value="5">其他</option>
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
				<table class="table table-striped table-bordered table_thead">
					<thead>
						<tr>
							<th>序號</th>
							<th>申訴人帳號</th>
							<th>申訴日期</th>
							<th>案件類型</th>
							<th>審核狀態</th>
							<th>申訴內容</th>
							<th>申訴回覆內容</th>
							<th>申訴回覆內容編輯</th>
							<th>申訴處理</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="CustomerReview" varStatus="st" items="${reviewList}">
							<tr>
								<td>${st.count}</td>
								<td>${CustomerReview.email}</td>
								<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${CustomerReview.reportTime}"/></td>
<%-- 								<td>${CustomerReview.problemTypes}</td> --%>
								<c:choose>
								<c:when test="${CustomerReview.problemTypes == 1}">
									<td>帳號問題</td>
								</c:when>
								<c:when test="${CustomerReview.problemTypes == 2}">
									<td>BUG問題</td>
								</c:when>
								<c:when test="${CustomerReview.problemTypes == 3}">
									<td>黑名單檢舉</td>
								</c:when>
								<c:when test="${CustomerReview.problemTypes == 4}">
									<td>其他</td>
								</c:when>								
							    </c:choose>
<%-- 								<td>${CustomerReview.processStatus}</td> --%>
								<c:choose>
								<c:when test="${CustomerReview.processStatus == 1}">
									<td><span class="label label-danger">處理中</span></td>
								</c:when>
								<c:when test="${CustomerReview.processStatus == 2}">
									<td>已處理</td>
								</c:when>
								<c:otherwise>
									<td>未處理</td>
								</c:otherwise>
							    </c:choose>
								<td>${CustomerReview.problemDescription}</td>
								<td>${CustomerReview.serviceFeedback}</td>
								<td><a href="#" class='btn btn-info audit_detail_btn'> 
									<span style="display: none;">${CustomerReview.reportID}</span>
								<i class="fa fa-commenting" aria-hidden="true"></i>
								</a></td>
								<td><a href="#" class='btn btn-primary audit_popupbox_btn' >
									<span style="display: none;">${CustomerReview.reportID}</span>
								<i class='fa fa-pencil'></i> 
									</a>
								</td>
							</tr>
						</c:forEach>
						<!-- <tr>
							<td>1</td>
							<td>華安</td>
							<td>2017-10-10 10:05:05</td>
							<td>檢舉黑名單</td>
							<td><span class="label label-danger">未處理</span></td>
							<td><a href="#" class='btn btn-info audit_detail_btn'> <i
									class="fa fa-commenting" aria-hidden="true"></i>
							</a></td>
							<td><a href="#" class='btn btn-primary audit_popupbox_btn'>
									<i class='fa fa-pencil'></i>
							</a></td>

						</tr>
						<tr>
							<td>2</td>
							<td>武狀元</td>
							<td>2017-10-10 10:05:05</td>
							<td>帳號問題</td>
							<td><span class="label label-info">處理中</span></td>
							<td><a href="#" class='btn btn-info audit_detail_btn'> <i
									class="fa fa-commenting" aria-hidden="true"></i>
							</a></td>
							<td><a href="#" class='btn btn-primary audit_popupbox_btn'>
									<i class='fa fa-pencil'></i>
							</a></td>

						</tr>
						<tr>
							<td>3</td>
							<td>對穿腸</td>
							<td>2017-10-10 10:05:05</td>
							<td>其他</td>
							<td><span class="label label-default">已處理</span></td>
							<td><a href="#" class='btn btn-info audit_detail_btn'> <i
									class="fa fa-commenting" aria-hidden="true"></i>
							</a></td>
							<td><a href="#" class='btn btn-success audit_popupbox_btn'> <i
									class='fa fa-eye'></i>
							</a></td>
						</tr> -->
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<!-- 顯示筆數 -->
	<div class="row">
		<div class="col-md-3 record-number">
			<span>第 <span class="pageNum">0</span>頁
			</span>| <span>第 <span class="firstNum">0</span> - <span
				class="endNum">0</span>筆
			</span>| <span>共 <span class="totalNum">0</span>筆
			</span>
		</div>
		<!--分頁 -->
		<ul class="pagination" id="audit_complaints_Pagination"></ul>
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
<script
	src="<c:url value="/pluging/Bootsrap/jquery.twbsPagination.js"/>"></script>
<script
	src="https://cdn.jsdelivr.net/npm/gasparesganga-jquery-loading-overlay@1.5.4/src/loadingoverlay.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/gasparesganga-jquery-loading-overlay@1.5.4/extras/loadingoverlay_progress/loadingoverlay_progress.min.js"></script>

<script>
	$(function() {
		// side_menu 帳戶總覽填充背景色
		$(".auditComplaints").css({
			'background' : '#3a4152'
		});
		$(".auditComplaints").find('.sub').css({
			'display' : 'block'
		});
		$(".auditComplaints").find('.sub a').eq(0).css({
			'color' : 'yellow'
		});

		// 設置 loaading icon大小
		$.LoadingOverlaySetup({
			size : "10%"
		});

 		// 申訴審核彈出框
		$(".audit_popupbox_btn").click(function(){
			console.log("AAA");
			var sss = $(this).find('span').text();
			console.log(sss)
			
				BootstrapDialog.show({
					message : $('<div></div>').load('/CowBaby/pages/common/audit_complaints_popup.jsp?sss='+sss),
					title : "申請審核",
					buttons : [ {
						label : '確定',
						// no title as it is optional
						cssClass : 'btn-primary',
						data : {
							js : 'btn-confirm',
							'user-id' : '3'
						},
						action : function() {
							console.log("AAA");
		                	$("#qqq").submit();
						}
					}, {
						label : '取消',
						action : function(dialogItself) {
							dialogItself.close();
						}
					} ]
				});
			})
				

		// 申訴內容細節和回覆彈出框
		$(".audit_detail_btn").click(function(){
			console.log("AA")
			var aaa = $(this).find('span').text();
			                                    
			BootstrapDialog.show({               
				message : $('<div></div>').load('/CowBaby/pages/common/audit_context.jsp?aaa='+aaa),
				title : "客服編輯使用",
				buttons : [ {
					label : '確定',
					// no title as it is optional
					cssClass : 'btn-primary',
					data : {
						js : 'btn-confirm',
						'user-id' : '3'
					},
					action : function() {
						console.log("AAA");
	                	$("#qqq").submit();
					}
				}, {
					label : '取消',
					action : function(dialogItself) {
						dialogItself.close();
					}
				} ]
			});
		}) 
	})
</script>




