<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, javax.sql.*, java.io.*, java.net.*, java.util.*"%>
<%@ page import="javax.sql.rowset.serial.SerialBlob"%>

<%@ page import="kr.ac.kopo21.dao.*"%>
<%@ page import="kr.ac.kopo21.domain.*"%>
<%@ page import="kr.ac.kopo21.dto.*"%>
<%@ page import="kr.ac.kopo21.service.*"%>
<html>
<head>
<meta charset="UTF-8">
<title>재고 수정</title>
<script>
   function submitForm(mode, productNum) {
      var fm = document.forms['fm'];
      fm.elements['mode'].value = mode;
      fm.elements['productNum'].value = productNum;
      fm.action = "product_write.jsp";
      fm.submit();
   }
</script>
<script>
   function countCharacters(element) {
      var text = element.value;
      var charCount = text.length;
      document.getElementById('charCount').textContent = charCount + '/1000';
   }
</script>
<script>
   function checkForm1() {
      const form = document.getElementById('write');

      const productNum = form.elements.productNum.value.trim();
      const productName = form.elements.productName.value.trim();
      const productEa = form.elements.productEa.value.trim();
      const content = form.elements.content.value.trim();

      const pattern = /^(?!\s)([\s\S]*)$/; // 공백이 없는 문자열을 검사하는 정규식 패턴
      const patternNumber = /^\d+$/; // 숫자만 허용하는 정규식 패턴
      const maxContentLength = 1000;

      if (!patternNumber.test(productNum) || !patternNumber.test(productEa)) {
         alert("상품 번호와 수량은 숫자만 입력해주세요.");
      } else if (!pattern.test(productName) || !pattern.test(content)) {
         alert("상품명과 내용에는 공백이 없도록 입력해주세요.");
      } else if (content.length > maxContentLength) {
         alert("상세 내용은 1000자를 넘을 수 없습니다.");
      } else {
         form.action = "product_write.jsp";
         form.submit();
      }
   }
</script>
</head>
<body>
   <%
   int productNumIdx = 0;
   String productNameIdx = "";
   int productEaIdx = 0;
   String productRegistDateIdx = "";
   String inventoryRegistDateIdx = "";
   String contentIdx = "";
   String path = "./";
   String realPath = request.getServletContext().getRealPath(path);
   System.out.println("product_write.jsp - realPath :" + realPath);
   int size = 1024 * 1024 * 1024; // 저장크기 제한 
   
   // 파일 업로드 하기위한 코드
   //MultipartRequest multi = new MultipartRequest(request, realPath, size, "utf-8", new DefaultFileRenamePolicy());
   
   
   

   request.setCharacterEncoding("UTF-8"); // 요청 문자 인코딩을 UTF-8로 설정

   String key = request.getParameter("key"); // key 값 가져오기
   String mode = request.getParameter("mode");
   String productNum = request.getParameter("productNum");
   String productName = request.getParameter("productName");
   String productEa = request.getParameter("productEa");
   String productRegistDate = request.getParameter("productRegistDate");
   String inventoryRegistDate = request.getParameter("inventoryRegistDate");
   String content = request.getParameter("content");
   

   ProductDao productDao = new ProductDaoImpl();
   ProductService productService = new ProductServiceImpl();
   Product product = new Product();

   if (mode != null && mode.equals("update")) {
      productNumIdx = Integer.parseInt(productNum);
      productNameIdx = productName;
      productEaIdx = Integer.parseInt(productEa);
      productRegistDateIdx = productRegistDate;
      inventoryRegistDateIdx = productDao.inventoryRegistDate();
      contentIdx = content;
   } else if (mode != null && mode.equals("write")) {
      product.setKeyNum(Integer.parseInt(key));
      product.setProductName(productName);
      product.setProductEa(Integer.parseInt(productEa));
      product.setProductRegistDay(productRegistDate);
      product.setContent(content);

      productDao.update(product.getKeyNum(), product);

      productNumIdx = product.getKeyNum();
      productNameIdx = product.getProductName();
      productEaIdx = product.getProductEa();
      productRegistDateIdx = product.getProductRegistDay();
      inventoryRegistDateIdx = productDao.inventoryRegistDate();
      contentIdx = product.getContent();

   }

   %>
   <form id="write" method="post" name="fm" action="product_write.jsp" enctype="multipart/form-data">
      <input type="hidden" name="mode" value="">
      <input type="hidden" name="productNum" value="">
      <table width="800" border="1" cellspacing="0" cellpadding="5">
         <tr>
            <td style="background-color: gray;"><b>상품 번호</b></td>
            <td><input type="text" name="productNum" size="70" maxlength="70" value="<%=productNumIdx%>" <% if (mode != null && mode.equals("update")) { %>readonly<% } %>></td>
         </tr>
         <tr>
            <td style="background-color: gray;"><b>상품명</b></td>
            <td><input type="text" name="productName" size="70" maxlength="70" value="<%=productNameIdx%>"></td>
         </tr>
         <tr>
               <td style="background-color: gray;"><b>재고 수량</b></td>
            <td><input type="text" name="productEa" size="70" maxlength="70" value="<%=productEaIdx%>"></td>
         </tr>
         <tr>
               <td style="background-color: gray;"><b>상품 등록일</b></td>
            <td><%=productRegistDateIdx%></td>
         </tr>
         <tr>
               <td style="background-color: gray;"><b>재고 등록일</b></td>
            <td><%=inventoryRegistDateIdx%></td>
         </tr>
         <tr>
               <td style="background-color: gray;"><b>상세 내용</b></td>
            <td><textarea name="content" cols="70" rows="10" oninput="countCharacters(this)"><%=contentIdx%></textarea></td>
         </tr>
      </table>
      <table width="800">
         <tr>
            <td width="800"></td>
            <td><input type="button" value="취소" onclick="location.href='product_list.jsp'"></td>
            <% if (mode != null && mode.equals("update")) { %>
               <td><input type="button" value="수정" onclick="submitForm('update', '<%=productNumIdx%>')"></td>
            <% } else { %>
               <td><input type="button" value="쓰기" onclick="checkForm1()"></td>
            <% } %>
            <td><input type="button" value="삭제" onclick="submitForm('delete', '<%=productNumIdx%>')"></td>
         </tr>
      </table>
   </form>
</body>
</html>