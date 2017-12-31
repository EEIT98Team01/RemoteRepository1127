<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<p>請選則要處理的狀態</p>
<form class="form-horizontal" role="form" id="qqq" 
		action="${pageContext.servletContext.contextPath}/ficationupdate.controller" method="POST">
<div>
<input class="c-choice__input" id="radio1" name="classficatoinName" type="radio" value="玩具">
<label class="c-choice__label" for="radio1">玩具</label>

<input class="c-choice__input" id="radio1" name="classficatoinName" type="radio" value="圖書">
<label class="c-choice__label" for="radio1">圖書</label>

<input class="c-choice__input" id="radio1" name="classficatoinName" type="radio" value="衣服">
<label class="c-choice__label" for="radio1">衣服</label>

<input class="c-choice__input" id="radio1" name="classficatoinName" type="radio" value="鞋子">
<label class="c-choice__label" for="radio1">鞋子</label>

<input class="c-choice__input" id="radio1" name="classficatoinName" type="radio" value="日用品">
<label class="c-choice__label" for="radio1">日用品</label>
</div>
<hr />
<div>
		<label for="exampleFormControlTextarea1">分類描述</label>	
		<textarea class="form-control" name="classificationDescription"></textarea> 
</div>
<hr />
<div>
<input class="c-choice__input" id="radio1" name="startStopStatus" type="radio" value="true">
<label class="c-choice__label" for="radio1">啟用</label>

<input class="c-choice__input" id="radio1" name="startStopStatus" type="radio" value="false">
<label class="c-choice__label" for="radio1">停用</label>

</div>
<input type="hidden" value="${param.sss}" name="classficationID">
</form>