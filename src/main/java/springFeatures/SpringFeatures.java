package springFeatures;

import java.lang.reflect.Field;

public class SpringFeatures {
	public static void main(String [] args) {
		runConstructorInjection();
		runUsingReflectionApi();
	}
	
	private static void runConstructorInjection(){
		MyClass mc = new MyFactory().createMyClass();
		mc.doSomething();
	}
	
	private static void runUsingReflectionApi(){
		MyClass mc = new MyClass();
		interfaceA interfaceAFieldObject= new InterfaceAImpl();
		interfaceB interfaceBFieldObject= new InterfaceBImpl();
		
		try{
		Field interfaceAField = MyClass.class.getDeclaredField("a");
		Field interfaceBField = MyClass.class.getDeclaredField("b");
		
		interfaceAField.setAccessible(true);
		interfaceBField.setAccessible(true);
		
		interfaceAField.set(mc, interfaceAFieldObject);
		interfaceBField.set(mc, interfaceBFieldObject);
		
		mc.doSomething();
		
		}catch(NoSuchFieldException ex){
			ex.printStackTrace();
		}catch(IllegalAccessException ex){
			ex.printStackTrace();
		}
		
	}
}

class MyClass{
	private interfaceA a;
	private interfaceB b;
	
	public MyClass(){
		
	}
	
	public MyClass(interfaceA a, interfaceB b){
		this.a = a;
		this.b = b;
	}
	
	public void doSomething(){
		System.out.println(a.testA());
		System.out.println(b.testB());
	}
}

class MyFactory {
	public MyClass createMyClass(){
		return new MyClass(new InterfaceAImpl(), new InterfaceBImpl());			//Constructor Injection method
	}
}
