package java8Features;

import java.util.Arrays;
import java.util.List;

/**
 * Brings Anonymous function types in Java- known as closures or anonymous methods
 * Method without a declaration 
 * Optional type declaration 
 * Optional parameter parenthesis- Required for multiple parameters
 * Optional return keyword - Required to indicate that expression returns a value.
 * Basic syntax - (parameters) -> {body} Ex- (int x, int y) -> {x + y}
 * Useful in places where a method is being used only once, and the method definition is short
 * 
 * Lambda expression returns a reference of SAM (Simple Abstract Method) interface
 * 
 * Method References- Compact and more readable form of a Lambda expression for already written methods. “::” operator is used for method reference.
 * 		Lambda Expression 						Equivalent Method Reference
 *		x -> String.valueOf(x)					String::valueOf
 *		() -> x.toString()						x::toString
 *		x -> x.toString()						Object::toString
 *		() -> new ArrayList<>()					ArrayList::new
 */
public class LambdaExpressions {
	public static void main(String [] args){
		List<Integer> numbers =  Arrays.asList(1,2,3,4); 
		
		beforeJava8(numbers); 	// Before Java 8	
		System.out.print("\n"); 
		afterJava8(numbers); 	// After Java 8
	}
	
	static void beforeJava8(List<Integer> numbers){
		for(int number : numbers) {
			   System.out.print(number); 
		}
	}
	
	static void afterJava8(List<Integer> numbers){
		numbers.forEach((Integer value) -> System.out.print(value));
		System.out.print("\n"); 
		numbers.forEach(value -> System.out.print(value));		//Type Inference- Type not specified
		System.out.print("\n"); 
		numbers.forEach(System.out::print);					//Method References
	}
}
