package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent{
	
	WebDriver driver; //local variable

	// constructor for initialization, for diver, first to run code
	public CartPage (WebDriver driver) {
		
		super(driver); // passing driver from child class to parent in another package (inheritance)
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this); // invoking the PageFactory FindBy
	}
	
	@FindBy(css = ".totalRow button")
	WebElement checkoutEle;
	
	@FindBy(css = ".cartSection h3")
	private List<WebElement> cartProducts;
	
	public Boolean verifyProductDisplay(String productName)
	{
		Boolean match = cartProducts.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	
	public CartPage goToCheckout()
	{
		checkoutEle.click();
		return null;
	}


	public void selectCountry(String string) {
		// TODO Auto-generated method stub
		
	}
	
	
}
