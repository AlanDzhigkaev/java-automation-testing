package lesson10;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class refactor_7_lesson {
    @Test
    public void lesson7_refactor() {
        RegistrationPage RegistrationPage = new RegistrationPage();

        String userName = "Alan";
        String LastName = "Dzhigkaev";
        String Email = "AlanDzhigkaev@mail.ru";
        String gender = "Male";
        String NumberOfPhone = "7999999999";
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
}