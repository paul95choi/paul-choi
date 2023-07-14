package Analysis0621;

import java.util.Arrays;

public class quartile {

	public static void main(String[] args) {
		 double[] arr = {1, 2, 5, 6, 7, 9, 12, 15, 18, 19, 27};

	      Arrays.sort(arr);
	        double q1 = getQuartile(arr, 0.25);
	        double q2 = getQuartile(arr, 0.5);
	        double q3 = getQuartile(arr, 0.75);
	        double iqr = q3 - q1;
	        double minimum = q1 - 1.5 * iqr;
	        double maximum = q3 + 1.5 * iqr;
	        
	        System.out.println("Q1: " + q1);
	        System.out.println("Q2: " + q2);
	        System.out.println("Q3: " + q3);
	        System.out.println("IQR: " + iqr);
	        System.out.println("Minimum: " + minimum);
	        System.out.println("Maximum: " + maximum);
	    }
	    
	    private static double getQuartile(double[] arr, double quartile) {
//	       원하는 사분위수 위치를 계산. 예를 들어, 데이터 세트에 10개의 요소가 있고 1사분위수(Q1)를 원한다면, 
//	       위치는 0.25 * (10 - 1) = 2.25가 된다. 이 위치는 2번째와 3번째 요소 사이를 나타낸다.
	        double pos = quartile * (arr.length - 1);
//	      사분위수 위치가 배열의 범위를 벗어나는지 확인. 만약 위치가 0보다 작다면, 배열의 첫 번째 요소를 반환. 
//	      사분위수의 범위는 0부터 1 사이이기 때문에 이 조건이 발생하며 안됨.
	        if (pos < 0) {
	            return arr[0];
	        }
//	      만약 위치가 배열 길이 - 1보다 크거나 같다면, 배열의 마지막 요소를 반환.
	        if (pos >= arr.length - 1) {
	            return arr[arr.length - 1];
//	      사분위수 위치가 배열의 범위 내에 있을 때, 이 위치를 기준으로 상위와 하위 값을 찾는다. 
//	      예를 들어, 위치가 2.25라면, 상위 값은 3번째 요소이고 하위 값은 2번째 요소이다.    
	        } else {
	            double lower = arr[(int) pos];
	            double upper = arr[(int) pos + 1];
//	       마지막으로, 하위 값과 상위 값 사이의 가중 평균을 계산하여 반환한다. 이는 사분위수 위치가 정확히 배열 요소의 위치와 일치하지 않을 때 
//	       (즉, 소수점이 있는 경우) 사용된다. 예를 들어, 위치가 2.25라면, 이는 2번째와 3번째 요소 사이의 25% 지점을 의미한다. 
//	       따라서 결과 값은 2번째 요소 값과 3번째 요소 값 사이의 25% 지점에 해당하는 값이 된다.
	            return lower + (pos - Math.floor(pos)) * (upper - lower);
	        }
	    }
	}