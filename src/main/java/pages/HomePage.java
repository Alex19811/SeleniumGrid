package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='sf-o-header__actions']//div[@class='sf-image']")
    private static WebElement header;

    @FindBy(xpath = "//span[contains(text(),'Догляд за собою')]")
    private static WebElement personalCare;

    @FindBy(xpath = "//input[@type='search']")
    private static WebElement searchInput;

    @FindBy(xpath = "//button[@title='evaріанти']")
    private static WebElement searchButton;

    @FindBy(xpath = "//span[contains(text(),'Шампуні для волосся')]")
    private static WebElement hairShampoosButton;

    @FindBy(xpath = "//span[contains(text(),'Бренди')]")
    private static WebElement brandsButton;

    @FindBy(xpath = "//a[@href='/ua/brnd-72884/']")
    private static WebElement calvinKleinButton;

    public boolean isHeaderVisibility() {
        return header.isDisplayed();
    }

    public boolean isPersonalСareVisibility() {
        return personalCare.isDisplayed();
    }

    public void clickPersonalСarePage() {
        personalCare.click();
    }

    public boolean isSearchInputVisibility() {
        return searchInput.isDisplayed();
    }

    public boolean isSearchButtonVisibility() {
        return searchButton.isDisplayed();
    }

    public void searchByKeyword(final String keyword) {
        searchInput.sendKeys(keyword);
        searchButton.click();
    }

    public boolean isHairShampoosVisibility() {
        return hairShampoosButton.isDisplayed();
    }

    public void clickHairShampoosPage() {
        hairShampoosButton.click();
    }


    public boolean isBrandsVisibility() {
        return brandsButton.isDisplayed();
    }

    public void clickBrands() {
        brandsButton.click();
    }

    public WebElement getCalvinKleinButton() {
        return calvinKleinButton;
    }

    public void clickCalvinKleinPage() {
        calvinKleinButton.click();
    }

}
