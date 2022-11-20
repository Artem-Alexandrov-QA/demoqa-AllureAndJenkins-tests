import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class PracticeFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    void testForm() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Artem");
        $("#lastName").setValue("Alexandrov");
        $("#userEmail").setValue("test@vtb.ru");
        $(byText("Male")).click();
        $("#userNumber").setValue("89998887766");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("August");
        $(".react-datepicker__year-select").selectOption("1993");
        $x("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div[2]").click();
        $("#subjectsInput").setValue("History").pressEnter();
        $(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("img/1.png");
        $("#currentAddress").setValue("Samara");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();
        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave
                (text("Artem Alexandrov")
                        , text("test@vtb.ru")
                        , text("Male")
                        , text("8999888776")
                        , text("09 August,1993")
                        , text("History")
                        , text("Sports")
                        , text("1.png")
                        , text("Samara")
                        , text("NCR Delhi"));
    }
}
