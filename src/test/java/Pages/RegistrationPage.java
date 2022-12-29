package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Base.BasePage;

public class RegistrationPage extends BasePage{
	
	public RegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	//Registration form elements
	By firstNameField = By.id("input-firstname");
	By lastNameField = By.id("input-lastname");
	By emailField = By.id("input-email");
	By telephoneField = By.id("input-telephone");
	By passwordField = By.id("input-password");
	By confirmPasswordField = By.id("input-confirm");
	By privacyCheckBox = By.name("agree");
	By submitButton = By.xpath("//input[@value='Continue']");
	
	public By accountSuccessMessage = By.tagName("h1[text()='Your Account Has Been Created!']"); // Your Account Has Been Created!
	public By emailRegisteredWarningMessage = By.xpath("//div[@class='alert alert-danger alert-dismissible']");
	
	public void registerAccount() {
		getElement(firstNameField).sendKeys("Test");
		getElement(lastNameField).sendKeys("User");
		getElement(emailField).sendKeys("test@gmail.com");
		getElement(telephoneField).sendKeys("9999999999");
		getElement(passwordField).sendKeys("123456");
		getElement(confirmPasswordField).sendKeys("123456");
		getElement(privacyCheckBox).click();
		getElement(submitButton).click();
	}
}
