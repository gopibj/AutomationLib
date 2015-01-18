/**
 * 
 */
package org.zapto.ajad.tests.code;

import java.io.IOException;

import junit.framework.Assert;

import org.testng.annotations.Test;
import org.zapto.ajad.tests.TestNgTestBase;
import org.zapto.ajad.utils.FileOps;
import org.zapto.ajad.utils.PropertyLoader;

/**
 * @author Ajad
 *
 */
public class FileOpsTest extends TestNgTestBase{
	
/*To test FileOpsad
 * 		1. To test ReadFile()
 * 		2. It reads a file  StrDataCsv from -> appproperties - > pom
 * 		3. Out puts ObjStringBuilder containing all the strings read line by line
 * 		4. So need to assert whether the read value is same as the input.
 * 
 */
	@Test(enabled=true)
	public void ReadFileTest() throws IOException{
		//Instantiate the FileOps obj
		FileOps ObjFileOps = new FileOps();
		
		//StringBuilder ObjStringBuilder = ObjFileOps.ReadFile("src/test/resources/datalogin.csv");
		StringBuilder ObjStringBuilder = ObjFileOps.ReadFile("datalogin.csv");
		System.out.println(ObjStringBuilder.toString());
	//	Assert.assertEquals("Ok", "TestString", ObjStringBuilder.toString());
		Assert.assertEquals("ok", ObjStringBuilder.toString());
		
		
		
		
	}
	
}
