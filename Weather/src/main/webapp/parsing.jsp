<%@page import="org.w3c.dom.*"%>
<%@page import="org.w3c.dom.NodeList"%>
<%@page import="javax.xml.parsers.DocumentBuilderFactory"%>
<%@page import="javax.xml.parsers.DocumentBuilder"%>
<%@ page contentType="text/html; charset=utf-8"%> <%-- 페이지의 콘텐츠 타입과 문자 인코딩 설정 --%>
<%@ page import="java.sql.*, javax.sql.*, java.io.*"%> <%-- jsp파일에 java 클래스, java sql import --%>

<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
   <%
   // DocumentBuilder 객체를 생성합니다.
   DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

   // XML 문서를 파싱하여 Document 객체를 생성합니다.
   // XML 문서의 경로나 URL을 파라미터로 전달할 수 있습니다.
   Document doc = docBuilder.parse("http://192.168.23.200:8081/Weather/xmlmake.jsp");

   // XML 문서의 루트 엘리먼트를 가져옵니다.
   Element root = doc.getDocumentElement();

   // 각각의 태그에 해당하는 NodeList를 가져옵니다.
   NodeList tag_name = doc.getElementsByTagName("name");
   NodeList tag_studentid = doc.getElementsByTagName("studentid");
   NodeList tag_kor = doc.getElementsByTagName("kor");
   NodeList tag_eng = doc.getElementsByTagName("eng");
   NodeList tag_mat = doc.getElementsByTagName("mat");

   // HTML 테이블을 생성합니다.
   out.println("<table cellspacing=1 width=500 border=1>");
   out.println("<tr>");
   out.println("<td width=100>이름</td>");
   out.println("<td width=100>학번</td>");
   out.println("<td width=100>국어</td>");
   out.println("<td width=100>영어</td>");
   out.println("<td width=100>수학</td>");
   out.println("</tr>");

   // NodeList에 저장된 데이터를 반복하여 HTML 테이블의 행으로 출력합니다.
   for(int i=0; i<tag_name.getLength(); i++){
       out.println("<tr>");
      out.println("<td width=100>"+tag_name.item(i).getFirstChild().getNodeValue()+"</td>"); // name 엘리먼트의 값을 가져와서 출력합니다.
      out.println("<td width=100>"+tag_studentid.item(i).getFirstChild().getNodeValue()+"</td>"); // studentid 엘리먼트의 값을 가져와서 출력합니다.
      out.println("<td width=100>"+tag_kor.item(i).getFirstChild().getNodeValue()+"</td>"); // kor 엘리먼트의 값을 가져와서 출력합니다.
      out.println("<td width=100>"+tag_eng.item(i).getFirstChild().getNodeValue()+"</td>"); // eng 엘리먼트의 값을 가져와서 출력합니다.
      out.println("<td width=100>"+tag_mat.item(i).getFirstChild().getNodeValue()+"</td>"); // mat 엘리먼트의 값을 가져와서 출력합니다.
      out.println("</tr>");
   }

   %>


</body>
</html>