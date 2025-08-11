package com.example.stream;

import com.example.method_ref.Employee;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collector;
import java.util.stream.Collectors;

record Cricketer(
        Long cricketerId,
        String name,
        String country,
        String role,
        List<String> teams
){
    public Cricketer{
        teams = List.copyOf(teams);
    }
}
public class StreamPractice2 {
    public static void main(String[] args) {
        List<String> stringList = List.of("rohit","virat","sachin","sehwag","yuvraj");

//        AtomicInteger idGenerator = new AtomicInteger(1);
//        stringList.stream().map(Employee::new).peek(e->e.setId(idGenerator.getAndIncrement())).forEach(System.out::println);



        List<Cricketer> cricketers = List.of(
                new Cricketer(1L, "Virat Kohli", "India", "Batsman", List.of("RCB", "Delhi")),
                new Cricketer(2L, "Steve Smith", "Australia", "Batsman", List.of("Rajasthan Royals")),
                new Cricketer(3L, "Jasprit Bumrah", "India", "Bowler", List.of("Mumbai Indians")),
                new Cricketer(4L, "Pat Cummins", "Australia", "Bowler", List.of("KKR", "Sunrisers Hyderabad")),
                new Cricketer(5L, "MS Dhoni", "India", "Wicket-Keeper", List.of("CSK", "Rising Pune Supergiant")),
                new Cricketer(6L, "AB de Villiers", "South Africa", "Batsman", List.of("RCB")),
                new Cricketer(7L, "David Warner", "Australia", "Batsman", List.of("Sunrisers Hyderabad", "Delhi Capitals"))
        );

//        cricketers.stream().filter(c->c.country().equals("India")).forEach(System.out::println);

//        cricketers.stream().sorted(Comparator.comparing(Cricketer::name)).forEach(System.out::println);

//        cricketers.stream().collect(Collectors.groupingBy(Cricketer::country)).forEach((country,players)->System.out.println(country+": "+players));

//        cricketers.stream().flatMap(c->c.teams().stream()).distinct().forEach(System.out::println);

//        cricketers.stream().collect(Collectors.groupingBy(Cricketer::role,Collectors.counting())).forEach((role,count)->System.out.println(role+": "+count));

//        cricketers.stream().max(Comparator.comparingInt(c->c.name().length())).ifPresent(System.out::println);

        /*boolean westIndies = cricketers.stream().anyMatch(c -> c.country().equals("West Indies"));
        if(westIndies)
            System.out.println("West Indies are playing");
        else
            System.out.println("West Indies are not playing");
*/
//        String string = cricketers.stream().map(Cricketer::name).collect(Collectors.joining(", "));
//        System.out.println(string);

//        More challenges
//        cricketers.stream().filter(c->c.teams().contains("RCB")).forEach(System.out::println);

//            cricketers.stream().collect(Collectors.groupingBy(Cricketer::country,Collectors.mapping(Cricketer::name,Collectors.collectingAndThen(Collectors.toList(),list->list.stream().sorted().toList()))))
//                    .forEach((country,sortedPlayers)->System.out.println(country+": "+sortedPlayers));

//            cricketers.stream().sorted(Comparator.comparing((Cricketer c)->c.name().length()).reversed()).limit(3).map(Cricketer::name).forEach(System.out::println);
//        Map<Boolean, List<Cricketer>> collect = cricketers.stream().collect(Collectors.partitioningBy(c -> c.teams().size() > 1));
//        collect.forEach((b,cricketers1)->System.out.println((b==true?"Played for more than 1 team":"Played for 1 team"+": ")+cricketers1));

//        double average = cricketers.stream().mapToInt(c -> c.teams().size()).average().orElse(0);
//        System.out.println("Average number of teams: "+average);

//        cricketers.stream().map(c->c.name().split(" ")[0]).forEach(System.out::println);





    }
}
