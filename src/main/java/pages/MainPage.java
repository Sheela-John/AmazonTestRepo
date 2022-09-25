package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class MainPage extends TestBase {

	@FindBy(xpath = "//*[@id=\"nav-link-accountList\"]/span")
	WebElement account_List;
	@FindBy(xpath = "//*[@id=\"nav-flyout-ya-signin\"]/a/span")
	WebElement signin;

	// Initializing the Page Objects:
	public MainPage() {
		PageFactory.initElements(driver, this);
	}

	public LoginPage signin() {

		Actions action = new Actions(driver);
		action.moveToElement(signin).build().perform();
		// signin.click();
		// JavascriptExecutor js = (JavascriptExecutor)driver;
		// js.executeScript("arguments[0].click();", loginBtn);

		return new LoginPage();
	}
}
