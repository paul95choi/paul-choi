<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head><!-- img 부분에도 "${pageContext.request.contextPath } 붙여줘야함-->
<link href="${pageContext.request.contextPath }/resources/css/bootstrap.min.css" rel="stylesheet">
<meta charset="EUC-KR">
<title>Welcome</title>
</head>
<body>
	<nav class="navbar navbar-expand navbar-dark bg-dark">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="./home">Home</a> 
				<a class="navbar-brand" href="./books">도서목록</a> 
				<a class="navbar-brand"	href="./home">게시판</a>
			</div>
		</div>
	</nav>

	<div class="jumbotron">
		<div class="jcontainer">
			<h1 class="display-3">도서 목록</h1>
		</div>
	</div>

	<div class="container">
		<div class="row" align="center">
			
			
			<c:forEach items= "${bookList}" var="book">
				<div class="col-md-4">
				<!--  <p><img src=./resources/img/${webtoon.imagPath }></p>-->
					<h3>${book.name}</h3>
					<p>${book.author} 
					<br> ${book.publisher } | ${book.unitPrice}원
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