<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<p>請選則要處理的狀態</p>
<form class="seller_audit_popupForm">
	<input class="c-choice__input" name="applicationState" type="radio" value="1" checked="checked">
	<label class="c-choice__label" >審核中</label>

	<input class="c-choice__input" name="applicationState" type="radio" value="2">
	<label class="c-choice__label" >審核通過</label>
	
	<input class="c-choice__input" name="applicationState" type="radio" value="3">
	<label class="c-choice__label">審核通不通過</label>
	
	<hr/>
	
	<div style="text-align: left;">	
	    <label for="exampleFormControlTextarea1">客服回覆:</label>
		<textarea class="form-control" rows="3"  name="applicationDescription"></textarea>        	
	</div>
</form>

