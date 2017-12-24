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
			<section class="wrapper"  id="order-details">
				<div class="breadcrumb-row">
					<h3>帳戶總覽</h3>
					<ol class="breadcrumb">
					  	<li><a href="#">帳戶總覽</a></li>
					</ol>
				</div>
				<div class="row">
					<div class="clear-both"></div>
				</div>
				<!--這邊開始寫內容-->
				<div class="row">	
					<div class="col-md-12">
						<div class = "panel">
							 <!--   <div class = "panel-heading">
						      <h3 class = "panel-title">Panel title</h3>
						    </div> -->
						   
						    <div class = "panel-body">
						    	<div class="row">
							      	<div class="col-md-6">
							      		<i class="fa fa-asterisk" aria-hidden="true"></i>
							      		訂單編號 A123456
							      	</div>
							      	<div class="col-md-6 pull-right text-right">
							      		<i class="fa fa-calendar-minus-o" aria-hidden="true"></i>
							      		下訂日期 2017-10-10
							      	</div>
						      	</div>
						    </div>

							<table class="table table-bordered"> 

								<thead>
								  	<tr>
										<th>商品名稱</th>
										<th>商品圖片</th>
										<th>數量</th>
										<th>庫存</th>
										<th>原價</th>
										<th>特價</th>
										<th>總計</th>
								  	</tr>
								</thead>
								<tbody>
								  	<tr>
										<td>啾啾英文小故書</td>
										<td><img src="${pageContext.request.contextPath}/images/01.jpg"></td>
										<td>3</td>
										<td>有</td>
										<td>100</td>
										<td>20</td>
										<td>240</td>		
								  	</tr>  
								  	<tr>
										<td>啾啾英文小故書</td>
										<td><img src="${pageContext.request.contextPath}/images/01.jpg"></td>
										<td>3</td>
										<td>有</td>
										<td>100</td>
										<td>20</td>
										<td>240</td>		
								  	</tr>
								  	<tr>
										<td>啾啾英文小故書</td>
										<td><img src="${pageContext.request.contextPath}/images/01.jpg"></td>
										<td>3</td>
										<td>有</td>
										<td>100</td>
										<td>20</td>
										<td>240</td>		
								  	</tr>
								  	<tr class="totalnumber">
										<td>抵用金</td>
										<td colspan="4"></td>

										<td></td>
										<td>100</td>		
								  	</tr> 
                                    <tr class="totalmoneny">
										<td>金額</td>
										<td colspan="4" style="text-align: right;">數量  3 個</td>
										<td>合計</td>
										<td style="color: red;">500$</td>		
								  	</tr> 	
								</tbody>
							</table> 							
						</div>
					</div>
				</div>
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
	
	// side_menu 商店設置填充背景色
	$("#nav-accordion").find('li a').eq(2).addClass('active');

})
</script>



