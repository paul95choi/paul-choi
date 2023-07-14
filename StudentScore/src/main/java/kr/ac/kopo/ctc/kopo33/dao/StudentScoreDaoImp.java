package kr.ac.kopo.ctc.kopo33.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.ctc.kopo33.domain.StudentScore;

public class StudentScoreDaoImp implements StudentScoreDao {

	@Override
	public String createTable() { //테이블을 만드는 메서드
		// TODO Auto-generated method stub

		try {// 예외가 발생할 수 있는 코드 블록을 try 블록으로 감싸서 예외 처리를 시작한다.
			// "com.mysql.cj.jdbc.Driver" 클래스를 동적으로 로드한다. 이는 MySQL JDBC 드라이버를 사용하기 위해 필요한 동작
			Class.forName("com.mysql.cj.jdbc.Driver");
			// localhost서버의 "kopo33" 데이터베이스에 "root" 사용자로 연결, 비밀번호는 choi0924.
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.200:33060/kopo33", "root", "choi0924");
			// Connection 객체인 conn을 사용하여 SQL 문을 실행하기 위한 Statement 객체를 생성한다.
			Statement stmt = conn.createStatement();
			// 생성한 Statement 객체 stmt를 사용하여 sql문을 실행한다. examtable7라는 테이블을 생성하고 각 열의 이름과 형식을
			// 지정한다.
			stmt.execute(
					"create table examtable7(id int auto_increment not null primary key, name varchar(20), student_id int not null unique, "
					+ "kor int, eng int, mat int) DEFAULT CHARSET =utf8;");
			stmt.close(); // Statement객체를 닫아 자원을 해제
			stmt.close(); // Statement객체를 닫아 자원을 해제
			conn.close(); // connection객체를 닫아 자원을 해제

			// try 블록에서 발생할 수 있는 오류를 처리하기 위한 catch 블록이다.
			// 예외가 발생한 경우에는 예외 정보를 출력한다.
		} catch (Exception e) {
			e.printStackTrace();
			return "이미 존재하는 테이블입니다";
		}	//String 반환
		return "테이블이 생성되었습니다.";
	}

// ============================================================================================================================================================
	@Override
	public String insertData() { //데이터를 생성하고 테이블에 입력하는 메서드
		// TODO Auto-generated method stub

		try {// 예외가 발생할 수 있는 코드 블록을 try 블록으로 감싸서 예외 처리를 시작한다.
				// "com.mysql.cj.jdbc.Driver" 클래스를 동적으로 로드한다. 이는 MySQL JDBC 드라이버를 사용하기 위해 필요한 동작
			Class.forName("com.mysql.cj.jdbc.Driver");
			// localhost서버의 "kopo33" 데이터베이스에 "root" 사용자로 연결, 비밀번호는 choi0924.
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.200:33060/kopo33", "root", "choi0924");
			// Connection 객체인 conn을 사용하여 SQL 문을 실행하기 위한 Statement 객체를 생성한다.
			Statement stmt = conn.createStatement();
			// 생성한 Statement 객체 stmt를 사용하여 sql문을 실행한다. examtable4라는 테이블의 각 열에 데이터를 삽입한다.
			//sql구문을 저장한다. 해당 sql구문은 프로시저를 실행하는 구문이다.
			String storedProcedure = "{call insert_examtable7(?)}";
			//callablestatement 메서드를 이용하여 프로시저를 실행하기 위해 cstmt변수에 저장한다..
			CallableStatement cstmt = conn.prepareCall(storedProcedure);
			cstmt.setInt(1, 300); // 저장 프로시저 매개변수 설정
			cstmt.executeUpdate(); //callablestatement를 실행한다.

			stmt.close(); // Statement객체를 닫아 자원을 해제
			conn.close(); // connection객체를 닫아 자원을 해제

			// try 블록에서 발생할 수 있는 오류를 처리하기 위한 catch 블록이다.
			// 예외가 발생한 경우에는 예외 정보를 출력한다.
		} catch (Exception e) {
			e.printStackTrace();
			return "테이블에 데이터가 존재합니다";
		}//String 반환
		return "데이터가 입력되었습니다";
	}

// ============================================================================================================================================================
	@Override
	public String DropTable() { //테이블에 DROP하는 메서드
		// TODO Auto-generated method stub
	
		try {// 예외가 발생할 수 있는 코드 블록을 try 블록으로 감싸서 예외 처리를 시작한다.
				// "com.mysql.cj.jdbc.Driver" 클래스를 동적으로 로드한다. 이는 MySQL JDBC 드라이버를 사용하기 위해 필요한 동작
			Class.forName("com.mysql.cj.jdbc.Driver");
			// localhost서버의 "kopo33" 데이터베이스에 "root" 사용자로 연결, 비밀번호는 choi0924.
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.200:33060/kopo33", "root", "choi0924");
			// Connection 객체인 conn을 사용하여 SQL 문을 실행하기 위한 Statement 객체를 생성한다.
			Statement stmt = conn.createStatement();
			// 생성한 Statement 객체 stmt를 사용하여 sql문을 실행한다. examtable7라는 테이블을 삭제한다.
			stmt.execute("drop table examtable7;");

			stmt.close(); // Statement객체를 닫아 자원을 해제
			conn.close(); // connection객체를 닫아 자원을 해제

			// try 블록에서 발생할 수 있는 오류를 처리하기 위한 catch 블록이다.
			// 예외가 발생한 경우에는 예외 정보를 출력한다.
		} catch (Exception e) {
			System.out.println(e);
			return "테이블이 없습니다.";
		}
		//String 반환
		return "테이블이 삭제되었습니다.";
	}

// ============================================================================================================================================================
	@Override //studentid와 일치하는 행을 보여주는 메서드
	public StudentScore selectOne(int studentId, StudentScore studentScoreOneView) { 
		// 해당 id를 가진 StudentScore가 데이터베이스에 없다면 null을 반환
		StudentScore result = null;

		try {
			// "com.mysql.cj.jdbc.Driver" 클래스를 동적으로 로드한다. 이는 MySQL JDBC 드라이버를 사용하기 위해 필요한 동작
			Class.forName("com.mysql.cj.jdbc.Driver");
			// localhost서버의 "kopo33" 데이터베이스에 "root" 사용자로 연결, 비밀번호는 choi0924.
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.200:33060/kopo33", "root", "choi0924");
			// Connection 객체인 conn을 사용하여 SQL 문을 실행하기 위한 Statement 객체를 생성한다.
			Statement stmt = conn.createStatement();

			// ckey라는 이름의 문자열 변수를 선언하고, request.getParameter("key")에서 가져온 값을 할당.
			int ckey = studentId;
			// stmt라는 Statement 객체를 사용하여 examtable7에서 name열이 ckey변수가 가지고 있는 문자열과 일치하는 조건의
			// 데이터를 모두 조회하는 쿼리를 실행하고, 그 결과를 처리하기 위해 ResultSet 객체 rset를 생성하는 구문.
			ResultSet rset = stmt.executeQuery(
					"select r.name, r.student_id, r.kor, r.mat, r.eng, r.kor+r.eng+r.mat as tot, ((r.kor+r.eng+r.mat) / 3.0) as avg, "
							+ "(SELECT COUNT(*) + 1 FROM examtable7 as r2 WHERE r2.kor + r2.eng + r2.mat > r.kor + r.eng + r.mat) AS ran "
							+ "from examtable7 as r where student_id = '" + ckey + "';");

			rset.close(); // ResultSet객체를 닫아 자원을 해제
			stmt.close(); // Statement객체를 닫아 자원을 해제
			conn.close(); // Connection객체를 닫아 자원을 해제
		// try 블록에서 발생할 수 있는 오류를 처리하기 위한 catch 블록이다.
		// 예외가 발생한 경우에는 예외 정보를 출력한다.
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} //studentScoreOneView 메서드 반환
		return studentScoreOneView;
	}
// ============================================================================================================================================================

