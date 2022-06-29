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
    private final static String specialCharacters = "!»№;%:?*()_+.,}{}[];:’”`~";
    private final static String registerLogin = "NaaaAaaa";
    private final static String registerPassword = "troLLivalli";
    private final static String translitLogin = "Naaaaaaа";
    private final static String translitPassword = "trollivаlli";
    private final static String sqlInjection = "a’ OR 1=1;--";




    @Test
    public void checkAutoValidData() {
        LoginPage loginPage = new LoginPage(Url);
        loginPage.validLogin(login);
        loginPage.validPassword(password);
        loginPage.cliclInputButton();
        MainPage mainPage = new MainPage();
        mainPage.checkUserTag();
    }

    @Test
    public void checkAutoNotValidData() {
        LoginPage loginPage = new LoginPage(Url);
        loginPage.validLogin(falseLogin);
        loginPage.validPassword(falsePassword);
        loginPage.cliclInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkErrorMassage();

    }

    @Test
    public void checkNotValidOne(){
        LoginPage loginPage = new LoginPage(Url);
        loginPage.validLogin(login);
        loginPage.validPassword(falsePassword);
        loginPage.cliclInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkErrorMassage();

    }

    @Test
    public void spaceAfter() {
        LoginPage loginPage = new LoginPage(Url);
        loginPage.validLogin(login + " ");
        loginPage.validPassword(password + " ");
        loginPage.cliclInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkErrorMassage();
    }

    @Test
    public void spaceBefoe() {
        LoginPage loginPage = new LoginPage(Url);
        loginPage.validLogin(" " + login);
        loginPage.validPassword(" " + password);
        loginPage.cliclInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkErrorMassage();
    }

    @Test
    public void specChar(){
        LoginPage loginPage = new LoginPage(Url);
        loginPage.validLogin(specialCharacters);
        loginPage.validPassword(specialCharacters);
        loginPage.cliclInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkErrorMassage();
    }

    @Test
    public void registerLogin(){
        LoginPage loginPage = new LoginPage(Url);
        loginPage.validLogin(registerLogin);
        loginPage.validPassword(password);
        loginPage.cliclInputButton();
        MainPage mainPage = new MainPage();
        mainPage.checkUserTag();

    }

    @Test
    public void registerPassword(){
        LoginPage loginPage = new LoginPage(Url);
        loginPage.validLogin(login);
        loginPage.validPassword(registerPassword);
        loginPage.cliclInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkErrorMassage();
    }

    @Test
    public void emptyInput(){
        LoginPage loginPage = new LoginPage(Url);
        loginPage.cliclInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkFindfMe();

    }

    @Test
    public void oneOfIsEmpty(){
        LoginPage loginPage = new LoginPage(Url);
        loginPage.validLogin(login);
        loginPage.cliclInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkFindfMe();
    }

    @Test
    public void translitLogin(){
        LoginPage loginPage = new LoginPage(Url);
        loginPage.validLogin(translitLogin);
        loginPage.validPassword(password);
        loginPage.cliclInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkErrorMassage();
    }

    @Test
    public void translitPassword(){
        LoginPage loginPage = new LoginPage(Url);
        loginPage.validLogin(login);
        loginPage.validPassword(translitPassword);
        loginPage.cliclInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkErrorMassage();
    }

    @Test
    public void sqlInjection(){
        LoginPage loginPage = new LoginPage(Url);
        loginPage.validLogin(sqlInjection);
        loginPage.validPassword(password);
        loginPage.cliclInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkErrorMassage();
    }








}










