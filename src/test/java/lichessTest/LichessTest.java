package lichessTest;

import core.BaseTest;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import static lichessTest.Storage.*;

@DisplayName(value = "Тесты для формы авторизации lichess.org")
public class LichessTest extends BaseTest {
   @BeforeAll
   static void prepareLoginPage() {
       LoginPage loginPage = new LoginPage(Url);
   }
    LoginPage loginPage = new LoginPage(Url);

    @DisplayName(value = "Авторизация валидными данными")
    @Test
    public void checkAutoValidData() {
        loginPage.setValueLogin(login);
        loginPage.setValuePassword(password);
        loginPage.clickInputButton();
        MainPage mainPage = new MainPage();
        mainPage.checkUserTag();
    }
    @DisplayName(value = "Авторизация невалидными данными")
    @Test
    public void checkAutoNotValidData() {
        loginPage.setValueLogin(randomString);
        loginPage.setValuePassword(randomString);
        loginPage.clickInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkErrorMassage();
    }
    @DisplayName(value = "Неверный пароль")
    @Test
    public void checkNotValidOneP(){
        loginPage.setValueLogin(login);
        loginPage.setValuePassword(randomString);
        loginPage.clickInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkErrorMassage();
    }
    @DisplayName(value = "Неверный логин")
    @Test
    public void checkNotValidLogin() {
        loginPage.setValueLogin(randomString);
        loginPage.setValuePassword(password);
        loginPage.clickInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkErrorMassage();
    }
    @DisplayName(value = "Пробел после логина")
    @Test
    public void spaceAfterLogin() {
        loginPage.setValueLogin(login + " ");
        loginPage.setValuePassword(password);
        loginPage.clickInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkErrorMassage();
    }
    @DisplayName(value = "Пробел после пароля")
    @Test
    public void spaceAfterPassword() {
        loginPage.setValueLogin(login);
        loginPage.setValuePassword(password + " ");
        loginPage.clickInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkErrorMassage();
    }
    @DisplayName(value = "Пробел до логина")
    @Test
    public void spaceBeforeLogin() {
        loginPage.setValueLogin(" " + login);
        loginPage.setValuePassword(password);
        loginPage.clickInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkErrorMassage();
    }
    @DisplayName(value = "Пробел до пароля")
    @Test
    public void spaceBeforePassword() {
        loginPage.setValueLogin(login);
        loginPage.setValuePassword(" " + password);
        loginPage.clickInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkErrorMassage();
    }
    @DisplayName(value = "Спец символы")
    @Test
    public void specChar(){
        loginPage.setValueLogin(specialCharacters);
        loginPage.setValuePassword(specialCharacters);
        loginPage.clickInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkErrorMassage();
    }
    @DisplayName(value = "Чувствительность логина к регистру")
    @Test
    public void registerLogin(){
        loginPage.setValueLogin(registerLogin);
        loginPage.setValuePassword(password);
        loginPage.clickInputButton();
        MainPage mainPage = new MainPage();
        mainPage.checkUserTag();
    }
    @DisplayName(value = "Чувствительность пароля к регистру")
    @Test
    public void registerPassword(){
        loginPage.setValueLogin(login);
        loginPage.setValuePassword(registerPassword);
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
        loginPage.setValueLogin(login);
        loginPage.clickInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkFindfMe();
    }
    @DisplayName(value = "Пустой ввод-логин")
    @Test
    public void oneOfIsEmptyLogin(){
        loginPage.setValuePassword(password);
        loginPage.clickInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkFindfMe();
    }
    @DisplayName(value = "Чувствительность к транслиту-логин")
    @Test
    public void translitLogin(){
        loginPage.setValueLogin(translitLogin);
        loginPage.setValuePassword(password);
        loginPage.clickInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkErrorMassage();
    }
    @DisplayName(value = "Чувствительность к транслиту-пароль")
    @Test
    public void translitPassword(){
        loginPage.setValueLogin(login);
        loginPage.setValuePassword(translitPassword);
        loginPage.clickInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkErrorMassage();
    }
    @DisplayName(value = "SQL иньекция логин")
    @Test
    public void sqlInjection(){
        loginPage.setValueLogin(sqlInjection);
        loginPage.setValuePassword(password);
        loginPage.clickInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkErrorMassage();
    }
}










