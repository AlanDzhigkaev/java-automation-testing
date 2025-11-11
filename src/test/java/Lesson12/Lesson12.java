package Lesson12;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import net.bytebuddy.asm.Advice;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class Lesson12 {

    @DisplayName("Демонстрационный тест")
    @Test
    public void simpleTest(){
        Assertions.assertTrue(3>2);
    }

//    @CsvSource({"Allure testops, qameta.io", "Selenide, ru.selenide.org"})
    @CsvFileSource(resources = "/testData.csv")
    @ParameterizedTest(name = "Адрес {1} должен быть в выдаче яндекса по запросу {0}")
    @Tags({@Tag("Blocker"),@Tag("UI_TEST")})
//    @ValueSource(strings = {"Allure testops","qameta.io"})
    void productSiteUrlShouldBePresentInResultsOfSearchInGoggleByProductNameQuery(String productName, String productUrl){
        Configuration.holdBrowserOpen = true;
        open("https://ya.ru/");
        $x("//*[@id=\"text\"]").setValue(productName).pressEnter();
        $$x("//*[@id=\"search-result\"]/li/div/div/div/a/b").findBy(text(productUrl)).shouldBe(visible);
    }

    static Stream<Arguments> SelenideSiteSHowContainAllOfButtonsForGivenLocale() {
        return Stream.of (Arguments.of(Locale.EN,List.of("Quick start","Docs","FAQ","Blog","Javadoc","Users","Quotes")),
                Arguments.of(Locale.RU,List.of("С чего начать?","Док","ЧАВО","Блог","Javadoc","Пользователи","Отзывы"))
        );
    }

    @ParameterizedTest(name = "Для локали {0} отображаются кнопки {1}")
    @Tag("BLOCKER")
    @MethodSource("SelenideSiteSHowContainAllOfButtonsForGivenLocale")
    void SelenideSiteSHowContainAllOfButtonsForGivenLocale(Locale Locale,
                                                           List<String> buttons){
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        open("https://selenide.org/");
        $$("#languages a").findBy(text(Locale.name())).click();
        $$(".main-menu-pages a")
                .filter(visible)
                .shouldHave(CollectionCondition.texts(buttons));
    }
}
