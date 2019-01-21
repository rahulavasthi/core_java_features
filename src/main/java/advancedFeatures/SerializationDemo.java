package advancedFeatures;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * If a class has a reference of another class, all the references must be Serializable otherwise serialization process will not be performed. 
 * In such case, NotSerializableException is thrown at runtime.
 * 
 * If a class implements serializable then all its sub classes will also be serializable.
 * 
 * If there is any static data member in a class, it will not be serialized because static is the part of class not object.
 * 
 * Static variables value can be stored while serializing if the same is provided while initialization (Behave as constant "final" variables).
 * 
 * If variable is defined as Static and Transient both, than static modifier will govern the behavior of variable and not Transient.
 * 
 * In case of array or collection, all the objects of array or collection must be serializable. If any object is not serialiizable, serialization will be failed.
 * 
 * The Externalizable interface provides the facility of writing the state of an object into a byte stream in compress format. It is not a marker interface.
 * 
 * It is mainly used in Hibernate, RMI, JPA, EJB and JMS technologies.
 * 
 * It is mainly used to travel object's state on the network (known as marshaling).
 * 
 * serialVersionUID is used during deserialization to verify that the sender and receiver of a serialized object have loaded classes for that object that are compatible with respect to serialization. 
 * If the receiver has loaded a class for the object that has a different serialVersionUID than that of the corresponding sender's class, then deserialization will result in an  InvalidClassException.
 * 
 * Circular references- writeobject/readobject maintain an "identity hash map" IdentityHashMap<Object,Handle> for each object it writes out. and if present will just write out the handle.object.
 *
 */
public class SerializationDemo {
	public static void main(String [] args) {
	      Employee e = new Employee();
	      e.name = "Rahul Avasthi";
	      e.address = "A-62 Sai Enclave";
	      e.SSN = 11122333;
	      e.number = 101;
	      
	      serializeObject(e);
	      System.out.println("\n");
	      deSerializeObject();
	}
	
	private static void serializeObject(Employee e){
		try {
	         FileOutputStream fileOut = new FileOutputStream("C://App Home//employee.txt");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(e);
	         out.close();
	         fileOut.close();
	         System.out.printf("Serialized data is saved in C://App Home/employee.txt");
	      }catch(IOException i) {
	         i.printStackTrace();
	      }
	}
	
	private static void deSerializeObject(){
		Employee e = null;
	      try {
	         FileInputStream fileIn = new FileInputStream("C://App Home//employee.txt");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         e = (Employee) in.readObject();
	         in.close();
	         fileIn.close();
	      }catch(IOException i) {
	         i.printStackTrace();
	         return;
	      }catch(ClassNotFoundException c) {
	         System.out.println("Employee class not found");
	         c.printStackTrace();
	         return;
	      }
	      
	      System.out.println("Deserialized Employee...");
	      System.out.println("Name: " + e.name);				
	      System.out.println("Address: " + e.address);			
	      System.out.println("SSN: " + e.SSN);					
	      System.out.println("Number: " + e.number);		
	}
}

class Employee implements SerializableExtend {
	   public static String name;
	   public static String address;
	   public transient int SSN;
	   public int number;
	   
	   public void mailCheck() {
	      System.out.println("Mailing a check to " + name + " " + address);
	   }
}

interface SerializableExtend extends Serializable{
	
}
