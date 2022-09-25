package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Base.TestBase;

public class ProductPage extends TestBase {

	@FindBy(xpath = "//*[@id=\"search\"]/span/div/h1/div/div[1]/div/div/span[3]")
	WebElement productName;
	@FindBy(xpath = "//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[3]/div/div/div/div/div/div/div[2]/div[1]/h2/a/span")
	WebElement productNameLink;
	@FindBy(xpath = "//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[3]/div/div/div/div/div/div/div[2]/div[1]/h2/a/span")
	WebElement productTitle;

	public ProductPage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyProductPageTitle() {
		return driver.getTitle();
	}

	public String verifyCorrectProductName() throws InterruptedException {
		// Thread.sleep(4000);
		System.out.println("name" + productName.getText());
		return productName.getText();
	}

	public String verifyCorrectProductTitle() {
		// Thread.sleep(4000);
		System.out.println(productTitle.getText());
		return productTitle.getText();
	}

	public void verifyAllProducts(String pName) {
		Select select = new Select(driver.findElement(By.className("a-size-base-plus a-color-base a-text-normal")));
		System.out.println(select.isMultiple());

		List<WebElement> product = select.getOptions();
		System.out.println(product.size());
		for (int i = 0; i <= product.size(); i++) {
			String productname = product.get(i).getText();
			System.out.println(product);
			// if(product.equals(pName))
			// {
			// product.get(i).click();
			// break;
			// }
		}

	}

	public ProductViewPage verifyclickonProductNameLink() throws InterruptedException {
		Thread.sleep(3000);
		productNameLink.click();
		return new ProductViewPage();
	}
}
