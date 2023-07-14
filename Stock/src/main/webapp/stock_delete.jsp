<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, javax.sql.*, java.io.*, java.net.*, java.util.*"%>

<%@ page import="Stock_dao.*"%>
<%@ page import="Stock_domain.*"%>
<%@ page import="Stock_dto.*"%>
<%@ page import="Stock_service.*"%>


<html>
<head>
<title>stock_delete</title>
</head>
<body>
<%

Stock_Dao stockDao = new Stock_Dao_Impl();
Stock_Service stockService = new Stock_ServiceImpl();
Stock stock = new Stock();

String key = request.getParameter("key");

stockDao.delete(Integer.parseInt(key), stock);

%>

<h2>상품 삭제 완료</h2>
	<table width="650">
		<tr>
			<td width="650"></td>
			<td>
				<input type="button" value="목록" onclick="location.href='stock_list.jsp'">
			</td>
		</tr>
	</table>

</body>
</html>