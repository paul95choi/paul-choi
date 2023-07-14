package java심화4강;

public class Understood_while_for {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//단순 비교
		/*
		int k33A, k33B;//두 개의 정수형 변수를 선언
		k33A = 0; //초기화 위치
		while(true) {//while(true)는 무한 루프를 의미
			k33B = 0;//k33B 변수에 0 값을 할당 및 초기화
			while(true) {//while(true)는 내부 루프로, 무한 루프
				System.out.printf("*");
				
				if(k33A==k33B) break;//break를 걸지 않으면 무한으로 루프&k33A와 k33B가 같을 때 내부 루프를 탈출
				k33B++;
			}
			System.out.printf("\n");//줄 바꿈
			k33A++;//k33A 변수를 1 증가
			if(k33A==20)break;//break문은 반복문을 중지하고 다음 코드로 이동
		}*/
		
		////////////////////////////////////////////////
		/*
		//문자형 숫자형 비교
		int k33i;
		double k33D;
		//int형 변수 k33i와 double형 변수 k33D를 선언
		k33i = 10/3;
		k33D = 10/3.0;
		//k33i = 10/3; k33D = 10/3.0;: k33i에는 10/3의 몫인 3이 할당되고, 
		//k33D에는 10/3.0의 값을 계산한 3.3333...이 할당
		
		if(k33i == k33D) System.out.printf("equal\n");
		else System.out.printf("not equal\n", (double)k33i, k33D);
		//k33D가 같은 값인지 확인하고 같으면 equal을 출력하고, 다르면 not equal을 출력
		if(k33D == 3.333333)System.out.printf("equal\n");
		else System.out.printf("not equal[3.333333][%f]\n", k33D);
		//k33D가 3.333333과 같은 값인지 확인하고 같으면 equal을 출력하고, 다르면 not equal과 k33D의 값을 함께 출력
		k33D = (int)k33D;//k33D를 (int)형으로 형변환
		if(k33i == k33D)System.out.printf("equal");
		else System.out.printf("not equal[%f][%f]\n", (double) k33i, k33D);
		//k33i와 k33D가 같은 값인지 확인하고 같으면 equal을 출력하고, 다르면 not equal과 k33i, k33D의 값을 함께 출력
		System.out.printf("int로 인쇄[%d][%f]\n", k33i, k33D);
		System.out.printf("double로 인쇄[%f][%f]\n", (double)k33i, k33D);
		//k33i와 k33D의 값을 각각 int형과 double형으로 출력한다.
		
		char a ='c';//char형 변수 a에 문자 'c'를 할당
		
		if(a=='b')System.out.printf("a는 b이다\n");
		if(a=='c')System.out.printf("a는 c이다\n");
		if(a=='d')System.out.printf("a는 d이다\n");
		//a가 'b', 'c', 'd' 중 어느 것과 같은지 비교하고, 해당하는 문자열을 출력
		String aa="abcd";
		
		if(aa.equals("abcd")) System.out.printf("aa는 abcd이다\n");
		else System.out.printf("aa는 abcd아니다\n");
		//aa가 "abcd"와 같은지 확인하고, 같으면 aa는 abcd이다를 출력하고, 다르면 aa는 abcd아니다를 출력
		boolean bb=true;
		if(!!bb)System.out.printf("bb가 아니고 아니면 참이다\n");
		else System.out.printf("bb가 아니고 아니면 거짓이다\n");
		*/
		////////////////////////////////////////////////////
		//범위를 주어서 찾기
		/*
		int k33Val;//int k33Val;: 정수형 변수 k33Val을 선언
		for(int k33_i = 0; k33_i <300; k33_i++) {//0부터 299까지의 숫자를 순차적으로 k33_i에 저장하면서 반복하는 루프를 실행
			k33Val=5 * k33_i; //k33_i값에 5를 곱한 값을 k33Val에 저장
			if(k33Val >= 0 && k33Val <10) System.out.printf("일%d\b",k33Val);
			//0이상 10미만이면 다음 블록을 실행
			else if(k33Val >=10 && k33Val < 100) System.out.printf("십 %d\n", k33Val);
			//k33Val이 10이상 100미만이면 다음 블록을 실행
			else if(k33Val >=100 && k33Val <1000)System.out.printf("백 %d\n", k33Val);
			//100이상 1000미만이면 다음 블록을 실행
			else System.out.printf("천 %d\n", k33Val);
			//k33Val이 1000이상이면 다음 블록을 실행
			//k33Val 값을 출력한다. %d는 정수값을 출력하는 포맷 문자열
		}*/
		
		////////////////////////////////////////////////////////
		
