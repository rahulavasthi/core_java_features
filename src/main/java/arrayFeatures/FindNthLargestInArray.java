package arrayFeatures;

import java.util.Arrays;

public class FindNthLargestInArray {
	public static void main(String [] args) {
		int [] testArray1 = {3, 1, 2, 2, 3, 4, 5, 6, 7, 8, 9};
		int n =8;
		Arrays.sort(testArray1);	//sort Array
		int[] temp = new int[testArray1.length];
		
		//remove duplicates
		for (int i =0, j=0; i < testArray1.length-1 ; i++){
			if(testArray1[i] != testArray1[i+1]){
				temp[j++] = testArray1[i];
			}
		}
		
		System.out.println(temp[n-1]);
	}
}
