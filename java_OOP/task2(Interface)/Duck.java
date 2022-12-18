package com.example.playground.OOP_interface;

public class Duck extends Animal implements Speakable,Runable,Flyable {

    public Duck(String nickname, int legs, String owner) {
        super(nickname, legs, owner);
    }

    @Override
    public int flySpeed() {
        return 40;
    }

    @Override
    public Integer runSpeed() {
        return 5;
    }

    @Override
    public String speak() {
        return "Krya";
    }

    @Override
    public String toString() {
        return "Duck" + super.toString();
    }
}
