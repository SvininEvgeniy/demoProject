package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private WebDriver driver;
    private By formAuthenticationLink = By.xpath("//a[contains(@href, 'login')]");
    private By alertsPageLink = By.xpath("//a[contains(@href, 'javascript_alerts')]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //написать метод, который будет универсальный для клика и перехода на новую страницу с главной
    public LoginPage clickFormAuthenticationLink() {
        driver.findElement(formAuthenticationLink).click();
        return new LoginPage(driver);
    }

    public AlertsPage clickAlertsLink() {
        driver.findElement(alertsPageLink).click();
        return new AlertsPage(driver);
    }
}
