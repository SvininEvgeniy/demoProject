package baseTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.MainPage;

import java.time.Duration;

public abstract class BaseTest {

    private WebDriver driver;
    protected MainPage mainPage;

    //setting chromedriver before each test classes
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        goMainPage();
    }

    //go to main page before each test methods
    @BeforeMethod
    public void goMainPage() {
        driver.get("https://the-internet.herokuapp.com/");
        mainPage = new MainPage(driver);
    }

    //closing all browser tabs and terminating driver session after each test classes
    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    /*public void waitElement(WebElement element) {
        FluentWait fluentWait = new FluentWait(driver).withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        fluentWait.until(ExpectedConditions.visibilityOfElementLocated();
    }*/
    // пока не врубаюсь как сделать так, чтобы этот метод был универсальным,
    // в visibilityOfElementLocated требуется тип данных By
}
