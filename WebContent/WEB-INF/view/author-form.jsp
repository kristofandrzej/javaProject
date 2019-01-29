<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE HTML">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Author</title>


<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/form-style.css" />
</head>
<body>

	<div class="main_container">
		<div class="header">

			<div class="container">
				<h1 class="header-heading">Update Author Data</h1>
			</div>
		</div>

			<div class="nav-bar">
				<div class="container">
					<ul class="nav">
						<li>You are logged in as <security:authentication
								property="principal.username" />
						</li>
						<li>Your current role(s): <security:authentication
								property="principal.authorities" /></li>
						<li><form:form
								action="${pageContext.request.contextPath}/logout" method="POST">
								<input class="header_btn" type="submit" value="logout" />
							</form:form></li>
					</ul>
				</div>
			
		</div>


		<div class="content">
			<div class="container">
				<div class="col1">


					<form:form action="saveAuthor" modelAttribute="author"
						method="POST">

						<!-- need to associate this data with customer -->

						<form:hidden path="id" />

						<table class="table_form">

							<tbody>

								<tr>
									<td><label>First Name:</label></td>
									<td><form:input path="firstName" /></td>
								</tr>

								<tr>
									<td><label>Last Name:</label></td>
									<td><form:input path="lastName" /></td>
								</tr>

								<tr>
									<td><label></label></td>
									<td><input id="save_input" type="submit" value="Save" class="save" /></td>
								</tr>

							</tbody>

						</table>

					</form:form>


				</div>

				<div class="col2">

					<p>
						<input type="button" value="Add Author" class="add-button"
							onclick="window.location.href='showFormForAdd'; return false;" />
					</p>
					<p>
						<a href="${pageContext.request.contextPath}/author">Authors
							List</a>
					</p>
					<p>
						<a href="${pageContext.request.contextPath}/account">Your
							Account Main Page</a>
					</p>

				</div>

			</div>
		</div>


	</div>


</body>
</html>