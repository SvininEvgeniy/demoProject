package logInTests;

import baseTests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import properties.ConfigProvider;

public class LoginTests extends BaseTest {

    @Test
    public void successfulLogInTest() {
        var secureAreaPage = mainPage.clickFormAuthenticationLink()
                .logIn(ConfigProvider.USERNAME, ConfigProvider.PASSWORD);
        String expectedResult = ConfigProvider.expectedMessageAfterLogIn;
        Assert.assertEquals(secureAreaPage.getTextFromCongratulationMessage(),
                expectedResult);
    }

    @Test
    public void successfulLogOutTest() {
        var secureAreaPage = mainPage.clickFormAuthenticationLink()
                .logIn(ConfigProvider.USERNAME, ConfigProvider.PASSWORD);
        var loginPage = secureAreaPage.logOut();
        String expectedResult = ConfigProvider.expectedMessageAfterLogOut;
        Assert.assertTrue(loginPage.hasTextFromMessage(expectedResult));
    }

    @Test
    public void invalidUsernameLogInTest() {
        var loginPage = mainPage.clickFormAuthenticationLink();
        loginPage.incorrectLogIn(ConfigProvider.INVALIDUSERNAME,
                ConfigProvider.PASSWORD);
        String expectedResult = ConfigProvider.expectedMessageAfterInvalidUsername;
        Assert.assertTrue(loginPage.hasTextFromMessage(expectedResult));
    }

    @Test
    public void invalidPasswordLogInTest() {
        var loginPage = mainPage.clickFormAuthenticationLink();
        loginPage.incorrectLogIn(ConfigProvider.USERNAME,
                ConfigProvider.INVALIDPASSWORD);
        String expectedResult = ConfigProvider.expectedMessageAfterInvalidPassword;
        Assert.assertTrue(loginPage.hasTextFromMessage(expectedResult));
    }
}