		//for loop를 사용하여, 각 월별로 해당 월의 일수만큼 숫자를 출력
		/*for(int k33_i=1; k33_i<13; k33_i++) {//1월부터 12월까지 순서대로 loop를 돌며, 각 월에 해당하는 숫자들을 출력
			System.out.printf(" %d월 =>", k33_i);
			for(int k33_j =1; k33_j <32; k33_j++) {//1부터 31까지 loop를 돌며, 각 숫자를 출력
				System.out.printf("%d", k33_j);
				
				if(k33_i ==1 && k33_j==31)break;//1월은 31일까지 하고 멈춤
				if(k33_i ==2 && k33_j==28)break;//2월은 28일까지 하고 멈춤
				if(k33_i ==3 && k33_j==31)break;//3월은 31일까지 하고 멈춤
				if(k33_i ==4 && k33_j==30)break;//4월은 30일까지 하고 멈춤
				if(k33_i ==5 && k33_j==31)break;//5월은 31일까지 하고 멈춤
				if(k33_i ==6 && k33_j==30)break;//6월은 30일까지 하고 멈춤
				if(k33_i ==7 && k33_j==31)break;//7월은 31일까지 하고 멈춤
				if(k33_i ==8 && k33_j==31)break;//8월은 31일까지 하고 멈춤
				if(k33_i ==9 && k33_j==30)break;//9월은 30일까지 하고 멈춤
				if(k33_i ==10 && k33_j==31)break;//10월은 31일까지 하고 멈춤
				if(k33_i ==11 && k33_j==30)break;//11월은 30일까지 하고 멈춤
				if(k33_i ==12 && k33_j==31)break;//12월은 31일까지 하고 멈춤
				System.out.printf(" , ");//각 월별로 출력된 숫자는 쉼표와 띄어쓰기로 구분
			}
			System.out.printf(".\n");//각 월이 끝나면 마침표를 출력
		}*/
		//////////////////////////////////////////////////////////////////////////
		//비정형 비교
		/*for(int k33_i=1; k33_i<13; k33_i++) {//1월부터 12월까지 반복하는 for문
			System.out.printf(" %d월 =>", k33_i);//현재 몇 월인지 출력
			for(int k33_j =1; k33_j<32; k33_j++) {//1일부터 31일까지 반복하는 for문
				System.out.printf("%d,", k33_j);//현재 몇 일인지 출력
				if(k33_i ==4 || k33_i==6 || k33_i ==9 || k33_i==11) {//4월, 6월, 9월, 11월인 경우를 검사
					if(k33_j ==30) break;//4월, 6월, 9월, 11월은 30일까지 있으므로, 30일까지 출력한 후에는 반복문을 종료
				}
				if(k33_i ==2) {// 2월인 경우를 검사
					if(k33_j==28) break;//2월은 윤년이 아니면 28일까지 있으므로, 28일까지 출력한 후에는 반복문을 종료
				}
				
			}
			System.out.printf("\n");//각 월의 일수를 출력한 후, 줄바꿈
		}*/
		
		///////////////////////////////////////////////////////////////////////
		//이런건 하지말것
//		for(int k33_i=1; k33_i<13; k33_i++) {
//			System.out.printf(" %d월 =>", k33_i);
//			L00P: for(int k33_j =1; k33_j<32; k33_j++) {
//				System.out.printf("%d,", k33_j);
//				
//				switch(k33_i) {
//				case 4: case 6: case 9: case 11:
//					if(k33_j ==30) break L00P;
//					//L00P라는 표시자가 없으면 엉뚱한 결과.
//					break;
//				case 2:
//					if(k33_j==28) break L00P;
//					break;
//				}
//			}
//			System.out.printf("\n");
//		}
//		/////////////////////////////////////////////////////////////
		//Array 이용 비교
		int[] k33LMD = {31,28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		//인덱스 0은 1월의 마지막 일자 31을 나타내고, 인덱스 1은 2월의 마지막 일자 28을 나타냄
		//배열은 0부터 시작한다는 것에 유의
		//k33LMD[0] ~k33LMD[11]이다
		for(int k33 = 1; k33<13; k33++) {//for문을 이용해 1부터 12월까지 각 월의 마지막 일자를 출력
			System.out.printf(" %d월 =>", k33);
			for(int k33_j = 1; k33_j < 32; k33_j++) {//for문을 이용해 1부터 31일까지 각 일자를 출력
				System.out.printf(" %d", k33_j);
				if(k33LMD[k33-1] == k33_j) break;//해당 월의 출력을 멈추고 다음 월로 넘어간다
				System.out.printf(",");//마지막일 콤마 안찍기
				
			}
			System.out.printf("\n");//한 달의 출력이 끝나면 줄바꿈
		}
		
	}

}
