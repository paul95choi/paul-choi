package Web_Board_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import Web_Board_domain.Web_Board;


public class Web_Board_Dao_Impl implements Web_Board_Dao{

	@Override
	public Web_Board allView(Web_Board webboard) {
		// TODO Auto-generated method stub

		try {
			
			Calendar cdr = Calendar.getInstance();
			SimpleDateFormat sdt = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now(); 
			String formattedDate = sdt.format(cdr.getTime());
			
			//com.mysql.cj.jdbc.Driver 클래스를 동적으로 로드. mysql jdbc 드라이버를 사용하기 위해 필요한 동작.
			Class.forName("com.mysql.cj.jdbc.Driver");
			// localhost서버의 "kopo33" 데이터베이스에 "root" 사용자로 연결, 비밀번호는 kopo33.
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.200:33060/kopo33", "root", "choi0924");
			// Connection 객체인 conn을 사용하여 SQL 문을 실행하기 위한 Statement 객체를 생성한다.
			Statement stmt = conn.createStatement();
			
			String sql = "select * from gongji order by id";
			ResultSet rset = stmt.executeQuery(sql);
			

			rset.close();
			stmt.close();
			conn.close();
			
		} catch (Exception e) {  //try블록에서 발생할 수 있는 예외를 처리하기 위한 catch 블록
			e.printStackTrace(); //에러 문자열 콘솔에 출력
			return null;
		}
		return webboard;
		
	}

	@Override
	public List<Web_Board> selectAll(int page, int countPerPage) {
		// TODO Auto-generated method stub
		List<Web_Board> results = new ArrayList<>();
		
		try {
			Calendar cdr = Calendar.getInstance();
			SimpleDateFormat sdt = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			String formattedDate = sdt.format(cdr.getTime());

			// com.mysql.cj.jdbc.Driver 클래스를 동적으로 로드. mysql jdbc 드라이버를 사용하기 위해 필요한 동작.
			Class.forName("com.mysql.cj.jdbc.Driver");
			// localhost서버의 "kopo33" 데이터베이스에 "root" 사용자로 연결, 비밀번호는 kopo33.
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.200:33060/kopo33", "root",
					"choi0924");
			// Connection 객체인 conn을 사용하여 SQL 문을 실행하기 위한 Statement 객체를 생성한다.
			Statement stmt = conn.createStatement();

			String sql = "select * from gongji order by id desc limit ? OFFSET ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, countPerPage);
			pstmt.setInt(2, (page - 1) * countPerPage);
			// SQL 쿼리를 실행하고 결과를 가져옴
			ResultSet rset = pstmt.executeQuery();

			// 결과 집합에서 데이터를 반복하면서 학생 성적 정보를 생성하고 결과 리스트에 추가
			while (rset.next()) {
				Web_Board result = new Web_Board();
				result.setId(rset.getInt(1));
				result.setTitle(rset.getString(2));
				result.setDate(rset.getString(3));
				result.setContent(rset.getString(4));

				results.add(result);
			}
			rset.close();
			stmt.close();
			conn.close();
		} catch (Exception e) { // try블록에서 발생할 수 있는 예외를 처리하기 위한 catch 블록
			e.printStackTrace(); // 에러 문자열 콘솔에 출력
			return null;
		}
		return results;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		int count = 0;

