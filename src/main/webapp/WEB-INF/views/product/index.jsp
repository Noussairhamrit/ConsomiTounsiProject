<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Product</title>
</head>
<body>

	<h3>Add New Product</h3>
	<s:form method="post" commandName="product" enctype="multipart/form-data"
		action="product/save">
		<table>
			<tr>
				<td>Id</td>
				<td>
					<s:input path="id"/>
				</td>
			</tr>
			<tr>
				<td>Name</td>
				<td>
					<s:input path="nom"/>
				</td>
			</tr>
			<tr>
				<td>Price</td>
				<td>
					<s:input path="prix"/>
				</td>
			</tr>
			<tr>
				<td>Photo</td>
				<td>
					<input type="file" name="file"/>
				</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td>
					<input type="submit" value="Save">
				</td>
			</tr>
		</table>
	</s:form>

</body>
</html>