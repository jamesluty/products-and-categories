<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<title>Category Details</title>
</head>
<body>
	<div class="mainWrapper">
		<div class="title">
			<h1>${category.name }</h1>	
		</div>
		<div class="linksDiv">
			<div>
				<a href="/">Home</a>
			</div>
		</div>
		<div class="showBody">
			<h3>Products:</h3>
			<ul>
				<c:forEach var="product" items="${list }">
					<li>${product.name }</li>
				</c:forEach>
			</ul>
		</div>
		<div>
			<h3>Add Category:</h3>
			<form:form action="/add/product/${category.id }" method="post" modelAttribute="newCategory">
				<input type="hidden" name="_method" value="put">
				<div class="formItem">
					<form:select class="selectForm" path="id" multiple="false">
						<c:forEach var="product" items="${notList }">
							<form:option value="${product.id }">${product.name }</form:option>
						</c:forEach>
					</form:select>
				</div>
				<button class="btn btn-primary">Add Category</button>
			</form:form>
		</div>
	</div>
</body>
</html>