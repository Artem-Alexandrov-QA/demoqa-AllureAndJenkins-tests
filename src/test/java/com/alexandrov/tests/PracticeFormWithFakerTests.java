package com.alexandrov.tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import com.alexandrov.tests.page.RegistrationPage;
import utils.RandomUtils;

import java.io.File;


public class PracticeFormWithFakerTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    RandomUtils randomUtils = new RandomUtils();
    Faker faker = new Faker();
    int phoneNumberLength = 10;
    String firstName = faker.name().firstName()
            , lastName = faker.name().lastName()
            , userEmail = faker.internet().emailAddress()
            , mobileNumber = faker.phoneNumber().subscriberNumber(phoneNumberLength)
            , setCurrentAddress = faker.address().fullAddress()
            , gender = randomUtils.getRandomGender()
            , hobby = randomUtils.getRandomHobby()
            , year = "1993"
            , moth = "August"
            , dayOfMoth = "09"
            , file = "1.png"
            , fileLocation = "src/test/resources/img/"
            , state = "NCR"
            , city = "Delhi"
            , subjects = "History";

    @Test
    void testForm() {
        registrationPage.openPage();
        registrationPage.typeFirstName(firstName);
        registrationPage.typeLastName(lastName);
        registrationPage.userEmail(userEmail);
        registrationPage.setGender(gender);
        registrationPage.mobileNumber(mobileNumber);
        registrationPage.calendar.setDate("09", "August", "1993");
        registrationPage.subjects(subjects);
        registrationPage.setHobby(hobby);
        registrationPage.setPictureImg(new File(fileLocation + file));
        registrationPage.setCurrentAddress(setCurrentAddress);
        registrationPage.location.setLocation();
        registrationPage.pressButton();

        registrationPage.checkResultsTitle()
                .checkResultsValue("Student Name", firstName + " " + lastName)
                .checkResultsValue("Student Email", userEmail)
                .checkResultsValue("Gender", gender)
                .checkResultsValue("Mobile", mobileNumber)
                .checkResultsValue("Date of Birth", dayOfMoth + " "+ moth + "," +year )
                .checkResultsValue("Subjects", subjects)
                .checkResultsValue("Hobbies", hobby)
                .checkResultsValue("Picture", file)
                .checkResultsValue("Address", setCurrentAddress)
                .checkResultsValue("State and City", state + " " + city);
    }
}
