<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head><!-- img �κп��� "${pageContext.request.contextPath } �ٿ������-->
<link href="${pageContext.request.contextPath }/resources/css/bootstrap.min.css" rel="stylesheet">
<meta charset="EUC-KR">
<title>Welcome</title>
</head>
<body>
	<nav class="navbar navbar-expand navbar-dark bg-dark">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="./home">Home</a> 
				<a class="navbar-brand" href="./books">�������</a> 
				<a class="navbar-brand"	href="./home">�Խ���</a>
			</div>
		</div>
	</nav>

	<div class="jumbotron">
		<div class="jcontainer">
			<h1 class="display-3">���� ���</h1>
		</div>
	</div>

	<div class="container">
		<div class="row" align="center">
			
			
			<c:forEach items= "${bookList}" var="book">
				<div class="col-md-4">
				<!--  <p><img src=./resources/img/${webtoon.imagPath }></p>-->
					<h3>${book.name}</h3>
					<p>${book.author} 
					<br> ${book.publisher } | ${book.unitPrice}��
					<p align=Left>${fn:substring(book.description,0, 50)}... 
					<p>${book.releaseDate }
				</div>
			</c:forEach>
		</div>
	</div>

	<footer class="container">
		<hr>
		<p>&copy; Book</p>
	</footer>
</body>
</html>