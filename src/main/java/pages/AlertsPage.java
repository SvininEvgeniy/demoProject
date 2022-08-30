package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage {

    private WebDriver driver;
    private By alertButton = By.xpath("//button[@onclick='jsAlert()']");
    private By confirmButton = By.xpath("//button[@onclick='jsConfirm()']");
    private By promptButton = By.xpath("//button[@onclick='jsPrompt()']");
    private By resultMessage = By.id("result");

    public AlertsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnButton(By locator) {
        driver.findElement(locator).click();
    }

    public void acceptAlert() {
        clickOnButton(alertButton);
        driver.switchTo().alert().accept();
    }

    public void cancelConfirm() {
        clickOnButton(confirmButton);
        driver.switchTo().alert().dismiss();
    }

    public String getTextFromResultMessage() {
        return driver.findElement(resultMessage).getText();
    }
}
