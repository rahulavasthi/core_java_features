package file_features;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindFilesOfDirectory { // find all the files from a given directory files might be in any of the sub directory
	public static void main(String args[])  
	{  
		List<File> returnfList = new ArrayList<File>();
		(new FindFilesOfDirectory()).listf("C:/App Home", returnfList);
		System.out.println(returnfList);
	}
	
	public List<File> listf(String directoryName, List<File> files) {
		
		File directory =  new File(directoryName);
		
		Arrays.stream(directory.list()).forEach(System.out::println);
		File [] fList = directory.listFiles();
		
		for (File file : fList){
			if (file.isFile()){
				
				System.out.println(file.getName());
				files.add(file);
			}else if (file.isDirectory()){
				listf(file.getAbsolutePath(), files);
			}
		}
		return files;
	}
	    
}
