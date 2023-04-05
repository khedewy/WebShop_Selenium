package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class CheckOutPage {
    private final WebDriver driver;
    public CheckOutPage(WebDriver driver){
        this.driver = driver;
    }
    private final By servicesBtn = By.id("termsofservice");
    private final By checkoutButton = By.id("checkout");
    private final By guestOption = By.xpath("//input[@class='button-1 checkout-as-guest-button']");
    private final By firstNameTxt = By.id("BillingNewAddress_FirstName");
    private final By lastNameTxt = By.id("BillingNewAddress_LastName");
    private final By emailTxt = By.id("BillingNewAddress_Email");
    private final By companyTxt = By.id("BillingNewAddress_Company");
    private final By countryTxt = By.id("BillingNewAddress_CountryId");
    private final By cityTxt = By.id("BillingNewAddress_City");
    private final By address1Txt = By.id("BillingNewAddress_Address1");
    private final By address2Txt = By.id("BillingNewAddress_Address2");
    private final By zipTxt = By.id("BillingNewAddress_ZipPostalCode");
    private final By phoneTxt = By.id("BillingNewAddress_PhoneNumber");
    private final By faxNumber = By.id("BillingNewAddress_FaxNumber");
    private final By continueBtn = By.xpath("//input[@class='button-1 new-address-next-step-button']");
    private final By shippingButton = By.xpath("//input[@onclick='Shipping.save()']");
    private final By shippingMethode = By.xpath("//input[@onclick='ShippingMethod.save()']");
    private final By paymentMethode = By.xpath("//input[@onclick='PaymentMethod.save()']");
    private final By paymentInformation = By.xpath("//input[@onclick='PaymentInfo.save()']");
    private final By confirmationButton = By.xpath("//input[@onclick='ConfirmOrder.save()']");
    private final By assertionMessage = By.xpath("//strong[text()='Your order has been successfully processed!']");

    public void AgreeOnServices(){
        driver.findElement(servicesBtn).click();
    }

    public void navigateToCheckout(){
        driver.findElement(checkoutButton).click();
        driver.findElement(guestOption).click();
    }

    public void enterAddressData(String firstName, String lastName,
                                 String email, String company ,
                                 String country, String city,
                                 String address1, String address2,
                                 String zip, String phone, String fax ){

        driver.findElement(firstNameTxt).sendKeys(firstName);
        driver.findElement(lastNameTxt).sendKeys(lastName);
        driver.findElement(emailTxt).sendKeys(email);
        driver.findElement(companyTxt).sendKeys(company);
        Select select = new Select(driver.findElement(countryTxt));
        select.selectByVisibleText(country);
        driver.findElement(cityTxt).sendKeys(city);
        driver.findElement(address1Txt).sendKeys(address1);
        driver.findElement(address2Txt).sendKeys(address2);
        driver.findElement(zipTxt).sendKeys(zip);
        driver.findElement(phoneTxt).sendKeys(phone);
        driver.findElement(faxNumber).sendKeys(fax);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(continueBtn)));
        driver.findElement(continueBtn).click();
    }


    public void clickShippingButton(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(shippingButton)));
        driver.findElement(shippingButton).click();
    }

    public void navigateToShippingMethode(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(shippingMethode)));
        driver.findElement(shippingMethode).click();
    }
    public void navigateToPaymentMethode(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(paymentMethode)));
        driver.findElement(paymentMethode).click();
    }

    public void navigateToPaymentInformation(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(paymentInformation)));
        driver.findElement(paymentInformation).click();
    }
    public void confirmOrder(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(confirmationButton)));
        driver.findElement(confirmationButton).click();
    }
    public String getAssertionMessage(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver.findElement(assertionMessage).getText();
    }

}
