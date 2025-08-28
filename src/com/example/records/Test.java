package com.example.records;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Test {
    private int id;
    private  String name;

    public static void main(String[] args) {
        /*List<String> hobbies = new ArrayList<>();
        hobbies.add("Cricket");
        hobbies.add("Football");
        hobbies.add("Basketball");
        hobbies.add("Hockey");
        Student student = new Student(1, "Vishal", 22, "1234567890", hobbies);
        System.out.println(student);
        hobbies.remove(1);
        System.out.println(student);*/

        var person = new Person(1, "Vishal", "123 Main St", "1234567890");
//        System.out.println(person);

        Object obj1 = new Test();
        Object obj2 = new Test();
        System.out.println(obj1.equals(obj2));

        if(!(obj2 instanceof Test t)){

        }else {
            System.out.println(t);
        }

    }

    public Test() {
        id=0;
        name="";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if(!(obj instanceof Test t)) return false;
        return this.id == t.id && this.name.equals(t.name);
    }
}
