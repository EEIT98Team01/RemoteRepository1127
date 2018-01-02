<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<p>請選則要處理的狀態</p>
<form class="form-horizontal" role="form" id="qqq" 
		action="${pageContext.servletContext.contextPath}/OrderUpdate.controller" method="POST">
<input class="c-choice__input" id="radio1" name="status" type="radio" value="未處理">
<label class="c-choice__label" for="radio1">未處理</label>

<input class="c-choice__input" id="radio1" name="status" type="radio" value="檢貨中">
<label class="c-choice__label" for="radio1">檢貨中</label>

<input class="c-choice__input" id="radio1" name="status" type="radio" value="送貨中">
<label class="c-choice__label" for="radio1">送貨中</label>

<input class="c-choice__input" id="radio1" name="status" type="radio" value="已完成">
<label class="c-choice__label" for="radio1">已完成</label>
<input type="hidden" value="${param.aaa}" name="orderID">
</form>