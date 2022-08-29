package properties;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {
    //for reading properties
    Config config = readConfig();

    static Config readConfig() {
        return ConfigFactory.load("application.conf");
    }

    String URL = readConfig().getString("url");
    String USERNAME = readConfig().getString("username");
    String INVALIDUSERNAME = readConfig().getString("invalidUsername");
    String PASSWORD = readConfig().getString("password");
    String expectedMessageAfterLogIn = readConfig().getString("messages.congratulationMessageAfterLogIn");
    String expectedMessageAfterInvalidUsername = readConfig().getString("messages.messageAfterInvalidUsername");
}
