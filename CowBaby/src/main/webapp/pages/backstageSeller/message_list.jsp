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
			<section class="wrapper" id="message">
				<div class="breadcrumb-row">
					<h3>訊息管理</h3>
					<ol class="breadcrumb">
					  	<li><a href="#">訊息管理</a></li>
					</ol>
				</div>
				<div class="row">
					<div class="clear-both"></div>
				</div>
				<!--這邊開始寫內容-->
				<div class="row">
					<div class="col-md-12">
						<div class="panel panel-addpadding">
							<form class="form-inline">
								<div class="form-group">
									<label for="exampleInputName2">會員帳號:</label>
									<input type='text' name='account' id='account' class="form-control" value="${account}"/>
								</div>
							
								<div class="form-group">
									<label for="exampleInputName2">信件狀態</label>
									<select class="form-control">
										<option>全部</option>
										<option>未讀</option>
										<option>已讀</option>
									</select>
								</div>

								<div class="form-group">
									<label for="exampleInputName2">寄件者</label>
									<select class="form-control">
										<option>全部</option>
										<option>系統訊息</option>
										<option>一般會員</option>
										<option>平台賣家</option>
									</select>
								</div>

								<button type="submit" class="btn btn-primary">查詢</button>
							</form>
						</div>
					</div>
				</div>	
			
				<div class="row"> 
					<div class="col-md-12">    
		                <table class="table table-bordered " style="background-color: #fff;">                  
                        	<thead>
							  	<tr>
									<th>刪除</th>
									<th>標記</th>
									<th>寄件人</th>
									<th>敘述</th>
									<th>時間</th>
									<th>狀態</th>
								</tr>
							</thead>
                           <tr>
                              	<td>
                                    <input type="checkbox" class="mail-checkbox">
                              	</td>
                              	<td>*</td>>
                                <td>金毛獅王</td>
                                <td> <a href="<c:url value="/pages/backstageSeller/message_detail.jsp"/>" class="linklist">9大派圍攻光明頂!!快火速前來支援</td>
                                <td>2017-10-10 20:08:08</td>
                                <td>未讀</td>  
                            </tr> 	
	                    </table>   
	                </div>
				</div>
				<!-- 分頁 -->
				<div class="row">
					<div class="col-md-3 record-number">
						<span>第2頁</span>
						<span>第10 - 20 筆</span>
						<span>共150筆</span>
					</div>
					<ul class="pagination">
						<li>
					      <a href="#" aria-label="Previous">
					        <span aria-hidden="true">&laquo;</span>
					      </a>
					    </li>
					    <li><a href="#">1</a></li>
					    <li><a href="#">2</a></li>
					    <li><a href="#">3</a></li>
					    <li><a href="#">4</a></li>
					    <li><a href="#">5</a></li>
					    <li>
					    <a href="#" aria-label="Next">
					        <span aria-hidden="true">&raquo;</span>
					    </a>
					    </li>
					</ul>
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
	$("#nav-accordion").find('li a').eq(6).addClass('active');

})
</script>




