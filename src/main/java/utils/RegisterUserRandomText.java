package utils;

import java.util.Random;

public class RegisterUserRandomText {
    private static String registerUserChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static int textLength = 62;
    private static final String FIRST_NAME= randomString().toUpperCase();
    private static final String LAST_NAME= randomString().toUpperCase();
    private static final String EMAIL_ID= randomString().toLowerCase()+"@gmail.com";
    private static final String PASSWORD = randomString();

    public static String randomString() {
        Random random = new Random();
        StringBuilder randomText = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(textLength);
            randomText.append(registerUserChars.charAt(index));
        }
        return randomText.toString();
    }

    public static final String getFirstName() {
        return  FIRST_NAME;
    }
    public static final String getLastName() {
        return  LAST_NAME;
    }
    public static final String getEmailID() {
        return  EMAIL_ID;
    }
    public static final String getPassword() {
        return PASSWORD;
    }

}
