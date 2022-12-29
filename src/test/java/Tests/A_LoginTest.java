package Tests;

import org.testng.annotations.Test;

import Base.BaseTest;

import org.testng.Assert;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegistrationPage;

public class A_LoginTest extends BaseTest{
	
	HomePage homePage;
	RegistrationPage regPage;
	LoginPage loginPage;
	
	@Test(priority = 0)
	public void verifyRegistration() {
		homePage = new HomePage(driver);
		regPage = new RegistrationPage(driver);
		
		homePage.goToRegistrationPage();
		regPage.registerAccount();
		if(regPage.isElementPresent(regPage.accountSuccessMessage))
			Assert.assertEquals(regPage.getElement(regPage.accountSuccessMessage).getText(), "Your Account Has Been Created!");
		else 
			Assert.assertEquals(regPage.getElement(regPage.emailRegisteredWarningMessage).getText(), "Warning: E-Mail Address is already registered!");
	}
	
	@Test (priority = 1)
	public void verifyLoginToApplication() {
		homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
		
		homePage.goToLoginPage();
		loginPage.doLogin();
		Assert.assertTrue(loginPage.isElementPresent(loginPage.logOutOption));
	}
}
