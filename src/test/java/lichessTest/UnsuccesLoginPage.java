package lichessTest;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class UnsuccesLoginPage {
    private final SelenideElement errorMessage = $x("//p[@class='error']");

    public boolean checkErrorMassage() {
        return errorMessage.isDisplayed();
  }




}
