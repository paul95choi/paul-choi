package Analysis0621;

import java.util.Arrays;

public class IQR {

	 public static void main(String[] args) {
	      int[] quantileArray = {1, 2, 5, 6, 7, 9, 12, 15, 18, 19, 27};

	      // 배열을 오름차순으로 정렬
	      Arrays.sort(quantileArray);

	      int n = quantileArray.length;
	      // Q2 (중앙값) 구하기
	      double q2;
	      if (n % 2 == 0) {
	         q2 = (quantileArray[n / 2 - 1] + quantileArray[n / 2]) / 2.0;
	      } else {
	         q2 = quantileArray[n / 2];
	      }

	      // Q1 구하기
	      double q1;

	      if (n % 2 == 0) {
	         q1 = (quantileArray[n / 4] + quantileArray[n / 4 + 1]) / 2.0;
	      } else {
	         q1 = quantileArray[n / 4];
	      }

	      // Q3 구하기
	      double q3;
	      if (n % 2 == 0) {
	         q3 = (quantileArray[3 * n / 4] + quantileArray[3 * n / 4 + 1]) / 2.0;
	      } else {
	         q3 = quantileArray[3 * n / 4];
	      }
	      double iqr = q3 - q1;
	      
	      double min = q1 - 1.5 * iqr;
	      
	      double max = q3 + 1.5 * iqr;
	      
	      System.out.println(n);
	      System.out.println("Q1: " + q1);
	      System.out.println("Q2: " + q2);
	      System.out.println("Q3: " + q3);
	      System.out.println(iqr);
	      System.out.println(min);
	      System.out.println(max);
	   }
	}