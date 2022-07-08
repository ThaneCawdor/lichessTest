package lichessTest;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
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
    public void setValueLogin(String login){
        loginBox.setValue(login);
    }
    public void setValuePassword(String password){
        passwordBox.setValue(password);
    }
    public void clickInputButton(){
        inputButton.click();
    }
}
