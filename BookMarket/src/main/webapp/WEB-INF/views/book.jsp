<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="${pageContext.request.contextPath }/resources/css/bootstrap.min.css" rel="stylesheet">
<title>유일 도서 페이지</title>
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
			<h1 class="display-3">도서 정보</h1>
		</div>
	</div>
	<div class ="container">
	<div class="row">
	<div class="col-md-12">
			<h3>${book.name }</h3>
			<p>${book.description}
			<br/>
			<p><b>도서코드: </b><span class="badge badge-info">${book.bookId}</span>
			<p><b>저자: </b>${book.author}
			<p><b>출판사: </b>${book.publisher}
			<p><b>분류: </b>${book.category}
			<p><b>출판일: </b>${book.releaseDate}
			<p><b>재고수: </b>${book.unitsInStock}
			<h4>${book.unitPrice }원</h4>
			<br>
			<p><a href="#" class="btn btn-primary">도서주문 &raquo;</a>
			<a href="<c:url value="/books"/>"
			class="btn btn-secondary">도서목록 &raquo;</a>
	</div>
	</div>
	<hr>
	<footer> <p>&copy; Book INFO</p> </footer>
	</div>




</body>
</html>