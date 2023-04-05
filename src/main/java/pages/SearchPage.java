package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import java.time.Duration;

public class SearchPage {
    private final WebDriver driver;
    public SearchPage(WebDriver driver){
        this.driver = driver;
    }

    private final By searchBox = By.id("small-searchterms");
    private final By FirstProductResults = By.id("ui-id-2");
    private final By secondSearchResults = By.id("ui-id-9");
    private final By AssertionMessage = By.xpath("//strong[@class='current-item']");

    public void searchForFirstProductProduct(String product){
        driver.findElement(searchBox).sendKeys(product);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(FirstProductResults).click();
    }

    public String getAssertionMessage(){
        return driver.findElement(AssertionMessage).getText();
    }

    public void searchForSecondProduct(String product){
        driver.findElement(searchBox).sendKeys(product);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(secondSearchResults).click();
    }
}