	@Override //examtable7 테이블의 모든 데이터를 보여주는 메서드
	public List<StudentScore> selectAll(int page, int countPerPage) {
		// TODO Auto-generated method stub
		List<StudentScore> results = new ArrayList<>();

		try {
			// "com.mysql.cj.jdbc.Driver" 클래스를 동적으로 로드한다. 이는 MySQL JDBC 드라이버를 사용하기 위해 필요한 동작
			Class.forName("com.mysql.cj.jdbc.Driver");
			// localhost서버의 "kopo33" 데이터베이스에 "root" 사용자로 연결, 비밀번호는 choi0924.
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.200:33060/kopo33", "root", "choi0924");
			
			//이 쿼리문은 examtable7 테이블에서 학생의 이름, 학번, 국어 점수, 영어 점수, 수학 점수, 총점, 평균, 순위 정보를 조회. 
			//limit과 offset을 사용하여 페이지와 페이지당 항목 수에 따라 결과를 제한
			String sql = "select r.name, r.student_id, r.kor, r.eng, r.mat, r.kor+r.eng+r.mat as tot, "
					+ "((r.kor+r.eng+r.mat) / 3) as avg, (SELECT COUNT(*) + 1 FROM examtable7 as r2 WHERE r2.kor + r2.eng + r2.mat > r.kor + r.eng + r.mat) AS ran "
					+ "from examtable7 as r ORDER BY r.student_id ASC limit ? OFFSET ?";
			//SQL 쿼리문을 실행하기 위한 준비된 문(Prepared Statement)을 생성
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//준비된 문의 매개변수에 값을 설정. 이를 통해 페이지와 페이지당 항목 수에 따라 조회 범위를 설정
			pstmt.setInt(1, countPerPage);
			pstmt.setInt(2, (page - 1) * countPerPage);
			//SQL 쿼리를 실행하고 결과를 가져옴
			ResultSet rset = pstmt.executeQuery();
			
			//결과 집합에서 데이터를 반복하면서 학생 성적 정보를 생성하고 결과 리스트에 추가
			while (rset.next()) { 
				StudentScore result = new StudentScore();
				result.setName(rset.getString(1));
				result.setStudentid(rset.getInt(2));
				result.setKor(rset.getInt(3));
				result.setEng(rset.getInt(4));
				result.setMat(rset.getInt(5));
				result.setTot(rset.getInt(6));
				result.setAvg(rset.getInt(7));
				result.setRan(rset.getInt(8));

				results.add(result);

			}
			//사용한 리소스를 정리하고 데이터베이스 연결을 종료.
			rset.close();
			pstmt.close();
			conn.close();
		// try 블록에서 발생할 수 있는 오류를 처리하기 위한 catch 블록이다.
		// 예외가 발생한 경우에는 예외 정보를 출력한다.
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}//results에 담긴 정보를 반환
		return results;
	}

// ========================================================================== CRUD ============================================================================
// ============================================================================================================================================================


// ============================================================================================================================================================
	@Override //studentid와 일치하는 행을 삭제하는 메서드
	public StudentScore deleteByStudentId(int studentId, StudentScore studentScoreDelete) {
		// TODO Auto-generated method stub
		try {
			// "com.mysql.cj.jdbc.Driver" 클래스를 동적으로 로드한다. 이는 MySQL JDBC 드라이버를 사용하기 위해 필요한 동작
			Class.forName("com.mysql.cj.jdbc.Driver");
			// localhost서버의 "kopo33" 데이터베이스에 "root" 사용자로 연결, 비밀번호는 choi0924.
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.200:33060/kopo33", "root", "choi0924");

			//객체에서 학번을 가져와서 studentId 변수에 할당	
			studentId = studentScoreDelete.getStudentid();
			//SQL 쿼리문을 정의. 이 쿼리문은 examtable7 테이블에서 주어진 학번과 일치하는 행을 삭제
			String sql = "delete from examtable7 where student_id = ?";
			//SQL 쿼리문을 실행하기 위한 준비된 문(Prepared Statement)을 생성
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//준비된 문의 매개변수에 학번 값을 설정
			pstmt.setInt(1, studentId);
			//SQL 쿼리를 실행하여 데이터베이스에서 행을 삭제
			pstmt.executeUpdate();
			//사용한 리소스를 정리하고 데이터베이스 연결을 종료
			pstmt.close();
			conn.close();
		// try 블록에서 발생할 수 있는 오류를 처리하기 위한 catch 블록이다.
		// 예외가 발생한 경우에는 예외 정보를 출력한다.
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}//삭제된 학생의 성적 정보를 포함한 studentScoreDelete 객체를 반환
		return studentScoreDelete;
	}

// ============================================================================================================================================================

