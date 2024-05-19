package TestCases;
import java.io.IOException;
import java.util.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;
import PageObject.indexPage;
import PageObject.registrationPage;

public class TC_IndexPage extends BaseClass{
	@Test
	public static void verifyLogin() {
		indexPage index = new indexPage(driver);
		index.email("xx@yy.com");
		index.clicktoenter();
		logger.info("Clicked on enter button");
		Assert.assertTrue(true);

	}
	@Test
	public void verifyRegistration() throws NoSuchElementException, InterruptedException, IOException {
		registrationPage rp = new registrationPage(driver);
		rp.enterFirstName("Vivek");
		rp.enterLastName("Nair");
		rp.enterAddress("xyz");
		rp.enterEmail("xx@yy.com");
		rp.clickMale();
		rp.clickCricket();
		rp.clickMoveies();
		rp.enterPhone(1234567890);
		rp.selectLanguages();
		rp.clickBlankSpace();
		rp.selectCountry("Select Country");
		rp.selectSelectCountry("India");
		rp.selectIndia();
		rp.selectSkills("C");
		rp.selectYear("1999");
		rp.selectMonth(3);
		rp.selectDay("3");
		rp.enterPass("Test321");
		rp.enterSecondPass("Test321");
		rp.clickSubmit();
		logger.info("Clicked on Submit button");
		if(rp.errorCountry().equals("Please fill out this field123")) {
			Assert.assertTrue(false);
			logger.info("Error message is displayed correctly");
		}
		else {
			Assert.assertTrue(false);
			logger.info("Error message is not displayed correctly");
			captureScreenShot(driver, "VerifyRegistration");
		}

	}
}

