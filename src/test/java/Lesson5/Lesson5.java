package Lesson5;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class Lesson5 {

    @BeforeAll
    static void setupAll() {
        // Инициализация Allure listener для Selenide
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true)
        );
    }

    @BeforeEach
    void setUp() {
        // Настройки браузера
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        Configuration.browserSize = "1920x1080";
        // Configuration.holdBrowserOpen = true; // Уберите эту строку для автоматического закрытия браузера
    }

    @Test
    void dragAndDropTest() {
        Allure.step("Открываем страницу drag and drop", step -> {
            open("/drag_and_drop");
        });

        SelenideElement elementA = $("#column-a");
        SelenideElement elementB = $("#column-b");

        Allure.step("Проверяем начальное положение элементов", step -> {
            elementA.$("header").shouldHave(text("A"));
            elementB.$("header").shouldHave(text("B"));
        });

        Allure.step("Выполняем drag and drop", step -> {
            elementA.dragAndDrop(DragAndDropOptions.to(elementB));
        });

        Allure.step("Проверяем, что элементы поменялись местами", step -> {
            elementA.$("header").shouldHave(text("B"));
            elementB.$("header").shouldHave(text("A"));
        });
    }
}