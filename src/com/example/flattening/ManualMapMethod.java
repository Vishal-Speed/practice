package com.example.flattening;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class ManualMapMethod {
    public static void main(String[] args) {
        Function<String,Integer> toLength = String::length;
        List<String> list = List.of("bob", "david", "john", "william");
//        List<Integer> integerList = mapGenerics(list, toLength);


        Function<String,String[]> toLettersArray = s->s.split("");
        Function<String,List<String>> toLettersList = new Function<String, List<String>>() {
            @Override
            public List<String> apply(String s) {
                return Arrays.asList(s.split(""));
            }
        };


//
//        String[] abcs = toLettersArray.apply("abc");
//        System.out.println(abcs);
//
//        List<String> abcList = toLettersList.apply("abc");
//        System.out.println(abcList);



        List<String> strings = List.of("hello", "world", "java", "features", "lambda");
        List<List<String>> lists = map(list, toLettersList);
        System.out.println(lists);

        List<String> stringList = flatMap(list, toLettersList);
        System.out.println(stringList);
    }

    static<T,R> List<R> map(List<T> list, Function<T,R> function){
        List<R> returnList = new ArrayList<>();
        for(T  s : list){
            R applied = function.apply(s);
            returnList.add(applied);
        }
        return returnList;
    }

    static <T,R> List<R>flatMap(List<T> list,Function<T,List<R>> function){
        List<R> returnList = new ArrayList<>();
        for(T element : list){
            List<R> applied = function.apply(element);
            returnList.addAll(applied);
        }
        return returnList;
    }
}
