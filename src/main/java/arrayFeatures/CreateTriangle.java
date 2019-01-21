package arrayFeatures;

public class CreateTriangle {
	public static void main(String [] args) {
		int count = 0;
		for (int i=0; count< 10; i++)	{
			
			for (int k=i; k < Math.sqrt(10); k++){
				System.out.print(" ");
			}
		    for (int j =0; j< i*2 +1; j++){
		    	if (count >=10){
		    		break;
		    	}
		    	System.out.print("*");
		    	count += 1;
		    }
		    System.out.println("\n");
		}
	}
}
