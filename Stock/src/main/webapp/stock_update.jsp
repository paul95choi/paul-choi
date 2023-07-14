<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, javax.sql.*, java.io.*, java.net.*, java.util.*"%>

<%@ page import="Stock_dao.*"%>
<%@ page import="Stock_domain.*"%>
<%@ page import="Stock_dto.*"%>
<%@ page import="Stock_service.*"%>


<html>
<head>
<title>stock_update_H.jsp</title>
<script>
function submitForm(mode, idIdx) {
	  var fm = document.forms['fm'];
	  if (mode == "update") {
	    fm.action = "stock_update2.jsp?key=" + idIdx;
	    fm.submit();
	  } else if (mode == "delete") {
		fm.action = "stock_delete.jsp?key=" + idIdx;
		fm.submit();
	  }
	}

</script>
</head>
<body>
	<%
	int idIdx = 0;
	String titleIdx = "";
	int amountIdx = 0;
	String dateIdx = "";
	String contentIdx = "";
	String dateIdex2 = "";
	String imgIdx="";
	
	request.setCharacterEncoding("UTF-8"); // 요청 문자 인코딩을 UTF-8로 설정
	
	String idKey = request.getParameter("key");
	String title = request.getParameter("title");
	String createdate= request.getParameter("createdate");
	String content = request.getParameter("content");
	
	Stock_Dao stockDao = new Stock_Dao_Impl();
	Stock_Service webBoardService = new Stock_ServiceImpl();
	Stock stock = new Stock();
	
	stock.setKeyNum(Integer.parseInt(idKey));
	
	List<Stock> results = stockDao.OneView(stock.getKeyNum(), stock);
	
	for(Stock stocks : results) {
		idIdx = stocks.getId();
		titleIdx = stocks.getTitle();
		amountIdx = stocks.getAmount();
		dateIdx = stocks.getDate(); //재고파악일
		dateIdex2 = stocks.getCreateDate(); //상품등록일
		contentIdx= stocks.getContent();
		imgIdx = stocks.getImg();
	}
	
	System.out.println(imgIdx);
	//이미지받기
    String path = "/upload/image/" + imgIdx;
    //파일이 저장되는 실제경로
    String realPath = request.getServletContext().getRealPath(path);
    //이미지를 나타낼 url경로
    String imagePath = request.getContextPath() + "/upload/image/" + imgIdx;
    //System.out.println(realPath);
    
//webBoardDao.update(webBoard.getKeyNum(), webBoard);
%>
	<form method=post name='fm' action="stock_write.jsp">

	
	<table width=650 border=1 cellspacing=0 cellpadding=5>
		<tr>
			<td><b>상품번호</b></td>
			<td><input type=text name=ids size=70 maxlength=70 value=<%= idIdx %> readonly></td>
		</tr>
		<tr>
			<td><b>상품명</b></td>
			<td><input type=text name=titles size=70 maxlength=70 value=<%=titleIdx %> readonly></td>
		</tr>
		<tr>
			<td><b>현재상품수량</b></td>
			<td><input type=number name=amount size=70 maxlength=70 value="<%=amountIdx %>"></td>
		</tr>
		<tr>
			<td><b>상품등록일자</b></td>
			<td><input type=text name=createdates size=70 maxlength=70 value=<%=dateIdex2 %> readonly></td>
		</tr>				
		<tr>
		<tr>
			<td><b>재고파악일자</b></td>
			<td><input type=text name=dates size=70 maxlength=70 value=<%=dateIdx %> readonly></td>
		</tr>				
		<tr>
			<td><b>상품설명</b></td>
			<td><textarea style='width:500px; height:100px;' name=contents cols=70 rows=600 readonly><%=contentIdx %></textarea></td>
		</tr>
		<tr>
			<td><b>상품사진</b></td>
			<td><img src="<%=imagePath %>" style='width:150px; height:100px;'></td>
		</tr>		
	</table>
	<table width=650>
	<tr>
		<td width=600></td>
		<td><input type=button value="취소" OnClick="location.href='stock_list.jsp'"></td>
		<td><input type=button value="상품등록" OnClick="submitForm('update', '<%= idIdx %>')"></td>
		<td><input type=button value="상품삭제" OnClick="submitForm('delete', '<%= idIdx %>')"></td>
	</tr>
	</table>
	</form>
	
	
	<!--  <td><input type=button value="쓰기" OnClick="submitForm('write')"></td> -->
	<!--  <td><input type=button value="쓰기" OnClick="location.href='gongji_write.jsp?key=<%= idIdx %>'"></td> -->
	<!--  <td><input type="button" value="쓰기" onclick="location.href='gongji_write.jsp?key=<%= idIdx %>&ids=<%=titleIdx %>&titles=<%=dateIdx %>&dates=<%=contentIdx %>&contents=<%=contentIdx %>'"></td> -->
</body>
</html>