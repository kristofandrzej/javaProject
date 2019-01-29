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
	href="${pageContext.request.contextPath}/resources/css/offStyle.css" />

</head>

<body>

	<div id="logo">
		<h1>Web Library System- Order your favourite books</h1>
	</div>


		<div id="menu">
		<ul>
			<security:authorize var="loggedIn" access="isAuthenticated()" />
			<c:choose>
				<c:when test="${loggedIn}">
					<li accesskey="1" title=""><a>Home</a></li>
					<li accesskey="2" title="">You are logged in as <security:authentication
							property="principal.username" /></li>
					<form:form action="${pageContext.request.contextPath}/logout"
						method="POST">
						<li accesskey="3" title=""><input type="submit"
							value="logout" /></li>
					</form:form>
				</c:when>
				<c:otherwise>
					<li class="active" accesskey="1" title=""><a>Home</a></li>
					<li accesskey="2" title=""><a
						href="${pageContext.request.contextPath}/register">Register</a></li>
					<li accesskey="3" title=""><a
						href="${pageContext.request.contextPath}/showMyLoginPage">Log
							In</a></li>
					<li class="infoLog" accesskey="4" title=""><a>You are not
							logged in</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
		<hr />
	</div>



	<div class="main_container">





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
							<th>Order</th>


						</tr>

						<c:forEach var="tempBook" items="${books}">



							<c:url var="addToCart" value="/reader/addToCart">
								<c:param name="bookId" value="${tempBook.id}" />
							</c:url>


							<tr>

								<td>${tempBook.title}</td>
								<td>${tempBook.publishingHouse}</td>
								<td>${tempBook.datepublish}</td>
								<c:set var="tempAuthor" value="${tempBook.author}" />
								<td>${tempAuthor.firstName}${' '}${tempAuthor.lastName}</td>
								<c:set var="tempCategory" value="${tempBook.category}" />
								<td>${tempCategory.name}</td>
								<c:set var="tempQuantity" value="${tempBook.quantity}" />
								<c:choose>
									<c:when test="${tempQuantity gt 0}">
										<td><a href="${addToCart}">Order</a></td>
									</c:when>
									<c:otherwise>
										<td>Not Available Now</td>
									</c:otherwise>
								</c:choose>

							</tr>

						</c:forEach>
					</table>



				</div>


				<div class="col3">
					<c:set var="checkBooks" value="${choosenBooks}" />
					<c:choose>
						<c:when test="${empty checkBooks}">
							<p>Your order cart is empty now</p>
						</c:when>
						<c:otherwise>
							<p>Your order cart:</p>
							<ul>
								<c:forEach var="choosenBook" items="${choosenBooks}">
									<c:url var="deleteBook" value="/reader/removeFromCart">
										<c:param name="choosenBookId" value="${choosenBook.id}" />
									</c:url>
									<li><b>${choosenBook.title}</b><br> <a
										href="${deleteBook}">Delete </a></li>
								</c:forEach>
							</ul>
							<p><a href="${pageContext.request.contextPath}/orderingCart">Go to Ordering Cart</a></p>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>


	</div>


</body>

</html>