package arrayFeatures;

public class FindDuplicatesInArray {
	public static void main(String [] args) {
		double [] testArray1 = {3, 4, 5, 6, 7, 5, 8, 9};
		
		for (double element : testArray1){
			if (testArray1[Math.abs((int) element)] >= 0)
				testArray1[Math.abs((int) element)] = -testArray1[Math.abs((int) element)];
			    else
			      System.out.println(Math.abs(element));
		}
	}
}
