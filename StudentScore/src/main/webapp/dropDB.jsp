<%@ page contentType="text/html; charset=utf-8" %>
<!--html과 jsp에서 한글처리 지시-->
<%@ page import="java.sql.*,javax.sql.*,java.io.*" %>
<!--필요한 파일 임포트(이 3개는 기본)-->
<!--이렇게 세 줄은 항상 html 위에 써줄 것-->

<html>
<head>
<title>DBDrop</title>
</head>
<body>

<%

    Class.forName("com.mysql.cj.jdbc.Driver"); 
    //JDBC 드라이버 클래스 로드, 데이터베이스와 연결을 설정하기 위해 필요
    Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.200:33060/kopo33", "root", "choi0924");
    //getConnetion 메서드를 호출하여 MySQL 데이터베이스와 연결, 매개변수 순서(JDBC URL, DB NAME, DB USER, PASSWD)
    Statement stmt = conn.createStatement();
    //SQL문을 실행하기 위한 statement 객체 생성

    try{ //예외처리
    stmt.execute("drop table examtable;"); //execute 메서드를 사용하여 SQL문 실행(drop table 테이블 삭제)      
    out.println("<h1>테이블 지우기 OK</h1>"); //예외 발생하지 않았을때 화면에 출력
    stmt.close(); //statement 객체 열어줬으면 닫기
    conn.close(); //connection 객체 열어줬으면 닫기
        } catch(SQLException e) {
      out.println(e); //예외 발생시 에러 내용 출력
   }
%>
</body>
</html>