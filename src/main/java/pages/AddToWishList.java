package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class AddToWishList {
    private final WebDriver driver;
    public AddToWishList(WebDriver driver) {
        this.driver = driver;
    }
    private final By addToWishListButton = By.id("add-to-wishlist-button-43");
    private final By showWishList = By.linkText("wishlist");
    private final By AssertionMessage = By.xpath("//a[@href='/smartphone' and text()='Smartphone']");

    public void addToWishList(){
        driver.findElement(addToWishListButton).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(showWishList).click();
    }

    public String getAssertionMessage(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver.findElement(AssertionMessage).getText();
    }
}
