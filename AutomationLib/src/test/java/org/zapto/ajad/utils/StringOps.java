package org.zapto.ajad.utils;

import org.zapto.ajad.common.CommonParams;

/*
 * The csv data read by File reader needs to be converted in to a 2d array 
 * so that it can be consumed by the TestNg tests through a data provider 
 * 
 *  So the csv data is split on the delimiter "," 
 *  
 */
public class StringOps extends CommonParams{
	
				/*
				 * This method with take in the csv data as a string and out put  a 2d array
				 */
				//The entire csv data string read from  the file
				private String StrCsvData;
				/**
				 * @return the strCsvData
				 */
				public String getStrCsvData() {
					return StrCsvData;
				}
				/**
				 * @param strCsvData the strCsvData to set
				 */
				public void setStrCsvData(String strCsvData) {
					StrCsvData = strCsvData;
				}
				
				//The delimiter to use for splitting the data
				private String StrCsvDelimiter;
				/**
				 * @return the strCsvDelimiter
				 */
				public String getStrCsvDelimiter() {
					return StrCsvDelimiter;
				}
				/**
				 * @param strCsvDelimiter the strCsvDelimiter to set
				 */
				public void setStrCsvDelimiter(String strCsvDelimiter) {
					StrCsvDelimiter = strCsvDelimiter;
				}
				//Length of the row in terms of number of fields
				private int RowCount;
				private int IntArr2dFieldCount;


			
				/**
				 * @return the intArr2dFieldCount
				 */
				public int getIntArr2dFieldCount() {
					return IntArr2dFieldCount;
				}
				/**
				 * @param intArr2dFieldCount the intArr2dFieldCount to set
				 */
				public void setIntArr2dFieldCount(int intArr2dFieldCount) {
					IntArr2dFieldCount = intArr2dFieldCount;
				}
				/**
				 * @return the rowCount
				 */
				public int getRowCount() {
					return RowCount;
				}
				/**
				 * @param rowCount the rowCount to set
				 */
				public void setRowCount(int rowCount) {
					RowCount = rowCount;
				}

				private String[] ArrStr;
				/**
				 * @return the arrStr
				 */
				public String[] getArrStr() {
					return ArrStr;
				}
				/**
				 * @param arrStr the arrStr to set
				 */
				public void setArrStr(String[] arrStr) {
					ArrStr = arrStr;
				}
							
				private String[][] Arr2dStr;
				/**
				 * @return the arr2dStr
				 */
				public String[][] getArr2dStr() {
					return Arr2dStr;
				}
				/**
				 * @param arr2dStr the arr2dStr to set
				 */
				public void setArr2dStr(String[][] arr2dStr) {
					Arr2dStr = arr2dStr;
				}
	
				private 	 String [][] ArrDataProvider;
				
				/**
				 * @return the arrDataProvider
				 */
				public String[][] getArrDataProvider() {
					return ArrDataProvider;
				}
				/**
				 * @param arrDataProvider the arrDataProvider to set
				 */
				public void setArrDataProvider(String[][] arrDataProvider) {
					ArrDataProvider = arrDataProvider;
				}
				private int IntArr2dRowCount;
				
				/**
				 * @return the intArr2dRowCount
				 */
				public int getIntArr2dRowCount() {
					return IntArr2dRowCount;
				}
				/**
				 * @param intArr2dRowCount the intArr2dRowCount to set
				 */
				public void setIntArr2dRowCount(int intArr2dRowCount) {
					IntArr2dRowCount = intArr2dRowCount;
				}
								
				public String[][] FormatCsvDataToArray (String ParStrCsvData, String ParStrDelimiter, int IntArr2dFieldCount) {
										
								this.setStrCsvData(ParStrCsvData);
								this.setStrCsvDelimiter(ParStrDelimiter);
								this.setIntArr2dFieldCount(IntArr2dFieldCount);																
								int IntArr1dRowCount ;

								if(ParStrCsvData != null){
											//Split the in put data to get the ArrStr Array
											  this.setArrStr(ParStrCsvData.split(this.getStrCsvDelimiter()));
											  
											 IntArr1dRowCount = ArrStr.length;
											 this.setIntArr2dRowCount(ArrStr.length / this.getIntArr2dFieldCount());
											 this.setArr2dStr(new String[this.getIntArr2dRowCount()][IntArr2dFieldCount]);				
											  											 
											 //Now to build the 2d Arr																
											  for(Integer i=0, k=0; i < IntArr1dRowCount; i++, k++){							  
											  			for(int j=0; j < IntArr2dFieldCount; j++,i++){
											  					//k remains constant after this till the loop ends
											  					Arr2dStr[k][j] = ArrStr[i];
											  					//[Debug]
											  					//	System.out.println(Arr2dStr[k][j].toString());												  		
															}		
											  			//To offset effects of k loop
											  			i=i-1;
											  	}
										}
/*								
		 *								[Debug]
										for(int x=0; x <Arr2dStr.length; x++){
											for(int y=0;y<this.getIntArr2dFieldCount(); y++){
												System.out.println(Arr2dStr[x][y]);
											 	//System.out.println(ArrDataProvider.toString());	
											}
										}
		 			*/
										return Arr2dStr;
					}

//[Debug]															
/*							public static void main(String[] args){
								
											String ParStrCsvData = "a,b,c,d,e,f";
											String ParStrDelimiter = ",";
											int IntArr2dFieldCount = 2;
											
											StringOps ObjStringOps = new StringOps();
											String[][] ArrCsvData = ObjStringOps.FormatCsvDataToArray(ParStrCsvData, ParStrDelimiter, IntArr2dFieldCount);
			
											for(int x=0; x <ArrCsvData.length; x++){
													for(int y=0;y<ArrCsvData[0].length; y++){
															System.out.println("ArrCsvData - " + " [ x ] - "+ x + " [ y ] - " + y + " - " + ArrCsvData[x][y]);
													}
											}								
								}*/
}
