package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import utils.ConfigReader;

public class OverviewPage {

    private WebDriver driver;
    private ConfigReader config;

    By productName = By.className("inventory_item_name");
    By orderTotal = By.className("inventory_item_price");
    By completeOrder = By.id("finish");

    public OverviewPage(WebDriver driver, ConfigReader config) {
        this.driver = driver;
        this.config = config;
    }

    public void confirmOrder(String expectedProduct, String orderprice) {

        String exProduct = config.getProperty(expectedProduct);
        String actualProduct = getProductName();

        Assert.assertEquals(actualProduct, exProduct,
                "Wrong product displayed on overview page");

        String expectedTotal = config.getProperty(orderprice);
        String actualTotal = getTotal();

        Assert.assertEquals(actualTotal, expectedTotal,
                "Price is not Matching");
        
    }

    public String getProductName() {
        return driver.findElement(productName).getText();
    }

    public String getTotal() {
        return driver.findElement(orderTotal).getText();
    }

    public void clickFinish() {
        driver.findElement(completeOrder).click();
    }
}