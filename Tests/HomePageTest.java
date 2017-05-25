package Tests;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import Pages.*;

public class HomePageTest {
WebDriver driver;

Home homePage;
	

@Before 
public void setup(){
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\Desktop\\Selenium\\chromedriver.exe");
    
	driver = new ChromeDriver();
	driver.get("http://automationpractice.com");
}
	
@Test
	public void testHomepage() {
	homePage = new Home(driver);
	String homePageTitle=homePage.getTitle();
		assertEquals(homePage.getTitle(),"My Store");
		
		
	}

}
