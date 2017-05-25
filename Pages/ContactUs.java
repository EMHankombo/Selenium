package Pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUs {
	WebDriver driver;
	
	//Contact us link
	@FindBy(xpath = "/html/body/div/div[3]/footer/div/section[3]/ul/li[5]/a")
	WebElement contactUsLink;
	
	//Make sure the contact Us page has loaded
	@FindBy(className = "title")
	WebElement contactUsTitle;
	
	
	
	//drop down menu for selecting the service
	@FindBy(name = "id_contact")
	WebElement service;
	
	//select customer service
	@FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/form/fieldset/div[1]/div[1]/div[1]/div/select/option[2]")
	WebElement selectCustomerService;
	
	
	//Your email address so they can reply to you
	@FindBy(name = "from")
	WebElement yourEmailAddress;
	
	//The message you want to write
	@FindBy(name = "message")
	WebElement yourMessage;
	
	@FindBy(name = "submitMessage")
	WebElement sendMessage;
	
	@FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/p" )
	WebElement successfulMessage;
	
	public ContactUs(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getTitle(){
		return driver.getTitle();
	}
	
	public void clickContactUsLink(){
		contactUsLink.click();
		
	}
	//Select customer Serivce
	public void SelectService(){
		service.click();
		
		}

	public void selectCustomerService(){
		selectCustomerService.click();
	}
		
		public void YourEmailAddress(String email){
			yourEmailAddress.sendKeys(email);
			
		}
		
		public void yourMessage (String message){
			yourMessage.sendKeys(message);
		}
		
		public void sendMessage (){
			sendMessage.click();
		}
		
		public boolean successfulMessage(){
			boolean result;
			
				if(driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/p")).isDisplayed()){
				result = true;
				} else result = false;
				
				return result;
			
		}
	}

