package baseFeatures;

public class OverloadedMethodsWithNull {
	
	public static void main(String[] args){
		new CheckNull(null);
	}

}

class CheckNull {
	CheckNull (Object o) {
		System.out.println("In object");
	}
	
	CheckNull (String o) {
		System.out.println("In String");
	}
	
	/*CheckNull (StringBuffer o) {
		System.out.println("In String buffer");
	}*/
}
