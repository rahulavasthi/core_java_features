package collections;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class CutomCollectionImplemetations {
	public static void main(String[] args) {
		System.out.print("Array List Implementation- ");		testCustomArrayList();
		System.out.print("Linked List Implementation- "); 		testCustomLinkedList();
		System.out.print("Hash Map Implementation- "); 			testCustomHashMap();
		System.out.print("Hash Set Implementation- "); 		testCustomHashSet();
	}

	private static void testCustomArrayList() {
		CustomArrayList<String> arrayList = new CustomArrayList<String>();
		System.out.print("Size - " + arrayList.size() + ", ");
		arrayList.add("abc");
		arrayList.add("xyz");
		System.out.print("Size - " + arrayList.size()+ ", ");
		arrayList.remove("xyz");
		System.out.println("Size - " + arrayList.size());
	}
	
	private static void testCustomLinkedList() {
		CustomLinkedList<String> linkedList = new CustomLinkedList<String>();
		System.out.print("Size - " + linkedList.size() + ", ");
		linkedList.add("abc");
		linkedList.add("xyz");
		System.out.print("Size - " + linkedList.size() + ", ");
		linkedList.remove("xyz");
		System.out.println("Size - " + linkedList.size());
	}
	
	private static void testCustomHashMap() {
		CustomHashMap<Integer, Integer> hashMapCustom = new CustomHashMap<Integer, Integer>();
        hashMapCustom.put(21, 12);
        hashMapCustom.put(25, 121);
        hashMapCustom.put(30, 151);
        hashMapCustom.put(33, 15);
        hashMapCustom.put(35, 89);

        System.out.println("value corresponding to key 21="
                     + hashMapCustom.get(21));
        System.out.println("value corresponding to key 51="
                     + hashMapCustom.get(51));

        System.out.print("Displaying : ");
        hashMapCustom.display();

        System.out.println("\n\nvalue corresponding to key 21 removed: "
                     + hashMapCustom.remove(21));
        System.out.println("value corresponding to key 51 removed: "
                     + hashMapCustom.remove(51));

        System.out.print("Displaying : ");
        hashMapCustom.display();
	}
	
	private static void testCustomHashSet() {
		
	}
}