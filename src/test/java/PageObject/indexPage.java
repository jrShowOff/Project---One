package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class indexPage {
	// Creating webdriver object
	WebDriver driver;

	public indexPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		driver.manage().window().fullscreen();
	}

	// Identifing Webelements
	@FindBy(id = "email")
	WebElement enteremail;

	@FindBy(id = "enterimg")
	WebElement enterbutton;

	//Actions on WebElements
	public void email(String emailid){
		enteremail.sendKeys(emailid);
	}
	public void clicktoenter(){
		enterbutton.click();
	}
}
