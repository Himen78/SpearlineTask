package com.spearline.webAppFunctions;

import com.spearline.pageData.WLoginPageData;
import com.spearline.pageObjects.WLoginPage;
import com.spearline.utilities.BaseClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class webAppFunctions extends BaseClass {

    WebDriver webDriver;
    public static Logger log = LogManager.getLogger(webAppFunctions.class.getName());

    public webAppFunctions(WebDriver remoteDriver) {
        webDriver = remoteDriver;
    }

    public void loginFunction() throws InterruptedException {
        WLoginPage wLoginPage = new WLoginPage(webDriver);
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        Thread.sleep(4000);
        wLoginPage.getLogInButton().click();
        log.info("Clicked on Log-in button successfully..!!");
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String getHeadingTitle = wLoginPage.getLogInHeadingText().getText();
        Assert.assertTrue(getHeadingTitle.equalsIgnoreCase(WLoginPageData.expLoginHeadingTitle));
        log.info("Page title is verified successfully..!");
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wLoginPage.getUserNameTextField().sendKeys(WLoginPageData.usernameData);
        log.info("Username entered successfully..!");
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wLoginPage.getPasswordTextField().sendKeys(WLoginPageData.passwordData);
        log.info("Password entered successfully..!");
        wLoginPage.getLogInButtonOnMainLoginPage().isEnabled();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wLoginPage.getLogInButtonOnMainLoginPage().click();
        log.info("Clicked on Log-in button successfully..!!");
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String wrongCredentialsMessage = wLoginPage.getWrongCredentialsMessage().getText();
        Assert.assertTrue(wrongCredentialsMessage.equalsIgnoreCase(WLoginPageData.wrongCredentialsMessage));
        log.info("Validation message is verified successfully.!!");
    }
}
