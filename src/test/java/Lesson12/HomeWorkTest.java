package Lesson12;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class HomeWorkTest {

    @BeforeEach
    void setUp() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.headless = true; // Добавляем для CI
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        open("https://demoqa.com/automation-practice-form");
        getWebDriver().manage().window().maximize();
    }

    @ParameterizedTest(name = "тест для домашней работы №1. @ValueSource. Имя = {0}")
    @ValueSource(strings = {"Alan", "Timur", "Vadim"})
    void testValueSource(String firstname) {
        $("#firstName").setValue(firstname);
        $("#lastName").setValue("Dzhigkaev");
    }

    @ParameterizedTest(name = "тест для домашней работы №2. @CsvSource. Имя = {0}, фамилия = {1}, email = {2}")
    @CsvSource({
            "Alan, Dzhigkaev, alan.dzhigkaevv@mail.ru",
            "Timur, Bikmambetov, timur.bikmambetov@gmail.com",
            "Vadim, Mamedov, vadim.mamedov@yandex.ru"
    })
    void testCsvSource(String firstname, String lastname, String email) {
        $("#firstName").setValue(firstname);
        $("#lastName").setValue(lastname);
        $("#userEmail").setValue(email);
    }

    @ParameterizedTest(name = "тест для домашней работы №3. @CsvFileSource. Имя = {0}, фамилия = {1}, email = {2}")
    @CsvFileSource(resources = "/testData.csv")
    void testCsvFile(String firstname, String lastname, String email) {
        $("#firstName").setValue(firstname);
        $("#lastName").setValue(lastname);
        $("#userEmail").setValue(email);
    }

    @ParameterizedTest(name = "тест для домашней работы №4. @MethodSource. Имя = {0}, фамилия = {1}, mail = {2}")
    @MethodSource("testMethodSourceProvider")
    void testMethodSource(String firstname, String lastname, String email) {
        $("#firstName").setValue(firstname);
        $("#lastName").setValue(lastname);
        $("#userEmail").setValue(email);
    }

    static Stream<Arguments> testMethodSourceProvider() {
        return Stream.of(
                Arguments.of("Alan", "Dzhigkaev", "alan.dzhigkaevv@mail.ru"),
                Arguments.of("Timur", "Mambetov", "timur.Mambetov@gmail.com"),
                Arguments.of("Vadim", "Pushkin", "vadim.Pushkin@yandex.ru")
        );
    }
}