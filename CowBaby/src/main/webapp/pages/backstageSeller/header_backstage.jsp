<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- 後台 HEADER -->
<header class="header">
	<div class="header-toggle-box">
		<div class="fa fa-bars" data-placement="right"
			data-original-title="Toggle Navigation"></div>
	</div>
	<a href="#" class="logo"><b>COW BABY 賣家後台</b></a>
	<div class="nav notify-row">
		<ul class="nav notify-menu">
			<li>
			  <a href="#"> 
					<i class="fa fa-file-text" aria-hidden="true"></i>
					<span class="badge orderlist">4</span>
			  </a>
			</li>
			<li>
				<a href="#">
					<i class="fa fa-envelope-o"></i> 
					<span class="badge mail">5</span>
				</a>
			</li>
		</ul>
	</div>
	<div class="login">
		<div class="nav pull-right">
			<li class="">
				<a href="${pageContext.servletContext.contextPath}">回到前台</a>
			</li>
			<li class="login-user">
				<img src="${pageContext.request.contextPath}/images/line.jpg"><span>${user.customerName}</span>
			</li>
			<li><a class="logout" href="<c:url value="/LoingOutController"/>">登出</a></li>
		</div>
	</div>
</header>
