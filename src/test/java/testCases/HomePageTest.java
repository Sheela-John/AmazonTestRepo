package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.TestBase;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	CartPage cartPage;
	String sheetName = "Product";

	public HomePageTest() {
		super();

	}

	// test cases should be separated -- independent with each other
	// before each test case -- launch the browser and login
	// @test -- execute test case
	// after each test case -- close the browser

	// @BeforeMethod
	// public void setUp() {
	// driver.get(
	/// "https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3F%26ext_vrnc%3Dhi%26tag%3Dgooghydrabk1-21%26ref%3Dnav_signin%26adgrpid%3D60612964962%26hvpone%3D%26hvptwo%3D%26hvadid%3D486452179346%26hvpos%3D%26hvnetw%3Dg%26hvrand%3D10556566517172113485%26hvqmt%3De%26hvdev%3Dc%26hvdvcmdl%3D%26hvlocint%3D%26hvlocphy%3D1007809%26hvtargid%3Dkwd-49491430%26hydadcr%3D14454_2154375%26gclid%3DEAIaIQobChMIrN7408ep-gIVwZJmAh0AWQzVEAAYASAAEgIF2fD_BwE&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
	// loginPage = new LoginPage();
	// homePage = loginPage.login(prop.getProperty("email"),
	// prop.getProperty("password"));
	// }

	@Test(priority = 1)
	public void verifyHomePageTitleTest() throws IOException, InterruptedException {

		Thread.sleep(5000);
		String homePageTitle = homePage.verifyHomePageTitle();
		System.out.println("title" + homePageTitle);

		String exp_Title = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		boolean val = false;
		if (homePageTitle.equalsIgnoreCase(exp_Title)) {
			val = true;
			// test.log(LogStatus.PASS, test.addScreenCapture(TestUtil.capture(driver)) +
			// "Test Passed");
		} else {
			// test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.capture(driver)) +
			// "Test Failed");
		}
		Assert.assertTrue(val);
	}

	@Test(priority = 2)
	public void verifyUserNameTest() throws InterruptedException, IOException {

		// testUtil.switchToFrame();
		String name = homePage.verifyCorrectUserName();
		String t_name = "Hello, Sheela";
		boolean val = false;
		if (name.equalsIgnoreCase(t_name)) {
			val = true;
			// test.log(LogStatus.PASS, test.addScreenCapture(TestUtil.capture(driver)) +
			// "Test Passed");
		} else {
			val = false;
			// test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.capture(driver)) +
			// "Test Failed");
		}
		Assert.assertTrue(val);

	}

	@DataProvider
	public Object[][] getAmazonTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority = 3, dataProvider = "getAmazonTestData")
	public void verifySearchProduct(String search, String product, String pName) throws InterruptedException {
		homePage = new HomePage();
		homePage.productSearch(search, product);
		homePage.verifyAllProducts(pName);
		Thread.sleep(5000);
		homePage.selectQuantity("2");
		Thread.sleep(5000);
		cartPage = homePage.addToCart();
	}

	public void productQuantityTest() throws InterruptedException {
		System.out.println("Pass");
		homePage.selectQuantity("2");
	}

	@Test
	public void addToCartTest() {

		// WebDriverWait wait1 = new WebDriverWait(driver, 15);
		// WebDriverWait wait = new WebDriverWait(driver, 15);
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"add-to-cart-button\"]")));
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"add-to-cart-button\"]")));
		cartPage = homePage.addToCart();
	}
}
