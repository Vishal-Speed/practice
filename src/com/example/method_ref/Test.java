package com.example.method_ref;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class Test {
    public static void main(String[] args) {
        IUpperCase converter = String::toUpperCase;
        String converted = converter.convertStringToUpperCase("hello world");
        System.out.println(converted);

        BiFunction<String, String, String> concatter = String::concat;
        String apply = concatter.apply("hello ", "world");
        System.out.println(apply);


        String str = "speed";
        Supplier<String> supplier = str::toUpperCase;
        String s = supplier.get();
        System.out.println(s);


        Function<String, String> func = String::toUpperCase;
        String apply1 = func.apply("abc");
        System.out.println(apply1);
/*
        When you use an instance method reference like ClassName::instanceMethod,
        the first parameter of your functional interface is treated as the
        instance (receiver) on which to call the method.*/


        Consumer<String> printer = System.out::println;
        printer.accept("print something");

        BiConsumer<PrintStream, String> publisher = PrintStream::println;
        publisher.accept(System.out, "hello world");
//        publisher.accept(new PrintStream(System.out),"hello world");

        BiFunction<List<String>, String, Boolean> listAdder = List::add;
        ArrayList<String> list = new ArrayList<>();
        listAdder.apply(list, "element 1");
        listAdder.apply(list, "element 2");
        listAdder.apply(list, "element 3");
        list.forEach(System.out::println);

        BiFunction<ArrayList<String>, String, Boolean> arrayListAdder = ArrayList::add;
        BiConsumer<ArrayList<String>, String> noNeedOfReturnValue = ArrayList::add;
        BiPredicate<ArrayList<String>, String> arrayListEBooleanBiFunction = ArrayList::add;
//        BIConsumer's accept method matched argument wise
//        since there is no need to match return type in method ref we can use BiConsumer here
        TriFunction<Test,Integer,Integer,Integer> adder = Test::add;
        System.out.println(adder.apply(new Test(),5,10));

        Function<Integer,Employee> id =  Employee::new;
        Employee e1 = id.apply(10);
        System.out.println(e1);

        BiFunction<Integer,String,Employee> idName = Employee::new;
        Employee vishal = idName.apply(20, "Vishal");
        System.out.println(vishal);

        TriFunction<Integer,String,String,Employee> idNameDepartment = Employee::new;
        Employee rohit = idNameDepartment.apply(30, "Rohit", "Sales");
        System.out.println(rohit);

    }

    int add(int a,int b){
        return a+b;
    }
}

interface TriFunction<A,B,C,R>{
    R apply(A a,B b,C c);
}
