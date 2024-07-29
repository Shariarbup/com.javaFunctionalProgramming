package streams;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

import static streams._Stream.Gender.*;


public class _Stream {
    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("Maria", FEMALE),
                new Person("Aisha", FEMALE),
                new Person("Shariar", MALE),
                new Person("Shuvo", MALE),
                new Person("Tonni", FEMALE),
                new Person("Shafali", FEMALE),
                new Person("Shafali", PREFER_NOT_TO_SAY)
        );

//        Set<Gender> genders = people.stream().map(p -> p.gender).collect(Collectors.toSet());
//        System.out.println(genders);

        System.out.println("All unique gender: ");

        people.stream().map(p -> p.gender).collect(Collectors.toSet())
                .forEach(System.out::println);

        System.out.println("All people name: ");

        people.stream().map(p -> p.name).collect(Collectors.toSet())
                .forEach(System.out::println);

        System.out.println("All people name length: ");

        people.stream().map(p -> p.name).mapToInt(String::length)
                .forEach(System.out::println);
        
        //Lets breaks the above length below way
        Function<Person, String> personStringFunction = p -> p.name;
        ToIntFunction<String> length = String::length;
        IntConsumer println = System.out::println;
        people.stream().map(personStringFunction).mapToInt(length)
                .forEach(println);

        
    }

    static class Person {
        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public Gender getGender() {
            return gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        MALE,
        FEMALE,
        PREFER_NOT_TO_SAY
    }
}
