<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, javax.sql.*, java.io.*, java.net.*, java.util.*"%>
<%@ page import="java.text.*,java.time.*,java.time.format.*"%>
<html>
<head>
<title>gongji_view.jsp</title>
</head>
<body>

<%
Calendar cdr = Calendar.getInstance();// 현재 시간 정보를 가지는 Calendar 객체 생성
SimpleDateFormat sdt = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");// 날짜 형식을 지정하기 위한 SimpleDateFormat 객체 생성
LocalDateTime now = LocalDateTime.now(); // 현재 시간 정보를 가지는 LocalDateTime 객체 생성
sdt.format(cdr.getTime());// Calendar 객체에서 시간 정보를 가져와서 지정한 형식에 맞게 문자열로 변환
%>
	<form method=post name='fm'>
		<table width=650 border=1 cellspacing=0 cellpadding=5>
		
		<%		
		String idKey = request.getParameter("key");
		
		try {
			//com.mysql.cj.jdbc.Driver 클래스를 동적으로 로드. mysql jdbc 드라이버를 사용하기 위해 필요한 동작.
			Class.forName("com.mysql.cj.jdbc.Driver");
			// localhost서버의 "kopo33" 데이터베이스에 "root" 사용자로 연결, 비밀번호는 choi0924.
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.200:33060/kopo33", "root", "choi0924");
			// Connection 객체인 conn을 사용하여 SQL 문을 실행하기 위한 Statement 객체를 생성한다.
			Statement stmt = conn.createStatement();
			
			//sql문자열변수에 sql문을 저장
			String sql = "select * from gongji where id = " + idKey;
			//resultset에 sql문 실행한 결과를 저장.
			ResultSet rset = stmt.executeQuery(sql);
			//resultset이 빌때까지 반복
			
			while(rset.next()){
				//id변수에 resultset의 1번 열 데이터를 저장.
				int id = rset.getInt(1);
				//name변수에 resultset의 2번 열 데이터를 저장.
				String name = rset.getString(2);
				String date =rset.getString(3);
				Clob clob = rset.getClob("content");
				String content = "";
				if (clob != null) {
				    content = clob.getSubString(1, (int) clob.length());
				}
				
				//out.println("<tr>");
		        //out.println("<td><b>번호</b></td>"); //행을 반복 출력
		        //out.println("<td><b>" + id + "</b></td>"); //행을 반복 출력
		        //out.println("</tr>");
				out.println("<tr>");
		        out.println("<td><b>제목</b></td>"); //행을 반복 출력
		        out.println("<td><b>" + name + "</b></td>"); //행을 반복 출력
		        out.println("</tr>");
				out.println("<tr>");
		        out.println("<td><b>일자</b></td>"); //행을 반복 출력
		        out.println("<td><b>" + date + "</b></td>"); //행을 반복 출력
		        out.println("</tr>");
				out.println("<tr>");
		        out.println("<td><b>내용</b></td>"); //행을 반복 출력
		        out.println("<td><b>" + content + "</b></td>"); //행을 반복 출력
		        out.println("</tr>");
			}
			
			rset.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {  //try블록에서 발생할 수 있는 예외를 처리하기 위한 catch 블록
			e.printStackTrace(); //에러 문자열 콘솔에 출력
			//return null;
		}
		%>		


		</table>
		<table width=650>
			<tr>
				<td width=600></td>
				<td><input type=button value="목록" OnClick="location.href='gongji_list.jsp'"></td>
				<td><input type=button value="수정" OnClick="location.href='gongji_update.jsp?key=<%=idKey%>'"></td>
				<td><input type=button value="삭제" OnClick="location.href='gongji_delete.jsp?key=<%=idKey%>'"></td>
			</tr>
		</table>
	</form>

	
	
	<!-- ////////////////////////////// -->
</body>
</html>