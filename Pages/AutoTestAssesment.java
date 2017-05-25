package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class AutoTestAssesment {
	
	static WebDriver driver;
	public static void main (String [] args){
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\Desktop\\Selenium\\chromedriver.exe");
        
		driver = new ChromeDriver();
		
		//Maximise window
//		ChromeOptions options = new ChromeOptions();
//				options.addArguments("--start-maximized");
//				driver = new ChromeDriver(options);
		
				driver.get("http://automationpractice.com");
		
		//sendEmail();
		 //orderPopularItem();
		//logInToPay();
				createAccount();	
				
	}
	
	
	
	public static void createAccount(){
		
		//email to use for your account
		String email= "trying2@trying.com";
		
		WebElement clickSignIn =driver.findElement(By.xpath("/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a"));
		
		clickSignIn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
			
		}
		
		WebElement emailToUse = driver.findElement(By.name("email_create"));
		
		WebElement confirm = driver.findElement(By.name("SubmitCreate"));
		
		emailToUse.sendKeys(email);
		
		confirm.click();

		
	}
	
	public static void orderPopularItem (){
		
		WebElement popularMenu = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/ul/li[1]/a"));
		
		popularMenu.click();
	
		
	WebElement addToCart= driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div[1]/ul[1]/li[1]/div/div[2]/div[2]/a[1]/span"));
	 addToCart.click();
	
	 //proceed to check out
	 try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	WebElement toCheckout =driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a"));
	toCheckout.click();
	 
	 try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	WebElement addQuantity =driver.findElement(By.className("icon-plus"));
	
	addQuantity.click();
	
	 try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	WebElement  proceedToPay=driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/p[2]/a[1]"));
		
	proceedToPay.click();
	 
	}
	
	
	public static void logInToPay (){
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String email= "trying@trying.com";
		String passwd ="aaaaa";
				
		
		WebElement userName = driver.findElement(By.name("email"));
		
		WebElement password = driver.findElement(By.name("passwd"));
		
		userName.sendKeys(email);
		password.sendKeys(passwd);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//WebElement  logIn=driver.findElement(By.xpath(""));
		WebElement logIn = driver.findElement(By.name("SubmitLogin"));
		logIn.click();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement confirmAdress = driver.findElement(By.name("processAddress"));
		confirmAdress.click();
		
		WebElement tickBox = driver.findElement(By.name("cgv"));
		tickBox.click();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement processCarrier = driver.findElement(By.name("processCarrier"));
		processCarrier.click();
		
		WebElement payment = driver.findElement(By.className("bankwire"));
		payment.click();
	
		WebElement confirmOrder = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/form/p/button"));
		confirmOrder.click();
		
	}
	
	
	public static void sendEmail (){
		
		String email = "iwantask@asking.com";
		
		String message="I want to know about your shipping charges";
		
		try{
		WebElement contactUs = driver.findElement(By.xpath("/html/body/div/div[3]/footer/div/section[3]/ul/li[5]/a"));
		
		contactUs.click();
		//WebElement contactUs = driver.findElement(By.linkText("Contact Us"));

		Thread.sleep(2000);
		WebElement subject= driver.findElement(By.name("id_contact"));
		
		subject.click();
		
		WebElement customerService =driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/form/fieldset/div[1]/div[1]/div[1]/div/select/option[2]"));
		customerService.click();
		
		
		WebElement yourEmail= driver.findElement(By.name("from"));
		yourEmail.sendKeys(email);
		
		WebElement EnterMessage= driver.findElement(By.name("message"));
		EnterMessage.sendKeys(message);
		Thread.sleep(3000);
		
		WebElement send= driver.findElement(By.name("submitMessage"));
		send.click();
		
		}catch (Exception e){
			e.printStackTrace();
		
		
		
		
	

}
	
}
}