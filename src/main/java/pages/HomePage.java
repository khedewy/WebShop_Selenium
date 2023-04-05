package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private final WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    private final By registerBtn = By.linkText("Register");
    private final By logoutButton = By.linkText("Log out");
    private final By loginButton = By.linkText("Log in");
    private final By contactUsBtn = By.xpath("//a[@href='/contactus']");


    public RegisterPage navigateToRegisterPage(){
        driver.findElement(registerBtn).click();
        return new RegisterPage(driver);
    }

    public void logout(){
        driver.findElement(logoutButton).click();
    }
    public LoginPage navigateToLoginPage(){
        driver.findElement(loginButton).click();
        return new LoginPage(driver);
    }
    public ContactUsPage navigateToContactUs(){
        driver.findElement(contactUsBtn).click();
        return new ContactUsPage(driver);
    }
}
