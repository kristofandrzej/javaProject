<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<title>Categories's List</title>

	<link type="text/css"
		  rel="stylesheet"
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
		
			<input type="button" value="Add Category" class="add-button"
			 onclick="window.location.href='showFormForAdd'; return false;"/>
			 


			<table>
				<tr>
					<th>Category Name</th>
					<th>Action</th>

				</tr>

				<c:forEach var="tempCategory" items="${categories}">
				
				
				<!-- construct an udpade link -->
				
				<c:url var="updateLink" value="/category/showFormForUpdate">
					<c:param name="categoryId" value="${tempCategory.id}"/>
				</c:url>
				
								<!-- construct an delete link -->
				
				<c:url var="deleteLink" value="/category/delete">
					<c:param name="categoryId" value="${tempCategory.id}"/>
				</c:url>
				
					<tr>

						<td>${tempCategory.name}</td>
						<td>
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}" onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
						</td>

					</tr>

				</c:forEach>
			</table>


		</div>

	</div>


</body>
</html>