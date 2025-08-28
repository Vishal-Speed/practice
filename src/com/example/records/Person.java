package com.example.records;

public record Person(int id, String name, String address, String phone) {
    public Person(){
        this(1,"Vishal","123 Main St","1234567890");
    }

    public Person(int id){
        this(id,"Vishal","123 Main St","1234567890");
    }

    public Person(int id, String name){
        this(id,name,"123 Main St","1234567890");
    }

    public Person(int id, String name, String address){
        this(id,name,address,"1234567890");
    }

}
