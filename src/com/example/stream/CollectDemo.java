package com.example.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectDemo {
    public static void main(String[] args) {
//        List<Integer> list =  new ArrayList<>();
//        List<Integer> list =  new CopyOnWriteArrayList<Integer>();
//        Stream.iterate(0,i->i+1).parallel().limit(20).forEach(list::add);
//        System.out.println(list);
//        System.out.println(list.size());

//        List<Integer> integerList = Stream.iterate(0, i -> i + 1).parallel().limit(20).collect(()->new ArrayList<>(),(list,element)->list.add(element),(list1,list2)->list1.addAll(list2));
        List<Integer> integerList = Stream.iterate(0, i -> i + 1).parallel().limit(20).collect(ArrayList::new,ArrayList::add,ArrayList::addAll);
        System.out.println(integerList);


    }

}
