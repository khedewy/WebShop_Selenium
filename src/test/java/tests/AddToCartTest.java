package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddToCartPage;
import pages.SearchPage;

public class AddToCartTest extends TestBase{

    SearchPage searchPage;
    AddToCartPage add;

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
}
