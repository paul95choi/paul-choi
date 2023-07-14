<%@ page contentType="text/html; charset=utf-8" %>  <!--jsp에서 한글 처리 지시-->
<%@ page import="java.sql.*,javax.sql.*,java.io.*, java.net.*, java.util.*"%> <!-- 필요한 파일 import-->

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
<style>
        .no-underline { /*클래스로 지정할 형식*/
        text-decoration: none;/*밑줄 삭제*/
        }
</style>
</head>

<body>
<h1>레코드 수정</h1>

<a href="#" onclick="goBack()">뒤로가기</a> <!-- 뒤로가기 링크 설정 -->
	<!-- 테이블을 언ㅇ너하고 제목행을 설정 -->
    <table cellspacing=1 width=600 border=1>
        <tr>
            <td width=50><p align=center>이름</p></td>
            <td width=50><p align=center>학번</p></td>
            <td width=50><p align=center>국어</p></td>
            <td width=50><p align=center>영어</p></td>
            <td width=50><p align=center>수학</p></td>
            <td width=50><p align=center>총점</p></td>
            <td width=50><p align=center>평균</p></td>
            <td width=50><p align=center>등수</p></td>
        </tr>
<%
request.setCharacterEncoding("UTF-8");  // 요청 문자 인코딩을 UTF-8로 설정
//StudentScoreDaoImpl 클래스의 인스턴스를 생성하고 참조변수에 값을 할당. 이 객체를 통해 인터페이스의 메서드를 호출하여 상호작용.
StudentScoreDao studentScoreDaoUpdates = new StudentScoreDaoImp();
//getter,setter에 값을 입력하고 받아오기 위해 StudentScore 객체를 생성 
StudentScore studentScoreUpdate = new StudentScore();

String nameUpdate = request.getParameter("name"); //파라미터를 받아와 변수에 저장
String studentidUpdate = request.getParameter("studentid"); //파라미터를 받아와 변수에 저장
String korScoreUpdate = request.getParameter("kor"); //파라미터를 받아와 변수에 저장
String engScoreUpdate = request.getParameter("eng"); //파라미터를 받아와 변수에 저장
String matScoreUpdate = request.getParameter("mat"); //파라미터를 받아와 변수에 저장

// 파라미터 값이 null이 아닌 경우에만 객체에 할당
if (nameUpdate != null) studentScoreUpdate.setName(nameUpdate); 
if (studentidUpdate != null) studentScoreUpdate.setStudentid(Integer.parseInt(studentidUpdate));
if (korScoreUpdate != null) studentScoreUpdate.setKor(Integer.parseInt(korScoreUpdate));
if (engScoreUpdate != null) studentScoreUpdate.setEng(Integer.parseInt(engScoreUpdate));
if (matScoreUpdate != null) studentScoreUpdate.setMat(Integer.parseInt(matScoreUpdate));

int firstpage = 1; // 처음페이지를 1로 설정
int countPerPage = 10; //페이지당 출력 행을 10으로 설정
// 해당 정보가 null이 아닌 경우에만 DB 업데이트 진행
if (nameUpdate != null && studentidUpdate != null) {
	//studentScoreDao의 update 메서드를 불러와, 학번값을 입력받아 update를 메서드를 실행
	studentScoreDaoUpdates.update(studentScoreUpdate.getStudentid(), studentScoreUpdate);
}






        

//StudentScoreDao 인터페이스를 구현한 StudentScoreDaoImpl 클래스의 인스턴스를 생성하여 studentScoreDao 변수에 할당
StudentScoreService studentScoreServiceUpdate = new StudentScoreServiceImp();



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

// ======================================================================================================================



	//studentScore객체에서 studentid를 받아와 변수에 저장.
    int studentid = studentScoreUpdate.getStudentid();
	//studentScoreDao의 getPageByStudentId를 불러와 studentid, countPerPage를 전달받아 메서드를 실행하고 반환값을 updatedStudentPage변수에 저장
    int updatedStudentPage = studentScoreDaoUpdates.getPageByStudentId(studentid, countPerPage);
    	//updatedStudentPage에 오류가 없다면 
	    if (updatedStudentPage != -1) {
	        //첫번째 페이지를 updatedStudentPage 변수에 담긴 값으로 할당
	        firstpage = updatedStudentPage;
	    }



//======================================================================================================================

//아래 코드 추가: 서비스로부터 Pagination 객체 받아와서, firstpage, countPerPage변수 값을 입력하고 
//pagination에서 계산한 값을 반환받음.
Pagination paginationUpdate = studentScoreServiceUpdate.getPagination(firstpage, countPerPage);


//서비스에서 계산된 페이지 정보를 사용하기
int currentPage = paginationUpdate.getC();
int startPage = paginationUpdate.getS();
int endPage = paginationUpdate.getE();

		//studentScoreDaoUpdates의 selectAll함수를 불러오고 그 반환값을 저장하기 위한 리스트 생성.
		//currentPage변수로 현재 페이지의 값을 지정할 수 있기 때문에 currentPage가 계산되면 업데이트된 studentid의 페이지로 이동 가능
		List<StudentScore> allStudents = studentScoreDaoUpdates.selectAll(currentPage, countPerPage);
		String requestedStudentId = request.getParameter("studentid"); //studentid 파타미터를 받아와 requestedStudentId 변수에 저장
		//allstudents에 있는 값을 studentScore객체에 모두 저장
		for (StudentScore student : allStudents) {
			//만약 studentid를 정수로 변환한 값이 requestedStudentId 변수에 저장된 값과 같다면
		    if (String.valueOf(student.getStudentid()).equals(requestedStudentId)) {
		        out.println("<tr bgcolor='#ffff00'>"); //색을 지정
		    } else { //그렇지 않다면 
		        out.println("<tr>"); //행생성
		    }
		  //모든 학생의 학생정보를 조회하도록 <td>태그 구문 생성
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
		//response.sendRedirect("?page=" + updatedStudentPage);
%>
</table>
<div class = "no-underline"  style= "width=600; text-align: center;">
<%
// Pagination 부분
// << 링크
if (paginationUpdate.getPp() != -1) {
	out.print("<a href='?page=" + paginationUpdate.getPp() + "'>" + "<<" + "</a> ");
}

// < 링크
if (paginationUpdate.getP() != -1) {
	out.print("<a href='?page=" + paginationUpdate.getP() + "'>" + "<" + "</a> ");
}

// 페이지 링크 출력
for (int i = startPage; i <= endPage; i++) {
    if (i == currentPage) {
    	out.print("<span style='color: red;'>" + " " + i + " " + "</span>");

    } else {
        out.print("<a href='?page=" + i + "'>" + " " + i + " " + "</a> ");
    	//out.print("<a href='?page=" + i + "&studentid=" + studentScoreUpdate.getStudentid() + "'>" + " " + i + " " + "</a> ");
    }
}

// > 링크
if (paginationUpdate.getN() != -1) {
	out.print("<a href='?page=" + paginationUpdate.getN() + "'>" + ">" + "</a> ");
}

// >> 링크
if (paginationUpdate.getNn() != -1) {
	out.print("<a href='?page=" + paginationUpdate.getNn() + "'>" + ">>" + "</a> ");
}
%>
</div>
</body>
</html>