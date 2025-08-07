package com.example.stream;

import com.example.method_ref.Employee;

import java.util.List;

public class StreamPractice2 {
    public static void main(String[] args) {
        List<String> stringList = List.of("rohit","virat","sachin","sehwag","yuvraj");
        stringList.stream()
                .map(Employee::new)
                .forEach(System.out::println);
    }
}
