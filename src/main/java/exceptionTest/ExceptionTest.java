package exceptionTest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
/**
 * By default Unchecked Exceptions are forwarded in calling chain (propagated).
 * By default, Checked Exceptions are not forwarded in calling chain (propagated).
 * 
 * 
 * Besides a System.exit(), the finally block will not run if the JVM crashes for some reason (e.g. infinite loop in your try block).
 * As far as the thread itself, only if it is stopped using the stop() method (or suspend() without resume()) will the finally block not be executed. 
 * A call to interrupt() will still result in the finally block being executed.
 * It's also worth noting that, since any return statement in the finally block will override any returns or exception throws in the try/catch blocks, 
 * program behavior can quickly become erratic and hard to debug if this happens to you. 
 * Not really anything worth taking precaution against (as it only happens in extremely rare cases), but worth being aware of so you can recognize it when it happens.
 *
 */
public class ExceptionTest {
	public static void main(String[] args) throws IOException{
		//Check throw and throws
		testThrowAndThrows();
		
		//test error throw
		//testErrorThrow();
		
		//custom exception
		//System.out.println("Value returned- " + testCustomException(17));
		
		System.out.println( methodReturningValue());	//Output- return value from try block, If put 'return s;" in finally than output will be return value from try blockreturn value from finally block
		
		
	}
	
	private static void testThrowAndThrows() throws IOException{
		System.out.println("Check");
		//throw new NullPointerException();
	}
	
	private static void testErrorThrow(){
		try {
			System.out.println("In try block");
			throw new Error();
		} catch (Exception e) {
			System.out.println("In catch block");
		}finally{
			System.out.println("In finally block");
		}
	}
	
	private static int testCustomException(int age){
		try {
			if(age<18) { 
		      throw new InvalidAgeException("not valid"); 
			}else { 
		      System.out.println("welcome to vote");
		      return 2;
			}
		} catch (Exception e) {
			System.out.println("Exception occurred " + e);  
			return 0;
		}finally{
			System.out.println("In finally block");
			return 1;
		}
		
		
		/**
		 * Output-
		 * Exception occurred exceptionTest.InvalidAgeException: not valid
		 * In finally block
		 * Value returned- 1
		 */
	}
	
	static String methodReturningValue()
    {
		String s = null;
        try
        {
            s = "return value from try block";
            return s;
        }
        catch (Exception e)
        {
            s = s + "return value from catch block";
            return s;
        }
        finally
        {
            s = s + "return value from finally block";
            return s;
        }
    }
}

class InvalidAgeException extends Exception{  
	 InvalidAgeException(String s){  
	  super(s);  
	 }  
} 

class InvalidAgeException1 extends RuntimeException{  
	InvalidAgeException1(String s){  
	  super(s);  
	 }  
} 

