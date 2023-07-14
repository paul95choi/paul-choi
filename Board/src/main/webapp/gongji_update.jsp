<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, javax.sql.*, java.io.*, java.net.*, java.util.*"%>

<%@ page import="Web_Board_dao.*"%>
<%@ page import="Web_Board_domain.*"%>
<%@ page import="Web_Board_dto.*"%>
<%@ page import="Web_Board_service.*"%>


<html>
<head>
<title>gongji_update_H.jsp</title>
<script>
function submitForm(mode, idIdx) {
	  var fm = document.forms['fm'];// 폼 요소를 가져옴
	  if (mode == "write") {
	    fm.action = "gongji_write.jsp?key=" + idIdx;// 쓰기 모드일 경우 폼의 action을 설정하여 gongji_write.jsp로 이동하도록 함
	    fm.submit();// 폼 전송
	  } else if (mode == "delete") {
		fm.action = "gongji_delete.jsp?key=" + idIdx;// 삭제 모드일 경우 폼의 action을 설정하여 gongji_delete.jsp로 이동하도록 함
		fm.submit();// 폼 전송
	  }
	}

</script>
</head>
<body>
<%
int idIdx = 0; // 게시글 번호를 저장할 변수 선언 및 초기화
String titleIdx = ""; // 게시글 제목을 저장할 변수 선언 및 초기화
String dateIdx = ""; // 게시글 일자를 저장할 변수 선언 및 초기화
String contentIdx = ""; // 게시글 내용을 저장할 변수 선언 및 초기화

request.setCharacterEncoding("UTF-8"); // 요청 문자 인코딩을 UTF-8로 설정

String idKey = request.getParameter("key"); // 요청에서 key 파라미터 값을 가져옴
String title = request.getParameter("title"); // 요청에서 title 파라미터 값을 가져옴
String content = request.getParameter("content"); // 요청에서 content 파라미터 값을 가져옴

Web_Board_Dao webBoardDao = new Web_Board_Dao_Impl(); // Web_Board_Dao_Impl 객체 생성
Web_Board_Service webBoardService = new Web_Board_ServiceImpl(); // Web_Board_ServiceImpl 객체 생성
Web_Board webBoard = new Web_Board(); // Web_Board 객체 생성

webBoard.setKeyNum(Integer.parseInt(idKey)); // Web_Board 객체의 keyNum에 요청에서 받은 idKey 값을 설정

List<Web_Board> results = webBoardDao.OneView(webBoard.getKeyNum(), webBoard); // keyNum을 기준으로 게시글 정보 조회

for(Web_Board webBoards : results) { // 조회한 결과를 반복문을 통해 변수에 저장
    idIdx = webBoards.getId();
    titleIdx = webBoards.getTitle();
    dateIdx = webBoards.getDate();
    contentIdx = webBoards.getContent();
}
%>
	<form method=post name='fm' action="gongji_write.jsp">

	
	<table width=650 border=1 cellspacing=0 cellpadding=5>
		<tr>
			<td><b>번호</b></td>
			<td><input type=text name=ids size=70 maxlength=70 value=<%= idIdx %>></td>
		</tr>
		<tr>
			<td><b>제목</b></td>
			<td><input type=text name=titles size=70 maxlength=70 value=<%=titleIdx %>></td>
		</tr>
		<tr>
			<td><b>일자</b></td>
			<td><input type=text name=dates size=70 maxlength=70 value=<%=dateIdx %> readonly></td>
		</tr>				
		<tr>
			<td><b>내용</b></td>
			<td><textarea style='width:500px; height:250px;' name=contents cols=70 rows=600><%=contentIdx %></textarea></td>
		</tr>		
	</table>
	<table width=650>
	<tr>
		<td width=600></td>
		<td><input type=button value="취소" OnClick="location.href='gongji_list.jsp'"></td>
		<td><input type=button value="쓰기" OnClick="submitForm('write', '<%= idIdx %>')"></td>
		<td><input type=button value="삭제" OnClick="submitForm('delete', '<%= idIdx %>')"></td>
	</tr>
	</table>
	</form>
	
	
	<!--  <td><input type=button value="쓰기" OnClick="submitForm('write')"></td> -->
	<!--  <td><input type=button value="쓰기" OnClick="location.href='gongji_write.jsp?key=<%= idIdx %>'"></td> -->
	<!--  <td><input type="button" value="쓰기" onclick="location.href='gongji_write.jsp?key=<%= idIdx %>&ids=<%=titleIdx %>&titles=<%=dateIdx %>&dates=<%=contentIdx %>&contents=<%=contentIdx %>'"></td> -->
</body>
</html>