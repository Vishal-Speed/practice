package com.example.stream;

import static com.example.ds.DataSource.*;


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
//        wordFrequencyCounter();
//        processCSVTransactions();
//        customCollectorStats();


        // New practice methods (call any to test)
        // filterHighEarners();
//         averageSalaryByDept();
//         employeesBySalaryRange();
//         distinctDepartments();
//         sumOfSalaries();
//         medianSalary();
         findEmployeeByName("1");
        // flattenNestedLists();
        // mapToIdNameMap();
        // salaryHistogram();

//        Function<StreamPractice,Integer> publisher = Objects::hashCode;
//        System.out.println(publisher.apply(new StreamPractice()));
/*

        Consumer<String> printString = System.out::println;

        printString.accept("hello world");*/
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
    private static void processCSVTransactions() {

    }
    private static void customCollectorStats() {
    }


    /**
     * 1) Filter employees with salary > 80k and print them.
     * Fresher: use filter + forEach.
     * Pro: use primitive stream (mapToDouble) or avoid boxing if large list.
     */
    private static void filterHighEarners() {
        // TODO: implement - e.g.
        // employees.stream()
        //          .filter(e -> e.getSalary() > 80000)
        //          .forEach(System.out::println);
    }

    /**
     * 2) Average salary by department (Map<String, Double>)
     * Fresher: Collectors.averagingDouble(Employee::getSalary)
     * Pro: use Collectors.summarizingDouble to get count/sum/min/max together.
     */
    private static void averageSalaryByDept() {
        // TODO
        Map<String, Double> collect = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        collect.forEach((dept,average)-> System.out.println(dept+ ": "+average));
    }

    /**
     * 3) Group employees into salary ranges (e.g., 0-50k, 50k-75k, 75k-100k)
     * Fresher: implement using mapping + groupingBy with custom classifier.
     * Pro: make ranges configurable and use TreeMap to keep order.
     */
    private static void employeesBySalaryRange() {
        // TODO
        Map<String, List<Employee>> collect = employees.stream().collect(Collectors.groupingBy(e -> {
            double salary = e.getSalary();
            if (salary <= 50000)
                return "0-50k";
            else if (salary <= 75000)
                return "50k-75k";
            else if (salary <= 100000)
                return "75k-100k";
            return "100k+";
        }));
        collect.forEach((range,employees)-> System.out.println(range+": "+employees));
    }

    /**
     * 4) List distinct departments (sorted)
     * Fresher: map to department, distinct, sorted, collect to list.
     * Pro: use TreeSet or stream to a TreeSet to avoid separate sort step.
     */
    private static void distinctDepartments() {
        // TODO
        employees.stream().map(Employee::getDepartment).collect(Collectors.toCollection(TreeSet::new)).forEach(System.out::println);
    }

    /**
     * 5) Sum of all salaries (primitive-friendly)
     * Fresher: mapToDouble and sum()
     * Pro: use LongAdder if updating concurrently or process huge streams in parallel carefully.
     */
    private static void sumOfSalaries() {
        // TODO
        Function<Employee,Double> function = Employee::getSalary;
        double sum = employees.stream().map(Employee::getSalary).mapToDouble(Double::doubleValue).sum();
        System.out.println(sum);
    }

    /**
     * 6) Median salary (exercise in sorting or selection)
     * Fresher: sort, collect to list, pick middle
     * Pro: use selection algorithm or use a heap for O(n log k) for streaming median
     */
    private static void medianSalary() {
        // TODO
    }

    /**
     * 7) Find an employee by name (case-insensitive) and return Optional<Employee>
     * Fresher: filter + findFirst
     * Pro: consider name collisions and return all matches or map by name for O(1) lookups
     */
    private static void findEmployeeByName(String name) {
        // TODO
        Optional<Employee> optional = employees.stream().filter(employee -> employee.getName().equalsIgnoreCase(name)).findFirst();
        optional.ifPresentOrElse(System.out::println,()-> System.out.println("No match found"));
    }

    /**
     * 8) Flattening nested lists: if you had List<List<String>> tags for employees,
     *    flatten them and get distinct tags.
     * Fresher: flatMap + distinct()
     * Pro: keep insertion order with LinkedHashSet if required
     */
    private static void flattenNestedLists() {
        // TODO
    }

    /**
     * 9) Map from employee id -> name (handle duplicate ids)
     * Fresher: use Collectors.toMap with merge function for duplicates
     * Pro: define clear merge policy or use groupingBy for multiple values
     */
    private static void mapToIdNameMap() {
        // TODO

    }

    /**
     * 10) Salary histogram: bucket salaries into ranges and count per bucket (Map<String, Long>)
     * Fresher: groupingBy classifier that returns bucket label
     * Pro: use LongStream and TreeMap for sorted buckets; consider performance if many buckets
     */
    private static void salaryHistogram() {
        // TODO
    }
}
