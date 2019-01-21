package arrayFeatures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ArrayToArrayListMethods {
	public static void main(String args[]){
		Integer[] arrayTest = {1,2,3,4, 5};
		
		//testAsList(arrayTest);
		
		//testCollectionsAddAll(arrayTest);
		
		//testArrayListAddAll(arrayTest);
		
		testArraysStreamJava8(arrayTest);
		
	}
	
	static public void testAsList(Integer[] arrayTest){
		List<Integer> testArrayList1 = Arrays.asList(arrayTest);
		
		//testArrayList1.add(6);	//UnsupportedOperationException
		
		System.out.println(testArrayList1.size());
		
		testArrayList1.set(1, 8);				//Change Array also
		
		System.out.println(arrayTest[1]);		//Output - 8
		
		ArrayList<Integer> testArrayList2 = new ArrayList<Integer>(Arrays.asList(arrayTest));
		
		testArrayList2.add(6);	//Works fine
		
		System.out.println(testArrayList2.size());		//Print 6
	}
	
	static public void testCollectionsAddAll(Integer[] arrayTest){
		ArrayList<Integer> testArrayList = new ArrayList<Integer>();
		Collections.addAll(testArrayList, arrayTest);
		
		System.out.println(testArrayList.size());	
		testArrayList.add(6);
		System.out.println(testArrayList.size());
	}
	
	static public void testArrayListAddAll(Integer[] arrayTest){
		ArrayList<Integer> testArrayList = new ArrayList<Integer>();
		testArrayList.addAll(Arrays.asList(arrayTest));
		System.out.println(testArrayList.size());	
		testArrayList.add(6);
		System.out.println(testArrayList.size());
	}
	
	static public void testArraysStreamJava8(Integer[] arrayTest){
		List<Integer> testArrayList = Arrays.stream(arrayTest).collect(Collectors.toList());
		System.out.println(testArrayList.size());	
		testArrayList.add(6);
		System.out.println(testArrayList.size());
	}
		
}

