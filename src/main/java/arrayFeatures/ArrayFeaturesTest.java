package arrayFeatures;

import java.util.Arrays;

public class ArrayFeaturesTest {
	public static void main(String args[]){
		
		//Array is initialized to '0' for all elements
		double [] testArray = new double[10];
		System.out.println(testArray[5] + "**" + testArray.length);		//Output- 0.0**10
		
		double[] testArray1 = {10, 8, 4, 25, 1, 30, 7, 5, 2};
		double[] testArray2 = {45, 9, 3, 26, 1, 32, 8, 6, 11};
		
		System.out.print(" Array Values- "); for (double d : testArray1) {System.out.print(d+ "\t");}
		
		System.out.println("\n");
		
		System.out.println("*** Find maximum value in list of values ***");
		System.out.print("Maximum value is- "); System.out.println(findMaxValue(testArray1));
		
		System.out.println("\n");
		
		System.out.println("*** Find average of given values ***");
		System.out.print("Average value- "); System.out.println(findAverageValue(testArray1));
		
		System.out.println("\n");
		
		System.out.println("*** Copy to another array ***");
		System.out.print("Copied Array- "); for (double d : copyToAnotherArray(testArray1)) {System.out.print(d+ "\t");}
		
		System.out.println("\n");
		
		System.out.println("*** Reverse array ***");
		System.out.print("Reverse Array- "); for (double d : reverseArray(testArray1)) {System.out.print(d+ "\t");}
		
		System.out.println("\n");
		
		/*System.out.println("*** Matrix multiplication ***");
		System.out.print("Matrix multiplication Array- "); for (double[] d : matrixArray(testArray1, testArray2)) {System.out.print(d+ "\t");}*/
		
	}
	
	private static double findMaxValue(double[] paramArray){
		Arrays.sort(paramArray);
		double maxValue = paramArray[paramArray.length -1] ;
		/*double maxValue = paramArray[0];
		
		for (double d : paramArray) {
			if (d > maxValue){
				maxValue =d;
			}
		}*/
		
		return maxValue;
	}
	
	private static double findAverageValue(double[] paramArray){
		double averageValue;
		double sum = 0;
		for (double d : paramArray) {
			sum += d;
		}
		
		averageValue = sum/paramArray.length;
		
		return Math.round(averageValue*100.0)/100.0;
	}
	
	private static double[] copyToAnotherArray(double[] paramArray){
		//double[] newArray = Arrays.copyOf(paramArray, paramArray.length);
		double[] newArray = new double[paramArray.length];
		System.arraycopy(paramArray, 0, newArray, 0, paramArray.length);
		/*int length = paramArray.length;
		//No add or push method in array
		double[] newArray = new double[length];
		for(int i=0; i < length; i++){
			newArray[i]= paramArray[i];
		}*/
		return newArray;
	}
	
	private static double[] reverseArray(double[] paramArray){
		int length = paramArray.length;
		
		for(int i=0; i < length/2; i++){
			double temp = paramArray[i];
			paramArray[i] = paramArray[length-1-i];
			paramArray[length-1-i] = temp;
		}
		return paramArray;
	}
	
	/*private static double[][] matrixArray(double[] paramArray1, double[] paramArray2){
		int length = paramArray1.length;
		
		double[][] matrixMultiplication = new double[length][length];
		for(int i=0; i< length; i++){
			for(int j=0; j< length; j++){
				for(int k=0; k< length; k++){
					matrixMultiplication[i][j] += paramArray1[i][k]*paramArray2[k][j];
				}
			}
		}
		return matrixMultiplication;
	}*/
}
