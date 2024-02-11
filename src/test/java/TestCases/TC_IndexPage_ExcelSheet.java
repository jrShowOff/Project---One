package TestCases;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.indexPage;
import PageObject.registrationPage;
import Utilities.ReadExcelFile;

public class TC_IndexPage_ExcelSheet extends BaseClass{
	@Test
	public void verifyLogin() {
		indexPage index = new indexPage(driver);
		index.email("xx@yy.com");
		index.clicktoenter();
		logger.info("Clicked on enter button");	
		Assert.assertTrue(true);

	}
	@Test (dataProvider = "d1")
	public void verifyRegistration(String firstname, String lastname) throws NoSuchElementException, InterruptedException, IOException {
		registrationPage rp = new registrationPage(driver);
		rp.enterFirstName(firstname);
		rp.enterLastName(lastname);
		logger.info("Clicked on Submit button");
		if(rp.errorCountry().equals("Please fill out this field123")) {
			Assert.assertTrue(true);
			logger.info("Error message is displayed correctly");
		}
		else {
			Assert.assertTrue(false);
			logger.info("Error message is not displayed correctly");
			captureScreenShot(driver, "VerifyRegistration");
		}

	}
	@DataProvider(name="d1")
	public String[][] LoginDataProvider()
	{
		//System.out.println(System.getProperty("user.dir"));
		String fileName = System.getProperty("C:\\Users\\vivek\\new workspace\\One\\TestData\\Book1.xlsx");


		int ttlRows = ReadExcelFile.getRowCount(fileName, "Sheet1");
		int ttlColumns = ReadExcelFile.getColCount(fileName, "Sheet1");
	

		String data[][]=new String[ttlRows-1][ttlColumns];

		for(int i=1;i<ttlRows;i++)//rows =1,2
		{
			for(int j=0;j<ttlColumns;j++)//col=0, 1,2
			{

				data[i-1][j]=ReadExcelFile.getCellValue(fileName,"Sheet1", i,j);
				System.out.println(data);
			}

		}
		return data;
		
	}
}

