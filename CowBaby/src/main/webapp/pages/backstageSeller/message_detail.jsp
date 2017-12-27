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
			<section class="wrapper" id="message-details">
		
				<!--這邊開始寫內容-->
				<div class="container details-inbox">
					<div class="row">
						<div class="col-md-12">
                  			<h4><span>主題:   </span>9大派圍攻光明頂!!快火速前來支援</h4>
                  		</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<i class="fa fa-user-circle-o" aria-hidden="true"></i>
                  		  	<strong>FROM:</strong>	
                          	<strong>金毛獅王謝遜</strong>
                          	<span>[mosaddek73@gmail.com]</span>
                          	<span>-</span>
                          	<span><i class="fa fa-clock-o" aria-hidden="true"></i>2017-10-10</span> 	
                  		</div>
					</div>
					<div class="row text">
						<div class="col-md-12">
							<p>
							根據外媒報導，德國一名男子賀杰（Niels Hoegel）於1999至2005年間，在兩間醫院擔任護理師期間，都故意替病患注射過量心臟藥物，導致其死亡，事件曝光後，他終於在2005年間因兩起謀殺案遭到逮捕，並遭判無期徒刑。
							根據外媒報導，德國一名男子賀杰（Niels Hoegel）於1999至2005年間，在兩間醫院擔任護理師期間，都故意替病患注射過量心臟藥物，導致其死亡，事件曝光後，他終於在2005年間因兩起謀殺案遭到逮捕，並遭判無期徒刑。</p>

							<p>不過，恐怖的是檢方進一步調查發現，他狠心殺害的人數超過一百人，其他起訴案將於明年初開始審判。然而，究竟為何要故意殺害病患？賀杰受審時曾表示，因為自己很喜歡替病人急救，讓他們死而復生，而當他的行為導致病人死亡時，他都告訴自己絕不再犯，但最後總是忍不住。</p>
                  		</div>
					</div>
					<div class="row">
						<hr/>
					</div>
					<div class="row">
						<div class="form-group col-md-12">
					  		<label for="comment">回應內容</label>
					  		<textarea class="form-control" rows="5" id="comment"></textarea>
						</div>	
						<!-- <a class="btn btn-sm btn-primary" href="mail_compose.html"><i class="fa fa-reply"></i> Reply</a> -->
					</div>
					<div class="row">
						<div class="form-group col-md-12">
							<a class="btn btn-sm btn-primary pull-right" href="mail_compose.html">
							<i class="fa fa-reply"></i>
							 Reply</a>
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
	
	// side_menu 帳戶總覽填充背景色
	$("#nav-accordion").find('li a').eq(6).addClass('active');

})
</script>




