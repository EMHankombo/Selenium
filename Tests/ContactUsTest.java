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

public class ContactUsTest {
	WebDriver driver;
	Home homePage;
	ContactUs contactUs;
	
	
	
	@Before 
	public void setup(){
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\Desktop\\Selenium\\chromedriver.exe");
	    
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com");
		
		
	}
	
	

//	@Test
//	public void testThatOnContactUsPage() {
//		homePage = new Home(driver);
//		String homePagetitle = homePage.getTitle();
//		assertEquals(homePage.getTitle(),"My Store");
//		//homePage.clickContactUsLink();
//		
//		contactUs = new ContactUs(driver);
//		String contactUsPageTitle=contactUs.getTitle();
//		contactUs.clickContactUsLink();
//		
//		
//		assertEquals(contactUs.getTitle(),"Contact us - My Store");
//	}
	
	
	@Test
	public void sendMessageToCustomerService(){
		homePage = new Home(driver);
		contactUs = new ContactUs(driver);
		
		String homePagetitle = homePage.getTitle();
		assertEquals(homePage.getTitle(),"My Store");
	
		String email = "happy1@happy.com";
		
		String message= "Are you guys hiring? Asking for a firend";
		
		contactUs.clickContactUsLink();
		
		contactUs.SelectService();
		
		contactUs.selectCustomerService();
		
		contactUs.YourEmailAddress(email);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		contactUs.yourMessage(message);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		contactUs.sendMessage();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		contactUs.successfulMessage();
		
		assertEquals(contactUs.successfulMessage(),true);
		
	}
	
	
	}


