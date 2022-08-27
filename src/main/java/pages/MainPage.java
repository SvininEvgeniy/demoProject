package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private WebDriver driver;
    private By basicAuthLink = By.xpath("//a[contains(@href, 'basic_auth')]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public BasicAuthPage clickBasicAuthLink() {
        driver.findElement(basicAuthLink).click();
        return new BasicAuthPage(driver);
    }
}
