package com.darren.optimize.interview.java;

public class Person {
    volatile int age = 100;

    public void add() {
        this.age++;
    }

    public void delete() {
        this.age--;
    }

}
