package com.example.stream;

import static com.example.ds.DataSource.*;

import com.example.ds.DataSource;

import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StreamPractice {

    public static void main(String[] args) throws IOException {
//        basicSquares();
//        countEvenNumbers();
//        joinStrings();
//        groupEmployeesByDept();
//        top3HighestPaid();
//        partitionEvenOdd();
        wordFrequencyCounter();
//        processCSVTransactions();
//        customCollectorStats();
    }

    //  Basic
    private static void basicSquares() {
        numbers.stream().map(i->i*i).forEach(System.out::println);
    }
    private static void countEvenNumbers() {
        long count = numbers.stream().filter(i -> i % 2 == 0).count();
        System.out.println("Even number count: "+count);
    }
    private static void joinStrings() {
//        String join = String.join(", ", words);
        String collect = words.stream()
                .map(s -> s == null ? null : s.trim())
                .filter(s -> !s.isBlank())
                .collect(Collectors.joining(", "));
        System.out.println(collect);
    }

    //  Intermediate
    private static void groupEmployeesByDept() {
        TreeMap<String, List<Employee>> collect = employees.stream().collect(Collectors.groupingBy(
                Employee::getDepartment, TreeMap::new, Collectors.toList()
        ));
        collect.forEach((dept,employeeList)->{
            System.out.println(dept+": "+employeeList);
        });
    }
    private static void top3HighestPaid() {
        employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).limit(3).forEach(System.out::println);
    }
    private static void partitionEvenOdd() {
        Map<Boolean, List<Integer>> collect = numbers.stream().collect(Collectors.partitioningBy(i -> i % 2 == 0));
        System.out.println("Even: "+collect.get(true));
        System.out.println("False: "+collect.get(false));

    }

    //  Advanced
    private static void wordFrequencyCounter() {

        Pattern WORD_SPLIT = Pattern.compile("[^\\p{L}'’]+");
        Map<String, Long> freq = WORD_SPLIT
                .splitAsStream(largeText)
                .map(s -> s.trim().toLowerCase())
                .filter(s -> !s.isBlank())
                .collect(Collectors.groupingBy(Function.identity(), TreeMap::new,Collectors.counting()));
        freq.forEach((word,count)-> System.out.println(word+ ": "+count));

        String[] split = largeText.split("\\W+");
        Map<String, Long> collect = Arrays.stream(split)
                .map(s -> s == null ? null : s.trim().toLowerCase())
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
//        collect.forEach((word,count)-> System.out.println(word+": "+count));
    }
    private static void processCSVTransactions() { /* ... */ }
    private static void customCollectorStats() { /* ... */ }
}
