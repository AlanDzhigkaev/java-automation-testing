package Lesson14;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomUtilsData {
    public static String randomString(int len){
        String randomString = RandomStringUtils.randomAlphabetic(len);
        return randomString;
    }

    public static String randomPhoneNumber(int len){
        String randomPhoneNumber = RandomStringUtils.randomNumeric(len);
        return randomPhoneNumber;
    }
}
