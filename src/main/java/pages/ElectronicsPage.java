package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ElectronicsPage {
    private final WebDriver driver;
    Actions actions;
    public ElectronicsPage(WebDriver driver){
        this.driver = driver;
    }
    private final By electronics = By.xpath("//a[@href='/electronics']");
    private final By camera = By.xpath("//a[@href='/camera-photo']");
    private final By CameraAssertion = By.xpath("//h1[text()='Camera, photo']");
    private final By cellPhones = By.xpath("//a[@href='/cell-phones']");
    private final By cellPhonesAssertion = By.xpath("//h1[text()='Cell phones']");
    private final By chosenProduct = By.linkText("Smartphone");

    public void HoverOverElectronics(){
        actions = new Actions(driver);
        actions.moveToElement(driver.findElement(electronics)).perform();
    }

    public void hoverOverCamera(){
        actions = new Actions(driver);
        actions.moveToElement(driver.findElement(camera)).click().build().perform();
    }

    public String getCameraAssertionMessage(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver.findElement(CameraAssertion).getText();
    }

    public void hoverOverCellPhones(){
        actions = new Actions(driver);
        actions.moveToElement(driver.findElement(cellPhones)).click().build().perform();
    }
    public String getCellPhonesAssertionMessage(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver.findElement(cellPhonesAssertion).getText();
    }

    public void navigateToChosenProduct(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(chosenProduct).click();
    }

}
