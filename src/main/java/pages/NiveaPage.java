package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NiveaPage extends BasePage {

    public NiveaPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[contains(text(),'Косметика Nivea')]")
    private static WebElement niveaTitle;

    public NiveaPage() {
        super(driver);
    }

    public WebElement getNiveaTitle() {
        return niveaTitle;
    }

    private String niveaPageTitle;

    public String getTextNiveaPageTitle() {
        niveaPageTitle = niveaTitle.getText();
        return niveaPageTitle;
    }
}
