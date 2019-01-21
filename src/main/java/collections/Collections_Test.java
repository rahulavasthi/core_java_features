package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

public class Collections_Test {
	public static void main(String[] args) {
		// Array to LIst and vice-versa
		// When you update one of them, the other gets updated automatically.
		System.out.println("****Begin of Arrays to List****");
		listToArrayViceVersa();
		System.out.println("****End of Arrays to List****");
		
		//Check a null can not be used in forEach loop
		System.out.println("****Begin of check null in for-each loop****");
		testNullPoniterInForEach();
		System.out.println("****End of check null in for-each loop****");
		
		//find unique list
		System.out.println("****Begin of unique list****");
		findUniqueList();
		System.out.println("****End of unique list****");
		
		ArrayList<String> list = new ArrayList<String>();
        
        //Adding elements to list
         
        list.add("JAVA");
         
        list.add("STRUTS");
         
        list.add("JSP");
         
        list.add("SERVLETS");
         
        list.add("JSF");
         
        //Getting synchronized list
         
        List<String> synchronizedList = Collections.synchronizedList(list);
         
        //you must use synchronized block while iterating over synchronizedList
        
            Iterator<String> it = synchronizedList.iterator();
             
            while (it.hasNext()) 
            {
                System.out.println(it.next());
            }
	}

	public static void listToArrayViceVersa() {
		String[] sa = { "one", "two", "three", "four" };
		List sList = Arrays.asList(sa); // make a List
	
		System.out.println("size " + sList.size());
		System.out.println("idx2 " + sList.get(2));
		
		sList.set(3, "six"); // change List
		sa[1] = "five"; // change array
		for (String s : sa)
			System.out.print(s + " ");
		System.out.println("\nsl[1] " + sList.get(1));
	}

	public static void testNullPoniterInForEach() {
		List<Integer> checkNull= null;
		
		try{
			for (int i : checkNull){
				System.out.println(i);
			}
		}catch(NullPointerException ex){
			ex.printStackTrace();
		}
	}
	
	public static void findUniqueList() {
		List<String> sList = new ArrayList<String>();
		sList.add("One");
		sList.add("two");
		sList.add("One");
		sList.add("two");
		
		
		Iterator it = sList.iterator();
		while (it.hasNext())
			System.out.print(it.next() + " ");
		
		Set<String> set = new HashSet<String>(sList);
		System.out.print( "\n **** Start of set print \n");
		Iterator itforset = set.iterator();
		while (itforset.hasNext())
			System.out.print(itforset.next() + " ");
		
		System.out.println("\n **** Check add all method");
		sList.addAll(set);
		Iterator itList = sList.iterator();
		System.out.print("\n");
		while (itList.hasNext())
			System.out.print(itList.next() + " ");
	}
}