package java심화5강;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class Receipt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//다이소
		/////////////////////////////////////////////////////////////////////////////
		int k33_iprice = 33000;
	      double k33_rate = 0.1;
	      int k33_netprice = (int) (k33_iprice / (1+k33_rate)) + 1;
	      
	      Calendar k33_calt = Calendar.getInstance();
	      SimpleDateFormat k33_sdf = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");
	      DecimalFormat k33_df = new DecimalFormat("###,###,###,###,###");
		//LocalDateTime k40_now = LocalDateTime.now();
	      //String k33_formatTime = k40_now.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
	      //String k33_refundDate = k40_refund.format(DateTimeFormatter.ofPattern("MM월dd일"));
	      
	      //System.out.println(k33_sdf.format(k33_calt.getTime()));
	      
	      Calendar k33_calt2 = Calendar.getInstance();
//	      k33_calt2.add(Calendar.DATE, 14);
	      //System.out.println(k33_calt2.get(Calendar.DATE));//날짜 체크용
	      
	      LocalDateTime k33_now = LocalDateTime.now();
	      String k_33formatTime = k33_now.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
	      LocalDateTime k_33refund = k33_now.plusDays(14);
	      String k_33refundDate = k_33refund.format(DateTimeFormatter.ofPattern("MM월dd일"));
	      
//	      SimpleDateFormat k33_sdf_M = new SimpleDateFormat("MM");
//	      SimpleDateFormat k33_sdf_D = new SimpleDateFormat("dd");
	      SimpleDateFormat k33_sdf2 = new SimpleDateFormat("YYYY.MM.dd HH:mm:ss");
	      String k33_itemname1 = "퓨어에어 비말차단용마스크(최고급형)";
	      String k33_itemcode1 = "1031615";
	      int k33_price1 = 3000;
	      int k33_amount1 =1;
	      
	      String k33_itemname2 = "슬라이드식명찰(가로형)(100호)";
	      String k33_itemcode2 = "11008152";
	      int k33_price2 = 1000;
	      int k33_amount2 = 1;
	      
	      String k33_itemname3 = "매직흡착 인테리어후크(알루미늄타입)";
	      String k33_itemcode3 = "1020800";
	      int k33_price3 = 1000;
	      int k33_amount3 = 1;
	      
	      byte[] k33_getbyitem1 = k33_itemname1.getBytes();
	      byte[] k33_getbyitem2 = k33_itemname2.getBytes();
	      byte[] k33_getbyitem3 = k33_itemname3.getBytes();
	      
	      String k33_subitem1 = new String(k33_getbyitem1, 0, 38);
	      String k33_subitem2 = new String(k33_getbyitem2, 0, 34);
	      String k33_subitem3 = new String(k33_getbyitem3, 0, 38);
	      
	      int k33_totalprice = k33_price1 + k33_price2 + k33_price3;
	      int k33_netprice2 = (int) (k33_totalprice / (1+k33_rate));
	      
	      //System.out.println(k33_totalprice);
	      //System.out.println(k33_netprice2);
	      
	      /////////////////////////////
	      System.out.printf("%22s\n", "\"국민가계, 다이소\"");
	      //System.out.println();
	      System.out.printf("%-14s\n", "(주)아성다이소_분당서현점");
	      System.out.printf("%-2s:%5s\n", "전화", "031-702-6016");
	      System.out.printf("%-2s:%5s\n", "본사", "서울 강남구 남부순환로 2748 (도곡동)");
	      System.out.printf("%-2s:%3s,%3s %5s\n", "대표", "박정부","신호섭","213-81-52063");
	      System.out.printf("%-2s:%5s\n", "매장", "경기도 성남시 분당구 분당로53번길 11 (서현동)");
	      System.out.printf("==========================================\n"); //48
	      System.out.printf("%23s\n", "소비자중심경영(CCM) 인증기업");
	      System.out.printf("%25s\n", "ISO 9001 품질경영시스템 인증기업"); //43
	      System.out.printf("==========================================\n"); 
	      System.out.printf("        교환/환불 14일(%s)이내,\n",k_33refundDate);
	      System.out.printf("%23s\n", "(전자)영수증, 결제카드 지참 후 구입매장에서 가능"); //67
	      System.out.printf("%23s\n", "포장/가격 택 훼손시 교환/환불 불가"); //48
	      System.out.printf("%23s\n", "체크카드 취소 시 최대 7일 소요");
	      System.out.printf("==========================================\n");  
	      System.out.printf("%-22s%19s\n", "[POS 1058231]", k33_sdf.format(k33_calt.getTime())); 
	      System.out.printf("==========================================\n"); 
	      System.out.printf("%-10s %5s%3s %5s\n" , k33_subitem1 , k33_df.format(k33_price1), k33_amount1 , k33_df.format(k33_price1 * k33_amount1) );
	      System.out.printf("[%s]\n", k33_itemcode1);
	      System.out.printf("%-16s %5s%3s %5s\n" , k33_subitem2 , k33_df.format(k33_price2), k33_amount2 , k33_df.format(k33_price2 * k33_amount2) );
	      System.out.printf("[%s]\n", k33_itemcode2);
	      System.out.printf("%-10s %5s%3s %5s\n" , k33_subitem3 , k33_df.format(k33_price1), k33_amount3 , k33_df.format(k33_price3 * k33_amount3) );
	      System.out.printf("[%s]\n", k33_itemcode3);
	      System.out.printf("%15s%22s\n", "과세합계" , k33_df.format(k33_netprice2));
	      System.out.printf("%15s%23s\n", "부과세" , k33_df.format(k33_totalprice - k33_netprice2));
	      System.out.printf("------------------------------------------\n"); 
	      System.out.printf("%-21s%16s\n", "판매합계" , k33_df.format(k33_totalprice));
	      System.out.printf("==========================================\n");  
	      System.out.printf("%-21s%16s\n", "신용카드" , k33_df.format(k33_totalprice));
	      System.out.printf("------------------------------------------\n");  
	      System.out.printf("%-14s%23s\n", "우리카드" , "538720**********"); //42
	      System.out.printf("%-5s%-18s%-5s%5s\n", "승인번호" , "77982843(0)" , "승인금액", k33_df.format(k33_totalprice) ); //39
	      System.out.printf("==========================================\n"); 
	      System.out.printf("%25s %5s\n", k33_sdf2.format(k33_calt.getTime()), "분당서현점");
	      System.out.printf("%-8s : %-10s\n", "상품 및 기타문의", "1522-4400");
	      System.out.printf("%-8s : %-10s\n", "멤버십 및 샵다이소 관련 문의", "1599-2211");
	      System.out.printf("------------------------------------------\n");  
	      System.out.printf("◈ 다이소 멤버십 앱 또는 홈페이지에 접속\n하셔서 회원가입 후 다양한 혜택을 누려보세요! ◈");

	}

}
