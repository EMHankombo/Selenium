package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccount {
	WebDriver driver;
	
	public CreateAccount (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Click sign in button from home page
	@FindBy(xpath = "/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a")
	WebElement signIn;
	
	
	//email to use
	@FindBy(name ="email_create")
	WebElement emailToUse;
	
	//click sign up
	@FindBy( name = "SubmitCreate")
	WebElement createAccount;
	
	public String getTitle(){
		return driver.getTitle();
	} 
	
	public void clickSignIn(){
		signIn.click();
	}
	
	
	public void email (String email){
		emailToUse.sendKeys(email);
}
	
	
	public void signUp(){
		createAccount.click();
	}
	
	
	@FindBy(name = "customer_firstname")
	WebElement yourFirstName;
	
	@FindBy(name ="customer_lastname")
	WebElement yourLastName;
	
	
	public void firstAndLastName(String firstName,String lastName){
		
		yourFirstName.sendKeys(firstName);
		
		yourLastName.sendKeys(lastName);
		
		
	}
	
}





