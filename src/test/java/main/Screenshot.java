package main;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Screenshot {

    public static final DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd G 'at' HH_mm_ss z");


    public static String generateFileName(ITestResult result) {
        Date date = new Date();
        return result.getName() + "_" + dateFormat.format(date);
    }

    public static String takeScreenshot(WebDriver driver, String filename) throws IOException {

        TakesScreenshot screen = (TakesScreenshot) driver;
        File src = screen.getScreenshotAs(OutputType.FILE);

        String dest = Paths.FAIL_TC_IMAGE + filename + ".png";

        File target = new File(dest);

        FileUtils.copyFile(src, target);

        return dest;
    }

}
