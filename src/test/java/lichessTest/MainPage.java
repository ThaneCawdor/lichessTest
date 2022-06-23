package lichessTest;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

    private final SelenideElement userTag = $x("//a[@id='user_tag']");


    public void checkClick(){
        userTag.click();

    }




}
