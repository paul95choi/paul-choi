<%-- 이 JSP 지시자는 현재 페이지의 콘텐츠 유형과 문자 인코딩을 설정한다. contentType 속성은 응답으로 전송되는 콘텐츠의 유형을 설정하며, 
charset 속성은 해당 JSP 페이지의 문자 인코딩을 설정한다. 이 경우, text/html은 HTML 콘텐츠를 응답으로 전송함을 나타내고, utf-8은 문자 인코딩을 설정한다. --%>
<%@ page contentType="text/html; charset=utf-8" %>

<%-- 이 JSP 지시자는 Java 클래스 및 패키지를 가져오는 역할을 한다. import 속성을 사용하여 JSP 페이지에서 사용할 Java 클래스와 패키지를 지정할 수 있다. 
위의 구문에서는 java.sql.*, javax.sql.*, java.io.* 패키지의 모든 클래스를 가져온다는 의미이다. 이렇게 가져온 클래스는 JSP 페이지에서 사용될 수 있다. --%>
<%@ page import="java.sql.*, javax.sql.*, java.io.*,java.util.*" %>
<%@ page import="kr.ac.kopo.ctc.kopo33.dao.*" %>
<%@ page import="kr.ac.kopo.ctc.kopo33.service.*" %>
<%@ page import="kr.ac.kopo.ctc.dto.*" %>
<%@ page import="kr.ac.kopo.ctc.kopo33.domain.*" %>

<html> <!--문서 유형을 나타내는 선언문. HTML5 문서에서는 필수적으로 선언되어야 함-->
<head><!--Heading의 준말로 글의 머리말에 해당하는 태그.-->
<script>
    function goBack() {
        history.back(); // 뒤로가기 실행
    }
</script>
</head><!--head 태그가 끝남을 알림.-->
<body><!--본문에 해당하는 부분을 알려주는 태그.-->


<%
//StudentScoreDaoImpl 클래스의 인스턴스를 생성하고 참조변수에 값을 할당. 이 객체를 통해 인터페이스의 메서드를 호출하여 상호작용.
StudentScoreDao studentScoreDaoOneView = new StudentScoreDaoImp();
//getter,setter에 값을 입력하고 받아오기 위해 StudentScore 객체를 생성 
StudentScore studentScoreOneView = new StudentScore();
String ckey = request.getParameter("key"); //파라미터를 받아와 변수에 저장
studentScoreOneView.setStudentid(Integer.parseInt(ckey)); //StudentScore객체의 setter를 불러와서 studentid 할당
//studentScoreOneView.setName(ckey); //StudentScore객체의 setter를 불러와서 studentid 할당
%>
<h1>[<%=ckey%>]조회</h1> <!--컴파일이 오류없이 되었을 때 가장 먼저 뜨는 문구-->


<a href="#" onclick="goBack()">뒤로가기</a>

<!--테이블은 1픽셀 간격으로 셀을 구분하고, 전체 너비는 600픽셀로 설정하며, 테두리의 두께는 1픽셀로 설정-->
<table cellspacing =1 width=600 border =1>
    <tr> <!--테이블의 제목 행을 설정-->
        <td width = 50><p align=center>이름</p></td> <!--제목 행의 1열 셀을 설정. 너비는 50px, 문단 정렬은 중앙으로 설정 -->
        <td width = 50><p align=center>학번</p></td> <!--제목 행의 2열 셀을 설정. 너비는 50px, 문단 정렬은 중앙으로 설정-->
        <td width = 50><p align=center>국어</p></td> <!--제목 행의 3열 셀을 설정. 너비는 50px, 문단 정렬은 중앙으로 설정-->
        <td width = 50><p align=center>영어</p></td> <!--제목 행의 4열 셀을 설정. 너비는 50px, 문단 정렬은 중앙으로 설정-->
        <td width = 50><p align=center>수학</p></td> <!--제목 행의 5열 셀을 설정. 너비는 50px, 문단 정렬은 중앙으로 설정-->
        <td width = 50><p align=center>총점</p></td> <!--제목 행의 5열 셀을 설정. 너비는 50px, 문단 정렬은 중앙으로 설정-->
        <td width = 50><p align=center>평균</p></td> <!--제목 행의 5열 셀을 설정. 너비는 50px, 문단 정렬은 중앙으로 설정-->
        <td width = 50><p align=center>등수</p></td> <!--제목 행의 5열 셀을 설정. 너비는 50px, 문단 정렬은 중앙으로 설정-->

    </tr><!--테이블의 제목 행 설정 종료-->
    
<%  
		//studentScoreDaoOneView의 getOne함수를 불러오고 그 반환값을 저장하기 위한 리스트 생성.
		List<StudentScore> allStudents = studentScoreDaoOneView.getOne(studentScoreOneView.getStudentid());
		String requestedStudentId = request.getParameter("key"); //파라미터를 받아와 변수에 저장
		//allstudents에 있는 값을 studentScore에 모두 저장
		for (StudentScore student : allStudents) {
			//만약 studentid를 정수로 변환한 값이 requestedStudentId 변수에 저장된 값과 같다면
		    if (String.valueOf(student.getStudentid()).equals(requestedStudentId)) {
		        out.println("<tr bgcolor='#ffff00'>"); //색을 입력
		    } else { //그렇지 않다면 
		        out.println("<tr>"); //행생성
		    }
		  //선택한 한명의 학생정보를 조회하도록 <td>태그 구문 생성
		    out.println("<td width=50><p align=center><a href='oneview.jsp?key=" +
		                student.getStudentid() + "'>" + student.getName() + "</a></p></td>");
		    out.println("<td width=50><p align=center>" + student.getStudentid() + "</p></td>");
		    out.println("<td width=50><p align=center>" + student.getKor() + "</p></td>");
		    out.println("<td width=50><p align=center>" + student.getEng() + "</p></td>");
		    out.println("<td width=50><p align=center>" + student.getMat() + "</p></td>");
		    out.println("<td width=50><p align=center>" + student.getTot() + "</p></td>");
		    out.println("<td width=50><p align=center>" + student.getAvg() + "</p></td>");
		    out.println("<td width=50><p align=center>" + student.getRan() + "</p></td>");
		    out.println("</tr>");
		}	
%>       
    
</table>


</body><!--본문에 해당하는 부분이 끝남을 알림.-->
</html><!--HTML 구문이 끝남을 알림.-->