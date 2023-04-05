package tests;

import data.EmailToFriendData;
import data.RegisterData;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ElectronicsPage;
import pages.EmailToFriendPage;
import pages.HomePage;
import pages.RegisterPage;

import java.io.IOException;

public class EmailToFriendTest extends TestBase{
    ElectronicsPage electronicsPage;
    EmailToFriendPage email;
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

    @Test(priority = 3)
    public void HoverOverCellPhones(){
        electronicsPage = new ElectronicsPage(driver);
        electronicsPage.HoverOverElectronics();
        electronicsPage.hoverOverCellPhones();
        Assert.assertEquals(electronicsPage.getCellPhonesAssertionMessage(),"Cell phones");
    }

    @Test(priority = 4)
    public void goToChosenProductPage(){
        electronicsPage = new ElectronicsPage(driver);
        electronicsPage.navigateToChosenProduct();
    }
    @Test(priority = 5)
    public void goToEmailFriendPage(){
        email = new EmailToFriendPage(driver);
        email.navigateToEmailToFriendPage();
        Assert.assertEquals(email.getEmailPageAssertion(),"Email a friend");
    }

    @Test(priority = 6)
    public void sendEmailToFriend() throws IOException, ParseException {
        EmailToFriendData data = new EmailToFriendData(driver);
        data.UserData();
        email = new EmailToFriendPage(driver);
        email.sendMessage(data.friendEmail,data.Message);
        Assert.assertEquals(email.getEmailSentAssertionMessage(),"Your message has been sent.");
    }

}
