package steps;

import driver.WebDriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BaseSteps {

    private static WebDriver driver = WebDriverBase.getDriver();

    public static void maximizeDriver() {
        driver.manage().window().maximize();
    }

    public static void openPage(String url) {
        driver.navigate().to(url);
    }

    public static boolean checkPageUrlEnding(String ending) {
        return driver.getCurrentUrl().endsWith(ending);
    }

    public static WebElement getElement(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    public static List<WebElement> getElements(String xpath) {
        return driver.findElements(By.xpath(xpath));
    }

    public static void quitDriver() {
        driver.quit();
    }
}
