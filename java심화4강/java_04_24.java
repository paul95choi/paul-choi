package java심화4강;

import java.text.DecimalFormat;

public class java_04_24 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//띄어쓰기 연습
//		for(int k33_i = 0; k33_i<10; k33_i++) {// k33_i가 0부터 9까지 반복
//			for(int k33_j =0; k33_j<k33_i; k33_j++) System.out.printf(" ");
//			//k33_j가 0부터 k33_i보다 작을 때까지 반복하면서, 공백(" ")을 출력
//			System.out.printf("%d\n", k33_i);
//		}
		
		//degree 삼각함수 sin값 계산하고 그값 이용하기
		/*
		double k33fSin;
		for(int k33_i = 0; k33_i<360; k33_i++) {
			k33fSin = Math.sin(k33_i * 3.141592/180);
			//k33_i가 0부터 359까지 반복하면서 Math.sin 메소드를 이용하여 k33_i의 sin 값을 계산
			System.out.printf("%d sin ==> %f\n", k33_i,k33fSin);
		}//값을 k33fSin 변수에 할당하고 printf 메소드를 이용하여 k33_i와 k33fSin 값을 출력
		
		for(int k33_i = 0; k33_i< 360; k33_i++) {
			k33fSin = Math.sin(k33_i * 3.141592/180);
			//k33_i가 0부터 359까지 반복하면서, Math.sin 메소드를 이용하여 k33_i의 sin 값을 계산
			int k33iSpace = (int)((1.0 - k33fSin) * 50);
			// (1.0 - k33fSin) 값을 계산하고, 이를 50과 곱하여 k33iSpace 변수에 할당하고, 
			//k33iSpace는 k33fSin 값에 비례하여 변하며 이 값은 별을 출력할 위치를 계산하는 데 사용.
			for(int k33j = 0; k33j<k33iSpace; k33j++) System.out.printf(" ");
			System.out.printf("*[%f][%d]\n", k33fSin, k33iSpace);
		}
		*/
		//별찍기 피라미드
		/* 		
		int k33n, k33m;
		k33m=20;
		k33n = 1;
		//변수 k33n과 k33m을 선언하고 k33m에는 20을 할당하고 k33n에는 1을 할당
		
		while(true) {//while 문은 true로 설정하여 무한 반복합니다. 반복문 내부에서는 두 개의 for 문을 사용
			for(int k33i =0; k33i <k33m; k33i++) System.out.printf(" ");
			//위에서부터 공백,k33i가 0부터 k33m보다 작을 때까지 반복하면서 " "을 출력
			for(int k33i =0; k33i < k33n; k33i++) System.out.printf("*");
			//별을 출력하고 k33i가 0부터 k33n보다 작을 때까지 반복하면서 "*"을 출력
			System.out.printf("\n");//반복문이 끝나면 줄바꿈을 출력
			
			k33m =k33m-1; // blank는 1개씩 줄어듬
			k33n = k33n+2; //별은 13579로 2개씩 증가함
			if(k33m<0) break;
		}*/
		
		/////////////////////////////////////////////
		//영수증 칸 맞추기 실습
		
		String k33_item = "바나나";//바나나"라는 문자열을 k33_item이라는 이름으로 정의
		int k33_unit_price = 5000;// k33unit_price을 5000 초기화
		int k33_num = 500;// k33num을 500으로 초기화
		int k33_total = 0;//변수 total을 0으로 초기화
		
		DecimalFormat k33_df = new DecimalFormat( "###,###,###,###,###" );
		// DecimalFormat 클래스를 사용하여 숫자를 3자리마다 쉼표로 구분하여 출력
		//P.S import java.text.DecimalFormat;	이거 넣어야 돌아감
		//해더 찍기
		System.out.printf("===========================================\n");
		System.out.printf("%20.20s%8.8s%8.8s%8.8s\n", "품목","단가", "수량", "합계");// 간격 맞추기
		System.out.printf("===========================================\n");
		
		//값 찍기
		System.out.printf("%20.20s%10.10s%8.10s%16.10s\n",
				k33_item, k33_df.format(k33_unit_price), k33_df.format(k33_num), k33_df.format(k33_unit_price*k33_num));
		//상품,수량,단가,합계 간격맞추기
		System.out.printf("===========================================\n");
		
	}

}
