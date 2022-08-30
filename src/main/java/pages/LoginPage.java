package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.className("radius");
    private By errorMessage = By.id("flash");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void sendKeysToLogIn(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
    }

    public SecureAreaPage logIn(String username, String password) {
        sendKeysToLogIn(username, password);
        driver.findElement(loginButton).click();
        return new SecureAreaPage(driver);
    }

    public void incorrectLogIn(String invalidUsername, String password) {
        sendKeysToLogIn(invalidUsername, password);
        driver.findElement(loginButton).click();
    }

    public Boolean hasTextFromMessage(String expectedMessage) {
        return driver.findElement(errorMessage).getText().contains(expectedMessage);
    }

}
