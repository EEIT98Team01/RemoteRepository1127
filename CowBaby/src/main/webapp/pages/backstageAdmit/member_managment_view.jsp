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
		
		<!--引入 側邊欄選單-->
		<jsp:include page="/pages/backstageAdmit/side_menu.jsp"/>
		
		<!--main-content-->
		<!--主要內容-->
     	<section id="main-content">
			<section class="wrapper" id="account_overview">
				<div class="breadcrumb-row">
					<h3>會員管理</h3>
					<ol class="breadcrumb">
						<li><a href="<c:url value='/pages/backstageAdmit/member_managment.jsp'/>">會員管理</a></li>
					  	<li><a href="<c:url value='/pages/backstageAdmit/CustomerManagementView?id=${customerData.customerID}'/>">會員檢視</a></li>
					</ol>
				</div>
				<div class="row">
					<div class="clear-both"></div>
				</div>
				<!--這邊開始寫內容-->
				<div class="container">
					<div class="row">
						<section class="panel">
							<header class="panel-heading product-add-heading" style="background:#93bad1;color: #fff; ">檢視會員資料</header>
	                        <div class="panel-body">
								<div class="row">
									<div class="form-group col-md-12">
										<label class="col-md-2 control-label">會員ID</label>
										<label class="col-md-2 control-label" style="text-align:left; width:auto;">${customerData.customerID}</label>
									</div>
									
									<div class="form-group col-md-12">
										<label class="col-md-2 control-label">會員帳號</label>
										<label class="col-md-2 control-label" style="text-align:left; width:auto;">${customerData.email}</label>
									</div>
									
									<div class="form-group col-md-12">
										<label class="col-md-2 control-label">會員姓名</label>
										<label class="col-md-2 control-label" style="text-align:left; width:auto;">${customerData.customerName}</label>
									</div>
									
									<div class="form-group col-md-12">
										<label class="col-md-2 control-label">註冊日期</label>
										<label class="col-md-2 control-label" style="text-align:left; width:auto;">${customerData.createTime.year+1900}-${customerData.createTime.month+1}-${customerData.createTime.date}</label>
									</div>
									
									<div class="form-group col-md-12">
										<label class="col-md-2 control-label">累積消費金額</label>
										<label class="col-md-2 control-label" style="text-align:left; width:auto;">${customerData.totalAmoutOfConsumption}</label>
									</div>
									
									<div class="form-group col-md-12">
										<label class="col-md-2 control-label">累積消費次數</label>
										<label class="col-md-2 control-label" style="text-align:left; width:auto;">${customerData.consumptionTimes}</label>
									</div>
									
									<div class="dash-line col-md-12"/></div>
									
									<div class="form-group col-md-12" style="padding-top: 30px">
										<label class="col-md-2 control-label">收入</label>
										<label class="col-md-2 control-label" style="text-align:left; width:auto;">${customerData.income}</label>
									</div>
									
									<div class="form-group col-md-12">
										<label class="col-md-2 control-label">性別</label>
										<c:if test="${customerData.gender == 'F'}">
											<label class="col-md-2 control-label" style="text-align:left; width:auto;">女</label>
										</c:if>
										<c:if test="${customerData.gender == 'M'}">
											<label class="col-md-2 control-label" style="text-align:left; width:auto;">男</label>
										</c:if>
									</div>
									
									<div class="form-group col-md-12">
										<label class="col-md-2 control-label">婚姻</label>
										<c:if test="${customerData.marriage == true}">
											<label class="col-md-2 control-label" style="text-align:left; width:auto;">已婚</label>
										</c:if>
										<c:if test="${customerData.marriage == false}">
											<label class="col-md-2 control-label" style="text-align:left; width:auto;">未婚</label>
										</c:if>
									</div>
									
									<div class="form-group col-md-12">
										<label class="col-md-2 control-label">生日</label>
										<label class="col-md-2 control-label" style="text-align:left; width:auto;">${customerData.birthday.year+1900}-${customerData.birthday.month+1}-${customerData.birthday.date}</label>
									</div>

									<div class="dash-line col-md-12"/></div>
									
									<div class="form-group col-md-12" style="padding-top: 30px">
										<label class="col-md-2 control-label">住址</label>
										<label class="col-md-2 control-label" style="text-align:left; width:auto;">${customerData.address}</label>
									</div>
									
									<div class="form-group col-md-12">
										<label class="col-md-2 control-label">室內電話</label>
										<label class="col-md-2 control-label" style="text-align:left; width:auto;">${customerData.landline}</label>
									</div>
									
									<div class="form-group col-md-12">
										<label class="col-md-2 control-label">行動電話</label>
										<label class="col-md-2 control-label" style="text-align:left; width:auto;">${customerData.mobilePhone}</label>
									</div>
									
									<div class="dash-line col-md-12"/></div>
									
									<div class="form-group col-md-12" style="padding-top: 30px">
										<label class="col-md-2 control-label">紅利點數</label>
										<label class="col-md-2 control-label" style="text-align:left; width:auto;">${customerData.bonus}</label>
									</div>
									
									<div class="form-group col-md-12">
										<label class="col-md-2 control-label">所屬身份</label>
										<c:if test="${customerData.userID == 1}">
											<label class="col-md-2 control-label" style="text-align:left; width:auto;">一般會員</label>
										</c:if>
										<c:if test="${customerData.userID == 2}">
											<label class="col-md-2 control-label" style="text-align:left; width:auto;">平台賣家</label>
										</c:if>
										<c:if test="${customerData.userID == 3}">
											<label class="col-md-2 control-label" style="text-align:left; width:auto;">黑名單</label>
										</c:if>
										<c:if test="${customerData.userID == 4}">
											<label class="col-md-2 control-label" style="text-align:left; width:auto;">系統管理者</label>
										</c:if>
									</div>
		                                
									<div class="form-group col-md-12">
										<label class="col-md-2 control-label">訂閱電子報</label>
										<c:if test="${customerData.subscription == true}">
											<label class="col-md-2 control-label" style="text-align:left; width:auto;">有</label>
										</c:if>
										<c:if test="${customerData.subscription == false}">
											<label class="col-md-2 control-label" style="text-align:left; width:auto;">無</label>
										</c:if>
									</div>
								</div>
								<input type="button" id="beforePage" class="btn btn-primary pull-left" value="返回查詢頁面" />
								<input type="button" id="editCustomerData"class="btn btn-primary pull-right" value="編輯會員資料" />
							  </div>
	                      	</section>
	                      	
						</div>
					</div>	
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
	// 返回查詢頁面
	$("#beforePage").on('click', function () {
		window.location.assign("<c:url value='/pages/backstageAdmit/member_managment.jsp'/>");
	})
	// 前往編輯頁面
	$("#editCustomerData").on('click', function () {
		window.location.assign("<c:url value='CustomerManagementEdit?id=${customerData.customerID}'/>");
	})
})
</script>