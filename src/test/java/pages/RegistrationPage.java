package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class RegistrationPage {
    private SelenideElement
            firstNameInput = $("#firstName"),
            LastNameInput = $("#lastName"),
            EmailInput = $("#userEmail"),
            GenderChoise = $("#genterWrapper"),
            NumberOfPhoneInput = $("#userNumber"),
            Subject = $("#subjectsInput"),
            Hobbi = $("#hobbiesWrapper"),
            UploadPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress");

    @Step("Открываем страницу https://demoqa.com/automation-practice-form")
    public RegistrationPage openPage() {
        Configuration.pageLoadStrategy = "eager";
        open("https://demoqa.com/automation-practice-form");
        getWebDriver().manage().window().maximize();
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        LastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value) {
        EmailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        GenderChoise.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setHobbies(String value) {
        Hobbi.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setNumberOfPhone(String value) {
        NumberOfPhoneInput.setValue(value);
        return this;
    }

    public RegistrationPage setBirthDate(String year, String month, String day) {
        $(".react-datepicker__input-container").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month .react-datepicker__day--0" + day).click();
        return this;
    }

    public RegistrationPage setSubject(String subject) {
        Subject.setValue(subject).sendKeys(Keys.ENTER);
        return this;
    }

    public RegistrationPage UploadFile(String fileRoute) {
        UploadPicture.uploadFile(new File(fileRoute));
        return this;
    }

    public RegistrationPage setCurrentAddress(String CurrentAddress) {
        currentAddress.setValue(CurrentAddress);
        return this;
    }

    public RegistrationPage ScrollToElementAndClick(String key) {
        $(key).scrollTo().click();
        return this;
    }

    public RegistrationPage ClickToElement(String key) {
        $(key).click();
        return this;
    }

    public RegistrationPage InputAndEnter(String key,String value) {
        $(key).setValue(value).sendKeys(Keys.ENTER);
        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        $(".table-dark").$(byText(key)).parent().shouldHave(text(value));
        return this;
    }
}
