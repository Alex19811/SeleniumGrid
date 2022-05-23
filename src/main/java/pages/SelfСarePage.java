package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelfСarePage extends BasePage{

    public SelfСarePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@class='sf-link o-swype-item__link']//span[contains(text(),'Електричні зубні щітки')]")
    private static WebElement electricToothbrushes;

    public SelfСarePage() {
        super(driver);
    }

    public WebElement getElectricToothbrushes() {
        return electricToothbrushes;
    }

    public boolean isElectricToothbrushesVisible() {
        return electricToothbrushes.isDisplayed();

    }

    public void clickElectricToothbrushesPage() {
        electricToothbrushes.click();
    }
}