	@Override //examtable에 데이터를 입려하는 메서드
	public StudentScore create(StudentScore studentScore) {

		String nameStr = ""; //namestr을 받을 변수 선언
		int studentid = 0; //studentid값을 받을 변수 선언
		int aStdID = 209901; //데이터를 입력할 때 빈 학번과 마지막 학번을 찾을 때 사용하는 변수

		try {

			// "com.mysql.cj.jdbc.Driver" 클래스를 동적으로 로드한다. 이는 MySQL JDBC 드라이버를 사용하기 위해 필요한 동작
			Class.forName("com.mysql.cj.jdbc.Driver");
			// localhost서버의 "kopo33" 데이터베이스에 "root" 사용자로 연결, 비밀번호는 choi0924.
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.200:33060/kopo33", "root", "choi0924");
			// Connection 객체인 conn을 사용하여 SQL 문을 실행하기 위한 Statement 객체를 생성한다.
			Statement stmt = conn.createStatement();
			//객체에서 이름을 가져와서 변수에 할당	
			nameStr = studentScore.getName();
			//객체에서 국영수 점수를 가져와서 변수에 할당	
			int korScore = studentScore.getKor();
			int engScore = studentScore.getEng();
			int matScore = studentScore.getMat();
			
			// 테이블에서 학생 학번을 조회하는 쿼리를 실행하고 결과를 가져오고, 반복해 내려감
			ResultSet rsetStdID = stmt.executeQuery("select student_id from examtable7;");
			while (rsetStdID.next()) {
				//만약 첫 학번이 일치하는 것이 없다면 if문을 빠져나감.
				if (aStdID != rsetStdID.getInt(1)) {
					break;
				}// 반복하면서 aStdID값을 계속 늘려나감
				aStdID++;					
			}
			//aStudID값을 학번에 집어 넣음(맨 마지막 값 혹은 중간에 빈 학번 자리)
			studentid = aStdID;
			//사용한 리소스를 정리하고 연결을 종료
			rsetStdID.close();
			
			
			//객체에 새로운 학번을 설정
			studentScore.setStudentid(studentid);

			// examtable7 테이블에 새로운 학생의 성적 정보를 추가
			String sql = "INSERT INTO examtable7 (name, student_id, kor, eng, mat) VALUES (?, ?, ?, ?, ?)";
			//SQL 쿼리문을 실행하기 위한 준비된 문(Prepared Statement)을 생성
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//준비된 문의 매개변수에 값을 설정. 이를 통해 새로운 학생의 성적 정보를 쿼리에 전달
			pstmt.setString(1, nameStr);
			pstmt.setInt(2, studentid);
			pstmt.setInt(3, korScore);
			pstmt.setInt(4, engScore);
			pstmt.setInt(5, matScore);

			// SQL 쿼리를 실행하여 데이터베이스에 새로운 학생의 성적 정보를 추가
			pstmt.executeUpdate();
			
			//사용한 리소스를 정리하고 데이터베이스 연결을 종료
			pstmt.close();
			conn.close();
		// try 블록에서 발생할 수 있는 오류를 처리하기 위한 catch 블록이다.
		// 예외가 발생한 경우에는 예외 정보를 출력한다.
		} catch (Exception e) {
			e.printStackTrace();
		}
		//생성된 학생의 성적 정보를 포함한 객체를 반환
		return studentScore;
	}

// ============================================================================================================================================================
	@Override //examtable의 데이터를 update하는 메서드
	public StudentScore update(int id, StudentScore studentScoreUpdate) {
		// TODO Auto-generated method stub

		try {
			// "com.mysql.cj.jdbc.Driver" 클래스를 동적으로 로드한다. 이는 MySQL JDBC 드라이버를 사용하기 위해 필요한 동작
			Class.forName("com.mysql.cj.jdbc.Driver");
			// localhost서버의 "kopo33" 데이터베이스에 "root" 사용자로 연결, 비밀번호는 choi0924.
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.200:33060/kopo33", "root", "choi0924");
		
			//SQL 쿼리문을 정의. 이 쿼리문은 examtable7 테이블에서 주어진 학번과 일치하는 행의 국영수점수를 업데이트
			String sql = "update examtable7 set name = ?, kor = ?, eng = ?, mat = ? where student_id = ?";
			//SQL 쿼리문을 실행하기 위한 준비된 문(Prepared Statement)을 생성
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//준비된 문의 매개변수에 값을 설정. 이를 통해 새로운 학생의 성적 정보를 쿼리에 전달
			pstmt.setString(1, studentScoreUpdate.getName());
			pstmt.setInt(2, studentScoreUpdate.getKor());
			pstmt.setInt(3, studentScoreUpdate.getEng());
			pstmt.setInt(4, studentScoreUpdate.getMat());
			pstmt.setInt(5, studentScoreUpdate.getStudentid());
			// SQL 쿼리를 실행하여 데이터베이스에 학생의 성적 정보를 추가
			pstmt.executeUpdate();

			//사용한 리소스를 정리하고 데이터베이스 연결을 종료
			pstmt.close();
			conn.close();
		// try 블록에서 발생할 수 있는 오류를 처리하기 위한 catch 블록이다.
		// 예외가 발생한 경우에는 예외 정보를 출력한다.
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return studentScoreUpdate; //생성된 학생의 성적 정보를 포함한 객체를 반환
	}

// ============================================================================================================================================================
	@Override //examtable의 전체 행을 세는 메서드
	public int count() {

		int count = 0;

		try {
			// "com.mysql.cj.jdbc.Driver" 클래스를 동적으로 로드한다. 이는 MySQL JDBC 드라이버를 사용하기 위해 필요한 동작
			Class.forName("com.mysql.cj.jdbc.Driver");
			// localhost서버의 "kopo33" 데이터베이스에 "root" 사용자로 연결, 비밀번호는 choi0924.
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.200:33060/kopo33", "root", "choi0924");
			
			//SQL 쿼리문을 정의. 이 쿼리문은 examtable7 테이블에서 모든 열을 카운트함
			String sql = "SELECT COUNT(*) FROM examtable7";
			//SQL 쿼리문을 실행하기 위한 준비된 문(Prepared Statement)을 생성
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// SQL 쿼리를 실행하여 데이터베이스에 학생의 성적 정보를 추가하고 resultset으로 받아옴
			ResultSet rset = pstmt.executeQuery();
			//resultset에서 다음 행으로 이동하고, 다음 행이 존재하는 경우 첫 번째 열의 값을 가져와서 Count 변수에 저장. 
			//이를 통해 후보자의 수를 확인
			if (rset.next()) {
				count = rset.getInt(1);
			}
			//사용한 리소스를 정리하고 데이터베이스 연결을 종료
			rset.close();
			pstmt.close();
			conn.close();
		// try 블록에서 발생할 수 있는 오류를 처리하기 위한 catch 블록이다.
		// 예외가 발생한 경우에는 예외 정보를 출력한다.
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return count; //행의 총 개수 반환
	}

// ============================================================================================================================================================
	@Override //examtable의 전체 데이터를 가져오는 메서드
	public List<StudentScore> getAll() {
		// TODO Auto-generated method stub
		List<StudentScore> getAllResults = new ArrayList<>();

		try {
			// "com.mysql.cj.jdbc.Driver" 클래스를 동적으로 로드한다. 이는 MySQL JDBC 드라이버를 사용하기 위해 필요한 동작
			Class.forName("com.mysql.cj.jdbc.Driver");
			// localhost서버의 "kopo33" 데이터베이스에 "root" 사용자로 연결, 비밀번호는 choi0924.
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.200:33060/kopo33", "root", "choi0924");

			//이 쿼리문은 examtable7 테이블에서 모든 학생의 이름, 학번, 국어 점수, 영어 점수, 수학 점수, 총점, 평균, 순위 정보를 조회
			String sql = "select r.name, r.student_id, r.kor, r.eng, r.mat, r.kor+r.eng+r.mat as tot, "
					+ "((r.kor+r.eng+r.mat) / 3) as avg, "
					+ "(SELECT COUNT(*) + 1 FROM examtable7 as r2 WHERE r2.kor + r2.eng + r2.mat > r.kor + r.eng + r.mat) AS ran "
					+ "from examtable7 as r";
			//SQL 쿼리문을 실행하기 위한 준비된 문(Prepared Statement)을 생성
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//SQL 쿼리를 실행하고 결과를 가져온다
			ResultSet rset = pstmt.executeQuery();
			//결과 집합에서 데이터를 반복하면서 학생 성적 정보를 생성하고 결과 리스트에 추가
			while (rset.next()) { 
				StudentScore result = new StudentScore();
				result.setName(rset.getString(1));
				result.setStudentid(rset.getInt(2));
				result.setKor(rset.getInt(3));
				result.setEng(rset.getInt(4));
				result.setMat(rset.getInt(5));
				result.setTot(rset.getInt(6));
				result.setAvg(rset.getInt(7));
				result.setRan(rset.getInt(8));

				getAllResults.add(result);

			}
			//사용한 리소스를 정리하고 데이터베이스 연결을 종료
			rset.close();
			pstmt.close();
			conn.close();
		// try 블록에서 발생할 수 있는 오류를 처리하기 위한 catch 블록이다.
		// 예외가 발생한 경우에는 예외 정보를 출력한다.
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return getAllResults; // 조회된 모든 학생의 성적 정보가 저장된 결과 리스트를 반환

	}
// ============================================================================================================================================================
	
	@Override //examtable에서 studentid와 일치하는 행을 조회하는 메서드
	public List<StudentScore> getOne(int studentId) {
		// TODO Auto-generated method stub

		List<StudentScore> getOneResults = new ArrayList<>();

		try {
			// "com.mysql.cj.jdbc.Driver" 클래스를 동적으로 로드한다. 이는 MySQL JDBC 드라이버를 사용하기 위해 필요한 동작
			Class.forName("com.mysql.cj.jdbc.Driver");
			// localhost서버의 "kopo33" 데이터베이스에 "root" 사용자로 연결, 비밀번호는 choi0924.
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.200:33060/kopo33", "root", "choi0924");
			// Connection 객체인 conn을 사용하여 SQL 문을 실행하기 위한 Statement 객체를 생성한다.
			 Statement stmt = conn.createStatement();

			 
			//SQL 쿼리문을 실행하여 주어진 학번에 해당하는 학생의 이름, 학번, 국어 점수, 영어 점수, 수학 점수, 총점, 평균, 순위 정보를 조회
			ResultSet rset = stmt.executeQuery(
					"select r.name, r.student_id, r.kor, r.mat, r.eng, r.kor+r.eng+r.mat as tot, ((r.kor+r.eng+r.mat) / 3.0) as avg, "
							+ "(SELECT COUNT(*) + 1 FROM examtable7 as r2 WHERE r2.kor + r2.eng + r2.mat > r.kor + r.eng + r.mat) AS ran "
							+ "from examtable7 as r where student_id = '" + studentId + "';");

			//결과 집합에서 데이터를 반복하면서 학생 성적 정보를 생성하고 결과 리스트에 추가
			while (rset.next()) { 
				StudentScore resultOneView = new StudentScore();
				resultOneView.setName(rset.getString(1));
				resultOneView.setStudentid(rset.getInt(2));
				resultOneView.setKor(rset.getInt(3));
				resultOneView.setEng(rset.getInt(4));
				resultOneView.setMat(rset.getInt(5));
				resultOneView.setTot(rset.getInt(6));
				resultOneView.setAvg(rset.getInt(7));
				resultOneView.setRan(rset.getInt(8));

				getOneResults.add(resultOneView);

			}
			//사용한 리소스를 정리하고 데이터베이스 연결을 종료
			rset.close();
			conn.close();
		// try 블록에서 발생할 수 있는 오류를 처리하기 위한 catch 블록이다.
		// 예외가 발생한 경우에는 예외 정보를 출력한다.
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} //조회된 학생의 성적 정보가 저장된 결과 리스트를 반환
		return getOneResults;

	}
// ============================================================================================================================================================
	
	@Override //학번과 페이지별 조회행을 입력받아 studentid의 페이지를 찾는 함수
	public int getPageByStudentId(int studentId, int itemsPerPage) {
		// TODO Auto-generated method stub
		int a = 0; //학생 수를 저장할 변수
	    try {	
			// "com.mysql.cj.jdbc.Driver" 클래스를 동적으로 로드한다. 이는 MySQL JDBC 드라이버를 사용하기 위해 필요한 동작
			Class.forName("com.mysql.cj.jdbc.Driver");
			// localhost서버의 "kopo33" 데이터베이스에 "root" 사용자로 연결, 비밀번호는 choi0924.
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.200:33060/kopo33", "root", "choi0924");
			// 주어진 학번보다 작거나 같은 학번을 가진 학생들의 수를 계산
	    	String sql = "SELECT COUNT(*) FROM examtable7 WHERE student_id <= ?";
	    	//SQL 쿼리문을 실행하기 위한 준비된 문(Prepared Statement)을 생성
	        PreparedStatement stmt = conn.prepareStatement(sql); 
	        //SQL 쿼리문의 매개변수에 주어진 학번을 설정
	        stmt.setInt(1, studentId);
	       //SQL 쿼리를 실행하고 결과를 가져온다.
	       ResultSet rs = stmt.executeQuery();
	       //쿼리를 실행하고 결과 집합에서 데이터를 반복하면서 학생 수를 변수 a에 저장.
	       while(rs.next()) {
	    	   a = rs.getInt(1);
	       }   
	    //학생 수와 페이지당 항목 수를 이용하여 페이지 수를 계산하고 반환. Math.ceil() 함수는 올림 연산을 수행하여 정수 값을 반환              
        return (int) Math.ceil((double) a / itemsPerPage);
		// try 블록에서 발생할 수 있는 오류를 처리하기 위한 catch 블록이다.
		// 예외가 발생한 경우에는 예외 정보를 출력한다.	              
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return -1;  // 에러가 났을 때 -1 반환
	}

	@Override
	public StudentScore selectOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentScore deleteByStudentId(int studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentScore deleteById(int id) {
		// TODO Auto-generated method stub
		return null;
	}



}
