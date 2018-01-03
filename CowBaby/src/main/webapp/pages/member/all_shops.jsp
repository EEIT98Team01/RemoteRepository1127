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
<link rel="stylesheet" href="<c:url value="/css/frontDesk/all_shops.css"/>">


<!--body-->
<body>
	<!--引入 topbar 跟  header-->
	<jsp:include page="/pages/common/topbar_and_header.jsp"/>
	
	<!-- 這邊 開始寫內容-->
	<!--每頁Banner-->
	<section class="page_banner">
		<img src="<c:url value="/images/all_prouducts_banner.png"/>">
	</section>
	
	<!--每頁 page_container-->
	<section class="page_container all_shops_page_container">

		<!-- 主要內容-->
		<div class="main_container_col_1">
			<div class="container_pagination">
				<div class="container_pagination_title col-md-2">全部商家</div>
				<div class="pull-right">
					<ul class="pagination" id="myPagination">
						<!-- <li>
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
					    </a> -->
					</ul>
				</div>
				<div class="col-md-2 col-md-offset-3 pull-right">
					<form class="form-inline">
						<div class="form-group">
							<label>顯示</label>
							<select class="form-control mySelect">
								<option value="10">10</option>
								<option value="2">2</option>
								<option value="4">4</option>
								<option value="6">6</option>		
							</select>
						</div>
					</form>	
				</div>
				
			</div>
			<!--全部商店-->
			<section class="shopList"> 
				<c:forEach var="list" items="${shopList}">
										
					<a class="item" href="<c:url value="PersonShopController"/>?storeID=${list.storeID}&email=${list.email}" >
						<img src="<c:url value="/images/newArrived1.jpg"/>">
						<div class="shopName">${list.storeName}</div>
						<div class="description">${list.storeDescription}</div>
						<div class="stars">
							<c:if test="${list.storeRating==0}">
								<ul>
									<li><i class="fa fa-star" aria-hidden="true"></i></li>
									<li><i class="fa fa-star-o" aria-hidden="true"></i></li>
									<li><i class="fa fa-star-o" aria-hidden="true"></i></li>
									<li><i class="fa fa-star-o" aria-hidden="true"></i></li>
									<li><i class="fa fa-star-o" aria-hidden="true"></i></li>
								</ul>
							</c:if>
							<c:if test="${list.storeRating==1}">
								<ul>
									<li><i class="fa fa-star" aria-hidden="true"></i></li>
									<li><i class="fa fa-star-o" aria-hidden="true"></i></li>
									<li><i class="fa fa-star-o" aria-hidden="true"></i></li>
									<li><i class="fa fa-star-o" aria-hidden="true"></i></li>
									<li><i class="fa fa-star-o" aria-hidden="true"></i></li>
								</ul>
							</c:if>
							<c:if test="${list.storeRating==2}">
								<ul>
									<li><i class="fa fa-star" aria-hidden="true"></i></li>
									<li><i class="fa fa-star" aria-hidden="true"></i></li>
									<li><i class="fa fa-star-o" aria-hidden="true"></i></li>
									<li><i class="fa fa-star-o" aria-hidden="true"></i></li>
									<li><i class="fa fa-star-o" aria-hidden="true"></i></li>
								</ul>
							</c:if>
							<c:if test="${list.storeRating==3}">
								<ul>
									<li><i class="fa fa-star" aria-hidden="true"></i></li>
									<li><i class="fa fa-star" aria-hidden="true"></i></li>
									<li><i class="fa fa-star" aria-hidden="true"></i></li>
									<li><i class="fa fa-star-o" aria-hidden="true"></i></li>
									<li><i class="fa fa-star-o" aria-hidden="true"></i></li>
								</ul>
							</c:if>
							<c:if test="${list.storeRating==4}">
								<ul>
									<li><i class="fa fa-star" aria-hidden="true"></i></li>
									<li><i class="fa fa-star" aria-hidden="true"></i></li>
									<li><i class="fa fa-star" aria-hidden="true"></i></li>
									<li><i class="fa fa-star" aria-hidden="true"></i></li>
									<li><i class="fa fa-star-o" aria-hidden="true"></i></li>
								</ul>
							</c:if>
							<c:if test="${list.storeRating==5}">
								<ul>
									<li><i class="fa fa-star" aria-hidden="true"></i></li>
									<li><i class="fa fa-star" aria-hidden="true"></i></li>
									<li><i class="fa fa-star" aria-hidden="true"></i></li>
									<li><i class="fa fa-star" aria-hidden="true"></i></li>
									<li><i class="fa fa-star" aria-hidden="true"></i></li>
								</ul>
							</c:if>
						</div>
						<div class="likes">
							<i class="fa fa-gratipay" aria-hidden="true"></i>
							<span>${list.totalPageView}</span>
						</div>
					</a>
				</c:forEach>
				
				<%-- <div class="item">
					<img src="<c:url value="/images/newArrived1.jpg"/>">
					<div class="shopName">兔兔的家</div>
					<div class="description">
						秋冬新款全面鋪貨中 每一款都是精心挑選出來了 這裏有最好的質量歡迎來諮詢 ！！
					</div>
					<div class="stars">
						<ul>
							<li><i class="fa fa-star" aria-hidden="true"></i></li>
							<li><i class="fa fa-star" aria-hidden="true"></i></li>
							<li><i class="fa fa-star" aria-hidden="true"></i></li>
							<li><i class="fa fa-star-o" aria-hidden="true"></i></li>
							<li><i class="fa fa-star-o" aria-hidden="true"></i></li>
						</ul>
						
					</div>
					<div class="likes">
						<i class="fa fa-gratipay" aria-hidden="true"></i>
						<span>1234</span>
					</div>
				</div> --%>
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
<script src="<c:url value="/pluging/Bootsrap/jquery.twbsPagination.js"/>"></script>
 



