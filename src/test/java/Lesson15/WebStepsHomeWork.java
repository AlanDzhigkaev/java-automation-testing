package Lesson15;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class WebStepsHomeWork {
    @Step("Открываем страницу https://demoqa.com/automation-practice-form")
    public void openMainPage(){
        open("https://demoqa.com/automation-practice-form");
        getWebDriver().manage().window().maximize();
    }

    @Step("Заполняем поле Name начением {firstName}")
    public void setFirstName(String firstName){
        $("#firstName").setValue(firstName);
    }
}
