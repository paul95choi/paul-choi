<%@ page contentType="text/html; charset=utf-8" language = "java" %>
<%@ page import="java.sql.*, javax.sql.*, java.net.*, java.io.*,java.util.*" %>
<html>
<head>
<title>makedata.jsp</title>
</head>
<body>
<h1>Make table</h1>

<%
Class.forName("com.mysql.cj.jdbc.Driver"); // JDBC 드라이버를 로드
Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.200:33060/kopo33", "root", "choi0924"); // 데이터베이스에 연결
Statement stmt = conn.createStatement(); // SQL 문 실행을 위한 Statement 객체를 실행
%>

<%
try {//데이터베이스 테이블 "gongji"를 삭제하는 부분
   stmt.execute("drop table if exists gongji");
   out.println("drop table gongji OK<br>");
} catch (Exception e) {
   out.println("drop table gongji NOT OK<br>");
   out.println(e.toString());
}
%>
<% //stmt.execute 메서드를 사용하여 SQL문 "create table gongji(...)"를 실행하여 "gongji" 테이블을 생성
   stmt.execute("create table gongji(id int auto_increment not null primary key , title varchar(70), date Date, content text) DEFAULT CHARSET=UTF8"); 
%>
<%
   String sql="";//gongji" 테이블에 데이터를 삽입하는 부분
   sql="INSERT INTO gongji(title, date, content) values('공지사항1', date(now()), '공지사항내용1')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항2', date(now()), '공지사항내용2')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항3', date(now()), '공지사항내용3')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항4', date(now()), '공지사항내용4')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항5', date(now()), '공지사항내용5')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항6', date(now()), '공지사항내용6')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항1', date(now()), '공지사항내용1')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항2', date(now()), '공지사항내용2')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항3', date(now()), '공지사항내용3')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항4', date(now()), '공지사항내용4')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항5', date(now()), '공지사항내용5')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항6', date(now()), '공지사항내용6')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항1', date(now()), '공지사항내용1')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항2', date(now()), '공지사항내용2')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항3', date(now()), '공지사항내용3')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항4', date(now()), '공지사항내용4')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항5', date(now()), '공지사항내용5')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항6', date(now()), '공지사항내용6')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항1', date(now()), '공지사항내용1')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항2', date(now()), '공지사항내용2')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항3', date(now()), '공지사항내용3')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항4', date(now()), '공지사항내용4')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항5', date(now()), '공지사항내용5')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항6', date(now()), '공지사항내용6')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항1', date(now()), '공지사항내용1')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항2', date(now()), '공지사항내용2')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항3', date(now()), '공지사항내용3')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항4', date(now()), '공지사항내용4')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항5', date(now()), '공지사항내용5')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항6', date(now()), '공지사항내용6')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항1', date(now()), '공지사항내용1')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항2', date(now()), '공지사항내용2')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항3', date(now()), '공지사항내용3')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항4', date(now()), '공지사항내용4')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항5', date(now()), '공지사항내용5')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항6', date(now()), '공지사항내용6')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항1', date(now()), '공지사항내용1')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항2', date(now()), '공지사항내용2')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항3', date(now()), '공지사항내용3')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항4', date(now()), '공지사항내용4')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항5', date(now()), '공지사항내용5')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항6', date(now()), '공지사항내용6')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항1', date(now()), '공지사항내용1')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항2', date(now()), '공지사항내용2')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항3', date(now()), '공지사항내용3')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항4', date(now()), '공지사항내용4')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항5', date(now()), '공지사항내용5')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항6', date(now()), '공지사항내용6')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항1', date(now()), '공지사항내용1')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항2', date(now()), '공지사항내용2')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항3', date(now()), '공지사항내용3')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항4', date(now()), '공지사항내용4')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항5', date(now()), '공지사항내용5')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항6', date(now()), '공지사항내용6')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항1', date(now()), '공지사항내용1')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항2', date(now()), '공지사항내용2')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항3', date(now()), '공지사항내용3')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항4', date(now()), '공지사항내용4')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항5', date(now()), '공지사항내용5')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항6', date(now()), '공지사항내용6')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항1', date(now()), '공지사항내용1')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항2', date(now()), '공지사항내용2')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항3', date(now()), '공지사항내용3')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항4', date(now()), '공지사항내용4')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항5', date(now()), '공지사항내용5')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항6', date(now()), '공지사항내용6')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항1', date(now()), '공지사항내용1')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항2', date(now()), '공지사항내용2')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항3', date(now()), '공지사항내용3')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항4', date(now()), '공지사항내용4')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항5', date(now()), '공지사항내용5')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항6', date(now()), '공지사항내용6')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항1', date(now()), '공지사항내용1')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항2', date(now()), '공지사항내용2')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항3', date(now()), '공지사항내용3')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항4', date(now()), '공지사항내용4')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항5', date(now()), '공지사항내용5')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항6', date(now()), '공지사항내용6')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항1', date(now()), '공지사항내용1')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항2', date(now()), '공지사항내용2')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항3', date(now()), '공지사항내용3')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항4', date(now()), '공지사항내용4')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항5', date(now()), '공지사항내용5')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항6', date(now()), '공지사항내용6')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항1', date(now()), '공지사항내용1')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항2', date(now()), '공지사항내용2')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항3', date(now()), '공지사항내용3')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항4', date(now()), '공지사항내용4')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항5', date(now()), '공지사항내용5')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항6', date(now()), '공지사항내용6')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항1', date(now()), '공지사항내용1')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항2', date(now()), '공지사항내용2')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항3', date(now()), '공지사항내용3')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항4', date(now()), '공지사항내용4')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항5', date(now()), '공지사항내용5')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항6', date(now()), '공지사항내용6')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항1', date(now()), '공지사항내용1')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항2', date(now()), '공지사항내용2')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항3', date(now()), '공지사항내용3')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항4', date(now()), '공지사항내용4')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항5', date(now()), '공지사항내용5')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항6', date(now()), '공지사항내용6')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항1', date(now()), '공지사항내용1')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항2', date(now()), '공지사항내용2')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항3', date(now()), '공지사항내용3')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항4', date(now()), '공지사항내용4')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항5', date(now()), '공지사항내용5')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항6', date(now()), '공지사항내용6')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항1', date(now()), '공지사항내용1')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항2', date(now()), '공지사항내용2')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항3', date(now()), '공지사항내용3')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항4', date(now()), '공지사항내용4')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항5', date(now()), '공지사항내용5')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항6', date(now()), '공지사항내용6')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항1', date(now()), '공지사항내용1')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항2', date(now()), '공지사항내용2')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항3', date(now()), '공지사항내용3')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항4', date(now()), '공지사항내용4')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항5', date(now()), '공지사항내용5')"; stmt.execute(sql);
   sql="INSERT INTO gongji(title, date, content) values('공지사항6', date(now()), '공지사항내용6')"; stmt.execute(sql);
   
   stmt.close(); // Statement 객체 닫기
   conn.close(); // Connection 객체 닫기
   %>

</body>
</html>