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
	<title>Products and Categories</title>
</head>
<body>
	<div class="mainWrapper">
		<div class="title">
			<h1>Home Page</h1>	
		</div>
		<div class="linksDiv">
			<div>
				<a href="/product/new">New Product</a>
			</div>
			<div>
				<a href="/category/new">New Category</a>
			</div>
		</div>
		<div class="displayDiv">
			<div class="productList">
				<div class="header">
					<h3>Products</h3>
				</div>
				<div class="list">
					<ul>
						<c:forEach var="product" items="${allProducts }">
							<li><a href="/product/show/${product.id}">${product.name }</a></li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<div class="categoryList">
				<div class="header">
					<h3>Categories</h3>
				</div>
				<div class="list">
					<ul>
						<c:forEach var="category" items="${allCategories }">
							<li><a href="category/show/${category.id}">${category.name }</a></li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
	</div>
</body>
</html>