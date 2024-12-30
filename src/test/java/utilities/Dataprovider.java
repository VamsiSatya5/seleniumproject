package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class Dataprovider {
	 
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException{
		
		String path=".//testData/Test Data.xlsx";
		
		ExcelUtility excel=new ExcelUtility(path);
		
		int totalrows=excel.getRowCount("TestData");
		int totalcols=excel.getCellCount("TestData", 1);
		
		String logindata[][]=new String[totalrows][totalcols];
		
		for(int i=1;i<=totalrows;i++) {
			for(int j=0;j<totalcols;j++) {
				
				logindata[i-1][j]=excel.getCellData("path", i, j);
			}
		}
		
		return logindata;
				
		
		
	}

}
