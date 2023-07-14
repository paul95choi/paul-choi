<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page
	import="java.sql.*, javax.sql.*, java.io.*, java.net.*, java.util.*"%>
<%@ page import="java.text.*,java.time.*,java.time.format.*"%>

<%@ page import="Stock_dao.*"%>
<%@ page import="Stock_domain.*"%>
<%@ page import="Stock_dto.*"%>
<%@ page import="Stock_service.*"%>

<html>
<head>
<title>stock_list.jsp</title>
<style>
.container {
      margin-top : 10px;
      display: flex;
      justify-content: flex-end;
   }

</style>
</head>
<body>
	<%
	Calendar cdr = Calendar.getInstance();
	SimpleDateFormat sdt = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
	LocalDateTime now = LocalDateTime.now();
	String formattedDate = sdt.format(cdr.getTime());
	%>


	<table  width=100% align=center border=2>
	<h1><p align=center>Paul's 물산 재고현황</p></h1>
		<tr>
			<td width=50><p align=center>상품번호</p></td>
			<td width=100><p align=center>상품명</p></td>
			<td width=80><p align=center>현재상품수량</p></td>
			<td width=100><p align=center>재고파악일</p></td>
			<td width=100><p align=center>상품등록일</p></td>
		</tr>

		<%
		Stock_Dao stockDao = new Stock_Dao_Impl();
		Stock_Service stockService = new Stock_ServiceImpl();

		int firstpage = 1; // Default page
		int countPerPage = 10;

		//URL의 쿼리 문자열(query string)에서 'page' 파라미터를 받아오는 역할
		//웹 브라우저의 주소 표시줄에 http://yourwebsite.com/yourpage.jsp?page=2와 같이 입력되어 있다면, 'page' 파라미터의 값은 '2'
		//사용자가 요청한 페이지 번호. URL의 'page' 파라미터로 부터 가져옴.
		String paramPage = request.getParameter("page");
		//'page' 파라미터가 없을 경우 (즉, 사용자가 특정 페이지를 요청하지 않았을 경우), 기본 페이지 번호로 '1'을 설정하며,
		//비어있지 않다면 firstpage를 'page'파라미터에서 받아온 값으로 설정
		if (paramPage != null) {
			//이 값은 문자열 형태로 반환되기 때문에, 페이지 번호로 사용하기 위해 Integer.parseInt() 메소드를 사용하여 정수로 변환
			firstpage = Integer.parseInt(paramPage);
		}

		// 아래 코드 추가: 서비스로부터 Pagination 객체 받아오기
		Pagination pagination = stockService.getPagination(firstpage, countPerPage);

		int currentPage = pagination.getC();
		int startPage = pagination.getS();
		int endPage = pagination.getE();
		
		
		List<Stock> results = stockDao.selectAll(currentPage, countPerPage);
		//만약 리스트가 비어있다면 데이터가 없음을 보준다.
		if (results == null || results.isEmpty()) {
			out.println("<tr>");
			out.println("<td colspan='8'><p align='center'>데이터가 없습니다.</p></td>");
			out.println("</tr>");
		} else {//리스트가 비어있지 않다면 

			//scores리스트에 있는 값을 studentScore객체로 하나씩 이동하면서 테이블 행을 출력함
			for (Stock stock : results) {

				out.println("<tr>"); // 테이블의 내용행을 설정
				out.println("<td width=50><p align=center>" + stock.getId() + "</p></td>"); //행을 반복 출력
				out.println("<td width=100><p align=center><a href='stock_view.jsp?key=" + stock.getId() + "'>"
				+ stock.getTitle() + "</a></p></td>"); //행을 반복 출력
				out.println("<td width='80'><p align='center'>" + stock.getAmount() + "</p></td>"); // 현재 재고수 출력
	            out.println("<td width='100'><p align='center'>" + stock.getCreateDate() + "</p></td>"); // 상품등록일 출력
	            out.println("<td width='100'><p align='center'>" + stock.getDate() + "</p></td>"); // 재고파악일 출력
				out.println("</tr>");

			}
		}
		if (!(results == null)) {
		%>
	</table>
	<div class="no-underline" style="width: 100%; text-align: center; margin-top:10px"> <!-- 페이지부분 사이즈 -->
		<%
		// Pagination 부분
		// << 링크
		if (pagination.getPp() != -1) {
			out.print("<a href='?page=" + pagination.getPp() + "'>" + "&lt;&lt;" + "</a> ");
		}

		// < 링크
		if (pagination.getP() != -1) {
			out.print("<a href='?page=" + pagination.getP() + "'>" + "&lt;" + "</a> ");
		}

		// 페이지 링크 출력
		for (int i = startPage; i <= endPage; i++) {
			if (i == currentPage) {
				out.print("<span style='color: red;'>" + " " + i + " " + "</span>");
			} else {
				out.print("<a href='?page=" + i + "'>" + " " + i + " " + "</a> ");
			}
		}
		
		// > 링크
		if (pagination.getN() != -1) {
			out.print("<a href='?page=" + pagination.getN() + "'>" + "&gt;" + "</a> ");
		}

		// >> 링크
		if (pagination.getNn() != -1) {
			out.print("<a href='?page=" + pagination.getNn() + "'>" + "&gt;&gt;" + "</a> ");
		}
		%>

		<%
		}
		%>
	</div>
	</table>

	<div class="container">
		<button OnClick="location.href='stock_insert.jsp'">신규상품등록</button>	
	</div>
	<!-- ////////////////////////////// -->
</body>
</html>



