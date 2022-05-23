package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CalvinKleinPage extends BasePage {
    public CalvinKleinPage(WebDriver driver) {
        super(driver);
    }

    @FindAll(@FindBy(xpath = "//a[@class='sf-link product__link product__name']"))
    private List<WebElement> calvinKleinProducts;

    @FindBy(xpath = "//h1[@class='page-title__label']")
    private WebElement calvinKleinTitle;

    public WebElement getCalvinKleinTitle() {
        return calvinKleinTitle;
    }

    public List<WebElement> getCalvinKleinProducts() {
        return calvinKleinProducts;
    }

    private int productsSize;

    public int getCalvinClineProductsSize() {
        productsSize = getCalvinKleinProducts().size();
        return productsSize;
    }
}
