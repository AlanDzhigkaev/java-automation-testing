package Lesson15;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.qameta.allure.Allure.step;

public class StepsTest {

    private static final String Repository = "eroshenkoam/allure-example";

    @Test
    public void TestLambdaTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.pageLoadStrategy = "eager";

        step("Открываем главную страницу", () -> {
            open("https://github.com");
            getWebDriver().manage().window().maximize();
        });
        step("Ищем репозиторий " + Repository, () -> {
            $("span.flex-1").click();
            $("#query-builder-test").setValue(Repository).submit();
        });
        step("Кликаем по ссылке репозитория", () -> {
            $$("div.Box-sc-62in7e-0.lnrylK.search-title").get(0).click();
        });
        step("Открываем Pull Requests", () -> {
            $("span[data-content=\"Pull requests\"]").click();
        });
        step("Проверяем наличие текста внутри первого Pull Request", () -> {
            $$("span.opened-by").get(0).shouldHave(text("#91 opened on Oct 15, 2024Oct 15, 2024 by eroshenkoam"));
        });
    }

    @Test
    public void testAnnotatedStep(){
        WebSteps steps = new WebSteps();
        Configuration.pageLoadStrategy = "eager";
        SelenideLogger.addListener("allure", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false)
                .includeSelenideSteps(false) // ОТКЛЮЧАЕМ запись шагов Selenide
        );

        steps.openMainPage();
        steps.searchForRepository(Repository);
        steps.clickOnRepositoryLink();
        steps.openIssueTab();
        steps.shouldSeeIssueWithNumber(0,"#91 opened on Oct 15, 2024Oct 15, 2024 by eroshenkoam");
    }
}
