package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HairShampoosPage extends BasePage {
    public HairShampoosPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[contains(text(),'Acme')]")
    private static WebElement acmeButton;

    @FindBy(xpath = "//h1[contains(text(),'Шампуні, бальзами, кондиціонери для волосся Acme')]")
    private WebElement acmeTitle;

    @FindAll(@FindBy(xpath = "//a[@class='sf-link product__link product__name']"))
    private List<WebElement> acmeProducts;

    public boolean isAcmeButtonVisibility() {
        return acmeButton.isDisplayed();
    }

    public void clickAcmeButtonPage() {
        acmeButton.click();
    }

    public WebElement getAcmeTitle() {
        return acmeTitle;
    }

    public List<WebElement> getAcmeProducts() {
        return acmeProducts;
    }

    int acmeProductsSize;

    public int getAcmeProductsSize() {
        acmeProductsSize = getAcmeProducts().size();
        return acmeProductsSize;
    }
}
