package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage {
    private final WebDriver driver;
    public ContactUsPage(WebDriver driver){
        this.driver = driver;
    }
    private final By nameTxt = By.id("FullName");
    private final By emailTxt = By.id("Email");
    private final By messageTxt = By.id("Enquiry");
    private final By submitButton = By.name("send-email");
    private final By AssertionMessage = By.xpath("//div[@class='result']");

    public void contactUsData(String name, String email, String message){
        driver.findElement(nameTxt).sendKeys(name);
        driver.findElement(emailTxt).sendKeys(email);
        driver.findElement(messageTxt).sendKeys(message);
        driver.findElement(submitButton).click();
    }

    public String getAssertionMessage(){
        return driver.findElement(AssertionMessage).getText();
    }
}
