package baseFeatures;

public class SuperAndThis {
	public static void main(String[] args) {
		SubClass subClass = new SubClass();
		subClass.methodOfSubClass();
	}
}


class SuperClass
{
    int i;    //Field
 
    SuperClass(int i)
    {
        System.out.println("Super Class Constructor");
        this.i= i;
    }
 
    void methodOfSuperClass()     //method
    {
        System.out.println("From method of super class");
    }
}
 
class SubClass extends SuperClass
{
    SubClass()
    {
        super(10);
        //Calling statement to super class constructor
    }
 
    void methodOfSubClass()
    {
        System.out.println(i);  //super class field is accessed
        methodOfSuperClass();  // super class method is called
        System.out.println("From method of sub class");
    }
}

class AB
{
    int i;   //Non-final global variable, no need to initialize them
 
    final int j;         //Blank Final Field
 
    AB()
    {
        j=20;    
 
        //final global variable must get a value at the time of object creation.
    }
}