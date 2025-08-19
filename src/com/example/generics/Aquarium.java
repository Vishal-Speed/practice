package com.example.generics;


public class Aquarium<T extends Fish & AquariumFish> {
    private T fish;
    Aquarium(T fish){
        this.fish = fish;
    }

    T getFish(){
        return fish;
    }

    void setFish(T fish){
        this.fish = fish;
    }

    void printFish() {
        System.out.println(fish+" is in the aquarium");
    }
}
