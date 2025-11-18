package Lesson15;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.codeborne.selenide.selector.ByText;
import com.github.javafaker.Faker;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.qameta.allure.Allure.step;

public class Homework15Lesson {

    @Test
    @DisplayName("Тест из урока №7 с подключенным Allure Reports")
    public void testHomeWork15(){
        // Правильная настройка Allure Selenide listener
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true)
                .includeSelenideSteps(true)
        );

        Faker faker = new Faker();
        Configuration.holdBrowserOpen = true;
        Configuration.pageLoadStrategy = "eager";

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String emailAddress = faker.internet().emailAddress();
        String gender = "Female";
        String phoneNumber = ("7" + faker.phoneNumber().phoneNumber()
                .replaceAll("[^0-9]", "")).substring(0, 10);
        String[] dateOfBirth = {"April", "2001", "19"};
        String Subject = "Maths";
        String Hobbi = "Sports";
        String fileRoute = "C:/Users/alaniwe/Downloads/ChatGPT.png";
        String CurrentAddress = faker.address().streetAddress();
        String State = "NCR";
        String City = "Delhi";

        step("Открываем страницу https://demoqa.com/automation-practice-form", () -> {
            open("https://demoqa.com/automation-practice-form");
            getWebDriver().manage().window().maximize();
        });

        step("Заполняем поле First Name значением "+firstName, () -> {
            $("#firstName").setValue(firstName);
        });

        step("Заполняем поле last Name значением "+lastName, () -> {
            $("#lastName").setValue(lastName);
        });

        step("Заполняем поле Email значением "+emailAddress, () -> {
            $("#userEmail").setValue(emailAddress);
        });

        step("Выбираем Gender="+gender, () -> {
            $("#genterWrapper").$(byText(gender)).click();
        });

        step("Заполняем номер телефона="+phoneNumber, () -> {
            $("#userNumber").setValue(phoneNumber);
        });

        step("Заполняем дату рождения", () -> {
            $(".react-datepicker-wrapper").click();
            $(".react-datepicker__month-select").selectOption(dateOfBirth[0]);
            $(".react-datepicker__year-select").selectOption(dateOfBirth[1]);
            $(".react-datepicker__day.react-datepicker__day--0" + dateOfBirth[2]).click();
        });

        step("Заполняем Subjects", () -> {
            $("#subjectsInput").setValue(Subject).pressEnter();
        });

        step("Заполняем Hobbies", () -> {
            $("#hobbiesWrapper").$(byText(Hobbi)).click();
        });

        step("Загружаем файл", () -> {
            $("#uploadPicture").uploadFile(new File(fileRoute));
        });

        step("Заполняем поле Current Address= "+CurrentAddress, () -> {
            $("#currentAddress").setValue(CurrentAddress);
        });

        step("Выбираем штат= "+State, () -> {
            $$(".css-1wa3eu0-placeholder").get(0).scrollTo().click();
            $(".css-26l3qy-menu").$(byText(State)).click();
        });

        step("Выбираем город= "+City, () -> {
            $(".css-1wa3eu0-placeholder").click();
            $(".css-11unzgr").$(byText(City)).click();
        });

        step("Нажимаем на кнопку Submit", () -> {
            $("#submit").click();
        });

    }
}
