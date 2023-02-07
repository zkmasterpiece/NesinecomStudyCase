package zkmasterpiece.nesinecom;

import java.io.IOException;

import org.testng.annotations.Test;

import zkmasterpiece.pageobjects.LandingPage;
import zkmasterpiece.pageobjects.PopularBetsPage;
import zkmasterpiece.tests.BaseTest;

public class Main extends BaseTest {

	@Test
	public void smoketest() throws IOException, InterruptedException {

		
		
		LandingPage landingPage = launchApp();
		landingPage.goToLandingPage();
		landingPage.closePopUp();
		landingPage.isLoggedIn();
		PopularBetsPage popularBetsPage = landingPage.goToPopularBetsPage();
		popularBetsPage.isPopularBetsOpened();
		popularBetsPage.getDataAsJson();
		PostRequest rqs = new PostRequest();
		popularBetsPage.logout();

	}

}
