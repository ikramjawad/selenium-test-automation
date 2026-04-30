package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.LoginPage;
import pages.ProductPage;

public class LoginTest extends BaseTest {

	@Test(priority = 1)
	public void validLoginTest() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver, config);
		loginPage.login("username", "password");
		Assert.assertTrue(loginPage.isLoginSuccessful(), "LoginTest Failed");
		ProductPage productpage = new  ProductPage(driver , config);
		productpage.addProductToCart("productname");
		Thread.sleep(3000);
		productpage.openCart();
		Thread.sleep(3000);
		productpage.clickCheckout();
		Thread.sleep(3000);
		productpage.fillCheckoutInfo("firstname", "lastname", "zipcode");
		Thread.sleep(3000);
	}

//	@Test(dependsOnMethods = "validLoginTest")
//
//	public void invalidLoginTest() {
//		LoginPage loginpage = new LoginPage(driver, config);
//		loginpage.login("username1", "password1");
//		Assert.assertFalse(loginpage.isLoginSuccessful(), "invalid Login Pass");
//	}
}
