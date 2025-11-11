package Lesson12;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class HomeWorkTest {

    @ParameterizedTest(name = "тест для домашней работы №1. @ValueSource. Имя = {0}")
    @ValueSource(strings = {"Alan","Timur","Vadim"})
    void TestValueSource(String firstname){
        Configuration.holdBrowserOpen = true;
        Configuration.pageLoadStrategy = "eager";
        open("https://demoqa.com/automation-practice-form");
        getWebDriver().manage().window().maximize();

        $("#firstName").setValue(firstname);
        $("#lastName").setValue("Dzhigkaev");
    }

    @CsvSource({"Alan, Dzhigkaev, alan.dzhigkaevv@mail.ru",
            "Timur, Bikmambetov, timur.bikmambetov@gmail.com",
            "Vadim, Mamedov, vadim.mamedov@yandex.ru"})
    @ParameterizedTest(name = "тест для домашней работы №2. @CsvSource. Имя = {0}, фамилия = {1}, email = {2}")
    void TestCsvSource(String firstname, String lastname, String email){
        Configuration.holdBrowserOpen = true;
        Configuration.pageLoadStrategy = "eager";
        open("https://demoqa.com/automation-practice-form");
        getWebDriver().manage().window().maximize();

        $("#firstName").setValue(firstname);
        $("#lastName").setValue(lastname);
        $("#userEmail").setValue(email);
    }

    @CsvFileSource(resources = "/testData.csv")
    @ParameterizedTest(name = "тест для домашней работы №3. @CsvFileSource. Имя = {0}, фамилия = {1}, email = {2}")
    void TestCsvFile(String firstname, String lastname, String email){
        Configuration.holdBrowserOpen = true;
        Configuration.pageLoadStrategy = "eager";
        open("https://demoqa.com/automation-practice-form");
        getWebDriver().manage().window().maximize();

        $("#firstName").setValue(firstname);
        $("#lastName").setValue(lastname);
        $("#userEmail").setValue(email);
    }

    @MethodSource()
    @ParameterizedTest(name = "тест для домашней работы №4. @MethodSource. Имя = {0}, фамилия = {1}, mail = {2}")
    void TestMethodSource(String firstname, String lastname, String Email){
        Configuration.holdBrowserOpen = true;
        Configuration.pageLoadStrategy = "eager";
        open("https://demoqa.com/automation-practice-form");
        getWebDriver().manage().window().maximize();

        $("#firstName").setValue(firstname);
        $("#lastName").setValue(lastname);
        $("#userEmail").setValue(Email);
    }

    static Stream<Arguments> TestMethodSource(){
        return Stream.of(Arguments.of("Alan","Dzhigkaev","alan.dzhigkaevv@mail.ru"),
                Arguments.of("Timur","Mambetov","timur.Mambetov@gmail.com"),
                Arguments.of("Vadim","Pushkin","vadim.Pushkin@yandex.ru"));
    }
}