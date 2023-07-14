package Stock_dao;
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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import Stock_domain.Stock;
import Stock_dao.Stock_Dao;
import Stock_dao.Stock_Dao_Impl;


public class Stock_Dao_Impl implements Stock_Dao{

	@Override
	public Stock allView(Stock stock) {
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
			
			String sql = "select * from stock order by id";
			ResultSet rset = stmt.executeQuery(sql);
			

		 	
			rset.close();
			stmt.close();
			conn.close();
			
		} catch (Exception e) {  //try블록에서 발생할 수 있는 예외를 처리하기 위한 catch 블록
			e.printStackTrace(); //에러 문자열 콘솔에 출력
			return null;
		}
		return stock;
		
	}
	

	@Override
	public List<Stock> selectAll(int page, int countPerPage) {
		// TODO Auto-generated method stub
		List<Stock> results = new ArrayList<>();
		
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
			
			String sql = "select * from stock order by id asc limit ? OFFSET ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, countPerPage);
			pstmt.setInt(2, (page - 1) * countPerPage);
			//SQL 쿼리를 실행하고 결과를 가져옴
			ResultSet rset = pstmt.executeQuery();
			
			//결과 집합에서 데이터를 반복하면서 상품 정보를 생성하고 결과 리스트에 추가
			while (rset.next()) { 
				Stock result = new Stock();
				result.setId(rset.getInt(1));
				result.setTitle(rset.getString(2));
				result.setAmount(rset.getInt(3));
				result.setCreateDate(rset.getString(4));
				result.setDate(rset.getString(5));
				result.setContent(rset.getString(6));

				results.add(result);

			}
		 	
			rset.close();
			stmt.close();
			conn.close();
			
		} catch (Exception e) {  //try블록에서 발생할 수 있는 예외를 처리하기 위한 catch 블록
			e.printStackTrace(); //에러 문자열 콘솔에 출력
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
			
			//SQL 쿼리문을 정의. 이 쿼리문은 stock 테이블에서 모든 열을 카운트함
			String sql = "SELECT COUNT(*) FROM stock";
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
	public Stock insert(Stock stock) {
		// TODO Auto-generated method stub
		int idIdxNum = 0; //studentid값을 받을 변수 선언
		int aID = 1;
		String title="";
		String amount="";
		String content ="";
		
		
		try {
			//com.mysql.cj.jdbc.Driver 클래스를 동적으로 로드. mysql jdbc 드라이버를 사용하기 위해 필요한 동작.
			Class.forName("com.mysql.cj.jdbc.Driver");
			// localhost서버의 "kopo33" 데이터베이스에 "root" 사용자로 연결, 비밀번호는 kopo33.
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.200:33060/kopo33", "root", "choi0924");
			// Connection 객체인 conn을 사용하여 SQL 문을 실행하기 위한 Statement 객체를 생성한다.
			Statement stmt = conn.createStatement();
			
			
			
		    ResultSet rsetMaxID = stmt.executeQuery("select max(id) from stock;");

		    if (idIdxNum == 0) {
		        while (rsetMaxID.next()) {
		        	idIdxNum = rsetMaxID.getInt(122100) + 1;
		        }
		    }
		    rsetMaxID.close();

			
			
		stock.setId(idIdxNum);

			
			stmt.close();
			conn.close();
			
		} catch (Exception e) {  //try블록에서 발생할 수 있는 예외를 처리하기 위한 catch 블록
			e.printStackTrace(); //에러 문자열 콘솔에 출력
			return null;
		}
		
		return stock;
	
	}

	@Override
	public Stock write(Stock stock) {
		// TODO Auto-generated method stub
		Stock_Dao a = new Stock_Dao_Impl();
		try {
			//com.mysql.cj.jdbc.Driver 클래스를 동적으로 로드. mysql jdbc 드라이버를 사용하기 위해 필요한 동작.
			Class.forName("com.mysql.cj.jdbc.Driver");
			// localhost서버의 "kopo33" 데이터베이스에 "root" 사용자로 연결, 비밀번호는 kopo33.
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.200:33060/kopo33", "root", "choi0924");
			// Connection 객체인 conn을 사용하여 SQL 문을 실행하기 위한 Statement 객체를 생성한다.
			Statement stmt = conn.createStatement();
			
			String sql = "insert into stock (title, amount, createdate, date, content) values (?,?,?,?,?)";
	
			
			PreparedStatement pstmt = conn.prepareStatement(sql); //PreparedStatement에 sql문 실행한 결과를 저장.
			pstmt.setString(1, stock.getTitle()); // idVar의 값을 정수로 변환하여 매개변수로 설정한다.
			pstmt.setInt(2, stock.getAmount());
			pstmt.setString(3, a.getCreateDate());
			pstmt.setString(4, a.date());
			pstmt.setString(5, stock.getContent());
			pstmt.executeUpdate(); //데이터베이스에서 결과를 삭제하기 위해 SQL 문을 실행한다.
			
			
			pstmt.close();
			stmt.close();
			conn.close();
			
		} catch (Exception e) {  //try블록에서 발생할 수 있는 예외를 처리하기 위한 catch 블록
			e.printStackTrace(); //에러 문자열 콘솔에 출력
			//return null;
		}
		
		return stock;
	}

	
	@Override
	public String date() {
		// TODO Auto-generated method stub
		Calendar cdr = Calendar.getInstance();
		SimpleDateFormat sdt = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now(); 
		String dateFormatter = sdt.format(cdr.getTime());
		Stock stock = new Stock();
		stock.setDate(dateFormatter);
		return stock.getDate();
	}
	
	@Override
	public Stock update(int id, Stock stock) {
		// TODO Auto-generated method stub
		try {
			//com.mysql.cj.jdbc.Driver 클래스를 동적으로 로드. mysql jdbc 드라이버를 사용하기 위해 필요한 동작.
			Class.forName("com.mysql.cj.jdbc.Driver");
			// localhost서버의 "kopo33" 데이터베이스에 "root" 사용자로 연결, 비밀번호는 choi0924.
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.200:33060/kopo33", "root", "choi0924");
			// Connection 객체인 conn을 사용하여 SQL 문을 실행하기 위한 Statement 객체를 생성한다.
			Statement stmt = conn.createStatement();
		
			String sql = "update stock set amount = ?, date = ? where id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			// 현재 날짜 구하기 (시스템 시계, 시스템 타임존)
	        LocalDate now = LocalDate.now();
	        String Now = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	         
			pstmt.setInt(1, stock.getAmount());
			pstmt.setString(2, Now);
			pstmt.setInt(3, id);
			// SQL 쿼리를 실행하여 데이터베이스에 학생의 성적 정보를 추가
			pstmt.executeUpdate();
	
			//pstmt.close();
			stmt.close();
			conn.close();
			
		} catch (Exception e) {  //try블록에서 발생할 수 있는 예외를 처리하기 위한 catch 블록
			e.printStackTrace(); //에러 문자열 콘솔에 출력
			//return null;
		}
		
		return stock;
	}

	@Override
	public Stock delete(int id, Stock stock) {
		// TODO Auto-generated method stub
		try {
			//com.mysql.cj.jdbc.Driver 클래스를 동적으로 로드. mysql jdbc 드라이버를 사용하기 위해 필요한 동작.
			Class.forName("com.mysql.cj.jdbc.Driver");
			// localhost서버의 "kopo33" 데이터베이스에 "root" 사용자로 연결, 비밀번호는 kopo33.
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.200:33060/kopo33", "root", "choi0924");
			// Connection 객체인 conn을 사용하여 SQL 문을 실행하기 위한 Statement 객체를 생성한다.
			Statement stmt = conn.createStatement();
			
			
			String sql2 = "delete from stock WHERE id =" + id;
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
	public List<Stock> OneView(int id, Stock stock) {
		// TODO Auto-generated method stub
		List<Stock> results = new ArrayList<>();
		
		try {
			//com.mysql.cj.jdbc.Driver 클래스를 동적으로 로드. mysql jdbc 드라이버를 사용하기 위해 필요한 동작.
			Class.forName("com.mysql.cj.jdbc.Driver");
			// localhost서버의 "kopo33" 데이터베이스에 "root" 사용자로 연결, 비밀번호는 kopo33.
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.200:33060/kopo33", "root", "choi0924");
			// Connection 객체인 conn을 사용하여 SQL 문을 실행하기 위한 Statement 객체를 생성한다.
			Statement stmt = conn.createStatement();
			
			
			String sql2 = "SELECT * FROM stock WHERE id =" + id;
			ResultSet rset2 = stmt.executeQuery(sql2);
			
			while(rset2.next()) {
				Stock a = new Stock();
				a.setId(rset2.getInt(1)) ;
				a.setTitle(rset2.getString(2));
				a.setAmount(rset2.getInt(3));
				a.setCreateDate(rset2.getString(4));
				a.setDate(rset2.getString(5));
				a.setContent(rset2.getString(6));
				a.setImg(rset2.getString(7));
				
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
			
			
		    ResultSet rsetMaxID = stmt.executeQuery("select max(id) from stock;");

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

	@Override
	public String getCreateDate() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Stock insertrecord(Stock stock) {
		//Create record 데이터 삽입
	      try {
	         Class.forName("com.mysql.cj.jdbc.Driver"); //mysql jdbc 드라이버를 로드합니다.
	         String dbuname = "root"; //db와 연결하는 유저의 이름
	         String dbpw = "choi0924"; //db와 연결하는 패스워드
	         //mysqldb와 연결합니다.
	           Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.200:33060/kopo33",dbuname,dbpw);
	           String sql = "insert into stock(id, title, amount, createdate, date, content, img) " +
	                 "values (?,?,?,?,?,?,?);" ;  
	                 
	         PreparedStatement pstmt = conn.prepareStatement(sql);
	         
	         // 현재 날짜 구하기 (시스템 시계, 시스템 타임존)
	         LocalDate now = LocalDate.now();
	         String Now = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	           
	         pstmt.setInt(1, stock.getId());
	         pstmt.setString(2, stock.getTitle());
	         pstmt.setInt(3, stock.getAmount());
	         pstmt.setString(4, Now);
	         pstmt.setString(5, Now);
	         pstmt.setString(6, stock.getContent());
	         pstmt.setString(7, stock.getImg());
	         
	         pstmt.executeUpdate();
	         pstmt.close();
	         conn.close();
	           
	      } catch (Exception e) {
	         System.out.println(e.toString());
	         return null;
	      }
	      
	      return stock;

	}



	

	

	

}
