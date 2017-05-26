package Tests;
import org.openqa.selenium.WebDriver
;

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
			"C:\\Users\\Administrator\\Desktop\\Result\\Order2Quantitiesreport.html",true);
	
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\Desktop\\Selenium\\chromedriver.exe");
    
	driver = new ChromeDriver();
	
	driver.get("http://automationpractice.com");
	
	
	
}


@Test
public void order2ItemsTest(){
	
	homePage = new Home(driver);
	
	order2 = new Order2quantititesOfItem(driver);
	
	//contactUs = new ContactUs(driver);
	
	test = report.startTest("Verify On home page");
	
	test.log(LogStatus.INFO,"Browser started");
	
	String homePagetitle = homePage.getTitle();
	
	if(homePagetitle.equals("My Store")){
		
	test.log(LogStatus.PASS, "Verify that you're on home page");
	}else {
		test.log(LogStatus.FAIL, "Verify that you're on home page");
	}
	//assertEquals(homePage.getTitle(),"My Store");
	order2 = new Order2quantititesOfItem(driver);
	
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
	

//	
	order2.assertNumberIs2();
	
	if(order2.assertNumberIs2()==true){
		test.log(LogStatus.PASS, "Verify that unit price and total are different");
}else {
	test.log(LogStatus.FAIL, "Verify that unit price and total price are different");
}
	
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	order2.proceedToPayment();
	
	//login to pay
	String logIn=order2.getTitle();
	
	
	if(logIn.equals("Login - My Store")){
		test.log(LogStatus.PASS, "Made it to login or create account option");
	}else {
		test.log(LogStatus.FAIL, "Oooops something went wrong");
	}
	
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	//email and password to login
	String email= "trying@trying.com";
	String password ="aaaaa";
	
	order2.enterEmailAndPassword(email, password);
	
	//verify that you've signed in
	String orderPage=order2.getTitle();
	
	if(orderPage.equals("Order - My Store")){
		test.log(LogStatus.PASS, "Managed to login ");
	}else {
		test.log(LogStatus.FAIL, "Didnt manage to login");
	}
	
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	//confirm that the address is correct
	order2.confirmAddress();
	
	order2.tickBox();
	
	
	order2.processCarrier();
	
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	order2.payWithBankWire();
	
	order2.finalizeOrder();
	
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	String orderConfirmation=order2.getTitle();
	
	if(orderConfirmation.equals("Order confirmation - My Store")){
		test.log(LogStatus.PASS, "Order has gone through ");
	}else {
		test.log(LogStatus.FAIL, "Order didnt process");
		
	}
		
		
		
	report.endTest(test);
	report.flush();
	
}



}
