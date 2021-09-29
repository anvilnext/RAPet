package pages;

import driver.WebDriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.String.format;

public class MainPage {

    private static WebDriver driver = WebDriverBase.getDriver();

    public MainPage() {
        PageFactory.initElements(driver, this);
    }

    public static final String ADD_TO_CART_BUTTON = "//div[@class='inventory_item_name'][text()='%s']//ancestor::div[@class='inventory_item']//button";
    public static final String SHOPPING_CART_LABEL = "//a[@class='shopping_cart_link']";

    @FindBy(xpath = ADD_TO_CART_BUTTON)
    private WebElement addToCartButton;

    @FindBy(xpath = SHOPPING_CART_LABEL)
    private WebElement shoppingCartLabel;

    public void addToCart(String product) {
        driver.findElement(By.xpath(format(ADD_TO_CART_BUTTON, product))).click();
    }

    public ShoppingCartPage openShoppingCart() {
        shoppingCartLabel.click();
        return new ShoppingCartPage();
    }

    public boolean checkUrlOnMainPage(String ending) {
        return driver.getCurrentUrl().endsWith(ending);
    }
}
