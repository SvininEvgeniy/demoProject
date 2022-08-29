package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private WebDriver driver;
    private By formAuthenticationLink = By.xpath("//a[contains(@href, 'login')]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage clickFormAuthenticationLink() {
        driver.findElement(formAuthenticationLink).click();
        return new LoginPage(driver);
    }
}
