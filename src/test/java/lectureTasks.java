
import Chrome.RunChrome;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class lectureTasks extends RunChrome {
    @Test
    public void lecTasks(){
        $(byAttribute("class","btn-register mb-2 mr-4")).click();
        $(byId("firstName")).setValue("gurami");
        $(byId("lastName")).setValue("ivanidze");
        $(byId("email")).setValue("ivanidze@gmail.com");
        $(byId("password")).setValue("password123");
        $(byId("confirmPassword")).setValue("password123");
        System.out.println($(byId("singup")).isEnabled());
        sleep(5000);
    }
    @Test
    public void negativeTest(){

        $(byAttribute("class","btn-register mb-2 mr-4")).click();
        $(byText("სწრაფი რეგისტრაცია")).shouldBe(Condition.visible);
        System.out.println($(byId("singup")).isEnabled());
        //$(byId("firstName")).setValue("gurami");
        //$(byId("firstName")).clear();
        $(byId("firstName")).click();
        $(byId("lastName")).click();
        $(byText("სახელი სავალდებულოა")).shouldBe(Condition.visible);
        sleep(500);
        $(byId("lastName")).click();
        $(byId("firstName")).click();
        $(byText("გვარი სავალდებულოა")).shouldBe(Condition.visible);

        $(byId("email")).click();
        $(byId("firstName")).click();
        $(byText("ელ. ფოსტა სავალდებულოა")).shouldBe(Condition.visible);

        $(byId("password")).click();
        $(byId("firstName")).click();
        $(byText("პაროლი სავალდებულოა.")).shouldBe(Condition.visible);

        $(byId("confirmPassword")).click();
        $(byId("firstName")).click();
        $(byText("პაროლის გამეორება სავალდებულოა")).shouldBe(Condition.visible);


        String[] listtext = {"test" , "test@" , "test@gmail" , "test@gmail"};

        for (String i :listtext){
            $(byId("email")).setValue(i);
            $(byId("firstName")).click();
            $(byId("email")).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
            $(byText("ელ. ფოსტა სავალდებულოა")).shouldBe(Condition.visible);
        }

        $(byId("password")).setValue("123");
        $(byId("firstName")).click();
        $(byText("პაროლი სავალდებულოა.")).shouldBe(Condition.visible);
        sleep(1000);

        $(byId("confirmPassword")).setValue("1232321312");
        $(byId("firstName")).click();
        sleep(1000);

        $(byId("confirmPassword")).setValue("asdasdasdas");
        $(byText("პაროლის გამეორება სავალდებულოა")).shouldBe(Condition.visible);
    }

    @Test
    public void methon3(){
        WebDriverManager.chromedriver().setup();
        Configuration.startMaximized = true;
        Selenide.open("https://ee.ge/");
        $(byAttribute("src", "/images/cart.png")).click();
        $(byText("კალათა ცარიელია")).shouldBe(Condition.visible);
        $("#search_list").setValue("iphone").sendKeys(Keys.ENTER);
        $(".add_to_cart",0).click();
        $(byAttribute("src", "/images/cart.png")).click();
        $(byText("კალათა ცარიელია")).shouldNotBe(Condition.visible);

        $(".fa-trash", 0).click();
        $(byText("კალათა ცარიელია")).shouldBe(Condition.visible);
        sleep(1000);
    }
}
