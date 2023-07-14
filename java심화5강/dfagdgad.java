package java심화5강;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class dfagdgad {

   
      
	public static void main(String[] args) {
	      // TODO Auto-generated method stub
	      
	      //비트를 이용?
	      Calendar calendar = Calendar.getInstance();
	      SimpleDateFormat k33_sdt = new SimpleDateFormat("YYYY-MM-dd HH:mm");
	      //Calendar.getInstance()를 이용하여 현재 시간을 구하고, SimpleDateFormat 클래스를 이용하여 출력 형식을 지정
	      DecimalFormat df = new DecimalFormat("###,###,###,###,###");
	      //DecimalFormat 클래스는 가격을 출력할 때 사용
	      
	      
	      LocalDateTime k33_now = LocalDateTime.now();
	      LocalDateTime refund = k33_now.plusHours(-2);
	        String parkDate = refund.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	        //LocalDateTime을 이용하여 현재 시간에서 2시간 전의 시간을 구하고, DateTimeFormatter를 이용하여 출력 형식을 지정
	      
	      String[] k33_itemName= {"하인즈유기농케찹","노브랜드냉동닭다리", "농심짜왕134g*4","노브랜드도시락김20", "월남쌈소스230g", 
	            "피코크통곡물뮤즐리", "CJ주부초밥왕더블","국내산등심카레용","소불고기(신세계푸드)", "프로바이오틱포도800g", 
	            "콘프레이크 500g", "양파(1.8kg/망)","노브랜드믹스넛800g", "팬티형기저귀 특대3", "파프리카(혼합)",
	            "강원애호박", "덴마크부드러운치즈300g","햇브로콜리(2입/봉)", "하인즈유기농케찹", "아침에주스 포도1.8L", 
	            "풀무원 제주도콩콩","남양 맛있는우유1L", "우리쌀 프레이크490", "갈바니리코타치즈", "양념등심돈가스",
	            "완숙토마토 4kg박스", "양념닭주물럭2.2kg", "갈바니리코타치즈",  
	            "koukakis그릭요거트", "(군용)방탄조끼"};//상품명
	      
	      int[] amount= { 1,1,1,1,1,
	                  1,1,1,1,1,
	                  1,1,1,1,2,
	                  2,1,1,1,1,
	                  1,2,1,1,1,
	                  1,1,1,//상품 수량
	                  1,10};
	       int[] k33_price= {   3280,4990,4980,4580,2680,
	                  5580,3480,4990,10000,3480,
	                  3680,2780,9980,8900,1980,
	                  2580,6600,4580,2680,3900,
	                  1880,4580,5980,2680,16980,
	                  17890,27980,6780,//상품별 단가
	                  8480,1800000};
	      
	      
	      
	      boolean[] taxfree= {true,true,false,false,false,//면세는true, 과세는false 
	                     false,false,true,false,false,
	                     false,false,true,true,true,
	                     true,false,true,true,false,
	                     true,true,false,false,false,
	                     true,false,false,false,true,
	                     false,false};
	      
	      
	      
	      System.out.printf("%36s\n","이마트 죽전점 (031)888-1234");
	      System.out.printf("%9s %21s\n","EMART","206-86-50913 강희석");
	      System.out.printf("%30s\n","용인 수지구 포은대로 552");
	      System.out.printf("%-5s\n","영수증 미지참시 교환/환불 불가");
	      System.out.printf("%-5s\n","정상상품에 한함, 30일 이내(신선 7일)");
	      System.out.printf("%-5s\n","※일부 브랜드매장 제외(매장 고지물참조)");
	      System.out.printf("%-5s\n","교환/환불 구매점에서 가능(결제카드 지참)");
	      System.out.printf("%-5s%s%18s\n","[구 매]",k33_sdt.format(calendar.getTime()),"POS:0011-9861");
	      System.out.printf("-----------------------------------------\n");
	      System.out.printf("%5s%15s%4s%5s\n","상품명","단  가","수량","금  액");


	      
	      /////////가격계산부///////////
	      int k33_cntFalse = 0;
	      int k33_cntTrue = 0;
	      int sumFalse = 0;
	      int sumTrue = 0;
	      int totalSumk33_price = 0;
	      
	      int itemk33_price = 0;
	      int[] itemk33_priceArray = new int[k33_itemName.length];
	      
	      for(int i = 0; i < k33_itemName.length;i++) {
	         itemk33_price = amount[i] * k33_price[i];
	         itemk33_priceArray[i] = itemk33_price;
	         totalSumk33_price += itemk33_price;
	      }
	      
	      //소비자가격은 totalSumk33_price
	      
	      //면세품목 가격 계산
	      for(int j = 0; j < k33_itemName.length; j++) {
	         
	         if (taxfree[j] == false) {
	            sumFalse += (amount[j] * k33_price[j]); 
	            k33_cntFalse++;
	         } else sumTrue += (amount[j] * k33_price[j]); k33_cntTrue++;
	      }
	      
	      
	      double k33_rate = 0.1;
	      //int k33_netprice = (int) (k33_netprice / (1+k33_rate)) + 1;
	      //과세금액 (소비자가격 - 면세가격) / 1.1 
	      double k33_netprice = (double) ((totalSumk33_price - sumFalse) / 1.1);
	      //부가세 
	      double tax = totalSumk33_price - sumFalse - k33_netprice;
	      //합계
	      int total = (int)(sumFalse + k33_netprice + tax);
	            
	     
	         
	   
//	         만약 k33_itemName 배열의 바이트 수가 16자리보다 작으면 String 생성자에서 IndexOutOfBoundsException 예외가 발생합니다. 
//	         Arrays.copyOf() 메소드를 사용하면 해당 문자열의 바이트 배열 길이가 16보다 작더라도 배열의 길이를 16으로 만들 수 있습니다.               
//	         Arrays.copyOf(k33_itemName[i].getBytes(), 16) 메소드를 사용하여 길이가 16인 새로운 바이트 배열을 만들고, 
//	         해당 배열의 끝 부분을 null 또는 0으로 채워서 16바이트로 만들 수 있습니다.          
//	         그런 다음 이 새로운 배열을 String 클래스의 생성자에 전달하여 새로운 문자열 객체를 만들 수 있습니다. 
//	         따라서, k33_itemName[i] 문자열의 바이트 배열 길이가 16보다 작은 경우에도 String 객체를 생성할 수 있습니다.         
	         
	         
	         for (int k33i = 0; k33i < k33_itemName.length; k33i++) { // i는 0부터 k33_itemNames배열의 길이 - 1까지 1씩 증가하며 루프 (5개마다 구분선 출력 및 면/과세 표시 출력)                                       
	             String cc = cutString(k33_itemName[k33i], 14); // bb을 잘라서 cc에 대입
	             byte[] bb = cc.getBytes();
	             
	             if (k33i % 5 == 0) { // i 나누기 5의 나머지가 0이면 (5개마다 구분선 출력되게 하려고)
	                System.out.printf("-----------------------------------------\n"); // 구분선 출력
	             }
	             
	             if (taxfree[k33i]) { // taxfree가 true이면 (면세)
	                System.out.printf("* %s%11s%3d%11s\n", cc, df.format(k33_price[k33i]), amount[k33i], // 상품명 앞 * 표시 및 단가 수량 금액 출력
	                      df.format(k33_price[k33i] * amount[k33i]));
	             } else { // taxfree가 false이면 (과세)
	                System.out.printf("  %s%11s%3d%11s\n", cc, df.format(k33_price[k33i]), amount[k33i], // 상품명 앞 공백 표시 및 단가 수량 금액 출력                                                                  // 출력
	                      df.format(k33_price[k33i] * amount[k33i])); 
	             }
	          }
	      
	      System.out.println();
	      System.out.printf("%22s%14d\n","총 품목 수량",amount.length);
	      System.out.printf("%23s%14s\n","(*)면 세  물 품",df.format(sumFalse));
	      System.out.printf("%23s%14s\n", "과 세  물 품",df.format(k33_netprice));
	      System.out.printf("%24s%14s\n", "부   가   세",df.format(tax));
	      System.out.printf("%25s%14s\n", "합        계",df.format(total));
	      System.out.printf("%s%24s\n", "결 제 대 상 금 액",df.format(total));
	      System.out.printf("-----------------------------------------\n");
	      System.out.printf("%-5s %27s\n", "0012 KEB 하나", "541707**0484/35860658");
	       System.out.printf("%-5s %14s %4s\n","카드결제(IC)","일시불/", df.format(total));//금액 합계
	      
	      System.out.printf("-----------------------------------------\n");
	         System.out.printf("%21s\n","[신세계포인트 적립]");
	         System.out.printf("%-5s\n","최*울 고객님의 포인트 현황입니다.");
	         System.out.printf("%-5s %15s %10s\n", "금회발생포인트","9350**9995", df.format(total/1000));//적립포인트 달아야함
	         System.out.printf("%-5s %13s (%8s)\n","누계(가용)포인트", df.format(5473+(total/1000)), df.format(5473));
	         System.out.printf("%-5s\n","*신세계포인트 유효기간은 2년입니다.");
	         System.out.printf("-----------------------------------------\n");
	         System.out.printf("%22s\n", "구매금액기준 무료주차시간 자동부여");
	         System.out.printf("%-5s %28s\n","차량번호 : ","30도****");
	         System.out.printf("%-5s %30s\n","입차시간 :",parkDate);//입차시간 
	         System.out.printf("-----------------------------------------\n");
	         System.out.printf("%-5s %24s\n", "캐셔:084599 양OO","1150");
	      }
	        
	      
	   
	   
	      public static String cutString(String str_kopo33, int len_kopo33) {

	          byte[] by_kopo33 = str_kopo33.getBytes();
	          if (by_kopo33.length <= 14) {
	             str_kopo33 = new String(by_kopo33, 0, by_kopo33.length);
	             for (int i_kopo33 = by_kopo33.length; i_kopo33 < 14; i_kopo33++) {
	                str_kopo33 = str_kopo33 + " ";
	             }
	             return str_kopo33;
	          } else {
	             int count_kopo33 = 0;
	             try {
	                for (int i_kopo33 = 0; i_kopo33 < len_kopo33; i_kopo33++) {
	                   if ((by_kopo33[i_kopo33] & 0x80) == 0x80)
	                      count_kopo33++; // 핵심 코드
	                }
	                if ((by_kopo33[len_kopo33 - 1] & 0x80) == 0x80 && (count_kopo33 % 2) == 1) {
	                   len_kopo33--; // 핵심코드
	                   String str1_kopo33 = new String(by_kopo33, 0, len_kopo33) + " ";
	                   return str1_kopo33;
	                }
	             } catch (java.lang.ArrayIndexOutOfBoundsException e_kopo33) {
	                System.out.println(e_kopo33);
	                return "";
	             }
	             String str2_kopo33 = new
	            		 String(by_kopo33, 0, len_kopo33);
	             return str2_kopo33;
	          }
	       }
	   
	   
	   
	   
	   
	}