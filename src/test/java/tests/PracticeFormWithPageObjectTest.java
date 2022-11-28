package tests;

import org.junit.jupiter.api.Test;
import pages.components.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static tests.TestData.*;

public class PracticeFormWithPageObjectTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void testForm() {
        registrationPage.openPage();
        registrationPage.typeFirstName(firstName);
        registrationPage.typeLastName(lastName);
        registrationPage.userEmail(userEmail);
        registrationPage.gender();
        registrationPage.(mobileNumber);
        registrationPage.calendar.setDate("09", "August", "1993");
        registrationPage.subjects(subjects);
        registrationPage.setHobbies();
        registrationPage.setPictureImg();
        registrationPage.setCurrentAddress(setCurrentAddress);
        registrationPage.location.setLocation();
        registrationPage.pressButton();

        registrationPage.checkResultsTitle();
        registrationPage.checkResultsValue("Student Name", firstName + " " + lastName);
        registrationPage.checkResultsValue("Student Email", userEmail);
        registrationPage.checkResultsValue("Address", setCurrentAddress);


//        $(".table-responsive").shouldHave
//                (text(firstName + " " + lastName)
//                        , text(userEmail)
//                        , text()
//                        , text(mobileNumber)
//                        , text("09 August,1993")
//                        , text("History")
//                        , text("Sports")
//                        , text("1.png")
//                        , text("Samara")
//                        , text("NCR Delhi"));


        sleep(5000);

    }
}
