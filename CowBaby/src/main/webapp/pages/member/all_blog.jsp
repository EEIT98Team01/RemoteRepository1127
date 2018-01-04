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
<link rel="stylesheet" href="<c:url value="/css/frontDesk/all_blog.css"/>">


<!--body-->
<body>
	<!--引入 topbar 跟  header-->
	<jsp:include page="/pages/common/topbar_and_header.jsp"/>
	
	<!--每頁Banner-->
	<section class="page_banner">
		<img src="<c:url value="/images/searchbox1.jpg"/>">
	</section>
	
	<!--每頁主要內容-->
	<!--從這邊開始寫-->
	<section class="page_container all_blog_page_container">
		<!-- 主要內容-->
		<div class="main_container_col_1">
			<div class="container_pagination">
				<div class="container_pagination_title col-md-2">媽咪BLOG</div>
				<div class="pull-right">
					<ul class="pagination">
						<li>
						    <a  style="border-radius:50%" href="#" aria-label="Previous">
						        <span aria-hidden="true">«</span>
						    </a>
					    </li>
					    <li><a href="#">1</a></li>
					    <li><a href="#">2</a></li>
					    <li><a href="#">3</a></li>
					    <li><a href="#">4</a></li>
					    <li><a href="#">5</a></li>
					    <li>
					    <a style="border-radius:50%" href="#" aria-label="Next">
					        <span aria-hidden="true">»</span>
					    </a>
					</ul>
				</div>
				<div class="col-md-2 col-md-offset-3 pull-right">
					<form class="form-inline">
						<div class="form-group">
							<label for="exampleInputName2">顯示</label>
							<select class="form-control">
								<option>10</option>
								<option>20</option>
								<option>30</option>
								<option>40</option>		
							</select>
						</div>
					</form>	
				</div>
			</div>

			<!--blogList-->
			<section class="blogList">		
				<c:forEach var="array" varStatus="st" items="${blogList}">
					<div class="item"> 
						<a href="<c:url value="BlogItemOfArticle"/>?articleID=${array[0]}" >
							<img width="250" height="230"   src="data:image/jpeg;base64,${array[1]}">
							<p class="articlHeader">${array[2]}</p>
							<p class="bloggerName">${array[3]}</p>
						</a>
					</div>
				</c:forEach>
			
			</section>
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

		$(".nav li").eq(3).find('a').css({"background": "#6abbc5","color": "#ffff"});
	})
</script>
