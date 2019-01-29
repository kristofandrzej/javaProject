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
				<h1 class="header-heading">Your Library Account - Authors List</h1>
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


					<table>
						<tr>
							<th>Author First Name</th>
							<th>Author Last Name</th>
							<th>Books</th>
							<th>Action</th>

						</tr>

						<c:forEach var="tempAuthor" items="${authors}">


							<!-- construct an udpade link -->

							<c:url var="updateLink" value="/author/showFormForUpdate">
								<c:param name="authorId" value="${tempAuthor.id}" />
							</c:url>

							<!-- construct an delete link -->

							<c:url var="deleteLink" value="/author/delete">
								<c:param name="authorId" value="${tempAuthor.id}" />
							</c:url>

							<!--  link to books -->

							<c:url var="booksLink" value="/author/books">
								<c:param name="authorId" value="${tempAuthor.id}" />
							</c:url>

							<tr>

								<td>${tempAuthor.firstName}</td>
								<td>${tempAuthor.lastName}</td>
								<td><a href="${booksLink}">Books written </a></td>
								<td><a href="${updateLink}">Update</a> | <a
									href="${deleteLink}"
									onclick="if (!(confirm('Are you sure you want to delete this author?'))) return false">Delete</a>
								</td>

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
						<a href="${pageContext.request.contextPath}/account">Your
							Account Main Page</a>
					</p>

				</div>

			</div>
		</div>


	</div>



</body>
</html>