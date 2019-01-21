package basicPrograms;

import java.text.DecimalFormat;

public class RoundOfDouble {
	public static void main(String[] args){
		double number = 16.666666;
		
		//round a number- for calculation
		double number1 = Math.round(number*100d)/100d;
		System.out.println(number1);
		
		//round a number- for display
		DecimalFormat format = new DecimalFormat("#.##");
		format.format(number);
		System.out.println(number1);
		
		//truncate number- For calculation
		number1 = Math.floor(number*100)/100;
		System.out.println(number1);
	}	
}
