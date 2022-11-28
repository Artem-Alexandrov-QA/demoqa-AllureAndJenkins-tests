package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {


    private final static String FORM_TITLE = "Student Registration Form";
    private final static String RESULTS_TITLE = "Thanks for submitting the form";
    private SelenideElement
            formTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderRadioButton = $(byText("Male")),
            mobileNumberInput = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            hobbiesCheckBox = $(byText("Sports")),
            pictureImg = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            submitButton = $("#submit"),

    titleFormDesc = $(".modal-title"),
            checkForm = $(".table-responsive");

    public CalendarComponent calendar = new CalendarComponent();
    public StateAndCity location = new StateAndCity();


    public void openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(FORM_TITLE));
    }

    public RegistrationPage typeFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage typeLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }


    public void checkResultsValue(String key, String value) {
        $x("//td[text()='" + key + "']").parent().shouldHave(text(value));
    }

    public RegistrationPage userEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage gender() {
        genderRadioButton.click();
        return this;

    }

    public RegistrationPage mobileNumber(String value) {
        mobileNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendar.setDate(day, month, year);
        return this;
    }

    public RegistrationPage subjects(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies() {
        hobbiesCheckBox.click();
        return this;
    }

    public RegistrationPage setPictureImg() {
        pictureImg.uploadFromClasspath("img/1.png");
        return this;

    }

    public RegistrationPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public void pressButton() {
        submitButton.click();
    }

    public RegistrationPage checkResultsTitle() {
        $("#example-modal-sizes-title-lg").shouldHave(text(RESULTS_TITLE));
        return this;
    }

    public void checkFullForm() {
        checkForm.shouldHave();
    }


    //   $(".table-responsive").shouldHave
//                (text("Artem Alexandrov")
//                        , text("test@vtb.ru")
//                        , text("Male")
//                        , text("8999888776")
//                        , text("09 August,1993")
//                        , text("History")
//                        , text("Sports")
//                        , text("1.png")
//                        , text("Samara")
//                        , text("NCR Delhi"));

}
