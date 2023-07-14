package Java심화6강;

public class Elevater {
	int k33_limit_up_floor = 10;
	int k33_limit_down_floor = 0;
	int k33_floor =1;
	String help;
	
	void up()
	{
		if (k33_floor == k33_limit_up_floor) {
			help= "마지막층입니다.";
		}else {
			k33_floor++;
			help= String.format("%d층입니다", k33_floor);
		}
	}
	void down()
	{
		if(k33_floor == k33_limit_down_floor) {
			help = "처음층입니다.";
		}else {
			k33_floor--;
			help = String.format("%d층입니다.", k33_floor);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
			
	}

}
