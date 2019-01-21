package java8Features;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Streams provide an interface to a sequenced set of values of a specific element type
 * Don’t actually store elements; they are computed on demand.
 * Consume from a data-providing source such as Collections, Arrays, or I/O resources.
 * Support common higher order functions – filter, map, reduce, find, match, sorted, and so on. 
 * Pipelining: Many stream operations return a stream, thus allowing operations to be chained to form a larger pipeline. 
 * Enables certain optimizations, such as lazy evaluation.
 * Collection interface has been extended with stream() and parallelStream() default methods – sequential/parallel execution.
 * 
 * Streams vs. Collections
 * 
 * 		Stream																				Collection
 * 		Streams are fixed data structures which computes the elements on-demand basis.		Collections are in-memory data structures which hold elements within it.
 * 		Streams can be seen as lazily constructed Collections, where the values 			Collections behave absolutely opposite to it and they are set on eagerly 
 * 		are computed when user demands for it.												computed values (no matter if the user demands for a particular value or not).
 * 		Parallel and Sequential execution													Sequential execution
 * 		Internal Iteration																	External Iteration (forEach needed)
 * 
 * 		map()- 
 * 			Applies an operation across each element present within a stream. 
 * 			Returns a stream consisting of the results of applying the given function to the elements of the previous stream.
 * 
 * 		filter()-
 * 				Returns a stream consisting of the elements of a given stream that match the given predicate/condition.
 * 
 * 		reduce()-
 * 				Reduction takes a sequence of elements and combines them into a single summary result by repeated application of a combining operation (e.g. sum or max).
 * 				Stream classes have multiple forms of reduction operations, called reduce() and collect(), as well as multiple specialized forms such as average(), sum(), max() or count().
 */		
public class Streams {
	public static void main(String args[]) {
		List<Integer> myList = Arrays.asList(1, 2, 3, 4,5,6,7,8,9);
		//sequential stream
		Stream<Integer> sequentialStream = myList.stream();
		
		//parallel stream
		Stream<Integer> parallelStream = myList.parallelStream();
		
		sequentialStream.forEach(System.out::print);			//Output- 123456789
		System.out.println("");
		parallelStream.forEach(System.out::print);				//Output- 387624519 (Any random)
		System.out.println("");
		
		//Map example
		int sum = myList.stream().map(x -> x * x).reduce((s, x) -> s + x).get();
		
		System.out.println(sum);						//Output- 285 (Sum of square 1-9)

		//Filter Example
		List<String> names = Arrays.asList("Rahul", "Amit", "Sachin", "Sikha");
		Optional<String> firstS = names.stream().filter(name -> name.startsWith("S")).findFirst();
			
		System.out.print(firstS.orElse("None found"));					//Output- Sachin
	}
}
