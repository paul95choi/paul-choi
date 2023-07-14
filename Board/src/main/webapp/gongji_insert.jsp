<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page
	import="java.sql.*, javax.sql.*, java.io.*, java.net.*, java.util.*"%>
<%@ page import="java.text.*,java.time.*,java.time.format.*"%>

<%@ page import="Web_Board_dao.*"%>
<%@ page import="Web_Board_domain.*"%>
<%@ page import="Web_Board_dto.*"%>
<%@ page import="Web_Board_service.*"%>
<html>
<head>
<title>gongji_insert.jsp</title>

<script>
	function submitForm(mode) {
		var fm = document.forms['fm'];
		if (mode == "write") {
			fm.action = "gongji_write.jsp";
			fm.submit();
		}
	}
</script>
<script>
	function checkForm1() { //입력된 문자를 검사하는 함수 선언
		const form = document.getElementById('insert'); //insert폼에 있는 요소를 form변수에 저장한다.

		const title = form.elements.title.value; //form변수에서 insert폼의 id에 해당하는 값을 id변수에 저장한다.
		const content = form.elements.content.value;//name변수에서 insert폼의 name에 해당하는 값을 name변수에 저장한다.

		//const pattern1 = /^([a-zA-Z가-힣]{1,20})$/; //한글(초성, 중성, 종성), 영어만 입력받고, 20자 이내로 입력받는 정규식1 생성
		//const pattern2 = /^[1-9][0-9]?$/; // 1~100사이의 정수값만 입력받는 정규식2 생성
		const pattern3 = /^(?!\s)([\s\S]*)$/;

		if (!pattern3.test(title) && !pattern3.test(content)) { //id값이 pattern2 테스트를 실패하고, name값이 pattern1 테스트를 실패한다면 
			alert("게시글 제목과 내용을 입력해주세요 "); // 경고창 팝업
		}
		if (!pattern3.test(title)) { //name값이 pattern1 테스트를 실패한다면
			alert("게시글을 입력해주세요");// 경고창 팝업
		} else if (!pattern2.test(id)) { //id값이 pattern2 테스트를 실패한다면
			alert("1~100까지 숫자만 입력하세요.");// 경고창 팝업
		} else {
			form.action = "A_03_H.jsp"; // "테스트를 모두 통과한다면 A_03_H.jsp"를 인자로 제공.
			form.submit();
		}
	}
</script>
</head>
<body>
	<%
	int idIdxNum = 0; //id값을 받을 변수 선언
	int aID = 1;// aID 변수 선언과 초기값 할당
	String title = "";// title 변수 선언과 빈 문자열로 초기화
	String content = "";// content 변수 선언과 빈 문자열로 초기화

	Web_Board_Dao webBoardDao = new Web_Board_Dao_Impl();// Web_Board_Dao_Impl 인스턴스 생성
	Web_Board_Service webBoardService = new Web_Board_ServiceImpl();// Web_Board_ServiceImpl 인스턴스 생성
	Web_Board webBoard = new Web_Board();// Web_Board 인스턴스 생성
	webBoardDao.insert(webBoard);// webBoardDao를 사용하여 webBoard를 DB에 삽입
	
	%>
	<!--  <td><%=webBoard.getId()%><input type=hidden name=id  value= id readonly></td>	-->
	<!--  <input type=hidden name=date value="date"> -->
	<!--  <form method=post action="gongji_write_H.jsp">-->
	<form method=post name="fm"><!-- 게시글 입력 폼 -->
		<table width=650 border=1 cellspacing=0 cellpadding=5 >
			<tr>
				<td><b>번호</b></td>
				<td>신규게시글 (자동번호부여 )<input type=hidden name=id
					value=<%=webBoard.getId()%> readonly></td>
			</tr>
			<tr>
				<td><b>제목</b></td>
				<td><input type="text" required name="title" size="70"
					maxlength="70" pattern="^\S.*$" placeholder="제목을 입력해주세요"></td>

			</tr>
			<tr>
				<td><b>일자</b></td>
				<td><%=webBoardDao.date()%><input type=hidden name=date
					value=<%=webBoardDao.date()%> readonly></td>
			</tr>
			<tr>
				<td><b>내용</b></td>
				<td><textarea style="width: 500px; height: 250px;" required
						name=content cols=70 rows=600 placeholder="내용을 입력해주세요"></textarea></td>
			</tr>
		</table>
		<table width=650>
			<tr>
				<td><input type=button value="취소"
					OnClick="location.href='gongji_list.jsp'"></td>
				<td><input type=button value="쓰기" OnClick="submitForm('write')"></td>
				<!--  <td><input type="submit" value="쓰기"></td> -->
			</tr>

		</table>
	</form>

	<!-- ////////////////////////////// -->
</body>
</html>