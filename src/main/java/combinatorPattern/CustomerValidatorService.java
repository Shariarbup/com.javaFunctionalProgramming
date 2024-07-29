package combinatorPattern;

import java.time.LocalDate;
import java.time.Period;

public class CustomerValidatorService {
    public boolean isEmailValid(String email) {
        return email.contains("@");
    }

    public boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.contains("+0");
    }

    public boolean isAdult(LocalDate dob) {
        return Period.between(dob, LocalDate.now()).getYears() > 16;
    }
}
