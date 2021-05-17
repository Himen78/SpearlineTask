package com.spearline.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class WLoginPage {

    WebDriver localDriver;

    public WLoginPage(WebDriver remoteDriver) {
        localDriver = remoteDriver;
        PageFactory.initElements(remoteDriver,this);
    }

    @FindBy(xpath = "//span[contains(text(),'Log in')]")
    public WebElement logInButton;

    @FindBy(xpath = "//span[normalize-space()='Log in to Twitter']")
    public WebElement logInHeadingText;

    @FindBy(xpath = "//input[@type='text']")
    public WebElement userNameTextField;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement passwordTextField;

    @FindBy(xpath = "(//span[contains(text(),'Log in')])[2]")
    public WebElement logInButtonOnMainLoginPage;

    @FindBy(xpath = "//div[contains(text(),'The username and password you entered did not match our records.')]")
    public WebElement wrongCredentialsMessage;

    public WebElement getWrongCredentialsMessage() {
        return wrongCredentialsMessage;
    }

    public WebElement getLogInHeadingText() {
        return logInHeadingText;
    }

    public WebElement getLogInButton() {
        return logInButton;
    }

    public WebElement getLogInButtonOnMainLoginPage() {
        return logInButtonOnMainLoginPage;
    }

    public WebElement getPasswordTextField() {
        return passwordTextField;
    }

    public WebElement getUserNameTextField() {
        return userNameTextField;
    }
}
