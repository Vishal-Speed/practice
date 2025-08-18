package com.example.comparator;

import java.util.Comparator;

public class GenericComparator<T> {
    Comparator<T> c = new Comparator<T>() {
        @Override
        public int compare(T o1, T o2) {
            return o1.toString().compareTo(o2.toString());
        }
    };
    public static void main(String[] args) {


    }
}
