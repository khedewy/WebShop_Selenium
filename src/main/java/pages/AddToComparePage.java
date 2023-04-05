package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToComparePage {
    private final WebDriver driver;
    public AddToComparePage(WebDriver driver){
        this.driver = driver;
    }
    private final By addToCompareButton = By.xpath("//input[@class='button-2 add-to-compare-list-button']");
    private final By AssertionMessage = By.xpath("//a[@href='/smartphone' and text()='Smartphone']");

    public void addToCompareList(){
        driver.findElement(addToCompareButton).click();
    }
    public String getAssertionMessage(){
        return driver.findElement(AssertionMessage).getText();
    }
}
