package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;

public class ComputerPage {
    private final WebDriver driver;
    Actions actions;
    public ComputerPage(WebDriver driver){
        this.driver = driver;
    }
    private final By computers = By.xpath("//a[@href='/computers']");
    private final By desktops = By.xpath("//a[@href='/desktops']");
    private final By notebooks = By.xpath("//a[@href='/notebooks']");
    private final By DesktopsAssertionMessage = By.xpath("//strong[@class='current-item']");
    private final By notebooksAssertionMessage = By.xpath("//h1[text()='Notebooks']");

    public void HoverOverComputers() {
        actions = new Actions(driver);
        actions.moveToElement(driver.findElement(computers)).perform();
    }

    public void hoverOverDesktops(){
        actions = new Actions(driver);
        actions.moveToElement(driver.findElement(desktops)).click().build().perform();
    }

    public void hoverOverNotebooks(){
        actions = new Actions(driver);
        actions.moveToElement(driver.findElement(notebooks)).click().build().perform();
    }

    public String getDesktopAssertionMessage(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver.findElement(DesktopsAssertionMessage).getText();
    }

    public String getNotebooksAssertionMessage(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver.findElement(notebooksAssertionMessage).getText();
    }
}
