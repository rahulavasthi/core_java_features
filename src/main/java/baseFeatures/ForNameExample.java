package baseFeatures;

public class ForNameExample {
	public static void main(String[] args) {
		try {
			Class c = Class.forName("baseFeatures.AccessKeywordTest");
			AccessKeywordTest obj = (AccessKeywordTest) c.newInstance();
			System.out.println(obj.toString());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
