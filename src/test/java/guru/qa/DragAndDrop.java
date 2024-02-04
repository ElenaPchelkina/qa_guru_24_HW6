package guru.qa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDrop {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        //Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void actionsTest() {
        // открыть https://the-internet.herokuapp.com/drag_and_drop
        open("https://the-internet.herokuapp.com/drag_and_drop");
        // проверить, что первый прямоугольник A
        $("#column-a").shouldHave(text("A"));
        // перенести прямоугольник А на место В
        actions().clickAndHold($("#column-a")).moveToElement($("#column-b")).release().perform();
        // проверить, что прямоугольники действительно поменялись
        $("#column-a").shouldHave(text("B"));
    }

    @Test
    void dragAndDropTest() {
        // открыть https://the-internet.herokuapp.com/drag_and_drop
        open("https://the-internet.herokuapp.com/drag_and_drop");
        // проверить, что первый прямоугольник A
        $("#column-a").shouldHave(text("A"));
        // перенести прямоугольник А на место В
        $("#column-a").dragAndDrop(DragAndDropOptions.to($("#column-b")));
        // проверить, что прямоугольники действительно поменялись
        $("#column-a").shouldHave(text("B"));
    }
}
