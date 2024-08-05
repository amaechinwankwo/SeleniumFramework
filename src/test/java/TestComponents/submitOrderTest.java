package TestComponents;

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
import pageObject.CartPage;
import pageObject.CheckOutPage;
import pageObject.LandingPage;
import pageObject.ProductCatalogue;

public class submitOrderTest extends BaseTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String productName = "ZARA COAT 3";

		String thanks = "THANKYOU FOR THE ORDER.";

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		LandingPage landingPage = new LandingPage(driver);

		landingPage.GoTo();

		landingPage.LoginApp("greenmouseapp@gmail.com", "Dandytech@2022");

		ProductCatalogue productCatalogue = new ProductCatalogue(driver);

		List<WebElement> products = productCatalogue.getProductList();

		productCatalogue.addProductToCart(productName);

		productCatalogue.goToCartPage();

		CartPage cartPage = new CartPage(driver);

		Boolean match = cartPage.verifyProductDisplay(productName);

		Assert.assertTrue(match);

		cartPage.goToCheckout();

		// place order
		CheckOutPage checkOutPage = new CheckOutPage(driver);

		checkOutPage.selectCountry("Niger");

		checkOutPage.submitOrder();

		// Confirm Thank you
		Boolean matchText = checkOutPage.textThanks(thanks);

		Assert.assertTrue(matchText);

		driver.close();
	}
}
