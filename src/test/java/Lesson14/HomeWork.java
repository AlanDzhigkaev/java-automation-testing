package Lesson14;

import com.github.javafaker.Faker;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class HomeWork {

    @ParameterizedTest(name = "Домашка 14 урок. State {0}, city {1}")
    @CsvFileSource(resources = "/testDataLesson14Homework.csv")
    public void Lesson14Test(String state, String city) {
        HomeWorkFormPageObject HomeWorkFormPageObject = new HomeWorkFormPageObject();
        Faker faker = new Faker();

        String userName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String gender = "Male";
        String phoneNumber = ("7" + faker.phoneNumber().phoneNumber()
                .replaceAll("[^0-9]", "")).substring(0, 10);
        String[] dateOfBirth = {"April", "2001", "19"};
        String[] subject = {"Maths", "Arts"};
        String[] hobbies = {"Sports", "Music"};
        String path = "C:/Users/alaniwe/Downloads/ChatGPT.png";
        String CurrentAddress = faker.address().streetAddress();

        HomeWorkFormPageObject.OpenPage()
                .SetFirstName(userName)
                .SetLastName(lastName)
                .SetEmail(email)
                .SetGender(gender)
                .SetPhoneNumber(phoneNumber)
                .SetDateOfBirth(dateOfBirth[0], dateOfBirth[1], dateOfBirth[2])
                .SetSubjects(subject[0])
                .SetSubjects(subject[1])
                .SetHobbies(hobbies[0])
                .SetHobbies(hobbies[1])
                .UploadFile(path)
                .SetCurrentAddress(CurrentAddress)
                .SetState(state)
                .SetCity(city)
                .SubmitClick();

        HomeWorkFormPageObject.CompareResults("Student Name", userName + " " + lastName)
                .CompareResults("Student Email", email)
                .CompareResults("Gender", gender)
                .CompareResults("Mobile", phoneNumber)
                .CompareResults("Date of Birth",dateOfBirth[2]+" "+dateOfBirth[0]+","+dateOfBirth[1])
                .CompareResults("Subjects",subject[0]+", "+subject[1])
                .CompareResults("Hobbies",hobbies[0]+", "+hobbies[1])
                .CompareResults("Picture","ChatGPT.png")
                .CompareResults("Address",CurrentAddress)
                .CompareResults("State and City",state+" "+city);
    }
}
