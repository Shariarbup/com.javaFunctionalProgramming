package functionalInterface;

import java.util.List;
import java.util.function.Supplier;

public class _Supplier {
    public static void main(String[] args) {
        // Normal Java code
        System.out.println("Without Supplier");
        System.out.println(getDbConnectionUrl());

        //Declarative Java code
        System.out.println("With Supplier");
        System.out.println(getDbConnectionUrlSupplier.get());
        System.out.println(getDbConnectionUrlListBySupplier.get());
    }

    static String getDbConnectionUrl() {
        return "jdbc://localhost:3606/users";
    }

    static Supplier<String> getDbConnectionUrlSupplier = () ->
            "jdbc://localhost:3606/users";
    static Supplier<List<String>> getDbConnectionUrlListBySupplier = () ->
            List.of(
                    "jdbc://localhost:3606/users",
                    "jdbc://localhost:3606/customers"
                    );
}


