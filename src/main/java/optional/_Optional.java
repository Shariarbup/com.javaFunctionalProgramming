package optional;

import java.util.Optional;
import java.util.function.Supplier;

public class _Optional {
    public static void main(String[] args) {
        // orElseGet with null value
        Object ofNullableOptional = Optional.ofNullable(null)
                .orElseGet(() -> "Get default value");
        System.out.println("ofNullableOptional:  " + ofNullableOptional);

        // orElseGet with a value
        Object ofNullableOptional2 = Optional.ofNullable("Hello")
                .orElseGet(() -> "Get default value");
        System.out.println("ofNullableOptional 2:  " + ofNullableOptional2);

        // orElseThrow
        Object orElseThrowOptional = Optional.ofNullable("Hello")
                .orElseThrow(() -> new IllegalStateException("exception"));
        System.out.println("orElseThrowOptional:  " + orElseThrowOptional);

        // orElseThrow another representation
        Supplier<IllegalStateException> exception = () -> new IllegalStateException("exception");
        Object orElseThrowOptional2 = Optional.ofNullable("jj")
                .orElseThrow(exception);
        System.out.println("orElseThrowOptional:  " + orElseThrowOptional2);

        //ifPresent
        Optional.ofNullable("Hello").ifPresent(
               value-> System.out.println(value)
        );

        //ifPresent another representation
        Optional.ofNullable("Hello").ifPresent(System.out::println);

        //ifPresentOrElse
        Optional.ofNullable(null).ifPresentOrElse(
                email -> System.out.println("Sending email to that email"+ email),
                () -> {
                    System.out.println("Cannot send email");
                }
        );
    }
}
