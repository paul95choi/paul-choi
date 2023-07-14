<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, javax.sql.*, java.io.*, java.net.*, java.util.*"%>

<%@ page import="Stock_dao.*"%>
<%@ page import="Stock_domain.*"%>
<%@ page import="Stock_dto.*"%>
<%@ page import="Stock_service.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	//id, stock
	int id = Integer.parseInt(request.getParameter("key"));
	int Cnt = Integer.parseInt(request.getParameter("amount"));
	
	Stock stock = new Stock();
	stock.setAmount(Cnt);
	Stock_Dao stockdao = new Stock_Dao_Impl();
	stockdao.update(id, stock);
	
	String name = request.getParameter("titles");
	String namehan = new String(name.getBytes("8859_1"), "utf-8");
%>
	
	<div style="text-align : center;">
		<h1>[<%=namehan %>]상품이 수정되었습니다.</h1>
	</div>
	<hr>
	<button onclick="location.href = 'stock_list.jsp';">목록</button>
	
</body>
</html>