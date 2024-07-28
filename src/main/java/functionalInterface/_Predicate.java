package functionalInterface;

import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {
        // Normal Java code
        System.out.println("Without predicate");
        System.out.println(isValidPhoneNumber("01869663209"));
        System.out.println(isValidPhoneNumber("0196838515"));

        //Functional Java Code
        System.out.println("With predicate");
        System.out.println(isValidPhoneNumberPredicate.test("0186966323"));
        System.out.println("Is phone number valid and contains 3: " +
                isValidPhoneNumberPredicate.and(isPhoneNumberContains03Predicate).test("01869663203"));

        System.out.println("Is phone number valid or contains 3: " +
                isValidPhoneNumberPredicate.or(isPhoneNumberContains03Predicate).test("018663203"));
    }

    static Predicate<String> isValidPhoneNumberPredicate = phoneNumber->
            phoneNumber.startsWith("01") && phoneNumber.length() == 11;

    static Predicate<String> isPhoneNumberContains03Predicate = phoneNumber->
            phoneNumber.contains("3");

    static boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.startsWith("01") && phoneNumber.length() == 11;
    }
}
