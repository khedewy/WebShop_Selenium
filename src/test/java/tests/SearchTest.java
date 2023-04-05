package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchPage;

public class SearchTest extends TestBase{
    SearchPage searchPage;

    @Test
    public void searchForProducts(){
        searchPage = new SearchPage(driver);
        searchPage.searchForFirstProductProduct("inch");
        Assert.assertEquals(searchPage.getAssertionMessage(),"14.1-INCH LAPTOP");
    }
}
