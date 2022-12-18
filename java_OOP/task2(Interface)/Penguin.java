package com.example.playground.OOP_interface;

public class Penguin extends Animal implements Runable, Speakable, Swimable {

    public Penguin(String nickname, int legs, String owner) {
        super(nickname, legs, owner);
    }

    @Override
    public String toString() {
        return "Penguin" + super.toString();
    }

    @Override
    public Integer runSpeed() {
        return 5;
    }

    @Override
    public String speak() {
        return "Quarck quarck";
    }

    @Override
    public float swimSpeed() {
        return 36.1f;
    }
}
