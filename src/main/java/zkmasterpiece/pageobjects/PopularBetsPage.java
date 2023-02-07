package zkmasterpiece.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import zkmasterpiece.CommonMethods.CommonMethod;

public class PopularBetsPage extends CommonMethod {

	WebDriver driver;
	String url = "https://www.nesine.com/iddaa/populer-bahisler";
	List<String> getItems = new ArrayList<String>();
	List<String> totalList = new ArrayList<String>();
	String code, count;
	JSONObject dataOb = new JSONObject();

	public PopularBetsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".betHeader")
	WebElement betHeader;

	@FindBy(css = ".ni.ni-caret-down")
	WebElement hesabimHover;

	@FindBy(css = "[tracking-label='Header-GüvenliCikis']")
	WebElement cikisButton;

	@FindBy(css = "[bettypeid='1']")
	WebElement futbolTab;

	By header = By.cssSelector(".betHeader");
	By tab = By.cssSelector("[bettypeid='1']");
	By cikisbtn = By.cssSelector("[tracking-label='Header-GüvenliCikis']");

	public String getCurrentUrl() {
		System.out.println(driver.getCurrentUrl().toString());
		return driver.getCurrentUrl().toString();
	}

	public void clickToFutbolTab() {
		waitElementToAppear(tab);
		futbolTab.click();
	}

	public Boolean isPopularBetsOpened() {

		waitElementToAppear(header);
		if (url.equals(driver.getCurrentUrl().toString())) {
			return true;
		} else {
			return false;
		}

	}

	// Method to fetch PlayedCount and MarketNo from the PopularBets page.
	public JsonObject getDataAsJson() {
		JsonArray dataArray = new JsonArray();
		for (int i = 1; i <= 49; i++) {
			JsonObject data = new JsonObject();
			data.addProperty("PlayedCount",
					driver.findElement(
							By.xpath("//div[@class='betLine'][" + i + "]/descendant::div[@class='matchCode']"))
							.getText());
			data.addProperty("MarketNo",
					driver.findElement(
							By.xpath("//div[@class='betLine'][" + i + "]/descendant::div[@class='playedCount']"))
							.getText());

			dataArray.add(data);
		}

		JsonObject dataObject = new JsonObject();
		dataObject.add("PopularBetList", dataArray);
		System.out.println(dataObject.toString());
		return dataObject;
	}

	public void logout() throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(hesabimHover);
		//Wait for appearing of "Çıkış" button.
		waitSeconds(3);
		action.moveToElement(cikisButton).click().build().perform();

	}

	public void closeBrowser() {
		driver.close();
	}

}
