package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import utils.ConfigReader;

public class ProductPage {

	private WebDriver driver;
	private ConfigReader config;

	public ProductPage(WebDriver driver, ConfigReader config) {
		this.driver = driver;
		this.config = config;
	}
	By products = By.className("inventory_item");
	By productName = By.className("inventory_item_name");
	By cartLink   = By.className("shopping_cart_link");
	By cartcheckout = By.id("checkout");
	By firstname  = By.id("first-name");
	By lastname   = By.id("last-name");
	By postalcode = By.id("postal-code");
	By submituserinfo = By.id("continue");
	By finishorder = By.id("finish");
	
	public void addProductToCart(String expectedProduct) {

		List<WebElement> allProducts = driver.findElements(products);

		for (WebElement product : allProducts) {
			String actualProduct = product.findElement(productName).getText();
			if (actualProduct.trim().equalsIgnoreCase(config.getProperty("expectedProduct").trim())) {
				product.findElement(By.tagName("button")).click();
			break;
			}
		}
	}
	//open cart
	public void openCart() {

		// Click cart icon
		driver.findElement(cartLink).click();
	}
	
	public boolean isProductinCart(String expectedProduct) {
		// Get all cart items
		List<WebElement> items = driver.findElements(productName);

		// Verify expected product exists in cart
		for (WebElement item : items) {
			String actualProduct = item.getText().trim();
			if (actualProduct.trim().equalsIgnoreCase(config.getProperty("expectedProduct").trim())) {
				return true;
			}
		}
				return false;
	}
             public void clickCheckout()
             {
            	 driver.findElement(cartcheckout).click();
             }
             
             public void fillCheckoutInfo(String fname, String lname, String zip)
             {
			String currentUrl = driver.getCurrentUrl();
			String checkoutLink = config.getProperty("checkoutURL");
			
			if (currentUrl.equals(checkoutLink)) {
				System.out.println("URLs match - proceed further");
				driver.findElement(firstname).sendKeys(config.getProperty("firstname"));
				driver.findElement(lastname).sendKeys(config.getProperty("lastname"));
				driver.findElement(postalcode).sendKeys(config.getProperty("zipcode"));
				driver.findElement(submituserinfo).click();
			} 
			else 
			{
				System.out.println("Order not Complete");
			}
			
	}
             public void finishOrder()
 			{
 				driver.findElement(finishorder).click();
 			}
             }