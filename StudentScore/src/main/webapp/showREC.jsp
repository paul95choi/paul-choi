<meta http-equiv="Content-Type" content="text/html; charset=utf-8"> <!--html에서 한글 처리 지시-->
<%@ page contentType="text/html; charset=utf-8" %>  <!--jsp에서 한글 처리 지시-->
<%@ page import="java.sql.*,javax.sql.*,java.io.*"%> <!-- 필요한 파일 import-->


<HTML>
<head> <!-- 머릿말 정의 시작--> 

    <!--script 언어를 javascript로 설정 -->
    <SCRIPT LANGUAGE="JavaScript">
	/* mode 파라미터에 따라 폼의 action 속성을 설정하고 제출하는 javascript 함수*/
   function submitForm(mode) {
        if(mode == "update") { //mode가 update라면 myform의 데이터를 가져와 updateDB.jsp에 할당
            document.getElementById('myform').setAttribute('action', 'updateDB.jsp');
            document.getElementById('myform').submit();
        } else if(mode == "delete") { //mode가 delete라면 myform의 데이터를 가져와  deleteDB.jsp에 할당
            document.getElementById('myform').setAttribute('action', 'deleteDB.jsp');
            document.getElementById('myform').submit();
        }
    } 

    </script>

   <script>
    function checkForm3 () { /* 폼의 입력값을 검사하여 유효성을 확인하는 JavaScript 함수*/
        const form = document.getElementById('myform');  //myform폼에 있는 요소를 form변수에 저장한다.

        const username = form.elements.name.value; //form변수에서 myform폼의 name에 해당하는 값을 id변수에 저장한다.
        const korean = form.elements.kor.value; //form변수에서 myform폼의 kor에 해당하는 값을 id변수에 저장한다.
        const english = form.elements.eng.value; //form변수에서 myform폼의 eng에 해당하는 값을 id변수에 저장한다.
        const mathematics = form.elements.mat.value; //form변수에서 myform폼의 mat에 해당하는 값을 id변수에 저장한다.

        const pattern1 = /^([a-zA-Z]|[가-힣])+$/; //한글,영어만 입력받는 정규식1 생성
        const pattern2 = /^.{1,20}$/; //20자 이내만 입력받는 정규식2 생성
        const pattern3 = /^(?:100|[1-9]?[0-9])$/; //0~100사이의 정수값만 입력받는 정규식3 생성
        
		// username 값이 한글 또는 영문을 20자 이내로 만족하지 않을 경우를 검사하며
		// 입력된 korean, english, mathematics 값 중 하나라도 0부터 100 사이의 정수가 아닐 경우를 검사
        if ((!pattern1.test(username) || !pattern2.test(username)) && (!pattern3.test(korean) || !pattern3.test(english) || !pattern3.test(mathematics))) {
        	//위의 두 조건 중 하나라도 true인 경우, 즉 입력 값이 유효하지 않을 경우 해당하는 알림 메시지를 출력
            alert("한글, 영문을 20자 이내로 입력하고, 점수는 0~100까지의 정수만 입력해주세요."); 
        // 입력된 username 값이 한글 또는 영문을 20자 이내로 만족하지 않을 경우 해당하는 알림 메시지를 출력	
        } else if (!pattern1.test(username) || !pattern2.test(username)) {
            alert("한글과 영문을 20자 이내로 입력하세요");
        // 입력된 korean, english, mathematics 값 중 하나라도 0부터 100 사이의 정수가 아닐 경우 해당하는 알림 메시지를 출력    
        } else if (!pattern3.test(korean) || !pattern3.test(english) ||!pattern3.test(mathematics)) {
            alert("0~100까지 점수만 입력하세요.");
        } else { //위의 조건들을 모두 통과하면 submitForm("update") 함수를 호출하여 폼을 제출
            submitForm("update");
        }
    }
</script>

</head>

<body>

<%	
	//"com.mysql.cj.jdbc.Driver" 클래스를 동적으로 로드한다. 이는 MySQL JDBC 드라이버를 사용하기 위해 필요한 동작
    Class.forName("com.mysql.cj.jdbc.Driver");
	//localhost서버의 "kopo33" 데이터베이스에 "root" 사용자로 연결, 비밀번호는 kopo33.
    Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.200:33060/kopo33", "root", "choi0924");
	// Connection 객체인 conn을 사용하여 SQL 문을 실행하기 위한 Statement 객체를 생성한다.
    Statement stmt = conn.createStatement();
	//값을 담을 문자열 변수 선언
	String name = "", studentid = "", kor = "", eng = "", mat = "";
    String ctmp = request.getParameter("searchid"); //파라미터를 받아와 변수에 저장.

    if (ctmp.length() == 0) ctmp = "0"; //이 문장이 없다면 아무 학번도 없이 조회하는 셈????
 	// student_id가 searchid와 일치하는 데이터를 모두 조회하는 쿼리를 실행하고, 그 결과를 처리하기 위해 ResultSet 객체 rset를 생성하는 구문.
    ResultSet rset = stmt.executeQuery("select * from examtable7 where student_id = " + ctmp);
   
	
    name = "해당학번없음"; //학번이 없으면 해당학번 없음으로 출력
    while (rset.next()) { //resultset 객체의 내용이 모두 빌때까지 반복
    	//resultset 객체가 담고 있는 열의 정보를 하나씩 저장
        name = rset.getString(2); //
        studentid = Integer.toString(rset.getInt(3));
        kor = Integer.toString(rset.getInt(4));
        eng = Integer.toString(rset.getInt(5));
        mat = Integer.toString(rset.getInt(6));
    }
 	//사용한 리소스를 정리하고 데이터베이스 연결을 종료.
    stmt.close();
    conn.close();
    
	//}
