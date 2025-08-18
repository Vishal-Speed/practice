package com.example.flattening;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

class Person {
    String name;
    List<Integer> numbers;

    public Person(String name, List<Integer> numbers) {
        this.name = name;
        this.numbers = numbers;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", numbers=" + numbers +
                '}';
    }

}
public class ManualFlatMap {
    public static void main(String[] args) {
        List<Person> people = buildPeople();
//        people.stream().flatMap(person -> person.getNumbers().stream()).forEach(System.out::println);

        Function<Person, List<Integer>> getNumbers = Person::getNumbers;
        List<List<Integer>> integerList = ManualMapMethod.map(people, getNumbers);
//        System.out.println(integerList);

        List<Integer> list = ManualMapMethod.flatMap(people, getNumbers);
        System.out.println(list);

    }


    private static List<Person> buildPeople() {
        List<Person> people = new ArrayList<>();

        // create Person references
        Person alice = new Person("Alice", List.of(111111, 222222, 333333));
        Person bob = new Person("Bob", List.of(987654));
        Person charlie = new Person("Charlie", List.of(555555, 666666, 777777, 888888));
        Person david = new Person("David", List.of(323232, 453423));
        Person john = new Person("John", List.of(444444));

        // now use add with references
        people.add(alice);
        people.add(bob);
        people.add(charlie);
        people.add(david);
        people.add(john);

        return people;
    }


    static <T,R> List<R> fMap(List<T> list,Function<T,List<R>> function){
        List<R> returnList = new ArrayList<>();
        for(T element : list){
            List<R> applied = function.apply(element);
            returnList.addAll(applied);
        }
        return returnList;
    }
}
