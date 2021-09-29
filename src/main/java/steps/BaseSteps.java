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

    public static void quitDriver() {
        driver.quit();
    }
}
