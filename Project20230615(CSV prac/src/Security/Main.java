package Security;

import org.apache.commons.math4.legacy.stat.correlation.PearsonsCorrelation;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] x = {1, 2, 3, 4, 5};
		double[] y = {10, 20, 30, 40, 50};
		double[] y2 = {-10, -20, -30, -40, -50};
		
		double correlation = new PearsonsCorrelation().correlation(y, x);
		System.out.println(correlation);
		
		double correlation2 = new PearsonsCorrelation().correlation(y2,x);
		System.out.println(correlation2);
		}
	}


