package HomeWorkQaGuru;

import com.codeborne.selenide.Configuration;
import org.junit.Test;
import java.io.File;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class HomeworkLesson7 {

    @Test
    public void lesson7() {
        Configuration.pageLoadStrategy = "eager";
        open("https://demoqa.com/automation-practice-form");
        getWebDriver().manage().window().maximize();

        $x("//*[@id=\"firstName\"]").setValue("Alan");
        $x("//*[@id=\"lastName\"]").setValue("Dzhigkaev");
        $x("//*[@id=\"userEmail\"]").setValue("AlanDzhigkaev@mail.ru");
        $x("//*[@id=\"genterWrapper\"]/div[2]/div[1]/label").click();
        $x("//*[@id=\"userNumber\"]").setValue("79999999999");
        $x("//*[@id=\"subjectsContainer\"]/div").$("input").setValue("sport");
        $x("//*[@id=\"hobbiesWrapper\"]/div[2]/div[1]").click();
        $x("//*[@id=\"hobbiesWrapper\"]/div[2]/div[2]").click();
        $x("//*[@id=\"hobbiesWrapper\"]/div[2]/div[3]").click();
        $x("//*[@id=\"uploadPicture\"]").uploadFile(new File("C:/Users/alaniwe/Downloads/ChatGPT.png"));
        $x("//*[@id=\"currentAddress\"]").setValue("testComment");
        $x("//*[@id=\"state\"]/div[1]/div[1]/div[1]").scrollTo().click();
        $x("//*[@id=\"react-select-3-option-0\"]").click();
        $x("//*[@id=\"react-select-4-input\"]").setValue("Noida");
        $x("//*[@id=\"submit\"]").click();

        sleep(5000);

    }
}
