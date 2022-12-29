package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Base.BasePage;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	//Login form fields
	By emailField = By.id("input-email");
	By passwordField = By.id("input-password");
	By loginButton = By.xpath("//input[@value='Login']");
	
	public By logOutOption = By.linkText("Logout");
	
	public void doLogin() {
		getElement(emailField).sendKeys("test123123123123@gmail.com");
		getElement(passwordField).sendKeys("123456");
		getElement(loginButton).click();
	}
	
}
