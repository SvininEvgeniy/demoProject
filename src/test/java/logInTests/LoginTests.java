package logInTests;

import baseTests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import properties.ConfigProvider;

public class LoginTests extends BaseTest {

    @Test
    public void successfulLogIn() {
        var basicAuthPage = mainPage.clickBasicAuthLink();
        basicAuthPage.logIn();
        String expectedResult = ConfigProvider.expectedCongratulationMessage;
        Assert.assertEquals(basicAuthPage.getTextFromCongratulationMessage(),
                expectedResult);
    }
}
