package functionalInterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args) {
        Customer shariar = new Customer("Shariar", "01968385155");
        //Imperative code (normal java function)
        greetCustomer(shariar);
        greetCustomerV2(shariar, false);

        //Declarative code (consumer functional interface)
        greetCustomerConsumer.accept(shariar);
        greetCustomerConsumerV2.accept(shariar, false);
    }

    static BiConsumer<Customer, Boolean> greetCustomerConsumerV2 = (customer, showPhoneNumber) ->
            System.out.println(
                    "Hello "+ customer.getCustomerName() + ". Thank for registration, phone number " +
                            (showPhoneNumber ? customer.getCustomerPhoneNumber() : "#######")
            );

    static Consumer<Customer> greetCustomerConsumer = customer ->
            System.out.println(
                    "Hello "+ customer.getCustomerName() + ". Thank for registration, phone number " + customer.getCustomerPhoneNumber()
            );

    static void greetCustomer(Customer customer) {
        System.out.println(
                "Hello "+ customer.getCustomerName() + ". Thank for registration, phone number " + customer.getCustomerPhoneNumber()
        );
    }

    static void greetCustomerV2(Customer customer , Boolean showPhoneNumber) {
        System.out.println(
                "Hello "+ customer.getCustomerName() + ". Thank for registration, phone number " +
                        (showPhoneNumber ? customer.getCustomerPhoneNumber() : "#######")
        );
    }

    static class Customer {
        private final String customerName;
        private final String customerPhoneNumber;

        public Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }

        public String getCustomerName() {
            return customerName;
        }

        public String getCustomerPhoneNumber() {
            return customerPhoneNumber;
        }

        @Override
        public String toString() {
            return "Customer{" +
                    "customerName='" + customerName + '\'' +
                    ", customerPhoneNumber='" + customerPhoneNumber + '\'' +
                    '}';
        }
    }
}
