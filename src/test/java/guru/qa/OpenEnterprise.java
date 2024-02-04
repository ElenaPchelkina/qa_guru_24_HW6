package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class OpenEnterprise {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
       // Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void openEnterprizeThroughHoverTest () {
        // открыть GitHub
        open("https://github.com");
        // навести на Solutions
        $$("ul.list-style-none li").findBy(text("Solutions")).hover();
        // кликнуть на Enterprise
        $(byText("Enterprise")).click();
        // проверить, что загрузилась нужная страница
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered"));
    }



}
