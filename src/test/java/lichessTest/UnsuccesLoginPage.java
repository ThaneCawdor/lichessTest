package lichessTest;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
public class UnsuccesLoginPage {
    private final SelenideElement errorMessage = $("p.error");
    private final SelenideElement findMe = $("#main-wrap > main > h1");
    public void checkErrorMassage() {
        $("p.error").shouldBe(visible);
  }
    public void checkFindfMe(){
        $("#main-wrap > main > h1").shouldBe(visible);
    }
}
