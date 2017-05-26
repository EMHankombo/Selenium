package Pages;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Order2quantititesOfItem {
	WebDriver driver;
	
	
	public Order2quantititesOfItem (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Click on the popular clothes
	@FindBy(xpath = "/html/body/div/div[2]/div/div[2]/div/ul/li[1]/a")
	WebElement popular;
	
	//add the items to cart
	@FindBy(xpath = "/html/body/div/div[2]/div/div[2]/div/div[1]/ul[1]/li[1]/div/div[2]/div[2]/a[1]/span")
	WebElement addItem;
	
	//proceed to checkout
	
	@FindBy(xpath = "/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a")
	WebElement proceedToCheckOut;
	
	//increase the quantity by one
	@FindBy(className = "icon-plus")
	WebElement addQuantity;
	
	//Proceed to the payment
	@FindBy(xpath= "/html/body/div/div[2]/div/div[3]/div/p[2]/a[1]")
	WebElement goToPaymentScreen;
	
	//check that the number of items is two
	@FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr/td[5]/input[2]")
	WebElement checkThatItsTwo;
	
	//your login in email
	@FindBy(name = "email")
	WebElement yourEmail;
		
		
	//your password
	@FindBy(name= "passwd")
	WebElement yourPassword;
		
	//sign in
	@FindBy(name = "SubmitLogin")
	WebElement logIn;
		

	//proceed with the order,my address is correct
	@FindBy(name = "processAddress")
	WebElement confirmAddress;
		
	//Agree to terms of service
	@FindBy(name = "cgv")
	  WebElement tickBox;
	
	//Agree with the delivery charge and proceed
	@FindBy(name = "processCarrier")
	WebElement processCarrier;

	//choose to pay by bankwire
	@FindBy(className ="bankwire")
	WebElement payBycard;
	
	//confirm my order
	@FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/form/p/button")
	WebElement confirmMyOrder;
	
	public String getTitle(){
		return driver.getTitle();
	}
	
	
	public void clickOnPopular(){
		popular.click();
	}
	
	public void addItemToCart (){
		addItem.click();
		
	}
	
	public void proceedToCheckOut(){
		proceedToCheckOut.click();
	}

	
	public void increaseQuantity(){
		addQuantity.click();
	}
	
	public void proceedToPayment(){
		goToPaymentScreen.click();
	}
	
	public boolean assertNumberIs2(){
		boolean result;
		//check that the total price and unit price are not the same
		if(!driver.findElement(By.className("price")).getText().equals("$16.51")){
			result= true;
			}else result = false;
		
		return result;
	}
	
	
	
	public void enterEmailAndPassword(String email,String password){
		yourEmail.sendKeys(email);
		
		yourPassword.sendKeys(password);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		logIn.click();
		
		}
	
	
public void confirmAddress(){
	
	confirmAddress.click();
}
	

public void tickBox(){
	tickBox.click();
}



public void processCarrier(){
	processCarrier.click();
}


public void payWithBankWire(){
	payBycard.click();
}



public void finalizeOrder(){
	confirmMyOrder.click();
}


}
