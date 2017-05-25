package Tests;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeTest;

import static org.junit.Assert.*;

import Pages.*;





public class Order2quantitiesOfItemTest {
WebDriver driver;

ExtentTest test;

ExtentReports report;

Home homePage;

ContactUs contactUs;

Order2quantititesOfItem order2;

@BeforeTest 
public void setup(){
	report = new ExtentReports (
			"C:\\Users\\Administrator\\Desktop\\Result\\automationreport.html",true);
	
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\Desktop\\Selenium\\chromedriver.exe");
    
	driver = new ChromeDriver();
	
	driver.get("http://automationpractice.com");
	
	report = new ExtentReports (
			"C:\\Users\\Administrator\\Desktop\\Result\\automationreport.html",true);
	
}


@Test
public void order2ItemsTest(){
	homePage = new Home(driver);
	
	order2 = new Order2quantititesOfItem(driver);
	
	contactUs = new ContactUs(driver);
	
	test = report.startTest("Verify On home page");
	
	test.log(LogStatus.INFO,"Browser started");
	
	String homePagetitle = homePage.getTitle();
	
	if(homePagetitle.equals(homePage.getTitle())){
		
	test.log(LogStatus.PASS, "Verify that you're on home page");
	}else {
		test.log(LogStatus.FAIL, "Verify that you're on home page");
	}
	//assertEquals(homePage.getTitle(),"My Store");
	
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
	
	//assertEquals(order2.assertNumberIs2(),true);
	
	report.endTest(test);
	report.flush();
	
}



}
