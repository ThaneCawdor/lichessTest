package lichessTest;
import core.BaseTest;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
@DisplayName(value = "Тесты для формы авторизации lichess.org")
public class LichessTest extends BaseTest {
    public final static String Url = "https://lichess.org/login?referrer=/";
    private final static String login = "Naaaaaaa";
    private final static String password = "trollivalli";
    private final static String falseLogin = "Buonapart91@mail.sru";
    private final static String falsePassword = "131313";
    private final static String specialCharacters = "!»№;%:?*()_+.,}{}[];:’”`~";
    private final static String registerLogin = "NaaaAaaa";
    private final static String registerPassword = "troLLivalli";
    private final static String translitLogin = "Naaaaaaа";
    private final static String translitPassword = "trollivаlli";
    private final static String sqlInjection = "a’ OR 1=1;--";
    LoginPage loginPage = new LoginPage(Url);
   @BeforeAll
   static void prepareLogin(){
        LoginPage loginPage = new LoginPage(Url);
    }
    /*@ParameterizedTest
    @ValueSource({"Naaaaaaa","trollivalli","Buonapart91@mail.ru","131313"})
    public void pushInBox(){
       loginPage.
       loginPage.
    }*/
    @DisplayName(value = "Авторизация валидными данными")
    @Test
    public void checkAutoValidData() {
        loginPage.validLogin(login);
        loginPage.validPassword(password);
        loginPage.clickInputButton();
        MainPage mainPage = new MainPage();
        mainPage.checkUserTag();
    }
    @DisplayName(value = "Авторизация невалидными данными")
    @Test
    public void checkAutoNotValidData() {
        loginPage.validLogin(falseLogin);
        loginPage.validPassword(falsePassword);
        loginPage.clickInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkErrorMassage();
    }
    @DisplayName(value = "Неверный пароль")
    @Test
    public void checkNotValidOneP(){
        loginPage.validLogin(login);
        loginPage.validPassword(falsePassword);
        loginPage.clickInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkErrorMassage();
    }
    @DisplayName(value = "Неверный логин")
    @Test
    public void checkNotValidLogin() {
        loginPage.validLogin(falseLogin);
        loginPage.validPassword(password);
        loginPage.clickInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkErrorMassage();
    }
    @DisplayName(value = "Пробел после логина")
    @Test
    public void spaceAfterLogin() {
        loginPage.validLogin(login + " ");
        loginPage.validPassword(password);
        loginPage.clickInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkErrorMassage();
    }
    @DisplayName(value = "Пробел после пароля")
    @Test
    public void spaceAfterPassword() {
        loginPage.validLogin(login);
        loginPage.validPassword(password + " ");
        loginPage.clickInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkErrorMassage();
    }
    @DisplayName(value = "Пробел до логина")
    @Test
    public void spaceBeforeLogin() {
        loginPage.validLogin(" " + login);
        loginPage.validPassword(password);
        loginPage.clickInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkErrorMassage();
    }
    @DisplayName(value = "Пробел до пароля")
    @Test
    public void spaceBeforePassword() {
        loginPage.validLogin(login);
        loginPage.validPassword(" " + password);
        loginPage.clickInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkErrorMassage();
    }
    @DisplayName(value = "Спец символы")
    @Test
    public void specChar(){
        loginPage.validLogin(specialCharacters);
        loginPage.validPassword(specialCharacters);
        loginPage.clickInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkErrorMassage();
    }
    @DisplayName(value = "Чувствительность логина к регистру")
    @Test
    public void registerLogin(){
        loginPage.validLogin(registerLogin);
        loginPage.validPassword(password);
        loginPage.clickInputButton();
        MainPage mainPage = new MainPage();
        mainPage.checkUserTag();
    }
    @DisplayName(value = "Чувствительность пароля к регистру")
    @Test
    public void registerPassword(){
        loginPage.validLogin(login);
        loginPage.validPassword(registerPassword);
        loginPage.clickInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkErrorMassage();
    }
    @DisplayName(value = "Пустой ввод")
    @Test
    public void emptyInput(){
        loginPage.clickInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkFindfMe();
    }
    @DisplayName(value = "Пустой ввод-пароль")
    @Test
    public void oneOfIsEmptyPassword(){
        loginPage.validLogin(login);
        loginPage.clickInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkFindfMe();
    }
    @DisplayName(value = "Пустой ввод-логин")
    @Test
    public void oneOfIsEmptyLogin(){
        loginPage.validPassword(password);
        loginPage.clickInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkFindfMe();
    }
    @DisplayName(value = "Чувствительность к транслиту-логин")
    @Test
    public void translitLogin(){
        loginPage.validLogin(translitLogin);
        loginPage.validPassword(password);
        loginPage.clickInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkErrorMassage();
    }
    @DisplayName(value = "Чувствительность к транслиту-пароль")
    @Test
    public void translitPassword(){
        loginPage.validLogin(login);
        loginPage.validPassword(translitPassword);
        loginPage.clickInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkErrorMassage();
    }
    @DisplayName(value = "SQL иньекция логин")
    @Test
    public void sqlInjection(){
        loginPage.validLogin(sqlInjection);
        loginPage.validPassword(password);
        loginPage.clickInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkErrorMassage();
    }
}










