package pageObject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import abstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent{ //extends is use to link parent class to child class for inheritance
	
	WebDriver driver; //local variable
	
	//constructor for initialization, for diver, first to run code
	public LandingPage (WebDriver driver){
		
		super(driver); //passing driver from child class to parent  in another package (inheritance)
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this); //invoking the PageFactory FindBy
	}
	
	//pageFactory for locators
	@FindBy(id = "userEmail")
	static
	WebElement userEmail;
	
	@FindBy(id = "userPassword")
	static
	WebElement password;
	
	@FindBy(id = "login")
	static
	WebElement submit;
	
	
	//Action method for login
	public ProductCatalogue LoginApp(String email, String pass)
	{
		userEmail.sendKeys(email);
		
		password.sendKeys(pass);
		
		submit.click();
		return null;
	}
	
	//Action method to load urlz
	public void GoTo()
	{

		driver.get("https://rahulshettyacademy.com/client");

	}
	

}
