package Java심화6강;

public class JavaMethodTest {

	static int k33_iStatic;
	public static void add(int k33_i) {
		k33_iStatic++;
		k33_i++;
		System.out.printf("add메소드에서->Static = [%d]\n", k33_iStatic);
		System.out.printf("add메소드에서->k33_i=[%d]\n", k33_i);
	}
	
	public static int add2(int k33_i) {
		k33_iStatic++;
		k33_i++;
		System.out.printf("add메소드에서->k33_iStatic = [%d]\n", k33_iStatic);
		System.out.printf("add메소드에서->k33_i = [%d]\n", k33_i);
		return k33_i;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int k33_iMain;
		k33_iMain = 1;
		k33_iStatic = 1;
		System.out.printf("***********************************\n");
		System.out.printf("메소드호출전 메인에서->k33_iStatic=[%d]\n", k33_iStatic);
		System.out.printf("메소드호출전 메인에서->k33_iMain=[%d]\n", k33_iMain);
		System.out.printf("***********************************\n");
		
		add(k33_iMain);
		
		System.out.printf("***********************************\n");
		System.out.printf("메소드호출전 메인에서->k33_iStatic=[%d]\n", k33_iStatic);
		System.out.printf("메소드호출전 메인에서->k33_iMain=[%d]\n", k33_iMain);
		System.out.printf("***********************************\n");
		
		k33_iMain = add2(k33_iMain); //이런식으로 값을 전달하고 받는 방법이 이해하기 쉬움
		//전역변수로 선언후 이함수...아니 메소드 저메소드에서 변경해 버리면
		//도대체 어떻게 로직이 되었는지 알아보기 어렵다.
		
		System.out.printf("***********************************\n");
		System.out.printf("메소드호출전 메인에서->k33_iStatic=[%d]\n", k33_iStatic);
		System.out.printf("메소드호출전 메인에서->k33_iMain=[%d]\n", k33_iMain);
		System.out.printf("***********************************\n");
	}

}
