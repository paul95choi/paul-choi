package java심화4강;

public class Pil_Du_while_loop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int i =2;
		/*
		//while문 이용 구구단
		
		while(i <= 9) {
			int j = 1;
			while(j<=9) {
				System.out.println(i+" * "+ j + " = "+i*j );
				j++;
			}
			i++;
		}*/
		
		//for문 구구단
		for(int i = 2; i<=9; i++) {
			for(int j =1; j<=9; j++) {
				System.out.println(i+" * "+ j + " = "+i*j);
			}
			System.out.println();
		}
	}

}
