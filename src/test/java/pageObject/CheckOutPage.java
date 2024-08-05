package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponent;


public class CheckOutPage extends AbstractComponent {
	
	WebDriver driver; //local variable

	// constructor for initialization, for diver, first to run code
	public CheckOutPage (WebDriver driver) {
		
		super(driver); // passing driver from child class to parent in another package (inheritance)
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this); // invoking the PageFactory FindBy
	}


	@FindBy(css="a[class='btnn action__submit ng-star-inserted']")
	WebElement submit;
	
	@FindBy(css = "input[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(css = ".hero-primary")
	private List<WebElement> confirm;
	
	
	@FindBy(xpath = "(//span[contains(@class, 'ng-star-inserted')])[2]")
	WebElement selectCountry;
	
	//By thank = By.cssSelector(".hero-primary");
	
	//Action method
	public void selectCountry(String countryName)
	{
		Actions a = new Actions(driver);
		
		a.sendKeys(country, countryName).build().perform();
		
		selectCountry.click();
	}
	
	
	public void submitOrder()
	{
		submit.click();
	}
	
	public Boolean textThanks(String thanks)
	{
		Boolean matchThanks = confirm.stream().anyMatch(product -> product.getText().equalsIgnoreCase(thanks));
		
		return matchThanks;
	}
	
	
	
}

	
	