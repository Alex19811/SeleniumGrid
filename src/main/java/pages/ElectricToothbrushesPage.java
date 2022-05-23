package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class ElectricToothbrushesPage extends BasePage {

    public ElectricToothbrushesPage() {
        super(driver);
    }

    @FindAll(@FindBy(xpath = "//div[@class='products']//div[@class='product__wrapper']"))
    private List<WebElement> allProducts;

    @FindBy(xpath = "//span[@class='product__regular-price']")
    private WebElement productOldPrice;

    @FindBy(xpath = "//a[@class='sf-link product__link product__name']")
    private WebElement productName;

    private int getQuantityOfAllProducts() {
        return allProducts.size();
    }

    private int getRandomProductNumber() {
        int min = 0;
        int max = getQuantityOfAllProducts() - 1;
        return new Random().nextInt(max - min + 1) + min;
    }

    public boolean isRandomProductNotHavePromo() {
        int random = getRandomProductNumber();
        try {
            WebElement webElement = allProducts.get(random);
            WebElement element = webElement.findElement(By.xpath("//span[@class='product__regular-price']"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}

