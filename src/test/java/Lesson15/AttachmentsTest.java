package Lesson15;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.qameta.allure.Allure.attachment;
import static io.qameta.allure.Allure.step;

public class AttachmentsTest {

    private static final String Repository = "eroshenkoam/allure-example";

    @Test
    public void TestLambdaAttachments() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.pageLoadStrategy = "eager";

        step("Открываем главную страницу", () -> {
            open("https://github.com");
            getWebDriver().manage().window().maximize();
            attachment("Source",webdriver().driver().source());
        });
    }

    @Test
    public void testAnnotatedAttachments(){
        WebSteps steps = new WebSteps();
        Configuration.pageLoadStrategy = "eager";
        SelenideLogger.addListener("allure", new AllureSelenide());

        steps.openMainPage();
        steps.takeScreeshot();
    }
}
