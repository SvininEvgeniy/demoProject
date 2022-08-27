package logInTests;

import baseTests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void successfulLogIn() {
        var basicAuthPage = mainPage.clickBasicAuthLink();
        basicAuthPage.logIn();
        Assert.assertEquals(basicAuthPage.getTextFromCongratulationMessage(),
                "Congratulations! You must have the proper credentials.");
    }
}
