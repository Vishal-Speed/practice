package com.example.flattening;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class FlatMapMethodDemo {
    public static void main(String[] args) {
        List<String> stringList = getStringList();
//        Stream<String> stringStream = stringList.stream().flatMap(string -> Arrays.asList(string.split(" ")).stream());
        Stream<String> stringStream = stringList.stream().flatMap(string -> Stream.of(string.split(" ")));
        List<String> list = stringStream.toList();
//        System.out.println(list);

        Stream<String> stringStream1 = flatMap(stringList, string -> Arrays.asList(string.split(" ")).stream());
        Stream<String> stringStream2 = flatMap(stringList, string -> Stream.of(string.split(" ")));
        Stream<String> stringStream3 = flatMap(stringList, string -> Arrays.stream(string.split(" ")));

//        System.out.println(stringStream3.toList());

    }

    private static List<String> getStringList(){
        List<String> list = new ArrayList<>();
        list.add("hello world");
        list.add("java programming language");
        list.add("open ai chat gpt");
        list.add("stream api in java");
        list.add("functional interfaces and lambda expressions");
        list.add("object oriented programming concepts");
        list.add("collections framework in java");
        list.add("multithreading and concurrency");
        list.add("spring boot microservices");
        list.add("unit testing with junit");
        return list;
    }

    static <T,R> Stream<R> flatMap(List<T> list, Function<T,Stream<R>> function){
        Stream<R> result = Stream.empty();
        for(T element : list){
            Stream<R> apply = function.apply(element);
            result = Stream.concat(result,apply);
        }
        return result;
    }
}
