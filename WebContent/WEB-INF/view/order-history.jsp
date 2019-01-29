<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<title>Order's List</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>
<body>

	<div id="wrapper">
		<div id="header">
			<H2>Library</H2>
		</div>

	</div>



	<div id="container">



		<div id="content">



			<table>
				<tr>
					<th>Order Date</th>
					<th>When Receipt</th>
					<th>Order Status</th>
					<th>Details</th>

				</tr>

				<c:forEach var="tempOrder" items="${orders}">


					<!-- construct an udpade link -->

					<c:url var="goToDetails" value="/order/showOrderItems">
						<c:param name="orderId" value="${tempOrder.id}" />
					</c:url>


					<!--  link to books -->


					<tr>

						<td>${tempOrder.dateOrder}</td>
						<td>${tempOrder.dateReceipt}</td>
						<td>${tempOrder.status}</td>
						<td><a href="${goToDetails}">Details</a></td>

					</tr>

				</c:forEach>
			</table>


		</div>

		<p>
			<a href="${pageContext.request.contextPath}/account">Your Account
				Main Page</a>
		</p>

	</div>


</body>
</html>