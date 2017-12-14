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
					<h3>會員編輯</h3>
					<ol class="breadcrumb">
					  	<li><a href="#">會員管理</a></li>
					</ol>
				</div>
				<div class="row">
					<div class="clear-both"></div>
				</div>
				<!--這邊開始寫內容-->
				<span>${customerData.customerID}</span>
				<div class="container">
					<div class="row">
						<section class="panel">
							<header class="panel-heading product-add-heading" style="background:#93bad1;color: #fff; ">編輯會員資料</header>
	                        <div class="panel-body">
								<form class="form-horizontal" action="#" method="POST">
									<div class="row">
										<!-- 固定欄位不給修改 -->
										<div class="form-group col-md-12">
		                                    <label class="col-md-2 control-label">會員ID</label>
		                                    <label class="col-md-2 control-label" style="text-align:left">9527</label>
		                                    <input type="text" style="display:none" value="1" />
			                            </div>
			                            <div class="form-group col-md-12">
		                                    <label class="col-md-2 control-label">會員帳號</label>
		                                    <label class="col-md-2 control-label" style="text-align:left">9527@gmail.com</label>
		                                    <input type="text" style="display:none" value="1" />
			                            </div>
			                            <div class="form-group col-md-12">
		                                    <label class="col-md-2 control-label">會員姓名</label>
		                                    <label class="col-md-2 control-label" style="text-align:left">葉燁燁</label>
		                                    <input type="text" style="display:none" value="1" />
			                            </div>
			                            <div class="form-group col-md-12">
		                                    <label class="col-md-2 control-label">註冊日期</label>
		                                    <label class="col-md-2 control-label" style="text-align:left">2017-08-05</label>
		                                    <input type="text" style="display:none" value="1" />
			                            </div>
			                            <div class="form-group col-md-12">
		                                    <label class="col-md-2 control-label">累積消費金額</label>
		                                    <label class="col-md-2 control-label" style="text-align:left">5</label>
		                                    <input type="text" style="display:none" value="1" />
			                            </div>
			                            <div class="form-group col-md-12">
		                                    <label class="col-md-2 control-label">累積消費次數</label>
		                                    <label class="col-md-2 control-label" style="text-align:left">13987</label>
		                                    <input type="text" style="display:none" value="1" />
			                            </div>
			                            <!-- 基本資料 -->
			                            <div class="dash-line col-md-12"/></div>
			                            <div class="form-group col-md-12" style="padding-top: 30px">
		                                    <label class="col-md-2 control-label">收入</label>
		                                    <div class="col-md-6 add-prouduct-list-description">
		                                        <input type="text" class="form-control">
		                                    </div>
		                                </div>
		                                <div class="form-group col-md-12">
		                                    <label class="col-md-2 control-label">性別</label>
		                                    <div class="col-md-6">
		                                        <div class="radio">
													<label>
														<input type="radio" />男
													</label>
													<label>
														<input type="radio" />女
													</label>
												</div>
		                                    </div>
		                                </div>
		                                <div class="form-group col-md-12">
		                                    <label class="col-md-2 control-label">婚姻</label>
		                                    <div class="col-md-6">
		                                        <div class="radio">
													<label>
														<input type="radio" />是
													</label>
													<label>
														<input type="radio" />否
													</label>
												</div>
		                                    </div>
		                                </div>
			                            <div class="form-group col-md-12">
		                                    <label class="col-md-2 control-label">生日</label>
		                                    <div class="col-md-6 add-prouduct-list-description">
		                                        <input type="text" class="form-control">
		                                    </div>
		                                </div>
										<!-- 聯絡方式 -->
		                                <div class="dash-line col-md-12"/></div>
			                            <div class="form-group col-md-12" style="padding-top: 30px">
		                                    <label class="col-md-2 control-label">住址</label>
		                                    <div class="col-md-6 add-prouduct-list-description">
		                                        <input type="text" class="form-control">
		                                    </div>
		                                </div>
		                                <div class="form-group col-md-12">
		                                    <label class="col-md-2 control-label">室內電話</label>
		                                    <div class="col-md-6 add-prouduct-list-description">
		                                        <input type="text" class="form-control">
		                                    </div>
		                                </div>
		                                <div class="form-group col-md-12">
		                                    <label class="col-md-2 control-label">行動電話</label>
		                                    <div class="col-md-6 add-prouduct-list-description">
		                                        <input type="text" class="form-control">
		                                    </div>
		                                </div>
										<!-- 平台相關資訊 -->
		                                <div class="dash-line col-md-12"/></div>
			                            <div class="form-group col-md-12" style="padding-top: 30px">
		                                    <label class="col-md-2 control-label">紅利點數</label>
		                                    <div class="col-md-6 add-prouduct-list-description">
		                                        <input type="text" class="form-control">
		                                    </div>
		                                </div>
		                                <div class="form-group col-md-12">
		                                    <label class="col-md-2 control-label">所屬身份</label>
		                                    <div class="col-md-6">
		                                        <select class="form-control">
													<option>一般會員</option>
													<option>平台賣家</option>
													<option>黑名單</option>	
												</select>
		                                    </div>
		                                </div>
		                                <div class="form-group col-md-12">
		                                    <label class="col-md-2 control-label">消費群集</label>
		                                    <div class="col-md-6">
		                                        <select class="form-control">
													<option>群集1</option>
													<option>群集2</option>
													<option>群集3</option>
												</select>
		                                    </div>
		                                </div>
		                                <div class="form-group col-md-12">
		                                    <label class="col-md-2 control-label">訂閱電子報</label>
		                                    <div class="col-md-6">
		                                        <div class="radio">
													<label>
														<input type="radio" />是
													</label>
													<label>
														<input type="radio" />否
													</label>
												</div>
		                                    </div>
		                                </div>
                                     </div>        
		                             <input type="submit" class="btn btn-primary pull-right" value="儲存" />
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
})
</script>