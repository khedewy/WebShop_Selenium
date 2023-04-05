package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ElectronicsPage;

public class HoverOverElectronicsTest extends TestBase{
    ElectronicsPage electronicsPage;

    @Test
    public void HoverOverCameras(){
        electronicsPage = new ElectronicsPage(driver);
        electronicsPage.HoverOverElectronics();
        electronicsPage.hoverOverCamera();
        Assert.assertEquals(electronicsPage.getCameraAssertionMessage(),"Camera, photo");
    }

    @Test(priority = 1)
    public void HoverOverCellPhones(){
        electronicsPage = new ElectronicsPage(driver);
        electronicsPage.HoverOverElectronics();
        electronicsPage.hoverOverCellPhones();
        Assert.assertEquals(electronicsPage.getCellPhonesAssertionMessage(),"Cell phones");
    }
}
