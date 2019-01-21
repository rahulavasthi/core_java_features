package ByteArrayFeatures;

import java.util.Arrays;

import org.apache.tomcat.util.buf.Ascii;

public class ByteArrayExample {
	
	public static void main(String[] args){
		byte testByte= 50;
		
		testByte = (byte) (50*50);
		
		System.out.println(testByte);
		
		byte[] byteArray1 = {65, 66, 67, 68, 69, 70};
		
		byte[] byteArray2 = {71, 72, 73, 74, 75, 76};
		
		System.arraycopy(byteArray1, 2, byteArray2, 0, byteArray1.length - 2);
		
		for (byte byteValue: byteArray1){
			System.out.print((char) byteValue);
		}
		System.out.println("\n");
		for (byte byteValue: byteArray2){
			System.out.print((char) byteValue);
		}
		
	}

}
