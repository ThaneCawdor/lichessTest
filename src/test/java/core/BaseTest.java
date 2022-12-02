package core;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

abstract public class BaseTest {
   public static void setUp() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
    }
    @BeforeEach
    void init(){
        setUp();
    }
    @AfterEach
    void tearDown(){
        Allure.getLifecycle().addAttachment("screenshot","image/png","png",((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES));
        Selenide.closeWebDriver();
    }
}