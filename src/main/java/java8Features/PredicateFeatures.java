package java8Features;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * java.util.function.Predicate is a Functional Interface 
 * Predicate with Lambda helps solve the DRY (don’t repeat yourself) problem.
 * Better testability, reusability and readability of the code
 */
public class PredicateFeatures {
	public static void main(String [] args){
		usingLambdaWithPredicate();
	}
	
	static void usingLambdaWithPredicate(){
		Predicate<Integer> greaterThanTen = (i) -> i > 10; 
		Predicate<Integer> lowerThanTwenty = (i) -> i < 20; 
		
		System.out.println(greaterThanTen.test(14));		//Output- true
		
		System.out.println(greaterThanTen.and(lowerThanTwenty).test(21));	//Output- false
		
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		int total = sumAll(numbers, n -> true); 
		int sumEven = sumAll(numbers, n -> n % 2 == 0); 
		int sumGreaterThan3 = sumAll(numbers, n -> n > 3); 
		
		System.out.println("Total- " + total + " Sum of even- " + sumEven + " Sum of greater than 3- " + sumGreaterThan3);		//Output- Total- 21 Sum of even- 12 Sum of greater than 3- 15
	}
	
	static int sumAll(List<Integer> nums, Predicate<Integer> p) {
		   int total = 0;
		   for (int number : nums) {
		      if (p.test(number)) {
		         total += number;
		      }
		   }
		   return total;
	}
}
