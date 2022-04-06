<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Save Customer</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>Book Listing</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Book</h3>
	
		<form:form action="saveBook" modelAttribute="book" method="POST">

			<!-- need to associate this data with customer id -->
			<form:hidden path="bookCode" />
					
			<table>
				<tbody>
					<tr>
						<td><label>Book Code:</label></td>
						<td><form:input path="bookCode" /></td>
					</tr>
				
					<tr>
						<td><label>Book name:</label></td>
						<td><form:input path="bookName" /></td>
					</tr>

					<tr>
						<td><label>Author:</label></td>
						<td><form:input path="author" /></td>
					</tr>
					<tr>
						<td><label>Email:</label></td>
						<td><form:input path="email" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/book/list">Back to List</a>
		</p>
	
	</div>

</body>

</html>










