package com.thoughtworks.devbootcamp.factory;

public class Reactor extends Machine {

    public Reactor(int count) {
        super(count);
    }

    @Override
    public void process(Chemical chemical) {
        if (chemical.shouldReact() && isAvailable()) {
            chemical.react();
            users++;
        }
    }
}
