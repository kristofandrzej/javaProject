<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<html>

<head>

<title>Web Library System- Order your favourite books</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/main-style.css" />

</head>

<body>
	<div class="main_container">

		<div class="header">
			<div class="container">
				<h1 class="header-heading">Web Library System- Order your
					favourite books</h1>
			</div>
		</div>
		<div class="nav-bar">
			<div class="container">
				<ul class="nav">
					<security:authorize var="loggedIn" access="isAuthenticated()" />
					<c:choose>
						<c:when test="${loggedIn}">
							<li>You are logged in as <security:authentication
									property="principal.username" /></li>
							<form:form action="${pageContext.request.contextPath}/logout"
								method="POST">
								<li><input class="header_btn" type="submit" value="logout" /></li>
							</form:form>
							<li><a class="header_btn"
								href="${pageContext.request.contextPath}/">Home</a></li>
							<%-- 					<security:authentication var="userId"
								property="principal.username" />
							<input type="hidden" name="userLogin" value="${userId}" /> --%>
						</c:when>
						<c:otherwise>
							<li>You are not logged in.</li>
							<li><a class="header_btn"
								href="${pageContext.request.contextPath}/account">Register</a>
							<li>
							<li><a class="header_btn"
								href="${pageContext.request.contextPath}/account">Log In</a></li>
							<li><a class="header_btn"
								href="${pageContext.request.contextPath}/">Home</a></li>
						</c:otherwise>
					</c:choose>

				</ul>
			</div>
		</div>


		<div class="content">
			<div class="container">
				<div class="col1">
					<a href="reader/books">Display list of books</a>
				</div>

				<div class="col2">
					<table>
						<tr>
							<th>Title</th>
							<th>Publishing House</th>
							<th>Date Publishing</th>
							<th>Author</th>
							<th>Category</th>
							<th>Action</th>


						</tr>

						<c:forEach var="choosenBook" items="${choosenBooks}">



							<c:url var="addToCart" value="/reader/addToCart">
								<c:param name="bookId" value="${tempBook.id}" />
							</c:url>


							<tr>

								<td>${choosenBook.title}</td>
								<td>${choosenBook.publishingHouse}</td>
								<td>${choosenBook.datepublish}</td>
								<c:set var="tempAuthor" value="${choosenBook.author}" />
								<td>${tempAuthor.firstName}${' '}${tempAuthor.lastName}</td>
								<c:set var="tempCategory" value="${choosenBook.category}" />
								<td>${tempCategory.name}</td>
								<c:url var="deleteBook" value="/orderingCart/removeFromCart">
									<c:param name="choosenBookId" value="${choosenBook.id}" />
								</c:url>
								<td><a href="${deleteBook}">Delete </a></td>

							</tr>

						</c:forEach>
					</table>



				</div>


				<div class="col3">
					<p>
						<c:url var="makeOrder" value="/orderingCart/orderBooks">
							<security:authentication var="userId"
								property="principal.username" />
							<c:param name="userLogin" value="${userId}" />
						</c:url>

						<a class="add-button" href="${makeOrder}">Send your order</a>

					</p>
				</div>
			</div>
		</div>


	</div>


</body>

</html>