<script type="text/javascript">

$(function(){

	$(".all_shops_page_container .shopList .item .description").each(function(){
    	var mytext = $(this).text();
		var newText = mytext.substr(0,40);
		$(this).text(newText+"..."); 	
	});
	
	// 預設當前頁
  	var pagenow = 1;
  	// 預設總頁數
  	var totalPage = 1;
  	// 預設每頁顯示筆數
  	var visiblecount = 10;
  	// 分頁的插件，一定要加
    $('#myPagination').twbsPagination('destroy');
  	
 	// 自動產生分頁
 	var totalPages = ${totalPage};
    var pageSize  = ${pageSize};
  	
	$(".mySelect").change(function(){
		pageSize =$(this).children('option:selected').val();
  		console.log("visiblecount",visiblecount)
  		
  		$('#myPagination').twbsPagination('destroy');
  		
  		$('#myPagination').twbsPagination({
 			startPage: 1,
 			totalPages: totalPages,
 			visiblePages: pageSize,
 			initiateStartPageClick: true,
 			
 			onPageClick: function (evt, page) { 
 				var url = "";
 				url = url + 
 				      "${pageContext.servletContext.contextPath}/AllShopController?" +
 				      "pageNumber=" + page + "&" +
 				      "pageSize="+pageSize;		
 				window.location.replace(url);
 			}
 		});
	});


	if(!totalPages==0) {
		// 如果查詢有資料
		$('#myPagination').twbsPagination({
			startPage: ${pageNumber},
			totalPages: totalPages,
			visiblePages: pageSize,
			initiateStartPageClick: false,
			
			onPageClick: function (evt, page) { 
				var url = "";
				url = url + 
				      "${pageContext.servletContext.contextPath}/AllShopController?" +
				      "pageNumber=" + page + "&" +
				      "pageSize=${pageSize}"				
				window.location.replace(url);
			}
		});
	}

})
</script>
