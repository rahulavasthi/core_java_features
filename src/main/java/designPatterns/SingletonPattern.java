package designPatterns;

/**
 * Two ways to create
 * 1. Lazy Loading- Using volatile instance variable, double checking and private constructor
 * 2. Early loading- Create static instance variable and private constructor
 * 3. Using static initialization block, provide margin for exception ha
 */
public class SingletonPattern {
	public static void main(String args[]){
		Singleton_Lazy instance1 = Singleton_Lazy.getInstance();
		
		Singleton_Eager instance2 = Singleton_Eager.getInstance();
	}
}

class Singleton_Lazy{
	private static volatile Singleton_Lazy _instance;
	
	private Singleton_Lazy(){};
	
	public static Singleton_Lazy getInstance(){
		if (_instance ==null){
			synchronized(Singleton_Lazy.class){
				if (_instance ==null) _instance = new Singleton_Lazy();
			}
		}
		return _instance;
	}
}

class Singleton_Eager{
	private static Singleton_Eager _instance = new Singleton_Eager();
	
	private Singleton_Eager(){};
	
	public static Singleton_Eager getInstance(){
		return _instance;
	}
}




