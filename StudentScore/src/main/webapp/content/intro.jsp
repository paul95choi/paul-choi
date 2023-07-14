<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.sql.*, javax.sql.*, java.io.*, java.net.*, java.util.*"%>

<!DOCTYPE html> <!--문서 유형을 나타내는 선언문. HTML5 문서에서는 필수적으로 선언되어야 함-->
<html lang="en"><!--HTML 문서의 시작을 알리는 태그. lang 속성을 통해 문서의 언어를 지정할 수 있다.-->

<head><!--Heading의 준말로 글의 머리말에 해당하는 태그.-->
    <!--meta 태그를 통해 문자 인코딩, 브라우저 호환성, 화면 크기 등을 지정-->
    <meta charset="UTF-8"><!-- 인코딩 언어 utf-8-->
    <!-- 브라우저 호환성을 위한 태그. -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- 모바일 기기에서 화면 크기에 맞게 표시하기 위한 태그. -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title><!-- 웹 페이지의 제목을 지정하는 태그. -->
    <style> /*css형식의 스타일 정의*/
    span { /*span태그의 스타일 지정*/
        font-size: 50px /*폰트 크기 50px로 지정*/
    }
    </style> <!--css스타일 정의 종료-->
</head><!--head 태그가 끝남을 알림.-->

<body><!--본문에 해당하는 부분을 알려주는 태그.-->
    <span><b>JSP 데이터베이스 실습</b></span> <!--span와 b태그로 텍스트를 감싸고 문장 출력 -->
   <%
    int count = 0; //count 변수를 0으로 초기화합니다.
    //conn, stmt, rs 변수를 선언하고 초기화
   Connection conn = null;
   Statement stmt = null;
   ResultSet rs = null;

    try {
        // 데이터베이스 드라이버 로드
	    // 데이터베이스 연결
		Class.forName("com.mysql.cj.jdbc.Driver");
		// localhost서버의 "kopo33" 데이터베이스에 "root" 사용자로 연결, 비밀번호는 choi0924.
		conn = DriverManager.getConnection("jdbc:mysql://192.168.23.200:33060/kopo33", "root", "choi0924");
		//stmt 객체를 생성
		stmt = conn.createStatement();
	    rs = null;


        // 조회수 가져오기
        // sql구문을 저장할 변수 선언
        String sql = "SELECT count FROM visitors";
        //resultset에 sql구문을 실행한 결과를 저장.
        rs = stmt.executeQuery(sql);
        // 
        //데이터베이스에서 조회한 결과 집합에서 첫 번째 행의 "count" 열 값을 가져와서 count 변수에 할당하는 역할
        if (rs.next()) {
            count = rs.getInt("count");
        }

        // 조회수 증가
        count++;

        // 조회수 업데이트
        sql = "UPDATE visitors SET count = " + count;
        stmt.executeUpdate(sql);
        
        rs.close();
        stmt.close();

    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        // 리소스 해제
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // 방문자 수 출력
    out.println("<br><br><br>해당 홈페이지의 현재 조회수 : [" + count + "]입니다</br>");
    %>

</body><!--본문에 해당하는 부분이 끝남을 알림.-->

</html><!--HTML 구문이 끝남을 알림.-->