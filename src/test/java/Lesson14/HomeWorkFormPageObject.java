package Lesson14;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class HomeWorkFormPageObject {

    private final SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderChoise = $("#genterWrapper"),
            phoneNumberinput = $("#userNumber"),
            monthOfBirth = $(".react-datepicker__month-select"),
            yearOfBirth = $(".react-datepicker__year-select"),
            subjects = $("#subjectsInput"),
            hobbies = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddressinput = $("#currentAddress"),
            stateChoise = $(".css-26l3qy-menu"),
            buttonSibmit = $("#submit"),
            tableOfResults = $(".table.table-dark.table-striped.table-bordered.table-hover");

    public HomeWorkFormPageObject OpenPage() {
        Configuration.holdBrowserOpen = true;
        Configuration.pageLoadStrategy = "eager";
        open("https://demoqa.com/automation-practice-form");
        getWebDriver().manage().window().maximize();
        return this;
    }

    public HomeWorkFormPageObject SetFirstName(String FirstName) {
        firstNameInput.setValue(FirstName);
        return this;
    }

    public HomeWorkFormPageObject SetLastName(String LastName) {
        lastNameInput.setValue(LastName);
        return this;
    }

    public HomeWorkFormPageObject SetEmail(String Email) {
        emailInput.setValue(Email);
        return this;
    }

    public HomeWorkFormPageObject SetGender(String Gender) {
        genderChoise.$(byText(Gender)).click();
        return this;
    }

    public HomeWorkFormPageObject SetPhoneNumber(String PhoneNumber) {
        phoneNumberinput.setValue(PhoneNumber);
        return this;
    }

    public HomeWorkFormPageObject SetDateOfBirth(String Month, String Year, String Day) {
        $(".react-datepicker-wrapper").click();
        monthOfBirth.selectOption(Month);
        yearOfBirth.selectOption(Year);
        $(".react-datepicker__day.react-datepicker__day--0" + Day).click();
        return this;
    }

    public HomeWorkFormPageObject SetSubjects(String Subject) {
        subjects.setValue(Subject).pressEnter();
        return this;
    }

    public HomeWorkFormPageObject SetHobbies(String Hobbi) {
        hobbies.$(byText(Hobbi)).click();
        return this;
    }

    public HomeWorkFormPageObject UploadFile(String fileRoute) {
        uploadPicture.uploadFile(new File(fileRoute));
        return this;
    }

    public HomeWorkFormPageObject SetCurrentAddress(String CurrentAddress) {
        currentAddressinput.setValue(CurrentAddress);
        return this;
    }

    public HomeWorkFormPageObject SetState(String State) {
        $$(".css-1wa3eu0-placeholder").get(0).scrollTo().click();
        stateChoise.$(byText(State)).click();
        return this;
    }

    public HomeWorkFormPageObject SetCity(String City) {
        $(".css-1wa3eu0-placeholder").click();
        $(".css-11unzgr").$(byText(City)).click();
        return this;
    }

    public HomeWorkFormPageObject SubmitClick() {
        buttonSibmit.click();
        return this;
    }

    public HomeWorkFormPageObject CompareResults(String text, String value) {
        tableOfResults.$(byText(text)).parent().shouldHave(text(value));
        return this;
    }
}