package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	
	
	@DataProvider(name = "Data")
	public String[][] getAllData() throws IOException {
		
		String path = System.getProperty("user.dir")+"//TestData//datasheet.xlsx";
		
		Utility util = new Utility(path);
		
		int rownum = util.getRowCount("data");
		int colcount = util.getCellCount("data", 1);
		
		String apidata[] [] = new String[rownum][colcount];
		
		for(int i=1; i<rownum ; i++ ) {
			 for(int j=0; j<colcount;j++) {
				
				apidata[i-1][j] = util.getCellData("data", i, j);
			 }
		}
		
		return apidata;
	}

	@DataProvider(name="UserNames")
	public String[] getUserName() throws IOException {
		
String path = System.getProperty("user.dir")+"//TestData//datasheet.xlsx";
		
		Utility util = new Utility(path);
		
		int rownum = util.getRowCount("data");
		
		String apidata[] = new String[rownum];
		for(int j=1; j<rownum;j++) {
			
			apidata[j-1] = util.getCellData("data", j, 1);
		 }
		
		return apidata;
		
		
	}
}
