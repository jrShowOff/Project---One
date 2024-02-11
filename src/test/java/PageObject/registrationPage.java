package PageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class registrationPage extends indexPage {
	public registrationPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//input[@placeholder=\"First Name\"]")
	WebElement firstname;
	@FindBy(xpath = "//input[@placeholder=\"Last Name\"]")
	WebElement lastname;
	@FindBy(xpath="//textarea[@ng-model=\"Adress\"]")
	WebElement address;
	@FindBy(xpath="//input[@type=\"email\"]")
	WebElement email;
	@FindBy(xpath="//input[@type=\"tel\"]")
	WebElement phone;
	@FindBy(xpath="//input[contains(@value,'Male')]")
	WebElement male;
	@FindBy(xpath="//input[contains(@value,'FeMale')]")
	WebElement female;
	@FindBy(id="checkbox1")
	WebElement checkboxcricket;
	@FindBy(id="checkbox2")
	WebElement checkboxmovies;
	@FindBy(id="checkbox3")
	WebElement checkboxhockey;
	@FindBy(id="msdd")
	WebElement languages;
	@FindBy(xpath = "//li[@class=\"ng-scope\"][4]")
	WebElement lanlist;
	@FindBy(id="Skills")
	WebElement skills;
	@FindBy(id="countries")
	WebElement country;
	@FindBy(xpath="//html")
	WebElement blankspace;
	@FindBy(xpath="//span[@class=\"select2-selection select2-selection--single\"]")
	WebElement selectcountry;
	@FindBy(xpath = "//ul[@class=\"select2-results__options\"]//li[6]")
	WebElement Ind;
	@FindBy(id="yearbox")
	WebElement year;
	@FindBy(xpath="//select[@placeholder=\"Month\"]")
	WebElement month;
	@FindBy(id="daybox")
	WebElement day;
	WebElement pass = driver.findElement(By.id("firstpassword"));
	WebElement secondpass = driver.findElement(By.id("secondpassword"));
	@FindBy(id="submitbtn")
	WebElement submit;
	@FindBy(xpath="//div[@class=\"form-group\"][10]//div[@class=\"col-md-4 col-xs-4 col-sm-4\"]")
	WebElement countryerror;

	public void enterFirstName(String fname) {
		firstname.sendKeys(fname);
	}
	public void enterLastName(String lname) {
		lastname.sendKeys(lname);
	}
	public void enterAddress(String add) {
		address.sendKeys(add);
	}
	public void enterEmail(String emailid) {
		email.sendKeys(emailid);
	}
	public void enterPhone(int phoneno){
		phone.clear();
		phone.sendKeys(String.valueOf(phoneno));
	}
	public void clickMale() {
		male.click();
	}
	public void clickCricket() {
		checkboxcricket.click();
	}
	public void clickMoveies() {
		checkboxmovies.click();
	}
	public void selectLanguages() {
		languages.click();	
		lanlist.click();
	}
	public void selectSkills(String ski) {
		Select select = new Select(skills);
		select.selectByVisibleText(ski);
	}
	public void selectCountry(String count) {
		Select select = new Select(country);
		select.selectByVisibleText(count);
	}
	public void clickBlankSpace() {
		blankspace.click();
	}
	public void selectSelectCountry(String selectcount) {
		selectcountry.click();	
	}
	public void selectIndia() {
		Ind.click();
	}
	public void selectYear(String y) {
		Select select = new Select(year);
		select.selectByVisibleText(y);
	}
	public void selectMonth(int m) {
		Select select = new Select(month);
		select.selectByIndex(m);
	}
	public void selectDay(String d) {
		Select select = new Select(day);
		select.selectByVisibleText(d);
	}
	public void enterPass(String pa) {
		pass.sendKeys("Test@321");
	}	
	public void enterSecondPass(String secpa) {
		secondpass.sendKeys("Test@321");
	}
	public void clickSubmit() {
		submit.click();
	}
	public String errorCountry() {
		String error = countryerror.getText();
		return error;
	}

}
