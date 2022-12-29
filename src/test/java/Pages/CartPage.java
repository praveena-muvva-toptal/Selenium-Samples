package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import Base.BasePage;

public class CartPage extends BasePage{

	public CartPage(WebDriver driver) {
		super(driver);
	}

	//Cart page locators
	By estimateShippingOption = By.linkText("Estimate Shipping & Taxes");
	By countryDropdown = By.id("input-country");
	By stateDropDown = By.id("input-zone");
	By postCodeField = By.name("postcode");
	By getQuoteButton = By.id("button-quote");
	By applyShippingButton = By.id("button-shipping");
	By checkoutButton = By.linkText("Checkout");
	
	public By shippingEstimationSuccessAlert = By.xpath("//div[text()=' Success: Your shipping estimate has been applied!']");
	public By noStockErrorMessage = By.xpath("//div[@class='alert alert-danger alert-dismissible']");
	
	public void estimateShippingCost() {
		getElement(estimateShippingOption).click();
		Select country = new Select(getElement(countryDropdown));
		country.selectByVisibleText("India");
		Select state = new Select(getElement(stateDropDown));
		state.selectByVisibleText("Andhra Pradesh");
		getElement(postCodeField).sendKeys("522009");
		getElement(getQuoteButton).click();
		getElement(applyShippingButton).click();
	}
	
	public void clickCheckOutButton() {
		getElement(checkoutButton).click();
	}
}
