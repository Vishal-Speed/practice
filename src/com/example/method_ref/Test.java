package com.example.method_ref;

public class Test {
    public static void main(String[] args) {
        IUpperCase converter = String::toUpperCase;
        String converted = converter.convertStringToUpperCase("hello world");
        System.out.println(converted);
    }
}
