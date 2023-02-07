package zkmasterpiece.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import zkmasterpiece.CommonMethods.CommonMethod;

public class LandingPage extends CommonMethod {
	WebDriver driver;

	
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".e164f20e289791f4785d")
	WebElement popUpCloseBtn;
	
	@FindBy(css = "#txtUsername")
	WebElement userNameField;
	
	@FindBy(css = "#realpass")
	WebElement passwordField;
	
	@FindBy(css = ".btn[tracking-label='Header-Giris']")
	WebElement submitButton;
	
	@FindBy(css = "#spnMemberId")
	WebElement loginMemberId;
	
	@FindBy(css = ".popular-bets")
	WebElement popularBetsButton;
	
	
	
	
	By closeBtn = By.cssSelector(".e164f20e289791f4785d");
	By memberId = By.cssSelector("#spnMemberId");
	
	public void goToLandingPage() {
		driver.get("https://www.nesine.com");
	}
	
	public void closePopUp() {
		waitElementToAppear(closeBtn);
		popUpCloseBtn.click();
	}
	
	public void loginTo(String userName, String password) {
		userNameField.sendKeys(userName);
		passwordField.sendKeys(password);
		submitButton.click();
	}
	
	public Boolean isLoggedIn() {
		waitElementToAppear(memberId);
		System.out.println(loginMemberId.isDisplayed());
		return loginMemberId.isDisplayed();
	}
	
	
	public PopularBetsPage goToPopularBetsPage() {
		popularBetsButton.click();
		return new PopularBetsPage(driver);
	}
	

}
