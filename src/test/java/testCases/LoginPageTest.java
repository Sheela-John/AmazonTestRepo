package testCases;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import pages.HomePage;
import pages.LoginPage;
import pages.MainPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	MainPage mainPage = new MainPage();

	// MainPage mainPage=new MainPage();
	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		driver.get(
				"https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3F%26ext_vrnc%3Dhi%26tag%3Dgooghydrabk1-21%26ref%3Dnav_signin%26adgrpid%3D60612964962%26hvpone%3D%26hvptwo%3D%26hvadid%3D486452179346%26hvpos%3D%26hvnetw%3Dg%26hvrand%3D10556566517172113485%26hvqmt%3De%26hvdev%3Dc%26hvdvcmdl%3D%26hvlocint%3D%26hvlocphy%3D1007809%26hvtargid%3Dkwd-49491430%26hydadcr%3D14454_2154375%26gclid%3DEAIaIQobChMIrN7408ep-gIVwZJmAh0AWQzVEAAYASAAEgIF2fD_BwE&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
		loginPage = new LoginPage();

	}

	@Test
	public void loginTest() throws IOException {

		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));

	}

}
