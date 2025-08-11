package com.example.stream;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Student {

    private final List<String> hobbies;

    public Student(List<String> hobbies) {
        this.hobbies = List.copyOf(hobbies);
    }

    public List<String> getHobbies() {
        return hobbies;
    }
}
public class IntStreamPractice {
    public static void main(String[] args) {

        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//        intStream.forEach(System.out::println);

        IntStream intStream = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//        integerStream.forEach(System.out::println);
//        intStream.min().ifPresent(System.out::println);
//        intStream.max().ifPresent(System.out::println);
//        System.out.println(intStream.sum());
//        System.out.println(intStream.average());

        OptionalInt min = IntStream.iterate(1, i -> i + 1).takeWhile(i -> i < 10).filter(i -> i > 10).min();
        if (min.isPresent()){
            System.out.println(min.getAsInt());
        }
        else {
            System.out.println("Not found");
        }


        Stream<Integer> integerStream1 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Optional<Integer> result = integerStream1.reduce(Integer::sum);
        if (result.isPresent()){
            System.out.println(result.get());
        }

        Integer sum = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).reduce(0, Integer::sum);
        System.out.println("Sum: "+sum);

        IntStream intStream1 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).mapToInt(Integer::intValue);
        /*int sum1 = intStream1.sum();
        System.out.println("Sum: "+sum1);*/


        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        IntStream stream = Arrays.stream(arr);

        Integer[] integerArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Stream<Integer> stream1 = Arrays.stream(integerArray);


//        ArrayList<String> hobbies = new ArrayList<>();
//        hobbies.add("watching sitcoms");
//        hobbies.add("playing cricket");
//
//        Student student = new Student(hobbies);
//        student.getHobbies().stream().map(String::toUpperCase).forEach(System.out::println);
//        student.getHobbies().add("aaa");




    }
}
