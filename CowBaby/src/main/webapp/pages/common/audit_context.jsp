<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<form class="form-inline" role="form" id="qqq"
	action="${pageContext.servletContext.contextPath}/CustomerReviewInsert.controller"
	method="POST">
	<div>
		<label for="exampleFormControlTextarea1">客服回覆內容:</label>	
		<textarea class="form-control" name="serviceFeedback"></textarea> 
	</div>
<input type="hidden" value="${param.aaa}" name="reportid">
</form>

