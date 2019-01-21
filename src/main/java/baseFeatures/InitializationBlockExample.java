package baseFeatures;

/**
 * The instance initializer block is created when instance of the class is created.
 * The instance initializer block is invoked after the parent class constructor is invoked (i.e. after super() constructor call).
 * The instance initializer block comes in the order in which they appear.
 */
public class InitializationBlockExample {
	public static void main(String [] args){
		/**
		 * Output
		 * instance initializer block invoked
		 * constructor is invoked
		 * speed is 100
		 */
		Bike7 b1=new Bike7(); 
		
		/**
		 * Output
		 * Parent instance initializer block is invoked
		 * parent class constructor invoked
		 * Child instance initializer block is invoked
		 * child class constructor invoked
		 */
		B2 b=new B2(); 
	}
}

class Bike7{  
    int speed;  
      
    Bike7(){
    	System.out.println("constructor is invoked");
    	System.out.println("speed is "+speed);
    }  
   
    {speed=100; System.out.println("instance initializer block invoked");}  //Initialization block (Used to perform some operations while assigning value to instance data member) 
}  

class A{  
	A(){System.out.println("parent class constructor invoked");}  
	
	{System.out.println("Parent instance initializer block is invoked");}
} 

class B2 extends A{  
	B2(){  
	super();  
	System.out.println("child class constructor invoked");  
	} 

	 {System.out.println("Child instance initializer block is invoked");}  
}