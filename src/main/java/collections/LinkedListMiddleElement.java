package collections;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListMiddleElement {
	public static void main(String args[]) {
        //creating LinkedList with 5 elements including head
      LinkedList<String> linkedList = new LinkedList<String>();
      
      linkedList.add("1");
      linkedList.add("2");
      linkedList.add("3");
      linkedList.add("4");
      linkedList.add("5");
      linkedList.add("6");
      
      //finding middle element of LinkedList in single pass
      String current = linkedList.getFirst();
      int length = linkedList.size();
      String middle = current;
      if (length%2 == 0){
    	  middle = linkedList.get(length/2- 1);
      }else{
    	  middle = linkedList.get(length/2);
      }
      
      System.out.println("length of LinkedList: " + length);
      System.out.println("middle element of LinkedList : " + middle);
      
    } 
}
