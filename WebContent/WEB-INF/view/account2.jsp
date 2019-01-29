<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">




<html>
<head>
<title>Web Library Account</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/account-style.css" />

</head>
<body>

	<div class="main_container">
		<div class="header">

			<div class="container">
				<h1 class="header-heading">Your Library Account</h1>
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
					<security:authorize access="hasRole('READER')">

						<!-- Add a link to point to /systems ... this is for the admins -->

						<p>
							<a href="${pageContext.request.contextPath}/reader/books">List
								Of Books</a>
						</p>

						<p>
							<a href="${pageContext.request.contextPath}/order/history">Order's History</a>
						</p>

					</security:authorize>

					<security:authorize access="hasRole('LIBRARIAN')">

						<!-- Add a link to point to /systems ... this is for the admins -->
						<p>
							<a href="${pageContext.request.contextPath}/order/all-orders">Manage Orders</a>

						</p>


						<p>
							<a href="${pageContext.request.contextPath}/book/list">Books
								Management Panel</a>

						</p>

					</security:authorize>
				</div>

				<div class="col2">

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
						</c:otherwise>
					</c:choose>

				</div>

			</div>
		</div>


	</div>


</body>
</html>