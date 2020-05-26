<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Information</title>
</head>
<body>

	<h3>Product Information</h3>
	<table cellpadding="2" cellspacing="2" border="1">
		<tr>
			<td>Id</td>
			<td>${product.id }</td>
		</tr>
		<tr>
			<td>Name</td>
			<td>${product.nom }</td>
		</tr>
		<tr>
			<td>Price</td>
			<td>${product.prix }</td>
		</tr>
		<tr>
			<td>Photo</td>
			<td>
				<c:forEach var="photo" items="${product.photos }">
					<img src="${pageContext.request.contextPath}/uploads/images/${photo }" />
				</c:forEach>
			</td>
		</tr>
	</table>

</body>
</html>