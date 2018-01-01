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
<link rel="stylesheet" href="<c:url value="/css/frontDesk/blog_article.css"/>">


<!--body-->
<body>
	<!--引入 topbar 跟  header-->
	<jsp:include page="/pages/common/topbar_and_header.jsp"/>
	
		<!--每頁Banner-->
	<section class="page_banner">
		<img src="<c:url value="/images/searchbox1.jpg"/>">
	</section>

	<section class="page_container blog_article_page">
		<div class="side_bar">

			<div class="article_classify">
				<div class="classify_title">最新文章</div>
				<ul>
					<li><a href="http://localhost:8080/CowBaby/BlogItemOfArticle?articleID=10">小魚兒屁屁褲</a></li>
					<li><a href="http://localhost:8080/CowBaby/BlogItemOfArticle?articleID=9">如何生出白人寶寶</a></li>
					<li><a href="http://localhost:8080/CowBaby/BlogItemOfArticle?articleID=8">如何生出黑人寶寶</a></li>
					<li><a href="http://localhost:8080/CowBaby/BlogItemOfArticle?articleID=7">如何生出漂亮寶寶</a></li>
					<li><a href="http://localhost:8080/CowBaby/BlogItemOfArticle?articleID=6">DinDin鞋</a></li>
				</ul>
				
			</div>
		</div>


		<!-- 全部文章-->
		<div class="main_container_col_2 blog_article_content">
			<div class="blog_introduction">
				<div class="blog_article_name">媽咪${blogData.bloggerName}</div>
			</div>

			<!--CK EDITOR 內容-->
				<!--這邊開始寫內容-->
				
				<div class="container">
					<div class="row">
						<section class="panel">
							<header class="panel-heading product-add-heading" style="background:#93bad1;color: #fff; ">精選部落格文章:${blogData.articleHeader}</header>
	                        <div class="panel-body">
								<div class="row">
							<!-- 	
									<div class="form-group col-md-12">
										<label class="col-md-2 control-label">文章ID</label>
										<label class="col-md-2 control-label" style="text-align:left; width:auto;">${blogData.articleID}</label>
									</div>
							 -->		
									<!-- 到底要怎麼插小圖阿 -->
							<!-- 		<div class="form-group col-md-12" style="padding-top: 30px">
										<label class="col-md-2 control-label">部落格小圖</label>
										<label class="col-md-2 control-label" style="text-align:left; width:auto;">${blogData.articlePhoto}</label>
									</div>
							 -->																	
									
									<div class="dash-line col-md-12"/></div>
									
									<div class="form-group col-md-12" style="padding-top: 30px">
										<label class="col-md-2 control-label">文章內容</label>
										<label class="col-md-2 control-label" style="text-align:left; width:auto;">${blogData.articleContent}</label>
									</div>
									
									

							  </div>
							  
	                      	</section>
                	 		<input type="button" id="beforePage" class="btn btn-primary pull-left" value="返回查詢頁面" />
	                      	
						</div>
					</div>	
				</div>	
 
			<!-- wrapper end -->
      	</section>
      	<!-- main-content end -->
	</section>
	<!-- container end -->
	
	
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

		 // 返回所有部落格頁面
		 $("#beforePage").on('click', function () {
			window.location.assign('<c:url value="http://localhost:8080/CowBaby/AllBlogController" />');
		 })
		
		 // side_menu 帳戶總覽填充背景色
		 $(".memberManagment a").addClass('active');
		

	})
</script>
