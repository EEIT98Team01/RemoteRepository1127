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
					  	<li><a href="<c:url value='/pages/backstageAdmit/CustomerManagementEdit?id=${customerData.customerID}'/>">會員編輯</a></li>
					</ol>
				</div>
				<div class="row">
					<div class="clear-both"></div>
				</div>
				<!--這邊開始寫內容-->
				<div class="container">
					<div class="row">
						<section class="panel">
							<header class="panel-heading product-add-heading" style="background:#93bad1;color: #fff; ">編輯會員資料</header>
	                        <div class="panel-body">
								<form class="form-horizontal" id="shopSetForm" action="http://localhost:8080/CowBaby/CustomerManagementUpdate.controller" method="POST">
									<div class="row">
										<!-- 固定欄位不給修改 -->
										<input type="text" style="display:none" name="password" value="${customerData.password}" />
										<div class="form-group col-md-12">
		                                    <label class="col-md-2 control-label">會員ID</label>
		                                    <label class="col-md-2 control-label" style="text-align:left; width:auto;">${customerData.customerID}</label>
		                                    <input type="text" style="display:none" name="customerID" value="${customerData.customerID}" />
			                            </div>
			                            <div class="form-group col-md-12">
		                                    <label class="col-md-2 control-label">會員帳號</label>
		                                    <label class="col-md-2 control-label" style="text-align:left; width:auto;">${customerData.email}</label>
		                                    <input type="text" style="display:none" name="email" value="${customerData.email}" />
			                            </div>
			                            <div class="form-group col-md-12">
		                                    <label class="col-md-2 control-label">會員姓名</label>
		                                    <label class="col-md-2 control-label" style="text-align:left; width:auto;">${customerData.customerName}</label>
		                                    <input type="text" style="display:none" name="customerName" value="${customerData.customerName}" />
			                            </div>
			                            <div class="form-group col-md-12">
		                                    <label class="col-md-2 control-label">註冊日期</label>
		                                    <label class="col-md-2 control-label" style="text-align:left; width:auto;">${customerData.createTime.year+1900}-${customerData.createTime.month+1}-${customerData.createTime.date}</label>
		                                    <input type="text" style="display:none" name="createTime" value="${customerData.createTime}" />
			                            </div>
			                            <div class="form-group col-md-12">
		                                    <label class="col-md-2 control-label">累積消費金額</label>
		                                    <label class="col-md-2 control-label" style="text-align:left; width:auto;">${customerData.totalAmoutOfConsumption}</label>
		                                    <input type="text" style="display:none" name="totalAmoutOfConsumption" value="${customerData.totalAmoutOfConsumption}" />
			                            </div>
			                            <div class="form-group col-md-12">
		                                    <label class="col-md-2 control-label">累積消費次數</label>
		                                    <label class="col-md-2 control-label" style="text-align:left; width:auto;">${customerData.consumptionTimes}</label>
		                                    <input type="text" style="display:none" name="consumptionTimes" value="${customerData.consumptionTimes}" />
			                            </div>
			                            <!-- 基本資料 -->
			                            <div class="dash-line col-md-12"/></div>
			                            <div class="form-group col-md-12" style="padding-top: 30px">
		                                    <label class="col-md-2 control-label">收入</label>
		                                    <div class="col-md-6 add-prouduct-list-description">
		                                        <input type="text" name="income" class="form-control" value="${customerData.income}">
		                                    </div>
		                                </div>
		                                <div class="form-group col-md-12">
		                                    <label class="col-md-2 control-label">性別</label>
		                                    <div class="col-md-6">
		                                        <div class="radio">
													<label>
														<input type="radio" name="gender" value="M" <c:if test="${customerData.gender=='M'}">checked</c:if> />男
													</label>
													<label>
														<input type="radio" name="gender" value="F" <c:if test="${customerData.gender=='F'}">checked</c:if> />女
													</label>
												</div>
		                                    </div>
		                                </div>
		                                <div class="form-group col-md-12">
		                                    <label class="col-md-2 control-label">婚姻</label>
		                                    <div class="col-md-6">
		                                        <div class="radio">
													<label>
														<input type="radio" name="marriage" value="1" <c:if test="${customerData.marriage==true}">checked</c:if> />是
													</label>
													<label>
														<input type="radio" name="marriage" value="0" <c:if test="${customerData.marriage==false}">checked</c:if> />否
													</label>
												</div>
		                                    </div>
		                                </div>
			                            <div class="form-group col-md-12">
		                                    <label class="col-md-2 control-label">生日</label>
		                                    <div class="col-md-6 add-prouduct-list-description">
		                                        <input type="text" name="birthday" class="form-control" value="${customerData.birthday.year+1900}-${customerData.birthday.month+1}-${customerData.birthday.date}">
		                                    </div>
		                                </div>
										<!-- 聯絡方式 -->
		                                <div class="dash-line col-md-12"/></div>
			                            <div class="form-group col-md-12" style="padding-top: 30px">
		                                    <label class="col-md-2 control-label">住址</label>
		                                    <div class="col-md-6 add-prouduct-list-description">
		                                        <input type="text" name="address" class="form-control" value="${customerData.address}">
		                                    </div>
		                                </div>
		                                <div class="form-group col-md-12">
		                                    <label class="col-md-2 control-label">室內電話</label>
		                                    <div class="col-md-6 add-prouduct-list-description">
		                                        <input type="text" name="landline" class="form-control" value="${customerData.landline}">
		                                    </div>
		                                </div>
		                                <div class="form-group col-md-12">
		                                    <label class="col-md-2 control-label">行動電話</label>
		                                    <div class="col-md-6 add-prouduct-list-description">
		                                        <input type="text" name="mobilePhone" class="form-control" value="${customerData.mobilePhone}">
		                                    </div>
		                                </div>
										<!-- 平台相關資訊 -->
		                                <div class="dash-line col-md-12"/></div>
			                            <div class="form-group col-md-12" style="padding-top: 30px">
		                                    <label class="col-md-2 control-label">紅利點數</label>
		                                    <div class="col-md-6 add-prouduct-list-description">
		                                        <input type="text" name="bonus" class="form-control" value="${customerData.bonus}">
		                                    </div>
		                                </div>
		                                <div class="form-group col-md-12">
		                                    <label class="col-md-2 control-label">所屬身份</label>
		                                    <div class="col-md-6">
		                                        <select class="form-control" name="userID">
													<option value="1" <c:if test="${customerData.userID=='1'}">selected="true"</c:if>>一般會員</option>
													<option value="2" <c:if test="${customerData.userID=='2'}">selected="true"</c:if>>平台賣家</option>
													<option value="3" <c:if test="${customerData.userID=='3'}">selected="true"</c:if>>黑名單</option>	
												</select>
		                                    </div>
		                                </div>
		                                <div class="form-group col-md-12">
		                                    <label class="col-md-2 control-label">消費群集</label>
		                                    <div class="col-md-6">
		                                        <select class="form-control" name="consumerSegmentation">
													<option value="1" <c:if test="${customerData.consumerSegmentation=='1'}">selected="true"</c:if>>群集1</option>
													<option value="2" <c:if test="${customerData.consumerSegmentation=='2'}">selected="true"</c:if>>群集2</option>
													<option value="3" <c:if test="${customerData.consumerSegmentation=='3'}">selected="true"</c:if>>群集3</option>
												</select>
		                                    </div>
		                                </div>
		                                <div class="form-group col-md-12">
		                                    <label class="col-md-2 control-label">訂閱電子報</label>
		                                    <div class="col-md-6">
		                                        <div class="radio">
													<label>
														<input type="radio" name="subscription" value="1" <c:if test="${customerData.subscription==true}">checked</c:if> />是
													</label>
													<label>
														<input type="radio" name="subscription" value="0" <c:if test="${customerData.subscription==false}">checked</c:if> />否
													</label>
												</div>
		                                    </div>
		                                </div>
                                     </div>
                                     <input type="button" id="beforePage" class="btn btn-primary pull-left" value="返回查詢頁面" />
		                             <input type="button" id="update" class="btn btn-primary pull-right" value="儲存會員資料" />
	                              </form>
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
	
	$("#beforePage").on('click', function () {
		window.location.assign('<c:url value="/pages/backstageAdmit/member_managment.jsp" />');
	})
	
	$("#update").on('click', function () {
		$.ajax({
			type: 'POST',
			url: "<c:url value='/service/cutomerDataUpdate' />",
			cache: false,
			processData: false,
			contentType: false,
			data: new FormData($('#shopSetForm')[0]),
			success: function(result){  //處理回傳成功事件，當請求成功後此事件會被呼叫
				//通知儲存成功  ，call BootstrapDialog      		       
				BootstrapDialog.show({
					type: BootstrapDialog.TYPE_INFO,
					title: "訊息",
					message: '儲存成功!!',
					buttons: [{
						label: 'Close',
						action: function(dialogItself){
							dialogItself.close();
						}
					}]
				});     
			},
			error: function(result){   //處理回傳錯誤事件，當請求失敗後此事件會被呼叫
				//your code here

			},
			complete: function(result) {

			},
			statusCode: {                     //狀態碼處理
				404: function() {
					alert("page not found");
				}
			}
		});
     
	}) 

})
</script>