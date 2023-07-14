<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page
	import="java.sql.*, javax.sql.*, java.io.*, java.net.*, java.util.*"%>
<%@ page import="java.text.*,java.time.*,java.time.format.*"%>

<%@ page import="Stock_dao.*"%>
<%@ page import="Stock_domain.*"%>
<%@ page import="Stock_dto.*"%>
<%@ page import="Stock_service.*"%>
<head>
<title>stock_insert.jsp</title>

<script>
	function submitForm(mode) {// 폼 요소에 접근하기 위해 폼을 가져옴
		var fm = document.forms['fm'];
		if (mode == "write") {// mode에 따라 동작 결정
			// "write" 모드인 경우
			// 폼의 액션을 "stock_write.jsp"로 설정
			fm.action = "stock_write.jsp";
			fm.submit();// 폼을 제출하여 페이지 이동
		}
	}
	
</script>
<script>
	function checkForm1() { //입력된 문자를 검사하는 함수 선언
		const form = document.getElementById('insert'); //insert폼에 있는 요소를 form변수에 저장한다.

		const title = form.elements.title.value; //form변수에서 insert폼의 id에 해당하는 값을 id변수에 저장한다.
		
		const content = form.elements.content.value;//name변수에서 insert폼의 name에 해당하는 값을 name변수에 저장한다.

		//const pattern1 = /^([a-zA-Z가-힣]{1,20})$/; //한글(초성, 중성, 종성), 영어만 입력받고, 20자 이내로 입력받는 정규식1 생성
		//const pattern2 = /^[1-9][0-9]?$/; // 1~100사이의 정수값만 입력받는 정규식2 생성
		const pattern3 = /^(?!\s)([\s\S]*)$/;

		if (!pattern3.test(title) && !pattern3.test(content)) { //id값이 pattern2 테스트를 실패하고, name값이 pattern1 테스트를 실패한다면 
			alert("상품명과 내용을 입력해주세요 "); // 경고창 팝업
		}
		if (!pattern3.test(title)) { //name값이 pattern1 테스트를 실패한다면
			alert("상품을 입력해주세요");// 경고창 팝업
		} else if (!pattern2.test(id)) { //id값이 pattern2 테스트를 실패한다면
			alert("1~1000까지 숫자만 입력하세요.");// 경고창 팝업
		} else {
			form.action = "A_03_H.jsp"; // "테스트를 모두 통과한다면 A_03_H.jsp"를 인자로 제공.
			form.submit();
		}
	}
</script>
</head>
<body>
	<%
	int idIdxNum = 0; //id값을 받을 변수 선언
	int aID = 1;
	String title = "";
	String content = "";

	Stock_Dao stockDao = new Stock_Dao_Impl();
	Stock_Service stockService = new Stock_ServiceImpl();
	Stock stock = new Stock();
	stockDao.insert(stock);	
	%>
	<form method=post name="fm" enctype="multipart/form-data">
		<table width=650 border=1 cellspacing=0 cellpadding=5>
			<tr>
				<td><b>상품등록번호</b></td>
				<td><input type="number" name=id ></td>
			</tr>
			<tr>
				<td><b>상품명</b></td>
				<td><input type="text" required name="title" size="70"
					maxlength="70" pattern="^\S.*$" placeholder="상품명을 입력해주세요"></td>
			</tr>
			<tr>
				<td><b>상품수량</b></td>
				<td><input type="number" required name="amount" size="70"
					maxlength="70" pattern="^\S.*$"  placeholder="상품수량을 입력해주세요"></td>
			</tr>
			<tr>
				<td><b>상품등록일</b></td>
				<!-- 현재 날짜를 stockDao.date()로 가져오는 경우 -->
				<td><%=stockDao.date()%><input type=hidden name=date
					value=<%=stockDao.date()%> readonly></td>
			</tr>
			<tr>
				<td><b>재고파악일자</b></td>
				<!-- 현재 날짜를 stockDao.date()로 가져오는 경우 -->
				<td><%=stockDao.date()%><input type=hidden name=date
					value=<%=stockDao.date()%> readonly></td>
			</tr>
			<tr>
				<td><b>상품설명</b></td>
				<td><textarea style="width: 500px; height: 100px;" required
						name=content cols=70 rows=600 placeholder="상품내용을 입력해주세요"></textarea></td>
			</tr>
			<tr>
				<td><b>상품사진</b></td>
				<td><!-- 파일 선택 시 이벤트 리스너와 함수 호출 -->
                 <input type="file" name="goodsimg" id="goodsimg">
                 <img src="#" id="preview" alt="Preview" style="max-width: 200px; max-height: 200px; display: none;">
            	</td>
			</tr>
			 <script>
       // 파일 선택 시 미리보기 함수 호출
       document.getElementById('goodsimg').addEventListener('change', function(event) {
           previewImage(event.target);
           checkFileExtension(event.target);
       });
   
      //파일 확장명 체크 함수
       function checkFileExtension(input) {
           var file = input.files[0];
           var allowedExtensions = ['jpg', 'jpeg', 'png', 'gif'];
           var fileExtension = getFileExtension(file.name);
           var preview = document.getElementById('preview');

           if (!allowedExtensions.includes(fileExtension)) {
               alert('jpg, jpeg, png, gif 확장명만 업로드할 수 있습니다.');
               input.value = '';
               preview.style.display = 'none';
               document.querySelector('form').reset(); // 입력값 초기화
           } else {
               previewImage(input, preview);
           }
       }

       // 파일 확장명 추출 함수
       function getFileExtension(filename) {
           return filename.split('.').pop().toLowerCase();
       }

       // 이미지 미리보기 함수
       function previewImage(input, preview) {
           if (input.files && input.files[0]) {
               var reader = new FileReader();

               reader.onload = function(e) {
                   preview.setAttribute('src', e.target.result);
                   preview.style.display = 'block';
               }
               reader.readAsDataURL(input.files[0]);
           } else {
               preview.style.display = 'none';
           }
       }
   </script>
			
		</table>
		<table width=650>
			<tr>
				<td><input type=button value="취소"
					OnClick="location.href='stock_list.jsp'"></td>
				<td><input type=button value="상품등록" OnClick="submitForm('write')"></td>
				<!--  <td><input type=submit value="쓰기"></td> -->
			</tr>

		</table>
	</form>

	<!-- ////////////////////////////// -->
</body>
</html>