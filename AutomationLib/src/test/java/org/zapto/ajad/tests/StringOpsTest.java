package org.zapto.ajad.tests;

import org.junit.Assert;
import org.testng.annotations.Test;
import org.zapto.ajad.tests.TestNgTestBase;
import org.zapto.ajad.utils.StringOps;



public class StringOpsTest extends TestNgTestBase{
	
	@Test(enabled=true)
	public  void StringOpsExecuteTest() {
		
		String ParStrCsvData="a,b,c,d,e,f";
		String ParStrDelimiter = ",";
		int IntArr2dFieldCount = 2;
		String[][] Arr2dStrActual;
		String[][] Arr2dStrExpected={{"a","b"}, {"c","d"}, {"e","f"}};
		
		StringOps ObjStringOps = new StringOps();
		Arr2dStrActual =  ObjStringOps.FormatCsvDataToArray(ParStrCsvData, ParStrDelimiter, IntArr2dFieldCount);
		Assert.assertArrayEquals(Arr2dStrExpected, Arr2dStrActual);
		
/*		for(int i=0; i<Arr2dStr.length; i++){
			for(int j=0; j<Arr2dStr[0].length; i++){
				StrValidate += Arr2dStr[i][j];				
			}*/
		}
		
	}

	

