package lichessTest;

import com.codeborne.selenide.SelenideElement;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.$x;
import static org.awaitility.Awaitility.with;

public class UnsuccesLoginPage {
    public final SelenideElement errorMessage = $x("//p[@class='error']");
    //public  final SelenideElement errorMessagecss =$x("p.error");


    public boolean checkErrorMassage() {
        return errorMessage.isDisplayed();
  }









}
