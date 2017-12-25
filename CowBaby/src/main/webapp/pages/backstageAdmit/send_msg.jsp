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
			<section class="wrapper" id="message">
				<div class="breadcrumb-row">
					<h3>發送訊息</h3>
					<ol class="breadcrumb">
					  	<li><a href="#">發送訊息</a></li>					  
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
										<option>一般</option>
										<option>系統</option>
									</select>
								</div>
								<button type="submit" class="btn btn-warning">
									<i class=" fa fa-refresh"></i>
								</button>	
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
									<th>寄件人</th>
									<th>主題</th>
									<th>時間</th>
									<th>狀態</th>
									<th>回覆</th>	
								</tr>
							</thead>
                           <tr>
                              	<td>
                                    <input type="checkbox" class="mail-checkbox">
                              	</td>
                                <td>金毛獅王</td>
                                <td> <a href="<c:url value="/pages/backstageAdmit/send_msg_detail.jsp"/>" class="linklist">9大派圍攻光明頂!!快火速前來支援</td>
                                <td>2017-10-10 20:08:08</td>
                                <td>未讀</td> 
                                <td><button type="submit" class="btn btn-primary">回覆</button></td>    
                            </tr> 	
                          	<tr>
                              	<td>
                                    <input type="checkbox" class="mail-checkbox">
                              	</td>
                                <td>金毛獅王</td>
                                <td> <a href="#" class="linklist">9大派圍攻光明頂!!快火速前來支援</td>
                                <td>2017-10-10 20:08:08</td>
                                <td>未讀</td> 
                                <td><button type="submit" class="btn btn-primary">回覆</button></td>    
                            </tr> 	
	                    </table>   
	                </div>
				</div>
				<div class="row">
					<div class="col-md-3 record-number">
						<span>第 <span class="pageNum">0</span>頁</span>|
						<span>第 <span class="firstNum">0</span> - <span class="endNum">0</span>筆</span>|
						<span>共 <span class="totalNum">0</span>筆</span>
					</div>
					<!--分頁 -->
					<ul class="pagination"  id="myPagination"></ul>
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
	$(".msg a").addClass('active');
	
})
</script>




