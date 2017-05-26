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


public class CreateAccountTest {
	WebDriver driver;

	ExtentTest test;

	ExtentReports report;

	Home homePage;

	ContactUs contactUs;

	Order2quantititesOfItem order2;
	
	CreateAccount account;

	@BeforeTest 
	public void setup(){
		report = new ExtentReports (
				"C:\\Users\\Administrator\\Desktop\\Result\\CreateAccount.html",true);
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\Desktop\\Selenium\\chromedriver.exe");
	    
		driver = new ChromeDriver();
		
		driver.get("http://automationpractice.com");}
	
@Test
public void createAccountTest(){
	
homePage = new Home(driver);
	
	account = new CreateAccount(driver);
	
	//contactUs = new ContactUs(driver);
	
	test = report.startTest("Verify On home page");
	
	test.log(LogStatus.INFO,"Browser started");
	
	String homePagetitle = homePage.getTitle();
	
	if(homePagetitle.equals("My Store")){
		
	test.log(LogStatus.PASS, "Verify that you're on home page");
	}else {
		test.log(LogStatus.FAIL, "Verify that you're on home page");
	}
	
	
	account.clickSignIn();
	
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}
	
	String LoginPage = account.getTitle();
	
	if(LoginPage.equals("Login - My Store")){
		
		test.log(LogStatus.PASS, "Verify that you're the login page");
		}else {
			test.log(LogStatus.FAIL, "Didnt make it to login page");
		}
	
	
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}
	
	//Email you're going to use
	String email="1trying2@trying.com";
	
	account.email(email);

	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}
	
	
	account.signUp();
	
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}
	
	//account = new CreateAccount(driver);
	
	String firstName="Peter";
	
	String lastName = "Parker";
	
	account.firstAndLastName(firstName, lastName);
	
	report.endTest(test);
	report.flush();
}

}
