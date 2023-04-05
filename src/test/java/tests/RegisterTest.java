package tests;

import data.RegisterData;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;

import java.io.IOException;

public class RegisterTest extends TestBase{
    HomePage home;
    RegisterPage registerPage;
    String currentTime = String.valueOf(System.currentTimeMillis());

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
}
