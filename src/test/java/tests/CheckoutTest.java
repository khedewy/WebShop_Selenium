package tests;

import data.CheckoutData;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddToCartPage;
import pages.CheckOutPage;
import pages.SearchPage;

import java.io.IOException;

public class CheckoutTest extends TestBase{
    SearchPage searchPage;
    AddToCartPage add;
    CheckOutPage check;

    @Test
    public void searchForProducts(){
        searchPage = new SearchPage(driver);
        searchPage.searchForFirstProductProduct("inch");
        Assert.assertEquals(searchPage.getAssertionMessage(),"14.1-INCH LAPTOP");
    }

    @Test(priority = 1)
    public void addFirstProductToCart(){
        add = new AddToCartPage(driver);
        add.addFirstProductToCart();
        Assert.assertEquals(add.getFirstProductAssertionMessage()
                ,"14.1-inch Laptop");
    }

    @Test(priority = 2)
    public void searchForSecondProduct(){
        searchPage = new SearchPage(driver);
        searchPage.searchForFirstProductProduct("computing");
        Assert.assertEquals(searchPage.getAssertionMessage(),"COMPUTING AND INTERNET");
    }

    @Test(priority = 3)
    public void addSecondProductToCart(){
        add = new AddToCartPage(driver);
        add.addSecondProductToCart();
        Assert.assertEquals(add.getSecondProductAssertionMessage(),"Computing and Internet");
    }

    @Test(priority = 4)
    public void agreeOnServices(){
        check = new CheckOutPage(driver);
        check.AgreeOnServices();
    }

    @Test(priority = 5)
    public void navigateToCheckout(){
        check = new CheckOutPage(driver);
        check.navigateToCheckout();
    }

    @Test(priority = 6)
    public void enterAddressData() throws IOException, ParseException {
        CheckoutData data = new CheckoutData(driver);
        data.UserData();
        check = new CheckOutPage(driver);
        check.enterAddressData(data.firstName, data.lastName, data.email,
                data.company, data.country,
                data.city, data.address1,
                data.address2, data.zip,
                data.phone, data.fax);
    }

    @Test(priority = 7)
    public void navigateToShipping(){
        check = new CheckOutPage(driver);
        check.clickShippingButton();
    }

    @Test(priority = 8)
    public void navigateToShippingMethode(){
        check = new CheckOutPage(driver);
        check.navigateToShippingMethode();
    }
    @Test(priority = 9)
    public void navigateToShippingPayment(){
        check = new CheckOutPage(driver);
        check.navigateToPaymentMethode();
    }
    @Test(priority = 10)
    public void navigateToPaymentInformation(){
        check = new CheckOutPage(driver);
        check.navigateToPaymentInformation();
    }

    @Test(priority = 11)
    public void confirmOrder(){
        check = new CheckOutPage(driver);
        check.confirmOrder();
        Assert.assertEquals(check.getAssertionMessage(),"Your order has been successfully processed!");
    }
}
