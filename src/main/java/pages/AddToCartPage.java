package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class AddToCartPage {
    private final WebDriver driver;
    public AddToCartPage(WebDriver driver){
        this.driver = driver;
    }
    private final By addToCartButton = By.id("add-to-cart-button-31");
    private final By showCartButton = By.linkText("shopping cart");
    private final By firstProductAssertionMessage = By.xpath("//a[@class='product-name' and text()='14.1-inch Laptop']");
    private final By addToCartButton2 = By.id("add-to-cart-button-13");
    private final By secondProductAssertionMessage = By.xpath("//a[@class='product-name' and text()='Computing and Internet']");


    public void addFirstProductToCart(){
        driver.findElement(addToCartButton).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(showCartButton).click();
    }
    public String getFirstProductAssertionMessage(){
        return driver.findElement(firstProductAssertionMessage).getText();
    }

    public void addSecondProductToCart(){
        driver.findElement(addToCartButton2).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(showCartButton).click();
    }
    public String getSecondProductAssertionMessage(){
        return driver.findElement(secondProductAssertionMessage).getText();
    }
}
