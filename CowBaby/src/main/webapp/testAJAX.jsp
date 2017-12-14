<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>
	<table id="simpleTable" class="table table-bordered table-hover">
		<thead>
			<tr>
				<th>Items</th>
				<th>ID</th>
				<th>Name</th>
				<th>Email</th>
				<th>Address</th>
			</tr>
		</thead>
	</table>

	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script>
		$(function(){
			var count = 1;
			$.getJSON('<c:url value="service/getCustomerData"/>',{},function(datas){
			     $.each(datas,function(idx,product){
				    	 var cell1 = $("<td></td>").text(count);
				    	 var cell2 = $("<td></td>").text(product.customerID);
				    	 var cell3 = $("<td></td>").text(product.customerName);
				    	 var cell4 = $("<td></td>").text(product.email);
				    	 var cell5 = $("<td></td>").text(product.address);
				    	 var row = $("<tr></tr>").append([cell1,cell2,cell3,cell4,cell5]);
				    	 $('table').append(row);
				    	 count = count + 1;
			     });
		   });
		});
	</script>
</body>
</html>