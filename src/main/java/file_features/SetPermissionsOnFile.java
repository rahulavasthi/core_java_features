package file_features;

import java.io.File;

public class SetPermissionsOnFile {
	public static void main(String[] args) {
		File file = new File("D:\\temp.txt");

		if (file.exists()) {
			// Setting execute permission for owner only

			boolean result = file.setExecutable(true);

			System.out.println("Is execute permission for owner set successfully? " + result);
		} else {
			System.out.println("Sorry...File doesn't exist.");
		}

		if (file.exists()) {
			// Setting execute permission for all

			boolean result = file.setExecutable(true, false);

			System.out.println("Is execute permission for all set successfully? " + result);
		} else {
			System.out.println("Sorry...File doesn't exist.");
		}
	}
}
