package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ComputerPage;

public class HoverOverComputersTest extends TestBase{
    ComputerPage computerPage;

    @Test
    public void HoverOverDesktops(){
        computerPage = new ComputerPage(driver);
        computerPage.HoverOverComputers();
        computerPage.hoverOverDesktops();
        Assert.assertEquals(computerPage.getDesktopAssertionMessage(),"DESKTOPS");
    }

    @Test(priority = 1)
    public void HoverOverNotebooks(){
        computerPage = new ComputerPage(driver);
        computerPage.HoverOverComputers();
        computerPage.hoverOverNotebooks();
        Assert.assertEquals(computerPage.getNotebooksAssertionMessage(),"Notebooks");
    }
}
