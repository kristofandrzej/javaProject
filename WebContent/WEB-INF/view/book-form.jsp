<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Author</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />
</head>
<body>

	<div id="wrapper">

		<div id="header">

			<h2>Book form</h2>

		</div>

	</div>

	<div id="container">

		<h3>Save Book</h3>

		<form:form action="saveBook" modelAttribute="book" method="POST">

			<!-- need to associate this data with customer -->

			<form:hidden path="id" />

			<table>

				<tbody>

					<tr>
						<td><label>Title:</label></td>
						<td><form:input path="title" /><form:errors path="title" cssClass="error"/></td>
					</tr>

					<tr>
						<td><label>Publishing House:</label></td>
						<td><form:input path="publishingHouse" /><form:errors path="publishingHouse" cssClass="error"/></td>
					</tr>
					<tr>
						<td><label>Description:</label></td>
						<td><form:input path="description" /></td>
					</tr>
					<tr>
						<td><label>Publish date:</label></td>
						<td><form:input path="datepublish" /><form:errors path="datepublish" cssClass="error"/></td>
					</tr>
					<tr>
						<td><label>Author:</label></td>
						
						<td><form:select path="author">

								<form:option value="" label="--Please Select" />
								<form:options items="${authors}" itemValue="id"
									itemLabel="fullName"/>

							</form:select></td>

						</td>
					</tr>
										<tr>
						<td><label>Category:</label></td>
						
						<td><form:select path="category">

								<form:option value="" label="--Please Select" />
								<form:options items="${categories}" itemValue="id"
									itemLabel="name" />

							</form:select></td>

						</td>
					</tr>

				<tr>
						<td><label>Quantity:</label></td>
						<td><form:input path="quantity" /><form:errors path="quantity" cssClass="error"/></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

				</tbody>

			</table>

		</form:form>

		<div style=""></div>

		<p>
			<a href="${pageContext.request.contextPath}/book/list">Back to
				List</a>
		</p>

	</div>


</body>
</html>