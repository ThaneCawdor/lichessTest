package lichessTest;

import core.BaseTest;
import io.qameta.allure.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static lichessTest.Storage.*;

@Epic("UI тесты")
@Feature("Страница авторизации")
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
    @Story("Авторизация")
    @Description("Авторизоваться валидными данными")
    @DisplayName("Проверка авторизации валидными данными")
    @Severity(value = SeverityLevel.CRITICAL)
    @Owner(value = "Вадим")
    @Link(name = "Ссылка", url = "http://yandex.ru")
    @Tag("puper")
    @Test
    public void checkAutoValidData() {
        loginPage.setValueLogin(login);
        loginPage.setValuePassword(password);
        loginPage.clickInputButton();
        MainPage mainPage = new MainPage();
        mainPage.checkUserTag();
    }
    @Story("Авторизация")
    @Description("Авторизоваться невалидными данными")
    @DisplayName("Проверка авторизации невалидными данными")
    @Severity(value = SeverityLevel.CRITICAL)
    @Owner(value = "Вадим")
    @Link(name = "Ссылка", url = "http://yandex.ru")
    @Tag("super")
    @Test
    public void checkAutoNotValidData() {
        loginPage.setValueLogin(randomString);
        loginPage.setValuePassword(randomString);
        loginPage.clickInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkErrorMassage();
    }
    @Story("Авторизация")
    @Description("Авторизоваться невалидным паролем")
    @DisplayName("Неверный пароль")
    @Severity(value = SeverityLevel.CRITICAL)
    @Owner(value = "Вадим")
    @Link(name = "Ссылка", url = "http://yandex.ru")
    @Tag("super")
    @Test
    public void checkNotValidOneP(){
        loginPage.setValueLogin(login);
        loginPage.setValuePassword(randomString);
        loginPage.clickInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkErrorMassage();
    }
    @Story("Авторизация")
    @Description("Авторизоваться невалидным логином")
    @DisplayName("Неверный логин")
    @Severity(value = SeverityLevel.CRITICAL)
    @Owner(value = "Вадим")
    @Link(name = "Ссылка", url = "http://yandex.ru")
    @Tag("super")
    @Test
    public void checkNotValidLogin() {
        loginPage.setValueLogin(randomString);
        loginPage.setValuePassword(password);
        loginPage.clickInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkErrorMassage();
    }
    @TmsLink("rgd-25")
    @Issue("f135")
    @Flaky
    @Story("Авторизация")
    @Description("Авторизоваться с пробелом после логина")
    @DisplayName("Пробел после логина")
    @Severity(value = SeverityLevel.CRITICAL)
    @Owner(value = "Вадим")
    @Link(name = "Ссылка", url = "http://yandex.ru")
    @Tag("super")
    @Test
    public void spaceAfterLogin() {
        loginPage.setValueLogin(login + " ");
        loginPage.setValuePassword(password);
        loginPage.clickInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkErrorMassage();
    }
    @Story("Авторизация")
    @Description("Авторизоваться с пробелом после пароля")
    @DisplayName("Пробел после пароля")
    @Severity(value = SeverityLevel.CRITICAL)
    @Owner(value = "Вадим")
    @Link(name = "Ссылка", url = "http://yandex.ru")
    @Tag("super")
    @Test
    public void spaceAfterPassword() {
        loginPage.setValueLogin(login);
        loginPage.setValuePassword(password + " ");
        loginPage.clickInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkErrorMassage();
    }

    @Story("Авторизация")
    @Description("Авторизоваться с пробелом до логина")
    @DisplayName("Пробел до логина")
    @Severity(value = SeverityLevel.CRITICAL)
    @Owner(value = "Вадим")
    @Link(name = "Ссылка", url = "http://yandex.ru")
    @Tag("super")
    @Test
    public void spaceBeforeLogin() {
        loginPage.setValueLogin(" " + login);
        loginPage.setValuePassword(password);
        loginPage.clickInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkErrorMassage();
    }
    @Story("Авторизация")
    @Description("Авторизоваться с пробелом до пароля")
    @DisplayName("Пробел до пароля")
    @Severity(value = SeverityLevel.CRITICAL)
    @Owner(value = "Вадим")
    @Link(name = "Ссылка", url = "http://yandex.ru")
    @Tag("super")
    @Test
    public void spaceBeforePassword() {
        loginPage.setValueLogin(login);
        loginPage.setValuePassword(" " + password);
        loginPage.clickInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkErrorMassage();
    }
    @Story("Авторизация")
    @Description("Проверка на спец символы")
    @DisplayName("Спец символы")
    @Severity(value = SeverityLevel.CRITICAL)
    @Owner(value = "Вадим")
    @Link(name = "Ссылка", url = "http://yandex.ru")
    @Tag("super")
    @Test
    public void specChar(){
        loginPage.setValueLogin(specialCharacters);
        loginPage.setValuePassword(specialCharacters);
        loginPage.clickInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkErrorMassage();
    }
    @Story("Авторизация")
    @Description("Проверка на чувствительность логина к регистру")
    @DisplayName("Чувствительность логина к регистру")
    @Severity(value = SeverityLevel.CRITICAL)
    @Owner(value = "Вадим")
    @Link(name = "Ссылка", url = "http://yandex.ru")
    @Tag("puper")
    @Test
    public void registerLogin(){
        loginPage.setValueLogin(registerLogin);
        loginPage.setValuePassword(password);
        loginPage.clickInputButton();
        MainPage mainPage = new MainPage();
        mainPage.checkUserTag();
    }
    @Story("Авторизация")
    @Description("Проверка на чувствительность пароля к регистру")
    @DisplayName("Чувствительность пароля к регистру")
    @Severity(value = SeverityLevel.CRITICAL)
    @Owner(value = "Вадим")
    @Link(name = "Ссылка", url = "http://yandex.ru")
    @Tag("super")
    @Test
    public void registerPassword(){
        loginPage.setValueLogin(login);
        loginPage.setValuePassword(registerPassword);
        loginPage.clickInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkErrorMassage();
    }
    @Story("Авторизация")
    @Description("Ввод пустой формы")
    @DisplayName("Пустой ввод")
    @Severity(value = SeverityLevel.CRITICAL)
    @Owner(value = "Вадим")
    @Link(name = "Ссылка", url = "http://yandex.ru")
    @Tag("super")
    @Test
    public void emptyInput(){
        loginPage.clickInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkFindfMe();
    }
    @Story("Авторизация")
    @Description("Ввод с пустым паролем")
    @DisplayName("Пустой ввод-пароль")
    @Severity(value = SeverityLevel.CRITICAL)
    @Owner(value = "Вадим")
    @Link(name = "Ссылка", url = "http://yandex.ru")
    @Tag("super")
    @Test
    public void oneOfIsEmptyPassword(){
        loginPage.setValueLogin(login);
        loginPage.clickInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkFindfMe();
    }
    @Story("Авторизация")
    @Description("Ввод с пустым логином")
    @DisplayName("Пустой ввод-логин")
    @Severity(value = SeverityLevel.CRITICAL)
    @Owner(value = "Вадим")
    @Link(name = "Ссылка", url = "http://yandex.ru")
    @Tag("super")
    @Test
    public void oneOfIsEmptyLogin(){
        loginPage.setValuePassword(password);
        loginPage.clickInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkFindfMe();
    }
    @Story("Авторизация")
    @Description("Проверка на чувствительность логина к транслиту")
    @DisplayName("Чувствительность к транслиту-логин")
    @Severity(value = SeverityLevel.CRITICAL)
    @Owner(value = "Вадим")
    @Link(name = "Ссылка", url = "http://yandex.ru")
    @Tag("super")
    @Test
    public void translitLogin(){
        loginPage.setValueLogin(translitLogin);
        loginPage.setValuePassword(password);
        loginPage.clickInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkErrorMassage();
    }
    @Story("Авторизация")
    @Description("Проверка на чувствительность пароля к транслиту")
    @DisplayName("Чувствительность к транслиту-пароль")
    @Severity(value = SeverityLevel.CRITICAL)
    @Owner(value = "Вадим")
    @Link(name = "Ссылка", url = "http://yandex.ru")
    @Tag("super")
    @Test
    public void translitPassword(){
        loginPage.setValueLogin(login);
        loginPage.setValuePassword(translitPassword);
        loginPage.clickInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkErrorMassage();
    }
    @Story("Авторизация")
    @Description("Проверка защиты от SQL иньекции")
    @DisplayName("SQL иньекция логин")
    @Severity(value = SeverityLevel.CRITICAL)
    @Owner(value = "Вадим")
    @Link(name = "Ссылка", url = "http://yandex.ru")
    @Tag("super")
    @Test
    public void sqlInjection(){
        loginPage.setValueLogin(sqlInjection);
        loginPage.setValuePassword(password);
        loginPage.clickInputButton();
        UnsuccesLoginPage unsuccesLoginPage = new UnsuccesLoginPage();
        unsuccesLoginPage.checkErrorMassage();
    }
}










