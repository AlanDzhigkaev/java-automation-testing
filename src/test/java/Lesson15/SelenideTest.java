package Lesson15;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class SelenideTest {

    @Test
    public void testIssueSearch(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.pageLoadStrategy = "eager";
        open("https://github.com");
        getWebDriver().manage().window().maximize();

        $("span.flex-1").click();
        $("#query-builder-test").setValue("eroshenkoam/allure-example").submit();
        $$("div.Box-sc-62in7e-0.lnrylK.search-title").get(0).click();
        $("span[data-content=\"Pull requests\"]").click();
        $$("span.opened-by").get(0).shouldHave(text("#91 opened on Oct 15, 2024Oct 15, 2024 by eroshenkoam"));
    }
}
