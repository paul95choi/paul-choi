package java심화2강;

import java.util.Scanner; //scanner사용하기 위해 추가해야됨.

public class Java_Chap_2_scan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		Scanner k33_scan = new Scanner(System.in);//Scanner(System.in)은 콘솔에서 입력을 받아오기 위한 객체를 생성함
		System.out.print("두자리 정수를 하나 입력해주세요.>");//입력받는 메시지를 출력하는 코드
		
		String k33_input = k33_scan.nextLine(); //문자 전체 입력받으려면 Line이 들어가야됨.
		int k33_num = Integer.parseInt(k33_input); //입력받은 문자열을 숫자로 변환
		
		System.out.println("입력내용:" + k33_input);
		System.out.printf("k33_num=%d%n", k33_num); //%n 은 \n과 같지만 실무에서는 관습적으로 \n을 많이 사용함
		*/
		
		byte k33_b = 1;
		short k33_s = 2;
		char k33_c = 'A'; //캐릭터는 큰따옴표가 아닌 작은따옴표 사용
		
		int k33_finger= 10;
		long k33_big = 1000000000L;
		//long k33_hex = 0*FFFFFFFFFFFFFFFFFFFFL ;
		
		int k33_octNum = 010; //8진수 10, 10진수로는 8
		int k33_hexNum = 0*10; // 16진수 10, 10진수로는 16
		int k33_binNum = 0b10; // 2진수 10, 10진수로는 2
		
		System.out.printf("k33_b=%d%n", k33_b); //%d는 10진수 형식으로 출력하는 서식 지정자임. b의 값인 10이 출력
		System.out.printf("k33_s=%d%n", k33_s);//%d는 10진수 형식으로 출력하는 서식 지정자임. s의 값인 20이 출력
		System.out.printf("k33_c=%c, %d %n", k33_c, (int)k33_c);//c는 문자(char) 형식으로 출력하는 서식 지정자임. c의 값인 'A'가 출력
		System.out.printf("k33_finger=[%5d]%n", k33_finger);//%5d는 10진수 형식으로 출력하는 서식 지정자로 출력할 자리수를 5로 지정
		System.out.printf("k33_b=[%-5d]%n", k33_finger);//k33_finger의 값인 5가 출력되며 출력되는 문자열은 전체 길이가 5가 되도록 우측에 공백을 추가함.
		System.out.printf("k33_b=[%05d]%n", k33_finger);//%05d는 10진수 형식으로 출력하는 서식 지정자로 출력할 자리수를 5로 지정하고 빈 자리는 0으로 채움.		
		System.out.printf("k33_big=%d%n", k33_big);//%d는 10진수 형식으로 출력하는 서식 지정자임 //big의 값 880202가 출력
		//System.out.printf("hex=%#x%n", hex); //'#' 은 접두사(16진수0x, 8진수 0) *모름
		System.out.printf("k33_octNum=%o, %d%n", k33_octNum, k33_octNum);//%o는 8진수 형식으로 출력하는 지정자. octNum의 값인 010(8진수)이 출력됨
		System.out.printf("k33_hexNum=%x, %d%n", k33_hexNum, k33_hexNum);
		System.out.printf("k33_binNum=%s, %d%n", Integer.toBinaryString(k33_binNum), k33_binNum);
		//%s는 문자열(string) 형식으로 출력하는 서식 지정자임. 이진수로 변환한 문자열 10이 출력
		
		/*
		String url = "www.codechobo.com";
		float f1 = .10f; //0.10, 1.0e-1
		float f2 = 1e1f;
		float f3 = 3.14e3f;
		double d = 1.123456789;
		
		System.out.printf("f1=%f, %e, %g%n", f1, f1,f1);//f1의 값을 %f, %e, %g 서식으로 출력
		System.out.printf("f2=%f, %e, %g%n", f2, f2,f2);
		System.out.printf("f3=%f, %e, %g%n", f3, f3,f3);
		
		System.out.printf("d=%f%n", d);
		System.out.printf("d=%14.10f%n", d);// 전체 14자리 중 소수점 10자리
		
		System.out.printf("[12345678901234567890]%n");
		System.out.printf("[%s]%n", url);//똑같은 길이
		System.out.printf("[%20s]%n", url);//오른쪽으로 정렬
		System.out.printf("[%-20s]%n", url); //왼쪽 정렬
		System.out.printf("[%.8s]%n", url); // 왼쪽에서 8글자만 출력
		*/
		/*	  
		short k33_sMin = -32768;//16비트 부호 있는 정수short형 변수로, 최소값은 -32768
		short k33_sMax = 32767;//16비트 부호 있는 정수(short)형 변수로, 최대값은 32767
		char k33_cMin = 0;//8비트 부호 없는 정수char형 변수로, 최소값은 0
		char k33_cMax = 65535;//8비트 부호 없는 정수char형 변수로, 최대값은 65535
	      
	      System.out.println("sMin = " + k33_sMin);
	      System.out.println("sMin-1 = " + (short)(k33_sMin-1));//변수의값을 1 감소 후short 형 변환을 통해 범위 유지, 그 값을 출력
	      System.out.println("sMax = " + k33_sMax);
	      System.out.println("sMax+1  = " + (short)(k33_sMin+1));//변수의값을 1 증가 후short 형 변환을 통해 범위 유지, 그 값을 출력
	      System.out.println("cMin = " + (int)k33_cMin);
	      System.out.println("cMin-1 = " + (int)--k33_cMin);//변수의값을 1 감소 후char 형 변수이므로 먼저 감소시킨 후 출력. 그 값을 int 형으로 변환하여 출력
	      System.out.println("cMax = " + (int)k33_cMax);
	      System.out.println("cMax+1 = " + (int)++k33_cMax);//변수의값을 1 증가 후char 형 변수이므로 먼저 증가시킨 후 출력. 그 값을 int 형으로 변환하여 출력
	      */
		
	      /*
	      double k33_d2 = 85.4;
	      int k33_score = (int)k33_d2;
	      
	      System.out.println("score=" + k33_score); //정수형 버림
	      System.out.println("d=" + k33_d2);//변환되기 전의 값인 85.4가 그대로 출력
	      */
	      /*
	      int k33_i = 10;
	      byte k33_b2 = (byte)k33_i;
	      System.out.printf("[int -> byte' i = %d -> b=%d%n", k33_i, k33_b2);
	      //k33_i: 32비트 정수형int 변수로, 초기값은 10
	      //k33_b2: 8비트 부호 있는 byte형 변수
	      
	      k33_i = 300;
	      k33_b2 = (byte)k33_i;
	      System.out.printf("[int -> byte' i = %d -> b=%d%n", k33_i, k33_b2);
	      
	      k33_b2 = 10;
	      k33_i = (int)k33_b2;
	      System.out.printf("[byte -> int' i = %d -> b=%d%n", k33_b2, k33_i);
	      //변수의 값을 10진수로 출력하고 k33_i의 값을 byte로 형변환한 k33_b2 값을 10진수로 출력
	      k33_b2 = -2;
	      k33_i = (int)k33_b2;
	      System.out.printf("[byte -> int' i = %d -> b=%d%n", k33_b2, k33_i);
	      System.out.println("i = " + Integer.toBinaryString(k33_i));//변수의 값을 이진수 문자열로 출력
	      */
	     
		 /*
	      float k33_f2 = 9.1234567f;
	      double k33_d = 9.1234567;
	      double k33_d2 = (double)k33_f2;
	      
	      System.out.printf("f = %20.18f\n", k33_f2);
	      System.out.printf("d = %20.18f\n", k33_d); 
	      System.out.printf("d2 = %20.18f\n", k33_d2); //float형을 double형으로 변환해도 값의 손실이 거의 없다.
	      */
	      /*
	      int k33_i = 91234567;
	      float k33_f = (float)k33_i;
	      int k33_i2 = (int)k33_f;
	      
	      double k33_d = (double)k33_i;
	      int k33_i3 = (int)k33_d;
	      
	      float k33_f2 = 1.666f;
	      int k33_i4 = (int)k33_f2;
	      
	      System.out.printf("i=%d\n", k33_i);
	      System.out.printf("f=%f i2=%d\n", k33_f, k33_i2); // 1이 올라감
	      System.out.printf("d=%f i3=%d\n", k33_d, k33_i3); // 정교한 값
	      System.out.printf("(int)%f=%d\n", k33_f2, k33_i4); //소수점 뒤는 버림.
			*/
	}

}
