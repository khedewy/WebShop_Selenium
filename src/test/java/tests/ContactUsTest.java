package tests;

import data.ContactUsData;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;

import java.io.IOException;

public class ContactUsTest extends TestBase {
    HomePage home;
    ContactUsPage contactUsPage;

    @Test
    public void navigateToContactUs(){
        home = new HomePage(driver);
        home.navigateToContactUs();
    }
    @Test(priority = 1)
    public void contactUs() throws IOException, ParseException {
        ContactUsData data = new ContactUsData(driver);
        data.UserData();
        contactUsPage = new ContactUsPage(driver);
        contactUsPage.contactUsData(data.name, data.email, data.Message);
        Assert.assertEquals(contactUsPage.getAssertionMessage(),"Your enquiry has been successfully sent to the store owner.");
    }

}
