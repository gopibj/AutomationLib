/**
 * 
 */
package org.zapto.ajad.tests;

import java.io.IOException;
import org.junit.Assert;
//import junit.framework.Assert;

import org.testng.annotations.Test;
import org.zapto.ajad.utils.FileOps;
import org.zapto.ajad.utils.StringOps;
/**
 * @author Ajad
 *
 */
public class CodeTest extends TestNgTestBase{
	
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
	
	@Test(enabled=true)
	public  void StringOpsExecuteTest() {
		
		String ParStrCsvData="a,b,c,d,e,f";
		String ParStrDelimiter = ",";
		int IntArr2dFieldCount = 2;
		String[][] Arr2dStrActual;
		String[][] Arr2dStrExpected={{"a","b"}, {"c","d"}, {"e","f"}};
		
		StringOps ObjStringOps = new StringOps();
		Arr2dStrActual =  ObjStringOps.FormatCsvDataToArray(ParStrCsvData, ParStrDelimiter, IntArr2dFieldCount);
		//Assert.assertEquals(Arr2dStrExpected, Arr2dStrActual);
		Assert.assertArrayEquals("ArrayCompareOk", Arr2dStrExpected, Arr2dStrActual);
		System.out.println("ArrayCompareOk");
				
/*		for(int i=0; i<Arr2dStr.length; i++){
			for(int j=0; j<Arr2dStr[0].length; i++){
				StrValidate += Arr2dStr[i][j];				
			}*/
		}
	
}
