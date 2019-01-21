package baseFeatures;

public class BaseAlgoFeaturesTest {
	public static void main(String args[]){
		int intValue1= -11;
		int intvalue2= 2;
		
		double doubleValue1= -12.0;
		double doubleValue2= 12.0;
		
		System.out.println("Absolute value of int " + intValue1 + "- " + absoluteValueOfInt(intValue1) + "\n");
		
		System.out.println("Absolute value of double " + doubleValue1 + "- " + absoluteValueOfDouble(doubleValue1) + "\n");
		
		System.out.println("Is " + intvalue2 + " is prime "  + " - " + isPrime(intvalue2) + "\n");
		System.out.println("Is "+ 9 + " is prime " + " - " + isPrime(9) + "\n");
		
		System.out.println("Square root of number(double) " + doubleValue2 + " - " + sqrt(doubleValue1) + "\n");
		System.out.println("Square root of number(int) " + intvalue2 + " - " + sqrt(intvalue2) + "\n");
		
		System.out.println("Hypotenuse of " + doubleValue1 + "and " + doubleValue2 + " - " + hypotenuse(doubleValue1, doubleValue2) + "\n");
		
		System.out.println("Harmonic number of " + intvalue2 + "th number- " + harmonicNumber(intvalue2) + "\n");
		
		System.out.println("Check for division and remainder -14/3 = " + -14/3 + "\t14/-3= " + 14/-3 +"\t-14%3= " + -14%3 + "\t14%-3= "+ 14%-3 + "\n");
		
	}
	
	private static int absoluteValueOfInt(int value){
		if (value < 0){
			return -value;
		}else{
			return value;
		}
	}
	
	private static double absoluteValueOfDouble(double value){
		if (value < 0.0){
			return -value;
		}else{
			return value;
		}
	}
	
	private static boolean isPrime(int value){ //prime number is divided by only 1 or by itself
		if(value < 2) return false;
		
		for(int i = 2; i*i <=value; i++) {if (value % i == 0) return false;}
		
		return true;
	}
	
	private static double sqrt(double value){
		
		if (value < 0) return Double.NaN;
		double err = 1e-15;
		double temp = value;
		while (Math.abs(temp - value/temp) > err * temp)
		temp = (value/temp + temp) / 2.0;
		return temp;
	}
	
	
	private static double hypotenuse(double value1, double value2){
		
		return Math.round(Math.sqrt(value1*value1 + value2*value2)*100.0)/100.0; 
	}
	
	private static double harmonicNumber(int value){
		double sum = 0.0;
		for (int i = 1; i <= value; i++)
		sum += 1.0 / i;
		return Math.round(sum*100.0)/100.0;
	}
	
}