%>

<h1>성적 조회 후 정정/삭제</h1>
	  <!-- showREC.jsp로 데이터를 post방식으로 전송하는 form선언 -->
      <form method='post' action='showREC.jsp'>
        <table cellspacing=1 width=400 border=0>
        <tr>
            <td width=100><p align=center>조회할 학번</p></td>
            <!-- 입력 필드(<input type='text'>)가 생성되며, name 속성은 "searchid"로 설정되고, value 속성은 <%=ctmp%>으로 설정 -->
            <!-- 이 입력 필드에는 ctmp 변수의 값이 초기값으로 설정 -->
            <td width=300><p align=center><input type='text' name='searchid' value='<%=ctmp%>'></p></td>
            <td width=100><input type="submit" value="조회"></td>
        </tr>
        </table>
    </form> 
    

    

<!-- =============================================================================================================================  -->
		<!-- 폼을 생성하고, post 방식으로 데이터를 전송하며, 폼의 식별자를 "myform"으로 지정. 
		이 폼은 버튼이 두 개 있으므로 자바스크립트 함수를 사용하여 분기 처리를 할 수 있도록 설정 -->
	    <form method='post' id='myform'>
	    <!-- 숨겨진 입력 필드로서, name 속성이 "studentid"로 지정되고, value 속성에는 studentid로 설정. 
	    studentid는 JSP 코드로, 변수 studentid의 값을 출력. 이 입력 필드를 통해 학번 값을 전송 -->
	    <input type="hidden" name="studentid" value="<%=studentid%>">
	    
	        <table cellspacing=1 width=400 border=1>
	        <tr>
	            <td width=100><p align=center>이름</p></td>
	            <!-- 이 입력 필드에는 name 변수의 값이 초기값으로 설정 -->
	            <td width=300><p align=center><input type='text' name='name' value='<%=name%>'></p></td>
	        </tr>
	        <tr>
	            <td width=100><p align=center>학번</p></td>
	            <!-- 이 입력 필드에는 studentid 변수의 값이 초기값으로 설정 -->
	         	<td width=300><p align=center><input type='text' name='studentid' value='<%=studentid%>' readonly></p></td>
	        </tr>
	        <tr>
	            <td width=100><p align=center>국어</p></td>
	             <!-- 이 입력 필드에는 kor 변수의 값이 초기값으로 설정 -->
	            <td width=300><p align=center><input type='text' name='kor' value='<%=kor%>'></p></td>
	        </tr>
	        <tr>
	            <td width=100><p align=center>영어</p></td>
	             <!-- 이 입력 필드에는 eng 변수의 값이 초기값으로 설정 -->
	            <td width=300><p align=center><input type='text' name='eng' value='<%=eng%>'></p></td>
	        </tr>
	        <tr>
	            <td width=100><p align=center>수학</p></td>
	             <!-- 이 입력 필드에는 mat 변수의 값이 초기값으로 설정 -->
	            <td width=300><p align=center><input type='text' name='mat' value='<%=mat%>'></p></td>
	        </tr>
	        </table>


<!--수정, 삭제 버튼-->
<%	//학번이 존재하는 경우에만 수정과 삭제 버튼이 포함된 테이블을 출력하는 코드
    if(studentid.length() != 0) { //학번이 비어있지 않은 경우에만 아래의 코드 블록을 실행 즉, 학번이 존재하는 경우에만 수정과 삭제 버튼이 출력
        out.println("<table cellspacing=1 width=400 border=0>");
        out.println("<tr>");
        out.println("<td width=200></td>");
        // 수정 버튼이 포함된 셀을 생성하는 태그를 출력. 버튼을 클릭하면 checkForm3() 함수가 실행
        out.println("<td width=100><p align=center><input type=button value=\"수정\" onClick=\"checkForm3()\"></p></td>");
        //삭제 버튼이 포함된 셀을 생성하는 태그를 출력. 버튼을 클릭하면 submitForm('delete') 함수가 실행
        out.println("<td width=100><p align=center><input type=button value=\"삭제\" onClick=\"submitForm('delete')\"></p></td>");
        out.println("</tr>");
        out.println("</table>");
    }
%>
</form>

</body>
</html>