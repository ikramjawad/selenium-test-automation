package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import java.lang.reflect.Method;

import utils.ConfigReader;
import utils.DriverFactory;
import utils.ScreenShot;
import utils.HTMLReport;

public class BaseTest {

	protected WebDriver driver;
    public ConfigReader config;  
    public static ExtentReports extent;
    public ExtentTest test;
    
    @Parameters("browser")
    @BeforeMethod
    public void setUp(String browser , Method method)
    {
    	config = new ConfigReader();  
        driver = DriverFactory.initDriver(browser);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(config.getProperty("url"));
        
        extent = HTMLReport.getInstance();
        test = extent.createTest(method.getName());
    }
    @AfterMethod
    public void tearDown(ITestResult result) {

        String moduleName = result.getMethod().getMethodName();

        if (result.getStatus() == ITestResult.FAILURE) {
            ScreenShot.captureScreenshot(driver, moduleName, "FAIL");
            String path = ScreenShot.captureScreenshot(driver, result.getMethod().getMethodName(), "FAIL");

            test.fail("Test Failed")
                .addScreenCaptureFromPath(path);
        } 
        else if (result.getStatus() == ITestResult.SUCCESS) {
        	ScreenShot.captureScreenshot(driver, moduleName, "PASS");
        }
        extent.flush(); 
        if (driver != null) {
            driver.quit();
        }
    }
}