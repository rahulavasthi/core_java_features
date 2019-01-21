package StringFeatures;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringFeatures {
	
	public static String sing() { return "fa"; }
	
	static String s = "-";
	
	public static void main(String[] args) {
		//Pattern and matcher***********************************************
			String [] arr1 = {"\\d*", "ab34ef"};
			Pattern p = Pattern.compile(arr1[0]);
			Matcher m = p.matcher(arr1[1]);
			boolean b = false;
			while(b = m.find()) {
			System.out.print(m.start() + m.group());
			}
		//End of Pattern and matcher*********************
	}
}	
	
