<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE HTML">


<html>
<head>
<title>Author's List</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/account-style.css" />

</head>
<body>

	<div class="main_container">
		<div class="header">

			<div class="container">
				<h1 class="header-heading">Your Library Account</h1>
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
		</div>

		<div class="content">
			<div class="container">
				<div class="col1">


					<table>
						<tr>
							<th>Title</th>
							<th>Publishing House</th>
							<th>Quantity</th>
							<th>Category</th>

						</tr>

						<c:forEach var="tempBook" items="${author.books}">

							<!-- construct an udpade link -->

							<tr>

								<td>${tempBook.title}</td>
								<td>${tempBook.publishingHouse}</td>
								<td>${tempBook.quantity}</td>
								<c:set var="tempCategory" value="${tempBook.category}" />
								<td>${tempCategory.name}</td>

							</tr>

						</c:forEach>
					</table>


				</div>

				<div class="col2">

					<p>
						<input type="button" value="Add Author" class="add-button"
							onclick="window.location.href='showFormForAdd'; return false;" />
					</p>
					<p>
						<a href="${pageContext.request.contextPath}/author">Author'
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