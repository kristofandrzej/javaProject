<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>




<html>
<head>
<title>Web Library Account</title>

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
					<li accesskey="1" title=""><a
						href="${pageContext.request.contextPath}/index">Home</a></li>
					<form:form action="${pageContext.request.contextPath}/logout"
						method="POST">
						<li accesskey="2" title="">
							<a><button type="submit" value="logout" class="btn-link">Logout</button></a>
						</li>
					</form:form>
					<li  class="infoLog" accesskey="3" title=""><a>Logged as <security:authentication
							property="principal.username" /></a></li>
				</c:when>
				<c:otherwise>
					<li class="active" accesskey="1" title=""><a
						href="${pageContext.request.contextPath}/">Home</a></li>
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

	<div id="bg">
		<div id="page">
			<div id="content">
				<div id="about" class="post">
					<h1 class="title">
						Welcome,
						<security:authentication property="principal.username" />
					</h1>
					<div class="entry">
						<p>
							Your current role:
							<security:authentication property="principal.authorities" />
						</p>

					</div>

					<div class="post">
						<h2 class="title">Available menu options</h2>
						<div class="entry">
							<security:authorize access="hasRole('READER')">

								<!-- Add a link to point to /systems ... this is for the admins -->

								<p>
									<a href="${pageContext.request.contextPath}/reader/books">List
										Of Books</a>
								</p>

								<p>
									<a href="${pageContext.request.contextPath}/order/history">Order's
										History</a>
								</p>

							</security:authorize>

							<security:authorize access="hasRole('LIBRARIAN')">

								<!-- Add a link to point to /systems ... this is for the admins -->
								<p>
									<a href="${pageContext.request.contextPath}/order/all-orders">Manage
										Orders</a>

								</p>


								<p>
									<a href="${pageContext.request.contextPath}/book/list">Books
										Management Panel</a>

								</p>

							</security:authorize>
						</div>
					</div>
				</div>
			</div>

			<!--   ------------------------------------------------------------------------- -->


			<div id="sidebar">
				<div id="useful-links" class="box">

					<h2 class="title">Go To:</h2>

					<div class="content">
						<ul>
							<li><a href="reader/books"><strong>Check
										Library's books</strong></a></li>
						</ul>
					</div>

				</div>


				<div id="sponsors" class="box">
					<h2 class="title">The Order Cart</h2>
					<c:set var="checkBooks" value="${choosenBooks}" />
					<c:choose>
						<c:when test="${empty checkBooks}">
							<ul>
								<li class="singleLi">Your order cart is empty now</li>
							</ul>
						</c:when>
						<c:otherwise>
							<div class="content">
								<ul>
									<c:forEach var="choosenBook" items="${choosenBooks}">
										<c:url var="deleteBook" value="/reader/removeFromCart">
											<c:param name="choosenBookId" value="${choosenBook.id}" />
										</c:url>
										<li><b>${choosenBook.title}</b><br> <a
											href="${deleteBook}">Delete </a></li>
									</c:forEach>
								</ul>

								<c:choose>
									<c:when test="${loggedIn}">
										<p>
											<a href="${pageContext.request.contextPath}/orderingCart">Go
												to Ordering Cart</a>
										</p>
									</c:when>
									<c:otherwise>
										<p>
											You need to be logged in to go to the order cart. Please <a
												href="${pageContext.request.contextPath}/showMyLoginPage">Log
												In</a>
										</p>

									</c:otherwise>
								</c:choose>



							</div>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>
	</div>

</body>
</html>