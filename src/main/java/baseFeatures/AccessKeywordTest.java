package baseFeatures;

/**
 * static methods can't be overridden, but they can be redefined. (Runtime polymorphism is not applied to Static method)
 * 
 *Overloaded methods can change return types; overridden methods cannot, except in case of covariant (subclass) returns.
 */
public class AccessKeywordTest {
	public static void main(String [] args){
		Fruit fruit = new Apple();
		fruit.getFruit();		//Output- I am in fruit class
		fruit.getFruit1();		//Output- I am in Apple class class
		
		SubtypeClass subtypeClass = (SubtypeClass) new AccessKeywordTest();		//Child class reference can not refer parent object without casting
	}
}

class Fruit {
	public static void getFruit(){
		System.out.println("I am in fruit class");
	}
	
	public void getFruit1(){
		System.out.println("I am in fruit class");
	}
}

class Apple extends Fruit {
	public static void getFruit(){
		System.out.println("I am in Apple class class");
	}
	
	public void getFruit1(){
		System.out.println("I am in Apple class class");
	}
}

class SubtypeClass extends AccessKeywordTest {
	
}
