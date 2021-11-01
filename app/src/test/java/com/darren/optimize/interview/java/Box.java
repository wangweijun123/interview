package com.darren.optimize.interview.java;

public class Box<T> {

    T data;

    public Box(T data) {
        this.data = data;
    }

    public void set(T data) {
        this.data = data;
    }

    public T get() {
        return data;
    }
}
