package Tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import Pages.*;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;

import org.junit.Test;

public class Order2quantitiesOfItemTest {
WebDriver driver;
Home homePage;
ContactUs contactUs;
Order2quantititesOfItem order2;

@Before 
public void setup(){
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\Desktop\\Selenium\\chromedriver.exe");
    
	driver = new ChromeDriver();
	driver.get("http://automationpractice.com");
	
}


@Test
public void order2ItemsTest(){
	homePage = new Home(driver);
	order2 = new Order2quantititesOfItem(driver);
	contactUs = new ContactUs(driver);
	
	String homePagetitle = homePage.getTitle();
	assertEquals(homePage.getTitle(),"My Store");
	
	order2.clickOnPopular();
	
	order2.addItemToCart();
	
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	order2.proceedToCheckOut();
	
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	order2.increaseQuantity();
	
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
//	
	
//	order2.proceedToPayment();
//	
	order2.assertNumberIs2();
	
	assertEquals(order2.assertNumberIs2(),true);
	
}



}
