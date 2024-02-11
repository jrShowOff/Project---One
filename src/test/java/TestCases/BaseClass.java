package TestCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import Utilities.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
ReadConfig readConfig = new ReadConfig();
String url = readConfig.getBaseUrl();
String browser = readConfig.getBrowser();
public static Logger logger;
//WebDrivers
public static WebDriver driver;
@BeforeClass
public void setup() {
	switch(browser){
	case "chrome":
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		break;
	case "edge":
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		break;
	case "mozilla":
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		break;
	default:
		driver = null;
		break;
	}
	//Waits
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	//Logging
	logger = LogManager.getLogger("One");
	//open url
	driver.get(url);
	logger.info("url successfully opened");	
}
@AfterClass
public void tearDown() {
	driver.close();
	driver.quit();
}
public void captureScreenShot(WebDriver driver,String testName) throws IOException
{
	//step1: convert webdriver object to TakesScreenshot interface
	TakesScreenshot screenshot = ((TakesScreenshot)driver);
	
	//step2: call getScreenshotAs method to create image file
	
	File src = screenshot.getScreenshotAs(OutputType.FILE);
	
	File dest = new File(System.getProperty("user.dir") + "Screenshots//" + testName + ".png");

	//step3: copy image file to destination
	FileUtils.copyFile(src, dest);

}
}
