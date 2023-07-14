<%-- 이 JSP 지시자는 현재 페이지의 콘텐츠 유형과 문자 인코딩을 설정한다. contentType 속성은 응답으로 전송되는 콘텐츠의 유형을 설정하며, 
charset 속성은 해당 JSP 페이지의 문자 인코딩을 설정한다. 이 경우, text/html은 HTML 콘텐츠를 응답으로 전송함을 나타내고, utf-8은 문자 인코딩을 설정한다. --%>
<%@ page contentType="text/html; charset=utf-8"%>

<%-- 이 JSP 지시자는 Java 클래스 및 패키지를 가져오는 역할을 한다. import 속성을 사용하여 JSP 페이지에서 사용할 Java 클래스와 패키지를 지정할 수 있다. 
위의 구문에서는 java.sql.*, javax.sql.*, java.io.* 패키지의 모든 클래스를 가져온다는 의미이다. 이렇게 가져온 클래스는 JSP 페이지에서 사용될 수 있다. --%>
<%@ page import="java.sql.*, javax.sql.*, java.io.*, java.net.*, java.util.*"%>
<%@ page import="kr.ac.kopo.ctc.kopo33.dao.*" %>
<%@ page import="kr.ac.kopo.ctc.kopo33.service.*" %>
<%@ page import="kr.ac.kopo.ctc.dto.*" %>
<%@ page import="kr.ac.kopo.ctc.kopo33.domain.*" %>

<html>
<!--문서 유형을 나타내는 선언문. HTML5 문서에서는 필수적으로 선언되어야 함-->
<head>
<!--Heading의 준말로 글의 머리말에 해당하는 태그.-->
</head>
<!--head 태그가 끝남을 알림.-->
<body>
	<!--본문에 해당하는 부분을 알려주는 태그.-->
	<h1>성적 추가 완료</h1>
	<!--컴파일이 오류없이 되었을 때 가장 먼저 뜨는 문구-->

	<%
	//StudentScoreDaoImpl 클래스의 인스턴스를 생성하고 참조변수에 값을 할당. 이 객체를 통해 인터페이스의 메서드를 호출하여 상호작용.
	StudentScoreDao studentScoreDao = new StudentScoreDaoImp();
	//getter,setter에 값을 입력하고 받아오기 위해 StudentScore 객체를 생성 
	StudentScore studentScore = new StudentScore();
	
	request.setCharacterEncoding("UTF-8"); // 요청 문자 인코딩을 UTF-8로 설정
	String nameStr = request.getParameter("name"); //파라미터를 받아와 변수에 저장
	String korStr = request.getParameter("kor"); //파라미터를 받아와 변수에 저장
	String engStr = request.getParameter("eng"); //파라미터를 받아와 변수에 저장
	String matStr = request.getParameter("mat"); //파라미터를 받아와 변수에 저장
	
	studentScore.setName(nameStr); //변수에 저장된 값을 studentScore의 setter로 할당
	studentScore.setKor(Integer.parseInt(korStr));//변수에 저장된 값을 studentScore의 setter로 할당
	studentScore.setEng(Integer.parseInt(engStr));//변수에 저장된 값을 studentScore의 setter로 할당
	studentScore.setMat(Integer.parseInt(matStr));//변수에 저장된 값을 studentScore의 setter로 할당

	studentScoreDao.create(studentScore); //studentScoreDao의 create의 메서드를 불러오고 인자로 studnetScore객체를 입력하여 메서드 결과값을 반환.
	%>

	<!-- 뒤로가기 링크 출력 -->
	<a href="./inputForm1.html"><input type="button" value="뒤로가기"></a>
	<!-- 테이블 출력 -->
	<table cellspacing=1 width=600 border=1>
		<tr><!-- 각각의 제목과 데이터열을 출력 -->
			<td>이름:</td>
			<td><%=studentScore.getName()%></td>
		<tr>
		<tr>
			<td>학번:</td>
			<td><%=studentScore.getStudentid()%></td>
		</tr>
		<tr>
			<td>국어:</td>
			<td><%=studentScore.getKor()%></td>
		</tr>
		<tr>
			<td>영어:</td>
			<td><%=studentScore.getEng()%></td>
		</tr>
		<tr>
			<td>수학:</td>
			<td><%=studentScore.getMat()%></td>
		</tr>