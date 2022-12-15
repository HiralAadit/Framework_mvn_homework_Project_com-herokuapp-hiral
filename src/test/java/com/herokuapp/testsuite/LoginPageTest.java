package com.herokuapp.testsuite;

import com.herokuapp.pages.LoginPage;
import com.herokuapp.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
    LoginPage loginPage;
    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        loginPage=new LoginPage();
    }
    @Test(groups = {"sanity","regression"})
    public void userSholdLoginSuccessfullyWithValidCredentials() {
        loginPage.getUserName("tomsmith");
        loginPage.getenterPassward("SuperSecretPassword!");
        loginPage.loginButton();
        String expecetdMessage = "Secure Area";
        Assert.assertEquals(loginPage.getVerifyMessage(), expecetdMessage, "No text found");

    }
    @Test(groups = {"smoke", "regression"})
    public void verifyTheUsernameErrorMessage() {
        //* Enter “tomsmith1” username
        loginPage.getUserName("tomsmith1");
        loginPage.getenterPassward("SuperSecretPassword!");
        loginPage.loginButton();
        //Verify the error message “Your username is invalid!”
        String expectedMessage = "Your username is invalid!\n" +
                "×";
        Assert.assertEquals(loginPage.getTextUserNameInvalid(), expectedMessage, "Message is not displayed");

    }


   @Test(groups = {"regression"})
    public void verifyThePasswordErrorMessage() {
        loginPage.getUserName("tomsmith");
        loginPage.getenterPassward("SuperSecretPassword");
        loginPage.loginButton();
        String expecetdMessage = "Your password is invalid!\n" +
                "×";
        Assert.assertEquals(loginPage.getVerifyErrorMessage(),expecetdMessage,"Not text found");

    }

}
