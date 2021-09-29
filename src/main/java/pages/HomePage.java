package pages;

import config.BaseData;
import driver.WebDriverBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private static WebDriver driver = WebDriverBase.getDriver();

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public static final String USERNAME_INPUT = "//input[@placeholder='Username']";
    public static final String PASSWORD_INPUT = "//input[@placeholder='Password']";

    @FindBy(xpath = USERNAME_INPUT)
    private WebElement usernameInput;

    @FindBy(xpath = PASSWORD_INPUT)
    private WebElement passwordInput;

    public void openHomePage() {
        driver.navigate().to(BaseData.SWAG);
    }

    public MainPage login(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        passwordInput.submit();
        return new MainPage();
    }
}
