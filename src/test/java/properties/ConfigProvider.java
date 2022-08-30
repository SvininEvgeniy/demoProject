package properties;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {
    //for reading properties
    Config config = readConfig();

    static Config readConfig() {
        return ConfigFactory.load("application.conf");
    }

    //сделать отдельный метод, который читает, получает строку и записывает
    String URL = readConfig().getString("url");
    String USERNAME = readConfig().getString("username");
    String INVALIDUSERNAME = readConfig().getString("invalidUsername");
    String PASSWORD = readConfig().getString("password");
    String INVALIDPASSWORD = readConfig().getString("invalidPassword");
    String expectedMessageAfterLogIn = readConfig().getString("messages.congratulationMessageAfterLogIn");
    String expectedMessageAfterLogOut = readConfig().getString("messages.congratulationMessageAfterLogOut");
    String expectedMessageAfterInvalidUsername = readConfig().getString("messages.messageAfterInvalidUsername");
    String expectedMessageAfterInvalidPassword = readConfig().getString("messages.messageAfterInvalidPassword");
    String expectedMessageAfterAcceptAlert = readConfig().getString("messages.messageAfterAcceptAlert");
    String expectedMessageAfterCancelConfirm = readConfig().getString("messages.messageAfterCancelConfirm");
}
