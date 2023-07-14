package java심화4강;

public class MAIN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//숫자읽기고급
		 int k33_iNumVal2 = 200100; //10자리
	        String k33_sNumVal2 = String.valueOf(k33_iNumVal2); // int형 string으로 변환
	        String k33_sNumVoice2 = "";
	        System.out.printf("==> %s [%d자리]\n", k33_sNumVal2, k33_sNumVal2.length());

	        String[] k33_units3 = {"영", "일", "이", "삼", "사", "오", "육", "칠", "팔", "구"};
	        String[] k33_unitX3 = {"", "십", "백", "천", "만", "십", "백", "천", "억", "십"};

	        int k33_i = 0;
	        int k33_j = k33_sNumVal2.length() - 1; // 그전단위를 가져오기위해서

	        while (true) {
	            if (k33_i >= k33_sNumVal2.length()) break; // i가 string보다 길이가 커질 경우 종료.
	            if(k33_iNumVal2==0) {
	            	k33_sNumVoice2 = "영";//0나오면 영 나오는 조건
	            	break;//반복문 탈출
	            }
	            System.out.printf("%s[%s]", k33_sNumVal2.substring(k33_i, k33_i + 1), //한단어씩 (인덱스 0,1 > 1,2 ...) i2는 1씩 증가해야함
	                  k33_units3[Integer.parseInt(k33_sNumVal2.substring(k33_i, k33_i + 1))]); //units에서 해당하는 값찾기
	                                                                                  // 가져온 값의 인덱스를 그대로 따르기
	            if (k33_sNumVal2.substring(k33_i, k33_i + 1).equals("0")) { 
	                if (k33_unitX3[k33_j].equals("만") || k33_unitX3[k33_j].equals("억")) { 
	                   if (k33_i > 2 && k33_sNumVal2.substring(k33_i - 3, k33_i).equals("000")) { 
	                	   //k33_i가 2보다 크고, k33_sNumVal2 변수에서 k33_i - 3부터 k33_i까지의 문자열이
	                	   //000인 경우, k33_sNumVoice2 변수에 아무것도 추가하지 않는다.
	                	   k33_sNumVoice2 = k33_sNumVoice2 + ""; 
	                   } else {
	                      k33_sNumVoice2 = k33_sNumVoice2 + "" + k33_unitX3[k33_j]; 
	                   }
	                }
	             } else {
	            	 k33_sNumVoice2 = k33_sNumVoice2 + k33_units3[Integer.parseInt(k33_sNumVal2.substring(k33_i, k33_i+1))]
	            			 + k33_unitX3[k33_j];//k33_unitX3[k33_j] 변수에 저장된 문자열을 추가
	             }//k33_sNumVal2 변수에서 k33_i부터 k33_i+1까지의 문자열을 정수형으로 
                 //변환하여 k33_units3 배열에서 가져온 값을 추가
	            
	         

	            k33_i++; //인덱스는 점차 증가
	            k33_j--; //단위배열 점차 감소
	        }
	        System.out.printf("\n %s[%s]\n", k33_sNumVal2, k33_sNumVoice2);
	}

}
