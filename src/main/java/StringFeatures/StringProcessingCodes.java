package StringFeatures;

public class StringProcessingCodes {
	public static void main(String args[]){
		String testString1 = "Test string";
		String testString2 = "Dad";
		
		String[] arrayOfStrings1 = {"Abc", "Cab", "Bac"};
		String[] arrayOfStrings2 = {"Abc", "Cab", "Dac"};
		
		// Palindrome is same after reverse
		System.out.println("Is string '" + testString1 +  "' a palindrome? " + isPalindrome(testString1) + "\n");
		System.out.println("Is string '" + testString2 +  "' a palindrome? " + isPalindrome(testString2) + "\n");
		
		System.out.println("Is 'arrayOfStrings1' is in Alphabetical order? " + isSorted(arrayOfStrings1) + "\n");
		System.out.println("Is 'arrayOfStrings2' is in Alphabetical order? " + isSorted(arrayOfStrings2) + "\n");
		
	}
	
	private static boolean isPalindrome(String value){
		int length = value.length();
		
		value = value.toUpperCase();
		for (int i=0; i<length; i++) {if(value.charAt(i) != value.charAt(length-1-i)) return false;}
		
		return true;
	}
	
	private static boolean isSorted(String[] value){
		for(int i=1; i< value.length; i++){
			if(value[i-1].compareToIgnoreCase(value[i]) > 0) return false;
		}
		
		return true;
	}
}
