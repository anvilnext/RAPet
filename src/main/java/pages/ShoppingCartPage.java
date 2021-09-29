package pages;

import driver.WebDriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.String.format;

public class ShoppingCartPage {

    private static WebDriver driver = WebDriverBase.getDriver();

    public ShoppingCartPage() {
        PageFactory.initElements(driver, this);
    }

    public static final String SHOPPING_CART_ITEM_LABEL = "//div[@class='inventory_item_name'][text()='%s']";

    @FindBy(xpath = SHOPPING_CART_ITEM_LABEL)
    private WebElement shoppingCartItemLabel;

    public boolean checkProductIsInCart(String product) {
        return driver.findElement(By.xpath(format(SHOPPING_CART_ITEM_LABEL, product))).isDisplayed();
    }
}
