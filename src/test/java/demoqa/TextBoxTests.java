package demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class TextBoxTests {

    @BeforeAll
    static void BrowserConfiguration() {
        System.out.println("Это @BeforeAll - выполняется!");
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080"; // добавьте это для полного окна
        Configuration.timeout = 10000;
    }

    @Test
    public void FillFormTest(){
        Configuration.pageLoadStrategy = "eager";
        open("https://demoqa.com/text-box");
        getWebDriver().manage().window().maximize();

        $x("//*[@id=\"userName\"]").setValue("Alan");
        $x("//*[@id=\"userEmail\"]").setValue("alan.dzhigkaevv@mail.ru");
        $x("//*[@id=\"currentAddress\"]").setValue("secret");
        $x("//*[@id=\"permanentAddress\"]").setValue("secret");
        $x("//*[@id=\"submit\"]").click();

        $("#output").shouldBe(visible).scrollTo();

        $x("//*[@id=\"name\"]").shouldHave(text("Alan"));
        $x("//*[@id=\"email\"]").shouldHave(text("alan.dzhigkaevv@mail.ru"));
        $$x("/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[6]/div/p")
                .findBy(text("Current Address"))
                .shouldHave(text("secret"));
        $$x("/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[6]/div/p")
                .findBy(text("Permananet Address"))
                .shouldHave(text("secret"));
    }
}
