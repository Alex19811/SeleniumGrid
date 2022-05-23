package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ElectricToothbrushesPage;
import pages.NiveaPage;

import java.util.concurrent.TimeUnit;

public class SmokeTests extends BaseTest {

    private static final long DEFAULT_WAITING_TIME = 90;
    private static final String SEARCH_KEYWORD_NIVEA = "Nivea";

    @Test(priority = 1)
    public void promotionalPriceOfProduct() throws InterruptedException {
        getHomePage().waitForPageLocalComplete(DEFAULT_WAITING_TIME);
        getHomePage().isPersonalСareVisibility();
        getHomePage().clickPersonalСarePage();
        getSelfСarePage().waitVisibilityOfElement(DEFAULT_WAITING_TIME, getSelfСarePage().getElectricToothbrushes());
        getSelfСarePage().isElectricToothbrushesVisible();
        getSelfСarePage().clickElectricToothbrushesPage();
        getHomePage().waitForPageLocalComplete(DEFAULT_WAITING_TIME);
        ElectricToothbrushesPage electricToothbrushesPage = new ElectricToothbrushesPage();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(electricToothbrushesPage.isRandomProductNotHavePromo());
        softAssert.assertTrue(electricToothbrushesPage.isRandomProductNotHavePromo());
        softAssert.assertTrue(electricToothbrushesPage.isRandomProductNotHavePromo());
        softAssert.assertAll();
    }

    @Test(priority = 2)
    private void checkForItemAvailability() throws InterruptedException {
        getHomePage().waitForPageLocalComplete(DEFAULT_WAITING_TIME);
        getHomePage().isHeaderVisibility();
        getHomePage().isSearchInputVisibility();
        getHomePage().isSearchButtonVisibility();
        getHomePage().searchByKeyword(SEARCH_KEYWORD_NIVEA);
        getHomePage().waitVisibilityOfElement(DEFAULT_WAITING_TIME, getNiveaPage().getNiveaTitle());
        NiveaPage niveaPage = new NiveaPage();
        Assert.assertEquals(niveaPage.getTextNiveaPageTitle(), "Косметика Nivea");
    }

    @Test(priority = 3)
    private void checkThatSearchResultsContainsName() {
        getHomePage().waitForPageLocalComplete(DEFAULT_WAITING_TIME);
        getHomePage().isHeaderVisibility();
        getHomePage().isBrandsVisibility();
        getHomePage().clickBrands();
        getHomePage().waitVisibilityOfElement(DEFAULT_WAITING_TIME, getHomePage().getCalvinKleinButton());
        getHomePage().clickCalvinKleinPage();
        getHomePage().waitVisibilityOfElement(DEFAULT_WAITING_TIME, getCalvinKleinPage().getCalvinKleinTitle());

        for (WebElement element : getCalvinKleinPage().getCalvinKleinProducts()) {
            Assert.assertTrue(element.getText().contains("Calvin Klein"));
        }
    }

    @Test(priority = 4)
    private void checkContainsAcme() {
        getHomePage().waitForPageLocalComplete(DEFAULT_WAITING_TIME);
        getHomePage().isHeaderVisibility();
        getHomePage().isHairShampoosVisibility();
        getHomePage().clickHairShampoosPage();
        getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        getHairShampoosPage().isAcmeButtonVisibility();
        getHairShampoosPage().clickAcmeButtonPage();
        getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        getHomePage().waitVisibilityOfElement(DEFAULT_WAITING_TIME, getHairShampoosPage().getAcmeTitle());
        for (WebElement elementAcme : getHairShampoosPage().getAcmeProducts())
            Assert.assertEquals(getHairShampoosPage().getAcmeProductsSize(), 22);
    }
}
