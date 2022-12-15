package com.herokuapp.pages;

import com.herokuapp.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//input[@id='username']")
    WebElement usernameField;

    @CacheLookup
    @FindBy(id = "password")
    WebElement enterPassward;

    @CacheLookup
    @FindBy(xpath = "//i[contains(text(),'Login')]")
    WebElement clickLoginButton;
    @CacheLookup
    @FindBy(xpath = "//h2[text()=' Secure Area']")
    WebElement verifyMessage;


    @CacheLookup
    @FindBy(xpath = "//div[@id='flash']")
    WebElement textUserNameInvalid;

    @CacheLookup
    @FindBy
            (xpath = "//div[@class = 'flash error']")
    WebElement textPasswordInvalid;


    @CacheLookup
    @FindBy(xpath = "//div[@class = 'flash error']")
    WebElement VerifyErrorMessage;
//    By VerifyErrorMessage = By.xpath("//div[@class = 'flash error']");


    public void getUserName(String username) {
        Reporter.log("Enter usrname" + username + "to username field" + username.toString());
        sendTextToElement(usernameField, username);
    }

    public void getenterPassward(String password) {
        Reporter.log("Enter passward" + password + "to passward Field" + enterPassward.toString());
        sendTextToElement(enterPassward, password);
    }

    public void loginButton() {
        Reporter.log("Click on Login button" + clickLoginButton.toString());
        clickOnElement(clickLoginButton);
    }
    public String getTextUserNameInvalid() {
        return getTextFromElement(textUserNameInvalid);
    }

    public String getTextPasswordInvalid() {
        Reporter.log("Verify message" + textPasswordInvalid.toString());
        return getTextFromElement(textPasswordInvalid);
}

    public String getVerifyMessage() {
        Reporter.log("Verify message" + verifyMessage.toString());
        return getTextFromElement(verifyMessage);
    }

    public String getVerifyErrorMessage() {
        Reporter.log("Verify error message" + VerifyErrorMessage.toString());
        return getTextFromElement(VerifyErrorMessage);
    }

}

