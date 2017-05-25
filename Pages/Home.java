package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
	WebDriver driver;
	
	@FindBy(className = "title")
	WebElement title;
	
	@FindBy(xpath = "/html/body/div/div[3]/footer/div/section[3]/ul/li[5]/a")
	WebElement contactUsLink;
	
	public String getTitle(){
		return driver.getTitle();
	}
	
	
	public Home(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}


	public void clickContactUsLink() {
		// TODO Auto-generated method stub
		contactUsLink.click();
	}
	
	
	

}
