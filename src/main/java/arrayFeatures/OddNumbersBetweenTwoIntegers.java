package arrayFeatures;

import java.util.ArrayList;

public class OddNumbersBetweenTwoIntegers {
	public static void main(String[] args){
		int[] returnArray = oddNumbers(5, 15);
		for (int element : returnArray){
			System.out.println(element);
		}
		
	}
	
	public static int[] oddNumbers(int l, int r){
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		for (int i=0; i<= r-l; i++){
			int number = l+i;
			if (number%2 != 0){
				arrayList.add(number);
			}
		}
		
		return arrayList.stream().mapToInt(Integer :: intValue).toArray();
	}
}
