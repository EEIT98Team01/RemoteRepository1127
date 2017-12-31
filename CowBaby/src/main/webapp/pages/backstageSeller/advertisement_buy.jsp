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
			<section class="wrapper" id="buy_advertising">
				<div class="breadcrumb-row">
					<h3>購買廣告</h3>	
				</div>
				
				<!--這邊開始寫內容-->
				<!--context-->
				<div class="row col-md-12">			
					<div class="panel panel-addpadding">
						<div class = "panel-heading">
					     	<h1 class = "panel-title">請選擇你想購買的廣告，我們有多種方案讓您選擇 ! 如有其他需求，需專人服務~請撥客服080-123456</h1>

					    </div>
					
						<div class = "panel-body">
					    	<div class="container">
					    		<!-- 買1天-->
					    		<div class="price-box oneday">
									<div class="price-table-header oneday-header">
					                    <h2>€ 15/mo</h2>
					                    <h3>Tiny</h3>
					                </div>
					                <div class="price-table-features">
					                    <p><strong>Unlimited</strong> Email Addresses</p>
					                    <p><strong>50GB</strong> Disk Space</p>
					                    <p><strong>Unlimited</strong> MySQL Databases</p>
					                    <p><strong>Unlimited</strong> Domains</p>
					                    <p><strong>Free</strong> Billing Systems</p>
					                </div>
					                <div class="price-table-buy">
					                  	<a href="#">馬上購買</a>
					                </div>	
					            </div>

					            <!-- 買3天-->
					    		<div class="price-box threeday">
									<div class="price-table-header threeday-header">
					                    <h2>€ 15/mo</h2>
					                    <h3>Tiny</h3>
					                </div>
					                <div class="price-table-features">
					                    <p><strong>Unlimited</strong> Email Addresses</p>
					                    <p><strong>50GB</strong> Disk Space</p>
					                    <p><strong>Unlimited</strong> MySQL Databases</p>
					                    <p><strong>Unlimited</strong> Domains</p>
					                    <p><strong>Free</strong> Billing Systems</p>
					                </div>
					                <div class="price-table-buy">
					                  	<a href="#">馬上購買</a>
					                </div>	
					            </div>

					            <!-- 買7天-->
					    		<div class="price-box sevenday">
									<div class="price-table-header sevenday-header">
					                    <h2>€ 15/mo</h2>
					                    <h3>Tiny</h3>
					                </div>
					                <div class="price-table-features">
					                    <p><strong>Unlimited</strong> Email Addresses</p>
					                    <p><strong>50GB</strong> Disk Space</p>
					                    <p><strong>Unlimited</strong> MySQL Databases</p>
					                    <p><strong>Unlimited</strong> Domains</p>
					                    <p><strong>Free</strong> Billing Systems</p>
					                </div>
					                <div class="price-table-buy">
					                  	<a href="#">馬上購買</a>
					                </div>	
					            </div>

					            <!-- 買14天-->
					    		<div class="price-box tow-week">
									<div class="price-table-header tow-week-header">
					                    <h2>€ 15/mo</h2>
					                    <h3>Tiny</h3>
					                </div>
					                <div class="price-table-features">
					                    <p><strong>Unlimited</strong> Email Addresses</p>
					                    <p><strong>50GB</strong> Disk Space</p>
					                    <p><strong>Unlimited</strong> MySQL Databases</p>
					                    <p><strong>Unlimited</strong> Domains</p>
					                    <p><strong>Free</strong> Billing Systems</p>
					                </div>
					                <div class="price-table-buy">
					                  	<a href="#">馬上購買</a>
					                </div>	
					            </div>
					        </div>
						</div>
					</div>	
				</div>
				<!--context end-->
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
	$("#nav-accordion").find('li a').eq(7).addClass('active');

})
</script>




