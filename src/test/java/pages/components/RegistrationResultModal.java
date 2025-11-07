package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class RegistrationResultModal {
    public void verifyResult(String key,String value){
        $(".table-dark").$(byText(key)).parent().shouldHave(text(value));
    }
}
