package tests;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.OverviewPage;
import pages.ProductPage;
import utils.ConfigReader;

public class ProductTest extends BaseTest{
@Test
	public void productTest(String productName) throws InterruptedException {
	LoginPage loginPage = new LoginPage(driver, config);
	loginPage.login("username", "password");
	ProductPage productpage = new  ProductPage(driver , config);
	productpage.addProductToCart("productname");
	productpage.openCart();
	productpage.fillCheckoutInfo("firstname", "lastname", "zipcode");
	Thread.sleep(3000);
	OverviewPage OverviewPage = new OverviewPage(driver , config);
	OverviewPage.confirmOrder("expectedProduct", "OrderTotal");
	Thread.sleep(3000);
	OverviewPage.clickFinish();
	
}
}




