package lichessTest;

import core.BaseTest;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static lichessTest.Storage.*;
public class LichessTest extends BaseTest {
    LoginPage loginPage = new LoginPage(Url);
    public String randomString = RandomStringUtils.randomAlphanumeric(10);
   /* @DisplayName("Проверка отображения текста ошибки при вводе не валидных данных")
    @ParameterizedTest(name = "Iteration #{index} -> Логин = {0}, Пароль = {1} ")
    @CsvSource({"banana,      qwerty123",
            "Naaaaaaa,       ' trollivalli'",
            "Naaaaaaa,        qwerty123",
            "banana,         trollivalli",
            "'Naaaaaaa ',    trollivalli",
            "Naaaaaaa,      'trollivalli '",
            "' Naaaaaaa',    trollivalli",
            "!»№;%:?*()_+.,}{}[];:’”`~, trollivalli",
            "Naaaaaaa,        troLLivalli",
            "Naaaaaaа,        troLLivalli",
            "Naaaaaaa,        trollivаlli",
            "a’ OR 1=1;--,    trollivalli",
    })
    public void paramTest(String param,String param1){
        loginPage.setValueLogin(param);
        loginPage.setValuePassword(param1);
        loginPage.clickInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkErrorMassage();
    }*/
    @Tag("puper")
    @DisplayName("Авторизация валидными данными")
    @Test
    public void checkAutoValidData() {
        loginPage.setValueLogin(login);
        loginPage.setValuePassword(password);
        loginPage.clickInputButton();
        MainPage mainPage = new MainPage();
        mainPage.checkUserTag();
    }
    @Tag("super")
    @DisplayName("Авторизация невалидными данными")
    @Test
    public void checkAutoNotValidData() {
        loginPage.setValueLogin(randomString);
        loginPage.setValuePassword(randomString);
        loginPage.clickInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkErrorMassage();
    }
    @Tag("super")
    @DisplayName("Неверный пароль")
    @Test
    public void checkNotValidOneP(){
        loginPage.setValueLogin(login);
        loginPage.setValuePassword(randomString);
        loginPage.clickInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkErrorMassage();
    }
    @Tag("super")
    @DisplayName("Неверный логин")
    @Test
    public void checkNotValidLogin() {
        loginPage.setValueLogin(randomString);
        loginPage.setValuePassword(password);
        loginPage.clickInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkErrorMassage();
    }
    @Tag("super")
    @DisplayName("Пробел после логина")
    @Test
    public void spaceAfterLogin() {
        loginPage.setValueLogin(login + " ");
        loginPage.setValuePassword(password);
        loginPage.clickInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkErrorMassage();
    }
    @Tag("super")
    @DisplayName("Пробел после пароля")
    @Test
    public void spaceAfterPassword() {
        loginPage.setValueLogin(login);
        loginPage.setValuePassword(password + " ");
        loginPage.clickInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkErrorMassage();
    }
    @Tag("super")
    @DisplayName("Пробел до логина")
    @Test
    public void spaceBeforeLogin() {
        loginPage.setValueLogin(" " + login);
        loginPage.setValuePassword(password);
        loginPage.clickInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkErrorMassage();
    }
    @Tag("super")
    @DisplayName("Пробел до пароля")
    @Test
    public void spaceBeforePassword() {
        loginPage.setValueLogin(login);
        loginPage.setValuePassword(" " + password);
        loginPage.clickInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkErrorMassage();
    }
    @Tag("super")
    @DisplayName("Спец символы")
    @Test
    public void specChar(){
        loginPage.setValueLogin(specialCharacters);
        loginPage.setValuePassword(specialCharacters);
        loginPage.clickInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkErrorMassage();
    }
    @Tag("puper")
    @DisplayName("Чувствительность логина к регистру")
    @Test
    public void registerLogin(){
        loginPage.setValueLogin(registerLogin);
        loginPage.setValuePassword(password);
        loginPage.clickInputButton();
        MainPage mainPage = new MainPage();
        mainPage.checkUserTag();
    }
    @Tag("super")
    @DisplayName("Чувствительность пароля к регистру")
    @Test
    public void registerPassword(){
        loginPage.setValueLogin(login);
        loginPage.setValuePassword(registerPassword);
        loginPage.clickInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkErrorMassage();
    }
    @Tag("super")
    @DisplayName("Пустой ввод")
    @Test
    public void emptyInput(){
        loginPage.clickInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkFindfMe();
    }
    @Tag("super")
    @DisplayName("Пустой ввод-пароль")
    @Test
    public void oneOfIsEmptyPassword(){
        loginPage.setValueLogin(login);
        loginPage.clickInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkFindfMe();
    }
    @Tag("super")
    @DisplayName("Пустой ввод-логин")
    @Test
    public void oneOfIsEmptyLogin(){
        loginPage.setValuePassword(password);
        loginPage.clickInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkFindfMe();
    }
    @Tag("super")
    @DisplayName("Чувствительность к транслиту-логин")
    @Test
    public void translitLogin(){
        loginPage.setValueLogin(translitLogin);
        loginPage.setValuePassword(password);
        loginPage.clickInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkErrorMassage();
    }
    @Tag("super")
    @DisplayName("Чувствительность к транслиту-пароль")
    @Test
    public void translitPassword(){
        loginPage.setValueLogin(login);
        loginPage.setValuePassword(translitPassword);
        loginPage.clickInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkErrorMassage();
    }@Tag("super")
    @DisplayName("SQL иньекция логин")
    @Test
    public void sqlInjection(){
        loginPage.setValueLogin(sqlInjection);
        loginPage.setValuePassword(password);
        loginPage.clickInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkErrorMassage();
    }
}










