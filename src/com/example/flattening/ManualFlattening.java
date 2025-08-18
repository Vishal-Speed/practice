package com.example.flattening;

import java.util.ArrayList;
import java.util.List;

public class ManualFlattening {
    public static void main(String[] args) {
        List<Integer> integerList1 = List.of(1, 2, 4, 4, 5);
        List<Integer> integerList2 = List.of(6, 7, 8, 9, 10);
        List<Integer> integerList3 = List.of(11,12,13,14,15);

        List<List<Integer>> list = new ArrayList<>();
        list.add(integerList1);
        list.add(integerList2);
        list.add(integerList3);
        System.out.println(list);
//        list.stream().flatMap(integers -> integers.stream()).forEach(System.out::println);
        List<Integer> integerList = flatMap(list);
        System.out.println(integerList);


        List<String> string1 = List.of("rishabh", "rohit", "virat");
        List<String> string2 = List.of("sehwag", "yuvraj", "dhawan");
        List<String> string3 = List.of("sachin", "dhoni", "kohli");
        List<List<String>> strings = List.of(string1,string2,string3);
        System.out.println(strings);
        List<String> stringList = flatMap(strings);
        System.out.println(stringList);

        List l1 = List.of("abc",123,false,1.2);
        List l2 = List.of("xyz",456,true,3.4);
        List l3 = List.of("pqr",789,true,5.6);
        List<List> lists = List.of(l1,l2,l3);
        System.out.println(lists);
        List l = flatMapRaw(lists);
        System.out.println(l);


    }

    static <T> List<T> flatMapRaw(List<List> list){
        List<T> result = new ArrayList<>();
        for (List<T> l : list) {
//            result.addAll(l);
            for(T element : l){
                result.add(element);
            }
        }
        return result;
    }

    static <T> List<T> flatMap(List<List<T>> list){
        List<T> result = new ArrayList<>();
        for (List<T> l : list) {
//            result.addAll(l);
            for(T element : l){
                result.add(element);
            }
        }
        return result;
    }
}
