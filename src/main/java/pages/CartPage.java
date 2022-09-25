package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class CartPage extends TestBase {

	@FindBy(xpath = "//*[@id=\"NATC_SMART_WAGON_CONF_MSG_SUCCESS\"]/span")
	WebElement success_msg;
	@FindBy(xpath = "//*[@id=\"sw-gtc\"]/span/a")
	WebElement gotoCart;
	@FindBy(id = "nav-cart")
	WebElement viewCart;
	@FindBy(xpath = "//*//*[@id=\"sc-item-C61e485ee-847b-4d1a-8f44-20de0d22a38c\"]/div[4]/div/div[1]/div/div/div[2]/ul/li[1]/span/a")
	WebElement productTitle;

	public CartPage() {
		PageFactory.initElements(driver, this);
	}

	public String productAddedMessage() {
		return success_msg.getText();
	}

	public String gotoCart() {
		gotoCart.click();
		return driver.getCurrentUrl();
		// return new CartPage();
	}

	public String viewCart() {
		viewCart.click();
		return driver.getCurrentUrl();
		// return new CartPage();
	}

	public String producTitle() {
		return productTitle.getText();
	}
}
