package com.alexandrov.tests;

import com.alexandrov.config.CredentialsConfig;
import com.alexandrov.helpers.Attach;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static java.lang.String.format;

public class TestBase {

    public static CredentialsConfig credentials = ConfigFactory.create(CredentialsConfig.class);

    @BeforeAll
    static void beforeAll() {

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        String login = credentials.login();
        String password = credentials.password();
        String browserURL = System.getProperty("url", credentials.browserURL());
        String browser = System.getProperty("browser", "chrome");
        String browserSize = System.getProperty("browserSize", "716x505");
        String browserVersion = System.getProperty("browserVersion");

        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = browser;
        Configuration.browserSize = browserSize;
        Configuration.browserVersion = browserVersion;
        Configuration.remote = format("https://%s:%s@%s", login, password, browserURL);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC",true);
        capabilities.setCapability("enableVideo",true);
        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void addAttachments () {
        Attach.screenshotAs("Screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}

