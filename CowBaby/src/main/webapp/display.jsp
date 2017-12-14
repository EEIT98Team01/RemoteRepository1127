<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/table.css" />
<title>Display</title>
</head>
<body>

<h3>共有${pageQuantity}筆資料</h3>

<c:if test="${not empty data}">
	<table>
		<thead>
			<tr>
				<th>Items</th>
				<th><a href="<c:url value="CustomerManagementController.controller?page=1&orderby=id" />">ID</a></th>
				<th><a href="<c:url value="CustomerManagementController.controller?page=1&orderby=name" />">Name</a></th>
				<th><a href="<c:url value="CustomerManagementController.controller?page=1&orderby=email" />">Email</a></th>
				<th><a href="<c:url value="CustomerManagementController.controller?page=1&orderby=address" />">Address</a></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="array" varStatus="st" items="${data}">
				<tr>
					<td>${st.count}</td>
					<td>${array.customerID}</td>
					<td>${array.customerName}</td>
					<td>${array.email}</td>
					<td>${array.address}</td>
					<td><td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<c:forEach var="pageNumber" begin="1" end="${pageQuantity/15+1}">
		<a href="<c:url value="CustomerManagementController.controller?page=${pageNumber}&orderby=${orderBy}" />">${pageNumber}</a>
	</c:forEach>
</c:if>

<h3><a href="<c:url value="index.jsp" />">Product Table</a></h3>
</body>
</html>