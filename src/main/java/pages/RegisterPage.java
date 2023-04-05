package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private final WebDriver driver;
    public RegisterPage(WebDriver driver){
        this.driver = driver;
    }
    private final By registerAssertion = By.xpath("//h1[text()='Register']");
    private final By genderButton = By.id("gender-male");
    private final By firstNameTxt = By.id("FirstName");
    private final By lastNameTxt = By.id("LastName");
    private final By emailTxt = By.id("Email");
    private final By passwordTxt = By.id("Password");
    private final By confirmPasswordTxt = By.id("ConfirmPassword");
    private final By registerBtn = By.id("register-button");
    private final By successfulRegisterMessage = By.xpath("//div[@class='result']");

    public String getAssertionMessageText(){
        return driver.findElement(registerAssertion).getText();
    }

    public void EnterUserData(String fName, String lName, String email, String password){
        driver.findElement(genderButton).click();
        driver.findElement(firstNameTxt).sendKeys(fName);
        driver.findElement(lastNameTxt).sendKeys(lName);
        driver.findElement(emailTxt).sendKeys(email);
        driver.findElement(passwordTxt).sendKeys(password);
        driver.findElement(confirmPasswordTxt).sendKeys(password);
        driver.findElement(registerBtn).click();
    }

    public String getSuccessfulRegisterMessage(){
        return driver.findElement(successfulRegisterMessage).getText();
    }
}
