package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddToComparePage;
import pages.ElectronicsPage;

public class AddToCompareTest extends TestBase{
    ElectronicsPage electronicsPage;
    AddToComparePage add;
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
    public void addToCompareList(){
        add = new AddToComparePage(driver);
        add.addToCompareList();
        Assert.assertEquals(add.getAssertionMessage(),"Smartphone");
    }
}
