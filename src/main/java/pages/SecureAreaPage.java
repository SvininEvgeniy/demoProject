package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class SecureAreaPage {

    private WebDriver driver;
    private By congratulationMessage = By.className("subheader");
    private By logOutButton = By.cssSelector("a[class*='button']");

    public SecureAreaPage(WebDriver driver) {
        this.driver = driver;
    }

    // using FluentWait class for downloading contents
    public String getTextFromCongratulationMessage() {
        FluentWait fluentWait = new FluentWait(driver).withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(congratulationMessage));

        return driver.findElement(congratulationMessage).getText();
    }

    public LoginPage logOut() {
        driver.findElement(logOutButton).click();
        return new LoginPage(driver);
    }
}
