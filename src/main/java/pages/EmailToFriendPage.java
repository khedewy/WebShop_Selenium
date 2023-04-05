package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class EmailToFriendPage {
    private final WebDriver driver;
    public EmailToFriendPage(WebDriver driver){
        this.driver = driver;
    }


    private final By emailToFriendButton = By.xpath("//input[@value='Email a friend']");
    private final By emailPageAssertion = By.xpath("//h1[text()='Email a friend']");
    private final By friendEmailTxt = By.id("FriendEmail");
    private final By messageBox = By.id("PersonalMessage");
    private final By sendEmailButton = By.xpath("//input[@name='send-email']");
    private final By emailSentAssertion = By.xpath("//div[@class='result']");


    public void navigateToEmailToFriendPage(){
        driver.findElement(emailToFriendButton).click();
    }
    public String getEmailPageAssertion(){
        return driver.findElement(emailPageAssertion).getText();
    }

    public void sendMessage(String f_email , String message){
        driver.findElement(friendEmailTxt).sendKeys(f_email);
        driver.findElement(messageBox).sendKeys(message);
        driver.findElement(sendEmailButton).click();
    }
    public String getEmailSentAssertionMessage(){
        return driver.findElement(emailSentAssertion).getText();
    }
}
