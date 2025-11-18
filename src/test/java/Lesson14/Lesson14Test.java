package Lesson14;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.util.Locale;

import static Lesson14.RandomUtilsData.randomPhoneNumber;
import static Lesson14.RandomUtilsData.randomString;

public class Lesson14Test {
    // Урок по генерации тестовых данных

    @Test
    public void lesson7_refactorWithRandomUtilsData() {
        RegistrationPage RegistrationPage = new RegistrationPage();

        String userName = randomString(10); // генерация рандомного имени из 10 символов
        String LastName = randomString(10); // генерация рандомной фамилии из 10 символов
        String Email = userName+"."+LastName+"@mail.ru";
        String gender = "Male";
        String NumberOfPhone = "7"+randomPhoneNumber(9);
        String YearOfBirthday = "2001";
        String MonthOfBirthday = "April";
        String DayOfBithday = "19";
        String[] Subjects = {"Maths", "Chemistry"};
        String[] Hobbies = {"Sports", "Reading", "Music"};
        String CurrentAddress = "testComment";
        String FileRoute = "C:/Users/alaniwe/Downloads/ChatGPT.png";

        RegistrationPage.openPage()
                .setFirstName(userName)
                .setLastName(LastName)
                .setEmail(Email)
                .setGender(gender)
                .setNumberOfPhone(NumberOfPhone)
                .setBirthDate(YearOfBirthday, MonthOfBirthday, DayOfBithday)
                .setSubject(Subjects[0])
                .setSubject(Subjects[1])
                .setHobbies(Hobbies[0])
                .setHobbies(Hobbies[1])
                .setHobbies(Hobbies[2])
                .UploadFile(FileRoute)
                .setCurrentAddress(CurrentAddress)
                .ScrollToElementAndClick("#state")
                .ClickToElement("#react-select-3-option-0")
                .InputAndEnter("#react-select-4-input", "Noida")
                .ClickToElement("#submit");

        // проверки на корректность данных
        RegistrationPage.verifyResult("Student Name", userName + " " + LastName)
                .verifyResult("Student Email", Email)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", NumberOfPhone)
                .verifyResult("Date of Birth", DayOfBithday + " " + MonthOfBirthday + "," + YearOfBirthday)
                .verifyResult("Subjects", Subjects[0] + ", " + Subjects[1])
                .verifyResult("Hobbies", Hobbies[0] + ", " + Hobbies[1] + ", " + Hobbies[2])
                .verifyResult("Picture", "ChatGPT.png")
                .verifyResult("Address", CurrentAddress)
                .verifyResult("State and City", "NCR Noida");
    }

    @Test
    public void lesson7_refactorWithJavaFaker() {
        RegistrationPage RegistrationPage = new RegistrationPage();

        Faker faker = new Faker(new Locale("ru"));

        String userName = faker.name().firstName();
        String LastName = faker.name().lastName();
        String Email = faker.internet().emailAddress("mangustNosorog");
        String gender = "Male";
        String NumberOfPhone = ("7" + faker.phoneNumber().phoneNumber()
                .replaceAll("[^0-9]", "")).substring(0, 10);
        String YearOfBirthday = "2001";
        String MonthOfBirthday = "April";
        String DayOfBithday = "19";
        String[] Subjects = {"Maths", "Chemistry"};
        String[] Hobbies = {"Sports", "Reading", "Music"};
        String CurrentAddress = faker.address().streetAddress();
        String FileRoute = "C:/Users/alaniwe/Downloads/ChatGPT.png";

        RegistrationPage.openPage()
                .setFirstName(userName)
                .setLastName(LastName)
                .setEmail(Email)
                .setGender(gender)
                .setNumberOfPhone(NumberOfPhone)
                .setBirthDate(YearOfBirthday, MonthOfBirthday, DayOfBithday)
                .setSubject(Subjects[0])
                .setSubject(Subjects[1])
                .setHobbies(Hobbies[0])
                .setHobbies(Hobbies[1])
                .setHobbies(Hobbies[2])
                .UploadFile(FileRoute)
                .setCurrentAddress(CurrentAddress)
                .ScrollToElementAndClick("#state")
                .ClickToElement("#react-select-3-option-0")
                .InputAndEnter("#react-select-4-input", "Noida")
                .ClickToElement("#submit");

        // проверки на корректность данных
        RegistrationPage.verifyResult("Student Name", userName + " " + LastName)
                .verifyResult("Student Email", Email)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", NumberOfPhone)
                .verifyResult("Date of Birth", DayOfBithday + " " + MonthOfBirthday + "," + YearOfBirthday)
                .verifyResult("Subjects", Subjects[0] + ", " + Subjects[1])
                .verifyResult("Hobbies", Hobbies[0] + ", " + Hobbies[1] + ", " + Hobbies[2])
                .verifyResult("Picture", "ChatGPT.png")
                .verifyResult("Address", CurrentAddress)
                .verifyResult("State and City", "NCR Noida");
    }
}
