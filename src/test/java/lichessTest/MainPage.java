package lichessTest;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
public class MainPage {
    private final SelenideElement userTag = $("#user_tag");
    public void checkUserTag(){
        $("#user_tag").shouldBe(visible);
    }
}
