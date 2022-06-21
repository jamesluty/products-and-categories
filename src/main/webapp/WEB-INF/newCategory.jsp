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
	<title>Add Category</title>
</head>
<body>
	<div class="mainWrapper">
		<div class="title">
			<h1>New Category</h1>	
		</div>
		<div class="linksDiv">
			<div>
				<a href="/">Home</a>
			</div>
		</div>
		<div>
			<form:form class="form" action="/create/category" method="post" modelAttribute="newProduct">
				<div class="formItem">
					<form:label path="name">Name: </form:label>
					<form:input path="name"/>
				</div>
				<form:errors class="errors" path="name"/>
				<div class="btnDiv">
					<button class="btn btn-primary">Add Category</button>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>