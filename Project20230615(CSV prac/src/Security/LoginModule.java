package Security;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class LoginModule {
    // MySQL 데이터베이스 연결 정보
    
    // AES256 암호화 키
    //private static final String ENCRYPTION_KEY = "kopo333333333333333333";

    public static void main(String[] args) {
        // MySQL 드라이버 로드
    	 try {
             // com.mysql.cj.jdbc.Driver 클래스를 동적으로 로드. mysql jdbc 드라이버를 사용하기 위해 필요한 동작.
             Class.forName("com.mysql.cj.jdbc.Driver");
             // localhost서버의 "kopo33" 데이터베이스에 "root" 사용자로 연결, 비밀번호는 kopo33.
             Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.200:33060/kopo33", "root", "choi0924");
             // Connection 객체인 conn을 사용하여 SQL 문을 실행하기 위한 Statement 객체를 생성한다.
             Statement stmt = conn.createStatement();
             
             Scanner sc1 = new Scanner(System.in);
             //Scanner sc2 = new Scanner(System.in);
             
             String key = "abcdefghijklmnop"; // now it's 16 bytes //반복문 돌려서 키 알아내기
             LoginModule login = new LoginModule();
             
             System.out.println("아이디:");
             String ID = sc1.nextLine();
             
             System.out.println("비밀번호:");
             String passwd = sc1.nextLine();
    
//비밀번호 아이디 만들기
//           String encryptedPasswd = login.encrypt(key, passwd);
//           String decryptedPasswd = login.decrypt(key, passwd);
//           String sql = "insert into login (name, password) values (?,?);";
//           PreparedStatement pstmt = conn.prepareStatement(sql);
//           pstmt.setString(1, ID);
//           pstmt.setString(2, encryptedPasswd);         
//           pstmt.executeUpdate();
       

                


              // 로그인 정보 검색
                boolean isAuthenticated = authenticate(conn, ID, passwd, key);
                if (isAuthenticated) {
                    System.out.println("로그인 성공");
                    System.out.println(isAuthenticated);
                } else {
                    System.out.println("로그인 실패");
                }
             
             stmt.close();
             conn.close();

          } catch (Exception e) { // try블록에서 발생할 수 있는 예외를 처리하기 위한 catch 블록
             e.printStackTrace(); // 에러 문자열 콘솔에 출력
          }

       }



       public String encrypt(String key, String text) {
           String cipherText = "";
           try {
               Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
               byte[] iv = Arrays.copyOfRange(key.getBytes("UTF-8"), 0, 16); // Assuming 16 byte block size
               IvParameterSpec ivspec = new IvParameterSpec(iv);
               SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
               cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivspec);
               cipherText = new String(Base64.encodeBase64(cipher.doFinal(text.getBytes("UTF-8"))), "UTF-8");
           } catch (Exception e) {
               cipherText = "";
               e.printStackTrace();
           }
           return cipherText;
       }

       public static String decrypt(String key, String encryptedText) {
           String plainText = "";
           try {
               byte[] decodedText = Base64.decodeBase64(encryptedText.getBytes("UTF-8"));
               Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
               byte[] iv = Arrays.copyOfRange(key.getBytes("UTF-8"), 0, 16); // Assuming 16 byte block size
               IvParameterSpec ivspec = new IvParameterSpec(iv);
               SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
               cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivspec);
               plainText = new String(cipher.doFinal(decodedText), "UTF-8");
           } catch (Exception e) {
               plainText = "";
               e.printStackTrace();
           }
           return plainText;
       }
       
       
        private static boolean authenticate(Connection connection, String name, String password, String key) throws SQLException {
            String sql = "SELECT password FROM login WHERE name = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, name);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        String storedPassword = resultSet.getString("password");
                        String decryptedPassword = decrypt(key,storedPassword);
                        return password.equals(decryptedPassword);
                    }
                }
            }
            return false;
        }
       
    }