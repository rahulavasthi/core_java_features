package core.java.features;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import file_features.FindFilesOfDirectory;


public class Test_File_Test2 {
	@Before
	public void setup(){
		System.out.println("This is executed before each Test");
	}
	
	@After
	public void tearDown(){
		System.out.println("This is exceuted after each Test");
	}
	
	@Test
	public void testFile_Test2() throws Exception {
		List<File> returnfList = new ArrayList<File>();
		returnfList = (new FindFilesOfDirectory()).listf("D:/ResultFileTest", returnfList);
		
		assertEquals(8, returnfList.size());
	}
}
