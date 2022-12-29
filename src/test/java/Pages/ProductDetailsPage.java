package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Base.BasePage;

public class ProductDetailsPage extends BasePage{

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	//Product details page locators
	By addToCartButton = By.id("button-cart");
	By quantityField = By.id("input-quantity");
	
	public By successAlert = By.xpath("//div[@class='alert alert-success alert-dismissible']");

	public void updateProductQuantity() {
		getElement(quantityField).clear();
		getElement(quantityField).sendKeys("2");
	}
	
	public void addProductToCart() {
		getElement(addToCartButton).click();
	}
	
}
