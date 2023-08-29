package ru.netology.tours.Data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.util.Locale;
import java.util.Random;

public class UserData {
    @Value
    public static class CardInfo {
        private String cardNumber;
        private String month;
        private String year;
        private String owner;
        private String cvcCvv;
    }

    private static String validCardNumberApproved = "1111222233334444";
    private static String validCardNumberDecline = "5555666677778888";

    public static CardInfo getValidDataApproved() {
        return new CardInfo(validCardNumberApproved, generateValidMonth(), generateValidYear(), generateValidName(), generateValidCvcCvv());
    }

    public static CardInfo getValidDataDecline() {
        return new CardInfo(validCardNumberDecline, generateValidMonth(), generateValidYear(), generateValidName(), generateValidCvcCvv());
    }

    public static String getValidCardNumberApproved(){
        return validCardNumberApproved;
    }

    public static String getValidCardNumberDeclined(){
        return validCardNumberDecline;
    }

    public static String generateValidMonth(){
        Faker faker = new Faker();
        int tmp = faker.number().numberBetween(1, 12);
        String result;
        if(tmp < 10){
            result = ("0" + tmp);
        } else {
            result = Integer.toString(tmp);
        }
        return result;
    }

    public static String generateValidYear(){
        Faker faker = new Faker();
        return Integer.toString(faker.number().numberBetween(24, 28));
    }

    public static String generateValidName(){
        Faker faker = new Faker(new Locale("en"));
        return faker.name().firstName();
    }

    public static String generateValidCvcCvv(){
        Faker faker = new Faker();
        return faker.numerify("###");
    }

    public static String generateInvalidMonth(){
        Faker faker = new Faker();
        return Integer.toString(faker.number().numberBetween(13, 99));
    }

    public static String generateInvalidYear() {
        Faker faker = new Faker();
        return Integer.toString(faker.number().numberBetween(29, 99));
    }

    public static String generateInvalidName() {
        Faker faker = new Faker();
        return  faker.numerify("#####");
    }

    public static String generateInvalidCvcCvv(){
        Faker faker = new Faker();
        return faker.numerify("##");
    }

    public static String generateInvalidCardNumber() {
        Faker faker = new Faker();
        return faker.numerify("##########");
    }
}
