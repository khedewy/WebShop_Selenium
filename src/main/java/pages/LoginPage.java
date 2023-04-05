package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    private final By loginPageAssertion = By.xpath("//h1[text()='Welcome, Please Sign In!']");
    private final By emailTxt = By.id("Email");
    private final By passwordTxt = By.id("Password");
    private final By loginButton = By.xpath("//input[@class='button-1 login-button']");
    private final By successfulLoginMessage = By.xpath("//p[text()='Welcome to the new Tricentis store!']");

    public String getLoginPageAssertion(){
        return  driver.findElement(loginPageAssertion).getText();
    }

    public void EnterLoginData(String email, String password){
        driver.findElement(emailTxt).sendKeys(email);
        driver.findElement(passwordTxt).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public String getSuccessfulMessageText(){
        return driver.findElement(successfulLoginMessage).getText();
    }
}
