package pageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumCartTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/client");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		/*
		 * Sign UP
		 * 
		 * driver.findElement(By.cssSelector(".btn1")).click();
		 * 
		 * driver.findElement(By.id("firstName")).sendKeys("Daniel");
		 * 
		 * driver.findElement(By.id("lastName")).sendKeys("Amaechi");
		 * 
		 * driver.findElement(By.id("userEmail")).sendKeys("greenmouseapp@gmail.com");
		 * 
		 * driver.findElement(By.id("userMobile")).sendKeys("7067676565");
		 * 
		 * //Static Selection
		 * 
		 * WebElement options =
		 * driver.findElement(By.cssSelector("select[formcontrolname='occupation']"));
		 * 
		 * Select myOption = new Select(options);
		 * 
		 * myOption.selectByIndex(3);
		 * 
		 * driver.findElement(By.cssSelector("input[value='Male']")).click();
		 * 
		 * driver.findElement(By.id("userPassword")).sendKeys("Dandytech@2022");
		 * 
		 * driver.findElement(By.id("confirmPassword")).sendKeys("Dandytech@2022");
		 * 
		 * driver.findElement(By.cssSelector("input[type='checkbox']")).click();
		 * 
		 * driver.findElement(By.id("login")).click();
		 * 
		 */
		// Login

		driver.findElement(By.id("userEmail")).sendKeys("greenmouseapp@gmail.com");

		driver.findElement(By.id("userPassword")).sendKeys("Dandytech@2022");

		driver.findElement(By.id("login")).click();

		// Explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".card-body")));

		List<WebElement> products = driver.findElements(By.className("card"));

		WebElement prod = products.stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst()
				.orElse(null);

		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("toast-container")));

		driver.findElement(By.cssSelector("button[routerlink='/dashboard/cart']")).click();

		List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));

		Boolean match = cartProducts.stream().anyMatch(cartProd -> cartProd.getText().equalsIgnoreCase("ZARA COAT 3"));

		// System.out.print(match);

		Assert.assertTrue(match);

		driver.findElement(By.cssSelector(".totalRow button")).click();

		WebElement opt = driver.findElement(By.cssSelector("select[class='input ddl"));

		Select option = new Select(opt);

		option.selectByIndex(4);
		
		//select option 

		WebElement opt2 = driver.findElement(By.cssSelector("select[class='input ddl']:last-of-type"));

		Select option2 = new Select(opt2);

		option2.selectByIndex(24);
		

		driver.findElement(By.cssSelector("div[class='field small'] input[class='input txt'] ")).sendKeys("123");

		driver.findElement(By.cssSelector("div[class='field'] input[class='input txt']")).sendKeys("Daniel Amaechi");
		
		//Suggest drop down
		Actions a = new Actions(driver);
		
		a.sendKeys(driver.findElement(By.cssSelector("input[placeholder='Select Country']")), "Nig").build().perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		
		driver.findElement(By.xpath("(//span[contains(@class, 'ng-star-inserted')])[2]")).click();
		
		driver.findElement(By.cssSelector("a[class='btnn action__submit ng-star-inserted']")).click();
		
		//confirm using Assert
		String confirm = driver.findElement(By.cssSelector(".hero-primary")).getText();
		
		Assert.assertTrue(confirm.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
		//driver.close();

	}
}
