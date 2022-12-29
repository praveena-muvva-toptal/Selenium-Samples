package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage{
	
	
	public WebDriver driver;
	
	@SuppressWarnings("deprecation")
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			 element = driver.findElement(locator);
			 return element;
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error occurred when finding the element" + locator.toString());
		}
		
		return element;
	}
	
	public void waitForElementPresent(By locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error occurred when waiting for an element" + locator.toString());
		}
	}
	
	public boolean isElementPresent(By locator) {
		return driver.findElements(locator).size() != 0;
	}
}
