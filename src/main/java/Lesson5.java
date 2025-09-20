import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import com.codeborne.selenide.SelenideElement;
import org.junit.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$x;

public class Lesson5 {

    @Test
    public void Lesson_5() {
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        Configuration.holdBrowserOpen = true;
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        open("/drag_and_drop");

        SelenideElement elementA = $("#column-a");
        SelenideElement elementB = $("#column-b");

        $x("//*[@id=\"column-a\"]/header").shouldHave(text("A"));
        $x("//*[@id=\"column-b\"]/header").shouldHave(text("B"));
        sleep(2000);
        elementA.dragAndDrop(DragAndDropOptions.to(elementB));
        $$x("/html/body/div[2]/div/div/div/div/header").get(0).shouldHave(text("B"));
        $$x("/html/body/div[2]/div/div/div/div/header").get(1).shouldHave(text("A"));
    }
}
