package com.example.generics;

import java.util.ArrayList;
import java.util.Iterator;

class Box <T>{
    private T value;
    Box(T value){
        this.value = value;
    }

    public void setValue(T value){
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
public class Test {
    public static void main(String[] args) {
        Aquarium<? extends Fish> aquarium = new Aquarium<>(new Starfish());
//        aquarium.printFish();
        Box<Integer> box = new Box<>(10);
        box.setValue(20);
        System.out.println(box.getValue().getClass().getName());
    }
}
