package lichessTest;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
public class UnsuccesLoginPage {
    private final SelenideElement errorMessage = $("p.error");
    private final SelenideElement findMe = $("#main-wrap > main > h1");
    @Step("Проверка видимости элемента-сообщение об ошибке")
    public void checkErrorMassage() {
        $("p.error").shouldBe(visible);
  }
    @Step("Проверка видимости элемента FindMe")
    public void checkFindfMe(){
        $("#main-wrap > main > h1").shouldBe(visible);
    }
}
