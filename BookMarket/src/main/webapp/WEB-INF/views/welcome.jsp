<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<link href="./resources/css/bootstrap.min.css" rel="stylesheet">
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
			<h1 class="display-3">${hello}</h1>
		</div>
	</div>

	<div class="container">
		<div class="text-center">
			<h3>${strapline}</h3>
		</div>
	</div>

	<footer class="container">
		<hr>
		<p>&copy; Book</p>
	</footer>
</body>
</html>