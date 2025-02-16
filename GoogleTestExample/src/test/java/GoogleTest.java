import org.junit.*;
import org.openqa.selenium.*;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class GoogleTest {
    @Test
    public void userCanSearchKeywordWithGoogle() {
        open("https://www.google.com/");
        $(By.name("q")).setValue("Selenide").pressEnter();
        $$("#ires li.g").shouldHave(size(10));
        $("#ires li.g").shouldHave(text("Selenide: concise UI Test on Java"));
        close();
    }
}
