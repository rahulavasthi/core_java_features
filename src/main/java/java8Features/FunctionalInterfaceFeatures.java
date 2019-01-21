package java8Features;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Functional (Single Abstract Method) Interfaces- Can contain only one abstract method.
 * Can be instantiated using Lambdas
 * Identified by an Annotation @FunctionalInterface, however it is not mandatory
 * Can declare the methods of Object.class.
 * Difference with Abstract class- Abstract classes are more structured and have a state (member variables) associated. Functional Interface cannot have a constructor.
 * Interface converted to Functional for them to be used with Lambdas- java.lang.Runnable, java.util.Comparator, java.awt.event.ActionListener, java.util.concurrent.Callable
 * 
 * Default Methods- Provide some default implementation to an interface with backward compatibility. Default methods cannot override equals, hashCode, and toString of the Object.class.
 * Reason- Inheriting equals/hashCode/toString will strongly tied to single inheritance and state, and interfaces are multiply inherited and stateless;
 * 
 * Defender Methods – Helps in evolving the interfaces without breaking the existing implementations of the interface. 
 * 
 * Virtual Extension Methods – Allows extension of existing interfaces.
 * 
 * Example-  Consumer, Supplier, Function and Predicate.
 * 
 */

@FunctionalInterface			//Can contain only one abstract method.
interface SimpleFuncInterface {
	public void doWork();
	//public void doWork1();
	//public String isFunctional(); //if uncommented there will be an error
	default public void doSomeOtherWork()  {
	    System.out.println("DoSomeOtherWork implementation in the interface");
	}
	default public void doSomeOtherWork1()  {
	    System.out.println("DoSomeOtherWork implementation in the interface 123");
	}
}

public class FunctionalInterfaceFeatures implements  SimpleFuncInterface{
	public static void main(String [] args){
		//beforeJava8(); 	// Before Java 8
		
		//afterJava8(); 	// After Java 8
		new FunctionalInterfaceFeatures().doSomeOtherWork();
		new FunctionalInterfaceFeatures().doSomeOtherWork1();
	}
	
	static void beforeJava8(){
		new Thread(new Runnable() {
			@Override
			public void run() {
			    System.out.println("It runs !");
			  }
			}).start();
	}
	
	static void afterJava8(){
		new Thread(() -> {
			   System.out.println("It runs !"); 
			}).start(); 
	}

	@Override
	public void doWork() {
		// TODO Auto-generated method stub
	}
}

