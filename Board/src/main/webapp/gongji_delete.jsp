<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, javax.sql.*, java.io.*, java.net.*, java.util.*"%>

<%@ page import="Web_Board_dao.*"%>
<%@ page import="Web_Board_domain.*"%>
<%@ page import="Web_Board_dto.*"%>
<%@ page import="Web_Board_service.*"%>


<html>
<head>
<title>gongji_delete_H</title>
</head>
<body>
<%

Web_Board_Dao webBoardDao = new Web_Board_Dao_Impl();
Web_Board_Service webBoardService = new Web_Board_ServiceImpl();
Web_Board webBoard = new Web_Board();

String key = request.getParameter("key");// 요청 파라미터에서 key 값을 가져옴

webBoardDao.delete(Integer.parseInt(key), webBoard);// key 값을 정수형으로 변환하여 delete 메서드 호출

%>

<h2>게시물 삭제 완료</h2>
	<table width="650">
		<tr>
			<td width="650"></td>
			<td>
				<input type="button" value="목록" onclick="location.href='gongji_list.jsp'">
			</td><!-- <input> 요소로, "목록" 버튼을 생성하는 부분 -->
		</tr>
	</table>

</body>
</html>