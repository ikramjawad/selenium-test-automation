package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot{

    public static String captureScreenshot(WebDriver driver, String moduleName, String status) {

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        String fileName = moduleName + "_" + status + "_" + timestamp + ".png";

        String path = System.getProperty("user.dir") + "/screenshots/" + fileName;

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(src, new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return path;
    }
}