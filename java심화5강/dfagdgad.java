package java��ȭ5��;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class dfagdgad {

   
      
	public static void main(String[] args) {
	      // TODO Auto-generated method stub
	      
	      //��Ʈ�� �̿�?
	      Calendar calendar = Calendar.getInstance();
	      SimpleDateFormat k33_sdt = new SimpleDateFormat("YYYY-MM-dd HH:mm");
	      //Calendar.getInstance()�� �̿��Ͽ� ���� �ð��� ���ϰ�, SimpleDateFormat Ŭ������ �̿��Ͽ� ��� ������ ����
	      DecimalFormat df = new DecimalFormat("###,###,###,###,###");
	      //DecimalFormat Ŭ������ ������ ����� �� ���
	      
	      
	      LocalDateTime k33_now = LocalDateTime.now();
	      LocalDateTime refund = k33_now.plusHours(-2);
	        String parkDate = refund.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	        //LocalDateTime�� �̿��Ͽ� ���� �ð����� 2�ð� ���� �ð��� ���ϰ�, DateTimeFormatter�� �̿��Ͽ� ��� ������ ����
	      
	      String[] k33_itemName= {"���������������","��귣��õ��ߴٸ�", "���¥��134g*4","��귣�嵵�ö���20", "�����Ӽҽ�230g", 
	            "����ũ������", "CJ�ֺ��ʹ�մ���","��������ī����","�ҺҰ��(�ż���Ǫ��)", "���ι��̿�ƽ����800g", 
	            "��������ũ 500g", "����(1.8kg/��)","��귣��ͽ���800g", "��Ƽ�������� Ư��3", "������ī(ȥ��)",
	            "������ȣ��", "����ũ�ε巯��ġ��300g","�޺���ݸ�(2��/��)", "���������������", "��ħ���ֽ� ����1.8L", 
	            "Ǯ���� ���ֵ�����","���� ���ִ¿���1L", "�츮�� ������ũ490", "���ٴϸ���Ÿġ��", "����ɵ�����",
	            "�ϼ��丶�� 4kg�ڽ�", "�����ֹ���2.2kg", "���ٴϸ���Ÿġ��",  
	            "koukakis�׸����Ʈ", "(����)��ź����"};//��ǰ��
	      
	      int[] amount= { 1,1,1,1,1,
	                  1,1,1,1,1,
	                  1,1,1,1,2,
	                  2,1,1,1,1,
	                  1,2,1,1,1,
	                  1,1,1,//��ǰ ����
	                  1,10};
	       int[] k33_price= {   3280,4990,4980,4580,2680,
	                  5580,3480,4990,10000,3480,
	                  3680,2780,9980,8900,1980,
	                  2580,6600,4580,2680,3900,
	                  1880,4580,5980,2680,16980,
	                  17890,27980,6780,//��ǰ�� �ܰ�
	                  8480,1800000};
	      
	      
	      
	      boolean[] taxfree= {true,true,false,false,false,//�鼼��true, ������false 
	                     false,false,true,false,false,
	                     false,false,true,true,true,
	                     true,false,true,true,false,
	                     true,true,false,false,false,
	                     true,false,false,false,true,
	                     false,false};
	      
	      
	      
	      System.out.printf("%36s\n","�̸�Ʈ ������ (031)888-1234");
	      System.out.printf("%9s %21s\n","EMART","206-86-50913 ����");
	      System.out.printf("%30s\n","���� ������ ������� 552");
	      System.out.printf("%-5s\n","������ �������� ��ȯ/ȯ�� �Ұ�");
	      System.out.printf("%-5s\n","�����ǰ�� ����, 30�� �̳�(�ż� 7��)");
	      System.out.printf("%-5s\n","���Ϻ� �귣����� ����(���� ����������)");
	      System.out.printf("%-5s\n","��ȯ/ȯ�� ���������� ����(����ī�� ����)");
	      System.out.printf("%-5s%s%18s\n","[�� ��]",k33_sdt.format(calendar.getTime()),"POS:0011-9861");
	      System.out.printf("-----------------------------------------\n");
	      System.out.printf("%5s%15s%4s%5s\n","��ǰ��","��  ��","����","��  ��");


	      
	      /////////���ݰ���///////////
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
	      
	      //�Һ��ڰ����� totalSumk33_price
	      
	      //�鼼ǰ�� ���� ���
	      for(int j = 0; j < k33_itemName.length; j++) {
	         
	         if (taxfree[j] == false) {
	            sumFalse += (amount[j] * k33_price[j]); 
	            k33_cntFalse++;
	         } else sumTrue += (amount[j] * k33_price[j]); k33_cntTrue++;
	      }
	      
	      
	      double k33_rate = 0.1;
	      //int k33_netprice = (int) (k33_netprice / (1+k33_rate)) + 1;
	      //�����ݾ� (�Һ��ڰ��� - �鼼����) / 1.1 
	      double k33_netprice = (double) ((totalSumk33_price - sumFalse) / 1.1);
	      //�ΰ��� 
	      double tax = totalSumk33_price - sumFalse - k33_netprice;
	      //�հ�
	      int total = (int)(sumFalse + k33_netprice + tax);
	            
	     
	         
	   
//	         ���� k33_itemName �迭�� ����Ʈ ���� 16�ڸ����� ������ String �����ڿ��� IndexOutOfBoundsException ���ܰ� �߻��մϴ�. 
//	         Arrays.copyOf() �޼ҵ带 ����ϸ� �ش� ���ڿ��� ����Ʈ �迭 ���̰� 16���� �۴��� �迭�� ���̸� 16���� ���� �� �ֽ��ϴ�.               
//	         Arrays.copyOf(k33_itemName[i].getBytes(), 16) �޼ҵ带 ����Ͽ� ���̰� 16�� ���ο� ����Ʈ �迭�� �����, 
//	         �ش� �迭�� �� �κ��� null �Ǵ� 0���� ä���� 16����Ʈ�� ���� �� �ֽ��ϴ�.          
//	         �׷� ���� �� ���ο� �迭�� String Ŭ������ �����ڿ� �����Ͽ� ���ο� ���ڿ� ��ü�� ���� �� �ֽ��ϴ�. 
//	         ����, k33_itemName[i] ���ڿ��� ����Ʈ �迭 ���̰� 16���� ���� ��쿡�� String ��ü�� ������ �� �ֽ��ϴ�.         
	         
	         
	         for (int k33i = 0; k33i < k33_itemName.length; k33i++) { // i�� 0���� k33_itemNames�迭�� ���� - 1���� 1�� �����ϸ� ���� (5������ ���м� ��� �� ��/���� ǥ�� ���)                                       
	             String cc = cutString(k33_itemName[k33i], 14); // bb�� �߶� cc�� ����
	             byte[] bb = cc.getBytes();
	             
	             if (k33i % 5 == 0) { // i ������ 5�� �������� 0�̸� (5������ ���м� ��µǰ� �Ϸ���)
	                System.out.printf("-----------------------------------------\n"); // ���м� ���
	             }
	             
	             if (taxfree[k33i]) { // taxfree�� true�̸� (�鼼)
	                System.out.printf("* %s%11s%3d%11s\n", cc, df.format(k33_price[k33i]), amount[k33i], // ��ǰ�� �� * ǥ�� �� �ܰ� ���� �ݾ� ���
	                      df.format(k33_price[k33i] * amount[k33i]));
	             } else { // taxfree�� false�̸� (����)
	                System.out.printf("  %s%11s%3d%11s\n", cc, df.format(k33_price[k33i]), amount[k33i], // ��ǰ�� �� ���� ǥ�� �� �ܰ� ���� �ݾ� ���                                                                  // ���
	                      df.format(k33_price[k33i] * amount[k33i])); 
	             }
	          }
	      
	      System.out.println();
	      System.out.printf("%22s%14d\n","�� ǰ�� ����",amount.length);
	      System.out.printf("%23s%14s\n","(*)�� ��  �� ǰ",df.format(sumFalse));
	      System.out.printf("%23s%14s\n", "�� ��  �� ǰ",df.format(k33_netprice));
	      System.out.printf("%24s%14s\n", "��   ��   ��",df.format(tax));
	      System.out.printf("%25s%14s\n", "��        ��",df.format(total));
	      System.out.printf("%s%24s\n", "�� �� �� �� �� ��",df.format(total));
	      System.out.printf("-----------------------------------------\n");
	      System.out.printf("%-5s %27s\n", "0012 KEB �ϳ�", "541707**0484/35860658");
	       System.out.printf("%-5s %14s %4s\n","ī�����(IC)","�Ͻú�/", df.format(total));//�ݾ� �հ�
	      
	      System.out.printf("-----------------------------------------\n");
	         System.out.printf("%21s\n","[�ż�������Ʈ ����]");
	         System.out.printf("%-5s\n","��*�� ������ ����Ʈ ��Ȳ�Դϴ�.");
	         System.out.printf("%-5s %15s %10s\n", "��ȸ�߻�����Ʈ","9350**9995", df.format(total/1000));//��������Ʈ �޾ƾ���
	         System.out.printf("%-5s %13s (%8s)\n","����(����)����Ʈ", df.format(5473+(total/1000)), df.format(5473));
	         System.out.printf("%-5s\n","*�ż�������Ʈ ��ȿ�Ⱓ�� 2���Դϴ�.");
	         System.out.printf("-----------------------------------------\n");
	         System.out.printf("%22s\n", "���űݾױ��� ���������ð� �ڵ��ο�");
	         System.out.printf("%-5s %28s\n","������ȣ : ","30��****");
	         System.out.printf("%-5s %30s\n","�����ð� :",parkDate);//�����ð� 
	         System.out.printf("-----------------------------------------\n");
	         System.out.printf("%-5s %24s\n", "ĳ��:084599 ��OO","1150");
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
	                      count_kopo33++; // �ٽ� �ڵ�
	                }
	                if ((by_kopo33[len_kopo33 - 1] & 0x80) == 0x80 && (count_kopo33 % 2) == 1) {
	                   len_kopo33--; // �ٽ��ڵ�
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