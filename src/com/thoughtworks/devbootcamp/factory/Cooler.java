package com.thoughtworks.devbootcamp.factory;

public class Cooler extends Machine {

    public Cooler(int count) {
        super(count);
    }

    @Override
    public void process(Chemical chemical) {
        if (chemical.shouldCool()) {
            chemical.cool();
            users++;
        }
    }

    @Override
    public boolean isAvailable() {
        return true;
    }
}
