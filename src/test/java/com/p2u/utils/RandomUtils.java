package com.p2u.utils;
import java.util.UUID;

public class RandomUtils {
    public static String generateRandomString(String prefix) {
        String randomID = UUID.randomUUID().toString().replace("-", "");
        return prefix != null ? prefix + "_" + randomID : randomID;
    }

    public static String generateRandomEmail() {
        return "tester_" + generateRandomString(null).substring(0, 5) + "@yopmail.com";
    }

    public static String generateRandomPhoneNumber() {
        return "+1" + (long) (Math.random() * 1_000_000_0000L);
    }
}
