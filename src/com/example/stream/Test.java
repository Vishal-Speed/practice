package com.example.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
        long reduce1 = LongStream.rangeClosed(0, 8).parallel().reduce(0, (a, b) -> a + b);
//        System.out.println(reduce1);
        parallelTask();
        System.out.println("JVM cached-----------------------");
        System.out.println("For Loop:");
        sumUsingForLoop();
        System.out.println("Using parallel stream:");
        parallelTask();
        System.out.println("Using sequential stream:");
        sequentialTask();

    }

    public static void parallelTask() {
        long start = System.currentTimeMillis();
        long sum = LongStream.rangeClosed(1, 9_000_000_000L).parallel().sum();
        System.out.println("Time taken: " + (System.currentTimeMillis() - start));
    }

    public static void sumUsingForLoop() {
        long start = System.currentTimeMillis();
        long sum = 0;
        for (long i = 1; i <= 9_000_000_000L; i++) {
            sum += i;
        }
        System.out.println("Time taken: " + (System.currentTimeMillis() - start));
    }

    public static void sequentialTask() {
        long start = System.currentTimeMillis();
        long sum = LongStream.rangeClosed(1, 9_000_000_000L).sum();
        System.out.println("Time taken: " + (System.currentTimeMillis() - start));
    }
}
