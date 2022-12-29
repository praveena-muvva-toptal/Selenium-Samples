package Tests;

import org.testng.annotations.Test;

import Base.BaseTest;

import org.testng.Assert;

import Pages.HomePage;
import Pages.ProductDetailsPage;
import Pages.ProductsListPage;

public class B_ProductsTest extends BaseTest{
	
	HomePage homePage;
	ProductsListPage prodListPage;
	ProductDetailsPage prodDetailPage;
	
	@Test(priority = 0)
	public void verifyDirectGlobalSearch() {
		String product = "Mac";
		homePage = new HomePage(driver);
		prodListPage = new ProductsListPage(driver);
		
		homePage.enterItemInGlobalSearch(product);
		if(prodListPage.getProductsCount() > 0)
			Assert.assertTrue(prodListPage.getFirstProductName().contains(product));
		else
			Assert.assertTrue(prodListPage.isElementPresent(prodListPage.noProductsPresentMessage));
	}
	
	@Test (priority = 1)
	public void verifySearchCriteriaIncludingDescription() {
		String product = "Mac";
		homePage = new HomePage(driver);
		prodListPage = new ProductsListPage(driver);
		
		homePage.enterItemInGlobalSearch(product);
		prodListPage.selectSearchInProductDescription();
		if(prodListPage.getProductsCount() > 0)
			Assert.assertTrue(prodListPage.getFirstProductName().contains(product));
		else
			Assert.assertTrue(prodListPage.isElementPresent(prodListPage.noProductsPresentMessage));
	}
	
	@Test(priority = 2)
	public void verifySearchCriteriaInLaptopCategory() {
		String product = "Mac";
		homePage = new HomePage(driver);
		prodListPage = new ProductsListPage(driver);
		
		homePage.enterItemInGlobalSearch(product);
		prodListPage.selectSearchInLaptopsCategory();
		if(prodListPage.getProductsCount() > 0)
			Assert.assertTrue(prodListPage.getFirstProductName().contains(product));
		else
			Assert.assertTrue(prodListPage.isElementPresent(prodListPage.noProductsPresentMessage));
	}
	
	@Test (priority = 3)
	public void verifySearchCriteriaIncludingSubCategories() {
		String product = "Mac";
		homePage = new HomePage(driver);
		prodListPage = new ProductsListPage(driver);
		
		homePage.enterItemInGlobalSearch(product);
		prodListPage.selectSearchInLaptopsCategory();
		prodListPage.selectSearchInSubCategories();
		if(prodListPage.getProductsCount() > 0)
			Assert.assertTrue(prodListPage.getFirstProductName().contains(product));
		else
			Assert.assertTrue(prodListPage.isElementPresent(prodListPage.noProductsPresentMessage));
	}
	
	@Test (priority = 4)
	public void addDifferentProductsToCart() {
		String products[] = {"iMac", "MacBook Air"};
		homePage = new HomePage(driver);
		prodListPage = new ProductsListPage(driver);
		prodDetailPage = new ProductDetailsPage(driver);
		
		for(String product: products) {
			homePage.enterItemInGlobalSearch(product);
			prodListPage.selectAProductByName(product);
			//prodDetailPage.updateProductQuantity();
			prodDetailPage.addProductToCart();
			
			prodDetailPage.waitForElementPresent(prodDetailPage.successAlert);
			Assert.assertTrue(prodDetailPage.isElementPresent(prodDetailPage.successAlert));
		}
	}
}
