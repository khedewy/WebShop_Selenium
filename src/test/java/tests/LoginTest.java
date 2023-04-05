package tests;

import data.RegisterData;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;

import java.io.IOException;

public class LoginTest extends TestBase{
    HomePage home;
    RegisterPage registerPage;
    String currentTime = String.valueOf(System.currentTimeMillis());
    LoginPage log;

    @Test
    public void validateTitlePage(){
        Assert.assertEquals(driver.getTitle(),"Demo Web Shop");
    }
    @Test(priority = 1)
    public void navigateToRegister(){
        home = new HomePage(driver);
        home.navigateToRegisterPage();
        registerPage = new RegisterPage(driver);
        Assert.assertEquals(registerPage.getAssertionMessageText(),"Register");
    }
    @Test(priority = 2)
    public void completeRegister() throws IOException, ParseException {
        RegisterData data = new RegisterData(driver);
        data.UserData();
        registerPage = new RegisterPage(driver);
        registerPage.EnterUserData(data.firstName, data.lastName, data.email+currentTime+"@gmail.com" , data.Password);
        Assert.assertEquals(registerPage.getSuccessfulRegisterMessage(),"Your registration completed");
    }
    @Test(priority = 3)
    public void logOut(){
        home = new HomePage(driver);
        home.logout();
    }

    @Test(priority = 4)
    public void Login() throws IOException, ParseException {
        log = new LoginPage(driver);
        RegisterData data = new RegisterData(driver);
        data.UserData();
        home = new HomePage(driver);
        home.navigateToLoginPage();
        Assert.assertEquals(log.getLoginPageAssertion(),"Welcome, Please Sign In!");
        log.EnterLoginData(data.email+currentTime+"@gmail.com", data.Password);
        Assert.assertEquals(log.getSuccessfulMessageText(),"Welcome to the new Tricentis store!");
    }
}
