package TestComponents;

import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.CartPage;
import pageObject.CheckOutPage;
import pageObject.LandingPage;
import pageObject.ProductCatalogue;

public class SubmitOrder extends BaseTest {

//	String productName = "ZARA COAT 3";
//
//	String thanks = "THANKYOU FOR THE ORDER.";

	@Test
	public void SubmitTest() throws InterruptedException {

		LandingPage landingPage = new LandingPage(driver);

		landingPage.GoTo();

		landingPage.LoginApp("greenmouseapp@gmail.com", "Dandytech@2022");

	}


//	public void submitOrder() throws InterruptedException {
//		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
//
//		List<WebElement> products = productCatalogue.getProductList();
//
//		productCatalogue.addProductToCart(productName);
//
//		productCatalogue.goToCartPage();
//
//	}
//
//		public void checkOut() {
//		CartPage cartPage = new CartPage(driver);
//
//		Boolean match = cartPage.verifyProductDisplay(productName);
//
//		Assert.assertTrue(match);
//
//		cartPage.goToCheckout();
//
//		// place order
//		CheckOutPage checkOutPage = new CheckOutPage(driver);
//
//		checkOutPage.selectCountry("Niger");
//
//		checkOutPage.submitOrder();
//
//		// Confirm Thank you
//		Boolean matchText = checkOutPage.textThanks(thanks);
//
//		Assert.assertTrue(matchText);
//
//	}

}
