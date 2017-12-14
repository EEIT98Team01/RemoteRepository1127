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
			<section class="wrapper">
				<div class="breadcrumb-row">
					<h3>新增商品</h3>
					<ol class="breadcrumb">
						<li><a href="#">商品管理</a></li>
					  	<li><a href="#">新增商品</a></li>
					</ol>
				</div>
				<div class="row">
					<div class="clear-both"></div>
				</div>
				<!--這邊開始寫內容-->
				<div class="container">
					<div class="row">
						<section class="panel">
							<header class="panel-heading product-add-heading" style="background:#93bad1;color: #fff; ">增加商品資訊</header>
	                        <div class="panel-body">
								<form class="form-horizontal" method="get">
									<div class="row">
										<div class="form-group col-md-12">
		                                    <label class="col-md-2 control-label">商品名稱</label>
		                                    <div class="col-md-6">
		                                        <input type="text" class="form-control">
		                                    </div>
		                                    <span class="col-md-4 text-limit-description">(限制30字內)<span>
			                            </div>   

		                                <div class="form-group col-md-12">
		                                    <label class="col-md-2 control-label">商品編號</label>
		                                    <div class="col-md-6">
		                                        <input type="text" class="form-control">
		                                    </div>  
		                                </div>  
		                                 <div class="form-group col-md-12">
		                                    <label class="col-md-2 control-label">商品分類</label>
		                                    <div class="col-md-6">
		                                        <select class="form-control">
													<option>玩具</option>
													<option>圖書</option>
													<option>日用品</option>
													<option>其他</option>		
												</select>
		                                    </div>
		                                </div>  
		                    
		                                <div class="form-group col-md-12">
		                                    <label class="col-md-2 control-label">原價</label>
		                                    <div class="col-md-6">
		                                        <input type="text" class="form-control">
		                                    </div>
		                                     <span class="col-md-4 not">元</span>  
		                                </div> 

		                                <div class="form-group col-md-12">
		                                    <label class="col-md-2 control-label">特價</label>
		                                    <div class="col-md-6">
		                                        <input type="text" class="form-control">
		                                    </div>
		                                    <span class="col-md-4 not">元</span>
		                                    
		                                </div>  

		                                 <div class="form-group col-md-12">
		                                    <label class="col-md-2 control-label">商品庫存</label>
		                                    <div class="col-md-6">
		                                        <input type="text" class="form-control">
		                                    </div>
		                                    <span class="col-md-4 not">個</span>
		                                </div> 
	
		                                <div class="dash-line col-md-12"/></div>
			                            <div class="form-group col-md-12" style="padding-top: 30px;">
		                                    <label class="col-md-2 control-label">商品描述</label>
		                                    <div class="col-md-6 add-prouduct-list-description">
		                                        <input type="text" class="form-control">
		                                    </div>
	
		                                    <span class="col-md-4 text-limit-description">
												 <button class="btn btn-primary">
													<i class="fa fa-plus" aria-hidden="true"></i>
												</button>
		                                    (每行限制15字內，最多可增加5行)
		                                    <span>
		                                </div> 

		                                <div class="dash-line col-md-12"/></div>

		                                <div class="form-group col-md-12" style="padding-top: 30px;">
		                                    <label class="col-md-2 control-label">商品主描述</label>
		                                    <div class="col-md-6 add-prouduct-list-description">
		                                        <input type="text" class="form-control">    
		                                    </div>

		                                    <span class="col-md-4 text-limit-description">
												(最多只可50字)
		                                    <span>
		                                </div>

		                                <div class="dash-line col-md-12"/></div> 

		                                <div class="form-group">
                                             <label class="col-sm-2 control-label col-sm-2">CKEditor</label>
                                                 <div class="col-sm-10"><div id="editor"></div>
                                        </div>
                                     </div>        
		                               
	                              </form>
	                          </div>
	                      	</section>
						</div>
					</div>	
				</div>	
				<!-- 這邊開始寫內容結束 -->
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
	
	// side_menu 帳戶總覽填充背景色
	$("#nav-accordion").find('li a').eq(3).addClass('active');
	$("#nav-accordion li a").siblings(".sub").css({'display':'block'});
	$("#nav-accordion li ul").find('a').eq(1).css({'color':'yellow'});
	$("#nav-accordion li").eq(3).css({'background':'#3a4152'});
	
	
})
</script>




