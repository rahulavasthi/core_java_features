package baseFeatures;

import StringFeatures.IntergerToStringAndViceVersa;

public class WrapperMethodsEx {
	public static void main(String [] args){
		int testInt= 20;
		Integer testInteger;
		String testString = "21";
		
		System.out.println("******Begin of Integer.valueOf()******");
		testInteger = Integer.valueOf(testInt);	//Returns an Integer instance representing the specified int value. Preferred to the constructor Integer(int). Provide caching (better space and time performance)
		System.out.println(testInteger);		//Output- 20
		
		testInteger = Integer.valueOf(testString);	//Same as Integer.valueOf(testInt)
		System.out.println(testInteger);		//Output- 20
		
		testInteger = Integer.valueOf(testString, 8);	//returns an Integer object equal to the value of: new Integer(Integer.parseInt(s, radix)) 
		System.out.println(testInteger);		//Output- 16
		
		System.out.println("******End of Integer.valueOf()******");

		System.out.println("******Begin of Integer.intValue()******");
		
		testInt = testInteger.intValue();
		System.out.println(testInt);		//Output- 16
		
		System.out.println("******End of Integer.intValue()******");
		
		testInt = Integer.parseInt(testString);
		
		System.out.println(testInt);

	}
}