		try {
			// "com.mysql.cj.jdbc.Driver" 클래스를 동적으로 로드한다. 이는 MySQL JDBC 드라이버를 사용하기 위해 필요한 동작
			Class.forName("com.mysql.cj.jdbc.Driver");
			// localhost서버의 "kopo33" 데이터베이스에 "root" 사용자로 연결, 비밀번호는 kopo33.
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.200:33060/kopo33", "root", "choi0924");
			
			//SQL 쿼리문을 정의. 이 쿼리문은 examtable7 테이블에서 모든 열을 카운트함
			String sql = "SELECT COUNT(*) FROM gongji";
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

	@Override
	public Web_Board insert(Web_Board webBoard) {
		// TODO Auto-generated method stub
		
		int idIdxNum = 0; //studentid값을 받을 변수 선언
		int aID = 1;
		String title="";
		String content ="";
		
		
		try {
			//com.mysql.cj.jdbc.Driver 클래스를 동적으로 로드. mysql jdbc 드라이버를 사용하기 위해 필요한 동작.
			Class.forName("com.mysql.cj.jdbc.Driver");
			// localhost서버의 "kopo33" 데이터베이스에 "root" 사용자로 연결, 비밀번호는 kopo33.
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.200:33060/kopo33", "root", "choi0924");
			// Connection 객체인 conn을 사용하여 SQL 문을 실행하기 위한 Statement 객체를 생성한다.
			Statement stmt = conn.createStatement();
			

			
			
		    ResultSet rsetMaxID = stmt.executeQuery("select max(id) from gongji;");

		    if (idIdxNum == 0) {
		        while (rsetMaxID.next()) {
		        	idIdxNum = rsetMaxID.getInt(1) + 1;
		        }
		    }
		    rsetMaxID.close();

			
			
			webBoard.setId(idIdxNum);

			stmt.close();
			conn.close();
			
		} catch (Exception e) {  //try블록에서 발생할 수 있는 예외를 처리하기 위한 catch 블록
			e.printStackTrace(); //에러 문자열 콘솔에 출력
			//return null;
		}
		
		return webBoard;
	}

	@Override
	public Web_Board write(Web_Board webBoard) {
		// TODO Auto-generated method stub
		Web_Board_Dao a = new Web_Board_Dao_Impl();
		try {
			//com.mysql.cj.jdbc.Driver 클래스를 동적으로 로드. mysql jdbc 드라이버를 사용하기 위해 필요한 동작.
			Class.forName("com.mysql.cj.jdbc.Driver");
			// localhost서버의 "kopo33" 데이터베이스에 "root" 사용자로 연결, 비밀번호는 kopo33.
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.200:33060/kopo33", "root", "choi0924");
			// Connection 객체인 conn을 사용하여 SQL 문을 실행하기 위한 Statement 객체를 생성한다.
			Statement stmt = conn.createStatement();
			
			String sql = "insert into gongji (title, date, content) values (?,?,?)";
	
			
			PreparedStatement pstmt = conn.prepareStatement(sql); //PreparedStatement에 sql문 실행한 결과를 저장.
			pstmt.setString(1, webBoard.getTitle()); // idVar의 값을 정수로 변환하여 매개변수로 설정한다.
			pstmt.setString(2, a.date());
			pstmt.setString(3, webBoard.getContent());
			pstmt.executeUpdate(); //데이터베이스에서 투표결과를 삭제하기 위해 SQL 문을 실행한다.
			
			
			
			pstmt.close();
			stmt.close();
			conn.close();
			
		} catch (Exception e) {  //try블록에서 발생할 수 있는 예외를 처리하기 위한 catch 블록
			e.printStackTrace(); //에러 문자열 콘솔에 출력
			//return null;
		}
		
		return webBoard;
	}

	@Override
	public String date() {
		// TODO Auto-generated method stub
		Calendar cdr = Calendar.getInstance();// 현재 시간을 가져오기 위해 Calendar 객체 생성
		SimpleDateFormat sdt = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");// 날짜 포맷을 설정하기 위해 SimpleDateFormat 객체 생성
		LocalDateTime now = LocalDateTime.now(); // 현재 LocalDateTime 객체 생성
		String dateFormatter = sdt.format(cdr.getTime());// Calendar 객체의 시간을 형식에 맞게 변환하여 문자열로 저장
		Web_Board webBoard = new Web_Board();// Web_Board 객체 생성
		webBoard.setDate(dateFormatter);// Web_Board 객체의 날짜를 설정
		return webBoard.getDate();// 설정된 날짜를 반환
	}

	@Override
	public Web_Board update(int id, Web_Board webBoard) {
		// TODO Auto-generated method stub
		
		try {
			//com.mysql.cj.jdbc.Driver 클래스를 동적으로 로드. mysql jdbc 드라이버를 사용하기 위해 필요한 동작.
			Class.forName("com.mysql.cj.jdbc.Driver");
			// localhost서버의 "kopo33" 데이터베이스에 "root" 사용자로 연결, 비밀번호는 kopo33.
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.200:33060/kopo33", "root", "choi0924");
			// Connection 객체인 conn을 사용하여 SQL 문을 실행하기 위한 Statement 객체를 생성한다.
			Statement stmt = conn.createStatement();
		
			

			String sql = "update gongji set title = ?, date = ?, content = ? where id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setString(1, webBoard.getTitle());
			pstmt.setString(2, webBoard.getDate());
			pstmt.setString(3, webBoard.getContent());
			pstmt.setInt(4, id);
			// SQL 쿼리를 실행하여 데이터베이스에 학생의 성적 정보를 추가
			pstmt.executeUpdate();
	
		
			//pstmt.close();
			stmt.close();
			conn.close();
			
		} catch (Exception e) {  //try블록에서 발생할 수 있는 예외를 처리하기 위한 catch 블록
			e.printStackTrace(); //에러 문자열 콘솔에 출력
			//return null;
		}
		
		return webBoard;
		
		
	}

	
	
	@Override
	public List<Web_Board> OneView(int id, Web_Board webBoard) {
		// TODO Auto-generated method stub
		
		List<Web_Board> results = new ArrayList<>();
		
		try {
			//com.mysql.cj.jdbc.Driver 클래스를 동적으로 로드. mysql jdbc 드라이버를 사용하기 위해 필요한 동작.
			Class.forName("com.mysql.cj.jdbc.Driver");
			// localhost서버의 "kopo33" 데이터베이스에 "root" 사용자로 연결, 비밀번호는 kopo33.
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.200:33060/kopo33", "root", "choi0924");
			// Connection 객체인 conn을 사용하여 SQL 문을 실행하기 위한 Statement 객체를 생성한다.
			Statement stmt = conn.createStatement();
			
			
			String sql2 = "SELECT * FROM gongji WHERE id =" + id;
			ResultSet rset2 = stmt.executeQuery(sql2);
			
			while(rset2.next()) {
				Web_Board a = new Web_Board();
				a.setId(rset2.getInt(1)) ;
				a.setTitle(rset2.getString(2));
				a.setDate(rset2.getString(3));
				a.setContent(rset2.getString(4));
				
				results.add(a);
			}

		
			//pstmt.close();
			stmt.close();
			conn.close();
			
		} catch (Exception e) {  //try블록에서 발생할 수 있는 예외를 처리하기 위한 catch 블록
			e.printStackTrace(); //에러 문자열 콘솔에 출력
			//return null;
		}
		
		return results;
		
	}

	@Override
	public Web_Board delete(int id, Web_Board webboard) {
		// TODO Auto-generated method stub
		

		try {
			//com.mysql.cj.jdbc.Driver 클래스를 동적으로 로드. mysql jdbc 드라이버를 사용하기 위해 필요한 동작.
			Class.forName("com.mysql.cj.jdbc.Driver");
			// localhost서버의 "kopo33" 데이터베이스에 "root" 사용자로 연결, 비밀번호는 kopo33.
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.200:33060/kopo33", "root", "choi0924");
			// Connection 객체인 conn을 사용하여 SQL 문을 실행하기 위한 Statement 객체를 생성한다.
			Statement stmt = conn.createStatement();
			
			
			String sql2 = "delete from gongji WHERE id =" + id;
			stmt.executeUpdate(sql2);
		
			//pstmt.close();
			stmt.close();
			conn.close();
			
		} catch (Exception e) {  //try블록에서 발생할 수 있는 예외를 처리하기 위한 catch 블록
			e.printStackTrace(); //에러 문자열 콘솔에 출력
			//return null;
		}
		
		return null;
	}

	@Override
	public int maxCount() {
		// TODO Auto-generated method stub
		int count = 0;
		try {
			//com.mysql.cj.jdbc.Driver 클래스를 동적으로 로드. mysql jdbc 드라이버를 사용하기 위해 필요한 동작.
			Class.forName("com.mysql.cj.jdbc.Driver");
			// localhost서버의 "kopo33" 데이터베이스에 "root" 사용자로 연결, 비밀번호는 kopo33.
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.200:33060/kopo33", "root", "choi0924");
			// Connection 객체인 conn을 사용하여 SQL 문을 실행하기 위한 Statement 객체를 생성한다.
			Statement stmt = conn.createStatement();
			
			
		    ResultSet rsetMaxID = stmt.executeQuery("select max(id) from gongji;");

		    if (rsetMaxID.next()) {
		       count=rsetMaxID.getInt(1);   
		    }
		    rsetMaxID.close();
			stmt.close();
			conn.close();
			
		} catch (Exception e) {  //try블록에서 발생할 수 있는 예외를 처리하기 위한 catch 블록
			e.printStackTrace(); //에러 문자열 콘솔에 출력
			//return null;
		}
		
		return count;
	}

	
	
}
