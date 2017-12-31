<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<form class="form-horizontal" role="form" id="qqq" action="${pageContext.servletContext.contextPath}/ficationControllerinsert" method="POST">

	<div class="form-group">
		<label style="padding-top: 15px;" for="firstname" class="col-md-2 col-md-offset-1 control-label">分類名稱 :</label>
		<div class="col-md-8">
			<input type="text" class="form-control" name="classficatoinName" 
				   placeholder="分類名稱">
		</div>
	</div>
	
	<div class="form-group">
		<label style="padding-top: 15px;" for="firstname" class="col-md-2 col-md-offset-1 control-label">分類描述 :</label>
		<div class="col-md-8">
			<input type="text" class="form-control" name="ClassificationDescription" 
				   placeholder="分類描述">
		</div>
	</div>
	
	
	<div class="form-group">
		<label for="firstname" class="col-md-2 col-md-offset-1 control-label">啟用狀態 :</label>
		<div class="col-md-4">
			<input class="c-choice__input" id="radio1" name="StartStopStatus" type="radio" value="true">
			<label class="c-choice__label" for="radio1" >啟用</label>

			<input class="c-choice__input" id="radio1" name="StartStopStatus" type="radio" value="false">
			<label class="c-choice__label" for="radio1" >不啟用</label>
		</div>
	</div>
	
</form>


