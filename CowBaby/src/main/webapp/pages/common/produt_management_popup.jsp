<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<p>請選則要處理的狀態</p>
<form class="form-horizontal" role="form" id="qqq" 
		action="${pageContext.servletContext.contextPath}/productupdate.controller" method="POST">
<div>
<input class="c-choice__input" id="radio1" name="title" type="text" >
<label class="c-choice__label" for="radio1">商品名稱</label>
</div>
<hr />
<div>
<input class="c-choice__input" id="radio1" name="summary" type="text" >
<label class="c-choice__label" for="radio1">摘要</label>
</div>
<hr />
<div>
<input class="c-choice__input" id="radio1" name="unitPrice" type="text" >
<label class="c-choice__label" for="radio1">單價</label>
</div>
<hr />
<div>
		<label for="exampleFormControlTextarea1">商品內容描述描述</label>	
		<textarea class="form-control" name="productDescription"></textarea> 
</div>
<hr />
<div>
		<input class="c-choice__input" id="radio1" name="productStatus" type="radio" value="上架">
		<label class="c-choice__label" for="radio1">上架</label>
		
		<input class="c-choice__input" id="radio1" name="productStatus" type="radio" value="下架">
		<label class="c-choice__label" for="radio1">下架</label>
</div>
<hr />
<div>
<input class="c-choice__input" id="radio1" name="classficationID" type="radio" value="玩具">
<label class="c-choice__label" for="radio1">玩具</label>

<input class="c-choice__input" id="radio1" name="classficationID" type="radio" value="圖書">
<label class="c-choice__label" for="radio1">圖書</label>

<input class="c-choice__input" id="radio1" name="classficationID" type="radio" value="衣服">
<label class="c-choice__label" for="radio1">衣服</label>

<input class="c-choice__input" id="radio1" name="classficationID" type="radio" value="鞋子">
<label class="c-choice__label" for="radio1">鞋子</label>

<input class="c-choice__input" id="radio1" name="classficationID" type="radio" value="日用品">
<label class="c-choice__label" for="radio1">日用品</label>
</div>
<hr />
<div>
		<input class="c-choice__input" id="radio1" name="suitableAges" type="radio" value="0-3歲">
		<label class="c-choice__label" for="radio1">0-3歲</label>
		
		<input class="c-choice__input" id="radio1" name="suitableAges" type="radio" value="3-6歲">
		<label class="c-choice__label" for="radio1">3-6歲</label>
		
		<input class="c-choice__input" id="radio1" name="suitableAges" type="radio" value="6-12歲">
		<label class="c-choice__label" for="radio1">6-12歲</label>
</div>
<hr />
<div>
		<input class="c-choice__input" id="radio1" name="genderPreference" type="radio" value="男">
		<label class="c-choice__label" for="radio1">男</label>
		
		<input class="c-choice__input" id="radio1" name="genderPreference" type="radio" value="女">
		<label class="c-choice__label" for="radio1">女</label>
</div>
<hr />
<input type="hidden" value="${param.sss}" name="productID">
</form>