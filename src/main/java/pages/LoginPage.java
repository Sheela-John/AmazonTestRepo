package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class LoginPage extends TestBase {
	@FindBy(name = "email")
	WebElement email;

	@FindBy(id = "continue")
	WebElement continue_btn;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(id = "signInSubmit")
	WebElement signin_btn;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public HomePage login(String em, String pwd) {

		email.sendKeys(em);
		continue_btn.click();
		password.sendKeys(pwd);
		signin_btn.click();
		// JavascriptExecutor js = (JavascriptExecutor)driver;
		// js.executeScript("arguments[0].click();", loginBtn);

		return new HomePage();
	}
}
