package pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Base.TestBase;

public class ProductViewPage extends TestBase {

	@FindBy(id = "add-to-cart-button")
	WebElement add_cart_btn;
	@FindBy(xpath = "//*[@id=\"corePrice_feature_div\"]/div/span/span[2]/span[2]")
	WebElement price;

	public ProductViewPage() {
		PageFactory.initElements(driver, this);
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
		System.out.println(select.getOptions());
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

		return new CartPage();
	}
}
