package Java심화6강;

public class TestMain {

	private static int k33_inval;
	public static void up() {
		k33_inval++;
		System.out.printf("난 그냥 메소드[%d]\n", k33_inval);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		k33_inval = 0;
		Elevater k33_elev;
		k33_elev = new Elevater();
		up();
		for(int i = 0; i < 10; i++) {
			k33_elev.up();
			
			System.out.printf("MSG[%s]\n", k33_elev.help);
		}
		
		for (int i =0; i < 10; i++) {
			k33_elev.down();
			System.out.printf("MSG[%s]\n", k33_elev.help);
		}
	}

}
