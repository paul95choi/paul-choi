<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, javax.sql.*, java.io.*, java.net.*, java.util.*"%>

<%@ page import="Web_Board_dao.*"%>
<%@ page import="Web_Board_domain.*"%>
<%@ page import="Web_Board_dto.*"%>
<%@ page import="Web_Board_service.*"%>
<html>
<head>
<title>gongji_write.jsp</title>
</head>
<body>
<%
request.setCharacterEncoding("UTF-8"); // 요청 문자 인코딩을 UTF-8로 설정

	String id = request.getParameter("id");  // 요청에서 "id" 파라미터 값을 가져와서 변수에 저장합니다.
	String title = request.getParameter("title");  // 요청에서 "title" 파라미터 값을 가져와서 변수에 저장합니다.
	String date = request.getParameter("date");  // 요청에서 "date" 파라미터 값을 가져와서 변수에 저장합니다.
	String content = request.getParameter("content");  // 요청에서 "content" 파라미터 값을 가져와서 변수에 저장합니다.
	
	Web_Board_Dao webBoardDao = new Web_Board_Dao_Impl();  // Web_Board_Dao 객체를 생성합니다.
	Web_Board_Service webBoardService = new Web_Board_ServiceImpl();  // Web_Board_Service 객체를 생성합니다.
	Web_Board webBoard = new Web_Board();  // Web_Board 객체를 생성합니다.
	
	webBoard.setTitle(title);  // Web_Board 객체의 제목을 설정합니다.
	webBoard.setContent(content);  // Web_Board 객체의 내용을 설정합니다.
	
	String key = request.getParameter("key");  // 요청에서 "key" 파라미터 값을 가져와서 변수에 저장합니다.
	String idsUpdate = request.getParameter("ids");  // 요청에서 "ids" 파라미터 값을 가져와서 변수에 저장합니다.
	String titlesUpdate = request.getParameter("titles");  // 요청에서 "titles" 파라미터 값을 가져와서 변수에 저장합니다.
	String datesUpdate = request.getParameter("dates");  // 요청에서 "dates" 파라미터 값을 가져와서 변수에 저장합니다.
	String contentsUpdate = request.getParameter("contents");  // 요청에서 "contents" 파라미터 값을 가져와서 변수에 저장합니다.
	
	Web_Board webBoardUpdate = new Web_Board();  // Web_Board 객체를 생성합니다.
	webBoardUpdate.setTitle(titlesUpdate);  // Web_Board 객체의 제목을 설정합니다.
	webBoardUpdate.setDate(datesUpdate);  // Web_Board 객체의 날짜를 설정합니다.
	webBoardUpdate.setContent(contentsUpdate);  // Web_Board 객체의 내용을 설정합니다.
	
	int maxCount = 0;  // 최대 카운트 값을 저장할 변수를 초기화합니다.
	if (key == null) {  // "key" 파라미터가 없는 경우
	    webBoardDao.write(webBoard);  // Web_Board_Dao를 사용하여 게시글을 작성합니다.
	    maxCount = webBoardDao.maxCount();  // 최대 카운트 값을 구합니다.
	
%>		 
	<!-- write 처리 후 결과 화면 -->
	<h2>게시물 작성 완료</h2>
	
	<form method="post" action="gongji_write.jsp">
	<!-- 원래의 폼 내용 -->
	<table width="650" border="1" cellspacing="0" cellpadding="5">
		<tr>
			<td><b>번호</b></td>
			<td><%= maxCount %></td>
		</tr>
		<tr>
			<td><b>제목</b></td>
			<td><%= title %></td>
		</tr>
		<tr>
			<td><b>일자</b></td>
			<td><%= date %></td>
		</tr>
		<tr>
			<td><b>내용</b></td>
			<td>
				<textarea style="width: 500px; height: 250px;" name="content" cols="70" rows="600"><%= content %></textarea>
			</td>
		</tr>
	</table>
		<table width="650">
		<tr>
			<td width="650"></td>
			<td>
				<input type="button" value="수정" onclick="location.href='gongji_update.jsp?key=<%= maxCount %>'">
			</td>
			<td>
				<input type="button" value="목록" onclick="location.href='gongji_list.jsp'">
			</td>
			<td>
				<input type="button" value="삭제" onclick="location.href='gongji_delete.jsp?key=<%= id %>'">
			</td>
		</tr>
	</table>
		
<%
	} else {
		webBoardDao.update(Integer.parseInt(key), webBoardUpdate);// Web_Board_Dao를 사용하여 게시글을 업데이트합니다.
%>
	<!-- update 처리 후 결과 화면 -->
	<h2>게시물 수정 완료</h2>
	
	<form method="post" action="gongji_write.jsp">
	<!-- 원래의 폼 내용 -->
	<table width="650" border="1" cellspacing="0" cellpadding="5">
		<tr>
			<td><b>번호</b></td>
			<td><%= idsUpdate %></td>
		</tr>
		<tr>
			<td><b>제목</b></td>
			<td><%= titlesUpdate %></td>
		</tr>
		<tr>
			<td><b>일자</b></td>
			<td><%= datesUpdate %></td>
		</tr>
		<tr>
			<td><b>내용</b></td>
			<td>
				<textarea style="width: 500px; height: 250px;" name="content" cols="70" rows="600"><%= contentsUpdate %></textarea>
			</td>
		</tr>
	</table>
		<table width="650">
		<tr>
			<td width="650"></td>
			<td>
				<input type="button" value="수정" onclick="location.href='gongji_update.jsp?key=<%= idsUpdate %>'">
			</td>
			<td>
				<input type="button" value="목록" onclick="location.href='gongji_list.jsp'">
			</td>
			<td>
				<input type="button" value="삭제" onclick="location.href='gongji_delete.jsp?key=<%= id %>'">
			</td>
		</tr>
	</table>
	
	
<%
	}
%>
	


</form>
</body>
</html>
