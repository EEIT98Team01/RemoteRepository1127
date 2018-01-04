<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- 前台footer -->
<section class="container-fliud footerWrapper">
	<div class="footerBk"></div>
	<div class="container footerContainer">

		<div class="containerBox container-1">
			<ul>
				<li><a href="#">關於我們</a></li>
				<li><a href="#">媽咪推薦</a></li>
				<li><a href="#">服務說明</a></li>
				<li><a href="#">客服專區</a></li>
			</ul>
		</div>
		<div class="containerBox container-1">
			<ul>
				<li><a href="#">最新消息</a></li>
				<li><a href="#">新品上市</a></li>
				<li><a href="#">媒體活動</a></li>
				<li><a href="#">來店禮活動</a></li>
			</ul>
		</div>

		<div class="containerBox container-1" style="position: relative;">
			<img src="<c:url value="/images/content_img.png"/>">
			<img style="position: absolute;top: 15px;right: -420px;"src="<c:url value="/images/footerIcon.png"/>">
		</div>	
		
	</div>
	<div class="footerCopyright">COPYREGHT @ 2017  COWBABY MAKE</div>
</section>