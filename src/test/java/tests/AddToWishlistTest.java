package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddToWishList;
import pages.ElectronicsPage;

public class AddToWishlistTest extends TestBase{

    ElectronicsPage electronicsPage;
    AddToWishList add;
    @Test
    public void HoverOverCellPhones(){
        electronicsPage = new ElectronicsPage(driver);
        electronicsPage.HoverOverElectronics();
        electronicsPage.hoverOverCellPhones();
        Assert.assertEquals(electronicsPage.getCellPhonesAssertionMessage(),"Cell phones");
    }
    @Test(priority = 1)
    public void goToChosenProductPage(){
        electronicsPage = new ElectronicsPage(driver);
        electronicsPage.navigateToChosenProduct();
    }
    @Test(priority = 2)
    public void addProductToWishList(){
        add = new AddToWishList(driver);
        add.addToWishList();
        Assert.assertEquals(add.getAssertionMessage(),"Smartphone");

    }
}
