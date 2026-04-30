package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;

public class LoginPage {
	
	 private WebDriver driver;
	 private ConfigReader config;

	  public LoginPage(WebDriver driver , ConfigReader config) {
	        this.driver = driver;
	        this.config = config;
	    }
    // 🔹 Locators (ALL here)
	    By username = By.id("user-name");
	    By password = By.id("password");
	    By loginBtn = By.id("login-button");
	    By logindisplayicon = By.cssSelector("#shopping_cart_container > a");
	     
	    // Actions
	    public void login(String user , String pass) {
	    	
	        driver.findElement(username).sendKeys(config.getProperty(user));
	        driver.findElement(password).sendKeys(config.getProperty(pass));
	        driver.findElement(loginBtn).click();
	    }
	    public boolean isLoginSuccessful()
	    {
			return driver.findElement(logindisplayicon).isDisplayed();	
	    }
	}

