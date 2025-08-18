package com.example.flattening;


import java.util.ArrayList;
import java.util.List;

public class Person {
    String name;
    List<Integer> numbers;
    List<String> nickNames;

    public Person(String name, List<Integer> numbers) {
        this.name = name;
        this.numbers = numbers;
    }

    public Person(String name, List<Integer> numbers, List<String> nickNames) {
        this.name = name;
        this.numbers = numbers;
        this.nickNames = nickNames;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public List<String> getNickNames() {
        return nickNames;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", numbers=" + numbers +
                ", nickNames=" + nickNames +
                '}';
    }

    public static List<Person> buildPeople() {
        List<Person> people = new ArrayList<>();

        // create Person references with nicknames
        Person alice = new Person(
                "Alice",
                List.of(111111, 222222, 333333),
                List.of("Ally", "Lice")
        );

        Person bob = new Person(
                "Bob",
                List.of(987654),
                List.of("Bobby")
        );

        Person charlie = new Person(
                "Charlie",
                List.of(555555, 666666, 777777, 888888),
                List.of("Chuck", "Char")
        );

        Person david = new Person(
                "David",
                List.of(323232, 453423),
                List.of("Dave", "Davy")
        );

        Person john = new Person(
                "John",
                List.of(444444),
                List.of("Johnny")
        );

        // add to list
        people.add(alice);
        people.add(bob);
        people.add(charlie);
        people.add(david);
        people.add(john);

        return people;
    }

}
