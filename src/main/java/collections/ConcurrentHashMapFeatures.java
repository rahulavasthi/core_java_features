package collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * update operations like put(), remove(), putAll() or clear() is not synchronized, concurrent retrieval may not reflect most recent change on Map.
 * Iterator of ConcurrentHashMap's keySet area is fail-safe and doesn’t throw ConcurrentModificationExceptoin.
 * ConcurrentHashMap doesn't allow null as key or value.
*/
public class ConcurrentHashMapFeatures {
	public static void main(String[] args) {

		//ConcurrentHashMap
		Map<String,String> myMap = new ConcurrentHashMap<String,String>();
		myMap.put("1", "1");
		myMap.put("2", "1");
		myMap.put("3", "1");
		myMap.put("4", "1");
		myMap.put("5", "1");
		myMap.put("6", "1");
		System.out.println("ConcurrentHashMap before iterator: "+myMap);
		Iterator<String> it = myMap.keySet().iterator();

		while(it.hasNext()){
			String key = it.next();
			if(key.equals("3")) myMap.put(key+"new", "new3");
		}
		System.out.println("ConcurrentHashMap after iterator: "+myMap);

		//HashMap
		myMap = new HashMap<String,String>();
		myMap.put("1", "1");
		myMap.put("2", "1");
		myMap.put("3", "1");
		myMap.put("4", "1");
		myMap.put("5", "1");
		myMap.put("6", "1");
		System.out.println("HashMap before iterator: "+myMap);
		Iterator<String> it1 = myMap.keySet().iterator();

		while(it1.hasNext()){
			String key = it1.next();
			if(key.equals("3")) myMap.put(key+"new", "new3");
		}
		System.out.println("HashMap after iterator: "+myMap);
	}

}

//Output
/**
 * ConcurrentHashMap before iterator: {1=1, 2=1, 3=1, 4=1, 5=1, 6=1}
 * ConcurrentHashMap after iterator: {1=1, 2=1, 3=1, 4=1, 5=1, 3new=new3, 6=1}
 * HashMap before iterator: {1=1, 2=1, 3=1, 4=1, 5=1, 6=1}
Exception in thread "main" java.util.ConcurrentModificationException
	at java.util.HashMap$HashIterator.nextNode(Unknown Source)
	at java.util.HashMap$KeyIterator.next(Unknown Source)
	at collections.CustomConcurrentHashMap.main(CustomConcurrentHashMap.java:45)
 */


