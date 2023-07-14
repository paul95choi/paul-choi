package java심화5강;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class kimchi2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//김치찌개2

		  int k33_iprice = 10000;
	      double k33_rate = 0.1;
	      int k33_netprice = (int) (k33_iprice / (1+k33_rate)); // 전세가격을 구하기 위해 금액 / 세율 + 1 을 구해준다.
	                                                // 무조건 버림을 적용하기 위해 int형으로 변환해주었다.
	      Calendar k33_calt = Calendar.getInstance();
	      SimpleDateFormat k33_sdf = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss"); // 내가 표현하려는 현재날짜의 포맷은 2000.01.01 01:01:01이다.
	      DecimalFormat k33_df = new DecimalFormat("###,###,###,###,###"); // 내가 표현하려는 금액의 포맷이다.
	      
	      
	      System.out.printf("%-5s", "신용승인\n");
	      System.out.printf("%-5s : %-4s   %3s : %5s\n", "단말기", "2N68665898" , "전표번호", "041218"); // 표시하고자하는 정보를 출력
	      System.out.printf("%-21s\n", "가맹점 : 한양김치찌개"); // 각 내용을 나누어 공간을 할당하는 것이 더 좋다.
	      System.out.printf("%-41s\n", "주  소 : 경기 성남시 분당구 황새울로351번길 10 . 1층");
	      System.out.printf("%-21s\n", "대표자 : 유창신");
	      System.out.printf("%-5s : %-5s   %5s : %5s\n", "사업자","752-53-00558" , "TEL","7055695"); 
	      System.out.printf("- - - - - - - - - - - - - - - - - - - - - \n");
	      System.out.printf("%-21s %14s 원\n", "금 액", k33_df.format(k33_netprice)); // 금액은 방금 계산한 전세가격이다.
	      System.out.printf("%-21s %13s 원\n", "부가세", k33_df.format((k33_iprice - k33_netprice))); // 총액에서 전세가격을 뺀다면 부가세가 나온다.
	      System.out.printf("%-21s %14s 원\n", "합 계", k33_df.format(k33_iprice)); // 금액과 부가세를 더하면 우리가 총액이 나온다.
	      System.out.printf("- - - - - - - - - - - - - - - - - - - - - \n");
	      System.out.printf("우리카드\n");
	      System.out.printf("%-2s : %-2s  %-1s\n", "카드번호" ,"5387-20**-****-4613(S)", "일시불"); // 각 내용을 할당하여 표현하였다.
	      System.out.printf("거래일시 : %s\n", k33_sdf.format(k33_calt.getTime())); // 현재날짜를 표현하려는 simpledataformat을 활용하였다.
	      System.out.printf("%-5s: %5s\n","승인번호", "70404427"); // 모두 왼쪽정렬을 활용하여 출력
	      System.out.printf("%-5s: %5s\n","거래번호", "357734873739"); // 표현하고자하는 공간의 갯수와 -를 붙이면 왼쪽정렬이 된다.
	      System.out.printf("%-3s: %-5s   %5s : %3s\n", "매입","비씨카드사", "가맹","720068568");
	      System.out.printf("%-3s: %-5s\n", "알림","EDC매출표");
	      System.out.printf("%-3s: %-5s\n", "문의","TEL)1544-4700");
	      System.out.printf("- - - - - - - - - - - - - - - - - - - - - \n"); // 정보를 나누기 위한 줄을 출력
	      System.out.printf("%25s", "* 감사합니다 *\n");
	      System.out.printf("%40s", "표준v2.08_20200212\n");
	}

}
