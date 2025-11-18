package Lesson15;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class WebSteps {
    @Step("Открываем гланую страницу")
    public void openMainPage(){
        open("https://github.com");
        getWebDriver().manage().window().maximize();
    }

    @Step("Ищем репозиторий {repo}")
    public void searchForRepository(String repo){
        $("span.flex-1").click();
        $("#query-builder-test").setValue(repo).submit();
    }

    @Step("Кликаем по ссылке репозитория")
    public void clickOnRepositoryLink(){
        $$("div.Box-sc-62in7e-0.lnrylK.search-title").get(0).click();
    }

    @Step("Открываем Pull Requests")
    public void openIssueTab(){
        $("span[data-content=\"Pull requests\"]").click();
    }

    @Step("Проверяем наличие текста {testtext} внутри первого Pull Request")
    public void shouldSeeIssueWithNumber(int issue, String testtext){
        $$("span.opened-by").get(issue).shouldHave(text(testtext));
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreeshot(){
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
