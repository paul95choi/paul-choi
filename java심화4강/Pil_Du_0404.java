package java심화4강;

import java.util.Scanner;

public class Pil_Du_0404 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		Scanner k33_scan = new Scanner(System.in);
		int k33_scan = Scanner.nextLine();
		String k33_jumin="123456-1234567";//문자열을 변수 k33_jumin에 대입
		
		switch(k33_jumin.charAt(7)) {//switch 문을 이용하여, k33_jumin 문자열의 7번째 자리에 해당하는 값을 확인
		case'1' :
			System.out.printf("20세기전 태어난 남자 사람\n");
		case'2':
			System.out.printf("20세기전 태어난 여자 사람\n");
			break;//'1' 또는 '2'에 해당하는 경우, 20세기전 태어난 여자 사람이 출력
		case'3':
			System.out.printf("20세기후 태어난 남자 사람\n");
		case'4':
			System.out.printf("20세기후 태어난 남자 사람\n");
			break;
			default:
				System.out.printf("사람\n");
				break;
		}
		*/
		//for문과 while문
		/*
		int k33_i =0;
		do {//do-while문은 while문의 변형으로 블럭{}이 최소한 한번은 수행될 것을 보장함.
			k33_i++;
			System.out.println(k33_i);
		}while(k33_i<=5);
//		for(int k33_i=1; k33_i<=5; k33_i++) {
//			System.out.println(k33_i);
//		}//반복시 카운트 변수를 유용히 쓸경우 for문을 그 외에는 while문을 사용.
		while(k33_i<=5) {
			System.out.println(k33_i);
			k33_i++;
		}//for문과 while문은 서로 변경가능하다
		*/
		
		
		//for문 구구단
		
		int k33_sum =0;
		for(int k33_i =0; k33_i<10; k33_i++) { //부등호표시에 유의
			k33_sum=k33_sum+k33_i;
		}//변수 k33_sum을 선언하고 0으로 초기화한 후, 0부터 9까지 반복하면서 
		//k33_sum 변수에 k33_i를 더하는 과정을 거쳐 0부터 9까지의 정수의 합을 구하고, 구해진 값을 출력
		System.out.printf("sum %d\n", k33_sum);//0부터 9까지 정수의 합
		
		for(int k33_i =2; k33_i<10; k33_i++) {
			//변수 k33_i를 2로 초기화한 후, 2부터 9까지 반복하면서 구구단의 단마다 1부터 9까지 곱한 값을 출력하는 코드
			System.out.printf("***************\n");
			System.out.printf("구구단 %d 단\n\n", k33_i);
			//구구단 n단"을 출력하기 위해 printf 함수를 사용하여 형식화된 문자열을 출력
			System.out.printf("***************\n");
			for(int k33_j=1; k33_j<10; k33_j++) {
				//for 문을 사용하여 1부터 9까지 반복하면서 곱셈 연산의 결과를 출력
				System.out.printf(" %d * %d = %d \n", k33_i, k33_j, k33_i*k33_j);	
			}//printf 함수를 사용하여 형식화된 문자열을 출력
			
		}
		
		
		
	}

}
