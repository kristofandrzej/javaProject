<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE HTML">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register in Web Library</title>


<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/form-style.css" />
</head>
<body>

	<div class="main_container">
		<div class="header">

			<div class="container">
				<h1 class="header-heading">Fill all necessary fields to create
					your account</h1>
			</div>
		</div>

		<div class="nav-bar">
			<div class="container">
				<ul class="nav">

				</ul>
			</div>

		</div>


		<div class="content">
			<div class="container">
				<div class="col1">

					<table>
						<tbody>
							<form:form action="registerUser" modelAttribute="user" method="POST">
								<tr>
									<td><label>Login:</label></td>
									<td><form:input path="login" /> <form:errors path="login"
											cssClass="error" /></td>
								</tr>
								<tr>
									<td><label>Password:</label></td>
									<td><form:input path="password" /> <form:errors
											path="password" cssClass="error" /></td>
								</tr>
								<tr>
									<td><label>Confirm Pasword:</label></td>
									<td><form:input path="passwordConfirmed" /> <form:errors
											path="passwordConfirmed" cssClass="error" /></td>
								</tr>


								<form:form modelAttribute="reader"	method="POST">
									<tr>
										<td><label>First Name:</label></td>
										<td><form:input path="firstName" /> <form:errors
												path="firstName" cssClass="error" /></td>
									</tr>
									<tr>
										<td><label>Last Name:</label></td>
										<td><form:input path="lastName" /> <form:errors
												path="lastName" cssClass="error" /></td>
									</tr>
									<tr>
										<td><label>Address:</label></td>
										<td><form:input path="address" /> <form:errors
												path="address" cssClass="error" /></td>
									</tr>
									<tr>
										<td><label>City:</label></td>
										<td><form:input path="city" /> <form:errors path="city"
												cssClass="error" /></td>
									</tr>
									<tr>
										<td><label>Zip-Code:</label></td>
										<td><form:input path="zipCode" /> <form:errors
												path="zipCode" cssClass="error" /></td>
									</tr>
									<tr>
										<td><label>Email:</label></td>
										<td><form:input path="email" /> <form:errors
												path="email" cssClass="error" /></td>
									</tr>
									<tr>
										<td><label>Phone Number:</label></td>
										<td><form:input path="phoneNumber" /> <form:errors
												path="phoneNumber" cssClass="error" /></td>
									</tr>

								
								
								<input type="submit"  value="submit to">
								
								</form:form>
								
								

							</form:form>
							
							

						</tbody>

					</table>


				</div>

				<div class="col2"></div>

			</div>
		</div>


	</div>


</body>
</html>