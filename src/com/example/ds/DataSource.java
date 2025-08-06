package com.example.ds;

import java.util.*;
import java.util.stream.*;

public class DataSource {

    // 🟢 For basic exercises
    public static List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    public static List<String> words = Arrays.asList("apple", "banana", "cherry", "date");

    // 🟡 For employee exercises
    public static List<Employee> employees = Arrays.asList(
            new Employee("Alice", "IT", 70000),
            new Employee("Bob", "Finance", 80000),
            new Employee("Charlie", "IT", 90000),
            new Employee("David", "HR", 60000),
            new Employee("Eva", "Finance", 75000),
            new Employee("Frank", "IT", 85000),
            new Employee("Grace", "Finance", 95000),
            new Employee("Hank", "HR", 58000),
            new Employee("Ivy", "Marketing", 72000),
            new Employee("Jack", "IT", 98000),
            new Employee("Karen", "Marketing", 65000),
            new Employee("Leo", "Finance", 88000),
            new Employee("Mona", "IT", 76000),
            new Employee("Nina", "HR", 62000),
            new Employee("Oscar", "Marketing", 81000),
            new Employee("Paul", "Finance", 93000),
            new Employee("Quinn", "IT", 87000),
            new Employee("Rita", "HR", 70000),
            new Employee("Sam", "Marketing", 64000),
            new Employee("Tom", "IT", 92000),
            new Employee("Uma", "IT", 105000),
            new Employee("Victor", "Finance", 120000),
            new Employee("Wendy", "Marketing", 110000),
            new Employee("Xavier", "HR", 115000)
    );


    // 🔴 For word frequency counter
    public static String largeText = """
    Java is a high-level, class-based, object-oriented programming language
    that is designed to have as few implementation dependencies as possible.
    Java applications are typically compiled to bytecode that can run on any
    Java virtual machine regardless of the underlying computer architecture.

    The syntax of Java is similar to C and C++, but it has fewer low-level facilities.
    One of Java's key features is its platform independence, which means that
    compiled Java code can run on all platforms that support Java without the
    need for recompilation.

    Java includes a vast standard library, known as the Java API, which provides
    a range of functionality from basic data structures to networking and GUI development.
    It is widely used in enterprise applications, mobile applications via Android,
    and large-scale distributed systems.

    Over the years, Java has evolved to include features like lambda expressions,
    the Stream API, modular programming, and record types. It is maintained and
    updated regularly to keep pace with the needs of modern software development.
    """;


    // 🔴 For CSV transaction processing
    // Format: userId,amount
    public static List<String> csvTransactions = Arrays.asList(
            "U1,100.50",
            "U2,250.00",
            "U1,75.25",
            "U3,300.00",
            "U2,125.75"
    );

    // Employee POJO
    public static class Employee {
        String name;
        String department;
        double salary;

        public Employee(String name, String department, double salary) {
            this.name = name;
            this.department = department;
            this.salary = salary;
        }
        public String getName() { return name; }
        public String getDepartment() { return department; }
        public double getSalary() { return salary; }
        @Override
        public String toString() {
            return name + " (" + department + ") - $" + salary;
        }
    }
}

