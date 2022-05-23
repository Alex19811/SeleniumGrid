package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import pages.*;
import utils.CapabilityFactory;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
    private CapabilityFactory capabilityFactory = new CapabilityFactory();
    private static final String EVA_URL = "https://eva.ua/";

    @BeforeMethod
    @Parameters(value = {"browser"})
    public void setUp(@Optional("chrome") String browser) throws MalformedURLException {
        driver.set(new RemoteWebDriver(new URL("http://192.168.1.134:4444/wd/hub"), capabilityFactory.getCapabilities(browser)));
        getDriver().manage().window().maximize();
        getDriver().get(EVA_URL);

    }

    @AfterMethod
    public void tearDown() {
        getDriver().close();
    }

    @AfterClass
    void terminate() {
        driver.remove();
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    public HomePage getHomePage() {
        return new HomePage(getDriver());
    }

    public SelfСarePage getSelfСarePage() {
        return new SelfСarePage(getDriver());
    }

    public NiveaPage getNiveaPage() {
        return new NiveaPage(getDriver());
    }

    public HairShampoosPage getHairShampoosPage() {
        return new HairShampoosPage(getDriver());
    }

    public CalvinKleinPage getCalvinKleinPage() {
        return new CalvinKleinPage(getDriver());
    }
}
