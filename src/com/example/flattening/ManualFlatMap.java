package com.example.flattening;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class ManualFlatMap {
    public static void main(String[] args) {
        List<Person> people = Person.buildPeople();
//        people.stream().flatMap(person -> person.getNumbers().stream()).forEach(System.out::println);

        Function<Person, List<Integer>> getNumbers = Person::getNumbers;
        List<List<Integer>> integerList = ManualMapMethod.map(people, getNumbers);
//        System.out.println(integerList);

        List<Integer> list = ManualMapMethod.flatMap(people, getNumbers);
        System.out.println(list);

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
