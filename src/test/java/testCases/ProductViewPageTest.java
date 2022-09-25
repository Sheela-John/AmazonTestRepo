package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import pages.ProductViewPage;

public class ProductViewPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ProductPage productPage;
	ProductViewPage productViewPage;
	CartPage cartPage;

	public ProductViewPageTest() {
		super();
	}

	// test cases should be separated -- independent with each other
	// before each test case -- launch the browser and login
	// @test -- execute test case
	// after each test case -- close the browser

	@BeforeMethod
	public void setUp() throws InterruptedException {
		driver.get(
				"https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3F%26ext_vrnc%3Dhi%26tag%3Dgooghydrabk1-21%26ref%3Dnav_signin%26adgrpid%3D60612964962%26hvpone%3D%26hvptwo%3D%26hvadid%3D486452179346%26hvpos%3D%26hvnetw%3Dg%26hvrand%3D10556566517172113485%26hvqmt%3De%26hvdev%3Dc%26hvdvcmdl%3D%26hvlocint%3D%26hvlocphy%3D1007809%26hvtargid%3Dkwd-49491430%26hydadcr%3D14454_2154375%26gclid%3DEAIaIQobChMIrN7408ep-gIVwZJmAh0AWQzVEAAYASAAEgIF2fD_BwE&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		productPage = homePage.productSearch("All Categories", "pen");
		productViewPage = productPage.verifyclickonProductNameLink();
	}

	@Test
	public void productQuantityTest() throws InterruptedException {
		System.out.println("Pass");
		productViewPage.selectQuantity("2");
	}

	@Test
	public void addToCartTest() {

		// WebDriverWait wait1 = new WebDriverWait(driver, 15);
		// WebDriverWait wait = new WebDriverWait(driver, 15);
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"add-to-cart-button\"]")));
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"add-to-cart-button\"]")));
		cartPage = productViewPage.addToCart();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}