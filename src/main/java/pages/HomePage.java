package pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Base.TestBase;

public class HomePage extends TestBase {

	@FindBy(id = "nav-link-accountList-nav-line-1")
	WebElement hello_signin;
	@FindBy(id = "searchDropdownBox")
	WebElement searchDropDown;
	@FindBy(id = "twotabsearchtextbox")
	WebElement searchText;
	@FindBy(id = "nav-search-submit-button")
	WebElement search_btn;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public String verifyCorrectUserName() throws InterruptedException {
		// Thread.sleep(4000);
		System.out.println("name" + hello_signin.getText());
		return hello_signin.getText();
	}

	public ProductPage productSearch(String sdropdown, String sText) throws InterruptedException {
		Thread.sleep(8000);
		searchText.clear();
		Select select = new Select(driver.findElement(By.name("url")));
		select.selectByVisibleText(sdropdown);

		searchText.sendKeys(sText);
		search_btn.click();
		return new ProductPage();

	}

	public void verifyAllProducts(String pName) throws InterruptedException {

		Thread.sleep(8000);

		List<WebElement> product = driver
				.findElements(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
		// System.out.println(product.size());
		for (int i = 0; i <= product.size(); i++) {
			String productname = product.get(i).getText();
			// System.out.println(productname);
			if (productname.equals(pName)) {
				product.get(i).click();
				break;
			}
		}

	}

	public void selectQuantity(String quan) throws InterruptedException {
		Thread.sleep(4000);
		// System.out.println(quantity.getText());
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		Select select = new Select(driver.findElement(By.id("quantity")));
		// System.out.println(select.getOptions());
		select.selectByVisibleText(quan);
	}

	public CartPage addToCart() {
		// System.out.println(price.getText());
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		driver.findElement(By.id("add-to-cart-button")).click();
		// add_cart_btn.click();
		// driver.navigate().to("https://www.amazon.in/");
		// driver.close();
		return new CartPage();
	}
}