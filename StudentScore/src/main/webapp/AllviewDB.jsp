
<%-- 이 JSP 지시자는 현재 페이지의 콘텐츠 유형과 문자 인코딩을 설정한다. contentType 속성은 응답으로 전송되는 콘텐츠의 유형을 설정하며, 
charset 속성은 해당 JSP 페이지의 문자 인코딩을 설정한다. 이 경우, text/html은 HTML 콘텐츠를 응답으로 전송함을 나타내고, utf-8은 문자 인코딩을 설정한다. --%>
<%@ page contentType="text/html; charset=utf-8" %>

<%-- 이 JSP 지시자는 Java 클래스 및 패키지를 가져오는 역할을 한다. import 속성을 사용하여 JSP 페이지에서 사용할 Java 클래스와 패키지를 지정할 수 있다. 
위의 구문에서는 java.sql.*, javax.sql.*, java.io.* 패키지의 모든 클래스를 가져온다는 의미이다. 이렇게 가져온 클래스는 JSP 페이지에서 사용될 수 있다. --%>
<%@ page import="java.sql.*, javax.sql.*, java.io.*, java.util.*" %>
<%@ page import="kr.ac.kopo.ctc.kopo33.dao.*" %>
<%@ page import="kr.ac.kopo.ctc.kopo33.service.*" %>
<%@ page import="kr.ac.kopo.ctc.dto.*" %>
<%@ page import="kr.ac.kopo.ctc.kopo33.domain.*" %>


<html> <!--문서 유형을 나타내는 선언문. HTML5 문서에서는 필수적으로 선언되어야 함-->
<head><!--Heading의 준말로 글의 머리말에 해당하는 태그.-->
<style>
        .no-underline { /*클래스로 지정할 형식*/
        text-decoration: none;/*밑줄 삭제*/
        }
</style>
</head><!--head 태그가 끝남을 알림.-->
<body><!--본문에 해당하는 부분을 알려주는 태그.-->
<h1>조회</h1> <!--컴파일이 오류없이 되었을 때 가장 먼저 뜨는 문구-->



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
//StudentScoreDao 인터페이스를 구현한 StudentScoreDaoImpl 클래스의 인스턴스를 생성하여 studentScoreDao 변수에 할당
StudentScoreService studentScoreService = new StudentScoreServiceImp();
StudentScoreDao studentScoreDao = new StudentScoreDaoImp();

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
Pagination pagination = studentScoreService.getPagination(firstpage, countPerPage);

// 기존의 직접 계산했던 maxPage 제거
// int maxPage = (int) Math.ceil((double)totalItems / countPerPage);

// 서비스에서 계산된 페이지 정보를 사용하기
int currentPage = pagination.getC();
int startPage = pagination.getS();
int endPage = pagination.getE();
//studentScoreDao의 selectAll함수를 불러와서 해당값을 scores 리스트에 넣는다.
List<StudentScore> scores = studentScoreDao.selectAll(currentPage, countPerPage);
//만약 리스트가 비어있다면 데이터가 없음을 보준다.
if (scores == null || scores.isEmpty()) {
    out.println("<tr>");
    out.println("<td colspan='8'><p align='center'>데이터가 없습니다.</p></td>");
    out.println("</tr>");
} else {//리스트가 비어있지 않다면 
	//scores리스트에 있는 값을 studentScore객체로 하나씩 이동하면서 테이블 행을 출력함
for (StudentScore score : scores) {
	  
	out.println("<tr>"); // 테이블의 내용행을 설정
	out.println("<td width=50><p align=center><a href='oneview.jsp?key=" + score.getStudentid() + "'>" + score.getName() + "</a></p></td>");
	// 내용 행의 2열 셀을 설정. 너비는 50px, 문단 정렬은 중앙으로 설정하고, rset객체의 2열 정보를 문자열로 형변환하여 가져온다.
	out.println("<td width=50><p align=center>" + score.getStudentid() + "</p></td>");
	// 내용 행의 3열 셀을 설정. 너비는 50px, 문단 정렬은 중앙으로 설정하고, rset객체의 3열 정보를 문자열로 형변환하여 가져온다.
	out.println("<td width=50><p align=center>" + score.getKor() + "</p></td>");
	// 내용 행의 4열 셀을 설정. 너비는 50px, 문단 정렬은 중앙으로 설정하고, rset객체의 4열 정보를 문자열로 형변환하여 가져온다.
	out.println("<td width=50><p align=center>" + score.getEng() + "</p></td>");
	// 내용 행의 5열 셀을 설정. 너비는 50px, 문단 정렬은 중앙으로 설정하고, rset객체의 5열 정보를 문자열로 형변환하여 가져온다.
	out.println("<td width=50><p align=center>" + score.getMat() + "</p></td>");
	out.println("<td width=50><p align=center>" + score.getTot() + "</p></td>");
	out.println("<td width=50><p align=center>" + score.getAvg() + "</p></td>");
	out.println("<td width=50><p align=center>" + score.getRan() + "</p></td>");
	out.println("<tr>"); // 테이블의 내용행 설정 종료
}
}
if (!(scores == null)) {
%>
</table>

<div class="no-underline" style="width: 600px; text-align: center;">
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



</body><!--본문에 해당하는 부분이 끝남을 알림.-->
</html><!--HTML 구문이 끝남을 알림.-->