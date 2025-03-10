package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name="Data")
	public String [][] getAllData() throws IOException{
		String path = System.getProperty("user.dir")+".//testData//UserData.xlsx";
		XLUtility xl=new XLUtility(path);
		int rownum=xl.getRowCount("sheet1");
		int colcount=xl.getCellCount("sheet1",1);
		String apidata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++) {
			for(int j=0;j<colcount;j++) {
				apidata[i-1][j]=xl.getCellData("sheet1", i, j);
			}
		}
		
		return apidata;
	}
	
	
	@DataProvider(name="UserNames")
	public String[] getUserNames() throws IOException {
		String path = System.getProperty("user.dir")+".//testData//UserData.xlsx";
		XLUtility xl=new XLUtility(path);
		int rownum=xl.getRowCount("sheet1");
		String apidata[]=new String[rownum];
		
		for(int i=1;i<=rownum;i++) {
			apidata[i-1]=xl.getCellData("sheet1", i, 1);
		}
		
		return apidata;
	}
	
	@DataProvider(name="PetData")
	public String [][] getAllPetData() throws IOException{
		String path = System.getProperty("user.dir")+".//testData//UserData.xlsx";
		XLUtility xl=new XLUtility(path);
		int rownum=xl.getRowCount("sheet2");
		int colcount=xl.getCellCount("sheet2",1);
		String apidata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++) {
			for(int j=0;j<colcount;j++) {
				apidata[i-1][j]=xl.getCellData("sheet2", i, j);
			}
		}
		
		return apidata;
	}
	
	
	@DataProvider(name="Pet_id")
	public String[] getPetid() throws IOException {
		String path = System.getProperty("user.dir")+".//testData//UserData.xlsx";
		XLUtility xl=new XLUtility(path);
		int rownum=xl.getRowCount("sheet2");
		String apidata[]=new String[rownum];
		
		for(int i=1;i<=rownum;i++) {
			apidata[i-1]=xl.getCellData("sheet2", i, 0);
		}
		
		return apidata;
	}
	
}
