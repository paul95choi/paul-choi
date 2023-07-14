package java심화5강;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Receipt_Emart {

   
      
	public static void main(String[] args) {
	      // TODO Auto-generated method stub
	      
	      //비트를 이용?
		//이마트 영수증
	      Calendar calendar = Calendar.getInstance();
	      SimpleDateFormat k33_sdt = new SimpleDateFormat("YYYY-MM-dd HH:mm");
	      //Calendar.getInstance()를 이용하여 현재 시간을 구하고, SimpleDateFormat 클래스를 이용하여 출력 형식을 지정
	      DecimalFormat k33_df = new DecimalFormat("###,###,###,###,###");
	      //DecimalFormat 클래스는 가격을 출력할 때 사용
	      
	      
	      LocalDateTime k33_now = LocalDateTime.now();
	      LocalDateTime k33_parking = k33_now.plusHours(-2);
	        String k33_parkDate = k33_parking.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	        //LocalDateTime을 이용하여 현재 시간에서 2시간 전의 시간을 구하고, DateTimeFormatter를 이용하여 출력 형식을 지정
	      
	      String[] k33_itemName= {"하인즈유기농케찹","노브랜드냉동닭다리", "농심짜왕134g*4","노브랜드도시락김20", "월남쌈소스230g", 
	            "피코크통곡물뮤즐리", "CJ주부초밥왕더블","국내산등심카레용","소불고기(신세계푸드)", "프로바이오틱포도800g", 
	            "콘프레이크 500g", "양파(1.8kg/망)","노브랜드믹스넛800g", "팬티형기저귀 특대3", "파프리카(혼합)",
	            "강원애호박", "덴마크부드러운치즈300g","햇브로콜리(2입/봉)", "하인즈유기농케찹", "아침에주스 포도1.8L", 
	            "풀무원 제주도콩콩","남양 맛있는우유1L", "우리쌀 프레이크490", "갈바니리코타치즈", "양념등심돈가스",
	            "완숙토마토 4kg박스", "양념닭주물럭2.2kg", "갈바니리코타치즈",  
	            "koukakis그릭요거트", "(군용)방탄조끼"};//상품명
	      
	      int[] k33_amount= { 1,1,1,1,1,
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
	                  17890,27980,6780,
	                  8480,1800000};//상품별 단가
	      
	      
	      
	      boolean[] k33_taxfree= {true,true,false,false,false,//면세는true, 과세는false 
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
	      //구매시간 출력
	      System.out.printf("-----------------------------------------\n");
	      System.out.printf("%5s%15s%4s%5s\n","상품명","단  가","수량","금  액");


	      
	      /////////가격계산부///////////
	      int k33_cntFalse = 0;
	      int k33_cntTrue = 0;
	      int k33_sumFalse = 0;
	      int k33_sumTrue = 0;
	      int k33_totalSumPrice = 0;
	      
	      int k33_itemPrice = 0;
	      int[] k33_itemPriceArray = new int[k33_itemName.length];
	      
	      for(int k33_i = 0; k33_i < k33_itemName.length;k33_i++) {
	         k33_itemPrice = k33_amount[k33_i] * k33_price[k33_i];
	         k33_itemPriceArray[k33_i] = k33_itemPrice;
	         k33_totalSumPrice += k33_itemPrice;
	      }
	      
	      //소비자가격은 k33_totalSumPrice
	      
	      //면세품목 가격 계산
	      for(int k33_j = 0; k33_j < k33_itemName.length; k33_j++) {
	         
	         if (k33_taxfree[k33_j] == false) {
	            k33_sumFalse += (k33_amount[k33_j] * k33_price[k33_j]); 
	            k33_cntFalse++;
	         } else k33_sumTrue += (k33_amount[k33_j] * k33_price[k33_j]); k33_cntTrue++;
	      }
	      
	      
	      double k33_rate = 0.1;
	      //int k33_netprice = (int) (k33_netprice / (1+k33_rate)) + 1;
	      //과세금액 (소비자가격 - 면세가격) / 1.1 
	      double k33_netprice = (double) ((k33_totalSumPrice - k33_sumFalse) / 1.1);
	      //부가세 
	      double k33_tax = k33_totalSumPrice - k33_sumFalse - k33_netprice;
	      //합계
	      int k33_total = (int)(k33_sumFalse + k33_netprice + k33_tax);
	            
	              
	         
	         
	         for (int k33i = 0; k33i < k33_itemName.length; k33i++) { 
	        // i는 0부터 k33_itemNames배열의 길이 - 1까지 1씩 증가하며 루프 (5개마다 구분선 출력 및 면/과세 표시 출력)                                       
	             String k33_cc = cutString(k33_itemName[k33i], 14); // k33_bb을 잘라서 k33_cc에 대입
	             byte[] k33_bb = k33_cc.getBytes();
	             
	             if (k33i % 5 == 0) { // i 나누기 5의 나머지가 0이면 (5개마다 구분선 출력되게 하려고)
	                System.out.printf("-----------------------------------------\n"); // 구분선 출력
	             }
	             
	             if (k33_taxfree[k33i]) { // k33_taxfree가 true이면 (면세)
	                System.out.printf("* %s%11s%3d%11s\n", k33_cc, k33_df.format(k33_price[k33i]), k33_amount[k33i], 
	                      k33_df.format(k33_price[k33i] * k33_amount[k33i]));
	             // 상품명 앞 * 표시 및 단가 수량 금액 출력
	             
	             } else { // k33_taxfree가 false이면 (과세)
	                System.out.printf("  %s%11s%3d%11s\n", k33_cc, k33_df.format(k33_price[k33i]), k33_amount[k33i],                                                                   // 출력
	                      k33_df.format(k33_price[k33i] * k33_amount[k33i])); 
	             }// 상품명 앞 공백 표시 및 단가 수량 금액 출력
	          }
	      
	      System.out.println();
	      System.out.printf("%22s%14d\n","총 품목 수량",k33_amount.length);//총 품목 수량을 출력
	      System.out.printf("%23s%14s\n","(*)면 세  물 품",k33_df.format(k33_sumFalse));//면세 물품의 금액을 출력
	      System.out.printf("%23s%14s\n", "과 세  물 품",k33_df.format(k33_netprice));//과세 물품의 금액을 출력
	      System.out.printf("%24s%14s\n", "부   가   세",k33_df.format(k33_tax));//과세 물품의 부가세 출력
	      System.out.printf("%25s%14s\n", "합        계",k33_df.format(k33_total));//부가세+과세물품+면세물품의 합계
	      System.out.printf("%s%24s\n", "결 제 대 상 금 액",k33_df.format(k33_total));//합계
	      System.out.printf("-----------------------------------------\n");
	      System.out.printf("%-5s %27s\n", "0012 KEB 하나", "541707**0484/35860658");
	       System.out.printf("%-5s %14s %4s\n","카드결제(IC)","일시불/", k33_df.format(k33_total));//금액 합계
	      
	      System.out.printf("-----------------------------------------\n");
	         System.out.printf("%21s\n","[신세계포인트 적립]");
	         System.out.printf("%-5s\n","최*울 고객님의 포인트 현황입니다.");
	         System.out.printf("%-5s %15s %10s\n", "금회발생포인트","9350**9995", k33_df.format(k33_total/1000));//적립포인트 
	         System.out.printf("%-5s %13s (%8s)\n","누계(가용)포인트", k33_df.format(5473+(k33_total/1000)), k33_df.format(5473));
	         //누적포인트(적립포인트)출력
	         System.out.printf("%-5s\n","*신세계포인트 유효기간은 2년입니다.");
	         System.out.printf("-----------------------------------------\n");
	         System.out.printf("%22s\n", "구매금액기준 무료주차시간 자동부여");
	         System.out.printf("%-5s %28s\n","차량번호 : ","30도****");
	         System.out.printf("%-5s %30s\n","입차시간 :",k33_parkDate);//입차시간 출력
	         System.out.printf("-----------------------------------------\n");
	         System.out.printf("%-5s %24s\n", "캐셔:084599 양OO","1150");
	      }
	        
	      
	   
	   
	      public static String cutString(String str_kopo33, int len_kopo33) {

	          byte[] by_kopo33 = str_kopo33.getBytes();//문자열을 byte 배열로 변환
	          if (by_kopo33.length <= 14) {//byte 배열의 길이가 14 이하인 경우, 문자열에 공백을 추가하여 길이를 맞춤
	             str_kopo33 = new String(by_kopo33, 0, by_kopo33.length);
	             for (int i_kopo33 = by_kopo33.length; i_kopo33 < 14; i_kopo33++) {
	                str_kopo33 = str_kopo33 + " ";
	             }
	             return str_kopo33;
	             //그렇지 않으면 문자열을 주어진 길이에 맞게 자르고 이때 한글이 포함된 경우를 고려하여 한글 글자수를 계산하여 끝 위치를 조정
	          } else {
	             int count_kopo33 = 0;
	             try {
	                for (int i_kopo33 = 0; i_kopo33 < len_kopo33; i_kopo33++) {
	                   if ((by_kopo33[i_kopo33] & 0x80) == 0x80)
	                      count_kopo33++; // 핵심 코드
	                }//한글 글자수를 저장하고 이 변수는 for문을 이용하여 문자열의 각 글자에 대해 한글인지 아닌지를 판별하여 계산
	                //조정할 때는 마지막 글자의 최상위 비트가 1인 경우에 한글이 잘리지 않도록 하기 위함
	                if ((by_kopo33[len_kopo33 - 1] & 0x80) == 0x80 && (count_kopo33 % 2) == 1) {
	                   len_kopo33--; // 핵심코드
	                   String str1_kopo33 = new String(by_kopo33, 0, len_kopo33) + " ";
	                   return str1_kopo33;
	                }
	             } catch (java.lang.ArrayIndexOutOfBoundsException e_kopo33) {
	                System.out.println(e_kopo33);
	                return "";
	                //catch에서는 예외가 발생한 경우를 처리하고, 배열 인덱스 범위를 벗어나는 경우에는 빈 문자열을 반환
	             }
	             String str2_kopo33 = new
	            		 String(by_kopo33, 0, len_kopo33);
	             return str2_kopo33;
	          }//최종적으로는 주어진 길이에 맞게 문자열을 자르고, 자른 문자열을 반환
	       }
	   
	   
	   
	   
	   
	}