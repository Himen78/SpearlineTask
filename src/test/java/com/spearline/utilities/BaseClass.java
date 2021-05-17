package com.spearline.utilities;

import com.spearline.webAppFunctions.webAppFunctions;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class BaseClass {

    public Properties properties;
    public static WebDriver webDriver;
    public static Logger log = LogManager.getLogger(webAppFunctions.class.getName());

    @BeforeClass
    public void setup() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("./config.properties");
        properties = new Properties();
        properties.load(fileInputStream);
        String browser = properties.getProperty("Browser");

        if (browser.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
            webDriver = new ChromeDriver();
            log.info("Chrome driver is initialize successfully.");
            webDriver.get(properties.getProperty("URL"));
        }

        else if (browser.equalsIgnoreCase("Edge"))

        {
            System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"/Drivers/msedgedriver.exe");
            webDriver = new EdgeDriver();
            log.info("Edge driver is initialize successfully.");
            webDriver.get(properties.getProperty("URL"));
        }

        else
        {
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
            webDriver = new ChromeDriver();
            log.info("Chrome driver is initialize successfully.");
            webDriver.get(properties.getProperty("URL"));
        }

        webDriver.manage().window().maximize();
        log.info("Web screen is maximized successfully.");
    }

    public String getScreenshotPath(String TestCaseName) throws IOException {

        TakesScreenshot screenshot = (TakesScreenshot) webDriver;
        String dateName = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        String destPath = System.getProperty("user.dir")+"\\Reports\\Screenshots\\"+TestCaseName+dateName+".png";
        File file = new File(destPath);
        FileUtils.copyFile(source, file);
        return destPath;
    }

    @AfterClass
    public void teardown(){

        webDriver.quit();

    }

}
