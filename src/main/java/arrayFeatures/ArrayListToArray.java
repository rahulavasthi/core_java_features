package arrayFeatures;

import java.util.ArrayList;

public class ArrayListToArray {
	public static void main(String args[]){
		ArrayList<Integer> testArrayList = new ArrayList<Integer>();
		testArrayList.add(1);
		testArrayList.add(2);
		testArrayList.add(3);
		
		Object[] testArray = testArrayList.toArray();
		
		//testArrayList.forEach(x -> System.out.print(x));
		
		for (Object object : testArray) {
			System.out.println(object);
		}
	}
}
