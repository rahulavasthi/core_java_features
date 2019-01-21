package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class MapFeatures {
	public static void main(String[] args) {
		Map<ToDos, String> m = createMapForTest();
		
		checkKeySet(m);
		
		CheckEntrySet(m);
		
		getValues(m);
		
		sortMapByValues(m);
		
		sortMapByKeys(m);
	}
	
	private static Map<ToDos, String> createMapForTest(){
		Map<ToDos, String> m = new HashMap<ToDos, String>();
		ToDos t1 = new ToDos("Monday");
		ToDos t2 = new ToDos("Monday");
		ToDos t3 = new ToDos("Tuesday");
		m.put(t1, "doLaundry");
		m.put(t2, "payBills");
		m.put(t3, "cleanAttic");
		return m;
	}
	
	private static void checkKeySet(Map<ToDos, String> m){
		System.out.println("check size to find duplicate added- " + m.size());		//Output 2
		System.out.println(m.keySet());
		for(ToDos todo : m.keySet()){
			System.out.println(todo.day);	//Output Monday Tuesday
		}
	}
	
	private static void CheckEntrySet(Map<ToDos, String> m){
		System.out.println(m.entrySet());
		for(Map.Entry<ToDos, String> todo : m.entrySet()){
			System.out.println(todo.getValue());		//payBills cleanAttic
			System.out.println(todo.getKey().day);		//Monday Tuesday
		}
	}
	
	private static void getValues(Map<ToDos, String> m){
		Iterator it = m.keySet().iterator();		//Iterator can be used on Lists and Sets
		System.out.println("Map Values- ");		
		while (it.hasNext()) {
			System.out.println(m.get(it.next()));
		}
	}
	
	private static void sortMapByValues(Map<ToDos, String> m){
		List<Map.Entry<ToDos, String>> listOfEntries = new ArrayList<Map.Entry<ToDos, String>>(m.entrySet());
		Collections.sort(listOfEntries, new Comparator<Map.Entry<ToDos, String>>() {

			@Override
			public int compare(Entry<ToDos, String> o1, Entry<ToDos, String> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});
		
		Map<ToDos, String> newMapByValues = new HashMap<ToDos, String>();
		for (Map.Entry<ToDos, String> entry: listOfEntries){
			newMapByValues.put(entry.getKey(), entry.getValue());
		}
		System.out.println("UnSorted map" + m);
		System.out.println("Sorted map by values" + newMapByValues);
	}
	
	private static void sortMapByKeys(Map<ToDos, String> m){
		TreeMap<ToDos, String> treemap = new TreeMap<ToDos, String>(new ComparatorForMap());
		treemap.putAll(m);
		System.out.println("Sorted Map by keys" + treemap);
	}

}

class ToDos {
	String day;

	ToDos(String d) {
		day = d;
	}

	public boolean equals(Object o) {
		return ((ToDos) o).day == this.day;
	}

	public int hashCode() {
		return 9;
	}
}

class Turtle {
	int size;

	public Turtle(int s) {
		size = s;
	}

	public boolean equals(Object o) {
		return (this.size == ((Turtle) o).size);
	}
	public int hashCode() { return size/5; }
}

class ComparatorForMap implements Comparator<ToDos>{
	@Override
	public int compare(ToDos o1, ToDos o2) {
		return o1.day.compareTo(o2.day);
	}
	
}
