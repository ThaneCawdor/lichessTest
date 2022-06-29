package lichessTest;

import com.codeborne.selenide.SelenideElement;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static org.awaitility.Awaitility.with;

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
