import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.*;

public class homework5 {
    @Test
    public void test1(){
        WebDriverManager.chromedriver().setup();
        Configuration.startMaximized = true;
        Selenide.open("https://www.facebook.com/");
        $(byAttribute("ajaxify",  "/reg/spotlight/")).click();
        $(byAttribute("placeholder",  "First name")).setValue("გურამი");
        $(byAttribute("aria-label",  "Last name")).setValue("ivanidze");
        $(byAttribute("aria-label",  "Mobile number or email")).setValue("gurami@gmailc.com");
        $(byId("password_step_input")).setValue("paroli");
        $(byAttribute("aria-label","Re-enter email")).setValue("gurami@gmailc.com");

        $(byId("month")).selectOption("Oct");
        $(byId("day")).selectOption("15");
        $(byId("year")).selectOption("1996");
        $(byText("Custom")).click();
        $(byAttribute("aria-label","Select your pronoun")).isDisplayed();

        $(byAttribute("aria-label","Select your pronoun")).selectOption("He: \"Wish him a happy birthday!\"");

        $("._58mt", 0).click();
        $(byAttribute("aria-label","Select your pronoun")).shouldNotBe(Condition.visible);
        $("._58mt", 1).click();
        $(byAttribute("aria-label","Select your pronoun")).shouldNotBe(Condition.visible);
}
}
