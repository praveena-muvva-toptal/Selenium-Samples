package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import Base.BasePage;

public class ProductsListPage extends BasePage{
	
	public ProductsListPage(WebDriver driver) {
		super(driver);
	}
	
	//Search Criteria elements
	By serachCriteriaSearchBar = By.id("input-search");
	By subCategorySearchCheckbox = By.name("sub_category");
	By searchInDescriptionCheckbox = By.name("description");
	By searchButton = By.id("button-search");
	By categoryDropdown = By.name("category_id");
	
	//List Elements
	By productItem = By.className("product-thumb");
	By productImage = By.xpath("//div[@class='product-thumb'/div[@class='image']]");
	By productName = By.xpath("//h4/a");
	By productSearchDiv = By.xpath("//h2[text()='Products meeting the search criteria']");
	public By noProductsPresentMessage = By.xpath("//p[text()='There is no product that matches the search criteria.']");
	
	public void selectSearchInProductDescription() {
		waitForElementPresent(productSearchDiv);
		getElement(searchInDescriptionCheckbox).click();
	}
	
	public void selectSearchInLaptopsCategory() {
		waitForElementPresent(productSearchDiv);
		waitForElementPresent(categoryDropdown);
		Select searchCriteriaDropDown = new Select(getElement(categoryDropdown));
		searchCriteriaDropDown.selectByVisibleText("Laptops & Notebooks");
	}
	
	public void selectSearchInSubCategories() {
		waitForElementPresent(productSearchDiv);
		getElement(subCategorySearchCheckbox).click();
	}
	
	public void clickSearchButton() {
		waitForElementPresent(productSearchDiv);
		getElement(searchButton).click();
	}
	
	public int getProductsCount() {
		waitForElementPresent(productSearchDiv);
		return driver.findElements(productItem).size();
	}
	
	public String getFirstProductName() {
		waitForElementPresent(productSearchDiv);
		return getElement(productName).getText();
	}
	
	public void selectAProductByName(String name) {
		waitForElementPresent(productSearchDiv);
		driver.findElement(By.linkText(name)).click();
	}
}
