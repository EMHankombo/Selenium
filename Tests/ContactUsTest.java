package Tests;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeTest;
import Pages.*;

import static org.junit.Assert.*;



public class ContactUsTest {
	WebDriver driver;
	ExtentTest test;

	ExtentReports report;
	Home homePage;
	ContactUs contactUs;
	
	
	
	@BeforeTest
	public void setup(){
		report = new ExtentReports (
				"C:\\Users\\Administrator\\Desktop\\Result\\ContactUs.html",true);
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
		
		test = report.startTest("Verify On home page");
		
		test.log(LogStatus.INFO,"Browser started");
		
		String homePagetitle = homePage.getTitle();
		
		if(homePagetitle.equals("My Store")){
			
			test.log(LogStatus.PASS, "Verify that you're on home page");
			}else {
				test.log(LogStatus.FAIL, "Verify that you're on home page");
			}
		
		//assertEquals(homePage.getTitle(),"My Store");
	
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
		
		if(contactUs.successfulMessage()==true){
			test.log(LogStatus.PASS, "Check that email sent successfully");
		}else {
			test.log(LogStatus.FAIL, "Email was not sent successfully");
		}
		
		report.endTest(test);
		report.flush();
		
		}
		
	
		
	
	}
	
	
	


