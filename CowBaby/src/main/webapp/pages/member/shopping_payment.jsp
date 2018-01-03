<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>cow babye購物商城</title>
	<link rel="icon" href="logo.ico">
</head>

<!--css-->
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css"> 
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-switch/3.3.4/css/bootstrap3/bootstrap-switch.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap3-dialog/1.34.7/css/bootstrap-dialog.min.css">

<link rel="stylesheet" href="<c:url value="/pluging/Bxsliders/jquery.bxslider.min.css"/>"> 
<link rel="stylesheet" href="<c:url value="/css/frontDesk/basic.css"/>">
<link rel="stylesheet" href="<c:url value="/css/frontDesk/shopping_payment.css"/>">


<!--body-->
<body>
	<!--引入 topbar 跟  header-->
	<jsp:include page="/pages/common/topbar_and_header.jsp"/>
	
	<!-- 這邊 開始寫內容-->
	<!--每頁 page_container-->
		<div class="main_page_title">
		<h3>我的購物車 My ShoppingCart</h3>
		<h5>親愛的${user.customerName}你好，以下是你的購物車清單<h5>
	</div>
	
	<div class="shopping_step">
		<div class="line1 lineActive"></div>
		<div class="line2"></div>
		<ul>
			<li><a class="step_link active" href="">Step1</a><small>確認購物明細</small></li>
			<li><a class="step_link active" href="">Step2</a><small>選擇附款方式</small></li>
			<li><a class="step_link" href="">Step3</a><small>確認結帳完成</small></li>
		</ul>
	</div>
	
	<!--每頁主要內容-->
	<section class="page_container shopping_payment">
		<!-- 主要內容-->
		<div class="main_container_col_1">
			<div class="panel panel-info">
		      	<div class="panel-heading title">請選擇付款方式</div>
		      	<div class="panel-body pannal_box">
			      	<ul>
						<li><label><input type="radio" name="payment">超商取貨</label></li>
						<li><label><input type="radio" name="payment">歐付寶付款</label></li>	
					</ul>
				</div>
				
   			</div>
   			
   			<div class="panel panel-info">
	   			<!-- 為了使用電子地圖不得以用才這樣 -->
	  			<form id="map" method="post" name="simulation_from" action="https://www.ezship.com.tw/emap/rv_request_web.jsp">
		      		<div class="panel-heading title">請選擇7-11</div>
					      	<input name="Submit2" type="submit" value="選擇門市" id="pp"></center>
					      	<input type="hidden" name="rv_name" value="謝無忌"> <!-- 取件人姓名 -->
						    <input type="hidden" name="rv_email" value="simulate_receiver@ezship.com.tw"> <!-- 取件人email -->
						    <input type="hidden" name="rv_mobil" value="0967123456"> <!-- 取件人行動電話 -->
						    <input type="hidden" name="order_id" value="${bonus}"> <!-- 購物網站自行產生之訂單編號 -->
						    <input type="hidden" name="su_id"  value="buyer@myweb.com.tw"> <!-- 業主在 ezShip 使用的帳號 -->
						    <input type="hidden" name="rv_amount" value="0"><!-- 金額 -->
						    <input type="hidden" name="webtemp" value="simulationpage"><!-- 網站所需額外判別資料。ezShip 將原值回傳，供網站判別用 -->
						    <input type="hidden" name="rturl"  value="http://localhost:8080/CowBaby/getmarketDataController"><!-- 回傳路徑及程式名稱 -->
					</div>
				</form>	
				
				
			</div>
			
	   		<form id ="test1" action="<c:url value="/getReceiveData"/>">
	   			<div class="panel panel-info">
			      	<div class="panel-heading title">訂購人資訊</div>
			      	<div class="panel-body pannal_box">
				      	<table>
				      		<tr>
				      			<td>ID</td>
								<td><input type="text" name="customerID" value="${user.customerID}"></td>
				      		</tr>
				      		<tr>
				      			<td>姓名</td>
								<td><input type="text" name="customerName" value="${user.customerName}"></td>
				      		</tr>
							<tr>
				      			<td>手機</td>
								<td><input type="text" name="mobilePhone" value="${user.mobilePhone}"></td>
				      		</tr>
	
				      		<tr>
				      			<td>地址</td>
								<td><input type="text" name="address" value="${user.address}"></td>
				      		</tr>

				      		<tr>			      			
								<td>email</td>
								<td><input type="text" name="email" value="${user.email}"></td>
				      		</tr>
				      	</table>
					</div>
	   			</div>
	
	
	   			<div class="panel panel-info">
			      	<div class="panel-heading title">收件人資訊</div>
			      	<div class="panel-body pannal_box">
			      		
				      	<table>
				      		<tr>
				      			<td><input type="checkbox" id="check1"/></td>
								<td style="padding: 10px;font-size: 15px;text-align:left;">跟寄件人一樣</td>
				      		</tr>
				      		<tr>
				      			<td>姓名</td>
								<td><input type="text" name="recipients" value=""></td>
				      		</tr>
							<tr>
				      			<td>手機</td>
								<td><input type="text" name="recipientsMobile" value=""></td>
				      		</tr>
	
				      		<tr>
				      			<td>地址</td>
								<td><input type="text" name="recipientsAdd" value=""></td>
				      		</tr>
				      		
				      		<tr>
				      			<td>email</td>
								<td><input type="text" name="recipientsEmail" value=""></td>
				      		</tr>

				      	</table>
				      	<!-- 把紅利 跟 便利商電地址 帶過去 -->
						<table>
				      		<tr>
				      			<td>便利商店名子</textarea>
								<td><input type="text" name="convenienceStoreName" value="${convenienceStorData.convenienceStoreName}"></td>
				      		</tr>
				      		<tr>
				      			<td>便利商店地址</textarea>
								<td><input type="text" name="convenienceStoreAdd" value="${convenienceStorData.convenienceStoreAdd}"></td>
				      		</tr>
				      		<tr>
				      			<td>便利商店電話</textarea>
								<td><input type="text" name="convenienceStoreTel" value="${convenienceStorData.convenienceStoreTel}"></td>
				      		</tr>
				      		<tr style="display:none">
				      			<td>我的紅利</td>
								<td><textarea  style="width: 100%;" name="recipientbonus">${bonus}</textarea></td>
				      		</tr>
			      		</table>
					</div>
	   			</div>

				<div class="docline"></div>
				
				<a href="#" class="go_checkout_btn">下ㄧ步</a>
		   </form>
		</div>		    
	</section>

	<!--引入 footer-->
	<jsp:include page="/pages/common/footer.jsp"/>
</body>
</html>


<!-- Bootstrap core JavaScript-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-switch/3.3.4/js/bootstrap-switch.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap3-dialog/1.34.7/js/bootstrap-dialog.min.js"></script>
<script src="<c:url value="/pluging/Bxsliders/jquery.bxslider.min.js"/>"></script>
<script type="text/javascript">

$(function(){

	var isCheck=false;
	$("#check1").click(function(){
		
		if(!isCheck){
			console.log("AA");
			$("input[name='recipients']").val("${user.customerName}");
			$("input[name='recipientsMobile']").val("${user.mobilePhone}");
			$("input[name='recipientsAdd']").val("${user.address}");
			$("input[name='recipientsEmail']").val("${user.email}");
			isCheck=true;
		}else{
			console.log("BB");
			$("input[name='recipients']").val("");
			$("input[name='recipientsMobile']").val("");
			$("input[name='recipientsAdd']").val("");
			$("input[name='recipientsEmail']").val("");
			isCheck=false;
		}

	});
	
	$(".go_checkout_btn").click(function(){
		$("#test1").submit();
		
	});
	
	$("#pp").click(function(){
		$("#map").submit();
		
	});
	
	

})
</script>
