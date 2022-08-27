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
    String LOGIN = readConfig().getString("login");
    String PASSWORD = readConfig().getString("password");
    String expectedCongratulationMessage = readConfig().getString("messages.congratulationMessageAfterLogIn");
}
