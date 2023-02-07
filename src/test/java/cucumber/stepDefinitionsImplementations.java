package cucumber;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.restassured.internal.common.assertion.Assertion;
import zkmasterpiece.nesinecom.PostRequest;
import zkmasterpiece.pageobjects.LandingPage;
import zkmasterpiece.pageobjects.PopularBetsPage;
import zkmasterpiece.tests.BaseTest;

public class stepDefinitionsImplementations extends BaseTest {
	public LandingPage landingPage;
	public PopularBetsPage popularBetsPage;
	BaseTest bt;

	String username;

	@Given("Nesine.com adresine giriş yapılır.")
	public void Nesine_com_adresine_giris_yapilir() throws IOException {
		landingPage = launchApp();
		landingPage.goToLandingPage();
		landingPage.closePopUp();

	}

	@Given("Kullanıcı adı ve şifre girilir.")
	public void Kullanici_adi_ve_şifre_girilir() throws IOException {

		landingPage.loginTo(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(landingPage.isLoggedIn());
	}

	@Given("Populer Bahisler butonuna tıklanır ve sayfa linki kontrol edilir.")
	public void Populer_Bahisler_butonuna_tiklanir_ve_sayfa_linki_kontrol_edilir() {
		popularBetsPage = landingPage.goToPopularBetsPage();
		Assert.assertTrue(popularBetsPage.isPopularBetsOpened());

	}

	@Given("Futbol Tabı seçilir.")
	public void Futbol_Tabi_secilir() {
		popularBetsPage.clickToFutbolTab();
	}

	@Given("GetPopularBets servisi tetiklenerek, sayfada bulunan tüm etkinlikler için Kod ve Oynanma sayılarının doğruluğu kontrol edilir.")
	public void GetPopularBets_servisi_tetiklenerek_sayfada_bulunan_tum_etkinlikler_icin_Kod_ve_Oynanma_sayilarinin_dogrulugu_kontrol_edilir() {

		PostRequest postRequest = new PostRequest();
		postRequest.request(popularBetsPage.getDataAsJson());
	}

	@Given("Hesabım butonuna tıklanır ve Çıkış işlemi gerçekleştirilir.")
	public void Hesabim_butonuna_tiklanir_ve_Cikis_islemi_gerceklestirilir() throws InterruptedException {
		popularBetsPage.logout();
	}

	@Given("Browser Kapatılır.")
	public void Browser_Kapatilir() {
		popularBetsPage.closeBrowser();
	}

}
