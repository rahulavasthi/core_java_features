package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sorting_List_Test {
	public static void main(String[] args){
		//sort list of string
		sortArrayOfString();
		
		//sort an object
		sortArrayOfObject();
	 }
	
	public static void sortArrayOfObject(){
		List<DVDInfo> testArray = new ArrayList<DVDInfo>();
		for(int i=0; i<5; i++){
			DVDInfo dVDInfo = new DVDInfo("title" +i, "genre" +i, "leadActor" +i);
			testArray.add(dVDInfo);
		}
		Collections.sort(testArray);
		System.out.println(testArray);
		GenreSort genreSort = new GenreSort();
		Collections.sort(testArray, genreSort);
		System.out.println(testArray);
	}
	
	public static void sortArrayOfString(){
		List<String> testArray = new ArrayList<String>();
		testArray.add("Rahul");
		testArray.add("Amit");
		testArray.add("Rahul Avasthi");
		System.out.println("Begin Array sorting");
		System.out.println("Unsorted Array");
		System.out.println(testArray);
		
		Collections.sort(testArray);
		System.out.println(testArray);
		System.out.println("End Array sorting");
	}
}

class DVDInfo implements Comparable<DVDInfo>{
	String title;
	String genre;
	String leadActor;
	DVDInfo(String t, String g, String a) {
		
		title = t; genre = g; leadActor = a;
	}
	public String toString() {
	return title + " " + genre + " " + leadActor + "\n";
	}
	
	@Override
	public int compareTo(DVDInfo d) {
		return title.compareTo(d.getTitle());
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getLeadActor() {
		return leadActor;
	}
	public void setLeadActor(String leadActor) {
		this.leadActor = leadActor;
	}
}

class GenreSort implements Comparator<DVDInfo> {
	public int compare(DVDInfo one, DVDInfo two) {
	return one.getGenre().compareTo(two.getGenre());
}
}