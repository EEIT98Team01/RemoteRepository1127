<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<p>請選則要處理的狀態</p>
<form class="form-horizontal" role="form" id="qqq" 
		action="${pageContext.servletContext.contextPath}/productupdate.controller" method="POST">
<div>
		<input class="c-choice__input" id="radio1" name="productStatus" type="radio" value="true">
		<label class="c-choice__label" for="radio1">上架</label>
		
		<input class="c-choice__input" id="radio1" name="productStatus" type="radio" value="false">
		<label class="c-choice__label" for="radio1">下架</label>
</div>

<!-- <div> -->
<!-- 		<label for="exampleFormControlTextarea1">上架或下架原因</label>	 -->
<!-- 		<textarea class="form-control" name="productDescription"></textarea>  -->
<!-- </div> -->
<input type="hidden" value="${param.sss}" name="productID">
</form>