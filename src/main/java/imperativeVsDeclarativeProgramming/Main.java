package imperativeVsDeclarativeProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static imperativeVsDeclarativeProgramming.Main.Gender.FEMALE;
import static imperativeVsDeclarativeProgramming.Main.Gender.MALE;

public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Shariar", MALE),
                new Person("Maria", FEMALE),
                new Person("Aisha", FEMALE),
                new Person("Shuvo", MALE),
                new Person("Tonni", FEMALE),
                new Person("Shafali", FEMALE)
        );

        //Imperative programming
        System.out.println("Imperative programming: ");
        List<Person> females = new ArrayList<>();
        for (Person p : people) {
            if(p!=null && FEMALE.equals(p.getGender())) {
                females.add(p);
            }
        }

        for (Person f : females) {
            System.out.println(f);
        }

        //Declarative programming:

        System.out.println("Declarative programming: ");
        people.stream().filter(p-> FEMALE.equals(p.getGender())).toList()
                .forEach(System.out::println);

        List<Person> females2 = people.stream().filter(p-> FEMALE.equals(p.getGender())).toList();
        females2.forEach(System.out::println);
        
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
        FEMALE
    }
}
