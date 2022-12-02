package lichessTest;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
public class MainPage {
    private final SelenideElement userTag = $("#user_tag");
    @Step("Проверка видимости элемента UserTag")
    public void checkUserTag(){
        $("#user_tag").shouldBe(visible);
    }
}
