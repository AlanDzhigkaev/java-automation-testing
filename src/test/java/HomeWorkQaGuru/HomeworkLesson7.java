package HomeWorkQaGuru;

import com.codeborne.selenide.Configuration;
import org.junit.Test;
import org.openqa.selenium.Keys;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class HomeworkLesson7 {

    @Test
    public void lesson7() {
        Configuration.holdBrowserOpen = true;
        Configuration.pageLoadStrategy = "eager";
        open("https://demoqa.com/automation-practice-form");
        getWebDriver().manage().window().maximize();

        $x("//*[@id=\"firstName\"]").setValue("Alan");
        $x("//*[@id=\"lastName\"]").setValue("Dzhigkaev");
        $x("//*[@id=\"userEmail\"]").setValue("AlanDzhigkaev@mail.ru");
        $x("//*[@id=\"genterWrapper\"]/div[2]/div[1]/label").click();
        // Заполняем номер телефона
        $x("//*[@id=\"userNumber\"]").setValue("79999999999");
        // Выбираем дату рождения
        $x("//*[@id=\"dateOfBirthInput\"]").click();
        $x("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/select")
                .selectOption("April");
        $x("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/select")
                .selectOption("2001");
        $x("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[2]//*[text()='19']").click();
        // заполняем subjects
        $x("//*[@id=\"subjectsInput\"]").setValue("Maths").sendKeys(Keys.ENTER);
        $x("//*[@id=\"hobbiesWrapper\"]/div[2]/div[1]").click();
        $x("//*[@id=\"hobbiesWrapper\"]/div[2]/div[2]").click();
        $x("//*[@id=\"hobbiesWrapper\"]/div[2]/div[3]").click();
        $x("//*[@id=\"uploadPicture\"]").uploadFile(new File("C:/Users/alaniwe/Downloads/ChatGPT.png"));
        $x("//*[@id=\"currentAddress\"]").setValue("testComment");
        $x("//*[@id=\"state\"]/div[1]/div[1]/div[1]").scrollTo().click();
        $x("//*[@id=\"react-select-3-option-0\"]").click();
        $x("//*[@id=\"react-select-4-input\"]").setValue("Noida").sendKeys(Keys.ENTER);
        $x("//*[@id=\"submit\"]").click();

        // проверки на корректность данных
        $x("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[1]/td[2]").shouldHave(text("Alan Dzhigkaev"));
        $x("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[2]/td[2]").shouldHave(text("AlanDzhigkaev@mail.ru"));
        $x("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[3]/td[2]").shouldHave(text("Male"));
        $x("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[4]/td[2]").shouldHave(text("7999999999"));
        $x("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[5]/td[2]").shouldHave(text("19 April,2001"));
        $x("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[6]/td[2]").shouldHave(text("Maths"));
        $x("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[7]/td[2]").shouldHave(text("Sports, Reading, Music"));
        $x("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[8]/td[2]").shouldHave(text("ChatGPT.png"));
        $x("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[9]/td[2]").shouldHave(text("testComment"));
        $x("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[10]/td[2]").shouldHave(text("\tNCR Noida"));
    }
}
