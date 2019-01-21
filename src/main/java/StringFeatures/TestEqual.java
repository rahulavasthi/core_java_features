package StringFeatures;

public class TestEqual {
	
	public static void main(String[] args) {
		//Test string equality
		testStringEquality();
	}
	
	
	public static void testStringEquality(){
		String s1 = "yes", s2 = "yes";
		String s3 = new String("yes");
		System.out.println((s1==s3) + "\n");			//false
		System.out.println(s1.equals(s2) + "\n");		//true
		System.out.println(s2.equals(s3));				//true
		
		String test = "  abcd aab fhzx  ";
		String[] words = test.trim().split(" ");
		
		System.out.println(words.length);
	}
}


