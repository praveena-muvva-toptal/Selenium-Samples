package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import Base.BasePage;

public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver) {
		super(driver);
	}

	//Locators
	By myAccountNavOption = By.xpath("//li/a[@title='My Account']");
	By registerLink = By.linkText("Register");
	By loginLink = By.linkText("Login");
	By shoppingCartLink = By.xpath("//li//span[text()='Shopping Cart']");
	By globalSearchBar = By.xpath("//div[@id='search']//input[@name='search']");
	By globalSearchButton = By.className("input-group-btn");
	
	public void goToRegistrationPage() {
		getElement(myAccountNavOption).click();
		getElement(registerLink).click();
	}
	
	public void goToLoginPage() {
		getElement(myAccountNavOption).click();
		getElement(loginLink).click();
	}
	
	public void enterItemInGlobalSearch(String product) {
		getElement(globalSearchBar).clear();
		getElement(globalSearchBar).sendKeys(product);
		getElement(globalSearchButton).click();
	}
	
	public void goToShoppingCart() {
		getElement(shoppingCartLink).click();
	}

}
