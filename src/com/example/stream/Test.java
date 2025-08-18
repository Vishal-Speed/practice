package com.example.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.OptionalLong;
import java.util.stream.LongStream;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new ArrayList<>();
        // if we use non-thread-safe list there will be inconsistency in data
        list = Collections.synchronizedList(list);
//        so overcome this problem we use parallel stream
        /*for (int i = 1; i <= 5; i++) {
            list.clear();
            Stream.iterate(1, integer -> integer <= 20, integer -> integer + 1)
                    .parallel().
                    forEachOrdered(list::add);
            System.out.println(list);
            System.out.println("Size: "+list.size());
        }*/

//        sequentialTask2();
        parallelTask();
        long reduce1 = LongStream.rangeClosed(0, 8).parallel().reduce(0, (a, b) -> a + b);
        System.out.println(reduce1);
    }
    public static void parallelTask(){
        long start = System.currentTimeMillis();
        long sum = LongStream.rangeClosed(1, 1_000_000_000).parallel().sum();
        System.out.println("Time taken: "+(System.currentTimeMillis()-start));
    }
    public static void sequentialTask(){
        long start = System.currentTimeMillis();
        long sum = LongStream.rangeClosed(1, 1_000_000_000).sum();
        System.out.println("Time taken: "+(System.currentTimeMillis()-start));
    }
    public static void sequentialTask2(){
        long start = System.currentTimeMillis();
        long sum = LongStream.rangeClosed(1, 2_000_000_000).sum();
        System.out.println("Time taken: "+(System.currentTimeMillis()-start));
    }
}
