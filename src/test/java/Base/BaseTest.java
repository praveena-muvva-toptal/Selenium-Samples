package Base;

import org.testng.annotations.AfterSuite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static WebDriver driver;
	public BasePage page;
	
	@BeforeSuite
	public void setupTest() {
		
		//Driver setup
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		//Navigate to base url
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();

		//Passing the driver object to the page
		page = new BasePage(driver);
	}
	
	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
	
}
