<%@ page isELIgnored="false" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product ADD DELETE UPDATE</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet"/>
<script type="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

	
</head>
<body>
	<h1>PRODUCT:    Add,  Delete,  Update</h1>
	<c:url value="/product/register" var="registerUrl" />
	<form action="${registerUrl}" method="post">
		<table class="table table-hover">
			<c:if test="${product.id ne null}">
				<tr>
				<td>Product ID:</td>
					<td><input type="text" name="id" value="${product.id}" readonly="readonly"></td>
				</tr>
			</c:if>
			<tr>
				<td>Product Name:</td>
				<td><input type="text" name="product_name" value="${product.product_name}" required></td>
			</tr>
			<tr>
				<td>Product Symbol:</td>
				<td><input type="text" name="product_symbol" value="${product.product_symbol}" required></td>
			</tr>
			
			
				<tr>
					<td colspan="2"><input type="submit" value="Save"></td>
				</tr>
			
		</table>
	</form>
	<br>
	<h1>List of products</h1>
	<table class="table table-striped">
		<tr>
			<th>ID</th>
			<th>Product Name</th>
			<th>Product Symbol</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${productList}" var="product">
			<tr>
				<td>${product.id}</td>
				<td>${product.product_name}</td>
				<td>${product.product_symbol}</td>
				
				
				<td>
					<form action="<c:url value="/product/update"/>" method="post">
						<input type="hidden" name="product_Id" value="${product.id}">
						
						<input type="submit" value="Update">
					</form>
				</td>
				<td>
					<form action="<c:url value="/product/delete"/>" method="post">
						<input type="hidden" name="product_Id" value="${product.id}">
						
						<input style="background: #F00;" type="submit" value="Delete">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>