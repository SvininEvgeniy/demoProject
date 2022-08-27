package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class BasicAuthPage {

    private WebDriver driver;
    private By congratulationMessage = By.cssSelector("div#content p");
    private final String USERNAME = "admin";
    private final String PASSWORD = "admin";

    public BasicAuthPage(WebDriver driver) {
        this.driver = driver;
    }

    //переработать метод логина, т.к. нужно использовать ConfigProvider
    public void logIn() {
       String url = "https://" + USERNAME +":" + PASSWORD +"@"+ "the-internet.herokuapp.com/basic_auth";
       driver.get(url);
    }

    // using FluentWait class for downloading contents
    public String getTextFromCongratulationMessage() {
        FluentWait fluentWait = new FluentWait(driver).withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(congratulationMessage));

        return driver.findElement(congratulationMessage).getText();
    }
}
