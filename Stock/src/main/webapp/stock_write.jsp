<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, javax.sql.*, java.io.*, java.net.*, java.util.*"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>

<%@ page import="Stock_dao.*"%>
<%@ page import="Stock_domain.*"%>
<%@ page import="Stock_dto.*"%>
<%@ page import="Stock_service.*"%>
<html>
<head>
<title>stock_write.jsp</title>
</head>
<body>
<%	//이미지받기
	String path = "/upload/image/";
	//파일이 저장되는 실제경로
	String realPath = request.getServletContext().getRealPath(path);
	//System.out.println("insert2.jsp - realPath : " + realPath);
	  
	//저장용량제한
	int size = 10 * 1024 * 1024;
	  
	//실제적으로 파일 업로드하는 처리문   
	MultipartRequest multi = new MultipartRequest(request, realPath, size, "utf-8", new DefaultFileRenamePolicy());
	
	//request.setCharacterEncoding("UTF-8"); // 요청 문자 인코딩을 UTF-8로 설정
	int idx = Integer.parseInt(multi.getParameter("id"));
	int Cnt = Integer.parseInt(multi.getParameter("amount"));
	String name = multi.getParameter("title");
	String content = multi.getParameter("content");
	String image = multi.getFilesystemName("goodsimg");
	
	Stock Updatestock = new Stock();
	Updatestock.setId(idx);
	Updatestock.setAmount(Cnt);
	Updatestock.setTitle(name);
	Updatestock.setContent(content);
	Updatestock.setImg(image);
	
	Stock_Dao stockDao = new Stock_Dao_Impl();
	Stock_Service stockService = new Stock_ServiceImpl();
	stockDao.insertrecord(Updatestock);
	
%>		 
	<div style="text-align : center;">
		<h1>[<%=name %>]상품이 등록되었습니다.</h1>
	</div>
	<hr>
	<button onclick="location.href = 'stock_list.jsp';">목록</button>

</body>
</html>
