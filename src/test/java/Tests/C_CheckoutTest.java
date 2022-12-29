package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.CartPage;
import Pages.HomePage;

public class C_CheckoutTest extends BaseTest{
	
	HomePage homePage;
	CartPage cartPage;
	
	@Test (priority = 1)
	public void verifyCheckout() {
		homePage = new HomePage(driver);
		cartPage = new CartPage(driver);
		
		homePage.goToShoppingCart();
		cartPage.clickCheckOutButton();
		Assert.assertTrue(cartPage.isElementPresent(cartPage.noStockErrorMessage));
	}
}
