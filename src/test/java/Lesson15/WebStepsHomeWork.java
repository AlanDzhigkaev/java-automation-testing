package Lesson15;

import com.codeborne.selenide.selector.ByText;
import io.qameta.allure.Step;

import java.io.File;
import java.time.Year;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class WebStepsHomeWork {
    @Step("Открываем страницу https://demoqa.com/automation-practice-form")
    public void openMainPage(){
        open("https://demoqa.com/automation-practice-form");
        getWebDriver().manage().window().maximize();
    }

    @Step("Заполняем поле Name значением {firstName}")
    public void setFirstName(String firstName){
        $("#firstName").setValue(firstName);
    }

    @Step("Заполняем поле Last Name значением {lastName}")
    public void setLastName (String lastName){
        $("#lastName").setValue(lastName);
    }

    @Step("Заполняем поле Email значением {Email}")
    public void setEmail(String Email){
        $("#userEmail").setValue(Email);
    }

    @Step("Выбираем гендер. Гендер = {gender}")
    public void setGender(String gender){
        $("#genterWrapper").$(byText(gender)).click();
    }

    @Step("Указываем номер телефона. Номер телефона = {phoneNumber}")
    public void setPhoneNumber(String phoneNumber){
        $("#userNumber").setValue(phoneNumber);
    }

    @Step("Выбираем дату рождения")
    public void setDateOfBirth(String Month, String year, String day){
        $(".react-datepicker__input-container").click();
        $(".react-datepicker__month-select").selectOption(Month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day.react-datepicker__day--"+day).click();
    }

    @Step("Выбираем Subject")
    public void setSubject(String subject){
        $("#subjectsInput").setValue(subject).pressEnter();
    }

    @Step("Выбираем хобби {hobbi}")
    public void setHobbies(String hobbi){
        $("#hobbiesWrapper").$(byText(hobbi)).click();
    }

    @Step("Загружаем файл")
    public void uploadFile(String fileRoute){
        $("#uploadPicture").uploadFile(new File(fileRoute));
    }

    @Step("Заполняем поле Current Address")
    public void setCurrentAddress(String curentAddress){
        $("#currentAddress").setValue(curentAddress);
    }

    @Step("Выбираем штат")
    public void setState(String state){
        $("#state").scrollTo().click();
        $(".css-26l3qy-menu").$(byText(state)).click();
    }

    @Step("Выбираем город")
    public void setCity(String city){
        $$(".col-md-4.col-sm-12").get(1).click();
        $(".css-26l3qy-menu").$(byText(city)).click();
    }

    @Step("Нажимаем на кнопку Submit")
    public void clickSumbit(){
        $("#submit").click();
    }
}
