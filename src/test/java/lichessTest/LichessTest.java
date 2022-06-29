package lichessTest;
import com.codeborne.selenide.SelenideElement;
import core.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static org.awaitility.Awaitility.await;

public class LichessTest extends BaseTest {


    private final static String Url = "https://lichess.org/login?referrer=/";
    private final static String login = "Naaaaaaa";
    private final static String password = "trollivalli";
    private final static String falseLogin = "Buonapart91@mail.ru";
    private final static String falsePassword = "131313";


    @Test
    public void checkAutoValidData() {
        LoginPage loginPage = new LoginPage(Url);
        loginPage.validLogin(login);
        loginPage.validPassword(password);
        loginPage.cliclInputButton();
        MainPage mainPage = new MainPage();
        mainPage.checkClick();
    }

    @Test
    public void checkAutoNotValidData() {
        LoginPage loginPage = new LoginPage(Url);
        loginPage.validLogin(falseLogin);
        loginPage.validPassword(falsePassword);
        loginPage.cliclInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        $("p.error").shouldBe(visible);
        boolean x = unsuccesLoginPage.checkErrorMassage();
        Assert.assertTrue(x);
    }

    @Test
    public void spaceAfter() {
        LoginPage loginPage = new LoginPage(Url);
        loginPage.validLogin(login + " ");
        loginPage.validPassword(password + " ");
        loginPage.cliclInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        $("p.error").shouldBe(visible);
        boolean x = unsuccesLoginPage.checkErrorMassage();
        Assert.assertTrue(x);
    }

    @Test
    public void spaceBefoe() {
        LoginPage loginPage = new LoginPage(Url);
        loginPage.validLogin(" " + login);
        loginPage.validPassword(" " + password);
        loginPage.cliclInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        $("p.error").shouldBe(visible);
        boolean y = unsuccesLoginPage.checkErrorMassage();
        Assert.assertTrue(y);
    }


}
//@Test









