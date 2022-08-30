package alertsTests;

import baseTests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import properties.ConfigProvider;

public class AlertsTests extends BaseTest {

    @Test
    public void successfulAcceptAlertTest() {
        var alertsPage = mainPage.clickAlertsLink();
        alertsPage.acceptAlert();
        String expectedResult = ConfigProvider.expectedMessageAfterAcceptAlert;
        Assert.assertEquals(alertsPage.getTextFromResultMessage(), expectedResult);
    }

    @Test
    public void successfulCancelConfirmTest() {
        var alertsPage = mainPage.clickAlertsLink();
        alertsPage.cancelConfirm();
        String expectedResult = ConfigProvider.expectedMessageAfterCancelConfirm;
        Assert.assertEquals(alertsPage.getTextFromResultMessage(), expectedResult);
    }
}
