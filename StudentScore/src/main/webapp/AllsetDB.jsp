<%-- 이 JSP 지시자는 현재 페이지의 콘텐츠 유형과 문자 인코딩을 설정한다. contentType 속성은 응답으로 전송되는 콘텐츠의 유형을 설정하며, 
charset 속성은 해당 JSP 페이지의 문자 인코딩을 설정한다. 이 경우, text/html은 HTML 콘텐츠를 응답으로 전송함을 나타내고, utf-8은 문자 인코딩을 설정한다. --%>
<%@ page contentType="text/html; charset=utf-8"%>

<%-- 이 JSP 지시자는 Java 클래스 및 패키지를 가져오는 역할을 한다. import 속성을 사용하여 JSP 페이지에서 사용할 Java 클래스와 패키지를 지정할 수 있다. 
위의 구문에서는 java.sql.*, javax.sql.*, java.io.* 패키지의 모든 클래스를 가져온다는 의미이다. 이렇게 가져온 클래스는 JSP 페이지에서 사용될 수 있다. --%>
<%@ page import="java.sql.*, javax.sql.*, java.io.*"%>
<%@ page import="kr.ac.kopo.ctc.kopo33.dao.*"%>
<!DOCTYPE html>
<!--문서 유형을 나타내는 선언문. HTML5 문서에서는 필수적으로 선언되어야 함-->
<html lang="en">
<!--HTML 문서의 시작을 알리는 태그. lang 속성을 통해 문서의 언어를 지정할 수 있다.-->

<head>
<!--Heading의 준말로 글의 머리말에 해당하는 태그.-->
<title>실습 데이터 입력</title>
<!-- 웹 페이지의 제목을 지정하는 태그. -->
</head>
<!--head 태그가 끝남을 알림.-->

<body>
	<!--본문에 해당하는 부분을 알려주는 태그.-->
	<h1>실습 데이터 입력</h1>
	<!--컴파일이 오류없이 되었을 때 가장 먼저 뜨는 문구-->
<%
//StudentScoreDaoImpl 클래스의 인스턴스를 생성하고 참조변수에 값을 할당. 이 객체를 통해 인터페이스의 메서드를 호출하여 상호작용.
StudentScoreDao studentScoreDao = new StudentScoreDaoImp();
//studentScoreDao의 insertData()를 불러와서 함수가 반환하는 값을 result에 저장
String result = studentScoreDao.insertData();
//result에 저장된 값 출력
out.println(result);
%>

</body>
<!--본문에 해당하는 부분이 끝남을 알림.-->
</html>
<!--HTML 구문이 끝남을 알림.-->