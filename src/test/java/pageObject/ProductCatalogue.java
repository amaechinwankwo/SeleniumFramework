package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import abstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {
	
	WebDriver driver; //local variable

	// constructor for initialization, for diver, first to run code
	public ProductCatalogue(WebDriver driver) {
		
		super(driver); // passing driver from child class to parent in another package (inheritance)
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this); // invoking the PageFactory FindBy
	}

	@FindBy(css = ".mb-3")
	List<WebElement> products;
	
	@FindBy(css = ".ng-animating")
	WebElement spinner;
	
	
	@FindBy(css = "[routerlink='/dashboard/cart']")
	WebElement cartHeader;
	
	By productsBy = By.cssSelector(".mb-3");
	
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	
	By toastMessage = By.id("toast-container");
	

	// method to grab all product list
	public List<WebElement> getProductList() 
	{
		waitForElementToAppear(productsBy);
		return products;
	}
	
	//method to get particular product by name
	public WebElement getProductName(String productName)
	{
		WebElement prod = getProductList().stream().filter(product ->
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	
	//method to add captured product to cart
	
	public void addProductToCart(String productName) throws InterruptedException
	{
		WebElement prod = getProductName(productName);
		
		prod.findElement(addToCart).click();
		
		waitForElementToAppear(toastMessage);
		
		waitForElementToDisappear(spinner);
		
	}
	
	
	public void CartPage()
	{
		cartHeader.click();
	}
	
	

}
