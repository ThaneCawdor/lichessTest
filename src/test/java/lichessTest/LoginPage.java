package lichessTest;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
public class LoginPage {
    private final SelenideElement loginBox = $x("//input[@id='form3-username']");
    private final SelenideElement passwordBox = $x("//input[@id='form3-password']");
    private final SelenideElement inputButton = $x("//button[@class='submit button']");
    /**
     * Загрузка страницы авторизации сайта lichess.org
     *
     */
    public LoginPage(String url) {
        Selenide.open(url);
    }
    /**
     Ввод валидных данных, клик на кнопку вход
    */
    @Step("Заполнение поля логин")
    public void setValueLogin(String login){
        loginBox.setValue(login);
    }
    @Step("Заполнение поля пароль")
    public void setValuePassword(String password){
        passwordBox.setValue(password);
    }
    @Step("Нажатие кнопки вход")
    public void clickInputButton(){
        inputButton.click();
    }

}
