package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import pages.ProductViewPage;

public class CartPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	ProductPage productPage;
	ProductViewPage productViewPage;
	CartPage cartPage;

	public CartPageTest() {
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
		cartPage = productViewPage.addToCart();
	}

	@Test
	public void productAddedSuccessMessage() {
		String Msg = cartPage.productAddedMessage();
		Assert.assertEquals(Msg, "Added to Cart");
	}

	@Test
	public void gotoCartTest() {
		String url = cartPage.gotoCart();
		Assert.assertEquals(url, "https://www.amazon.in/gp/cart/view.html?ref_=sw_gtc");

	}

	@Test
	public void viewCartTest() {
		String url = cartPage.gotoCart();
		Assert.assertEquals(url, "https://www.amazon.in/gp/cart/view.html?ref_=nav_cart");

	}

	/*
	 * @Test public void productTitleTest() { cartPage.viewCart(); String title =
	 * cartPage.producTitle(); productViewPage.addToCart(); String pTitle =
	 * productPage.verifyCorrectProductTitle(); Assert.assertEquals(title, pTitle);
	 * }
	 */

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
