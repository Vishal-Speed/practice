package com.example.method_ref;

import java.io.PrintStream;
import java.util.Locale;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class Test {
    public static void main(String[] args) {
        IUpperCase converter = String::toUpperCase;
        String converted = converter.convertStringToUpperCase("hello world");
        System.out.println(converted);

        BiFunction<String,String,String> concatter = String::concat;
        String apply = concatter.apply("hello ", "world");
        System.out.println(apply);


        String str = "speed";
        Supplier<String> supplier = str::toUpperCase;
        String s = supplier.get();
        System.out.println(s);


        Function<String,String> func = String::toUpperCase;
        String apply1 = func.apply("abc");
        System.out.println(apply1);
/*
        When you use an instance method reference like ClassName::instanceMethod,
        the first parameter of your functional interface is treated as the
        instance (receiver) on which to call the method.*/


        IUpperCase2 demo = Test::toUC;

        BiConsumer<PrintStream,char[]> printer = PrintStream::println;
        printer.accept(System.out,"Hello world".toCharArray());
    }
    public String toUC(String s){
        return s.toUpperCase();
    }
}
