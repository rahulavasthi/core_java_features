package StringFeatures;

public class IntergerToStringAndViceVersa {
	public static void main(String[] args) 
    {
        String s = "2015";
         
        int i = Integer.parseInt(s);
         
        System.out.println(i);          //Output : 2015
        
        i = Integer.valueOf(s);
        
        System.out.println(i);          //Output : 2015
        
        i = 2015;
        
        s = Integer.toString(i);
        
        System.out.println(s);     //Output : 2015
        
        s = String.valueOf(i);
        
        System.out.println(s);     //Output : 2015
    }
	
}
