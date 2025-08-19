package com.example.generics;

public class Fish {
}
class Goldfish extends Fish implements AquariumFish{}
class Starfish extends Fish implements AquariumFish {}
class Shark extends Fish {}
interface AquariumFish {}