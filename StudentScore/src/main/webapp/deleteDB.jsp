<%@ page contentType="text/html; charset=utf-8" %>  <!--jsp에서 한글 처리 지시-->
<%@ page import="java.sql.*, javax.sql.*, java.io.*, java.net.*, java.util.*"%>

<%@ page import="kr.ac.kopo.ctc.kopo33.dao.*" %>
<%@ page import="kr.ac.kopo.ctc.kopo33.service.*" %>
<%@ page import="kr.ac.kopo.ctc.dto.*" %>
<%@ page import="kr.ac.kopo.ctc.kopo33.domain.*" %>

<HTML>
<head> <!-- 머릿말 정의 시작--> 
<script>
    function goBack() {
        history.back(); // 뒤로가기 실행
    }
</script>
</head> <!-- 머릿말 정의 종료--> 
<body> <!--본문 정의 시작-->
    <h1>레코드 삭제</h1>

<%
	//StudentScoreDaoImpl 클래스의 인스턴스를 생성하고 참조변수에 값을 할당. 이 객체를 통해 인터페이스의 메서드를 호출하여 상호작용.
	StudentScoreDao studentScoreDaoDelete = new StudentScoreDaoImp();
	//getter,setter에 값을 입력하고 받아오기 위해 StudentScore 객체를 생성 
	StudentScore studentScoreDelete = new StudentScore();
	//studentid값을 받아와 ctmp문자열 변수에 저장
    String ctmp = request.getParameter("studentid");
	//StudentScore객체의 setter를 불러와서 studentid 할당
    studentScoreDelete.setStudentid(Integer.parseInt(ctmp));
    //studnetScoreDAO의 구현체를 불러와 studentid를 입력받고 studentid와 일치하는 행을 삭제
    studentScoreDaoDelete.deleteByStudentId(studentScoreDelete.getStudentid(), studentScoreDelete);
    
%>
<!-- 뒤로가는 링크 생성 -->
<a href="#" onclick="goBack()">뒤로가기</a> 
<!-- 제목 열 생성 -->
<table cellspaceing=1 width=600 border=1>
    <tr>
        <td width=50><p align=center>이름</p></td>
        <td width=50><p align=center>학번</p></td>
        <td width=50><p align=center>국어</p></td>
        <td width=50><p align=center>영어</p></td>
        <td width=50><p align=center>수학</p></td>
        <td width=50><p align=center>총점</p></td>
        <td width=50><p align=center>평균</p></td>
        <td width=50><p align=center>순위</p></td>
    </tr>


		<% 
		
		
		//studentScoreDaoDelete의 getAll함수를 불러오고 그 반환값을 저장하기 위한 리스트 생성.
		List<StudentScore> allStudents = studentScoreDaoDelete.getAll();
		// studentid를 받아와서 requestedStudentId 문자열 변수에 저장
		String requestedStudentId = request.getParameter("studentid");
		//allstudents에 있는 값을 studentScore에 모두 저장
		for (StudentScore student : allStudents) {
			//만약 studentid를 정수로 변환한 값이 requestedStudentId 변수에 저장된 값과 같다면 
		    if (String.valueOf(student.getStudentid()).equals(requestedStudentId)) {
		        out.println("<tr bgcolor='#ffff00'>"); //색을 입력
		    } else { //그렇지 않다면 
		        out.println("<tr>"); //행생성
		    }
		    //학생정보를 차례대로 조회하도록 <td>태그 구문 생성
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



</body>
</html>


