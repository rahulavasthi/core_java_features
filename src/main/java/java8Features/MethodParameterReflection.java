package java8Features;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Optional;

/**
 * New feature to the Reflection API that enables reading the actual names of the parameters of a method.
 * At compile time, we need to pass a compiler flag: javac -parameters and get method parameter names via reflection. 
 * In Eclipse, enable Store information about method parameters: Window -> Preferences -> Compiler -> Classfile Generation
 * 
 * Optional References- java.util.Optional to handle null references (NullPointerException).
 * Cons of Optional References:
 *		Can itself be null, causing a NullPointerException.
 *		Increases heap size.
 *		Makes debugging more difficult.
 *		Makes serializing objects, say as an XML or JSON for an external client, much more difficult.
 */
public class MethodParameterReflection {
	
	public static void main(String args[]) throws NoSuchMethodException, SecurityException {
		Class[] parameterTypes = new Class[2];
		parameterTypes[0] = String.class;
		parameterTypes[1] = String.class;
		Method method = MethodParam.class.getMethod("one", parameterTypes);
		beforeJava8(method);
		System.out.println("");
		afterJava8(method);
		
		Optional<String> opt = Optional.empty(); 
		System.out.println(opt.isPresent());
	}
	
	public static void beforeJava8(Method method) throws NoSuchMethodException, SecurityException {
		int paramCount = method.getParameterTypes().length;
		for (int i = 0; i < paramCount; i++) System.out.print("arg" + i + " ");
		
		//Output- arg0 arg1
	}
	
	public static void afterJava8(Method method) {
		for(Parameter parameter:method.getParameters()) {
	     	   System.out.print(parameter.getName() + " ");
	  	}     
	
	    //Output- one0 one1
	}
}

class MethodParam { public String one(String one3, String one4) { return "";} }
